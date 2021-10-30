package io.github.rimurutempestj.sullaimplugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class kickslime implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender snd, Command cmd, String label, String[] args) {
        Player p = (Player) snd;
        p.kickPlayer("http://slimekkutu.kro.kr 많이많이 이용해주세요!");
        return true;
    }
}
