package me.wentuziak.race2Szop.playerEvents;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;

import java.util.Set;

import static me.wentuziak.race2Szop.RaceKeys.ENDERIAN_RACE;
import static me.wentuziak.race2Szop.RaceKeys.GOAT_RACE;
import static me.wentuziak.race2Szop.races.Enderian.enderianInWater;
import static me.wentuziak.race2Szop.races.Goat.goatRam;

public class PlayerMoveManager {

    public static void playerMoved(Player player, Set<NamespacedKey> raceKey){
        if (raceKey.contains(ENDERIAN_RACE)){
            enderianInWater(player);
        }
    }

    public static void onSprintStart(Player player, Set<NamespacedKey> raceKey) {
        if (raceKey.contains(GOAT_RACE)) {
            goatRam(player);
        }
    }
}
