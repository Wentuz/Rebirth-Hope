package me.wentuziak.race2Szop.playerEvents;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import static me.wentuziak.race2Szop.Logic.GetItemCategories.*;
import static me.wentuziak.race2Szop.lootTables.LootManager.*;
import static me.wentuziak.race2Szop.lootTables.LuckCalculator.*;

public class PlayerBreakBlockManager {

    public static ItemStack breakBlockManager(Player player, ItemStack drop, NamespacedKey raceKey, Material brokenBlock){
        ItemStack itemInMainHand = player.getInventory().getItemInMainHand();
        Material finalDrop = brokenBlock;
        // TODO :
        // > check Goat race for drops from leaves
        // > add toolKey for all drops

        if (randomInteger(10) <= getHandLuck(itemInMainHand)){

            if (isPickaxe(itemInMainHand.getType())){
                //TODO:
                //pickaxe more loot from ores
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
            if (isShovel(itemInMainHand.getType())){
                drop.setAmount(1 + randomInteger(getHandLuck(itemInMainHand)));
            } else if (!((brokenBlock.equals(Material.COBBLESTONE)) || isAxe(itemInMainHand.getType()))){
                drop.setAmount(drop.getAmount() + randomInteger(getLuckLevel(player) / 2));
            }

            drop.setType(brokenBlock);
        }



        return drop;
    }



}


