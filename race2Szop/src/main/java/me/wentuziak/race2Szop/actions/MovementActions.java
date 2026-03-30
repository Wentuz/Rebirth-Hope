package me.wentuziak.race2Szop.actions;

import me.wentuziak.race2Szop.Logic.TaskManager;
import me.wentuziak.race2Szop.Race2Szop;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Vector;

import static me.wentuziak.race2Szop.Logic.Checkers.isPlayerAboveGround;

public class MovementActions {

    static BukkitTask glideTask;

    public static void addVelocityAtCursour(Player player, Double speed){
        Vector direction = player.getLocation().getDirection().normalize();
        player.setVelocity(direction.multiply(speed));
    }

    public static void playerGlideTask(Player player){

        // fly
        if (!TaskManager.isTaskRunning(player, "glideTask")) {
            final Player finalPlayer = player;
            glideTask = new BukkitRunnable() {
                @Override
                public void run(){
                    if (!isPlayerAboveGround(finalPlayer, 0.2) || player.isInWater()) {
                        stopPlayerGlideTask(finalPlayer);
                        return;
                    }
                    finalPlayer.setGliding(true);
                }
            }.runTaskTimer(Race2Szop.getInstance(), 0, 1);
            TaskManager.addTask(player, "glideTask", glideTask);
        }

    }

    public static void stopPlayerGlideTask(Player player) {
        TaskManager.stopTask(player, "glideTask");
    }

}
