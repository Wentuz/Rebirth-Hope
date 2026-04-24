package me.wentuziak.race2Szop.playerEvents;

import me.wentuziak.race2Szop.ItemKeys;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.Set;

import static me.wentuziak.race2Szop.RaceKeys.*;
import static me.wentuziak.race2Szop.items.SpecialFoodsManager.specialFoodManager;
import static me.wentuziak.race2Szop.races.Merfolk.merfolkDrinkPotion;
import static me.wentuziak.race2Szop.races.NetherFolk.netherFolkEat;
import static me.wentuziak.race2Szop.races.Parrot.parrotFood;

public class PlayerFoodConsumptionManager {


    public static void manageFoodConsumption(Player player, ItemStack itemStack, Set<NamespacedKey> raceKey){

        PersistentDataContainer foodContainer = itemStack.getItemMeta().getPersistentDataContainer();
        if (foodContainer.has(ItemKeys.SPECIAL_FOOD, PersistentDataType.BYTE)) {
            specialFoodManager(itemStack.getType(), player);
        }

        if (raceKey.contains(MERFOLK_RACE) && itemStack.getType() == Material.POTION){
            merfolkDrinkPotion(player);
        }
        if (raceKey.contains(NETHER_RACE)){
            netherFolkEat(player, itemStack);
        }
        if (raceKey.contains(PARROT_RACE)){
            parrotFood(player, itemStack.getType());
        }

    }


}
