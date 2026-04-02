package me.wentuziak.race2Szop.items;

import me.wentuziak.race2Szop.Race2Szop;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.EquipmentSlotGroup;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
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
}
