package me.wentuziak.race2Szop.playerEvents;

import me.wentuziak.race2Szop.RaceKeys;
import me.wentuziak.race2Szop.races.Enderian;
import org.bukkit.NamespacedKey;
import org.bukkit.block.data.type.Switch;
import org.bukkit.entity.Player;

import static me.wentuziak.race2Szop.RaceKeys.ENDERIAN_RACE;
import static me.wentuziak.race2Szop.RaceKeys.PARROT_RACE;
import static me.wentuziak.race2Szop.races.Enderian.throwPearlOrTeleport;
import static me.wentuziak.race2Szop.races.Parrot.parrotJump;

public class PlayerClapManager {

    public static void detectClapRace(Player player, NamespacedKey key){
        if (key.equals(ENDERIAN_RACE)){
            throwPearlOrTeleport(player);
        } else if (key.equals(PARROT_RACE)) {
            parrotJump(player);
        } else{
            return;
        }

    }

}
