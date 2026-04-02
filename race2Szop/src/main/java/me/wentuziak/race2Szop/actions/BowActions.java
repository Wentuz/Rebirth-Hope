package me.wentuziak.race2Szop.actions;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class BowActions {

    public static void arrowManager(Arrow arrow){

        if (arrow.getShooter() instanceof Player player){
            bowMultiShot(arrow, arrow.getLocation());
        }
    }

    public static void bowMultiShot(Arrow arrow, Location location) {
        World world = location.getWorld();

        for (int i = 0; i < 3; i++) {
            Arrow newArrow = world.spawn(location.add(0, 0.2, 0), Arrow.class);

            // Copy basic properties
            //newArrow.setShooter(arrow.getShooter());
            newArrow.setDamage(arrow.getDamage());
            newArrow.setKnockbackStrength(arrow.getKnockbackStrength());
            newArrow.setCritical(arrow.isCritical());
            newArrow.setPierceLevel(arrow.getPierceLevel());
            newArrow.setFireTicks(arrow.getFireTicks());

            // Base velocity from original arrow
            Vector velocity = arrow.getVelocity().clone();

            // Add random upward boost
            double randomUp = 0.5 + (Math.random() * 0.4); // between 0.2–0.6
            velocity.setY(velocity.getY() + randomUp);

            // Add slight horizontal spread (optional, looks nicer)
            velocity.setX(velocity.getX() + (Math.random() - 0.5) * 0.8);
            velocity.setZ(velocity.getZ() + (Math.random() - 0.5) * 0.8);

            newArrow.setVelocity(velocity);
        }
    }

}
