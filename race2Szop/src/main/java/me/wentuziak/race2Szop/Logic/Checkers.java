package me.wentuziak.race2Szop.Logic;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getServer;

public class Checkers {

    public static boolean isPlayerAboveGround(LivingEntity player, double minDistance) {
        Block blockBelow = player.getLocation().subtract(0, minDistance, 0).getBlock();
        return !blockBelow.getType().isSolid();
    }

    public static boolean isPlayerWet(LivingEntity player){

        if (player.isInWater()) return true;
        if (!player.getWorld().hasStorm() && !player.getWorld().isThundering()) return false;
        return !isPlayerHiddenFromSun((Player) player);
    }

    public static boolean isDaytime(World world) {
        long time = world.getTime();
        return time >= 0 && time < 12000;
    }

    public static boolean isPlayerHiddenFromSun(Player player){
        Location location = player.getLocation().clone();
        for(int y = location.getBlockY(); y < 255; y++) {
            if(location.add(0, 1, 0).getBlock().getType() != Material.AIR
            && location.add(0, 1, 0).getBlock().getType() != Material.VOID_AIR) {
                return true;
            }
        }
        return false;
    }

//    public static void findNearestBlockAbove(Player player, int value ){
//        // value = step,
//        Location location = player.getLocation().clone(); // clone the location so we can modify it without issues
//        for(int y = location.getBlockY(); y > 0; y++) { // get current Y coordinate, go down until we hit bedrock (0)
//            if(y > 255) break;
//            if(location.add(0, value, 0).getBlock().getType() == Material.AIR) continue; // if the block is air, go to next
//            player.teleport(location.add(0, value, 0)); // teleport player to the block above, otherwise he would be stuck in the current one
//            break; // stop the loop
//        }
//    }

}
