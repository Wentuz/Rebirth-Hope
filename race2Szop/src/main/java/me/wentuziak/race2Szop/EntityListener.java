package me.wentuziak.race2Szop;

import org.bukkit.entity.Cow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class EntityListener implements Listener {

    @EventHandler
    public void onEntityRightClick(PlayerInteractEntityEvent event){

        Player player = event.getPlayer();
        player.sendMessage("Clicked an entity :");

        String str = "";

        if (event.getRightClicked() instanceof Cow){
            AttributeManager.attributeManager(player,  "RACE_DWARF");
            str = "Cow";
        }else{
            AttributeManager.attributeManager(player);
            str = "not Cow";
        }
        player.sendMessage(str);
    }

}
