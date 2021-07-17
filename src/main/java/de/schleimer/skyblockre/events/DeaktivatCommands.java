package de.schleimer.skyblockre.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import java.util.ArrayList;
import java.util.List;

public class DeaktivatCommands implements Listener {

    public static List<String> playercommands= new ArrayList<>();
    public void Accepted (){
        playercommands.add("island");
        playercommands.add("is");
        playercommands.add("shop");
        playercommands.add("build");
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
        String raw = e.getMessage();
        String[] s = raw.toLowerCase().split(" ");
        for (String command:playercommands){
            if (s[0].equalsIgnoreCase("/"+command)){
                e.setCancelled(false);
                return;
            }
        }
        e.setCancelled(true);
        //Performing a Dummy Command to get a real "Unkown Command Message" so any
        e.getPlayer().performCommand("fdgftdhbtrfgh");
    }

}
