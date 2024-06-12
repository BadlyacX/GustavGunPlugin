package com.badlyac.GustavGun.Listeners.Player;

import com.badlyac.GustavGun.GustavGunMain;
import com.badlyac.GustavGun.Utils.Projectiles.shell;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.UUID;

public class GustavGunListener implements Listener {

    private final HashMap<UUID, Long> cooldowns = new HashMap<>();
    final long COOLDOWN_TIME = 50 * 1000;

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        ItemStack item = event.getItem();
        if (item != null && item.hasItemMeta() && (ChatColor.DARK_PURPLE + "古斯塔夫巨砲").equals(item.getItemMeta().getDisplayName())) {
            UUID playerId = event.getPlayer().getUniqueId();

            if (event.getAction().toString().contains("RIGHT")) {
                event.setCancelled(true);
                return;
            }

            if (event.getAction().toString().contains("LEFT")) {
                if (cooldowns.containsKey(playerId)) {
                    long lastUsed = cooldowns.get(playerId);
                    if (System.currentTimeMillis() - lastUsed < COOLDOWN_TIME) {
                        event.getPlayer().sendMessage(ChatColor.RED + "古斯塔夫巨砲正在冷卻中！");
                        return;
                    }
                }

                shell.launchLargeFireball(event.getPlayer());

                cooldowns.put(playerId, System.currentTimeMillis());

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        cooldowns.remove(playerId);
                        event.getPlayer().sendMessage(ChatColor.GREEN + "古斯塔夫巨砲冷卻結束！");
                    }
                }.runTaskLater(GustavGunMain.getInstance(), 20 * 20);
            }
        }
    }
}
