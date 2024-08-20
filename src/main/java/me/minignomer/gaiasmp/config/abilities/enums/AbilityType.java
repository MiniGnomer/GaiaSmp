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


    FLAME_IMBUEMENT (ElementType.FIRE, 17, "Flame Imbuement", RarityLevel.COMMON), // Increases damage by 15% (soul fire particles)
    DOLPHIN_RUSH (ElementType.WATER, 18, "Dolphin's Rush", RarityLevel.COMMON), // Gives you dolphins grace effect for 5 seconds
    POISON_IVY (ElementType.EARTH, 19, "Poison Ivy", RarityLevel.COMMON), // Creates a floor of particles that make you take damage and poison
    AIR_SWORD (ElementType.WIND, 20, "Air Sword", RarityLevel.COMMON), // Increases attack speed and movement speed slightly

    RAPID_FLARE (ElementType.FIRE, 21, "Rapid Flare", RarityLevel.COMMON), // Shoots several consecutive mini-fireballs
    WATER_JET (ElementType.WATER, 22, "Water Jet", RarityLevel.COMMON), // Shoots a stream of water wherever you're looking
    DEFENCIVE_DIG (ElementType.EARTH, 23, "Defencive Dig", RarityLevel.COMMON), // The next player to hit you get stuck in the ground
    WIND_GUST (ElementType.WIND, 24, "Wind Gust", RarityLevel.COMMON), // Pushes away players in the direction you're looking

    RING_OF_FIRE (ElementType.FIRE, 25, "Ring Of Fire", RarityLevel.COMMON), // Creates a damaging ring of fire
    DEFENCIVE_BUBBLE (ElementType.WATER, 26, "Defensive Bubble", RarityLevel.COMMON), // Stops 3 attacks until the bubble pops
    HARD_AS_A_ROCK (ElementType.EARTH, 27, "Hard As Dwayne (The Rock)", RarityLevel.COMMON), // Reduces damage for 15 seconds
    DASH (ElementType.WIND, 28, "Dash", RarityLevel.COMMON), // Dashes you forwards a bit

    FIRE_SLASHES (ElementType.FIRE, 29, "Fire Slashes", RarityLevel.COMMON), // Creates a slash which damages nearby players
    BUBBLE_BEAM (ElementType.WATER, 30, "Bubble Beam", RarityLevel.COMMON), // Shoots a few small bubbles that do damage
    BATTLE_RAM (ElementType.EARTH, 31, "Battle Ram", RarityLevel.COMMON), // If hit a player, they stunned + damaged. If you miss, you stunned
    WIND_TUG (ElementType.WIND, 32, "Wind Tug", RarityLevel.COMMON), // Pulls a player towards you


    FIREBALL (ElementType.FIRE, 33, "Fireball (we had to)", RarityLevel.UNCOMMON), // Shoots a fireball
    ANGELIC_CLEANSING (ElementType.WATER, 34, "Angelic Cleansing", RarityLevel.UNCOMMON), // Clears bad effects
    IRON_PROTECTOR (ElementType.EARTH, 35, "Iron Protector", RarityLevel.UNCOMMON), // Spawns an iron golem bodyguard
    GUST_OF_CHANCE (ElementType.WIND, 36, "Gust Of Chance", RarityLevel.UNCOMMON), // Pushes the player in a random direction

    DEMON_GUARDS (ElementType.FIRE, 37, "Demon Guards", RarityLevel.UNCOMMON), // Spawns nether mobs that attack everyone except the user
    WAVE (ElementType.WATER, 38, "Wave", RarityLevel.UNCOMMON), // Creates a wave in the direction you're looking
    PEACE_N_HARMONY (ElementType.EARTH, 39, "Peace N' Harmony", RarityLevel.UNCOMMON), // Marked player loses hearts as they deal damage to you
    WIND_VORTEX (ElementType.WIND, 40, "Wind Vortex", RarityLevel.UNCOMMON), // Creates a circle that pulls all nearby players to the centre

    SCARLET_BLAZE (ElementType.FIRE, 41, "Scarlet Blaze", RarityLevel.UNCOMMON), // Boosted up in air, slow falling for 5 seconds (aim time), pushes you where you're looking and kaboom
    HIT_OR_MIST (ElementType.WATER, 42, "Hit Or Mist (I Guess They Never Miss Huh?)", RarityLevel.UNCOMMON), // Mist particles in an area, makes you full invis and regen
    BLOCK_TURRET (ElementType.EARTH, 43, "Block Turret", RarityLevel.UNCOMMON), // Shoots several blocks
    WIND_SHURIKEN (ElementType.WIND, 44, "Wind Shuriken", RarityLevel.UNCOMMON), // Throws a shuiken made up of air/wind particles


    FLAMETHROWER (ElementType.FIRE, 45, "Flamethrower", RarityLevel.RARE), // Shoots lots of fire
    BOILING_BULLET (ElementType.WATER, 46, "Boiling Bullet", RarityLevel.RARE), // Shoots an extremely hot water bullet which catches the mob on fire
    FOOT_NIBBLER (ElementType.EARTH, 47, "Foot Nibbler", RarityLevel.RARE), // Causes fangs to come out of the ground
    EXTREME_GRAVITY (ElementType.WIND, 48, "Extreme Gravity", RarityLevel.RARE), // Pushes players to the ground (so they walk slow and can't jump)

    BLAZING_METEOR (ElementType.FIRE, 49, "Blazing Meteor", RarityLevel.RARE), // Shoots a large meteor with strong gravity
    AQUA_PULSE (ElementType.WATER, 50, "Aqua Pulse", RarityLevel.RARE), // Shoots several pulses of water around the player that progressively get bigger
    EARTHQUAKE (ElementType.EARTH, 51, "Earthquake", RarityLevel.RARE), // Causes nearby blocks and entities to experience an earthquake
    TORNADO (ElementType.WIND, 52, "Tornado", RarityLevel.RARE), // Creates a large tornado


    GATES_OF_HELL (ElementType.FIRE, 53, "Gates of Hell", RarityLevel.MYTHIC), // Creates a circle around the player, enemies take damage when they enter
    AQUA_SPHERE (ElementType.WATER, 54, "Aqua Sphere", RarityLevel.MYTHIC), // Creates a large sphere of water that slows down all entities that enter it
    ROCK_STORM (ElementType.EARTH, 55, "Rock Storm", RarityLevel.MYTHIC), // Makes blocks fly in the air then come back down as meteors (doesn't destroy blocks)
    WIND_MYTHIC_TEMP (ElementType.WIND, 56, "Wind Mythic", RarityLevel.MYTHIC);

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
