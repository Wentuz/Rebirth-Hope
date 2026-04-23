package me.wentuziak.race2Szop.playerEvents;

import me.wentuziak.race2Szop.ItemKeys;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import static me.wentuziak.race2Szop.items.LuckyTool.luckyToolManager;
import static me.wentuziak.race2Szop.items.SpecialFoodsManager.specialFoodManager;

public class PlayerFoodConsumptionManager {


    public static void manageFoodConsumption(Player player, ItemStack itemStack){

        PersistentDataContainer foodContainer = itemStack.getItemMeta().getPersistentDataContainer();
        if (foodContainer.has(ItemKeys.SPECIAL_FOOD, PersistentDataType.BYTE)) {
            specialFoodManager(itemStack.getType(), player);
        }

    }


}
