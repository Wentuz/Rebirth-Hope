package me.wentuziak.race2Szop.actions;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.*;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.util.Vector;

import static me.wentuziak.race2Szop.ItemKeys.MULTI_ATTACK_EFFECT;

public class BowActions {

    public static void arrowManager(Arrow arrow){

        PersistentDataContainer arrowDataContainer = arrow.getPersistentDataContainer();

        if (arrowDataContainer.has(MULTI_ATTACK_EFFECT)){
            bowMultiShot(arrow, arrow.getLocation());
        }
    }

    public static void bowMultiShot(Arrow arrow, Location location) {
        World world = location.getWorld();

        for (int i = 0; i < 3; i++) {
            Arrow newArrow = world.spawn(location.add(0, 0.2, 0), Arrow.class);

            newArrow.setShooter(arrow.getShooter());
            newArrow.setDamage(arrow.getDamage());
            newArrow.setKnockbackStrength(arrow.getKnockbackStrength());
            newArrow.setCritical(arrow.isCritical());
            newArrow.setPierceLevel(arrow.getPierceLevel());
            newArrow.setFireTicks(arrow.getFireTicks());

            Vector velocity = arrow.getVelocity().clone();

            double randomUp = 0.8 + (Math.random() * 0.4);
            velocity.setY(velocity.getY() + randomUp);

            velocity.setX(velocity.getX() + (Math.random() - 0.5) * 0.8);
            velocity.setZ(velocity.getZ() + (Math.random() - 0.5) * 0.8);

            newArrow.setVelocity(velocity);
        }
    }

    public static void blazeProjectile(Projectile projectile){
        SmallFireball fireball = (SmallFireball) projectile.getWorld().spawnEntity(
                projectile.getLocation(),
                EntityType.SMALL_FIREBALL
        );

        Vector velocity = projectile.getVelocity();
        fireball.setVelocity(velocity);

        if (projectile.getShooter() instanceof org.bukkit.entity.LivingEntity shooter) {
            fireball.setShooter(shooter);
        }

        fireball.setIsIncendiary(true);
        fireball.setYield(0);

        projectile.remove();
    }

}
