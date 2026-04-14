package me.wentuziak.race2Szop.playerEvents;

import me.wentuziak.race2Szop.Race2Szop;
import me.wentuziak.race2Szop.races.Enderian;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.Objects;
import java.util.Set;

import static me.wentuziak.race2Szop.ItemKeys.BLAZE_EFFECT;
import static me.wentuziak.race2Szop.ItemKeys.MULTI_ATTACK_EFFECT;
import static me.wentuziak.race2Szop.RaceKeys.*;
import static me.wentuziak.race2Szop.actions.BowActions.blazeProjectile;
import static me.wentuziak.race2Szop.actions.CrossBowActions.ghastProjectile;
import static me.wentuziak.race2Szop.lootTables.LuckCalculator.randomInteger;
import static me.wentuziak.race2Szop.races.Goat.goatRamAttack;

public class PlayerAttackManager {

    public static void playerGetHurt(Player player, Set<NamespacedKey> raceKey){
        if (raceKey.contains(ENDERIAN_RACE)){
            if (randomInteger(5) == 1) Enderian.onPlayerHurt(player);
        }
    }

    public static void playerHitLivingEntity(Player player, LivingEntity hitEntity, Set<NamespacedKey> raceKey){

        if (raceKey.contains(GOAT_RACE)){
            goatRamAttack(player, hitEntity);
        }
    }

    public static void playerShootBowManager(Player player, EntityShootBowEvent event){
        ItemStack usedBow = event.getBow();
        Projectile projectile = (Projectile) event.getProjectile();
        assert usedBow != null;
        PersistentDataContainer bowContainer = Objects.requireNonNull(usedBow.getItemMeta()).getPersistentDataContainer();

        if (bowContainer.has(MULTI_ATTACK_EFFECT)){
            event.getProjectile().getPersistentDataContainer().set(MULTI_ATTACK_EFFECT, PersistentDataType.BOOLEAN, true);
        }
        if (bowContainer.has(BLAZE_EFFECT)){
            int delay;
            if (projectile.getType().equals(EntityType.FIREWORK_ROCKET)){
                delay = 2;
            } else {
                delay = 1;
            }

            Bukkit.getScheduler().runTaskLater(Race2Szop.getInstance(), () -> {
                if (delay != 1){
                    ghastProjectile(projectile);
                }else{
                    blazeProjectile(projectile);}
                },  delay);
        }
    }
}
