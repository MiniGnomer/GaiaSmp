package me.minignomer.gaiasmp.items;

import me.minignomer.gaiasmp.config.abilities.AbilityManager;
import me.minignomer.gaiasmp.config.abilities.enums.AbilityType;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class GaiaStone extends AbilityManager {

    public static int fireStoneID = 301;

    public static int waterStoneID = 302;

    public static int earthStoneID = 303;

    public static int windStoneID = 304;


    public boolean isGaiaStone(ItemStack item) {
        if (item.getItemMeta() == null)
            return false;

        if (!item.getItemMeta().hasCustomModelData())
            return false;

        int customModelData = item.getItemMeta().getCustomModelData();

        return customModelData >= fireStoneID && customModelData <= windStoneID;
    }


    private static List<String> createAbilityLore(OfflinePlayer p) {
        List<String> lore = new ArrayList<>();

        if (getPassive(p) != AbilityType.EMPTY) {
            lore.add(" ");
            AbilityType ability = getPassive(p);
            lore.add("§5§n§lPerk:");
            lore.add(" ");
            lore.add(ability.element.symbol + " " + ability.name);
        }

        if (!getTrimmedAbilities(p).isEmpty()) {
            lore.add(" ");
            lore.add("§e§n§lAbilities:");

            for (AbilityType ability : getAbilities(p)) {
                if (ability == AbilityType.EMPTY)
                    continue;
                lore.add(" ");
                lore.add(ability.element.symbol + " " + ability.name);
                lore.add("§7 - Rarity: §r" + ability.rarity.name);
            }
        }

        if (getUltimate(p) != AbilityType.EMPTY) {
            lore.add(" ");
            AbilityType ability = getUltimate(p);
            lore.add("§6§n§lUltimate:");
            lore.add(" ");
            lore.add(ability.element.symbol + " " + ability.name);
        }



        return lore;
    }

    public static ItemStack createGaiaStone(OfflinePlayer p) {
        switch (getElement(p)) {
            case FIRE:
                return createFireStone(p);
            case WATER:
                return createWaterStone(p);
            case WIND:
                return createWindStone(p);
            case EARTH:
                return createEarthStone(p);
        }
        return null;
    }


    private static ItemStack createFireStone(OfflinePlayer p) {
        ItemStack item = new ItemStack(Material.RED_DYE);
        ItemMeta meta = item.getItemMeta();

        // Name:
        meta.setDisplayName("§c§lFire Gaia Stone");

        // Enchantments:
        meta.addEnchant(Enchantment.LURE, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        // Lore:
        meta.setLore(createAbilityLore(p));

        // Add item ID:
        meta.setCustomModelData(fireStoneID);

        // Finalize and return:
        item.setItemMeta(meta);
        return item;
    }

    private static ItemStack createWaterStone(OfflinePlayer p) {
        ItemStack item = new ItemStack(Material.BLUE_DYE);
        ItemMeta meta = item.getItemMeta();

        // Name:
        meta.setDisplayName("§9§lWater Gaia Stone");

        // Enchantments:
        meta.addEnchant(Enchantment.LURE, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        // Lore:
        meta.setLore(createAbilityLore(p));

        // Add item ID:
        meta.setCustomModelData(waterStoneID);

        // Finalize and return:
        item.setItemMeta(meta);
        return item;
    }

    private static ItemStack createEarthStone(OfflinePlayer p) {
        ItemStack item = new ItemStack(Material.LIME_DYE);
        ItemMeta meta = item.getItemMeta();

        // Name:
        meta.setDisplayName("§a§lEarth Gaia Stone");

        // Enchantments:
        meta.addEnchant(Enchantment.LURE, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        // Lore:
        meta.setLore(createAbilityLore(p));

        // Add item ID:
        meta.setCustomModelData(earthStoneID);

        // Finalize and return:
        item.setItemMeta(meta);
        return item;
    }

    private static ItemStack createWindStone(OfflinePlayer p) {
        ItemStack item = new ItemStack(Material.WHITE_DYE);
        ItemMeta meta = item.getItemMeta();

        // Name:
        meta.setDisplayName("§f§lWind Gaia Stone");

        // Enchantments:
        meta.addEnchant(Enchantment.LURE, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        // Lore:
        meta.setLore(createAbilityLore(p));

        // Add item ID:
        meta.setCustomModelData(windStoneID);

        // Finalize and return:
        item.setItemMeta(meta);
        return item;
    }
}
