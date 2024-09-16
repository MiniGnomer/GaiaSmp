package me.minignomer.gaiasmp.displayinfo;

import me.minignomer.gaiasmp.GaiaSmp;
import me.minignomer.gaiasmp.config.abilities.AbilityManager;
import me.minignomer.gaiasmp.config.abilities.enums.AbilityType;
import me.minignomer.gaiasmp.config.element.types.ElementType;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.UUID;

public class DisplayActionbar extends AbilityManager {

    private static HashMap<UUID, DisplayActionbar> actionBars = new HashMap<>();

    public static DisplayActionbar getActionBar(OfflinePlayer p) {
        return actionBars.get(p.getUniqueId());
    }
    public static DisplayActionbar getActionBar(UUID uuid) {
        return actionBars.get(uuid);
    }

    public static void addActionBar(Player p, DisplayActionbar displayActionbar) {
        actionBars.put(p.getUniqueId(), displayActionbar);
    }
    public static void removeActionBar(Player p) {
        actionBars.remove(p.getUniqueId());
    }

    public DisplayActionbar(Player p) {

        ElementType element = getElement(p);

        new BukkitRunnable() {
            @Override
            public void run() {
                if (!p.isOnline()) {
                    removeActionBar(p);
                    cancel();
                    return;
                }

                AbilityType ability = getAbility(p, currentAbility.get(p));

                String actionbarMsg = element.symbol + " " + element.name + " Stone";

                if (ability != AbilityType.EMPTY) {
                    actionbarMsg = actionbarMsg + " §0§l| " + ability.element.symbol + " " + ability.name + " §0§l| §d§l" + "Usable!";
                }

                if (isActive(p, ability)) {
                    p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(
                            element.symbol + " " + element.name + " Stone §0§l| " + ability.element.symbol + " " + ability.name + " §0§l| §a§l" + "Active!"
                    ));
                    return;
                }

                if (!hasCooldown(p, ability)) {
                    p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(actionbarMsg));
                    return;
                }

                long time = (getEndTime(p, ability) - System.currentTimeMillis()) / 1000;

                if (time <= 0) {
                    p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(actionbarMsg));
                    return;
                }

                p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(
                        element.symbol + " " + element.name + " Stone §0§l| " + ability.element.symbol + " " + ability.name + " §0§l| §d" + time + " seconds"
                ));
            }
        }.runTaskTimer(GaiaSmp.plugin, 10L, 10L);
    }
}
