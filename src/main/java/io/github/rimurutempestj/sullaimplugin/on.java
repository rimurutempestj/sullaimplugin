package io.github.rimurutempestj.sullaimplugin;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class on implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender snd, Command cmd, String label, String[] args) {
        Player p = (Player) snd;
        Inventory inv = Bukkit.createInventory(null, 27, "gui");
        inv.setItem(13, new ItemStack(Material.GRASS_BLOCK));
        inv.setItem(11, new ItemStack(Material.COOKED_PORKCHOP));
        inv.setItem(15, new ItemStack(Material.ACACIA_BOAT));
        p.openInventory(inv);
        return true;
    }
}
