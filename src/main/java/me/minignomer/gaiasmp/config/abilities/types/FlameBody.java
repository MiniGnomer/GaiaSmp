package me.minignomer.gaiasmp.config.abilities.types;

import me.minignomer.gaiasmp.config.abilities.AbilityManager;
import me.minignomer.gaiasmp.config.abilities.enums.AbilityType;
import org.bukkit.entity.Player;

public class FlameBody extends AbilityManager {

    public FlameBody(Player p) {
        setCooldown(p, AbilityType.FLAME_BODY, 20);


    }
}
