package me.wentuziak.race2Szop.playerEvents;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import static me.wentuziak.race2Szop.Logic.GetItemCategories.isHoe;
import static me.wentuziak.race2Szop.Logic.GetItemCategories.isPickaxe;
import static me.wentuziak.race2Szop.lootTables.LootManager.*;
import static me.wentuziak.race2Szop.lootTables.LuckCalculator.*;

public class PlayerBreakBlockManager {

    public static ItemStack breakBlockManager(Player player, ItemStack drop, NamespacedKey raceKey, Material brokenBlock){
        ItemStack itemInMainHand = player.getInventory().getItemInMainHand();
        Material finalDrop = brokenBlock;
        // TODO :
        // > check Goat race for drops from leaves
        // > add toolKey for all drops

        //randomInteger(5)
        if (0 <= getHandLuck(itemInMainHand)){

            if (isPickaxe(itemInMainHand.getType())){
                brokenBlock = getPickAxeLootMaterial(brokenBlock);
            } else if (isHoe(itemInMainHand.getType())) {
                brokenBlock = getHoeLootMaterial(brokenBlock);
            }

            //check for errors
            if (finalDrop.equals(brokenBlock)) return drop;

            if (!(brokenBlock.equals(Material.COBBLESTONE))){
                drop.setAmount(drop.getAmount() + randomInteger(getLuckLevel(player)));
            }

            drop.setType(brokenBlock);

        }



        return drop;
    }



}


