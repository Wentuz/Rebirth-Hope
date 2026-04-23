package me.wentuziak.race2Szop.playerEvents;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Biome;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import java.util.HashMap;
import java.util.Set;

import static me.wentuziak.race2Szop.RaceKeys.GATITO_RACE;
import static me.wentuziak.race2Szop.lootTables.LootManager.getLootMaterial;
import static me.wentuziak.race2Szop.lootTables.LuckCalculator.getLuckLevel;
import static me.wentuziak.race2Szop.lootTables.LuckCalculator.randomInteger;
import static me.wentuziak.race2Szop.races.Gatito.gatitoAdditionalFishManager;
import static me.wentuziak.race2Szop.races.Gatito.onGatitoFishMultiplier;

public class PlayerFishingManager {

    private static final HashMap<Integer, Material> fishMaterials = new HashMap<>();
    static {
        fishMaterials.put(1, Material.SALMON);
        fishMaterials.put(2, Material.COD);
        fishMaterials.put(3, Material.PUFFERFISH);
        fishMaterials.put(4, Material.TROPICAL_FISH);
    }

    public static ItemStack onPlayerCatchFish(Player player, Set<NamespacedKey> raceKey, ItemStack caughtFish, Projectile fishingBobber){

        Location loc = fishingBobber.getLocation();
        Biome biome = loc.getWorld().getBiome(loc);
        Material material = caughtFish.getType();
        int amount = randomInteger(getLuckLevel(player)) + 1;

        if (getLuckLevel(player) > randomInteger(500)){ //100
            // summon a mob
            player.sendMessage("MOB");
            return new ItemStack(Material.AIR, 1);
        }

        if (getLuckLevel(player) > randomInteger(5) && fishMaterials.containsValue(material)){ //30
            material = getLootMaterial(biome);
            //get treasure loot
        }

        if (raceKey.contains(GATITO_RACE)){
            amount = amount + onGatitoFishMultiplier(player);

            if (getLuckLevel(player) > randomInteger(5)){
                ItemStack gatitoLoot = gatitoAdditionalFishManager();
                Item item = player.getWorld().dropItemNaturally(fishingBobber.getLocation(), gatitoLoot);

                Vector direction = player.getLocation().toVector().subtract(fishingBobber.getLocation().toVector()).normalize();
                direction.setY(direction.getY() + 0.5);
                item.setVelocity(direction.multiply(0.7));
            }
        }

        caughtFish.setType(material);
        if (material == Material.ENCHANTED_BOOK) amount = 1;

        caughtFish.setAmount(amount);
        return caughtFish;
    }

}
