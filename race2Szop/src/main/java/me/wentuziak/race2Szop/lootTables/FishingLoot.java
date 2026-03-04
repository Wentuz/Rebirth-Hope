package me.wentuziak.race2Szop.lootTables;

import org.bukkit.Material;

import java.util.HashMap;

public class FishingLoot {

    private static final HashMap<Integer, Material> fishingTeasureLootCommon = new HashMap<>();
    static {
        fishingTeasureLootCommon.put(1, Material.COD);
        fishingTeasureLootCommon.put(2, Material.SALMON);
        fishingTeasureLootCommon.put(3, Material.PUFFERFISH);
        fishingTeasureLootCommon.put(4, Material.TROPICAL_FISH);
        fishingTeasureLootCommon.put(5, Material.INK_SAC);
        fishingTeasureLootCommon.put(6, Material.STRING);
        fishingTeasureLootCommon.put(7, Material.BOWL);
        fishingTeasureLootCommon.put(8, Material.BAMBOO);
        fishingTeasureLootCommon.put(9, Material.SEA_PICKLE);

    }
    private static final HashMap<Integer, Material> fishingTeasureLootRare = new HashMap<>();
    static {
        fishingTeasureLootRare.put(1, Material.NAUTILUS_SHELL);
        fishingTeasureLootRare.put(2, Material.PRISMARINE_SHARD);
        fishingTeasureLootRare.put(3, Material.PRISMARINE_CRYSTALS);
        fishingTeasureLootRare.put(4, Material.TROPICAL_FISH_BUCKET);
        fishingTeasureLootRare.put(5, Material.TURTLE_SCUTE);
        fishingTeasureLootRare.put(6, Material.EXPERIENCE_BOTTLE);
        fishingTeasureLootRare.put(7, Material.AXOLOTL_BUCKET);
        fishingTeasureLootRare.put(8, Material.BRAIN_CORAL);
        fishingTeasureLootRare.put(9, Material.TUBE_CORAL);
        fishingTeasureLootRare.put(10, Material.BUBBLE_CORAL);
        fishingTeasureLootRare.put(11, Material.FIRE_CORAL);
        fishingTeasureLootRare.put(11, Material.HORN_CORAL);
        fishingTeasureLootRare.put(12, Material.TUBE_CORAL_FAN);
        fishingTeasureLootRare.put(13, Material.BUBBLE_CORAL_FAN);
        fishingTeasureLootRare.put(14, Material.FIRE_CORAL_FAN);
        fishingTeasureLootRare.put(15, Material.HORN_CORAL_FAN);
        fishingTeasureLootRare.put(16, Material.BRAIN_CORAL_FAN);

    }

}
