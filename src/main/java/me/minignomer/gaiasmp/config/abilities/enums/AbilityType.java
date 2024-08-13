package me.minignomer.gaiasmp.config.abilities.enums;

import me.minignomer.gaiasmp.config.element.types.ElementType;

public enum AbilityType {

    EMPTY (null, 0, null, null),

    NETHER_RESILIENCE (ElementType.FIRE, 1, "Nether Resilience", RarityLevel.PERK), // Fire resistance
    OCEAN_AGILITY (ElementType.WATER, 2, "Ocean Agility", RarityLevel.PERK), // Faster swim speed
    NATURES_TOUCH (ElementType.EARTH, 3, "Nature's Touch", RarityLevel.PERK), // Haste
    WIND_RESISTANCE (ElementType.WIND, 4, "Wind Resistance", RarityLevel.PERK), // Reduces knockback taken

    FLAME_BODY (ElementType.FIRE, 5, "Flame Body", RarityLevel.PERK), // While on fire you do 15% damage
    HYDRO_BOOST (ElementType.WATER, 6, "Hydro Boost", RarityLevel.PERK), // Water breathing
    GEO_FIST (ElementType.EARTH, 7, "Geo Fist", RarityLevel.PERK), // You do 15% more damage under Y level 0
    LIGHT_FEET (ElementType.WIND, 8, "Light Feet", RarityLevel.PERK), // 50% less fall damage

    FLAMING_VENGEANCE(ElementType.FIRE, 9, "Flaming Vengeance", RarityLevel.PERK), // Fire thorns
    AQUATIC_SHIELD (ElementType.WATER, 10, "Aquatic Shield", RarityLevel.PERK), // Takes 15% less damage in water
    LITHO_COMBUSTION (ElementType.EARTH, 11, "Litho Combustion", RarityLevel.PERK), // 5% chance that players get a mini explosion to knock them in the air
    DOUBLE_JUMP (ElementType.WIND, 12, "Double Jump", RarityLevel.PERK), // Double jump

    BURNING_LOVE (ElementType.FIRE, 13, "Burning Love", RarityLevel.PERK), // Regen when near a campfire
    SPLASHY_WASHY (ElementType.WATER, 14, "Splashy Washy", RarityLevel.PERK), // Creates a splash when you fall from a distance
    FLOOR_DEFENCE (ElementType.EARTH, 15, "Floor Defence", RarityLevel.PERK), // Reduces damage based on how hard the block you're standing on is
    SWIFTY_SPRINT (ElementType.WIND, 16, "Swifty Sprint", RarityLevel.PERK), // Speed

    // COMMON:
    //
    FIRE_TEMP_8 (ElementType.FIRE, 17, "Flame Imbuement", RarityLevel.COMMON), // Increases damage by 15% (soul fire particles)
    WATER_TEMP_9 (ElementType.WATER, 18, "Hydro Boost", RarityLevel.COMMON),
    POISON_IVY (ElementType.EARTH, 19, "Poison Ivy", RarityLevel.COMMON), // Creates a floor of particles that make you take damage and poison
    AIR_SWORD (ElementType.WIND, 20, "Air Sword", RarityLevel.COMMON), // Increases attack speed and movement speed slightly

    // Sabotages another player
    RAPID_FLARE (ElementType.FIRE, 21, "Rapid Flare", RarityLevel.COMMON), // Shoots several consecutive mini-fireballs
    WATER_TEMP_10 (ElementType.WATER, 22, "Hydro Boost", RarityLevel.COMMON),
    DEFENCIVE_DIG (ElementType.EARTH, 23, "Defencive Dig", RarityLevel.COMMON), // The next player to hit you get stuck in the ground
    WIND_GUST (ElementType.WIND, 24, "Wind Gust", RarityLevel.COMMON), // Pushes away players in the direction you're looking

    // Boosts you:
    FIRE_TEMP_2 (ElementType.FIRE, 25, "Flame Body", RarityLevel.COMMON),
    WATER_TEMP_11 (ElementType.WATER, 26, "Hydro Boost", RarityLevel.COMMON),
    HARD_AS_A_ROCK (ElementType.EARTH, 27, "Hard As Dwayne (The Rock)", RarityLevel.COMMON), // Reduces damage for 15 seconds
    DASH (ElementType.WIND, 28, "Dash", RarityLevel.COMMON), // Dashes you forwards a bit

