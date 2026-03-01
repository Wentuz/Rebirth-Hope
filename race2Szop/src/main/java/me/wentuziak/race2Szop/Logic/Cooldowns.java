package me.wentuziak.race2Szop.Logic;

import me.wentuziak.race2Szop.Race2Szop;
import me.wentuziak.race2Szop.races.Race;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class Cooldowns {

    static BukkitTask cooldownTask;

    public static void startCooldownCountdown(Player player, int seconds) {
        if (!checkPlayerCooldown(player)) {
            final Player finalPlayer = player;

            finalPlayer.setCooldown(Material.WOLF_SPAWN_EGG, 20 * seconds);

            // Create and configure the boss bar
            BossBar bossBar = Bukkit.createBossBar(ChatColor.RED + "" + seconds + "s", BarColor.RED, BarStyle.SOLID);
            bossBar.addPlayer(finalPlayer);
            bossBar.setProgress(1.0);

            BukkitRunnable cooldownTask = new BukkitRunnable() {
                int timeLeft = seconds;

                @Override
                public void run() {
                    if (timeLeft <= 0) {
                        bossBar.setTitle(ChatColor.GREEN + "");
                        bossBar.setProgress(1.0);
                        bossBar.setColor(BarColor.GREEN);

                        // Remove the boss bar after a delay
                        new BukkitRunnable() {
                            public void run() {
                                bossBar.removeAll();
                            }
                        }.runTaskLater(Race2Szop.getInstance(), 40L); // ~2 seconds
                        cancel();
                        return;
                    }
                    // Update progress and title
                    double progress = (double) timeLeft / seconds;
                    bossBar.setProgress(progress);
                    bossBar.setTitle(ChatColor.RED + "Cooldown: " + timeLeft + "s");
                    timeLeft--;
                }
            };
            cooldownTask.runTaskTimer(Race2Szop.getInstance(), 0, 20L); // 20 ticks = 1 second
        }
    }


    public static boolean checkPlayerCooldown(Player player){
        return player.hasCooldown(Material.WOLF_SPAWN_EGG);
    }

}
