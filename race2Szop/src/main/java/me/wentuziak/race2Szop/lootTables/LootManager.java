package me.wentuziak.race2Szop.lootTables;

import org.bukkit.Material;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class LootManager {


    private static Material getRandomMaterial(HashMap<Integer, Material> map) {
        List<Integer> keys = new ArrayList<>(map.keySet());
        int randomIndex = new Random().nextInt(keys.size());
        return map.get(keys.get(randomIndex));
    }


}
