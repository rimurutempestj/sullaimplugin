package io.github.rimurutempestj.sullaimplugin;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
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
import java.util.HashMap;
import java.util.UUID;

public final class Sullaimplugin extends JavaPlugin implements Listener {
    Inventory inv2 = Bukkit.createInventory(null, 27, "상점");
    HashMap<UUID, Long> cooltime = new HashMap<UUID, Long>();
    HashMap<UUID, Location> home = new HashMap<UUID, Location>();

    @Override
    public void onEnable() {
        // Plugin startup logic

        ItemStack wool = new ItemStack(Material.WHITE_WOOL); // ---------------------------------------
        ItemMeta woolmeta = wool.getItemMeta();
        woolmeta.setDisplayName("양털 X16");
        woolmeta.setLore(Arrays.asList("클릭시 구매 (철 4개)"));
        wool.setItemMeta(woolmeta);
        inv2.setItem(11, wool); // ---------------------------------------------------------------
        ItemStack planks = new ItemStack(Material.SPRUCE_PLANKS); // ---------------------------------------
        ItemMeta planksmeta = planks.getItemMeta();
        planksmeta.setDisplayName("판자 X16");
        planksmeta.setLore(Arrays.asList("클릭시 구매 (금 4개)"));
        planks.setItemMeta(planksmeta);
        inv2.setItem(12, planks); // ---------------------------------------------------------------
        ItemStack opsi = new ItemStack(Material.OBSIDIAN); // ---------------------------------------
        ItemMeta opsimeta = opsi.getItemMeta();
        opsimeta.setDisplayName("흑요석 X4");
        opsimeta.setLore(Arrays.asList("클릭시 구매 (에메랄드 5개)"));
        opsi.setItemMeta(opsimeta);
        inv2.setItem(13, opsi); // ---------------------------------------------------------------
        ItemStack is = new ItemStack(Material.IRON_SWORD); // ---------------------------------------
        ItemMeta isme = is.getItemMeta();
        isme.setLore(Arrays.asList("클릭시 구매 (금 7개)"));
        is.setItemMeta(isme);
        inv2.setItem(14, is); // ---------------------------------------------------------------
        ItemStack ds = new ItemStack(Material.DIAMOND_SWORD); // ---------------------------------------
        ItemMeta dsme = ds.getItemMeta();
        dsme.setLore(Arrays.asList("클릭시 구매 (에메랄드 4개)"));
        ds.setItemMeta(dsme);
        inv2.setItem(15, ds); // ---------------------------------------------------------------
        ItemStack airm = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
        ItemMeta airmm = airm.getItemMeta();
        airmm.setDisplayName(" ");
        airm.setItemMeta(airmm);
        inv2.setItem(0, airm);
        inv2.setItem(1, airm);
        inv2.setItem(2, airm);
        inv2.setItem(3, airm);
        inv2.setItem(4, airm);
        inv2.setItem(5, airm);
        inv2.setItem(6, airm);
        inv2.setItem(7, airm);
        inv2.setItem(8, airm);
        inv2.setItem(9, airm);
        inv2.setItem(10, airm);
        inv2.setItem(16, airm);
        inv2.setItem(17, airm);
        inv2.setItem(18, airm);
        inv2.setItem(19, airm);
        inv2.setItem(20, airm);
        inv2.setItem(21, airm);
        inv2.setItem(22, airm);
        inv2.setItem(23, airm);
        inv2.setItem(24, airm);
        inv2.setItem(25, airm);
        inv2.setItem(26, airm);
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
            e.setCancelled(true);
            p.openInventory(inv2);
        }
    }

    @EventHandler
    public void onClick(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        Action a = e.getAction();
        UUID uuid = p.getUniqueId();
        if(a == Action.RIGHT_CLICK_AIR || a == Action.RIGHT_CLICK_BLOCK) {
            if(p.getItemInHand().getType().equals(Material.BLAZE_ROD)) {

                int cool = 3;
                if(cooltime.containsKey(uuid)) {
                    long timeLeft = ((cooltime.get(uuid) / 1000) + cool) - System.currentTimeMillis() / 1000;
                    if(timeLeft > 0) {
                        p.sendMessage("쿨타임이" + timeLeft + "초 남았습니다.");
                        return;
                    }
                }

                cooltime.put(uuid, System.currentTimeMillis());
                p.setVelocity(p.getLocation().getDirection());
                p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_ATTACK_SWEEP, 1.0f, 1.0f);
            }
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

            } else if(e.getCurrentItem().getType().equals(Material.SPRUCE_PLANKS)) { //SPRUCE_PLANKS
                if(p.getInventory().containsAtLeast(new ItemStack(Material.GOLD_INGOT), 4)) { //금이 있는지 감지 (4개 이상)
                    ItemStack planks = new ItemStack(Material.SPRUCE_PLANKS);
                    planks.setAmount(16);
                    p.getInventory().addItem(planks);
                    ItemStack gold = new ItemStack(Material.GOLD_INGOT);
                    gold.setAmount(4);
                    p.getInventory().removeItem(gold);
                    p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 1.0f); //구매 소리 재생
                } else {
                    p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1.0f, 1.0f); //NO소리 재생
                    p.sendMessage("금이 부족합니다(4개 필요)");
                }

            } else if(e.getCurrentItem().getType().equals(Material.OBSIDIAN)) { //OBSIDIAN
                if(p.getInventory().containsAtLeast(new ItemStack(Material.EMERALD), 5)) { //에메랄드가 있는지 감지 (5개 이상)
                    ItemStack opsi = new ItemStack(Material.OBSIDIAN);
                    opsi.setAmount(4);
                    p.getInventory().addItem(opsi);
                    ItemStack em = new ItemStack(Material.EMERALD);
                    em.setAmount(5);
                    p.getInventory().removeItem(em);
                    p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 1.0f); //구매 소리 재생
                } else {
                    p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1.0f, 1.0f); //NO소리 재생
                    p.sendMessage("에메랄드가 부족합니다(5개 필요)");
                }

            } else if(e.getCurrentItem().getType().equals(Material.IRON_SWORD)) { //IRON_SWORD
                if(p.getInventory().containsAtLeast(new ItemStack(Material.GOLD_INGOT), 7)) { //금이 있는지 감지 (7개 이상)
                    p.getInventory().addItem(new ItemStack(Material.IRON_SWORD));
                    ItemStack gold = new ItemStack(Material.GOLD_INGOT);
                    gold.setAmount(7);
                    p.getInventory().removeItem(gold);
                    p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 1.0f); //구매 소리 재생
                } else {
                    p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1.0f, 1.0f); //NO소리 재생
                    p.sendMessage("금이 부족합니다(7개 필요)");
                }

            } else if(e.getCurrentItem().getType().equals(Material.DIAMOND_SWORD)) { //DIAMOND_SWORD
                if(p.getInventory().containsAtLeast(new ItemStack(Material.EMERALD), 4)) { //에메랄드가 있는지 감지 (4개 이상)
                    p.getInventory().addItem(new ItemStack(Material.DIAMOND_SWORD));
                    ItemStack em = new ItemStack(Material.EMERALD);
                    em.setAmount(4);
                    p.getInventory().removeItem(em);
                    p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 1.0f); //구매 소리 재생
                } else {
                    p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1.0f, 1.0f); //NO소리 재생
                    p.sendMessage("에메랄드가 부족합니다(4개 필요)");
                }

            }
        }
    }

    @Override
    public boolean onCommand(CommandSender snd, Command cmd, String label, String[] args) {
        if(label.equalsIgnoreCase("sethome")) {
            Player p = (Player) snd;
            Location loc = p.getLocation();
            home.put(p.getUniqueId(), loc);
            p.sendMessage("집이 설정되었습니다.");
        } else if(label.equalsIgnoreCase("home")) {
            Player p = (Player) snd;
            if(home.containsKey(p.getUniqueId())) {
                Location loc = home.get(p.getUniqueId());
                p.teleport(loc);
            } else {
                p.sendMessage("집이 없습니다. 집을 설정해주세요 [/sethome]");
            }
        }
        return false;
    }
    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("슬라임 플러그인 꺼짐");
    }
}
