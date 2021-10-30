package io.github.rimurutempestj.sullaimplugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class tapcom1 implements TabCompleter {
    List<String> arg = new ArrayList<String>();
    @Override
    public List<String> onTabComplete(CommandSender arg0, Command arg1, String arg2, String[] arg3){
        if(arg.isEmpty()) {
            arg.add("0");
            arg.add("1");
            arg.add("2");
            arg.add("3");
        }
        return arg;
    }
}
