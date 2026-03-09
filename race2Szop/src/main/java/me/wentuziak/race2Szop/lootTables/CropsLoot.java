package me.wentuziak.race2Szop.lootTables;

import org.bukkit.Material;

import java.util.HashMap;

public class CropsLoot {

    public static final HashMap<Integer, Material> grassLoot = new HashMap<>();
    static {
        grassLoot.put(1, Material.CLAY_BALL);
        grassLoot.put(2, Material.GOLD_NUGGET);
        grassLoot.put(3, Material.CLAY);
        grassLoot.put(4, Material.FLINT);

    }

}
