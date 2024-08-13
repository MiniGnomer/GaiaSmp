package me.minignomer.gaiasmp.config.element;

import me.minignomer.gaiasmp.GaiaSmp;
import me.minignomer.gaiasmp.config.abilities.cooldowns.Cooldown;
import me.minignomer.gaiasmp.config.element.types.ElementType;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.Configuration;

import java.util.concurrent.ThreadLocalRandom;

public abstract class ElementManager extends Cooldown {

    public int elementMax = 4;

    public static ElementType getElement(OfflinePlayer p) {
        return ElementType.valueOf(getConfig().getString("ElementType." + p.getUniqueId()));
    }

    public void setElement(OfflinePlayer p, ElementType elementType) {
        setConfig("ElementType." + p.getUniqueId(), elementType.toString());
    }

    public ElementType randomizeElement() {
        int rand = ThreadLocalRandom.current().nextInt(0, elementMax);
        return ElementType.values()[rand];
    }

    public static boolean hasPlayedBefore(OfflinePlayer p) {
        return getConfig().contains("ElementType." + p.getUniqueId());
    }

    public static Configuration getConfig() {
        return getPlugin().getConfig();
    }

    public static GaiaSmp getPlugin() {
        return GaiaSmp.plugin;
    }

    public void setConfig(String path, Object value) {
        getConfig().set(path, value);
        updateConfig();
    }

    public void updateConfig() {
        getPlugin().saveConfig();
    }
}
