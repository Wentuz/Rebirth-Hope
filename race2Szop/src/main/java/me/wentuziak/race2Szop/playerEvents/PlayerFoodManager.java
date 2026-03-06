package me.wentuziak.race2Szop.playerEvents;

import me.wentuziak.race2Szop.races.Enderian;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;

import static me.wentuziak.race2Szop.RaceKeys.ENDERIAN_RACE;

public class PlayerFoodManager {

    public static void playerLooseHunger(Player player, NamespacedKey raceKey){
        if (raceKey.equals(ENDERIAN_RACE)){
            Enderian.onLooseHunger(player);
        }
    }

    public static void playerGainHunger(Player player, NamespacedKey raceKey){

    }

}
