package me.wentuziak.race2Szop.playerEvents;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import static me.wentuziak.race2Szop.RaceKeys.GATITO_RACE;
import static me.wentuziak.race2Szop.races.Gatito.onGatitoRide;

public class PlayerInteractionManager {

    public static void playerRightClickLivingEntity(Player player, LivingEntity clickedEntity, NamespacedKey raceKey){
        if (raceKey.equals(GATITO_RACE)){
            onGatitoRide(player, clickedEntity);
        }
    }

}
