package io.github.rimurutempestj.sullaimplugin;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

public final class Sullaimplugin extends JavaPlugin implements Listener {
    Inventory inv2 = Bukkit.createInventory(null, 27, "상점");

    @Override
    public void onEnable() {
        // Plugin startup logic

        ItemStack wool = new ItemStack(Material.WHITE_WOOL);
        ItemMeta woolmeta = wool.getItemMeta();
        woolmeta.setDisplayName("양털");
        woolmeta.setLore(Arrays.asList("클릭하면 16개 지급"));
        wool.setItemMeta(woolmeta);
        inv2.setItem(11, wool);
        Bukkit.getPluginManager().registerEvents(this, this);
        Bukkit.getPluginCommand("waterorlavaslime").setTabCompleter(new tapcom());
        Bukkit.getPluginCommand("gm").setTabCompleter(new tapcom1());
        getLogger().info("슬라임 플러그인 켜짐");
        getCommand("testslime").setExecutor(new testslime()); //testslime
        getCommand("kickslime").setExecutor(new kickslime()); //kickslime
        getCommand("gm").setExecutor(new gm1()); //gm
        getCommand("waterorlavaslime").setExecutor(new waterslime()); //waterorlavaslime
        getCommand("openmenu").setExecutor(new on()); //openmenu
        getCommand("cls").setExecutor(new cls()); //cls
    }

    @EventHandler
    public void onClick(PlayerInteractAtEntityEvent e) {
        Player p = e.getPlayer();
        Entity en = e.getRightClicked();

        if(en.getType().equals(EntityType.VILLAGER)) {
            p.openInventory(inv2);
        }
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if(e.getClickedInventory().equals(inv2)) {
            e.setCancelled(true); //상점에서 클릭 취소
            if(e.getCurrentItem().getType().equals(Material.WHITE_WOOL)) { //WHITE_WOOL
                if(p.getInventory().containsAtLeast(new ItemStack(Material.IRON_INGOT), 4)) { //철이 있는지 감지 (4개 이상)
                    ItemStack wool = new ItemStack(Material.WHITE_WOOL);
                    wool.setAmount(16);
                    p.getInventory().addItem(wool);
                    ItemStack iron = new ItemStack(Material.IRON_INGOT);
                    iron.setAmount(4);
                    p.getInventory().removeItem(iron);
                    p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 1.0f); //구매 소리 재생
                } else {
                    p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1.0f, 1.0f); //NO소리 재생
                    p.sendMessage("철이 부족합니다(4개 필요)");
                }

            }
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("슬라임 플러그인 꺼짐");
    }
}
