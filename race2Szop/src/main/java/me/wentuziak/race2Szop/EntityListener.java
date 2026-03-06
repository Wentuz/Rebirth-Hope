package me.wentuziak.race2Szop;

import me.wentuziak.race2Szop.Logic.Cooldowns;
import me.wentuziak.race2Szop.attribute.AttributeManager;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Biome;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;

import static me.wentuziak.race2Szop.RaceKeys.*;
import static me.wentuziak.race2Szop.lootTables.LuckCalculator.getLuckLevel;
import static me.wentuziak.race2Szop.playerEvents.PlayerAttackManager.playerGetHurt;
import static me.wentuziak.race2Szop.playerEvents.PlayerClapManager.detectClapRace;
import static me.wentuziak.race2Szop.playerEvents.PlayerFishingManager.onPlayerCatchFish;
import static me.wentuziak.race2Szop.playerEvents.PlayerFoodManager.playerGainHunger;
import static me.wentuziak.race2Szop.playerEvents.PlayerFoodManager.playerLooseHunger;
import static me.wentuziak.race2Szop.playerEvents.PlayerInteractionManager.playerRightClickLivingEntity;
import static me.wentuziak.race2Szop.playerEvents.PlayerMoveManager.playerMoved;
import static me.wentuziak.race2Szop.playerEvents.PlayerSneakManager.onSneakStart;
import static me.wentuziak.race2Szop.playerEvents.PlayerSneakManager.onSneakStop;
import static me.wentuziak.race2Szop.races.Gatito.onGatitoEnterBed;
import static me.wentuziak.race2Szop.races.Parrot.parrotSleep;

public class EntityListener implements Listener {

    PersistentDataContainer dataContainer;
    NamespacedKey raceKey;

    @EventHandler
    public void onEntityRightClick(PlayerInteractEntityEvent event){

        Player player = event.getPlayer();
        raceKey = getPlayerRaceKey(player);
        Entity clickedEntity = event.getRightClicked();

        if (raceKey == null){
            return;
        }else{
            if (clickedEntity instanceof LivingEntity) {
                playerRightClickLivingEntity(player, (LivingEntity) clickedEntity, raceKey);
            }

        }

    }

    @EventHandler
    public void onPlayerFish(PlayerFishEvent event){

        Player player = event.getPlayer();
        raceKey = getPlayerRaceKey(player);

        Projectile fishingBobber = event.getHook();

        if (event.getState() == PlayerFishEvent.State.CAUGHT_FISH){

            Entity caught = event.getCaught();
            if(caught instanceof Item){
                ItemStack caughtFish = ((Item) caught).getItemStack();

                onPlayerCatchFish(player, raceKey, caughtFish, fishingBobber);
            }
        }
    }

    @EventHandler
    public void onPlayerGetHurt(EntityDamageEvent event){
        if (event.getEntity() instanceof Player){
            Player player = (Player) event.getEntity();
            raceKey = getPlayerRaceKey(player);

            if (raceKey == null){
                return;
            }else{
                playerGetHurt(player, raceKey);
            }
        }

    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event){
        Player player = event.getPlayer();
        raceKey = getPlayerRaceKey(player);

        if (raceKey == null){
            return;
        }else{
            playerMoved(player, raceKey);
        }
    }

    @EventHandler
    public void onPlayerSneak(PlayerToggleSneakEvent event){
        Player player = event.getPlayer();
        raceKey = getPlayerRaceKey(player);

        if (raceKey == null){
            return;
        }

        if (!player.isSneaking()){
            onSneakStart(player, raceKey);
        }else{
            onSneakStop(player, raceKey);
        }
    }

    @EventHandler
    public void onPlayerSprint(PlayerToggleSprintEvent event){
        Player player = event.getPlayer();
        raceKey = getPlayerRaceKey(player);

        if (raceKey == null) {
            player.sendMessage("no key");

            return;
        }else {
            player.sendMessage("has key : " + raceKey);
        }
    }

    @EventHandler
    public void onPlayerSwapHand(PlayerSwapHandItemsEvent event){
        Player player = event.getPlayer();
        ItemStack itemInMainHand = player.getInventory().getItemInMainHand();
        ItemStack itemInOffHand = player.getInventory().getItemInOffHand();
        raceKey = getPlayerRaceKey(player);

        if (itemInMainHand.getType() == Material.AIR && itemInOffHand.getType() == Material.AIR
                && raceKey != null) {
            detectClapRace(player, raceKey);
        }
        return;
    }

    @EventHandler
    public void onPlayerEnterBed(PlayerBedEnterEvent event){
        Player player = event.getPlayer();
        raceKey = getPlayerRaceKey(player);

        if (raceKey == null){
            return;
        }

        if (raceKey.equals(PARROT_RACE)){
            parrotSleep(player);
        }else if (raceKey.equals(GATITO_RACE)){
            onGatitoEnterBed(player);
        }
    }

    @EventHandler
    public void onPlayerChangeFoodLevel(FoodLevelChangeEvent event){
        if (event.getEntity() instanceof Player){
            Player player = (Player) event.getEntity();

            int oldHunger = player.getFoodLevel();
            int newHunger = event.getFoodLevel();

            raceKey = getPlayerRaceKey(player);

            if (raceKey == null){
                return;
            }
            if (oldHunger > newHunger){
                playerLooseHunger(player, raceKey);
            }else {
                playerGainHunger(player, raceKey);
            }


        }
    }
}
