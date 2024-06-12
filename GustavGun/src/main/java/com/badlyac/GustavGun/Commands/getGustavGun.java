package com.badlyac.GustavGun.Commands;

import com.badlyac.GustavGun.Utils.Item.GustavGun;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class getGustavGun implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (command.getName().equalsIgnoreCase("getgustavgun")) {
                player.getInventory().addItem(GustavGun.createGustavGun());
                player.sendMessage(ChatColor.DARK_RED + "你已獲得古斯塔夫巨砲！");
                return true;
            }
        } else {
            sender.sendMessage(ChatColor.RED + "這個命令只能由玩家執行！");
        }
        return false;
    }
}
