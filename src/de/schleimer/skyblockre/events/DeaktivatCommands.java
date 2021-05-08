package de.schleimer.skyblockre.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import java.util.ArrayList;
import java.util.List;

public class DeaktivatCommands implements Listener {

    public static List<String> BlockedCommand = new ArrayList<>();
    public DeaktivatCommands (){
        BlockedCommand.add("?");
        BlockedCommand.add("about");
        BlockedCommand.add("achievment");
        BlockedCommand.add("ban");
        BlockedCommand.add("ban-ip");
        BlockedCommand.add("banlist");
        BlockedCommand.add("bukkit:?");
        BlockedCommand.add("bukkit:about");
        BlockedCommand.add("blockdata");
        BlockedCommand.add("bukkit:help");
        BlockedCommand.add("pl");
        BlockedCommand.add("bukkit:plugins");
        BlockedCommand.add("bukkit:reload");
        BlockedCommand.add("bukkit:timings");
        BlockedCommand.add("bukkit:rl");
        BlockedCommand.add("bukkit:ver");
        BlockedCommand.add("bukkit:version");
        BlockedCommand.add("bukkit:pl");
        BlockedCommand.add("clear");
        BlockedCommand.add("clone");
        BlockedCommand.add("debug");
        BlockedCommand.add("defaultgamemode");
        BlockedCommand.add("deop");
        BlockedCommand.add("difficulty");
        BlockedCommand.add("effect");
        BlockedCommand.add("entitydata");
        BlockedCommand.add("execute");
        BlockedCommand.add("fill");
        BlockedCommand.add("gamerule");
        BlockedCommand.add("give");
        BlockedCommand.add("help");
        BlockedCommand.add("kick");
        BlockedCommand.add("kill");
        BlockedCommand.add("list");
        BlockedCommand.add("me");
    }
    /*
    @EventHandler(priority = EventPriority.HIGHEST)
    public  void onTabComplete(PlayerChatTabCompleteEvent event){
        Collection<String> tabs=  event.getTabCompletions();
        for (String command:BlockedCommand) {
            if (tabs.contains(command)) {
                tabs.remove(command);
            }
        }

    }
     */

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onCommand(PlayerCommandPreprocessEvent e){
        if (e.getPlayer().hasPermission("skyblock.hidden")){
            return;
        }
        String s = e.getMessage().toString();
        for (String command:BlockedCommand){
            if (s.equalsIgnoreCase("/"+command)){
                e.setCancelled(true);
                return;
            }
        }


    }

}
