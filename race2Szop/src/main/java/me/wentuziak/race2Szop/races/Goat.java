package me.wentuziak.race2Szop.races;

import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class Goat implements Race {
    NamespacedKey raceKey = Race.currentRaceKey("GOAT_RACE");

    public static void goatBreakBlock(Player player, Block brokenBlock){
        //flowers, leaves, grass
    }

    public static void goatJump(Player player){
        //jump like in minecraft
    }

    public static void goatRam(Player player){
        //speed at started sprinting
        //first few seconds give bonus to firts attack & massive knockback
    }

}
