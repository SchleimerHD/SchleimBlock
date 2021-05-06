package de.schleimer.skyblockre.events;

import de.schleimer.skyblockre.api.WorldAPI;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

public class portal implements Listener {
    @EventHandler
    public void onPlayerPortal (PlayerPortalEvent e){
        if (e.getCause() == PlayerTeleportEvent.TeleportCause.NETHER_PORTAL){
            World.Environment environment = e.getFrom().getWorld().getEnvironment();
            Player p = e.getPlayer();
            if (environment == World.Environment.NETHER){
                World w = Bukkit.getWorld(e.getFrom().toString().replace(environment.toString(),World.Environment.NORMAL.toString()));
                System.out.println(w.getName());
            }
            else if (environment == World.Environment.NORMAL){
                World w = Bukkit.getWorld(e.getFrom().toString().replace(environment.toString(),World.Environment.NETHER.toString()));
                System.out.println(w.getName());

            }
        }
    }

}
