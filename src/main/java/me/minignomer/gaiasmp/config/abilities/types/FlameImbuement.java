package me.minignomer.gaiasmp.config.abilities.types;

import me.minignomer.gaiasmp.config.abilities.AbilityManager;
import me.minignomer.gaiasmp.config.abilities.enums.AbilityType;
import me.minignomer.gaiasmp.config.element.interfaces.FireElement;
import org.bukkit.entity.Player;


public class FlameImbuement extends AbilityManager implements FireElement {

    public FlameImbuement(Player p) {
        setCooldown(p, AbilityType.FLAME_IMBUEMENT, 15, 30);
    }
}
