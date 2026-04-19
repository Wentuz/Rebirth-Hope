package me.wentuziak.race2Szop.items;

import org.bukkit.Particle;
import org.bukkit.entity.Player;

import static me.wentuziak.race2Szop.Logic.Effects.particleEmitterOnEntity;
import static me.wentuziak.race2Szop.actions.MovementActions.multiplyUpwardVelocity;

public class SlimeBoots {

    public static void slimeBootsFall(Player player, double damage){
        particleEmitterOnEntity(player, Particle.ITEM_SLIME, 4, 4);
        damage = damage / 5;
        multiplyUpwardVelocity(player, damage);
    }

}
