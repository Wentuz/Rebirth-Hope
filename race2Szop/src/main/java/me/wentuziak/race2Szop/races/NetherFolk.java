package me.wentuziak.race2Szop.races;

import me.wentuziak.race2Szop.Logic.Cooldowns;
import me.wentuziak.race2Szop.Race2Szop;
import me.wentuziak.race2Szop.actions.BarActions;
import org.bukkit.*;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.entity.WindCharge;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;

import java.util.Objects;

import static me.wentuziak.race2Szop.Logic.Checkers.isPlayerWet;
import static me.wentuziak.race2Szop.Logic.Effects.givePotionEffect;
import static me.wentuziak.race2Szop.actions.BarActions.hurtPlayer;
import static me.wentuziak.race2Szop.lootTables.LootManager.getPiglinBarterLoot;
import static me.wentuziak.race2Szop.lootTables.LuckCalculator.randomInteger;

public class NetherFolk implements Race {
    NamespacedKey raceKey = Race.currentRaceKey("NETHER_RACE");
    static double cooldownModifier = 0.15;


    public static void onChangeRaceToNetherFolk(Player player){

        if (player.getExp() != 0) return;

        teleportToNether(player);

        givePotionEffect(player, PotionEffectType.HASTE, 10, 10);
        givePotionEffect(player, PotionEffectType.REGENERATION, 10, 10);
    }

    public static void netherFolkRespawn(Player player){
        Bukkit.getScheduler().runTaskLater(Race2Szop.getInstance(), () -> {
            teleportToNether(player);
        },  1);
    }

    private static void teleportToNether(Player player){
        World netherWorld = Bukkit.getWorld("world_nether");
        if (netherWorld != null) {
            Location location = netherWorld.getSpawnLocation();
            player.teleport(location);
        }
    }

    public static void netherFolkLevitation(Player player){
        if (Cooldowns.checkPlayerCooldown(player)) return;

        int intensity = 0;
        if (Race.checkCurrentLevel(player) == 1){
            intensity = 1;
        }
        givePotionEffect(player, PotionEffectType.LEVITATION, 4 * (intensity * 2 + 1), intensity);

        Race.giveRaceCooldown(player, cooldownModifier);
    }

    public static ItemStack piglinTradeOutcome(ItemStack droppedItem){
        Material material = droppedItem.getType();
        switch (material){
            case Material.IRON_BOOTS, Material.POTION, Material.SPLASH_POTION, Material.ENDER_PEARL -> {
                return droppedItem;
            }
            default -> {
                if (randomInteger(10) >= 8) {
                    droppedItem.setType(getPiglinBarterLoot());
                    return droppedItem;
                }
                droppedItem.setAmount(droppedItem.getAmount() + 4);
                return droppedItem;
            }
        }
    }

    public static void netherFolkEat(Player player, ItemStack item){
        if (!player.hasPotionEffect(PotionEffectType.FIRE_RESISTANCE)){
            givePotionEffect(player, PotionEffectType.FIRE_RESISTANCE, 15, 0);
        }
    }

    public static void wetNetherFolk(Player player){
        if (!player.hasCooldown(Material.DOLPHIN_SPAWN_EGG) && isPlayerWet(player)){
            hurtPlayer(player, -1, Sound.ENTITY_PLAYER_HURT_DROWN);

            player.setCooldown(Material.DOLPHIN_SPAWN_EGG, 20);
        }
    }



}
