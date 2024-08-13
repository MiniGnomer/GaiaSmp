package me.minignomer.gaiasmp.commands.scroll;

import me.minignomer.gaiasmp.config.abilities.enums.AbilityType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class ScrollTabCompleter implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] args) {
        List<String> options = new ArrayList<>();

        if (args.length == 1) {
            options.add("get");
            options.add("modify");
        }

        else if (args[0].equalsIgnoreCase("get")) {
            for (AbilityType ability : AbilityType.values()) {
                if (ability.abilityId == 0)
                    continue;
                options.add(ability.toString());
            }
        }

        return options;
    }
}
