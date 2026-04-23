package me.wentuziak.race2Szop.playerEvents;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Set;

import static me.wentuziak.race2Szop.RaceKeys.GATITO_RACE;
import static me.wentuziak.race2Szop.races.Gatito.onGatitoCraftFood;
import static me.wentuziak.race2Szop.races.Gatito.onGatitoSmeltFood;

public class PlayerCraftingManager {


    public static void playerSmelting(Player player, Set<NamespacedKey> key, ItemStack item){
        if (key.contains(GATITO_RACE)){
            onGatitoSmeltFood(item);
        }
    }


    public static void playerCrafting(Player player, Set<NamespacedKey> key, ItemStack item){
        if (key.contains(GATITO_RACE)){
            onGatitoCraftFood(item);
        }
    }

}
