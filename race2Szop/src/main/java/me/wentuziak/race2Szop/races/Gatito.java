package me.wentuziak.race2Szop.races;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemRarity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffectType;

import java.util.Collections;
import java.util.Objects;

import static me.wentuziak.race2Szop.ItemKeys.SPECIAL_FOOD;
import static me.wentuziak.race2Szop.Logic.Effects.givePotionEffect;
import static me.wentuziak.race2Szop.Logic.GetItemCategories.isFood;
import static me.wentuziak.race2Szop.lootTables.LuckCalculator.getLuckLevel;
import static me.wentuziak.race2Szop.lootTables.LuckCalculator.randomInteger;

public class Gatito implements Race{
    NamespacedKey raceKey = Race.currentRaceKey("GATITO_RACE");

    public static void onGatitoEnterBed(Player player) {
        givePotionEffect(player, PotionEffectType.SPEED, 60 * 8, 0);
        givePotionEffect(player, PotionEffectType.HASTE, 60 * 8, 0);
        givePotionEffect(player, PotionEffectType.LUCK, 60 * 8, 0);
    }

    public static ItemStack onGatitoSmeltFood(ItemStack item){
        return createGatitoFood(item);
    }

    public static ItemStack onGatitoCraftFood(ItemStack item){
        if (isFood(item.getType())) {
            return createGatitoFood(item);
        }else {
            return item;
        }
    }

    private static ItemStack createGatitoFood(ItemStack item){
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.setRarity(ItemRarity.UNCOMMON);
        meta.setLore(Collections.singletonList(ChatColor.YELLOW + "Addidional flavour"));
        meta.setEnchantmentGlintOverride(true);
        meta.getPersistentDataContainer().set(SPECIAL_FOOD, PersistentDataType.BOOLEAN, true);

        item.setItemMeta(meta);
        return item;
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
            case 1 -> Material.PRISMARINE_CRYSTALS;
            case 2 -> Material.PRISMARINE_SHARD;
            case 3 -> Material.AMETHYST_SHARD;
            case 4 -> Material.LAPIS_LAZULI;
            case 5 -> Material.REDSTONE_WIRE;
            case 6 -> Material.QUARTZ;
            case 7 -> Material.RAW_COPPER;
            case 8 -> Material.RAW_GOLD;
            case 0 -> Material.RAW_IRON;
            default -> Material.SPECTRAL_ARROW;
        };
        if (randomInteger(100) == 1) material = Material.CAKE;
        item.setType(material);
        return item;
    }
}
