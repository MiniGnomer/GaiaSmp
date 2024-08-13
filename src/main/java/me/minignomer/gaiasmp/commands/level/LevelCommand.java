package me.minignomer.gaiasmp.commands.level;

import me.minignomer.gaiasmp.config.level.LevelManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LevelCommand extends LevelManager implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use this command!");
            return true;
        }

        Player p = (Player) sender;

        if (args.length < 2) {
            p.sendMessage("§c§lIncorrect amount of command arguments!");
            p.sendMessage("§c§lCorrect usage: /level <player> <1-4>");
            return true;
        }

        if (Bukkit.getPlayer(args[0]) == null) {
            p.sendMessage("§c§lCould not find the player \"" + args[0] + "\"!");
            return true;
        }

        Player target = Bukkit.getPlayer(args[0]);

        int amount;

        try {
            amount = Integer.parseInt(args[1]);
        } catch (NumberFormatException exception) {
            sender.sendMessage("§c§l" + args[1] + " is an invalid amount!");
            return true;
        }

        if (amount < 1 || amount > 4) {
            p.sendMessage("§c§lLevel amount must be a number 1 to 4!");
            return true;
        }

        setLevel(target, amount);
        p.sendMessage("§a§lSet " + args[0] + "'s level to " + amount + "!");

        return true;
    }
}
