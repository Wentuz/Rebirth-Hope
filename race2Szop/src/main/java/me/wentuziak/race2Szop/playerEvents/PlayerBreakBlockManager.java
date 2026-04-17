package me.wentuziak.race2Szop.playerEvents;

import me.wentuziak.race2Szop.ItemKeys;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.Set;

import static me.wentuziak.race2Szop.Logic.GetItemCategories.*;
import static me.wentuziak.race2Szop.RaceKeys.GOAT_RACE;
import static me.wentuziak.race2Szop.items.LuckyTool.luckyToolManager;
import static me.wentuziak.race2Szop.lootTables.LootManager.*;
import static me.wentuziak.race2Szop.lootTables.LuckCalculator.*;
import static me.wentuziak.race2Szop.races.Goat.goatBreakBlock;

public class PlayerBreakBlockManager {

    public static ItemStack breakBlockManager(Player player, ItemStack drop, Set<NamespacedKey> raceKey, Material brokenBlock){
        ItemStack itemInMainHand = player.getInventory().getItemInMainHand();
        Material finalDrop = brokenBlock;
        // TODO :
        // > check Goat race for drops from leaves
        // > add toolKey for all drops
        // > check impact of luck on drops

        PersistentDataContainer playerContainer = itemInMainHand.getItemMeta().getPersistentDataContainer();
        if (playerContainer.has(ItemKeys.LUCKY_TOOL, PersistentDataType.BYTE)) {
            luckyToolManager(itemInMainHand, finalDrop, brokenBlock, drop, player);
        }

        return drop;
    }



}


