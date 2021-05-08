package de.schleimer.skyblockre.tabcomplete;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class IslandTab implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        List<String> completion = new ArrayList<>();
        if (strings.length == 1){

            completion.add("tp");
            completion.add("visit");
            completion.add("create");
            completion.add("shop");
            completion.add("help");
            completion.add("warp");
            completion.add("warps");
            completion.add("");
        }
        return completion;
    }
}
