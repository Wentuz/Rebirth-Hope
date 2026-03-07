package me.wentuziak.race2Szop.playerEvents;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import static me.wentuziak.race2Szop.Logic.GetItemCategories.isPickaxe;
import static me.wentuziak.race2Szop.lootTables.LootManager.getLootMaterial;

public class PlayerBreakBlockManager {

    public static ItemStack breakBlockManager(Player player, ItemStack drop, NamespacedKey raceKey, Block brokenBlock){

        ItemStack itemInMainHand = player.getInventory().getItemInMainHand();
        Material material = brokenBlock.getType();
        

        if (isPickaxe(itemInMainHand.getType())){
            material = getLootMaterial(material);
            player.sendMessage("stop at 3");

        }
        
        drop.setType(material);
        player.sendMessage("stop at 4");

        return drop;
    }



}


