package me.minignomer.gaiasmp.config.level;

import me.minignomer.gaiasmp.config.element.ElementManager;
import org.bukkit.OfflinePlayer;

public abstract class LevelManager extends ElementManager {

    public int getLevel(OfflinePlayer p) {
        return getConfig().getInt("Level." + p.getUniqueId());
    }

    public void setLevel(OfflinePlayer p, int level) {
        setConfig("Level." + p.getUniqueId(), level);
    }
}
