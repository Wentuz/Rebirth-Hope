package me.wentuziak.race2Szop.items;

import me.wentuziak.race2Szop.Race2Szop;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.EquipmentSlotGroup;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import static me.wentuziak.race2Szop.ItemKeys.LUCKY_TOOL;

public class ItemCrafting {

//    @SuppressWarnings("deprecation")
//    public static ItemStack createLuckyPick(){
//        ItemStack luckyPick = new ItemStack(Material.DIAMOND_PICKAXE);
//        ItemMeta luckyPickMeta = luckyPick.getItemMeta();
//
//        luckyPickMeta.setDisplayName(ChatColor.DARK_PURPLE + "Lucky Pickaxe");
//
//        luckyPickMeta.getPersistentDataContainer().set(LUCKY_TOOL, PersistentDataType.BOOLEAN, true);
//
//        AttributeModifier attackSpeedModifierAngelSword = new AttributeModifier(UUID.randomUUID(), "AttackSpeed", -2.4, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
//        luckyPickMeta.addAttributeModifier(Attribute.ATTACK_SPEED, attackSpeedModifierAngelSword);
//        AttributeModifier attackDamageModifierAngelSword = new AttributeModifier(UUID.randomUUID(), "AttackDamage", 8.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
//        luckyPickMeta.addAttributeModifier(Attribute.ATTACK_DAMAGE, attackDamageModifierAngelSword);
//        luckyPick.setItemMeta(luckyPickMeta);
//
//        return luckyPick;
//    }

    public static ItemStack createQuickPick(){
        ItemStack quickPick = new ItemStack(Material.GOLDEN_PICKAXE);
        ItemMeta quickPickMeta = quickPick.getItemMeta();

        assert quickPickMeta != null;
        quickPickMeta.setDisplayName(ChatColor.GOLD + "Quick Pick");

        quickPickMeta.getAttributeModifiers();

        quickPickMeta.addAttributeModifier(Attribute.BLOCK_BREAK_SPEED, getMiningSpeedModifier());
        quickPick.setItemMeta(quickPickMeta);

        return quickPick;
    }


    private static AttributeModifier getLuckModifier(){
        return new AttributeModifier(
                LUCKY_TOOL,
                1.0, // amount
                AttributeModifier.Operation.ADD_NUMBER,
                EquipmentSlotGroup.HAND // or specific group
        );
    }

    private static AttributeModifier getMiningSpeedModifier(){
        return new AttributeModifier(
                new NamespacedKey(Race2Szop.getInstance(), "MiningSpeedAttribute"),
                1.0, // amount
                AttributeModifier.Operation.ADD_NUMBER,
                EquipmentSlotGroup.HAND // or specific group
        );
    }

}
