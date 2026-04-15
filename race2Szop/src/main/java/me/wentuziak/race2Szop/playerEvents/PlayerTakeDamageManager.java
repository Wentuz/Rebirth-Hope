package me.wentuziak.race2Szop.playerEvents;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;

import java.util.Objects;

import static me.wentuziak.race2Szop.ItemKeys.*;
import static me.wentuziak.race2Szop.actions.BootActions.explosionBootsFall;
import static me.wentuziak.race2Szop.actions.BootActions.slimeBootsFall;

public class PlayerTakeDamageManager {

    public static void onPlayerFallDamage(Player player, double damage){
        ItemStack boots = player.getInventory().getBoots();

        assert boots != null;
        if (!boots.hasItemMeta() || player.isSneaking()) return;

        PersistentDataContainer bootContainer = Objects.requireNonNull(boots.getItemMeta()).getPersistentDataContainer();
        if (bootContainer.has(SLIMY_EFFECT)){
            slimeBootsFall(player, damage);
        } else if (bootContainer.has(EXPLOSIVE_EFFECT)) {
            explosionBootsFall(player);
        }
    }

}
