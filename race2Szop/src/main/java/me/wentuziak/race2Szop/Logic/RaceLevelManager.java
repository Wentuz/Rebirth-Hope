package me.wentuziak.race2Szop.Logic;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.advancement.Advancement;
import org.bukkit.advancement.AdvancementProgress;
import org.bukkit.entity.Player;

import java.util.Iterator;

public class RaceLevelManager {

    public static void unLoadAllAdvancments(Player player){
        Iterator iterator = Bukkit.getServer().advancementIterator();
        while (iterator.hasNext()) {
            AdvancementProgress progress = player.getAdvancementProgress((Advancement) iterator.next());
            for (String criteria : progress.getAwardedCriteria()) {
                progress.revokeCriteria(criteria);
            }
        }
        player.sendMessage(ChatColor.RED + "Removed all advancements");
    }

    public static void checkPlayerAdvancement(Player player){}

}
