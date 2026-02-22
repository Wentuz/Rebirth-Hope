package me.wentuziak.race2Szop.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.jspecify.annotations.NonNull;

import java.util.ArrayList;
import java.util.List;

import static me.wentuziak.race2Szop.commands.RaceChangeCommand.swapPlayerRace;

public class CommandManager implements TabExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
         // TODO : implement race swapping command and getInfo command
         // /szoprace [command] [race] [player]

        String changeRace = "swap";
        String getInfo = "info";

        if (args.length < 1) {
            sender.sendMessage("Usage: /szoprace [command] [race] [player]");
            return false;
        }

        String usedCommand = args[0].toLowerCase();

        if (usedCommand.equals(changeRace)){

            switch (args.length) {
                case 1:
                    sender.sendMessage("Too little arguments, provide Race");
                    return false;
                case 2:
                    sender.sendMessage("case 2");

                    return swapPlayerRace((Player) sender, args[1]);

                case 3:
                    Player targetPlayer = Bukkit.getPlayer(args[2]);
                    sender.sendMessage("case 3 " + args[2]);

                    if (targetPlayer == null || !(sender instanceof Player)) {
                        sender.sendMessage(ChatColor.RED + "Player not found: " + args[2]);
                        return false;
                    }else {
                        return swapPlayerRace(targetPlayer, args[1]);
                    }

                default:
                    sender.sendMessage("Default error");
                    return false;
            }




        }else{
            sender.sendMessage("get info " + usedCommand + " " + args.length);

        }

        if (!sender.isOp()) {
            sender.sendMessage("Need op to use this command");
            return false;
        }

        sender.sendMessage("hehehe : " + usedCommand);

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if(args.length == 1){
            return java.util.Arrays.asList(
                    "swap", "info"
            );
        }
        if (args.length == 3) {
            List<String> playerNames = new ArrayList<>();
            for (Player player : Bukkit.getOnlinePlayers()) {
                playerNames.add(player.getName());
            }
            return playerNames;
        }
        return new ArrayList<>();
    }
}
