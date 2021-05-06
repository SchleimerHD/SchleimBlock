package de.schleimer.skyblockre;

import de.schleimer.skyblockre.api.Generator;
import de.schleimer.skyblockre.commands.Island;
import de.schleimer.skyblockre.commands.SetSpawn;
import de.schleimer.skyblockre.commands.Spawn;
import de.schleimer.skyblockre.events.BlockBreakPlace;
import de.schleimer.skyblockre.events.JoinLeave;
import de.schleimer.skyblockre.events.MobSpawn;
import org.bukkit.Bukkit;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin {

    private static Main plugin;
    public static Main getPlugin(){
        return plugin;
    }

    public void onEnable() {
        initCommands();
        registerEvents();
        plugin = this;
        banner();
    }

    public void onDisable() {

    }

    public void initCommands() {
        getCommand("is").setExecutor(new Island());
        getCommand("spawn").setExecutor(new Spawn());
        getCommand("setspawn").setExecutor(new SetSpawn());
    }

    public void registerEvents() {
        PluginManager manager = Bukkit.getPluginManager();
        //manager.registerEvents(new Portal(),this);
        manager.registerEvents(new JoinLeave(), this);
        manager.registerEvents(new BlockBreakPlace(), this);
        manager.registerEvents(new MobSpawn(), this);
    }

    public void banner() {
        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage("░██████╗██╗░░██╗██╗░░░██╗██████╗░██╗░░░░░░█████╗░░█████╗░██╗░░██╗");
        Bukkit.getConsoleSender().sendMessage("██╔════╝██║░██╔╝╚██╗░██╔╝██╔══██╗██║░░░░░██╔══██╗██╔══██╗██║░██╔╝");
        Bukkit.getConsoleSender().sendMessage("╚█████╗░█████═╝░░╚████╔╝░██████╦╝██║░░░░░██║░░██║██║░░╚═╝█████═╝░");
        Bukkit.getConsoleSender().sendMessage("░╚═══██╗██╔═██╗░░░╚██╔╝░░██╔══██╗██║░░░░░██║░░██║██║░░██╗██╔═██╗░");
        Bukkit.getConsoleSender().sendMessage("██████╔╝██║░╚██╗░░░██║░░░██████╦╝███████╗╚█████╔╝╚█████╔╝██║░╚██╗");
        Bukkit.getConsoleSender().sendMessage("╚═════╝░╚═╝░░╚═╝░░░╚═╝░░░╚═════╝░╚══════╝░╚════╝░░╚════╝░╚═╝░░╚═╝Reloaded");
    }

    @Override
    public ChunkGenerator getDefaultWorldGenerator(String worldName, String id) {
        return new Generator();
    }
}
