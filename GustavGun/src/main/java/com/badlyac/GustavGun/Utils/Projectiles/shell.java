package com.badlyac.GustavGun.Utils.Projectiles;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class shell {
    public static void launchLargeFireball(Player player) {
        Location loc = player.getLocation();
        Vector dir = loc.getDirection().normalize();
        org.bukkit.entity.Fireball fireball = player.getWorld().spawn(loc.add(0, 1.6, 0), org.bukkit.entity.LargeFireball.class);
        fireball.setVelocity(dir.multiply(5));
        fireball.setShooter(player);
        fireball.setIsIncendiary(true);
        fireball.setYield(50);
    }
}
