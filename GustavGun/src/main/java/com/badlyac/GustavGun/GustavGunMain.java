package com.badlyac.GustavGun;

import com.badlyac.GustavGun.Commands.getGustavGun;
import com.badlyac.GustavGun.Listeners.Player.GustavGunListener;
import com.badlyac.GustavGun.Utils.Item.GustavGun;
import org.bukkit.plugin.java.JavaPlugin;

public class GustavGunMain extends JavaPlugin {

    private GustavGun gustavGun;
    public static GustavGunMain instance;
    @Override
    public void onEnable() {
        instance = this;

        this.gustavGun = new GustavGun();
        getLogger().info("GustavGunPlugin 啟動成功！");

        getGustavGun getGustavGun = new getGustavGun();
        getCommand("getgustavgun").setExecutor(getGustavGun);

        getServer().getPluginManager().registerEvents(new GustavGunListener(), this);
    }

    @Override
    public void onDisable() {
        getLogger().info("GustavGunPlugin 已禁用！");
    }

    public static GustavGunMain getInstance() {
        return instance;
    }
}
