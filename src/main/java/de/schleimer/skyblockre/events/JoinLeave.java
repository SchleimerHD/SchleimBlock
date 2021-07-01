package de.schleimer.skyblockre.events;

import de.schleimer.skyblockre.commands.Build;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinLeave implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        e.setJoinMessage("§7+§a " +p.getName());
        if (!p.hasPlayedBefore()){
        }
        p.sendMessage("" +
                "§aNote: This is a §4§lin Dev§a Version of §bSky§fBlock " +
                "\n§aThere will be many §4§lBugs §a and your progress can be gone any day" +
                "\nWith the Full release the Progress will be permanently");

    }
    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        e.setQuitMessage("§7-§c " + p.getName());
        World w = p.getWorld();
        System.out.println(w.getName());
        Build.builder.remove(p);
    }
}
