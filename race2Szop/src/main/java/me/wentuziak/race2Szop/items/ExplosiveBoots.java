package me.wentuziak.race2Szop.items;

import org.bukkit.entity.Player;

public class ExplosiveBoots {

    public static void explosionBootsFall(Player player){
        player.getWorld().createExplosion(player.getLocation(), 1, false, false);
    }

}
