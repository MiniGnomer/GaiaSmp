package me.minignomer.gaiasmp.listeners;

import me.minignomer.gaiasmp.config.abilities.enums.AbilityType;
import me.minignomer.gaiasmp.items.GaiaStone;
import me.minignomer.gaiasmp.items.Scroll;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class PlayerDeathListener extends GaiaStone implements Listener {

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent e) {
        e.getPlayer().getInventory().setItemInOffHand(createGaiaStone(e.getPlayer()));
    }

    private void dropScroll(Player p) {

        if (getUltimate(p) != AbilityType.EMPTY) {
            p.getWorld().dropItem(p.getLocation(), Scroll.createScroll(getUltimate(p)));
            setUltimate(p, AbilityType.EMPTY);
            return;
        }

        List<AbilityType> trimmedAbilities = getTrimmedAbilities(p);

        if (trimmedAbilities.isEmpty()) {
            p.getWorld().dropItem(p.getLocation(), Scroll.createScroll(getPassive(p)));
            setPassive(p, AbilityType.EMPTY);
            return;
        }

        int rand = ThreadLocalRandom.current().nextInt(0, trimmedAbilities.size());
        setAbility(p, rand, AbilityType.EMPTY);
        p.getWorld().dropItem(p.getLocation(), Scroll.createScroll(trimmedAbilities.get(rand)));

        trimmedAbilities.remove(rand);

        for (int i = 0; i < trimmedAbilities.size(); i++) {
            setAbility(p, i, trimmedAbilities.get(i));
        }

        setAbility(p, trimmedAbilities.size(), AbilityType.EMPTY);
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {
        Player p = e.getEntity();
        e.getDrops().removeIf(this::isGaiaStone);
        dropScroll(p);

        int level = getLevel(p);
        if (level <= 1)
            return;
        setLevel(p, level - 1);
    }
}
