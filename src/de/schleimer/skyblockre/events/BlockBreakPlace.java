package de.schleimer.skyblockre.events;

import de.schleimer.skyblockre.Main;
import org.bukkit.World;
import org.bukkit.configuration.Configuration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockBreakPlace implements Listener {
    @EventHandler
    public void onBlockBreak(BlockBreakEvent e){
        Configuration config = Main.getPlugin().getConfig();
        Player p = e.getPlayer();
        World w = p.getWorld();
        if (config.getString("Spawn.World").contains(w.getName()) ){
            e.setCancelled(true);
        }
        else e.setCancelled(!p.getWorld().getName().contains(p.getUniqueId().toString()));

    }
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e){
        Configuration config = Main.getPlugin().getConfig();
        Player p = e.getPlayer();
        World w = p.getWorld();
        if (config.getString("Spawn.World").contains(w.getName()) ){
            e.setCancelled(true);
        }
        else e.setCancelled(!p.getWorld().getName().contains(p.getUniqueId().toString()));
    }
}
