package io.github.rimurutempestj.sullaimplugin;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Sullaimplugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getPluginCommand("waterorlavaslime").setTabCompleter(new tapcom());
        getLogger().info("슬라임 플러그인 켜짐");
        getCommand("testslime").setExecutor(new testslime()); //testslime
        getCommand("kickslime").setExecutor(new kickslime()); //kickslime
        getCommand("gm").setExecutor(new gm1()); //gm
        getCommand("waterorlavaslime").setExecutor(new waterslime()); //waterorlavaslime
        getCommand("openmenu").setExecutor(new on()); //openmenu
    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("슬라임 플러그인 꺼짐");
    }
}
