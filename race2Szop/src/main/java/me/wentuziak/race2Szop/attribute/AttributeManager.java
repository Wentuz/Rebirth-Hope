package me.wentuziak.race2Szop.attribute;

import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Player;

import static me.wentuziak.race2Szop.attribute.AttributeModifier.*;

public class AttributeManager {
    private static double playerMovementSpeed;
    private static double playerHP;
    private static double playerScale;
    private static double playerMiningSpeed;
    private static double playerAttackDamage;
    private static double playerFireTime;
    private static double playerGravity;
    private static double playerFallDamage;
    private static double playerKnockback;
    private static double playerOxygenBonus;
    private static double playerAttackSpeed;
    private static double playerSafeFallRange;
    private static double playerBlockReach;
    private static double playerEntityReach;
    private static double playerWaterSpeed;

    static double getBaseValues(int attributeID){
        double [] baseAttributes = new double[15];
        baseAttributes[0] = 0.1;    //Movement speed
        baseAttributes[1] = 20;     //Health points
        baseAttributes[2] = 1;      //Scale
        baseAttributes[3] = 1;      //Mining speed
        baseAttributes[4] = 1;      //Attack damage
        baseAttributes[5] = 1;      //Fire time
        baseAttributes[6] = 0.08;   //Gravity
        baseAttributes[7] = 1;      //Fall damage multiplier
        baseAttributes[8] = 0;      //Knockback
        baseAttributes[9] = 0;      //Oxygen bonus
        baseAttributes[10] = 4;     //Attack speed
        baseAttributes[11] = 3;     //Safe fall range
        baseAttributes[12] = 4.5;   //Block reach
        baseAttributes[13] = 3;     //Entity reach
        baseAttributes[14] = 0;     //WaterSpeed

        return baseAttributes[attributeID];
    }

    public static void attributeManager(Player player){
        // reset to base values if "removerace"
        modifyMovementSpeed(player, getBaseValues(0));
        modifyHealthPoints(player, getBaseValues(1));
        modifyScale(player, getBaseValues(2));
        modifyMineSpeed(player, getBaseValues(3));
        modifyAttackDamage(player, getBaseValues(4));
        modifyFireTime(player, getBaseValues(5));
        modifyGravity(player, getBaseValues(6));
        modifyFallDmgMultiplier(player, getBaseValues(7));
        modifyKnockBack(player, getBaseValues(8));
        modifyOxygenBonus(player, getBaseValues(9));
        modifyAttackSpeed(player, getBaseValues(10));
        modifySafeFallRange(player, getBaseValues(11));
        modifyReach(player, getBaseValues(12), getBaseValues(13));
        modifyWaterSpeed(player, getBaseValues(14));

        return;
    }

