package me.minignomer.gaiasmp.items;

import me.minignomer.gaiasmp.config.abilities.enums.AbilityType;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Scroll {


    private static List<String> createLore(AbilityType abilityType) {
        List<String> lore = new ArrayList<>();
        lore.add(" ");
        switch (abilityType.element) {
            case FIRE:
                lore.add("§7 - Element: §c§l" + abilityType.element.name);
                break;
            case WATER:
                lore.add("§7 - Element: §9§l" + abilityType.element.name);
                break;
            case EARTH:
                lore.add("§7 - Element: §a§l" + abilityType.element.name);
                break;
            case WIND:
                lore.add("§7 - Element: §f§l" + abilityType.element.name);
                break;
        }
        lore.add("§7 - Rarity: §r" + abilityType.rarity.name);
        return lore;
    }

    public static ItemStack createScroll(AbilityType abilityType) {
        if (abilityType == AbilityType.EMPTY)
            return new ItemStack(Material.AIR);

        ItemStack item = new ItemStack(Material.CREEPER_BANNER_PATTERN);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(abilityType.element.symbol + " " + abilityType.name);

        meta.setLore(createLore(abilityType));

        meta.setCustomModelData(abilityType.abilityId);

        meta.addEnchant(Enchantment.LUCK_OF_THE_SEA, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ADDITIONAL_TOOLTIP);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        item.setItemMeta(meta);

        return item;
    }
}
