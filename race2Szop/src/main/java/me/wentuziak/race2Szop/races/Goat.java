package me.wentuziak.race2Szop.races;

import me.wentuziak.race2Szop.Logic.Cooldowns;
import me.wentuziak.race2Szop.Race2Szop;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;

import java.util.Objects;

import static me.wentuziak.race2Szop.Logic.Checkers.isPlayerAboveGround;
import static me.wentuziak.race2Szop.Logic.Effects.givePotionEffect;
import static me.wentuziak.race2Szop.Logic.Effects.particleEmitterOnEntity;
import static me.wentuziak.race2Szop.actions.MovementActions.addVelocityAtCursour;
import static me.wentuziak.race2Szop.lootTables.LootManager.getHoeLootMaterial;

public class Goat implements Race {
    NamespacedKey raceKey = Race.currentRaceKey("GOAT_RACE");
    static Double cooldownModifier = 0.05;

    public static void goatBreakBlock(Location location ,Material brokenBlock){
        ItemStack itemStack = new ItemStack(getHoeLootMaterial(brokenBlock), 1);
        Item item = location.getWorld().dropItemNaturally(location, itemStack);
    }

    public static void goatJump(Player player){
        if(!Cooldowns.checkPlayerCooldown(player) && isPlayerAboveGround(player, 0.5)){
            addVelocityAtCursour(player, 1.5);
            player.playSound(player.getLocation(), Sound.ENTITY_GOAT_LONG_JUMP, 1.0f, 1.0f);
            particleEmitterOnEntity(player, Particle.SNOWFLAKE, 1, 3, 0.1, 0.1, 0.1, 0.1);

            Race.giveRaceCooldown(player, cooldownModifier);
        }
    }

    public static void goatRamAttack(Player player, LivingEntity attackedEntity){
        if (player.hasPotionEffect(PotionEffectType.SPEED)){
            Location location = attackedEntity.getLocation();

            for (int x = 0; x < 1; x++){
                Bukkit.getScheduler().runTaskLater(Race2Szop.getInstance(), () -> {
                    WindCharge windCharge = (WindCharge) Objects.requireNonNull(location.getWorld()).spawnEntity(location, EntityType.WIND_CHARGE);
                    windCharge.explode();
                },  2);
            }
        }
    }

    public static void goatRam(Player player){

        givePotionEffect(player, PotionEffectType.SPEED, 2, 0);
    }

}
