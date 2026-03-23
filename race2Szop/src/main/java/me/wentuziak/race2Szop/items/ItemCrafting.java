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

import static me.wentuziak.race2Szop.ItemKeys.LUCKY_TOOL;
import static me.wentuziak.race2Szop.items.getToolModifiers.*;
import static org.bukkit.Bukkit.getLogger;

public class ItemCrafting {



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
        ItemStack quickPick = new ItemStack(Material.DIAMOND_PICKAXE);
        ItemMeta quickPickMeta = quickPick.getItemMeta();

        assert quickPickMeta != null;
        quickPickMeta.setDisplayName(ChatColor.GOLD + "Quick Pick");

        quickPickMeta.addAttributeModifier(Attribute.BLOCK_BREAK_SPEED, handMiningBonusAttribute);
        quickPickMeta.addAttributeModifier(Attribute.ATTACK_SPEED, handAttackSpeedPPickaxeAttribute);
        quickPickMeta.addAttributeModifier(Attribute.ATTACK_DAMAGE, handAttackDamage5Attribute);

        quickPick.setItemMeta(quickPickMeta);

        return quickPick;
    }
}
