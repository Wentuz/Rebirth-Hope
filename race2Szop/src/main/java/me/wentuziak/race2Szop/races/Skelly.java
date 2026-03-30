package me.wentuziak.race2Szop.races;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.data.type.Switch;
import org.bukkit.entity.Horse;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

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

    public static void skellyShootArrow(Player player){

    }

}
