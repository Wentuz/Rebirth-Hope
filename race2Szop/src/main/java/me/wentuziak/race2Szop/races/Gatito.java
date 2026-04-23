package me.wentuziak.race2Szop.races;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;

import java.util.Objects;

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

    public static int onGatitoFishMultiplier(Player player){
        return randomInteger(getLuckLevel(player) / 2);
    }

    public static ItemStack gatitoAdditionalFishManager(){
        ItemStack item = new ItemStack(Material.GOLD_INGOT);
        Material material = switch (randomInteger(10)) {
            case 0 -> Material.CAKE;
            case 1 -> Material.PRISMARINE_CRYSTALS;
            case 2 -> Material.PRISMARINE_SHARD;
            case 3 -> Material.AMETHYST_SHARD;
            case 4 -> Material.LAPIS_LAZULI;
            case 5 -> Material.REDSTONE_WIRE;
            case 6 -> Material.QUARTZ;
            case 7 -> Material.RAW_COPPER;
            case 8 -> Material.RAW_GOLD;
            case 9 -> Material.RAW_IRON;
            default -> Material.SPECTRAL_ARROW;
        };
        item.setType(material);
        return item;
    }
}
