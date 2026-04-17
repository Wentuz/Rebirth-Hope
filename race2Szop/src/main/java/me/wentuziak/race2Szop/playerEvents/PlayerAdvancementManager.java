package me.wentuziak.race2Szop.playerEvents;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.advancement.Advancement;
import org.bukkit.advancement.AdvancementProgress;
import org.bukkit.entity.Player;

import java.util.Iterator;

import static me.wentuziak.race2Szop.RaceKeys.ADVANCED_UPGRADE;
import static me.wentuziak.race2Szop.RaceKeys.BASE_UPGRADE;

public class PlayerAdvancementManager {

    public static void playerGetAdvancement(Player player, Advancement advancement){
        player.sendMessage(advancement + " ");
    }

    public static void unLoadAllAdvancments(Player player){
        Iterator iterator = Bukkit.getServer().advancementIterator();
        int x = 0;
        while (iterator.hasNext()) {
            AdvancementProgress progress = player.getAdvancementProgress((Advancement) iterator.next());
            for (String criteria : progress.getAwardedCriteria()) {
                progress.revokeCriteria(criteria);
                x = x + 1;
            }
        }

        if (x == 0) {
            player.sendMessage(ChatColor.RED + "No advancements to remove");
            return;
        }
        player.sendMessage(ChatColor.RED + "Removed all advancements");

        if (player.getPersistentDataContainer().has(BASE_UPGRADE)){
            player.getPersistentDataContainer().remove(BASE_UPGRADE);
        }
        if (player.getPersistentDataContainer().has(ADVANCED_UPGRADE)){
            player.getPersistentDataContainer().remove(ADVANCED_UPGRADE);
        }
    }

    public static void checkPlayerAdvancement(Player player){

    }

}
