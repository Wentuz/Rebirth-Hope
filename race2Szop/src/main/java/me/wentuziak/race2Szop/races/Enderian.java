package me.wentuziak.race2Szop.races;

import me.wentuziak.race2Szop.Logic.Cooldowns;
import me.wentuziak.race2Szop.RaceKeys;
import me.wentuziak.race2Szop.actions.BarActions;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import static me.wentuziak.race2Szop.Logic.Checkers.*;
import static me.wentuziak.race2Szop.actions.BarActions.hurtPlayer;
import static me.wentuziak.race2Szop.actions.BarActions.modifyPlayerHealthBar;

public class Enderian implements Race{

    static NamespacedKey raceKey = Race.currentRaceKey("ENDERIAN_RACE");
    static double cooldownModifier = 0.5;


    public static void throwPearlOrTeleport(Player player){
        if (Cooldowns.checkPlayerCooldown(player)) return;

        if(Race.checkCurrentLevel(player) == 0){
            dropEnderPearl(player);
        };

        BarActions.modifyPlayerHunger(player, -2);
        Race.giveRaceCooldown(player, cooldownModifier);
    }

    public static void dropEnderPearl(Player player){
        player.getWorld().dropItemNaturally(player.getLocation(), new ItemStack(Material.ENDER_PEARL, 1));
        player.playSound(player.getLocation(), Sound.ENTITY_CHICKEN_EGG, 1.0f, 1.0f);
    }

    public static void throwEndPearl(Player player){

    }

    public static void enderianInWater(Player player){

        if (isPlayerWet(player) && !player.hasCooldown(Material.DOLPHIN_SPAWN_EGG)){
            hurtPlayer(player, -1, Sound.ENTITY_PLAYER_HURT_DROWN);

            onPlayerHurt(player);

            player.setCooldown(Material.DOLPHIN_SPAWN_EGG, 10);
        }
    }

    public static void onPlayerHurt(Player player){

    }

    public static void onLooseHunger(Player player){
        dropEnderPearl(player);
    }

    public static void skillTeleportation(Player player){

    }



}
