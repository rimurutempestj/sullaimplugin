package io.github.rimurutempestj.sullaimplugin;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class gm1 implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if (args.length == 0) { //arg가 없으면
            p.sendMessage("/gm [0/1/2/3]");
            return true;
        } else if (args[0].equalsIgnoreCase("1")) {
            p.setGameMode(GameMode.CREATIVE);
            p.sendMessage("Your gamemode is now creative");
            return true;
        } else if (args[0].equalsIgnoreCase("2")) {
            p.setGameMode(GameMode.ADVENTURE);
            p.sendMessage("Your gamemode is now adventure");
            return true;
        } else if (args[0].equalsIgnoreCase("3")) {
            p.setGameMode(GameMode.SPECTATOR);
            p.sendMessage("Your gamemode is now spectator");
            return true;
        } else if (args[0].equalsIgnoreCase("0")) {
            p.setGameMode(GameMode.SURVIVAL);
            p.sendMessage("Your gamemode is now survival");
            return true;
        } else {
            p.sendMessage("/gm [0/1/2/3]");
            return true;
        }
    }
}
