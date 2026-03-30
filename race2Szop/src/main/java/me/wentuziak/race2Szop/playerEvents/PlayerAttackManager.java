package me.wentuziak.race2Szop.playerEvents;

import me.wentuziak.race2Szop.races.Enderian;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import java.util.Set;

import static me.wentuziak.race2Szop.RaceKeys.*;
import static me.wentuziak.race2Szop.lootTables.LuckCalculator.randomInteger;
import static me.wentuziak.race2Szop.races.Goat.goatRamAttack;

public class PlayerAttackManager {

    public static void playerGetHurt(Player player, Set<NamespacedKey> raceKey){
        if (raceKey.contains(ENDERIAN_RACE)){
            if (randomInteger(5) == 1) Enderian.onPlayerHurt(player);
        }
    }

    public static void playerHitLivingEntity(Player player, LivingEntity hitEntity, Set<NamespacedKey> raceKey){

        if (raceKey.contains(GOAT_RACE)){
            goatRamAttack(player, hitEntity);
        }

    }

}
