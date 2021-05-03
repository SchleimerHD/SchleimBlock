package de.schleimer.skyblockre;

import de.schleimer.skyblockre.api.Generator;
import de.schleimer.skyblockre.commands.Island;
import de.schleimer.skyblockre.events.portal;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    public void onEnable(){
        initCommands();
        registerEvents();
    }
    public  void onDisable(){

    }
    public boolean initCommands(){
        getCommand("is").setExecutor(new Island());
        return true;
    }
    public boolean registerEvents(){
        PluginManager manager = Bukkit.getPluginManager();
        manager.registerEvents(new portal(),this);
        return true;
    }

    @Override
    public ChunkGenerator getDefaultWorldGenerator(String worldName, String id) {
        return new Generator();
    }
}
