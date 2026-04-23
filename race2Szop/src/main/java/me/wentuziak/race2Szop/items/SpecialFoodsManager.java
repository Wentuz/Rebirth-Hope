package me.wentuziak.race2Szop.items;

import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

import static me.wentuziak.race2Szop.Logic.Effects.givePotionEffect;

public class SpecialFoodsManager {


    public static void specialFoodManager(Material material, LivingEntity target){
        switch (material){
            case DRIED_KELP, COOKED_SALMON, COOKED_COD -> givePotionEffect(target, PotionEffectType.WATER_BREATHING, 20, 0);
            case GOLDEN_CARROT -> givePotionEffect(target, PotionEffectType.NIGHT_VISION, 60, 0);
            case PUMPKIN_PIE, COOKIE -> givePotionEffect(target, PotionEffectType.SPEED, 60, 0);
            case MUSHROOM_STEW, RABBIT_STEW, BEETROOT_SOUP, SUSPICIOUS_STEW -> givePotionEffect(target, PotionEffectType.REGENERATION, 10 * 60, 0);
            default -> baseFoodEffect(target);
        }
    }


    private static void baseFoodEffect(LivingEntity target){
        givePotionEffect(target, PotionEffectType.SATURATION, 1, 0);
    }


}
