package me.wentuziak.race2Szop.items;

import me.wentuziak.race2Szop.Race2Szop;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;

import java.util.ArrayList;
import java.util.List;

public class ItemRecipes {

    private static List<NamespacedKey> recipeKeys = new ArrayList<>();

    public static List<NamespacedKey> getRecipeKeys() {
        return recipeKeys;
    }

    public static void register(){

        NamespacedKey key;

        //------------------------------------------------------------------------------------
        //                                     PICKAXES
        //------------------------------------------------------------------------------------

        //
        //      Hasty Pick Recipe
        //
        ItemStack quickPick = ItemCrafting.createQuickPick();
        key = new NamespacedKey(Race2Szop.getInstance(), "QuickPickRecipe");
        recipeKeys.add(key);

        ShapedRecipe quickPickRecipe = new ShapedRecipe(key, quickPick);
        quickPickRecipe.shape(
                "GUG",
                " B ",
                " B ");
        quickPickRecipe.setIngredient('B', Material.BLAZE_ROD);
        quickPickRecipe.setIngredient('G', Material.GOLD_INGOT);
        quickPickRecipe.setIngredient('U', Material.NETHERITE_UPGRADE_SMITHING_TEMPLATE);
        Bukkit.addRecipe(quickPickRecipe);


        //
        //      Lucky Pick Recipe
        //
        ItemStack luckyPick = ItemCrafting.createLuckyPick();
        key = new NamespacedKey(Race2Szop.getInstance(), "LuckyPickRecipe");
        recipeKeys.add(key);

        ShapedRecipe luckyPickRecipe = new ShapedRecipe(key, luckyPick);
        luckyPickRecipe.shape(
                "NDN",
                " E ",
                " E ");
        luckyPickRecipe.setIngredient('E', Material.END_ROD);
        luckyPickRecipe.setIngredient('N', Material.NETHERITE_INGOT);
        luckyPickRecipe.setIngredient('D', Material.DRAGON_BREATH);
        Bukkit.addRecipe(luckyPickRecipe);

        //------------------------------------------------------------------------------------
        //                                     AXES
        //------------------------------------------------------------------------------------

        //
        //      Lucky Axe Recipe
        //
        ItemStack luckyAxe = ItemCrafting.createLuckyAxe();
        key = new NamespacedKey(Race2Szop.getInstance(), "LuckyAxeRecipe");
        recipeKeys.add(key);

        ShapedRecipe luckyAxeRecipe = new ShapedRecipe(key, luckyAxe);
        luckyAxeRecipe.shape(
                "ND ",
                "NE ",
                " E ");
        luckyAxeRecipe.setIngredient('E', Material.END_ROD);
        luckyAxeRecipe.setIngredient('N', Material.NETHERITE_INGOT);
        luckyAxeRecipe.setIngredient('D', Material.DRAGON_BREATH);
        Bukkit.addRecipe(luckyAxeRecipe);

        //
        //      Quick Axe Recipe
        //
        ItemStack quickAxe = ItemCrafting.createQuickAxe();
        key = new NamespacedKey(Race2Szop.getInstance(), "QuickAxeRecipe");
        recipeKeys.add(key);

        ShapedRecipe quickAxeRecipe = new ShapedRecipe(key, quickAxe);
        quickAxeRecipe.shape(
                "GU ",
                "GB ",
                " B ");
        quickAxeRecipe.setIngredient('B', Material.BLAZE_ROD);
        quickAxeRecipe.setIngredient('G', Material.GOLD_INGOT);
        quickAxeRecipe.setIngredient('U', Material.NETHERITE_UPGRADE_SMITHING_TEMPLATE);
        Bukkit.addRecipe(quickAxeRecipe);

        //------------------------------------------------------------------------------------
        //                                     HOES
        //------------------------------------------------------------------------------------

        //
        //      Lucky Hoe Recipe
        //
        ItemStack luckyHoe = ItemCrafting.createLuckyHoe();
        key = new NamespacedKey(Race2Szop.getInstance(), "LuckyHoeRecipe");
        recipeKeys.add(key);

        ShapedRecipe luckyHoeRecipe = new ShapedRecipe(key, luckyHoe);
        luckyHoeRecipe.shape(
                "ND ",
                " E ",
                " E ");
        luckyHoeRecipe.setIngredient('E', Material.END_ROD);
        luckyHoeRecipe.setIngredient('D', Material.DRAGON_BREATH);
        luckyHoeRecipe.setIngredient('N', Material.NETHERITE_INGOT);
        Bukkit.addRecipe(luckyHoeRecipe);

        //------------------------------------------------------------------------------------
        //                                     SHOVELS
        //------------------------------------------------------------------------------------

        //
        //      Lucky Shovel Recipe
        //
        ItemStack luckyShovel = ItemCrafting.createLuckyShovel();
        key = new NamespacedKey(Race2Szop.getInstance(), "LuckyShovelRecipe");
        recipeKeys.add(key);

        ShapedRecipe luckyShovelRecipe = new ShapedRecipe(key, luckyShovel);
        luckyShovelRecipe.shape(
                " N ",
                " E ",
                " E ");
        luckyShovelRecipe.setIngredient('E', Material.END_ROD);
        luckyShovelRecipe.setIngredient('N', Material.NETHERITE_INGOT);
        Bukkit.addRecipe(luckyShovelRecipe);

        //------------------------------------------------------------------------------------
        //                                     SWORDS
        //------------------------------------------------------------------------------------

        //------------------------------------------------------------------------------------
        //                                     BOWS
        //------------------------------------------------------------------------------------

        //
        //      Multi Attack Bow Recipe
        //
        ItemStack multiAttackBow = ItemCrafting.createMultiAttackBow();
        key = new NamespacedKey(Race2Szop.getInstance(), "MultiAttackBowRecipe");
        recipeKeys.add(key);

        ShapedRecipe multiAttackBowRecipe = new ShapedRecipe(key, multiAttackBow);
        multiAttackBowRecipe.shape(
                "SW ",
                "S T",
                "SW ");
        multiAttackBowRecipe.setIngredient('S', Material.STRING);
        multiAttackBowRecipe.setIngredient('W', Material.STICK);
        multiAttackBowRecipe.setIngredient('T', Material.TRIPWIRE_HOOK);
        Bukkit.addRecipe(multiAttackBowRecipe);
        //------------------------------------------------------------------------------------
        //                                     CROSSBOWS
        //------------------------------------------------------------------------------------

        //
        //      Multi Attack CrossBow Recipe
        //
        ItemStack multiAttackCrossBow = ItemCrafting.createMultiAttackCrossBow();
        key = new NamespacedKey(Race2Szop.getInstance(), "MultiAttackCrossBowRecipe");
        recipeKeys.add(key);

        ShapedRecipe multiAttackCrossBowRecipe = new ShapedRecipe(key, multiAttackCrossBow);
        multiAttackCrossBowRecipe.shape(
                "SDS",
                " C ",
                "   ");
        multiAttackCrossBowRecipe.setIngredient('C', Material.CROSSBOW);
        multiAttackCrossBowRecipe.setIngredient('D', Material.DISPENSER);
        multiAttackCrossBowRecipe.setIngredient('S', Material.STICK);
        Bukkit.addRecipe(multiAttackCrossBowRecipe);

        //
        //      Blaze CrossBow Recipe
        //
        ItemStack blazeCrossBow = ItemCrafting.createBlazeCrossBow();
        key = new NamespacedKey(Race2Szop.getInstance(), "BlazeCrossBowRecipe");
        recipeKeys.add(key);

        ShapedRecipe blazeCrossBowRecipe = new ShapedRecipe(key, blazeCrossBow);
        blazeCrossBowRecipe.shape(
                "BFB",
                " C ",
                "   ");
        blazeCrossBowRecipe.setIngredient('C', Material.CROSSBOW);
        blazeCrossBowRecipe.setIngredient('F', Material.FIRE_CHARGE);
        blazeCrossBowRecipe.setIngredient('B', Material.BLAZE_ROD);
        Bukkit.addRecipe(blazeCrossBowRecipe);

    }


}
