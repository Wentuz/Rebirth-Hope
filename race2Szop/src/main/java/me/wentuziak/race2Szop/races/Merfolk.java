package me.wentuziak.race2Szop.races;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityAirChangeEvent;

import static me.wentuziak.race2Szop.Logic.Checkers.isPlayerWet;

public class Merfolk implements Race {
    NamespacedKey raceKey = Race.currentRaceKey("MERFOLK_RACE");

    public static void onChangeRaceToMerfolk(Player player){
        player.setRemainingAir(250);
    }

    public static void merfolkBreathe(Player player, EntityAirChangeEvent event){

        int air = event.getAmount();

        if (isPlayerWet(player)){
            //todo:
            //  omfg i hate it
        }else{
            air = air - 4;
            if (air > 0) event.setAmount(air);
            player.sendMessage(event.getAmount() + "");
        }

    }

    public static void onConduitClick(Player player){
        // summons storm
    }

    public static void onMerfolkStartSwim(){

    }

    public static void merfolkRiptide(){

    }

}
