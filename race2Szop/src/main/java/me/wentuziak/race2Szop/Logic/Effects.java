package me.wentuziak.race2Szop.Logic;

import me.wentuziak.race2Szop.Race2Szop;
import org.bukkit.Bukkit;
import org.bukkit.Particle;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Effects {
    public static void particleEmitterOnEntity(Entity target, Particle particle, int particleNumber, int ticks) {
        target.getWorld().spawnParticle(particle, target.getLocation(), particleNumber);
        if(ticks == 0) {
            return;
        }else {
            Bukkit.getScheduler().runTaskLater(Race2Szop.getInstance(), () -> {
                particleEmitterOnEntity(target, particle, particleNumber, ticks - 1);
            },  1);
        }
    }
    public static void particleEmitterOnEntity(Entity target, Particle particle, int particleNumber, int ticks, double x, double y, double z, double a) {
        target.getWorld().spawnParticle(particle, target.getLocation(), particleNumber, x, y, z, a);
        if(ticks == 0) {
            return;
        }else {
            Bukkit.getScheduler().runTaskLater(Race2Szop.getInstance(), () -> {
                particleEmitterOnEntity(target, particle, particleNumber, ticks - 1, x, y, z, a);
            },  1);
        }
    }

    public static void givePotionEffect(LivingEntity entity, PotionEffectType potionType, int seconds, int intensity){

        entity.addPotionEffect(new PotionEffect(potionType, 20 * seconds, intensity));

    }

}
