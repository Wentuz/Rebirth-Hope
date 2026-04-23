package me.wentuziak.race2Szop.items;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import static me.wentuziak.race2Szop.Logic.GetItemCategories.*;
import static me.wentuziak.race2Szop.Logic.GetItemCategories.isAxe;
import static me.wentuziak.race2Szop.Logic.GetItemCategories.isShovel;
import static me.wentuziak.race2Szop.lootTables.LootManager.*;
import static me.wentuziak.race2Szop.lootTables.LootManager.getShovelLootMaterial;
import static me.wentuziak.race2Szop.lootTables.LuckCalculator.*;
import static me.wentuziak.race2Szop.lootTables.LuckCalculator.getHandLuck;

public class LuckyTool {

    public static ItemStack luckyToolManager(ItemStack itemInMainHand, Material finalDrop, Material brokenBlock, ItemStack drop, Player player){
        if (randomInteger(10) <= getHandLuck(itemInMainHand)) {

            if (isPickaxe(itemInMainHand.getType())) {
                brokenBlock = getPickAxeLootMaterial(brokenBlock);
            } else if (isHoe(itemInMainHand.getType())) {
                brokenBlock = getHoeLootMaterial(brokenBlock);
            } else if (isAxe(itemInMainHand.getType())) {
                brokenBlock = getAxeLootMaterial(brokenBlock);
            } else if (isShovel(itemInMainHand.getType())) {
                brokenBlock = getShovelLootMaterial(brokenBlock);
            }


            //check for errors or not valid drops, excluding crops
            if (finalDrop.equals(brokenBlock) &&
                    !(finalDrop.equals(Material.WHEAT) || finalDrop.equals(Material.CARROTS)
                            || finalDrop.equals(Material.POTATOES)) || finalDrop.equals(Material.BEETROOTS)) {
                return drop;
            }

            // how much of loot drops
            if (isShovel(itemInMainHand.getType())) {
                drop.setAmount(1 + randomInteger(getHandLuck(itemInMainHand)));
            } else if (!((brokenBlock.equals(Material.QUARTZ_BLOCK)) || isAxe(itemInMainHand.getType()))) {
                drop.setAmount(drop.getAmount() + (randomInteger(getLuckLevel(player)) /2 ) + getHandLuck(itemInMainHand));
            }

            drop.setType(brokenBlock);
            return drop;
        }
        return drop;
    }

}
