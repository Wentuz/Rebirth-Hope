package me.wentuziak.race2Szop.playerEvents;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;

import java.util.Set;

import static me.wentuziak.race2Szop.RaceKeys.*;
import static me.wentuziak.race2Szop.races.Enderian.throwPearlOrTeleport;
import static me.wentuziak.race2Szop.races.NetherFolk.netherFolkLevitation;
import static me.wentuziak.race2Szop.races.Parrot.parrotJump;

public class PlayerClapManager {

    public static void detectClapRace(Player player, Set<NamespacedKey> key){
        if (key.contains(ENDERIAN_RACE)){
            throwPearlOrTeleport(player);
        } else if (key.contains(PARROT_RACE)) {
            parrotJump(player);
        } else if (key.contains(NETHER_RACE)) {
            netherFolkLevitation(player);
        }
    }

}
