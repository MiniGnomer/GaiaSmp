package me.minignomer.gaiasmp.listeners;

import me.minignomer.gaiasmp.config.abilities.AbilityManager;
import me.minignomer.gaiasmp.config.abilities.cooldowns.Cooldown;
import me.minignomer.gaiasmp.config.abilities.enums.AbilityType;
import me.minignomer.gaiasmp.config.element.types.ElementType;
import me.minignomer.gaiasmp.displayinfo.DisplayActionbar;
import me.minignomer.gaiasmp.items.GaiaStone;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.EquipmentSlot;

public class PlayerJoinListener extends GaiaStone implements Listener {

    private void firstJoin(Player p) {
        // Pick random element
        ElementType elementType = randomizeElement();

        // Add element to config
        setElement(p, elementType);

        // Set level to 1
        setLevel(p, 1);

        // Add empty ability slots, passive ability and element
        setDefaults(p);

        giveStone(p);

        DisplayActionbar displayActionbar = new DisplayActionbar(p);
        DisplayActionbar.addActionBar(p, displayActionbar);
    }

    private void giveStone(Player p) {
        p.getInventory().setItem(EquipmentSlot.OFF_HAND, createGaiaStone(p));
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();

        AbilityManager.currentAbility.put(p, 0);

        if (!hasPlayedBefore(p)) {
            firstJoin(p);
            return;
        }
        giveStone(p);

        DisplayActionbar displayActionbar = new DisplayActionbar(p);
        DisplayActionbar.addActionBar(p, displayActionbar);
        for (AbilityType abilityType : getAbilities(p)) {
            if (!Cooldown.hasIncompleteCooldown(p, abilityType)) {
                continue;
            }
            setCooldown(p, abilityType, getIncompleteCooldown(p, abilityType) + 2);
            removeIncompleteCooldown(p, abilityType);
        }
    }
}
