package me.wentuziak.race2Szop.playerEvents;

import me.wentuziak.race2Szop.races.Enderian;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;

import java.util.Set;

import static me.wentuziak.race2Szop.RaceKeys.ENDERIAN_RACE;
import static me.wentuziak.race2Szop.lootTables.LuckCalculator.randomInteger;

public class PlayerAttackManager {

    public static void playerGetHurt(Player player, Set<NamespacedKey> raceKey){
        if (raceKey.contains(ENDERIAN_RACE)){
            if (randomInteger(5) == 1) Enderian.onPlayerHurt(player);
        }
    }

}
