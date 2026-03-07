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
        miningNetherrack.put(2, Material.QUARTZ);
        miningNetherrack.put(3, Material.GOLD_NUGGET);
    }

}
