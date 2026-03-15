package me.wentuziak.race2Szop.races;

import org.bukkit.NamespacedKey;
import org.bukkit.block.data.type.Switch;
import org.bukkit.entity.Horse;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

import static me.wentuziak.race2Szop.Logic.Checkers.isDaytime;
import static me.wentuziak.race2Szop.Logic.Checkers.isPlayerHiddenFromSun;
import static me.wentuziak.race2Szop.Logic.Effects.givePotionEffect;

public class Skelly implements Race {
    NamespacedKey raceKey = Race.currentRaceKey("SKELETON_RACE");

    public static void burnSkellyOnSun(Player player){
        if (isDaytime(player.getWorld()) && isPlayerHiddenFromSun(player)){
            player.setFireTicks(20);
            player.setVisualFire(true);
        }else{
            player.setVisualFire(false);
        }
    }

    public static void skellyMount(LivingEntity mount){

        givePotionEffect(mount, PotionEffectType.SPEED, 60 * 5, 1);
        givePotionEffect(mount, PotionEffectType.JUMP_BOOST, 60 * 5, 1);

    }

    public static void skellyFood(Player player){

    }

    public static void skellyShootArrow(Player player){

    }

}
