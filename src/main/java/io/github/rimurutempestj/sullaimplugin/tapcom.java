package io.github.rimurutempestj.sullaimplugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class tapcom implements TabCompleter {

    List<String> arg = new ArrayList<String>();
    @Override
    public List<String> onTabComplete(CommandSender arg0, Command arg1, String arg2, String[] arg3){
        if(arg.isEmpty()) {
            arg.add("water");
            arg.add("lava");
        }
        return arg;
    }
}
