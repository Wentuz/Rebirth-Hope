package me.wentuziak.race2Szop;

import org.bukkit.NamespacedKey;

import java.lang.reflect.Field;

public class RaceKeys {
    public static final NamespacedKey RACE_BASIC = new NamespacedKey(Race2Szop.getInstance(), "BasicRace");
    public static final NamespacedKey RACE_GOAT = new NamespacedKey(Race2Szop.getInstance(), "GoatRace");
    public static final NamespacedKey RACE_GATITO = new NamespacedKey(Race2Szop.getInstance(), "GatitoRace");
    public static final NamespacedKey RACE_ENDERIAN = new NamespacedKey(Race2Szop.getInstance(), "EnderianRace");
    public static final NamespacedKey RACE_PARROT = new NamespacedKey(Race2Szop.getInstance(), "ParrotRace");
    public static final NamespacedKey RACE_SKELETON = new NamespacedKey(Race2Szop.getInstance(), "SkeletonRace");
    public static final NamespacedKey RACE_MERFOLK = new NamespacedKey(Race2Szop.getInstance(), "MerfolkRace");
    public static final NamespacedKey RACE_NETHER = new NamespacedKey(Race2Szop.getInstance(), "NetherRace");

    public static NamespacedKey[] getRaceKeys(){
        return new NamespacedKey[] {
                RACE_BASIC,
                RACE_GOAT,
                RACE_GATITO,
                RACE_ENDERIAN,
                RACE_PARROT,
                RACE_SKELETON,
                RACE_MERFOLK,
                RACE_NETHER
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
}
