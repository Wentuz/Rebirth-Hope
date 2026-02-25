package me.wentuziak.race2Szop;

import org.bukkit.NamespacedKey;

import java.lang.reflect.Field;
import java.util.List;

public class RaceKeys {
    public static final NamespacedKey BASIC_RACE = new NamespacedKey(Race2Szop.getInstance(), "BasicRace");
    public static final NamespacedKey GOAT_RACE = new NamespacedKey(Race2Szop.getInstance(), "GoatRace");
    public static final NamespacedKey GATITO_RACE = new NamespacedKey(Race2Szop.getInstance(), "GatitoRace");
    public static final NamespacedKey ENDERIAN_RACE = new NamespacedKey(Race2Szop.getInstance(), "EnderianRace");
    public static final NamespacedKey PARROT_RACE = new NamespacedKey(Race2Szop.getInstance(), "ParrotRace");
    public static final NamespacedKey SKELETON_RACE = new NamespacedKey(Race2Szop.getInstance(), "SkeletonRace");
    public static final NamespacedKey MERFOLK_RACE = new NamespacedKey(Race2Szop.getInstance(), "MerfolkRace");
    public static final NamespacedKey NETHER_RACE = new NamespacedKey(Race2Szop.getInstance(), "NetherRace");

    // race levels, remove when swapping race
    // add when advancing
    public static final NamespacedKey BASE_UPGRADE = new NamespacedKey(Race2Szop.getInstance(), "BaseUpgrade");
    public static final NamespacedKey ADVANCED_UPGRADE = new NamespacedKey(Race2Szop.getInstance(), "AdvancedUpgrade");


    public static NamespacedKey[] getRaceKeys(){
        return new NamespacedKey[] {
                BASIC_RACE,
                GOAT_RACE,
                GATITO_RACE,
                ENDERIAN_RACE,
                PARROT_RACE,
                SKELETON_RACE,
                MERFOLK_RACE,
                NETHER_RACE
        };
    }

    public static NamespacedKey getKeyByName(String keyName) {
        try {
            Field field = RaceKeys.class.getField(keyName);
            return (NamespacedKey) field.get(null);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<String> getRaceList(){
        return java.util.Arrays.asList(
                "goat", "gatito", "enderian", "parrot",
                "skeleton", "merfolk", "nerher"
        );
    }

    public static int getRaceId(String keyName){
        int id = 0;



        return id;
    }
}
