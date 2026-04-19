package me.wentuziak.race2Szop.items;

import me.wentuziak.race2Szop.Race2Szop;
import org.bukkit.*;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.EquipmentSlotGroup;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.components.ToolComponent;
import org.bukkit.inventory.meta.components.WeaponComponent;
import org.bukkit.inventory.meta.components.consumable.ConsumableComponent;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

import static me.wentuziak.race2Szop.ItemKeys.*;
import static me.wentuziak.race2Szop.items.getToolModifiers.*;
import static org.bukkit.Bukkit.getLogger;

public class ItemCrafting {

     //------------------------------------------------------------------------------------
     //                                     PICKAXES
     //------------------------------------------------------------------------------------

    @SuppressWarnings("deprecation")
    public static ItemStack createLuckyPick(){
        ItemStack luckyPick = new ItemStack(Material.NETHERITE_PICKAXE);
        ItemMeta luckyPickMeta = luckyPick.getItemMeta();

        luckyPickMeta.setDisplayName(ChatColor.DARK_PURPLE + "Lucky Pickaxe");

        luckyPickMeta.getPersistentDataContainer().set(LUCKY_TOOL, PersistentDataType.BOOLEAN, true);


        luckyPickMeta.addAttributeModifier(Attribute.LUCK, handLuckAttribute);
        luckyPickMeta.addAttributeModifier(Attribute.ATTACK_SPEED, handAttackSpeedPPickaxeAttribute);
        luckyPickMeta.addAttributeModifier(Attribute.ATTACK_DAMAGE, handAttackDamage5Attribute);


        luckyPick.setItemMeta(luckyPickMeta);

        return luckyPick;
    }

    public static ItemStack createQuickPick(){
        ItemStack item = new ItemStack(Material.DIAMOND_PICKAXE);
        ItemMeta itemMeta = item.getItemMeta();

        assert itemMeta != null;
        itemMeta.setDisplayName(ChatColor.GOLD + "Quick Pick");

        itemMeta.addAttributeModifier(Attribute.BLOCK_BREAK_SPEED, handMiningBonusAttribute);
        itemMeta.addAttributeModifier(Attribute.ATTACK_SPEED, handAttackSpeedPPickaxeAttribute);
        itemMeta.addAttributeModifier(Attribute.ATTACK_DAMAGE, handAttackDamage5Attribute);

        item.setItemMeta(itemMeta);

        return item;
    }

    //------------------------------------------------------------------------------------
    //                                     AXES
    //------------------------------------------------------------------------------------

    public static ItemStack createQuickAxe(){
        ItemStack item = new ItemStack(Material.DIAMOND_AXE);
        ItemMeta itemMeta = item.getItemMeta();

        assert itemMeta != null;
        itemMeta.setDisplayName(ChatColor.GOLD + "Quick Axe");

        itemMeta.addAttributeModifier(Attribute.BLOCK_BREAK_SPEED, handMiningBonusAttribute);
        itemMeta.addAttributeModifier(Attribute.ATTACK_SPEED, handAttackSpeedOneAttribute);
        itemMeta.addAttributeModifier(Attribute.ATTACK_DAMAGE, handAttackDamage9Attribute);

        item.setItemMeta(itemMeta);

        return item;
    }
    public static ItemStack createLuckyAxe(){
        ItemStack item = new ItemStack(Material.NETHERITE_AXE);
        ItemMeta itemMeta = item.getItemMeta();

        assert itemMeta != null;
        itemMeta.setDisplayName(ChatColor.DARK_PURPLE + "Lucky Axe");

        itemMeta.getPersistentDataContainer().set(LUCKY_TOOL, PersistentDataType.BOOLEAN, true);

        itemMeta.addAttributeModifier(Attribute.LUCK, handLuckAttribute);
        itemMeta.addAttributeModifier(Attribute.ATTACK_SPEED, handAttackSpeedOneAttribute);
        itemMeta.addAttributeModifier(Attribute.ATTACK_DAMAGE, handAttackDamage9Attribute);

        item.setItemMeta(itemMeta);

        return item;
    }

    //------------------------------------------------------------------------------------
    //                                     HOES
    //------------------------------------------------------------------------------------

