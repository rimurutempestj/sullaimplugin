package io.github.rimurutempestj.sullaimplugin;

import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Sullaimplugin extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getPluginManager().registerEvents(this, this);
        Bukkit.getPluginCommand("waterorlavaslime").setTabCompleter(new tapcom());
        getLogger().info("슬라임 플러그인 켜짐");
        getCommand("testslime").setExecutor(new testslime()); //testslime
        getCommand("kickslime").setExecutor(new kickslime()); //kickslime
        getCommand("gm").setExecutor(new gm1()); //gm
        getCommand("waterorlavaslime").setExecutor(new waterslime()); //waterorlavaslime
        getCommand("openmenu").setExecutor(new on()); //openmenu
    }
    @EventHandler
    public void onClick(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        Action a = e.getAction();

        if(a == Action.LEFT_CLICK_AIR) {
            p.sendMessage("You was left-clicked on air");
        } else if(a == Action.LEFT_CLICK_BLOCK) {
            p.sendMessage("You was left-clicked on block");
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("슬라임 플러그인 꺼짐");
    }
}
