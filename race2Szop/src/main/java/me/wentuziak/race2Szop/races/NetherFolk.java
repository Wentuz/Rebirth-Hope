package me.wentuziak.race2Szop.races;

import me.wentuziak.race2Szop.Logic.Cooldowns;
import me.wentuziak.race2Szop.actions.BarActions;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;

import static me.wentuziak.race2Szop.Logic.Effects.givePotionEffect;
import static me.wentuziak.race2Szop.lootTables.LootManager.getPiglinBarterLoot;
import static me.wentuziak.race2Szop.lootTables.LuckCalculator.randomInteger;

public class NetherFolk implements Race {
    NamespacedKey raceKey = Race.currentRaceKey("NETHER_RACE");
    static double cooldownModifier = 0.15;


    public static void onChangeRace(Player player){

        // start in the nether
    }

    public static void netherFolkLevitation(Player player){
        if (Cooldowns.checkPlayerCooldown(player)) return;

        int intensity = 0;
        if (Race.checkCurrentLevel(player) == 1){
            intensity = 1;
        }
        givePotionEffect(player, PotionEffectType.LEVITATION, 4 * (intensity * 2 + 1), intensity);

        BarActions.modifyPlayerHunger(player, -2);
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



}
