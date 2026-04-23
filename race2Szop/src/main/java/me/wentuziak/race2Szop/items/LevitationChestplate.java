package me.wentuziak.race2Szop.items;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

import static me.wentuziak.race2Szop.Logic.Effects.givePotionEffect;

public class LevitationChestplate {

    public static void levitationManager(Player player){
        player.setGravity(!player.hasGravity());
    }

    public static void entityHitGiveGravity(LivingEntity entity){
        givePotionEffect(entity, PotionEffectType.LEVITATION, 5, 1);
    }

}
