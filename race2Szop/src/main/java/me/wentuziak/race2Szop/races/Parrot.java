package me.wentuziak.race2Szop.races;

import me.wentuziak.race2Szop.Race2Szop;
import me.wentuziak.race2Szop.actions.BarActions;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

import static me.wentuziak.race2Szop.Logic.Effects.givePotionEffect;
import static me.wentuziak.race2Szop.Logic.Effects.particleEmitterOnEntity;
import static me.wentuziak.race2Szop.actions.BarActions.hurtPlayer;
import static me.wentuziak.race2Szop.actions.MovementActions.*;

public class Parrot implements Race {
    NamespacedKey raceKey = Race.currentRaceKey("PARROT_RACE");

    public static void parrotFood(Player player){

    }

    public static void parrotFly(Player player){
        playerGlideTask(player);
    }

    public static void stopParrotFly(Player player){
        givePotionEffect(player, PotionEffectType.SLOW_FALLING, 1, 0);
        stopPlayerGlideTask(player);
    }

    public static void parrotSleep(Player player){
        Location location = player.getLocation().clone();

        if (location.getBlockY() < 125){
            Bukkit.getScheduler().runTaskLater(Race2Szop.getInstance(), () -> {
                player.damage(1);
            },  1);
            player.sendMessage("You may not rest now, you are too low");
        }
    }

    public static void parrotJump(Player player){
        if (player.getFoodLevel() <= 0) return;

        addVelocityAtCursour(player,  (Race.checkCurrentLevel(player) / 0.8) + 0.5);
        BarActions.modifyPlayerHunger(player, -1);
        particleEmitterOnEntity(player, Particle.CLOUD, 1, 5, 0.1, 0.1, 0.1, 0.1);
    }

}
