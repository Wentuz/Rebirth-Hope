package me.wentuziak.race2Szop.playerEvents;

import me.wentuziak.race2Szop.races.Enderian;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;

import java.util.Set;

import static me.wentuziak.race2Szop.RaceKeys.ENDERIAN_RACE;

public class PlayerFoodManager {

    public static void playerLooseHunger(Player player, Set<NamespacedKey> raceKey){
        if (raceKey.contains(ENDERIAN_RACE)){
            Enderian.onLooseHunger(player);
        }
    }

    public static void playerGainHunger(Player player, Set<NamespacedKey> raceKey){

    }

}
