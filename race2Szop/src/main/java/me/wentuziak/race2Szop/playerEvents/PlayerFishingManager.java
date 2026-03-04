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
import static me.wentuziak.race2Szop.lootTables.LuckCalculator.getLuckLevel;
import static me.wentuziak.race2Szop.lootTables.LuckCalculator.randomInteger;
import static me.wentuziak.race2Szop.races.Gatito.onGatitoFish;

public class PlayerFishingManager {

    public static ItemStack onPlayerCatchFish(Player player, NamespacedKey raceKey, ItemStack caughtFish, Projectile fishingBobber){

        Location loc = fishingBobber.getLocation();
        Biome biome = loc.getWorld().getBiome(loc.getBlockX(), loc.getBlockZ());

        if (getLuckLevel(player) > randomInteger(100)){
            // summon a mob
            return new ItemStack(Material.AIR, 1);
        }

        if (getLuckLevel(player) > randomInteger(30)){
            //get treasure loot
        }

        if (raceKey.equals(GATITO_RACE)){
            onGatitoFish(player);
        }
        player.sendMessage("luck: " + getLuckLevel(player));

        return caughtFish;
    }

}
