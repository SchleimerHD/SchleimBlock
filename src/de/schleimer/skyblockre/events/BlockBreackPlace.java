package de.schleimer.skyblockre.events;

import de.schleimer.skyblockre.Main;
import de.schleimer.skyblockre.api.WorldAPI;
import org.bukkit.World;
import org.bukkit.configuration.Configuration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockBreackPlace implements Listener {
    @EventHandler
    public void onBlockBreack(BlockBreakEvent e){
        Configuration config = Main.getPlugin().getConfig();
        Player p = e.getPlayer();
        World w = p.getWorld();
        if (config.getString("Spawn.World").contains(w.getName()) ){
            e.setCancelled(true);
        }
        else if (p.getWorld().getName().contains(p.getUniqueId().toString())){
            e.setCancelled(false);
        }
        else {
            e.setCancelled(true);
        }

    }
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e){
        Configuration config = Main.getPlugin().getConfig();
        Player p = e.getPlayer();
        World w = p.getWorld();
        if (config.getString("Spawn.World").contains(w.getName()) ){
            e.setCancelled(true);
        }
        else if (p.getWorld().getName().contains(p.getUniqueId().toString())){
            e.setCancelled(false);
        }
        else {
            e.setCancelled(true);
        }
    }
}
