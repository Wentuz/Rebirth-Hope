package me.wentuziak.race2Szop.playerEvents;

import me.wentuziak.race2Szop.races.Enderian;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;

import java.util.Objects;
import java.util.Set;

import static me.wentuziak.race2Szop.ItemKeys.MULTI_ATTACK_EFFECT;
import static me.wentuziak.race2Szop.RaceKeys.*;
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

        Arrow usedArrow = (Arrow) event.getProjectile();

        assert usedBow != null;
        PersistentDataContainer bowContainer = Objects.requireNonNull(usedBow.getItemMeta()).getPersistentDataContainer();

        if (bowContainer.has(MULTI_ATTACK_EFFECT)){
            player.sendMessage("MULTI ATTACK !!! " + usedArrow);
        }
    }

}
