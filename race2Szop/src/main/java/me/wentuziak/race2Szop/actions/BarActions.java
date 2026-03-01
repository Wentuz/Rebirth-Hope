package me.wentuziak.race2Szop.actions;

import org.bukkit.Sound;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;

import java.util.Objects;

public class BarActions {

    public static void modifyPlayerHunger(Player player, int amount){

        int currentHunger = player.getFoodLevel() + amount;

        if (currentHunger >= 20){
            currentHunger = 20;
        } else if (currentHunger <= 0) {
            currentHunger = 0;
        }
        player.setFoodLevel(currentHunger);
    }

    public static void modifyPlayerHealthBar(Player player, int amount){
        double maxHealth = player.getMaxHealth();
        double currentHealth = player.getHealth();

        if (currentHealth + amount > maxHealth){
            player.setHealth(maxHealth);
        }else if(currentHealth + amount > 0){
            player.setHealth(currentHealth + amount);
        }else {
            player.setHealth(0);
        }
    }

    public static void hurtPlayer(Player player, int amount){
        modifyPlayerHealthBar(player, amount);
        player.playHurtAnimation(1);
    }
    public static void hurtPlayer(Player player, int amount, Sound sound ){
        modifyPlayerHealthBar(player, amount);
        player.playHurtAnimation(1);
        player.playSound(player.getLocation(), sound, 1.0f, 1.0f);
    }

}
