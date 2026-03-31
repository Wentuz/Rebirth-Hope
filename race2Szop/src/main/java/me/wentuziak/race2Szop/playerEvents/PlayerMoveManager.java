package me.wentuziak.race2Szop.playerEvents;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;

import java.util.Set;

import static me.wentuziak.race2Szop.RaceKeys.*;
import static me.wentuziak.race2Szop.races.Enderian.enderianInWater;
import static me.wentuziak.race2Szop.races.Goat.goatRam;
import static me.wentuziak.race2Szop.races.Merfolk.onMerfolkStartSwim;
import static me.wentuziak.race2Szop.races.Skelly.burnSkellyOnSun;

public class PlayerMoveManager {

    public static void playerMoved(Player player, Set<NamespacedKey> raceKey){
        if (raceKey.contains(ENDERIAN_RACE)){
            enderianInWater(player);
        } else if (raceKey.contains(SKELETON_RACE)) {
            burnSkellyOnSun(player);
        }
    }

    public static void onSprintStart(Player player, Set<NamespacedKey> raceKey) {
        if (raceKey.contains(GOAT_RACE)) {
            goatRam(player);
        } else if (raceKey.contains(MERFOLK_RACE)) {
            onMerfolkStartSwim(player);
        }
    }
}
