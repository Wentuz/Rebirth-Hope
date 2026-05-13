package me.wentuziak.race2Szop.races;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.data.type.Switch;
import org.bukkit.entity.*;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import java.util.Objects;

import static me.wentuziak.race2Szop.Logic.Checkers.*;
import static me.wentuziak.race2Szop.Logic.Effects.givePotionEffect;

public class Skelly implements Race {
    NamespacedKey raceKey = Race.currentRaceKey("SKELETON_RACE");

    public static void burnSkellyOnSun(Player player){
        if (isDaytime(player.getWorld()) && !isPlayerHiddenFromSun(player) && !isPlayerWet(player)){

            player.setFireTicks(20 * 5);

        }else{
            player.setVisualFire(false);
        }
    }

    public static void skellyMount(LivingEntity mount){

        givePotionEffect(mount, PotionEffectType.SPEED, 60 * 5, 1);
        givePotionEffect(mount, PotionEffectType.JUMP_BOOST, 60 * 5, 1);

    }

    public static void skellyFood(Player player, Material eatenFood){
        switch (eatenFood){
            case Material.ROTTEN_FLESH -> givePotionEffect(player, PotionEffectType.ABSORPTION, 45, 0);
            case Material.POISONOUS_POTATO -> givePotionEffect(player, PotionEffectType.HASTE, 45, 0);
        }
    }

    public static void skellyShootRocket(Firework firework){
        Firework newFirework = firework.getWorld().spawn(firework.getLocation().add(0, 0.2, 0), Firework.class);

        newFirework.setShooter(firework.getShooter());
        newFirework.setFireworkMeta(firework.getFireworkMeta());
        newFirework.setMaxLife(firework.getMaxLife());

        Vector velocity = firework.getVelocity().clone();

        velocity.setY(velocity.getY() + (Math.random() - 1.2) * 1);
        velocity.setX(velocity.getX() + (Math.random() - 0.5) * 0.6);
        velocity.setZ(velocity.getZ() + (Math.random() - 0.5) * 0.6);

        newFirework.setVelocity(velocity);
    }

    public static void skellyShootArrow(Arrow arrow){
        Arrow newArrow = arrow.getWorld().spawn(arrow.getLocation().add(0, 0.02, 0), Arrow.class);

        newArrow.setShooter(arrow.getShooter());
        newArrow.setDamage(arrow.getDamage());
        newArrow.setKnockbackStrength(arrow.getKnockbackStrength());
        newArrow.setCritical(arrow.isCritical());
        newArrow.setPierceLevel(arrow.getPierceLevel());
        newArrow.setFireTicks(arrow.getFireTicks());

        Vector velocity = arrow.getVelocity().clone();

        double randomUp = 0.1 + (Math.random() * 0.2);
        velocity.setY(velocity.getY() + randomUp);

        velocity.setX(velocity.getX() + (Math.random() - 0.5) * 0.8);
        velocity.setZ(velocity.getZ() + (Math.random() - 0.5) * 0.8);

        newArrow.setVelocity(velocity);
    }

}
