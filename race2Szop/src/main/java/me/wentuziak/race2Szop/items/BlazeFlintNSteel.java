package me.wentuziak.race2Szop.items;

import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import static me.wentuziak.race2Szop.ItemKeys.BLAZE_EFFECT;
import static me.wentuziak.race2Szop.Logic.Effects.randomFirework;


public class BlazeFlintNSteel {

    public static void blazeFlintNSteelSwingAction(Player player){

        Snowball snowball = player.launchProjectile(Snowball.class);

        snowball.getPersistentDataContainer().set(BLAZE_EFFECT, PersistentDataType.BOOLEAN, true);

        snowball.setFireTicks(20 * 10);
        snowball.setVisualFire(true);

        Vector direction = player.getLocation().getDirection().normalize();
        snowball.setVelocity(direction.multiply(1.2));
    }

    public static void blazeFlintNSteelOnImpact(Snowball snowball){
        randomFirework(1, snowball.getLocation()).detonate();
    }

}
