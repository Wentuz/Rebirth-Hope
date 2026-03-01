package me.wentuziak.race2Szop.attribute;

import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Player;

import static me.wentuziak.race2Szop.attribute.AttributeManager.attributeManager;

public class AttributeModifier {

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
