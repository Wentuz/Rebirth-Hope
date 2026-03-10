package me.wentuziak.race2Szop.lootTables;

import org.bukkit.Material;

import java.util.HashMap;

public class MiningLoot {
    public static final HashMap<Integer, Material> miningRocks = new HashMap<>();
    static {
        miningRocks.put(1, Material.COBBLESTONE);
        miningRocks.put(2, Material.QUARTZ);
    }

    public static final HashMap<Integer, Material> miningNetherrack = new HashMap<>();
    static {
        miningNetherrack.put(1, Material.QUARTZ);
        miningNetherrack.put(2, Material.GOLD_NUGGET);
    }

    public static final HashMap<Integer, Material> miningSand = new HashMap<>();
    static {
        miningSand.put(1, Material.SUSPICIOUS_SAND);
        miningSand.put(2, Material.GOLD_NUGGET);
        miningSand.put(3, Material.IRON_NUGGET);
        miningSand.put(4, Material.COPPER_NUGGET);
    }

    public static final HashMap<Integer, Material> miningGravel = new HashMap<>();
    static {
        miningGravel.put(1, Material.SUSPICIOUS_GRAVEL);
        miningGravel.put(2, Material.GOLD_NUGGET);
        miningGravel.put(3, Material.IRON_NUGGET);
        miningGravel.put(4, Material.COPPER_NUGGET);
    }

    public static final HashMap<Integer, Material> miningDirt = new HashMap<>();
    static {
        miningDirt.put(1, Material.COARSE_DIRT);
        miningDirt.put(2, Material.ROOTED_DIRT);
        miningDirt.put(3, Material.MUD);
        miningDirt.put(4, Material.CLAY);
    }

}
