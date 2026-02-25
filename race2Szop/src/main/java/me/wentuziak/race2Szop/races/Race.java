package me.wentuziak.race2Szop.races;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;

public interface Race {

    public String name = "";
    public NamespacedKey raceKey = null;
    public Integer id = null;
    public Double cooldownModifier = 1.0;
    public String levelMessage = "";

    // TODO :
    // read skill input
    // lvl up

    public default int checkCurrentLevel(Player player){



        return 0;
    }

    public default void sendLevelUpInfo(Player player, String levelMessage){
        player.sendMessage(levelMessage);
    }

    public default boolean skillUse(){
        return true;
    }

    public default boolean sendRaceInfo(Player player, int Id){
        return true;
    }
}
