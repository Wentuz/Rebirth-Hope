package me.wentuziak.race2Szop.lootTables;

import org.bukkit.Material;

import java.util.HashMap;

public class PiglinTrades {

    public static final HashMap<Integer, Material> piglinTrade = new HashMap<>();
    static {
        piglinTrade.put(1, Material.CRIMSON_STEM);
        piglinTrade.put(2, Material.WARPED_STEM);
        piglinTrade.put(3, Material.WARPED_FUNGUS);
        piglinTrade.put(4, Material.CRIMSON_FUNGUS);
        piglinTrade.put(5, Material.WARPED_WART_BLOCK);
        piglinTrade.put(6, Material.NETHER_WART_BLOCK);
        piglinTrade.put(7, Material.CRIMSON_FUNGUS);
    }

}
