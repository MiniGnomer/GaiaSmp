package me.minignomer.gaiasmp.config.abilities;

import me.minignomer.gaiasmp.config.abilities.enums.AbilityType;
import me.minignomer.gaiasmp.config.level.LevelManager;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public abstract class AbilityManager extends LevelManager {

    public static HashMap<Player, Integer> currentAbility = new HashMap<>();

    public void setDefaults(OfflinePlayer p) {
        int rand = ThreadLocalRandom.current().nextInt(1, AbilityType.SWIFTY_SPRINT.abilityId + 1);
        AbilityType passive = getAbility(rand);
        setPassive(p, passive);
        setElement(p, passive.element);

        List<Integer> abilities = new ArrayList<>();

        // Add 4 empty abilities
        for (int i = 1; i <= 4; i++) {
            abilities.add(AbilityType.EMPTY.abilityId);
        }

        setUltimate(p, AbilityType.EMPTY);

        // Adds them to the config
        setConfig("Abilities." + p.getUniqueId(), abilities);
    }

    public AbilityType getPassive(OfflinePlayer p) {
        return getAbility(getConfig().getInt("Passive." + p.getUniqueId()));
    }

    public void setPassive(OfflinePlayer p, AbilityType abilityType) {
        setConfig("Passive." + p.getUniqueId(), abilityType.abilityId);
    }

    public AbilityType getUltimate(OfflinePlayer p) {
        return getAbility(getConfig().getInt("Ultimate." + p.getUniqueId()));
    }

    public void setUltimate(OfflinePlayer p, AbilityType abilityType) {
        setConfig("Ultimate." + p.getUniqueId(), abilityType.abilityId);
    }

    public static List<Integer> getAbilitiesId(OfflinePlayer p) {
        if (getConfig().getIntegerList("Abilities." + p.getUniqueId()).isEmpty())
            return null;
        return getConfig().getIntegerList("Abilities." + p.getUniqueId());
    }

    public void setAbility(OfflinePlayer p, int abilitySlot, AbilityType newAbility) {
        List<Integer> abilities = getAbilitiesId(p);

        abilities.set(abilitySlot, newAbility.abilityId);

        setConfig("Abilities." + p.getUniqueId(), abilities);
    }

    public int getAbilityAmount(OfflinePlayer p) {
        int amount = 0;
        for (AbilityType abilityType : getAbilities(p)) {
            if (abilityType == AbilityType.EMPTY) {
                continue;
            }
            amount++;
        }
        return amount;
    }

    public int firstAbility(OfflinePlayer p) {
        int slot = -1;
        for (AbilityType abilityType : getAbilities(p)) {
            slot++;
            if (abilityType == AbilityType.EMPTY) {
                continue;
            }
            break;
        }
        return slot;
    }

    public AbilityType getAbility(OfflinePlayer p, int abilitySlot) {
        List<AbilityType> abilities = getAbilities(p);
        try {
            return abilities.get(abilitySlot);
        } catch (IndexOutOfBoundsException err) {
            return null;
        }
    }

    public AbilityType getAbility(int abilityId) {
        return AbilityType.values()[abilityId];
    }

    public static List<AbilityType> getTrimmedAbilities(OfflinePlayer p) {
        List<AbilityType> abilityList = new ArrayList<>();
        for (int id : getAbilitiesId(p)) {
            if (id == 0)
                continue;
            abilityList.add(AbilityType.values()[id]);
        }
        return abilityList;
    }

    public static List<AbilityType> getAbilities(OfflinePlayer p) {
        List<AbilityType> abilityList = new ArrayList<>();
        for (int id : getAbilitiesId(p)) {
            abilityList.add(AbilityType.values()[id]);
        }
        return abilityList;
    }
}
