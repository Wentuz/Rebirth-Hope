package me.wentuziak.race2Szop.races;

import me.wentuziak.race2Szop.Logic.Cooldowns;
import me.wentuziak.race2Szop.actions.BarActions;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityAirChangeEvent;
import org.bukkit.potion.PotionEffectType;

import static me.wentuziak.race2Szop.Logic.Checkers.isPlayerHiddenFromSun;
import static me.wentuziak.race2Szop.Logic.Checkers.isPlayerWet;
import static me.wentuziak.race2Szop.Logic.Effects.givePotionEffect;
import static me.wentuziak.race2Szop.Logic.Effects.particleEmitterOnEntity;
import static me.wentuziak.race2Szop.actions.BarActions.hurtPlayer;
import static me.wentuziak.race2Szop.actions.MovementActions.addVelocityAtCursour;

public class Merfolk implements Race {
    NamespacedKey raceKey = Race.currentRaceKey("MERFOLK_RACE");

    public static void onChangeRaceToMerfolk(Player player){
        player.setRemainingAir(250);
    }

    public static void merfolkBreathe(Player player, EntityAirChangeEvent event){


        int eventAir = event.getAmount();
        int playerAir = player.getRemainingAir();


        int difference = eventAir - playerAir;

        if (player.hasPotionEffect(PotionEffectType.WATER_BREATHING) && playerAir < 295) return;

        if (isPlayerWet(player)){
            if (!isPlayerHiddenFromSun(player) && (player.getWorld().hasStorm() || player.getWorld().isThundering())) {
                givePotionEffect(player, PotionEffectType.WATER_BREATHING, 15, 1);
            }
            if (difference > 0) {
                if (playerAir >= 0) {
                    event.setAmount(eventAir - 5);
                }
                if (playerAir <= 5){
                    merfolkNoAir(player);
                }
            }
            else {
                if (playerAir < 295){
                    event.setAmount(eventAir + 5);
                }
            }
        }else{
            if (!isPlayerHiddenFromSun(player) && (player.getWorld().hasStorm() || player.getWorld().isThundering())) {
                givePotionEffect(player, PotionEffectType.WATER_BREATHING, 15, 1);
            }
            if (difference > 0) {
                if (playerAir >= 0) {
                    event.setAmount(eventAir - 5);
                }
                if (playerAir <= 5){
                    merfolkNoAir(player);
                }
            }
        }
    }

    private static void merfolkNoAir(Player player){
        if (!player.hasCooldown(Material.DOLPHIN_SPAWN_EGG)){
            hurtPlayer(player, -1, Sound.ENTITY_PLAYER_HURT_DROWN);

            player.setCooldown(Material.DOLPHIN_SPAWN_EGG, 20);
        }
    }

    public static void onConduitClick(Player player){
        if (Cooldowns.checkPlayerCooldown(player)) return;


        player.getWorld().setThundering(true);
        givePotionEffect(player, PotionEffectType.DOLPHINS_GRACE, 60 * 4, 0);

        Race.giveRaceCooldown(player, cooldownModifier);

    }

    public static void onMerfolkStartSwim(Player player){
        if (!isPlayerWet(player)) return;
        givePotionEffect(player, PotionEffectType.DOLPHINS_GRACE, 4, 0);

        merfolkRiptide(player);
    }

    public static void merfolkRiptide(Player player){
        addVelocityAtCursour(player, 1.5);
        player.playSound(player.getLocation(), Sound.ITEM_TRIDENT_RIPTIDE_1, 1.0f, 1.0f);
        particleEmitterOnEntity(player, Particle.BUBBLE, 1, 3, 0.1, 0.1, 0.1, 0.1);

    }

    public static void merfolkDrinkPotion(Player player){
        if (!player.hasPotionEffect(PotionEffectType.WATER_BREATHING)){
            givePotionEffect(player, PotionEffectType.WATER_BREATHING, 10, 0);
            particleEmitterOnEntity(player, Particle.BUBBLE, 2, 2, 0.01, 0.5, 0.01, 0.01);
        }
    }

}
