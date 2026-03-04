package me.wentuziak.race2Szop.lootTables;

import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class LuckCalculator {

    public static int getLuckLevel(Player player){
        return 	getHandLuck(player.getInventory().getItemInMainHand())
                + getLuckAttribute(player);
    }

    private static int getHandLuck(ItemStack itemStack) {
        int lootingLvl = itemStack.getEnchantmentLevel(Enchantment.LOOTING);
        int fortuneLvl = itemStack.getEnchantmentLevel(Enchantment.FORTUNE);
        int luckOfSeaLvl = itemStack.getEnchantmentLevel(Enchantment.LUCK_OF_THE_SEA);

        return lootingLvl + fortuneLvl + luckOfSeaLvl;
    }

    private static int getLuckAttribute(Player player) {
        AttributeInstance luckAttribute = player.getAttribute(Attribute.LUCK);
        return (int) luckAttribute.getValue() / 2;
    }

}
