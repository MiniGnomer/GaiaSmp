package me.minignomer.gaiasmp.commands.scroll;

import me.minignomer.gaiasmp.config.abilities.enums.AbilityType;
import me.minignomer.gaiasmp.items.Scroll;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ScrollCommand extends Scroll implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use this command!");
            return true;
        }

        Player p = (Player) sender;

        if (args.length < 2) {
            p.sendMessage("§c§lThis command requires more arguments!");
            return true;
        }

        if (args[0].equalsIgnoreCase("get")) {
            if (args.length != 2) {
                p.sendMessage("§c§lIncorrect amount of arguments! \n§cCorrect usage: /scroll get <Scroll_Name>");
                return true;
            }
            AbilityType scrollType;
            try {
                scrollType = AbilityType.valueOf(args[1].toUpperCase());
            } catch (IllegalArgumentException err) {
                p.sendMessage("§c§lIncorrect scroll type!");
                return true;
            }

            p.getInventory().addItem(createScroll(scrollType));

            p.sendMessage("§a" + p.getDisplayName() + " obtained the " + scrollType.name + " scroll!");
            return true;
        }

        return true;
    }
}
