package me.minignomer.gaiasmp.commands.gaiastone;

import com.samjakob.spigui.SpiGUI;
import com.samjakob.spigui.buttons.SGButton;
import com.samjakob.spigui.menu.SGMenu;
import me.minignomer.gaiasmp.GaiaSmp;
import me.minignomer.gaiasmp.config.abilities.AbilityManager;
import me.minignomer.gaiasmp.config.abilities.enums.AbilityType;
import me.minignomer.gaiasmp.config.abilities.enums.RarityLevel;
import me.minignomer.gaiasmp.items.GaiaStone;
import me.minignomer.gaiasmp.items.Scroll;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;

public class GaiaStoneGui extends AbilityManager {

    final int gaiaStoneSlot = 25;

    final int slot1 = 10;

    final int slot2 = 11;

    final int slot3 = 19;

    final int slot4 = 20;

    final int passiveSlot = 16;

    final int ultimateSlot = 22;


    final int[] scrollSlots = { slot1, slot2, slot3, slot4, passiveSlot, ultimateSlot };


    private void scrollListener(Player p, SGMenu gui, InventoryClickEvent e) {
        if (p.getInventory().firstEmpty() == -1) {
            p.sendMessage("§c§lYour inventory is too full!");
            return;
        }

        ItemStack cursorItem = p.getItemOnCursor();
        ItemStack clickedItem = e.getCurrentItem();

        int clickedSlot = e.getSlot();

        if (e.getClick().isRightClick()) {
            if (clickedItem == null)
                return;
            switch (clickedSlot) {
                case slot1:
                case slot2:
                    setAbility(p, clickedSlot - 10, AbilityType.EMPTY);
                    break;
                case slot3:
                case slot4:
                    setAbility(p, clickedSlot - 17, AbilityType.EMPTY);
                    break;
                case passiveSlot:
                    setPassive(p, AbilityType.EMPTY);
                    break;
                case ultimateSlot:
                    setUltimate(p, AbilityType.EMPTY);
                    break;
            }
            p.getInventory().addItem(clickedItem);
            gui.setButton(clickedSlot, new SGButton(new ItemStack(Material.AIR)).withListener(event -> scrollListener(p, gui, event)));
            gui.setButton(gaiaStoneSlot, new SGButton(GaiaStone.createGaiaStone(p)));
            gui.refreshInventory(p);
            return;
        }


        if (cursorItem.getItemMeta() == null || !cursorItem.getItemMeta().hasCustomModelData())
            return;

        int customModelData = cursorItem.getItemMeta().getCustomModelData();

        AbilityType abilityType;

        try {
            abilityType = AbilityType.values()[customModelData];
        }
        catch (ArrayIndexOutOfBoundsException err) {
            p.sendMessage("§c§lYou can only attach scrolls to this slot!");
            return;
        }

        switch (clickedSlot) {
            case slot1:
            case slot2:
                if (abilityType.rarity == RarityLevel.PERK || abilityType.rarity == RarityLevel.ULTIMATE) {
                    p.sendMessage("§c§lThis scroll must go in the \"" + abilityType.rarity.name + "§c§l\" slot!");
                    return;
                }
                setAbility(p, clickedSlot - 10, abilityType);
                break;
            case slot3:
            case slot4:
                if (abilityType.rarity == RarityLevel.PERK || abilityType.rarity == RarityLevel.ULTIMATE) {
                    p.sendMessage("§c§lThis scroll must go in the \"" + abilityType.rarity.name + "§c§l\" slot!");
                    return;
                }
                setAbility(p, clickedSlot - 17, abilityType);
                break;
            case ultimateSlot: // Ultimate
                if (abilityType.rarity != RarityLevel.ULTIMATE) {
                    p.sendMessage("§c§lOnly ultimate abilities can go in this slot!");
                    return;
                }
                setUltimate(p, abilityType);
                break;
            case passiveSlot: // Perk
                if (abilityType.rarity != RarityLevel.PERK) {
                    p.sendMessage("§c§lOnly perks can go in this slot!");
                    return;
                }
                setPassive(p, abilityType);
                break;
        }

        if (clickedItem != null)
            p.getInventory().addItem(clickedItem);
        gui.setButton(clickedSlot, new SGButton(cursorItem).withListener(event -> scrollListener(p, gui, event)));
        p.setItemOnCursor(new ItemStack(Material.AIR));
        gui.setButton(gaiaStoneSlot, new SGButton(GaiaStone.createGaiaStone(p)));
        gui.refreshInventory(p);
        p.getInventory().setItemInOffHand(GaiaStone.createGaiaStone(p));
    }

    private void setGuiAbilities(Player p, SGMenu gui) {

        List<AbilityType> abilities = getAbilities(p);
        int availableSlots = getLevel(p);

        for (int i = 0; i < 5; i++) {

            if (i > availableSlots && i == 4) {
                gui.setButton(ultimateSlot, new SGButton(GuiItems.lockedSlotItem));
                continue;
            }
            else if (i > availableSlots) {
                gui.setButton(scrollSlots[i], new SGButton(GuiItems.lockedSlotItem));
                continue;
            }
            else if (i == 4) {
                ItemStack item = Scroll.createScroll(getUltimate(p));
                gui.setButton(ultimateSlot, new SGButton(item).withListener(event -> scrollListener(p, gui, event)));
                break;
            }

            ItemStack item = Scroll.createScroll(abilities.get(i));
            gui.setButton(scrollSlots[i], new SGButton(item).withListener(event -> scrollListener(p, gui, event)));
        }
        gui.setButton(passiveSlot, new SGButton(Scroll.createScroll(getPassive(p))).withListener(event -> scrollListener(p, gui, event)));
        gui.setButton(gaiaStoneSlot, new SGButton(GaiaStone.createGaiaStone(p)));
    }


    public GaiaStoneGui(Player p) {
        p.getInventory().setItemInOffHand(GaiaStone.createGaiaStone(p));
        SpiGUI spiGUI = GaiaSmp.spiGUI;
        SGMenu gui = spiGUI.create("§3§lGaia Stone Forger", 4);

        setGuiAbilities(p, gui);

        ItemStack defaultItem = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        ItemMeta defaultItemMeta = defaultItem.getItemMeta();
        defaultItemMeta.setDisplayName(" ");
        defaultItem.setItemMeta(defaultItemMeta);
        SGButton defaultButton = new SGButton(defaultItem);

        for (int slot = 0; slot < gui.getPageSize(); slot++) {
            if (gui.getInventory().getItem(slot) != null && !gui.getInventory().getItem(slot).getType().isAir())
                continue;

            int finalSlot = slot;
            if (Arrays.stream(scrollSlots).anyMatch(i -> i == finalSlot))
                continue;

            gui.setButton(slot, defaultButton);
        }

        p.openInventory(gui.getInventory());
    }

}
