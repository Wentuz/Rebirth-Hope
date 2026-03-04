package me.wentuziak.race2Szop.playerEvents;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.ItemStack;

import static me.wentuziak.race2Szop.RaceKeys.GATITO_RACE;
import static me.wentuziak.race2Szop.lootTables.LuckCalculator.getLuckLevel;
import static me.wentuziak.race2Szop.races.Gatito.onGatitoFish;

public class PlayerFishingManager {

    public static ItemStack onPlayerCatchFish(Player player, NamespacedKey raceKey, ItemStack caughtFish){

        if (raceKey.equals(GATITO_RACE)){
            onGatitoFish(player);
        }
        player.sendMessage("luck: " + getLuckLevel(player));

        return caughtFish;
    }

}
