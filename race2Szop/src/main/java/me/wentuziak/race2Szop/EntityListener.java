package me.wentuziak.race2Szop;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.advancement.AdvancementDisplayType;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDropItemEvent;
import org.bukkit.event.entity.*;
import org.bukkit.event.player.*;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.Set;

import static me.wentuziak.race2Szop.RaceKeys.*;
import static me.wentuziak.race2Szop.playerEvents.PlayerAttackManager.playerGetHurt;
import static me.wentuziak.race2Szop.playerEvents.PlayerAttackManager.playerHitLivingEntity;
import static me.wentuziak.race2Szop.playerEvents.PlayerBreakBlockManager.breakBlockManager;
import static me.wentuziak.race2Szop.playerEvents.PlayerClapManager.detectClapRace;
import static me.wentuziak.race2Szop.playerEvents.PlayerFishingManager.onPlayerCatchFish;
import static me.wentuziak.race2Szop.playerEvents.PlayerFoodManager.playerGainHunger;
import static me.wentuziak.race2Szop.playerEvents.PlayerFoodManager.playerLooseHunger;
import static me.wentuziak.race2Szop.playerEvents.PlayerInteractionManager.*;
import static me.wentuziak.race2Szop.playerEvents.PlayerMoveManager.onSprintStart;
import static me.wentuziak.race2Szop.playerEvents.PlayerMoveManager.playerMoved;
import static me.wentuziak.race2Szop.playerEvents.PlayerSneakManager.onSneakStart;
import static me.wentuziak.race2Szop.playerEvents.PlayerSneakManager.onSneakStop;
import static me.wentuziak.race2Szop.races.Gatito.onGatitoEnterBed;
import static me.wentuziak.race2Szop.races.Goat.goatBreakBlock;
import static me.wentuziak.race2Szop.races.Merfolk.merfolkBreathe;
import static me.wentuziak.race2Szop.races.NetherFolk.netherFolkRespawn;
import static me.wentuziak.race2Szop.races.Parrot.parrotSleep;

public class EntityListener implements Listener {

    Set<NamespacedKey> raceKey;

    @EventHandler
    public void onEntityRightClick(PlayerInteractEntityEvent event){

        Player player = event.getPlayer();


//        if (event.getRightClicked() instanceof Player) {
//            Player clickedPlayer = (Player) event.getRightClicked();
//            raceKey = getPlayerRaceKeySet(clickedPlayer);
//            if (raceKey == null){
//                return;
//            }
//            playerRightClickLivingEntity(player, (LivingEntity) clickedPlayer, raceKey);
//        }
        if (event.getRightClicked() instanceof LivingEntity clickedEntity) {
            raceKey = getPlayerRaceKeySet(player);

            playerRightClickLivingEntity(player, clickedEntity, raceKey);
        }
    }

    @EventHandler
    public void playerAttackLivingEntity(EntityDamageByEntityEvent event){

        if (event.getDamager() instanceof Player player &&
            event.getEntity() instanceof LivingEntity hitEntity){
            if (player.getAttackCooldown() == 1){
                raceKey = getPlayerRaceKeySet(player);

                playerHitLivingEntity(player, hitEntity, raceKey);
            }
        }
    }

    @EventHandler
    public void onPlayerAdvancement(PlayerAdvancementDoneEvent event){
        Player player = event.getPlayer();
        //event.getAdvancement().getKey()
        //if (event.getAdvancement().getDisplay().getType().equals(AdvancementDisplayType.GOAL)) player.sendMessage("TEST PASSED !!! ");
        //if (event.getAdvancement().getDisplay().getType().equals(AdvancementDisplayType.CHALLENGE)) player.sendMessage("Challange Passed !!! ");
        //if (event.getAdvancement().getDisplay().getType().equals(AdvancementDisplayType.TASK)) player.sendMessage("task Passed !!! ");


        //TODO:
        //  on CHALLANGE -> give ADVANCED_UPGRADE race bonus
        //  on GOAL -> give BASE_UPGRADE race bonus

        //player.sendMessage(event.getAdvancement().getDisplay().getType() + " ");


    }

    @EventHandler
    public void onPlayerMount(EntityMountEvent event){

        if ((event.getEntity() instanceof Player player) &&
            event.getMount() instanceof LivingEntity mount){
            player = (Player) event.getEntity();

            mount = (LivingEntity) event.getMount();
            raceKey = getPlayerRaceKeySet(player);

            playerMountEntity(player, mount, raceKey);
        }
    }