    public static ItemStack createLuckyHoe(){
        ItemStack item = new ItemStack(Material.NETHERITE_HOE);
        ItemMeta itemMeta = item.getItemMeta();

        assert itemMeta != null;
        itemMeta.setDisplayName(ChatColor.DARK_PURPLE + "Lucky Hoe");

        itemMeta.getPersistentDataContainer().set(LUCKY_TOOL, PersistentDataType.BOOLEAN, true);

        itemMeta.addAttributeModifier(Attribute.LUCK, handLuckAttribute);
        itemMeta.addAttributeModifier(Attribute.ATTACK_SPEED, handAttackSpeedOneAttribute);
        itemMeta.addAttributeModifier(Attribute.ATTACK_DAMAGE, handAttackDamage4Attribute);

        item.setItemMeta(itemMeta);

        return item;
    }

    //------------------------------------------------------------------------------------
    //                                     SHOVELS
    //------------------------------------------------------------------------------------

    public static ItemStack createLuckyShovel(){
        ItemStack item = new ItemStack(Material.NETHERITE_SHOVEL);
        ItemMeta itemMeta = item.getItemMeta();

        assert itemMeta != null;
        itemMeta.setDisplayName(ChatColor.DARK_PURPLE + "Lucky Shovel");

        itemMeta.getPersistentDataContainer().set(LUCKY_TOOL, PersistentDataType.BOOLEAN, true);

        itemMeta.addAttributeModifier(Attribute.LUCK, handLuckAttribute);
        itemMeta.addAttributeModifier(Attribute.ATTACK_SPEED, handAttackSpeedOneAttribute);
        itemMeta.addAttributeModifier(Attribute.ATTACK_DAMAGE, handAttackDamage4Attribute);

        item.setItemMeta(itemMeta);

        return item;
    }

    //------------------------------------------------------------------------------------
    //                                     SWORDS
    //------------------------------------------------------------------------------------

    //------------------------------------------------------------------------------------
    //                                     BOWS
    //------------------------------------------------------------------------------------

    public static ItemStack createMultiAttackBow(){
        ItemStack item = new ItemStack(Material.BOW);
        ItemMeta itemMeta = item.getItemMeta();

        assert itemMeta != null;
        itemMeta.setDisplayName(ChatColor.YELLOW + "Multi Attack Bow");
        itemMeta.setLore(List.of(ChatColor.BOLD + "Multi Attack"));

        itemMeta.getPersistentDataContainer().set(MULTI_ATTACK_EFFECT, PersistentDataType.BOOLEAN, true);

        item.setItemMeta(itemMeta);

        return item;
    }

    //------------------------------------------------------------------------------------
    //                                     BOWS
    //------------------------------------------------------------------------------------

    public static ItemStack createMultiAttackCrossBow(){
        ItemStack item = new ItemStack(Material.CROSSBOW);
        ItemMeta itemMeta = item.getItemMeta();

        assert itemMeta != null;
        itemMeta.setDisplayName(ChatColor.YELLOW + "Multi Attack CrossBow");
        itemMeta.setLore(List.of(ChatColor.BOLD + "Multi Attack"));

        itemMeta.getPersistentDataContainer().set(MULTI_ATTACK_EFFECT, PersistentDataType.BOOLEAN, true);

        item.setItemMeta(itemMeta);

        return item;
    }

    public static ItemStack createBlazeCrossBow(){
        ItemStack item = new ItemStack(Material.CROSSBOW);
        ItemMeta itemMeta = item.getItemMeta();

        assert itemMeta != null;
        itemMeta.setDisplayName(ChatColor.GOLD + "Blaze CrossBow");

        itemMeta.getPersistentDataContainer().set(BLAZE_EFFECT, PersistentDataType.BOOLEAN, true);

        item.setItemMeta(itemMeta);

        return item;
    }

