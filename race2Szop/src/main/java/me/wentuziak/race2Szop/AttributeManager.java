package me.wentuziak.race2Szop;

import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Player;

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
            case "RACE_DWARF" -> handleDwarf();

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
    static void handleDwarf() {
        playerMovementSpeed = playerMovementSpeed * 0.85;
        playerHP = playerHP * 1.25;
        playerScale = playerScale * 0.8;
        playerMiningSpeed = playerMiningSpeed * 1.3;
        playerFireTime = playerFireTime * 0.5;
        playerKnockback = playerKnockback * 0.8; // to check if it should be inverted
        playerSafeFallRange = playerSafeFallRange * 1.25;

        System.out.println("Handling Dwarf race...");
    }

    static void handleUnknownRace(Player player) {
        System.out.println("Unknown race. Applying default settings...");

        attributeManager(player);
    }



    public static void modifyMovementSpeed(Player player, double value){
        AttributeInstance speedAttribute = player.getAttribute(Attribute.MOVEMENT_SPEED);
        assert speedAttribute != null;
        speedAttribute.setBaseValue(value);
    }
    public static void modifyHealthPoints(Player player, double value){
        AttributeInstance healthAttribute = player.getAttribute(Attribute.MAX_HEALTH);
        assert healthAttribute != null;
        healthAttribute.setBaseValue(value);
    }
    public static void modifyScale(Player player, double value){
        AttributeInstance scaleAttribute = player.getAttribute(Attribute.SCALE);
        assert scaleAttribute != null;
        scaleAttribute.setBaseValue(value);
    }
    public static void modifyMineSpeed(Player player, double value){
        AttributeInstance mineSpeedAttribute = player.getAttribute(Attribute.BLOCK_BREAK_SPEED);
        assert mineSpeedAttribute != null;
        mineSpeedAttribute.setBaseValue(value);
    }
    public static void modifyAttackDamage(Player player, double value){
        AttributeInstance attackSpeedAttribute = player.getAttribute(Attribute.ATTACK_DAMAGE);
        assert attackSpeedAttribute != null;
        attackSpeedAttribute.setBaseValue(value);
    }
    public static void modifyFireTime(Player player, double value){
        AttributeInstance burnTimeAttribute = player.getAttribute(Attribute.BURNING_TIME);
        assert burnTimeAttribute != null;
        burnTimeAttribute.setBaseValue(value);
    }
    public static void modifyGravity(Player player, double value){
        AttributeInstance gravityAttribute = player.getAttribute(Attribute.GRAVITY);
        assert gravityAttribute != null;
        gravityAttribute.setBaseValue(value);
    }
    public static void modifyFallDmgMultiplier(Player player, double value){
        AttributeInstance fallDmgAttribute = player.getAttribute(Attribute.FALL_DAMAGE_MULTIPLIER);
        assert fallDmgAttribute != null;
        fallDmgAttribute.setBaseValue(value);
    }
    public static void modifyKnockBack(Player player, double value){
        AttributeInstance knockbackResistAttribute = player.getAttribute(Attribute.KNOCKBACK_RESISTANCE);
        assert knockbackResistAttribute != null;
        knockbackResistAttribute.setBaseValue(value);
    }
    public static void modifyOxygenBonus(Player player, double value){
        AttributeInstance oxygenAttribute = player.getAttribute(Attribute.OXYGEN_BONUS);
        assert oxygenAttribute != null;
        oxygenAttribute.setBaseValue(value);
    }
    public static void modifyAttackSpeed(Player player, double value){
        AttributeInstance attackSpeedAttribute = player.getAttribute(Attribute.ATTACK_SPEED);
        assert attackSpeedAttribute != null;
        attackSpeedAttribute.setBaseValue(value);
    }
    public static void modifySafeFallRange(Player player, double value){
        AttributeInstance safeFallRangeAttribute = player.getAttribute(Attribute.SAFE_FALL_DISTANCE);
        assert safeFallRangeAttribute != null;
        safeFallRangeAttribute.setBaseValue(value);
    }
    public static void modifyWaterSpeed(Player player, double value){
        AttributeInstance waterSpeedAttribute = player.getAttribute(Attribute.WATER_MOVEMENT_EFFICIENCY);
        assert waterSpeedAttribute != null;
        waterSpeedAttribute.setBaseValue(value);
    }
    public static void modifyReach(Player player, double valueBlockReach, double valueEntityReach){
        AttributeInstance blockReachAttribute = player.getAttribute(Attribute.BLOCK_INTERACTION_RANGE);
        AttributeInstance entityReachAttribute = player.getAttribute(Attribute.ENTITY_INTERACTION_RANGE);
        assert blockReachAttribute != null;
        blockReachAttribute.setBaseValue(valueBlockReach);
        assert entityReachAttribute != null;
        entityReachAttribute.setBaseValue(valueEntityReach);
    }
}
