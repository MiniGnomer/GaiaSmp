package me.minignomer.gaiasmp.config.abilities.cooldowns;

import me.minignomer.gaiasmp.GaiaSmp;
import me.minignomer.gaiasmp.config.abilities.enums.AbilityType;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.*;

public abstract class Cooldown {

    private static HashMap<AbstractMap.SimpleEntry<UUID, AbilityType>, Long> currentCooldowns = new HashMap<>();

    public long getEndTime(OfflinePlayer p, AbilityType abilityType) {
        return currentCooldowns.get(new AbstractMap.SimpleEntry<>(p.getUniqueId(), abilityType));
    }

    public long getEndTime(UUID uuid, AbilityType abilityType) {
        return currentCooldowns.get(new AbstractMap.SimpleEntry<>(uuid, abilityType));
    }

    public boolean hasCooldown(OfflinePlayer p, AbilityType abilityType) {
        return currentCooldowns.containsKey(new AbstractMap.SimpleEntry<>(p.getUniqueId(), abilityType));
    }

    public void addCooldownEndTime(UUID uuidKey, AbilityType abilityKey, long cooldownTime) {
        currentCooldowns.put(new AbstractMap.SimpleEntry<>(uuidKey, abilityKey), System.currentTimeMillis() + cooldownTime * 1000);
    }

    public void removeCooldown(UUID uuidKey, AbilityType abilityKey) {
        currentCooldowns.remove(new AbstractMap.SimpleEntry<>(uuidKey, abilityKey));
    }
    public void removeCooldown(OfflinePlayer p, AbilityType abilityKey) {
        currentCooldowns.remove(new AbstractMap.SimpleEntry<>(p.getUniqueId(), abilityKey));
    }

    public void setCooldown(Player p, AbilityType ability, long cooldownTime) {
        addCooldownEndTime(p.getUniqueId(), ability, cooldownTime);
        startRunnable(p, ability, cooldownTime);
    }

    public long getSecondsLeft(OfflinePlayer p, AbilityType abilityType) {
        return (getEndTime(p, abilityType) - System.currentTimeMillis()) / 1000;
    }

    public static boolean isOnCooldown(OfflinePlayer p, AbilityType abilityType) {
        return currentCooldowns.containsKey(new AbstractMap.SimpleEntry<>(p.getUniqueId(), abilityType));
    }

    private void startRunnable(OfflinePlayer p, AbilityType abilityType, long cooldownTime) {

        new BukkitRunnable() {
            int i = 0;
            @Override
            public void run() {
                if (!p.isOnline()) {
                    addIncompleteCooldown(p, abilityType);
                    removeCooldown(p, abilityType);
                    cancel();
                    return;
                }
                if (i >= cooldownTime - 1) {
                    removeCooldown(p.getUniqueId(), abilityType);
                    cancel();
                    return;
                }
                i++;
            }
        }.runTaskTimer(GaiaSmp.plugin, 0L, 20L);
    }

    private static HashMap<AbstractMap.SimpleEntry<UUID, AbilityType>, Long> incompleteCooldowns = new HashMap<>();

    public static boolean hasIncompleteCooldown(OfflinePlayer p, AbilityType abilityType) {
        return incompleteCooldowns.containsKey(new AbstractMap.SimpleEntry<>(p.getUniqueId(), abilityType));
    }
    public static long getIncompleteCooldown(OfflinePlayer p, AbilityType abilityType) {
        return incompleteCooldowns.get(new AbstractMap.SimpleEntry<>(p.getUniqueId(), abilityType));
    }
    public void addIncompleteCooldown(OfflinePlayer p, AbilityType abilityType) {
        incompleteCooldowns.put(new AbstractMap.SimpleEntry<>(p.getUniqueId(), abilityType),
                (getEndTime(p, abilityType) - System.currentTimeMillis()) / 1000);
    }
    public void addIncompleteCooldown(UUID uuid, AbilityType abilityType) {
        incompleteCooldowns.put(new AbstractMap.SimpleEntry<>(uuid, abilityType),
                (getEndTime(uuid, abilityType) - System.currentTimeMillis()) / 1000);
    }
    public void removeIncompleteCooldown(OfflinePlayer p, AbilityType abilityType) {
        incompleteCooldowns.remove(new AbstractMap.SimpleEntry<>(p.getUniqueId(), abilityType));
    }
}
