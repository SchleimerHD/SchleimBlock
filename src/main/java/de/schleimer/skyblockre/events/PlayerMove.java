package de.schleimer.skyblockre.events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMove implements Listener {

        @EventHandler
        public void onPlayerMove(PlayerMoveEvent e){
            Location l = e.getPlayer().getLocation();
            if (l.getY() < 50 && l.getWorld() == Bukkit.getWorld("world")){
            }
            else if (l.getY() <0){
                if (e.getPlayer().getHealth()>0){
                    e.getPlayer().setHealth(0);
                }

            }
        }
}


