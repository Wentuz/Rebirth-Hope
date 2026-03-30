package me.wentuziak.race2Szop.races;

import me.wentuziak.race2Szop.Logic.Cooldowns;
import me.wentuziak.race2Szop.Logic.TaskManager;
import me.wentuziak.race2Szop.RaceKeys;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;

public interface Race {

    public Integer id = null;
    public Double cooldownModifier = 1.0;
    public String levelMessage = "";

    // TODO :
    // read skill input
    // lvl up

    public static int checkCurrentLevel(Player player){

        if (player.getPersistentDataContainer().has(RaceKeys.BASE_UPGRADE)){
            return 1;
        } else if (player.getPersistentDataContainer().has(RaceKeys.ADVANCED_UPGRADE)) {
            return 2;
        }

        return 0;
    }

    public static NamespacedKey currentRaceKey(String keyString){
        return RaceKeys.getKeyByName(keyString);
    }

    public default void sendLevelUpInfo(Player player, String levelMessage){
        player.sendMessage(levelMessage);
    }

    public static void giveRaceCooldown(Player player, double cooldownModifier){
        if (!Cooldowns.checkPlayerCooldown(player)){
            Cooldowns.startCooldownCountdown(player, (int) (60 * cooldownModifier));
        }

        return;
    }

    public default boolean sendRaceInfo(Player player, int Id){
        return true;
    }
}
