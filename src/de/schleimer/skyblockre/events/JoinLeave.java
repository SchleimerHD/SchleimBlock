package de.schleimer.skyblockre.events;

import de.schleimer.skyblockre.api.SpawnAPI;
import de.schleimer.skyblockre.api.WorldAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinLeave implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if (p.hasPlayedBefore()){
            Bukkit.getServer().broadcastMessage("NotFirstJoin");
        }
        else{
            SpawnAPI.teleportToSpawn(p);
            Bukkit.getServer().broadcastMessage("FirstJoin");
        }

    }
}
