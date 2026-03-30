package me.wentuziak.race2Szop.commands;

import me.wentuziak.race2Szop.RaceKeys;
import me.wentuziak.race2Szop.attribute.AttributeManager;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.Arrays;

import static me.wentuziak.race2Szop.attribute.AttributeManager.attributeManager;
import static me.wentuziak.race2Szop.races.NetherFolk.onChangeRaceToNetherFolk;

public class RaceChangeCommand {

    public static boolean swapPlayerRace(Player targetPlayer, String raceKey){


        String inputKey = raceKey + "race";
        NamespacedKey[] allKeys = RaceKeys.getRaceKeys();
        boolean keyExists = Arrays.stream(allKeys).anyMatch(key -> key.getKey().equals(inputKey));


        if (!keyExists) {
            targetPlayer.sendMessage(ChatColor.RED + "The race '" + inputKey + "' does not exist.");
            return false;
        }

        unLoadRace(targetPlayer);

        String getKey = raceKey.toUpperCase() + "_RACE";
        NamespacedKey setKey = RaceKeys.getKeyByName(getKey);
        targetPlayer.getPersistentDataContainer().set(setKey, PersistentDataType.BOOLEAN, true);

        if (targetPlayer.getPersistentDataContainer().has(setKey, PersistentDataType.BOOLEAN)) {
            targetPlayer.sendMessage(ChatColor.GREEN + "The race '"
                    + inputKey.substring(0, inputKey.length() - 4) + "' has been set for the player.");

            attributeManager(targetPlayer, getKey.toString());


            if (getKey.equals("NETHER_RACE")) onChangeRaceToNetherFolk(targetPlayer);

            return true;
        }else{
            targetPlayer.sendMessage(ChatColor.RED + "Failed to set the race '"
                    + inputKey.substring(0, inputKey.length() - 4) + "' for the player.");
            attributeManager(targetPlayer);
            return false;
        }
    }


    public static void unLoadRace(Player player){
        PersistentDataContainer dataContainer = player.getPersistentDataContainer();

        NamespacedKey[] raceKeys = RaceKeys.getRaceKeys();

        for (NamespacedKey key : raceKeys) {
            if (dataContainer.has(key, PersistentDataType.BOOLEAN)) {
                String keyString =  key.getKey().toUpperCase();
                keyString = keyString.substring(0, keyString.length() - 4);
                player.sendMessage(ChatColor.GREEN + keyString + " Unloaded");

                attributeManager(player);

                keyString = keyString + "_RACE";
                NamespacedKey setKey = RaceKeys.getKeyByName(keyString);
                player.getPersistentDataContainer().remove(setKey);

            }
        }
    }

}
