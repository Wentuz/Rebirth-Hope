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
import static org.bukkit.Bukkit.getLogger;

public class ItemCrafting {

    private static final AttributeModifier handLuckAttribute = getLuckModifier();
    private static final AttributeModifier handMiningBonusAttribute = getMiningSpeedBonusModifier();

    @SuppressWarnings("deprecation")
    public static ItemStack createLuckyPick(){
        ItemStack luckyPick = new ItemStack(Material.DIAMOND_PICKAXE);
        ItemMeta luckyPickMeta = luckyPick.getItemMeta();

        luckyPickMeta.setDisplayName(ChatColor.DARK_PURPLE + "Lucky Pickaxe");

        luckyPickMeta.getPersistentDataContainer().set(LUCKY_TOOL, PersistentDataType.BOOLEAN, true);


        luckyPickMeta.addAttributeModifier(Attribute.LUCK, handLuckAttribute);

        luckyPick.setItemMeta(luckyPickMeta);

        return luckyPick;
    }


    // TODO:
    //   break it down into small shits
    //   omg i cant do this rn ...

    public static ItemStack createQuickPick(){
        ItemStack quickPick = new ItemStack(Material.NETHERITE_PICKAXE);
        ItemMeta quickPickMeta = quickPick.getItemMeta();

        assert quickPickMeta != null;
        quickPickMeta.setDisplayName(ChatColor.GOLD + "Quick Pick");

        quickPickMeta.addAttributeModifier(Attribute.BLOCK_BREAK_SPEED, handMiningBonusAttribute);

        //quickPick = setBasicTool(quickPick, new ItemStack(Material.DIAMOND_PICKAXE));
        quickPick.setItemMeta(quickPickMeta);

        return quickPick;
    }

    private static ItemStack setBasicTool(ItemStack item, ItemStack targetTool){
        ItemMeta itemMeta = item.getItemMeta();
        ItemMeta targetToolMeta = targetTool.getItemMeta();

        if (itemMeta == null || targetToolMeta == null) return item;

        ToolComponent targetToolComponent = targetToolMeta.getTool();
        if (targetToolComponent == null) return item;

        ToolComponent tool = itemMeta.getTool();

        List<ToolComponent.ToolRule> rules = new ArrayList<>();
        rules.addAll(targetToolComponent.getRules());

        tool.setRules(rules);

        getLogger().info("SET BASIC TOOL : " + rules + " " + targetTool.getType());
        tool.setDefaultMiningSpeed(targetToolComponent.getDefaultMiningSpeed());

        itemMeta.setTool(tool);
        item.setItemMeta(itemMeta);
        return item;
    }


    private static AttributeModifier getLuckModifier(){
        return new AttributeModifier(
                LUCKY_TOOL,
                1.0, // amount
                AttributeModifier.Operation.ADD_NUMBER,
                EquipmentSlotGroup.HAND // or specific group
        );
    }

    private static AttributeModifier getMiningSpeedBonusModifier(){
        return new AttributeModifier(
                new NamespacedKey(Race2Szop.getInstance(), "MiningSpeedBonusAttribute"),
                1, // amount
                AttributeModifier.Operation.ADD_NUMBER,
                EquipmentSlotGroup.HAND // or specific group
        );
    }
}