    // Weak damage
    FIRE_SLASHES (ElementType.FIRE, 29, "Fire Slashes", RarityLevel.COMMON), // Creates a slash which damages nearby players
    BUBBLE_BEAM (ElementType.WATER, 30, "Bubble Beam", RarityLevel.COMMON), // Shoots a few small bubbles that do damage
    EARTH_TEMP_13 (ElementType.EARTH, 31, "Geo Fist", RarityLevel.COMMON),
    WIND_TEMP_19 (ElementType.WIND, 32, "Light Feet", RarityLevel.COMMON),

    // UNCOMMON:
    FIRE_TEMP_3 (ElementType.FIRE, 33, "Flame Body", RarityLevel.UNCOMMON),
    ANGELIC_CLEANSING (ElementType.WATER, 34, "Angelic Cleansing", RarityLevel.UNCOMMON), // Clears bad effects
    EARTH_TEMP_14 (ElementType.EARTH, 35, "Geo Fist", RarityLevel.UNCOMMON),
    WIND_TEMP_20 (ElementType.WIND, 36, "Dash", RarityLevel.UNCOMMON),

    FIRE_TEMP_4 (ElementType.FIRE, 37, "Flame Body", RarityLevel.UNCOMMON),
    DEFENCIVE_BUBBLE (ElementType.WATER, 38, "Defencive Bubble", RarityLevel.UNCOMMON), // Stops 5 attacks until the bubble pops
    PEACE_N_HARMONY (ElementType.EARTH, 39, "Peace N' Harmony", RarityLevel.UNCOMMON), // Marked player loses hearts as they deal damage to you
    WIND_TEMP_21 (ElementType.WIND, 40, "Light Feet", RarityLevel.UNCOMMON),

    SCARLET_BLAZE (ElementType.FIRE, 41, "Scarlet Blaze", RarityLevel.UNCOMMON), // Boosted up in air, slow falling for 5 seconds (aim time), pushes you where you're looking and kaboom
    WATER_TEMP_12 (ElementType.WATER, 42, "", RarityLevel.UNCOMMON),
    EARTH_TEMP_16 (ElementType.EARTH, 43, "Geo Fist", RarityLevel.UNCOMMON),
    WIND_SHURIKEN (ElementType.WIND, 44, "Wind Shuriken", RarityLevel.UNCOMMON), // Throws a shuiken made up of air/wind particles


    FLAMETHROWER (ElementType.FIRE, 45, "Flamethrower", RarityLevel.RARE), // Shoots lots of fire
    BOILING_BULLET (ElementType.WATER, 46, "Boiling Bullet", RarityLevel.RARE), // Shoots an extremely hot water bullet which catches the mob on fire
    FOOT_NIBBLER (ElementType.EARTH, 47, "Foot Nibbler", RarityLevel.RARE), // Causes fangs to come out of the ground
    WIND_TEMP_23 (ElementType.WIND, 48, "Light Feet", RarityLevel.RARE),

    BLAZING_METEOR (ElementType.FIRE, 49, "Blazing Meteor", RarityLevel.RARE), // Shoots a large meteor with strong gravity
    AQUA_PULSE (ElementType.WATER, 50, "Aqua Pulse", RarityLevel.RARE), // Shoots several pulses of water around the player that progressively get bigger
    EARTHQUAKE (ElementType.EARTH, 51, "Earthquake", RarityLevel.RARE), // Causes nearby blocks and entities to experience an earthquake
    TORNADO (ElementType.WIND, 52, "Tornado", RarityLevel.RARE), // Creates a large tornado


    GATES_OF_HELL (ElementType.FIRE, 53, "Gates of Hell", RarityLevel.MYTHIC), // Creates a circle around the player, enemies take damage when they enter
    AQUA_SPHERE (ElementType.WATER, 54, "Aqua Sphere", RarityLevel.MYTHIC), // Creates a large sphere of water that slows down all entities that enter it
    EARTH_TEMP_17 (ElementType.EARTH, 55, "Geo Fist 2", RarityLevel.MYTHIC),
    WIND_TEMP_25 (ElementType.WIND, 56, "Light Feet 2", RarityLevel.MYTHIC);

    public final ElementType element;
    public final int abilityId;
    public final String name;
    public final RarityLevel rarity;

    AbilityType(ElementType element, int abilityId, String name, RarityLevel rarity) {
        this.element = element;
        this.abilityId = abilityId;
        this.name = name;
        this.rarity = rarity;
    }
}
