package de.schleimer.skyblockre;

import de.schleimer.skyblockre.api.Generator;
import de.schleimer.skyblockre.commands.Island;
import de.schleimer.skyblockre.commands.SetSpawn;
import de.schleimer.skyblockre.commands.Spawn;
import de.schleimer.skyblockre.commands.Template;
import de.schleimer.skyblockre.events.BlockBreackPlace;
import de.schleimer.skyblockre.events.JoinLeave;
import de.schleimer.skyblockre.events.MobSpawn;
import de.schleimer.skyblockre.events.portal;
import org.bukkit.Bukkit;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin {
    public static Main getPlugin() {
        return plugin;
    }

    public static void setPlugin(Main plugin) {
        Main.plugin = plugin;
    }

    private static de.schleimer.skyblockre.Main plugin;


    public void onEnable(){
        initCommands();
        registerEvents();
        plugin = this;
    }
    public  void onDisable(){

    }
    public boolean initCommands(){
        getCommand("is").setExecutor(new Island());
        getCommand("spawn").setExecutor(new Spawn());
        getCommand("setspawn").setExecutor(new SetSpawn());
        return true;
    }
    public boolean registerEvents(){
        PluginManager manager = Bukkit.getPluginManager();
        manager.registerEvents(new portal(),this);
        manager.registerEvents(new JoinLeave(),this);
        manager.registerEvents(new BlockBreackPlace(),this);
        manager.registerEvents(new MobSpawn(),this);
        return true;
    }

    @Override
    public ChunkGenerator getDefaultWorldGenerator(String worldName, String id) {
        return new Generator();
    }
}
