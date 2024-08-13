package me.minignomer.gaiasmp.config.abilities.enums;

public enum RarityLevel {
    PERK ("§5§lPerk"),
    COMMON ("§7§lCommon"),
    UNCOMMON ("§a§lUncommon"),
    RARE ("§b§lRare"),
    MYTHIC ("§5§lMythic"),
    GAIA ("§c§lG§9§la§a§li§f§la"),
    ULTIMATE ("§6§lUltimate");

    public final String name;

    RarityLevel(String name) {
        this.name = name;
    }
}
