package me.wentuziak.race2Szop.races;

import me.wentuziak.race2Szop.Logic.Cooldowns;
import me.wentuziak.race2Szop.RaceKeys;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Enderian implements Race{

    static NamespacedKey raceKey = Race.currentRaceKey("ENDERIAN_RACE");
    static double cooldownModifier = 0.5;


    public static void throwPearlOrTeleport(Player player){
        if (Cooldowns.checkPlayerCooldown(player)) return;

        if(Race.checkCurrentLevel(player) == 0){
            dropEnderPearl(player);
        };

        Race.giveRaceCooldown(player, cooldownModifier);
    }

    public static void dropEnderPearl(Player player){
        player.getWorld().dropItemNaturally(player.getLocation(), new ItemStack(Material.ENDER_PEARL, 1));
    }

    public static void throwEndPearl(Player player){

    }

    public static void onPlayerHurt(Player player){

    }

    public static void skillTeleportation(Player player){

    }



}
