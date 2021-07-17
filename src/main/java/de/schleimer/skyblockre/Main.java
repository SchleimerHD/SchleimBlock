package de.schleimer.skyblockre;

import de.schleimer.skyblockre.commands.Build;
import de.schleimer.skyblockre.commands.Island;
import de.schleimer.skyblockre.events.*;
import de.schleimer.skyblockre.tabcomplete.IslandTab;
import org.bukkit.Bukkit;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin {
    public static Main getPlugin() {
        return plugin;
    }

    private static de.schleimer.skyblockre.Main plugin;


    public void onEnable(){
        initCommands();
        initautocompletion();
        registerEvents();
        plugin = this;
        banner();
        Bukkit.setSpawnRadius(0);
    }
    public  void onDisable(){

    }
    public void initCommands(){
        getCommand("is").setExecutor(new Island());
        //getCommand("spawn").setExecutor(new Spawn());
        getCommand("build").setExecutor(new Build());
    }
    public void registerEvents(){
        PluginManager manager = Bukkit.getPluginManager();
        manager.registerEvents(new JoinLeave(),this);
        manager.registerEvents(new BlockBreakPlace(),this);
        manager.registerEvents(new MobSpawn(),this);
        manager.registerEvents(new PlayerMove(),this);
        manager.registerEvents(new DeaktivatCommands(),this);

    }
    public void initautocompletion(){
        getCommand("island").setTabCompleter(new IslandTab());
    }
    public void banner() {
        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage("░██████╗██╗░░██╗██╗░░░██╗██████╗░██╗░░░░░░█████╗░░█████╗░██╗░░██╗");
        Bukkit.getConsoleSender().sendMessage("██╔════╝██║░██╔╝╚██╗░██╔╝██╔══██╗██║░░░░░██╔══██╗██╔══██╗██║░██╔╝");
        Bukkit.getConsoleSender().sendMessage("╚█████╗░█████═╝░░╚████╔╝░██████╦╝██║░░░░░██║░░██║██║░░╚═╝█████═╝░");
        Bukkit.getConsoleSender().sendMessage("░╚═══██╗██╔═██╗░░░╚██╔╝░░██╔══██╗██║░░░░░██║░░██║██║░░██╗██╔═██╗░");
        Bukkit.getConsoleSender().sendMessage("██████╔╝██║░╚██╗░░░██║░░░██████╦╝███████╗╚█████╔╝╚█████╔╝██║░╚██╗");
        Bukkit.getConsoleSender().sendMessage("╚═════╝░╚═╝░░╚═╝░░░╚═╝░░░╚═════╝░╚══════╝░╚════╝░░╚════╝░╚═╝░░╚═╝Reloaded");
        Bukkit.getConsoleSender().sendMessage("v"+this.getDescription().getVersion()  +" by "+ this.getDescription().getAuthors()+" has been enabled");
    }

    @Override
    public ChunkGenerator getDefaultWorldGenerator(String worldName, String id) {
        return new Generator();
    }
}
