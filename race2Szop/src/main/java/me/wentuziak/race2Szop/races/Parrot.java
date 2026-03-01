package me.wentuziak.race2Szop.races;

import me.wentuziak.race2Szop.actions.BarActions;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;

import static me.wentuziak.race2Szop.actions.MovementActions.*;

public class Parrot implements Race {
    NamespacedKey raceKey = Race.currentRaceKey("PARROT_RACE");

    public static void parrotFood(Player player){

    }

    public static void parrotFly(Player player){
        playerGlideTask(player);
    }

    public static void stopParrotFly(Player player){
        stopPlayerGlideTask(player);
    }

    public static void parrotSleep(Player player){

    }

    public static void parrotJump(Player player){
        addVelocityAtCursour(player,  (Race.checkCurrentLevel(player) / 0.8) + 0.5);
        BarActions.modifyPlayerHunger(player, -1);
    }

}
