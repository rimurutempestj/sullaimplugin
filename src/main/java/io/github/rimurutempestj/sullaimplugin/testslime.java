package io.github.rimurutempestj.sullaimplugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class testslime implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender snd, Command cmd, String label, String[] args) {
        Player p = (Player) snd;
        p.sendMessage("testslimedesu");
        return true;
    }
}
