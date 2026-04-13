package me.wentuziak.race2Szop.actions;

import me.wentuziak.race2Szop.Race2Szop;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.*;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.util.Vector;

import static me.wentuziak.race2Szop.ItemKeys.MULTI_ATTACK_EFFECT;
import static me.wentuziak.race2Szop.actions.BowActions.blazeProjectile;

public class CrossBowActions {
    public static void fireworkManager(Firework firework){

        PersistentDataContainer fireworkDataContainer = firework.getPersistentDataContainer();

        if (fireworkDataContainer.has(MULTI_ATTACK_EFFECT)){
            fireworkMultiShot(firework, firework.getLocation());
        }
    }

    public static void fireworkMultiShot(Firework firework, Location location) {
        World world = location.getWorld();

        for (int i = 0; i < 3; i++) {
            Firework newFirework = world.spawn(location.add(0, 0.2, 0), Firework.class);

            newFirework.setShooter(firework.getShooter());
            newFirework.setFireworkMeta(firework.getFireworkMeta());

            newFirework.setGravity(true);

            Vector velocity = firework.getVelocity().clone();

            double randomUp = 0.2 + (Math.random() * 0.2);
            velocity.setY(velocity.getY() + randomUp);

            velocity.setX(velocity.getX() + (Math.random() - 0.5) * 1.2);
            velocity.setZ(velocity.getZ() + (Math.random() - 0.5) * 1.2);

            newFirework.setVelocity(velocity);
        }
    }

    public static void ghastProjectile(Projectile projectile){
        projectile.remove();

        Fireball fireball = (Fireball) projectile.getWorld().spawnEntity(
                    projectile.getLocation(),
                    EntityType.FIREBALL
            );

            Vector velocity = projectile.getVelocity().multiply(2);
            fireball.setVelocity(velocity);

            if (projectile.getShooter() instanceof org.bukkit.entity.LivingEntity shooter) {
                fireball.setShooter(shooter);
            }

            fireball.setIsIncendiary(true);

            fireball.setYield(2);

    }
}
