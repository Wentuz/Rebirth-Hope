package me.wentuziak.race2Szop.playerEvents;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import java.util.Set;

import static me.wentuziak.race2Szop.RaceKeys.*;
import static me.wentuziak.race2Szop.races.Gatito.onGatitoRide;
import static me.wentuziak.race2Szop.races.Skelly.skellyMount;

public class PlayerInteractionManager {

    public static void playerRightClickLivingEntity(Player player, LivingEntity clickedEntity, Set<NamespacedKey> raceKey){

    }

    public static void playerMountEntity(Player player, LivingEntity clickedEntity, Set<NamespacedKey> raceKey){
        if(raceKey.contains(SKELETON_RACE)){
            skellyMount(clickedEntity);
        }
    }

}
