package me.wentuziak.race2Szop.playerEvents;

import me.wentuziak.race2Szop.actions.MovementActions;
import me.wentuziak.race2Szop.races.Gatito;
import org.bukkit.entity.Player;

public class PlayerSneakManager {

    public static void onSneakStart(Player player){
        Double modifier = Gatito.cooldownModifier;
        player.sendMessage("Start sneak" + modifier);
        MovementActions.addVelocityAtCursour(player, 1.2);

    }

    public static void onSneakStop(Player player){
        player.sendMessage("Stop sneak");
        MovementActions.addVelocityAtCursour(player, 1.2);
    }

}
