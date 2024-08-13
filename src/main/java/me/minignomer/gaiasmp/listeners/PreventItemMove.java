package me.minignomer.gaiasmp.listeners;

import me.minignomer.gaiasmp.items.GaiaStone;
import org.bukkit.block.Sign;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.entity.SheepDyeWoolEvent;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;

public class PreventItemMove extends GaiaStone implements Listener {


    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {
        e.getDrops().removeIf(this::isGaiaStone);
    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent e) {
        Player p = e.getPlayer();
        createGaiaStone(p);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {

        if (e.getClick().isKeyboardClick()) {

            if (e.getClick() == ClickType.SWAP_OFFHAND) {

                ItemStack offHandItem = e.getWhoClicked().getInventory().getItemInOffHand();

                if (isGaiaStone(offHandItem)) {
                    e.setCancelled(true);
                }
                return;
            }
        }

        ItemStack item = e.getCurrentItem();

        if (item != null && isGaiaStone(item)) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onInventoryDrag(InventoryDragEvent e) {

        ItemStack draggedItem = e.getOldCursor();

        if (!isGaiaStone(draggedItem))
            return;

        e.setCancelled(true);
    }

    @EventHandler
    public void onSheepDyeEvent(SheepDyeWoolEvent e) {
        if (isGaiaStone(e.getPlayer().getInventory().getItemInMainHand())
         || isGaiaStone(e.getPlayer().getInventory().getItemInOffHand())) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onSignDyeEvent(PlayerInteractEvent e) {
        if (e.getAction() != Action.RIGHT_CLICK_BLOCK) return;
        if (!(e.getClickedBlock().getState() instanceof Sign)) return;
        if (isGaiaStone(e.getPlayer().getInventory().getItemInMainHand())
         || isGaiaStone(e.getPlayer().getInventory().getItemInOffHand())) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onItemFrameClickEvent(PlayerInteractEntityEvent e) {
        if (e.getRightClicked().getType() != EntityType.ITEM_FRAME && e.getRightClicked().getType() != EntityType.GLOW_ITEM_FRAME) return;
        if (isGaiaStone(e.getPlayer().getInventory().getItemInMainHand())
         || isGaiaStone(e.getPlayer().getInventory().getItemInOffHand())) {
            e.setCancelled(true);
        }
    }

}
