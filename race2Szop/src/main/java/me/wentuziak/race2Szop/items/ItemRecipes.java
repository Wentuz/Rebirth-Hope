package me.wentuziak.race2Szop.items;

import me.wentuziak.race2Szop.Race2Szop;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
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

    }


}
