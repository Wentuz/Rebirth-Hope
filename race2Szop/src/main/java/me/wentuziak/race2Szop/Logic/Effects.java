package me.wentuziak.race2Szop.Logic;

import me.wentuziak.race2Szop.Race2Szop;
import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Firework;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.meta.FireworkMeta;
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

    public static Firework randomFirework(int power, Location location){
        Firework firework = (Firework) location.getWorld().spawn(location, Firework.class);
        FireworkMeta meta = firework.getFireworkMeta();

        meta.setPower(power);

        FireworkEffect effect = FireworkEffect.builder()
                .withColor(getRandomColor())
                .withFade(getRandomColor())
                .with(FireworkEffect.Type.BALL_LARGE)
                .build();
        meta.addEffect(effect);
        firework.setFireworkMeta(meta);

        return firework;
    }

    private static Color getRandomColor() {
        int red = (int)(Math.random() * 255 + 1);
        int green = (int)(Math.random() * 255 + 1);
        int blue = (int)(Math.random() * 255 + 1);

        return Color.fromRGB(red, green, blue);
    }

}