    //------------------------------------------------------------------------------------
    //                                     MISCELLANEOUS
    //------------------------------------------------------------------------------------
    public static ItemStack createKnockBackSalmon(){
        ItemStack item = new ItemStack(Material.SALMON);
        ItemMeta itemMeta = item.getItemMeta();

        assert itemMeta != null;
        itemMeta.setDisplayName(ChatColor.RED + "Salmon of absolute STENCH");

        itemMeta.addAttributeModifier(Attribute.ATTACK_KNOCKBACK, handKnockback10Attribute);
        item.setItemMeta(itemMeta);

        return item;
    }
    public static ItemStack createBlazeLighter(){
        ItemStack item = new ItemStack(Material.FLINT_AND_STEEL);
        ItemMeta itemMeta = item.getItemMeta();

        assert itemMeta != null;
        itemMeta.setDisplayName(ChatColor.GOLD + "Blaze Flint 'n steel");
        itemMeta.setLore(List.of(ChatColor.YELLOW + "No powder ?"));

        itemMeta.getPersistentDataContainer().set(BLAZE_EFFECT, PersistentDataType.BOOLEAN, true);

        itemMeta.addAttributeModifier(Attribute.ATTACK_DAMAGE, offhandAttackDamage2Attribute);
        itemMeta.addAttributeModifier(Attribute.BURNING_TIME, offhandMinus20Attribute);

        item.setItemMeta(itemMeta);

        return item;
    }
    //------------------------------------------------------------------------------------
    //                                     BOOTS
    //------------------------------------------------------------------------------------
    public static ItemStack createSlimeBoots(){
        ItemStack item = new ItemStack(Material.LEATHER_BOOTS);
        ItemMeta itemMeta = item.getItemMeta();

        assert itemMeta != null;
        itemMeta.setDisplayName(ChatColor.GREEN + "Slime Boots");
        itemMeta.setLore(List.of(ChatColor.DARK_GREEN + "Don't lick them"));
        ((LeatherArmorMeta) itemMeta).setColor(Color.GREEN);

        itemMeta.getPersistentDataContainer().set(SLIMY_EFFECT, PersistentDataType.BOOLEAN, true);
        itemMeta.addAttributeModifier(Attribute.ARMOR, feetArmor2Attribute);
        itemMeta.addAttributeModifier(Attribute.FALL_DAMAGE_MULTIPLIER, feetFall20Attribute);
        itemMeta.addAttributeModifier(Attribute.JUMP_STRENGTH, feetJump2Attribute);

        item.setItemMeta(itemMeta);

        return item;
    }

    public static ItemStack createExplosionBoots(){
        ItemStack item = new ItemStack(Material.IRON_BOOTS);
        ItemMeta itemMeta = item.getItemMeta();

        assert itemMeta != null;
        itemMeta.setDisplayName(ChatColor.RED + "Explosive Boots");
        itemMeta.setLore(List.of(ChatColor.DARK_RED + "Safe to lick"));

        itemMeta.getPersistentDataContainer().set(EXPLOSIVE_EFFECT, PersistentDataType.BOOLEAN, true);
        item.setItemMeta(itemMeta);

        return item;
    }


    public static ItemStack createHermesBoots(){
        ItemStack item = new ItemStack(Material.CHAINMAIL_BOOTS);
        ItemMeta itemMeta = item.getItemMeta();

        assert itemMeta != null;
        itemMeta.setDisplayName(ChatColor.DARK_PURPLE + "Hermes Boots");
        itemMeta.setLore(List.of(ChatColor.GOLD + "don't shoot the messenger"));

        itemMeta.addAttributeModifier(Attribute.ARMOR, feetArmor2Attribute);
        itemMeta.addAttributeModifier(Attribute.MOVEMENT_SPEED, feetJump2Attribute);
        itemMeta.addAttributeModifier(Attribute.STEP_HEIGHT, feetStep1Attribute);

        item.setItemMeta(itemMeta);

        return item;
    }

    //------------------------------------------------------------------------------------
    //                                     CHESTPLATES
    //------------------------------------------------------------------------------------
    public static ItemStack createJetPack(){
        ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta itemMeta = item.getItemMeta();

        assert itemMeta != null;
        itemMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Star Chestplate");
        itemMeta.setLore(List.of(ChatColor.GOLD + "fire works ?"));

        itemMeta.getPersistentDataContainer().set(PHANTOM_EFFECT, PersistentDataType.BOOLEAN, true);

        item.setItemMeta(itemMeta);

        return item;
    }

    public static ItemStack createLevitatingChest(){
        ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta itemMeta = item.getItemMeta();

        assert itemMeta != null;
        itemMeta.setDisplayName(ChatColor.DARK_PURPLE + "box");
        itemMeta.setLore(List.of(ChatColor.GOLD + "Like being hit by a shulker"));

        itemMeta.getPersistentDataContainer().set(PHANTOM_EFFECT, PersistentDataType.BOOLEAN, true);

        item.setItemMeta(itemMeta);

        return item;
    }

}
