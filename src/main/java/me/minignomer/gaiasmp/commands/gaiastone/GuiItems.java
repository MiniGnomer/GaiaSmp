package me.minignomer.gaiasmp.commands.gaiastone;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class GuiItems {

    public static ItemStack lockedSlotItem;

    public static void registerGuiItems() {
        createLockedSlotItem();
    }

    private static void createLockedSlotItem() {
        ItemStack item = new ItemStack(Material.BARRIER);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§4§mLOCKED");

        List<String> lore = new ArrayList<>();
        lore.add("§7Level up to unlock this slot!");

        meta.setLore(lore);
        item.setItemMeta(meta);

        lockedSlotItem = item;
    }


}
