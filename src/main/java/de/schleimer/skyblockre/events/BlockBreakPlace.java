
package de.schleimer.skyblockre.events;

import de.schleimer.skyblockre.commands.Build;
import de.schleimer.skyblockre.objects.Islands;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class BlockBreakPlace implements Listener {
    @EventHandler
    public void onBlockBreak(PlayerInteractEvent e){
        Player player = e.getPlayer();
        if (Build.builder.get(player) != null){
            //Bukkit.getConsoleSender().sendMessage("Is in Builder list");
            if (Build.builder.get(player) == true){
                //Bukkit.getConsoleSender().sendMessage("Player is in Builder Mode");
                e.setCancelled(false);
                return;
            }

        }
        Islands is = Islands.getIslandsbyWorld(player.getWorld());
        if (is != null){
            e.setCancelled(!is.ismember(player));
        }
        else {
            e.setCancelled(true);
        }

    }

}