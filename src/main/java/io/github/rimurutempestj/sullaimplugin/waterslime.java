package io.github.rimurutempestj.sullaimplugin;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class waterslime implements CommandExecutor {
    public boolean onCommand(CommandSender snd, Command cmd, String label, String[] args) {
        Player p = (Player) snd;
        if (args.length == 0) { //arg가 없으면
            p.sendMessage("Please write water or lava");
            return true;
        } else if (args[0].equalsIgnoreCase("water")) {
            p.getLocation().getBlock().setType(Material.WATER);
            p.sendMessage("watered");
            return false;
        } else if (args[0].equalsIgnoreCase("lava")) {
            p.getLocation().getBlock().setType(Material.LAVA);
            p.sendMessage("Laved");
            return false;
        }
        return true;
    }

}
