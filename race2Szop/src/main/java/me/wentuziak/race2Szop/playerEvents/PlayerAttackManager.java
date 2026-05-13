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

import static me.wentuziak.race2Szop.ItemKeys.*;
import static me.wentuziak.race2Szop.RaceKeys.*;


import static me.wentuziak.race2Szop.items.BlazeBow.blazeBowShoot;
import static me.wentuziak.race2Szop.items.BlazeFlintNSteel.blazeFlintNSteelSwingAction;
import static me.wentuziak.race2Szop.lootTables.LuckCalculator.randomInteger;
import static me.wentuziak.race2Szop.races.Goat.goatRamAttack;
import static me.wentuziak.race2Szop.races.Skelly.skellyShootArrow;
import static me.wentuziak.race2Szop.races.Skelly.skellyShootRocket;

public class PlayerAttackManager {

    public static void playerGetHurt(Player player, Set<NamespacedKey> raceKey){
        if (raceKey.contains(ENDERIAN_RACE)){
            if (randomInteger(10) == 1) Enderian.onPlayerHurt(player);
        }
    }

    public static void playerHitLivingEntity(Player player, LivingEntity hitEntity, Set<NamespacedKey> raceKey){

        if (raceKey.contains(GOAT_RACE)){
            goatRamAttack(player, hitEntity);
        }
    }

    public static void playerShootBowManager(Player player, EntityShootBowEvent event, Set<NamespacedKey> raceKey){
        ItemStack usedBow = event.getBow();
        Projectile projectile = (Projectile) event.getProjectile();
        assert usedBow != null;
        PersistentDataContainer bowContainer = Objects.requireNonNull(usedBow.getItemMeta()).getPersistentDataContainer();

        if (bowContainer.has(MULTI_ATTACK_EFFECT)){
            event.getProjectile().getPersistentDataContainer().set(MULTI_ATTACK_EFFECT, PersistentDataType.BOOLEAN, true);
        }
        if (bowContainer.has(BLAZE_EFFECT)){
            blazeBowShoot(projectile);
        }

        if (raceKey.contains(SKELETON_RACE)){
            switch (projectile.getType()){
                case ARROW:
                    skellyShootArrow((Arrow) projectile);
                case FIREWORK_ROCKET:
                    skellyShootRocket((Firework) projectile);
            }
        }
    }

    public static void playerSwingAttackManager(Player player){
        ItemStack mainHandItem = player.getInventory().getItemInMainHand();
        ItemStack offHandItem = player.getInventory().getItemInOffHand();


        assert mainHandItem != null;
        PersistentDataContainer dataContainer;

        if (mainHandItem.hasItemMeta()) {
            dataContainer = Objects.requireNonNull(mainHandItem.getItemMeta()).getPersistentDataContainer();

            if (dataContainer.has(BLAZE_EFFECT)){
                blazeFlintNSteelSwingAction(player);
            }
        }

        assert offHandItem != null;
        if (offHandItem.hasItemMeta()) {
            dataContainer = Objects.requireNonNull(offHandItem.getItemMeta()).getPersistentDataContainer();

            if (dataContainer.has(BLAZE_EFFECT)){
                blazeFlintNSteelSwingAction(player);
            }
        }


    }
}
