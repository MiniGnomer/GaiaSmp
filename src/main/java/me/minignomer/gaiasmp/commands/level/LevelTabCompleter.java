package me.minignomer.gaiasmp.commands.level;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class LevelTabCompleter implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] args) {
        List<String> options = new ArrayList<>();

        if (args.length == 2) {
            options.add("1");
            options.add("2");
            options.add("3");
            options.add("4");
        }

        return options;
    }
}
