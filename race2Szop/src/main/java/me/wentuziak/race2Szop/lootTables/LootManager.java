package me.wentuziak.race2Szop.lootTables;

import org.bukkit.Material;
import org.bukkit.block.Biome;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import static me.wentuziak.race2Szop.lootTables.CropsLoot.grassLoot;
import static me.wentuziak.race2Szop.lootTables.FishingLoot.*;
import static me.wentuziak.race2Szop.lootTables.MiningLoot.miningNetherrack;
import static me.wentuziak.race2Szop.lootTables.MiningLoot.miningRocks;

public class LootManager {

    // fishing loot material
    public static Material getLootMaterial(Biome biome) {
        Material lootMaterial = Material.CAKE;

        if (biome.equals(Biome.COLD_OCEAN) || biome.equals(Biome.DEEP_COLD_OCEAN)){
            lootMaterial = getRandomMaterial(fishingColdOcean);
        }
        else if(biome.equals(Biome.DEEP_FROZEN_OCEAN) || biome.equals(Biome.FROZEN_OCEAN)
        || biome.equals(Biome.FROZEN_RIVER)){
            lootMaterial = getRandomMaterial(fishingFroznOcean);
        }
        else if(biome.equals(Biome.WARM_OCEAN) || biome.equals(Biome.LUKEWARM_OCEAN)
        || biome.equals(Biome.DEEP_LUKEWARM_OCEAN)){
            lootMaterial = getRandomMaterial(fishingWarmOcean);
        }
        else if (biome.equals(Biome.RIVER)) {
            lootMaterial = getRandomMaterial(fishingRiver);
        }else if (biome.equals(Biome.DRIPSTONE_CAVES)) {
            lootMaterial = getRandomMaterial(fishingDripstoneCave);
        }else if (biome.equals(Biome.LUSH_CAVES)) {
            lootMaterial = getRandomMaterial(fishingLushCave);
        }else if (biome.equals(Biome.DEEP_DARK)) {
            lootMaterial = getRandomMaterial(fishingDeepDark);
        }

        return lootMaterial;
    }

    public static Material getPickAxeLootMaterial(Material material){
        if (material.equals(Material.GRANITE) || material.equals(Material.ANDESITE) || material.equals(Material.DIORITE)){
            return getRandomMaterial(miningRocks);
        } else if (material.equals(Material.NETHERRACK)) {
            return getRandomMaterial(miningNetherrack);
        }
        return material;
    }
    public static Material getHoeLootMaterial(Material material){
        if (material.equals(Material.SHORT_GRASS) || material.equals(Material.TALL_GRASS)
                || material.equals(Material.FERN) || material.equals(Material.TALL_DRY_GRASS)
                || material.equals(Material.SHORT_DRY_GRASS) || material.equals(Material.LARGE_FERN)
                || material.equals(Material.BUSH)){
            return getRandomMaterial(grassLoot);
        } else if (material.equals(Material.NETHERRACK)) {
            return getRandomMaterial(miningNetherrack);
        }
        return material;
    }


    private static Material getRandomMaterial(HashMap<Integer, Material> map) {
        List<Integer> keys = new ArrayList<>(map.keySet());
        int randomIndex = new Random().nextInt(keys.size());
        return map.get(keys.get(randomIndex));
    }


}
