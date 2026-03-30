package me.wentuziak.race2Szop.lootTables;

import org.bukkit.Material;
import org.bukkit.block.Biome;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import static me.wentuziak.race2Szop.lootTables.CropsLoot.grassLoot;
import static me.wentuziak.race2Szop.lootTables.FishingLoot.*;
import static me.wentuziak.race2Szop.lootTables.MiningLoot.*;
import static me.wentuziak.race2Szop.lootTables.PiglinTrades.piglinTrade;

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
        return switch (material) {
            case Material.COAL_ORE, Material.DEEPSLATE_COAL_ORE -> Material.COAL;
            case Material.COPPER_ORE, Material.DEEPSLATE_COPPER_ORE -> Material.RAW_COPPER;
            case Material.IRON_ORE, Material.DEEPSLATE_IRON_ORE -> Material.RAW_IRON;
            case Material.GOLD_ORE, Material.DEEPSLATE_GOLD_ORE, Material.NETHER_GOLD_ORE -> Material.RAW_GOLD;
            case Material.REDSTONE_ORE, Material.DEEPSLATE_REDSTONE_ORE -> Material.REDSTONE_WIRE;
            case Material.DIAMOND_ORE, Material.DEEPSLATE_DIAMOND_ORE -> Material.DIAMOND;
            case Material.LAPIS_ORE, Material.DEEPSLATE_LAPIS_ORE -> Material.LAPIS_LAZULI;
            case Material.EMERALD_ORE, Material.DEEPSLATE_EMERALD_ORE -> Material.EMERALD;
            case Material.NETHER_QUARTZ_ORE -> Material.QUARTZ;

            default -> material;
        };
    }

    public static Material getShovelLootMaterial(Material material){
        return switch (material) {
            case Material.SAND -> getRandomMaterial(miningSand);
            case Material.GRAVEL -> getRandomMaterial(miningGravel);
            case Material.DIRT -> getRandomMaterial(miningDirt);

            default -> material;
        };
    }

    public static Material getHoeLootMaterial(Material material){
        if (material.equals(Material.SHORT_GRASS) || material.equals(Material.TALL_GRASS)
                || material.equals(Material.FERN) || material.equals(Material.TALL_DRY_GRASS)
                || material.equals(Material.SHORT_DRY_GRASS) || material.equals(Material.LARGE_FERN)
                || material.equals(Material.BUSH)) return getRandomMaterial(grassLoot);
        else if (material.equals(Material.OAK_LEAVES)) {
            return Material.GOLDEN_APPLE;
        } else if (material.equals(Material.CARROTS)) {
            return Material.GOLDEN_CARROT;
        } else if (material.equals(Material.MELON)) {
            return Material.GLISTERING_MELON_SLICE;
        }
        return material;
    }

    public static Material getAxeLootMaterial(Material material){
        return switch (material) {
            case Material.OAK_LOG -> Material.OAK_WOOD;
            case Material.DARK_OAK_LOG -> Material.DARK_OAK_LOG;
            case Material.BIRCH_LOG -> Material.BIRCH_WOOD;
            case Material.SPRUCE_LOG -> Material.SPRUCE_WOOD;
            case Material.JUNGLE_LOG -> Material.JUNGLE_WOOD;
            case Material.PALE_OAK_LOG -> Material.PALE_OAK_WOOD;
            case Material.MANGROVE_LOG -> Material.MANGROVE_WOOD;
            case Material.CHERRY_LOG -> Material.CHERRY_WOOD;
            case Material.ACACIA_LOG -> Material.ACACIA_WOOD;
            default -> material;
        };
    }

    public static Material getPiglinBarterLoot(){
        return getRandomMaterial(piglinTrade);
    }


    private static Material getRandomMaterial(HashMap<Integer, Material> map) {
        List<Integer> keys = new ArrayList<>(map.keySet());
        int randomIndex = new Random().nextInt(keys.size());
        return map.get(keys.get(randomIndex));
    }


}