    @EventHandler
    public void onPlayerFish(PlayerFishEvent event){

        Player player = event.getPlayer();
        raceKey = getPlayerRaceKeySet(player);

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
        if (event.getEntity() instanceof Player player){
            raceKey = getPlayerRaceKeySet(player);

            if (!raceKey.isEmpty()) playerGetHurt(player, raceKey);
        }

    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event){
        Player player = event.getPlayer();
        raceKey = getPlayerRaceKeySet(player);

        if (!raceKey.isEmpty()){
            playerMoved(player, raceKey);
        }
    }

    @EventHandler
    public void onPlayerSneak(PlayerToggleSneakEvent event){
        Player player = event.getPlayer();
        raceKey = getPlayerRaceKeySet(player);

        if (raceKey.isEmpty()){
            return;
        }

        if (!player.isSneaking()){
            onSneakStart(player, raceKey);
        }else{
            onSneakStop(player, raceKey);
        }
    }


    @EventHandler
    public void onPlayerBreakBlockDropItem(BlockDropItemEvent event){
        Player player = event.getPlayer();
        ItemStack itemInMainHand = player.getInventory().getItemInMainHand();
        ItemStack itemInOffHand = player.getInventory().getItemInOffHand();
        raceKey = getPlayerRaceKeySet(player);


        if (itemInMainHand.getType() == Material.AIR && itemInOffHand.getType() == Material.AIR
                && !raceKey.isEmpty()) {
            return;
        }

        if (event.getItems().isEmpty()){
            return;
        }

        //TODO :
        // age verification for crops

        ItemStack drop =  event.getItems().getFirst().getItemStack();
        ItemStack lastDrop =  event.getItems().getLast().getItemStack();

        if (!lastDrop.equals(drop)){
            breakBlockManager(player, lastDrop, raceKey, event.getBlockState().getType());
        }
        breakBlockManager(player, drop, raceKey, event.getBlockState().getType());


        //todo:
        // get this to work
        if (raceKey.contains(GOAT_RACE)) goatBreakBlock(event.getBlock());

    }

    @EventHandler
    public void onPiglinBarter(PiglinBarterEvent event){
        List<ItemStack> barteredItem = event.getOutcome();
        Piglin piglin = event.getEntity();



        playerBarterManager(piglin, barteredItem);
    }

    @EventHandler
    public void onPlayerSprint(PlayerToggleSprintEvent event){
        Player player = event.getPlayer();
        raceKey = getPlayerRaceKeySet(player);

        if (!raceKey.isEmpty()) {
            if (event.isSprinting()) {
                onSprintStart(player, raceKey);
            }
        }
    }

    @EventHandler
    public void onPlayerSwapHand(PlayerSwapHandItemsEvent event){
        Player player = event.getPlayer();
        ItemStack itemInMainHand = player.getInventory().getItemInMainHand();
        ItemStack itemInOffHand = player.getInventory().getItemInOffHand();
        raceKey = getPlayerRaceKeySet(player);

        if (itemInMainHand.getType() == Material.AIR && itemInOffHand.getType() == Material.AIR
                && !raceKey.isEmpty()) {
            detectClapRace(player, raceKey);
        }

    }

    @EventHandler
    public void onPlayerEnterBed(PlayerBedEnterEvent event){
        Player player = event.getPlayer();
        raceKey = getPlayerRaceKeySet(player);

        if (raceKey.isEmpty()){
            return;
        }

        if (raceKey.contains(PARROT_RACE)){
            parrotSleep(player);
        }else if (raceKey.contains(GATITO_RACE)){
            onGatitoEnterBed(player);
        }
    }

    @EventHandler
    public void onPlayerChangeFoodLevel(FoodLevelChangeEvent event){
        if (event.getEntity() instanceof Player player){
            int oldHunger = player.getFoodLevel();
            int newHunger = event.getFoodLevel();

            raceKey = getPlayerRaceKeySet(player);

            if (raceKey.isEmpty()){
                return;
            }
            if (oldHunger > newHunger){
                playerLooseHunger(player, raceKey);
            }else {
                playerGainHunger(player, raceKey);
            }
        }
    }

    @EventHandler
    public void onPlayerOxygenChange(EntityAirChangeEvent event){
        if (event.getEntity() instanceof Player player){
            raceKey = getPlayerRaceKeySet(player);

            if (raceKey.isEmpty()){
                return;
            }
            if (raceKey.contains(MERFOLK_RACE)) merfolkBreathe(player, event);
        }
    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event){
        Player player = event.getPlayer();
        raceKey = getPlayerRaceKeySet(player);
        if (raceKey.isEmpty()){
            return;
        }

        if ((!event.isAnchorSpawn() || !event.isBedSpawn()) && raceKey.contains(NETHER_RACE)){
            netherFolkRespawn(player);
        }
    }
}
