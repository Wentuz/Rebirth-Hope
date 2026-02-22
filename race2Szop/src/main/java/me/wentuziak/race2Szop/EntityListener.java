package me.wentuziak.race2Szop;

import me.wentuziak.race2Szop.Logic.Cooldowns;
import me.wentuziak.race2Szop.attribute.AttributeManager;
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

        if (event.getRightClicked() instanceof Cow && player.getPersistentDataContainer().has(RaceKeys.GATITO_RACE)){

            Cooldowns.startCooldownCountdown(player, 10);

            str = "Cow";
        }else{
            str = "not Cow";
        }
        player.sendMessage(str);
    }

}