    public static void attributeManager(Player player, String raceName){

        // get current player attributes
        AttributeInstance speedAttribute = player.getAttribute(Attribute.MOVEMENT_SPEED);
        AttributeInstance healthAttribute = player.getAttribute(Attribute.MAX_HEALTH);
        AttributeInstance scaleAttribute = player.getAttribute(Attribute.SCALE);
        AttributeInstance mineSpeedAttribute = player.getAttribute(Attribute.BLOCK_BREAK_SPEED);
        AttributeInstance attackAttribute = player.getAttribute(Attribute.ATTACK_DAMAGE);
        AttributeInstance burnTimeAttribute = player.getAttribute(Attribute.BURNING_TIME);
        AttributeInstance gravityAttribute = player.getAttribute(Attribute.GRAVITY);
        AttributeInstance fallDmgAttribute = player.getAttribute(Attribute.FALL_DAMAGE_MULTIPLIER);
        AttributeInstance knockbackResistAttribute = player.getAttribute(Attribute.KNOCKBACK_RESISTANCE);
        AttributeInstance oxygenAttribute = player.getAttribute(Attribute.OXYGEN_BONUS);
        AttributeInstance attackSpeedAttribute = player.getAttribute(Attribute.ATTACK_SPEED);
        AttributeInstance safeFallRangeAttribute = player.getAttribute(Attribute.SAFE_FALL_DISTANCE);
        AttributeInstance waterSpeedAttribute = player.getAttribute(Attribute.WATER_MOVEMENT_EFFICIENCY);
        AttributeInstance blockReachAttribute = player.getAttribute(Attribute.BLOCK_INTERACTION_RANGE);
        AttributeInstance entityReachAttribute = player.getAttribute(Attribute.ENTITY_INTERACTION_RANGE);

        // get current values
        playerMovementSpeed = speedAttribute.getValue();
        playerHP = healthAttribute.getValue();
        playerScale = scaleAttribute.getValue();
        playerMiningSpeed = mineSpeedAttribute.getValue();
        playerAttackDamage = attackAttribute.getValue();
        playerFireTime = burnTimeAttribute.getValue();
        playerGravity = gravityAttribute.getValue();
        playerFallDamage = fallDmgAttribute.getValue();
        playerKnockback = knockbackResistAttribute.getValue();
        playerOxygenBonus = oxygenAttribute.getValue();
        playerAttackSpeed = attackSpeedAttribute.getValue();
        playerSafeFallRange = safeFallRangeAttribute.getValue();
        playerBlockReach = blockReachAttribute.getValue();
        playerEntityReach = entityReachAttribute.getValue();
        playerWaterSpeed = waterSpeedAttribute.getValue();

        //multiply values "RACE_NAME"
        switch (raceName) {
            case "GOAT_RACE" -> handleGoat();
            case "GATITO_RACE" -> handleGatito();
            case "ENDERIAN_RACE" -> handleEnderian();
            case "PARROT_RACE" -> handleParrot();
            case "SKELETON_RACE" -> handleSkeleton();
            case "MERFOLK_RACE" -> handleMerfolk();
            case "NETHER_RACE" -> handleNetherRace();

            default -> handleUnknownRace(player);
        }

        //modify attributes
        modifyMovementSpeed(player, playerMovementSpeed);
        modifyHealthPoints(player, playerHP);
        modifyScale(player, playerScale);
        modifyMineSpeed(player, playerMiningSpeed);
        modifyAttackDamage(player, playerAttackDamage);
        modifyFireTime(player, playerFireTime);
        modifyGravity(player, playerGravity);
        modifyFallDmgMultiplier(player, playerFallDamage);
        modifyKnockBack(player, playerKnockback);
        modifyOxygenBonus(player, playerOxygenBonus);
        modifyAttackSpeed(player, playerAttackSpeed);
        modifySafeFallRange(player, playerSafeFallRange);
        modifyReach(player, playerBlockReach, playerEntityReach);
        modifyWaterSpeed(player, playerWaterSpeed);
    }



    // Attributes of all races
    static void handleGatito() {
        playerMovementSpeed = playerMovementSpeed * 1.15;
        playerHP = playerHP * 0.80;
        playerScale = playerScale * 0.80;
        playerGravity = playerGravity * 0.75;
        playerKnockback = playerKnockback * 1.2; // to check if it should be inverted

        System.out.println("Handling Gatito ...");
    }

    static void handleGoat(){
        playerSafeFallRange = playerSafeFallRange * 1.5;
        playerMiningSpeed = playerMiningSpeed * 1.25;

    }

    static void handleEnderian(){
        playerScale = playerScale * 1.1;
        playerBlockReach = playerBlockReach * 1.25;
        playerEntityReach = playerEntityReach * 1.25;
        playerHP = playerHP * 1.5;
    }

    static void handleParrot(){
        playerScale = playerScale * 0.7;
        playerHP = playerHP * 0.75;
        playerGravity = playerGravity * 0.5;
        playerKnockback = playerKnockback * 0.5;
        playerAttackSpeed = playerAttackSpeed * 1.10;
    }

    static void handleSkeleton(){
        playerAttackDamage = playerAttackDamage * 3;
        playerFireTime = playerFireTime * 2;
        playerMovementSpeed = playerMovementSpeed * 1.1;
        playerOxygenBonus = playerOxygenBonus * 3;
    }
    static void handleMerfolk(){
        playerFireTime = playerFireTime * 5;
        playerWaterSpeed = playerWaterSpeed * 2;
        playerScale = playerScale * 0.9;
    }
    static void handleNetherRace(){
        playerScale = playerScale * 1.3;
        playerFireTime = playerFireTime * 0;
        playerAttackSpeed = playerAttackSpeed * 1.25;
    }

    static void handleUnknownRace(Player player) {
        attributeManager(player);
        System.out.println("Unknown race. Applying default settings...");
    }
}
