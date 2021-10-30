package io.github.rimurutempestj.sullaimplugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import javax.sql.rowset.spi.SyncFactoryException;

import static javax.sql.rowset.spi.SyncFactory.getLogger;

public final class Sullaimplugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("슬라임 플러그인 켜짐");
        getCommand("testslime").setExecutor(new testslime()); //testslime
        getCommand("kickslime").setExecutor(new kickslime()); //kickslime
        getCommand("gm").setExecutor(new gm1()); //gm
        getCommand("waterorlavaslime").setExecutor(new waterslime()); //waterorlavaslime
    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("슬라임 플러그인 꺼짐");
    }
}
