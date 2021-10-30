package io.github.rimurutempestj.sullaimplugin;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class gm1 implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if (p.getGameMode().equals(GameMode.CREATIVE)) {
            p.setGameMode(GameMode.SURVIVAL);
        } else if (p.getGameMode().equals(GameMode.SURVIVAL)) {
            p.setGameMode(GameMode.CREATIVE);
            return true;
        }
        return false;
    }
}
