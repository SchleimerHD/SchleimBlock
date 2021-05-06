package de.schleimer.skyblockre.events;

import de.schleimer.skyblockre.api.SpawnAPI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinLeave implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        e.setJoinMessage("§2§l+ " + p.getName());
        if (!p.hasPlayedBefore()){
            SpawnAPI.teleportToSpawn(p);
        }

    }
    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        e.setQuitMessage("- " + p.getName());
        if (!p.hasPlayedBefore()){
            SpawnAPI.teleportToSpawn(p);

        }

    }
}
