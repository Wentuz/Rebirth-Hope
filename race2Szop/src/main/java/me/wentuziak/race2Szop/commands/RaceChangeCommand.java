package me.wentuziak.race2Szop.commands;

import org.bukkit.entity.Player;

public class RaceChangeCommand {

    public static boolean swapPlayerRace(Player player, String raceKey){

        player.sendMessage(" swap = " + player + raceKey);

        return true;
    }

}
