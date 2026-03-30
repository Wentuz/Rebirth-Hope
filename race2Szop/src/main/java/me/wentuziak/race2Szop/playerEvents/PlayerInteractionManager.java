package me.wentuziak.race2Szop.playerEvents;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Piglin;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.Set;

import static me.wentuziak.race2Szop.Logic.Checkers.getNearestPlayer;
import static me.wentuziak.race2Szop.RaceKeys.*;
import static me.wentuziak.race2Szop.races.NetherFolk.piglinTradeOutcome;
import static me.wentuziak.race2Szop.races.Skelly.skellyMount;
import static org.bukkit.Bukkit.getLogger;

public class PlayerInteractionManager {

    public static void playerRightClickLivingEntity(Player player, LivingEntity clickedEntity, Set<NamespacedKey> raceKey){

    }

    public static void playerMountEntity(Player player, LivingEntity clickedEntity, Set<NamespacedKey> raceKey){
        if(raceKey.contains(SKELETON_RACE)){
            skellyMount(clickedEntity);
        }
    }


    public static void playerBarterManager(Piglin piglin, List<ItemStack> droppedItem){
        ItemStack firstItem = droppedItem.getFirst();

        Player nearestPlayer = getNearestPlayer(piglin.getLocation());
        Set<NamespacedKey> raceKey = getPlayerRaceKeySet(nearestPlayer);

        if (!raceKey.contains(NETHER_RACE)) return;

        ItemStack newLoot = piglinTradeOutcome(firstItem);

        if (newLoot.getType() != firstItem.getType()){
            droppedItem.clear();
            droppedItem.add(newLoot);
        }
    }

}
