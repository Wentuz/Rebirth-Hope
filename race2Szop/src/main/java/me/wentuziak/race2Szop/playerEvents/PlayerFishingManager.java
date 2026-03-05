package me.wentuziak.race2Szop.playerEvents;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Biome;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.ItemStack;

import static me.wentuziak.race2Szop.RaceKeys.GATITO_RACE;
import static me.wentuziak.race2Szop.lootTables.LootManager.getLootMaterial;
import static me.wentuziak.race2Szop.lootTables.LuckCalculator.getLuckLevel;
import static me.wentuziak.race2Szop.lootTables.LuckCalculator.randomInteger;
import static me.wentuziak.race2Szop.races.Gatito.onGatitoFish;

public class PlayerFishingManager {

    public static ItemStack onPlayerCatchFish(Player player, NamespacedKey raceKey, ItemStack caughtFish, Projectile fishingBobber){

        Location loc = fishingBobber.getLocation();
        Biome biome = loc.getWorld().getBiome(loc);
        Material material = caughtFish.getType();
        int amount = randomInteger(getLuckLevel(player) + 1);

        if (getLuckLevel(player) > randomInteger(500)){ //100
            // summon a mob
            player.sendMessage("MOB");
            return new ItemStack(Material.AIR, 1);
        }

        if (getLuckLevel(player) > randomInteger(5)){ //30
            material = getLootMaterial(biome);
            //get treasure loot
        }

        if (raceKey.equals(GATITO_RACE)){
            amount = amount + onGatitoFish(player);
        }

        caughtFish.setType(material);
        if (material == Material.ENCHANTED_BOOK) amount = 1;

        caughtFish.setAmount(amount);
        return caughtFish;
    }

}
