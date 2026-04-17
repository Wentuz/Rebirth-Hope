package me.wentuziak.race2Szop.items;

import me.wentuziak.race2Szop.Race2Szop;
import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Projectile;

import static me.wentuziak.race2Szop.actions.BowActions.blazeProjectile;
import static me.wentuziak.race2Szop.actions.CrossBowActions.ghastProjectile;

public class BlazeBow {

    public static void blazeBowShoot(Projectile projectile){
        int delay;
        if (projectile.getType().equals(EntityType.FIREWORK_ROCKET)){
            delay = 2;
        } else {
            delay = 1;
        }

        Bukkit.getScheduler().runTaskLater(Race2Szop.getInstance(), () -> {
            if (delay != 1){
                ghastProjectile(projectile);
            }else{
                blazeProjectile(projectile);}
        },  delay);
    }

}
