package me.wentuziak.race2Szop.Logic;

import org.bukkit.Material;

import java.util.EnumSet;
import java.util.Set;

public class GetItemCategories {

    public static final Set<Material> HEAD_ITEMS = EnumSet.of(
            Material.LEATHER_HELMET,
            Material.CHAINMAIL_HELMET,
            Material.IRON_HELMET,
            Material.GOLDEN_HELMET,
            Material.DIAMOND_HELMET,
            Material.NETHERITE_HELMET,
            Material.TURTLE_HELMET,
            Material.COPPER_HELMET
    );

    public static final Set<Material> BODY_ITEMS = EnumSet.of(
            Material.LEATHER_CHESTPLATE,
            Material.CHAINMAIL_CHESTPLATE,
            Material.IRON_CHESTPLATE,
            Material.GOLDEN_CHESTPLATE,
            Material.DIAMOND_CHESTPLATE,
            Material.NETHERITE_CHESTPLATE,
            Material.COPPER_CHESTPLATE
    );

    public static final Set<Material> LEGS_ITEMS = EnumSet.of(
            Material.LEATHER_LEGGINGS,
            Material.CHAINMAIL_LEGGINGS,
            Material.IRON_LEGGINGS,
            Material.GOLDEN_LEGGINGS,
            Material.DIAMOND_LEGGINGS,
            Material.NETHERITE_LEGGINGS,
            Material.COPPER_LEGGINGS
    );

    public static final Set<Material> BOOTS_ITEMS = EnumSet.of(
            Material.LEATHER_BOOTS,
            Material.CHAINMAIL_BOOTS,
            Material.IRON_BOOTS,
            Material.GOLDEN_BOOTS,
            Material.DIAMOND_BOOTS,
            Material.NETHERITE_BOOTS,
            Material.COPPER_BOOTS
    );

    public static final Set<Material> SWORDS = EnumSet.of(
            Material.WOODEN_SWORD,
            Material.STONE_SWORD,
            Material.IRON_SWORD,
            Material.GOLDEN_SWORD,
            Material.DIAMOND_SWORD,
            Material.NETHERITE_SWORD,
            Material.COPPER_SWORD
    );

    public static final Set<Material> AXES = EnumSet.of(
            Material.WOODEN_AXE,
            Material.STONE_AXE,
            Material.IRON_AXE,
            Material.GOLDEN_AXE,
            Material.DIAMOND_AXE,
            Material.NETHERITE_AXE,
            Material.COPPER_AXE
    );

    public static final Set<Material> PICKAXES = EnumSet.of(
            Material.WOODEN_PICKAXE,
            Material.STONE_PICKAXE,
            Material.IRON_PICKAXE,
            Material.GOLDEN_PICKAXE,
            Material.DIAMOND_PICKAXE,
            Material.NETHERITE_PICKAXE,
            Material.COPPER_PICKAXE

    );

    public static final Set<Material> HOES = EnumSet.of(
            Material.WOODEN_HOE,
            Material.STONE_HOE,
            Material.IRON_HOE,
            Material.GOLDEN_HOE,
            Material.DIAMOND_HOE,
            Material.NETHERITE_HOE,
            Material.COPPER_HOE

    );


    public static final Set<Material> SHOVELS = EnumSet.of(
            Material.WOODEN_SHOVEL,
            Material.STONE_SHOVEL,
            Material.IRON_SHOVEL,
            Material.GOLDEN_SHOVEL,
            Material.DIAMOND_SHOVEL,
            Material.NETHERITE_SHOVEL,
            Material.COPPER_SHOVEL

    );


    public static final Set<Material> FOODS = EnumSet.of(
            Material.BREAD,
            Material.CAKE,
            Material.COOKIE,
            Material.GOLDEN_APPLE,
            Material.GOLDEN_CARROT,
            Material.PUMPKIN_PIE,
            Material.RABBIT_STEW,
            Material.BEETROOT_SOUP,
            Material.MUSHROOM_STEW,
            Material.SUSPICIOUS_STEW
    );


    public static boolean isSword(Material material) {
        return SWORDS.contains(material);
    }

    public static boolean isShovel(Material material) {
        return SHOVELS.contains(material);
    }

    public static boolean isAxe(Material material) {
        return AXES.contains(material);
    }

    public static boolean isPickaxe(Material material) {
        return PICKAXES.contains(material);
    }

    public static boolean isHoe(Material material) {
        return HOES.contains(material);
    }

    public static boolean isHelmet(Material material) {
        return HEAD_ITEMS.contains(material);
    }

    public static boolean isChestplate(Material material) {
        return BODY_ITEMS.contains(material);
    }

    public static boolean isLeggings(Material material) {
        return LEGS_ITEMS.contains(material);
    }

    public static boolean isBoots(Material material) {
        return BOOTS_ITEMS.contains(material);
    }

    public static boolean isFood(Material material) {
        return FOODS.contains(material);
    }

}
