package de.schleimer.skyblockre.api;

import de.schleimer.skyblockre.Main;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ConfigAPI {

    public static File config = new File("plugins/"+Main.getPlugin().getDescription().getName()+"/config.yml");
    public static YamlConfiguration cfg = YamlConfiguration.loadConfiguration(config);

    public static void checkEntry(String path, Object content, File file, YamlConfiguration cfg) {
        reloadConfig(file,cfg);
        if(!(file.exists())) {
            cfg.set(path, content);
        } else {
            if(!(cfg.contains(path))) {
                cfg.set(path, content);
            }
        }
        saveConfig(file,cfg);
    }

    public static void saveConfig(File file, YamlConfiguration cfg) {
        try {
            cfg.save(file);
        }
        catch (IOException ef) {
            ef.printStackTrace();
        }
        reloadConfig(file, cfg);
    }

    public static void reloadConfig(File file, YamlConfiguration cfg) {
        cfg = YamlConfiguration.loadConfiguration(file);
    }

    public static void checkEntry(String path, Object content) {
        File file = config;
        reloadConfig(file,cfg);
        if(!(file.exists())) {
            cfg.set(path, content);
        } else {
            if(!(cfg.contains(path))) {
                cfg.set(path, content);
            }
        }
        saveConfig(file,cfg);
    }

    public static void saveConfig() {
        File file = config;
        try {
            cfg.save(file);
        }
        catch (IOException ef) {
            ef.printStackTrace();
        }
        reloadConfig(file, cfg);
    }

    public static void reloadConfig() {
        File file = config;
        cfg = YamlConfiguration.loadConfiguration(file);
    }
}