
package de.schleimer.skyblockre.events;

import de.schleimer.skyblockre.Main;
import de.schleimer.skyblockre.commands.Build;
import de.schleimer.skyblockre.objekts.Islands;
import org.bukkit.World;
import org.bukkit.configuration.Configuration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.hamcrest.core.Is;

public class BlockBreakPlace implements Listener {
    @EventHandler
    public void onBlockBreak(PlayerInteractEvent e){
        Player player = e.getPlayer();
        if (Build.builder.get(player) != null){
            if (Build.builder.get(player) == true){
                e.setCancelled(false);
                return;
            }
        }
        Islands is = Islands.getIslandsbyWorld(player.getWorld());
        if (is != null){
            if(is.ismember(player)){
                e.setCancelled(false);
            }
            else {
                e.setCancelled(true);
            }
        }
        else {
            e.setCancelled(true);
        }

    }

}