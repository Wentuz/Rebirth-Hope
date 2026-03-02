package me.wentuziak.race2Szop.races;

import me.wentuziak.race2Szop.Logic.Cooldowns;
import org.bukkit.NamespacedKey;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import static me.wentuziak.race2Szop.Logic.Checkers.isPlayerAboveGround;
import static me.wentuziak.race2Szop.Logic.Effects.particleEmitterOnEntity;
import static me.wentuziak.race2Szop.actions.MovementActions.addVelocityAtCursour;

public class Goat implements Race {
    NamespacedKey raceKey = Race.currentRaceKey("GOAT_RACE");
    static Double cooldownModifier = 0.05;

    public static void goatBreakBlock(Player player, Block brokenBlock){
        //flowers, leaves, grass
    }

    public static void goatJump(Player player){
        if(!Cooldowns.checkPlayerCooldown(player) && isPlayerAboveGround(player, 0.5)){
            addVelocityAtCursour(player, 1.5);
            player.playSound(player.getLocation(), Sound.ENTITY_GOAT_LONG_JUMP, 1.0f, 1.0f);
            particleEmitterOnEntity(player, Particle.SNOWFLAKE, 1, 3, 0.1, 0.1, 0.1, 0.1);

            Race.giveRaceCooldown(player, cooldownModifier);
        }
    }

    public static void goatRam(Player player){
        //speed at started sprinting



        //first few seconds give bonus to firts attack & massive knockback
    }

}
