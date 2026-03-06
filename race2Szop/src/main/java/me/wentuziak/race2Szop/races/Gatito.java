package me.wentuziak.race2Szop.races;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;

import static me.wentuziak.race2Szop.Logic.Effects.givePotionEffect;
import static me.wentuziak.race2Szop.lootTables.LuckCalculator.getLuckLevel;
import static me.wentuziak.race2Szop.lootTables.LuckCalculator.randomInteger;

public class Gatito implements Race{
    NamespacedKey raceKey = Race.currentRaceKey("GATITO_RACE");

    public static void onGatitoEnterBed(Player player) {
        givePotionEffect(player, PotionEffectType.SPEED, 60 * 8, 0);
        givePotionEffect(player, PotionEffectType.HASTE, 60 * 8, 0);
        givePotionEffect(player, PotionEffectType.LUCK, 60 * 8, 0);
    }

    public static void onGatitoCookFood(Player player){

    }

    public static void onGatitoRide(Player player, LivingEntity rideableEntity){

        ItemStack itemInHand = player.getInventory().getItemInMainHand();
        ItemStack itemOffHand = player.getInventory().getItemInOffHand();

        if ((itemInHand.getType() == Material.AIR) && (itemOffHand.getType() == Material.AIR)){
            rideableEntity.addPassenger(player);
        }
    }

    public static int onGatitoFish(Player player){
        return randomInteger(getLuckLevel(player) / 2);
    }
}
