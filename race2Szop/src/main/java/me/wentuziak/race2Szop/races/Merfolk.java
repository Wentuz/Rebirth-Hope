package me.wentuziak.race2Szop.races;

import me.wentuziak.race2Szop.Logic.Cooldowns;
import me.wentuziak.race2Szop.actions.BarActions;
import org.bukkit.NamespacedKey;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityAirChangeEvent;
import org.bukkit.potion.PotionEffectType;

import static me.wentuziak.race2Szop.Logic.Checkers.isPlayerWet;
import static me.wentuziak.race2Szop.Logic.Effects.givePotionEffect;
import static me.wentuziak.race2Szop.Logic.Effects.particleEmitterOnEntity;
import static me.wentuziak.race2Szop.actions.MovementActions.addVelocityAtCursour;

public class Merfolk implements Race {
    NamespacedKey raceKey = Race.currentRaceKey("MERFOLK_RACE");

    public static void onChangeRaceToMerfolk(Player player){
        player.setRemainingAir(250);
    }

    public static void merfolkBreathe(Player player, EntityAirChangeEvent event){

        int eventAir = event.getAmount();
        int playerAir = player.getRemainingAir();

        //todo:
        // everything
//        if (isPlayerWet(player)){
//            if (eventAir > playerAir)
//        }else{
//            if ()
//        }

    }

    public static void onConduitClick(Player player){
        if (Cooldowns.checkPlayerCooldown(player)) return;


        player.getWorld().setThundering(true);
        givePotionEffect(player, PotionEffectType.DOLPHINS_GRACE, 60 * 4, 0);

        Race.giveRaceCooldown(player, cooldownModifier);

    }

    public static void onMerfolkStartSwim(Player player){
        givePotionEffect(player, PotionEffectType.DOLPHINS_GRACE, 4, 0);

        merfolkRiptide(player);
    }

    public static void merfolkRiptide(Player player){
        addVelocityAtCursour(player, 1.5);
        player.playSound(player.getLocation(), Sound.ITEM_TRIDENT_RIPTIDE_1, 1.0f, 1.0f);
        particleEmitterOnEntity(player, Particle.BUBBLE, 1, 3, 0.1, 0.1, 0.1, 0.1);

    }

}
