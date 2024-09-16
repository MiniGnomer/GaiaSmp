package me.minignomer.gaiasmp.listeners;

import me.minignomer.gaiasmp.config.abilities.AbilityManager;
import me.minignomer.gaiasmp.config.abilities.cooldowns.Cooldown;
import me.minignomer.gaiasmp.config.abilities.enums.AbilityType;
import me.minignomer.gaiasmp.config.abilities.types.FlameImbuement;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;

public class ActivateAbility extends AbilityManager implements Listener {

    private void activateAbility(Player p, AbilityType abilityType) {
        if (Cooldown.isOnCooldown(p, abilityType)) {
            p.sendMessage("§cThis ability is on cooldown!");
            return;
        }

        switch (abilityType) {
            case EMPTY:
                p.sendMessage("§c§lYou have no abilities to use!");
                return;
            case FLAME_IMBUEMENT:
                new FlameImbuement(p);
                break;
        }
        p.sendMessage("§aYou used your §r§2§l" + abilityType.name + "§r§a ability!");
    }

    private void switchAbility(Player p) {
        AbilityType nextAbility = getAbility(p, currentAbility.get(p) + 1);

        if (nextAbility == null) {
            currentAbility.put(p, 0);
        }

        else if (nextAbility == AbilityType.EMPTY) {
            if (getAbility(p, 0) == AbilityType.EMPTY) {
                p.sendMessage("§c§lYou have no abilities to switch to!");
                return;
            }
            currentAbility.put(p, 0);
        }

        else {
            currentAbility.put(p, currentAbility.get(p) + 1);
        }
        p.sendMessage("§dSwitched ability to §r§5§l" + getAbility(p, currentAbility.get(p)).name + "§r§d!");
    }

    @EventHandler
    public void onPlayerOffhand(PlayerSwapHandItemsEvent e) {
        Player p = e.getPlayer();

        e.setCancelled(true);

        if (p.isSneaking()) {
            switchAbility(p);
            return;
        }


        activateAbility(p, getAbility(p, currentAbility.get(p)));
    }
}
