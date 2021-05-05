package de.schleimer.skyblockre.events;

import de.schleimer.skyblockre.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

public class MobSpawn implements Listener {
    @EventHandler
    public void onMobSpawn(EntitySpawnEvent e){
        FileConfiguration config = Main.getPlugin().getConfig();
        if (e.getLocation().getWorld().getName() == config.getString("Spawn.World") ){
            e.setCancelled(true);
        }
    }
}
