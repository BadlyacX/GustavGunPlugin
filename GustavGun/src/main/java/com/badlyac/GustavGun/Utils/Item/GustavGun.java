package com.badlyac.GustavGun.Utils.Item;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GustavGun {

    public static ItemStack createGustavGun() {
        ItemStack gustavGun = new ItemStack(Material.FIRE_CHARGE);

        ItemMeta meta = gustavGun.getItemMeta();

        if (meta != null) {
            meta.setDisplayName(ChatColor.DARK_PURPLE + "古斯塔夫巨砲");
            gustavGun.setItemMeta(meta);
        }

        return gustavGun;
    }
}
