package me.wentuziak.race2Szop.actions;

import org.bukkit.Particle;
import org.bukkit.entity.Player;

import static me.wentuziak.race2Szop.Logic.Effects.particleEmitterOnEntity;
import static me.wentuziak.race2Szop.actions.MovementActions.multiplyUpwardVelocity;

public class BootActions {

    public static void slimeBootsFall(Player player, double damage){
        particleEmitterOnEntity(player, Particle.ITEM_SLIME, 4, 4);
        if (damage > 2) damage = 2;
        multiplyUpwardVelocity(player, damage);
    }

    public static void explosionBootsFall(Player player){
        player.getWorld().createExplosion(player.getLocation(), 1, false, false);
    }

}
