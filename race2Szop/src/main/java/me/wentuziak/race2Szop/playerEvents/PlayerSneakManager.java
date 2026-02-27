package me.wentuziak.race2Szop.playerEvents;

import me.wentuziak.race2Szop.actions.MovementActions;
import org.bukkit.entity.Player;

public class PlayerSneakManager {

    public static void onSneakStart(Player player){
        player.sendMessage("Start sneak");
        MovementActions.addVelocityAtCursour(player, 1.2);
    }

    public static void onSneakStop(Player player){
        player.sendMessage("Stop sneak");
        MovementActions.addVelocityAtCursour(player, 1.2);
    }

}
