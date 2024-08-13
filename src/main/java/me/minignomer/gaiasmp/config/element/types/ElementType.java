package me.minignomer.gaiasmp.config.element.types;

public enum ElementType {
    FIRE ("Fire", "§c🔥"),
    WATER ("Water","§9§l🌊§r§9"),
    WIND ("Wind","§f§l☁§r§f"),
    EARTH ("Earth", "§2§l♣§r§2");

    public final String name;
    public final String symbol;

    ElementType(String name, String symbol) {
        this.name = name;
        this.symbol = symbol;
    }
}
