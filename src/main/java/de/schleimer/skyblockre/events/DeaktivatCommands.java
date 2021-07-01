package de.schleimer.skyblockre.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import java.util.ArrayList;
import java.util.List;

public class DeaktivatCommands implements Listener {

    public static List<String> Accepted= new ArrayList<>();
    public void Accepted (){
        Accepted.add("island");
        Accepted.add("is");
        Accepted.add("gamemode");
        Accepted.add("gm");
        Accepted.add("stop");
        Accepted.add("ban");
        Accepted.add("banlist");
        Accepted.add("ban-ip");
        Accepted.add("island");
        Accepted.add("build");
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
        Accepted();
        if (e.getPlayer().hasPermission("skyblock.hidden")){
            return;
        }
        String s = e.getMessage().toString();
        for (String command:Accepted){
            if (s.equalsIgnoreCase("/"+command)){
                e.setCancelled(false);
                return;
            }
        }
        e.setCancelled(true);
        e.getPlayer().performCommand("fdgftdhbtrfgh");
        return;


    }

}
