package de.schleimer.skyblockre.events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMove implements Listener {

        @EventHandler
        public void onPlayerMove(PlayerMoveEvent e){
            Location l = e.getPlayer().getLocation();
            Player player = e.getPlayer();
            /*if (l.getY() < 50 && l.getWorld() == Bukkit.getWorld("world")){
            }
            else if (l.getY() <0){
                if (player.getHealth()>0){
                    player.setHealth(0);
                }

            }*/
        }
}


