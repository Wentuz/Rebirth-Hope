package me.wentuziak.race2Szop.playerEvents;

import me.wentuziak.race2Szop.actions.MovementActions;
import me.wentuziak.race2Szop.races.Gatito;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;

import static me.wentuziak.race2Szop.RaceKeys.GOAT_RACE;
import static me.wentuziak.race2Szop.RaceKeys.PARROT_RACE;
import static me.wentuziak.race2Szop.races.Goat.goatJump;
import static me.wentuziak.race2Szop.races.Parrot.parrotFly;
import static me.wentuziak.race2Szop.races.Parrot.stopParrotFly;

public class PlayerSneakManager {

    public static void onSneakStart(Player player, NamespacedKey raceKey){
        //Double modifier = Gatito.cooldownModifier;

        if (raceKey.equals(PARROT_RACE)){
            stopParrotFly(player);
        }

    }

    public static void onSneakStop(Player player, NamespacedKey raceKey){
        if (raceKey.equals(PARROT_RACE)){
            parrotFly(player);
        } else if (raceKey.equals(GOAT_RACE)) {
            goatJump(player);
        }
    }

}
