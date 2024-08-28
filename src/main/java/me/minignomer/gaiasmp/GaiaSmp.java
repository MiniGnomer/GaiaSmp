package me.minignomer.gaiasmp;

import com.samjakob.spigui.SpiGUI;
import me.minignomer.gaiasmp.commands.gaiastone.GaiaStoneCommand;
import me.minignomer.gaiasmp.commands.gaiastone.GuiItems;
import me.minignomer.gaiasmp.commands.level.LevelCommand;
import me.minignomer.gaiasmp.commands.level.LevelTabCompleter;
import me.minignomer.gaiasmp.commands.scroll.ScrollCommand;
import me.minignomer.gaiasmp.commands.scroll.ScrollTabCompleter;
import me.minignomer.gaiasmp.listeners.ActivateAbility;
import me.minignomer.gaiasmp.listeners.PlayerDeathListener;
import me.minignomer.gaiasmp.listeners.PlayerJoinListener;
import me.minignomer.gaiasmp.listeners.PreventItemMove;
import org.bukkit.plugin.java.JavaPlugin;

public final class GaiaSmp extends JavaPlugin {

    public static GaiaSmp plugin;

    public static SpiGUI spiGUI;

    private void registerListeners() {
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
        getServer().getPluginManager().registerEvents(new ActivateAbility(), this);
        getServer().getPluginManager().registerEvents(new PreventItemMove(), this);
        getServer().getPluginManager().registerEvents(new PlayerDeathListener(), this);
    }

    private void registerCommands() {
        getCommand("scroll").setExecutor(new ScrollCommand());
        getCommand("scroll").setTabCompleter(new ScrollTabCompleter());

        getCommand("gaiastone").setExecutor(new GaiaStoneCommand());

        getCommand("level").setExecutor(new LevelCommand());
        getCommand("level").setTabCompleter(new LevelTabCompleter());
    }

    @Override
    public void onEnable() {
        plugin = this;
        spiGUI = new SpiGUI(this);
        GuiItems.registerGuiItems();
        registerListeners();
        registerCommands();
    }
}
