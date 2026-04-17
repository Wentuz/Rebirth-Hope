package me.wentuziak.race2Szop.actions;

import org.bukkit.entity.Snowball;
import org.bukkit.persistence.PersistentDataContainer;

import static me.wentuziak.race2Szop.ItemKeys.BLAZE_EFFECT;
import static me.wentuziak.race2Szop.items.BlazeFlintNSteel.blazeFlintNSteelOnImpact;

public class SnowBallActions {

    public static void snowballFallManager(Snowball snowball){
        PersistentDataContainer dataContainer = snowball.getPersistentDataContainer();

        if (dataContainer.has(BLAZE_EFFECT)){
            blazeFlintNSteelOnImpact(snowball);
        }
    }

}
