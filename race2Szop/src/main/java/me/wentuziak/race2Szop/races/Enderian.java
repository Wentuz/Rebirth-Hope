package me.wentuziak.race2Szop.races;

import me.wentuziak.race2Szop.Logic.Cooldowns;
import me.wentuziak.race2Szop.RaceKeys;
import me.wentuziak.race2Szop.actions.BarActions;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import static me.wentuziak.race2Szop.Logic.Checkers.*;
import static me.wentuziak.race2Szop.actions.BarActions.hurtPlayer;
import static me.wentuziak.race2Szop.actions.BarActions.modifyPlayerHealthBar;
import static me.wentuziak.race2Szop.lootTables.LuckCalculator.randomInteger;

public class Enderian implements Race{

    static NamespacedKey raceKey = Race.currentRaceKey("ENDERIAN_RACE");
    static double cooldownModifier = 0.5;

    public static void throwPearlOrTeleport(Player player){
        if (Cooldowns.checkPlayerCooldown(player)) return;

        if(Race.checkCurrentLevel(player) == 0){
            dropEnderPearl(player);
        }else{
            enderianTeleport(player);
        };

        BarActions.modifyPlayerHunger(player, -2);
        Race.giveRaceCooldown(player, cooldownModifier);
    }

    public static void dropEnderPearl(Player player){
        player.getWorld().dropItemNaturally(player.getLocation(), new ItemStack(Material.ENDER_PEARL, 1));
        player.playSound(player.getLocation(), Sound.ENTITY_CHICKEN_EGG, 1.0f, 1.0f);
    }

    public static void enderianTeleport(Player player){

        Block targetBlock = player.getTargetBlock(null, 25);

        Location blockLocation = targetBlock.getLocation();

        int blockX = blockLocation.getBlockX();
        int blockY = blockLocation.getBlockY();
        int blockZ = blockLocation.getBlockZ();

        float yaw = player.getLocation().getYaw();
        float pitch = player.getLocation().getPitch();

        Location targetLocation = new Location(player.getWorld(), blockX, blockY + 1, blockZ, yaw, pitch);
        player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1, 1);
        player.getWorld().spawnParticle(Particle.PORTAL, player.getLocation(), 100);
        player.teleport(targetLocation);
    }

    public static void enderianInWater(Player player){

        if (isPlayerWet(player) && !player.hasCooldown(Material.DOLPHIN_SPAWN_EGG)){
            hurtPlayer(player, -1, Sound.ENTITY_PLAYER_HURT_DROWN);

            onPlayerHurt(player);

            player.setCooldown(Material.DOLPHIN_SPAWN_EGG, 10);
        }
    }

    public static void onPlayerHurt(Player player){

        int x = (randomInteger(20) > 10) ? randomInteger(15) : randomInteger(15) * -1;
        int z =  (randomInteger(20) > 10) ? randomInteger(15) : randomInteger(15) * -1;
        player.teleport(player.getLocation().add( x, 5.0, z));

        player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1, 1);
        player.getWorld().spawnParticle(Particle.PORTAL, player.getLocation(), 100);
    }

    public static void onLooseHunger(Player player){
        if (1 > randomInteger(5)){
            dropEnderPearl(player);
        }
    }
}
