package me.wentuziak.race2Szop.lootTables;

import org.bukkit.Material;

import java.util.HashMap;

public class FishingLoot {

    public static final HashMap<Integer, Material> fishingRiver = new HashMap<>();
    static {
        fishingRiver.put(1, Material.CLAY_BALL);
        fishingRiver.put(2, Material.GOLD_NUGGET);
        fishingRiver.put(3, Material.CLAY);
        fishingRiver.put(4, Material.FLINT);

    }
    public static final HashMap<Integer, Material> fishingColdOcean = new HashMap<>();
    static {
        fishingColdOcean.put(1, Material.ICE);
        fishingColdOcean.put(2, Material.PRISMARINE_SHARD);
        fishingColdOcean.put(3, Material.PRISMARINE_CRYSTALS);
        fishingColdOcean.put(4, Material.INK_SAC);

    }
    public static final HashMap<Integer, Material> fishingFroznOcean = new HashMap<>();
    static {
        fishingFroznOcean.put(1, Material.ICE);
        fishingFroznOcean.put(2, Material.BLUE_ICE);
        fishingFroznOcean.put(3, Material.PACKED_ICE);
        fishingColdOcean.put(4, Material.INK_SAC);
    }

    public static final HashMap<Integer, Material> fishingWarmOcean = new HashMap<>();
    static {
        fishingWarmOcean.put(1, Material.BRAIN_CORAL);
        fishingWarmOcean.put(2, Material.BUBBLE_CORAL);
        fishingWarmOcean.put(3, Material.FIRE_CORAL);
        fishingWarmOcean.put(4, Material.HORN_CORAL);
        fishingWarmOcean.put(5, Material.TUBE_CORAL);
        fishingWarmOcean.put(6, Material.BRAIN_CORAL_FAN);
        fishingWarmOcean.put(7, Material.BUBBLE_CORAL_FAN);
        fishingWarmOcean.put(8, Material.FIRE_CORAL_FAN);
        fishingWarmOcean.put(9, Material.HORN_CORAL_FAN);
        fishingWarmOcean.put(10, Material.TUBE_CORAL_FAN);
        fishingWarmOcean.put(11, Material.BRAIN_CORAL_BLOCK);
        fishingWarmOcean.put(12, Material.BUBBLE_CORAL_BLOCK);
        fishingWarmOcean.put(13, Material.FIRE_CORAL_BLOCK);
        fishingWarmOcean.put(14, Material.HORN_CORAL_BLOCK);
        fishingWarmOcean.put(15, Material.TUBE_CORAL_BLOCK);
        fishingWarmOcean.put(16, Material.SEA_PICKLE);

    }

    public static final HashMap<Integer, Material> fishingDripstoneCave = new HashMap<>();
    static {
        fishingDripstoneCave.put(1, Material.POINTED_DRIPSTONE);
        fishingDripstoneCave.put(2, Material.DRIPSTONE_BLOCK);
        fishingDripstoneCave.put(3, Material.GLOW_INK_SAC);
    }
    public static final HashMap<Integer, Material> fishingDeepDark = new HashMap<>();
    static {
        fishingDeepDark.put(1, Material.SCULK);
        fishingDeepDark.put(2, Material.SCULK_VEIN);
        fishingDeepDark.put(3, Material.GLOW_INK_SAC);
        fishingDeepDark.put(4, Material.DEEPSLATE);
    }
    public static final HashMap<Integer, Material> fishingLushCave = new HashMap<>();
    static {
        fishingLushCave.put(1, Material.MOSS_BLOCK);
        fishingLushCave.put(2, Material.GLOW_BERRIES);
        fishingLushCave.put(3, Material.CLAY);
        fishingLushCave.put(4, Material.SPORE_BLOSSOM);
        fishingLushCave.put(5, Material.GLOW_LICHEN);
        fishingLushCave.put(6, Material.SMALL_DRIPLEAF);
        fishingLushCave.put(7, Material.AZALEA);
        fishingLushCave.put(8, Material.FLOWERING_AZALEA);
        fishingLushCave.put(9, Material.GLOW_INK_SAC);
    }

}
