package me.wentuziak.race2Szop;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;

import java.util.List;

public class CommandManager implements TabExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {



         // TODO : implement race swapping command

        if (args.length < 1 || args.length > 2) {
            sender.sendMessage("Usage: /swaprace [race] [player]");
            return false;
        }
        if (!sender.isOp()) {
            sender.sendMessage("Need op to use this command");
            return false;
        }

        sender.sendMessage("hehehe");

        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        return List.of();
    }
}
