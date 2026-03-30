package me.wentuziak.race2Szop.playerEvents;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;

import java.util.Set;

import static me.wentuziak.race2Szop.RaceKeys.GOAT_RACE;
import static me.wentuziak.race2Szop.RaceKeys.PARROT_RACE;
import static me.wentuziak.race2Szop.races.Goat.goatJump;
import static me.wentuziak.race2Szop.races.Parrot.parrotFly;
import static me.wentuziak.race2Szop.races.Parrot.stopParrotFly;

public class PlayerSneakManager {

    public static void onSneakStart(Player player, Set<NamespacedKey> raceKey){
        //Double modifier = Gatito.cooldownModifier;

        if (raceKey.contains(PARROT_RACE)){
            stopParrotFly(player);
        }

    }

    public static void onSneakStop(Player player, Set<NamespacedKey> raceKey){
        if (raceKey.contains(PARROT_RACE)){
            parrotFly(player);
        } else if (raceKey.contains(GOAT_RACE)) {
            goatJump(player);
        }
    }

}
