package me.wentuziak.race2Szop;

import me.wentuziak.race2Szop.items.ItemRecipes;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import static me.wentuziak.race2Szop.attribute.AttributeManager.attributeManager;

public class PlayerOnLogin implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();

        ItemRecipes.getRecipeKeys().forEach(player::discoverRecipe);

        if(player.hasPlayedBefore()){
                PersistentDataContainer dataContainer = player.getPersistentDataContainer();
                NamespacedKey[] raceKeys = RaceKeys.getRaceKeys();

                attributeManager(player); // ensure none are loaded
                for (NamespacedKey key : raceKeys) {
                    if (dataContainer.has(key, PersistentDataType.BOOLEAN)) {
                        String keyString =  key.getKey().toUpperCase();
                        keyString = keyString.substring(0, keyString.length() - 4);
                        player.sendMessage(ChatColor.GREEN + keyString + " Loaded"); // load attributes
                        attributeManager(player, keyString + "_RACE");
                    }
            }
        }else{
            System.out.println("player first join succes : " + playerFirstJoin(player));
        }
    }

    private boolean playerFirstJoin(Player player){
        return true;
    }

}
