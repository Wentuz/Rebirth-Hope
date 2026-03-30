package me.wentuziak.race2Szop.items;

import me.wentuziak.race2Szop.Race2Szop;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.EquipmentSlotGroup;

import static me.wentuziak.race2Szop.ItemKeys.LUCKY_TOOL;

public class getToolModifiers {

    public static final AttributeModifier handLuckAttribute = getLuckHandModifier();
    public static final AttributeModifier headLuckAttribute = getLuckHeadModifier();
    public static final AttributeModifier chestLuckAttribute = getLuckChestModifier();
    public static final AttributeModifier legsLuckAttribute = getLuckLeggingsModifier();
    public static final AttributeModifier feetLuckAttribute = getLuckBootsModifier();

    public static final AttributeModifier handMiningBonusAttribute = getMiningSpeedBonusHandModifier();

    public static final AttributeModifier handAttackSpeedOneAttribute = getAttackSpeedOneModifier();
    public static final AttributeModifier handAttackSpeedSwordAttribute = getAttackSpeedSwordModifier();
    public static final AttributeModifier handAttackSpeedPPickaxeAttribute = getAttackSpeedPickaxeModifier();

    public static final AttributeModifier handAttackDamage4Attribute = getAttackDamage4Modifier();
    public static final AttributeModifier handAttackDamage5Attribute = getAttackDamage5Modifier();
    public static final AttributeModifier handAttackDamage6Attribute = getAttackDamage6Modifier();
    public static final AttributeModifier handAttackDamage7Attribute = getAttackDamage7Modifier();
    public static final AttributeModifier handAttackDamage8Attribute = getAttackDamage8Modifier();
    public static final AttributeModifier handAttackDamage9Attribute = getAttackDamage9Modifier();
    public static final AttributeModifier handAttackDamage10Attribute = getAttackDamage10Modifier();



     //
     //       Luck modifiers
     //
    private static AttributeModifier getLuckHandModifier(){
        return new AttributeModifier(
                LUCKY_TOOL,
                1.0, // amount
                AttributeModifier.Operation.ADD_NUMBER,
                EquipmentSlotGroup.HAND // or specific group
        );
    }
    private static AttributeModifier getLuckHeadModifier(){
        return new AttributeModifier(
                new NamespacedKey(Race2Szop.getInstance(), "LuckyHead"),
                1.0, // amount
                AttributeModifier.Operation.ADD_NUMBER,
                EquipmentSlotGroup.HEAD // or specific group
        );
    }
    private static AttributeModifier getLuckChestModifier(){
        return new AttributeModifier(
                new NamespacedKey(Race2Szop.getInstance(), "LuckyChest"),
                1.0, // amount
                AttributeModifier.Operation.ADD_NUMBER,
                EquipmentSlotGroup.CHEST // or specific group
        );
    }
    private static AttributeModifier getLuckLeggingsModifier(){
        return new AttributeModifier(
                new NamespacedKey(Race2Szop.getInstance(), "LuckyLeggings"),
                1.0, // amount
                AttributeModifier.Operation.ADD_NUMBER,
                EquipmentSlotGroup.LEGS // or specific group
        );
    }
    private static AttributeModifier getLuckBootsModifier(){
        return new AttributeModifier(
                new NamespacedKey(Race2Szop.getInstance(), "LuckyBoots"),
                1.0, // amount
                AttributeModifier.Operation.ADD_NUMBER,
                EquipmentSlotGroup.FEET // or specific group
        );
    }


    private static AttributeModifier getMiningSpeedBonusHandModifier(){
        return new AttributeModifier(
                new NamespacedKey(Race2Szop.getInstance(), "MiningSpeedBonusAttribute"),
                1, // amount
                AttributeModifier.Operation.ADD_NUMBER,
                EquipmentSlotGroup.HAND // or specific group
        );
    }

     //
     //         Attack speeds
     //
    private static AttributeModifier getAttackSpeedSwordModifier(){
        return new AttributeModifier(
                new NamespacedKey(Race2Szop.getInstance(), "AttackSpeedSwordAttribute"),
                1.6 - 4, // amount
                AttributeModifier.Operation.ADD_NUMBER,
                EquipmentSlotGroup.HAND // or specific group
        );
    }
    private static AttributeModifier getAttackSpeedOneModifier(){
        return new AttributeModifier(
                new NamespacedKey(Race2Szop.getInstance(), "AttackSpeedOneAttribute"),
                1 - 4, // amount
                AttributeModifier.Operation.ADD_NUMBER,
                EquipmentSlotGroup.HAND // or specific group
        );
    }
    private static AttributeModifier getAttackSpeedPickaxeModifier(){
        return new AttributeModifier(
                new NamespacedKey(Race2Szop.getInstance(), "AttackSpeedPickaxeAttribute"),
                1.2 - 4, // amount
                AttributeModifier.Operation.ADD_NUMBER,
                EquipmentSlotGroup.HAND // or specific group
        );
    }

     //
     //         Attack Damage
     //
     private static AttributeModifier getAttackDamage4Modifier(){
         return new AttributeModifier(
                 new NamespacedKey(Race2Szop.getInstance(), "AttackDamage4Attribute"),
                 4, // amount
                 AttributeModifier.Operation.ADD_NUMBER,
                 EquipmentSlotGroup.HAND // or specific group
         );
     }
     private static AttributeModifier getAttackDamage5Modifier(){
         return new AttributeModifier(
                 new NamespacedKey(Race2Szop.getInstance(), "AttackDamage5Attribute"),
                 5, // amount
                 AttributeModifier.Operation.ADD_NUMBER,
                 EquipmentSlotGroup.HAND // or specific group
         );
     }
    private static AttributeModifier getAttackDamage6Modifier(){
        return new AttributeModifier(
                new NamespacedKey(Race2Szop.getInstance(), "AttackDamage6Attribute"),
                6, // amount
                AttributeModifier.Operation.ADD_NUMBER,
                EquipmentSlotGroup.HAND // or specific group
        );
    }
    private static AttributeModifier getAttackDamage7Modifier(){
        return new AttributeModifier(
                new NamespacedKey(Race2Szop.getInstance(), "AttackDamage7Attribute"),
                7, // amount
                AttributeModifier.Operation.ADD_NUMBER,
                EquipmentSlotGroup.HAND // or specific group
        );
    }
    private static AttributeModifier getAttackDamage8Modifier(){
        return new AttributeModifier(
                new NamespacedKey(Race2Szop.getInstance(), "AttackDamage8Attribute"),
                8, // amount
                AttributeModifier.Operation.ADD_NUMBER,
                EquipmentSlotGroup.HAND // or specific group
        );
    }
    private static AttributeModifier getAttackDamage9Modifier(){
        return new AttributeModifier(
                new NamespacedKey(Race2Szop.getInstance(), "AttackDamage9Attribute"),
                9, // amount
                AttributeModifier.Operation.ADD_NUMBER,
                EquipmentSlotGroup.HAND // or specific group
        );
    }
    private static AttributeModifier getAttackDamage10Modifier(){
        return new AttributeModifier(
                new NamespacedKey(Race2Szop.getInstance(), "AttackDamage10Attribute"),
                10, // amount
                AttributeModifier.Operation.ADD_NUMBER,
                EquipmentSlotGroup.HAND // or specific group
        );
    }
}
