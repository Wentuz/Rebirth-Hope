package me.wentuziak.race2Szop.Logic;

import org.bukkit.block.Block;
import org.bukkit.entity.LivingEntity;

public class Checkers {

    public static boolean isPlayerAboveGround(LivingEntity player, double minDistance) {
        Block blockBelow = player.getLocation().subtract(0, minDistance, 0).getBlock();
        return !blockBelow.getType().isSolid();
    }

}
