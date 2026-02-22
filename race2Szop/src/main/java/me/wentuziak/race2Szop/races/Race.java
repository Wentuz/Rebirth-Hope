package me.wentuziak.race2Szop.races;

import org.bukkit.entity.Player;

public interface Race {

    public String name = "";
    public Integer id = null;
    public Integer RaceLvl = null;
    public Double cooldownModifier = 1.0;

    // TODO :
    // read skill input
    // lvl up

    private int levelUp(){
        return 0;
    }
    private int levelDown(){
        return 0;
    }

    private boolean skillUse(){
        return true;
    }

    public default boolean sendRaceInfo(Player player, int Id){
        return true;
    }
}
