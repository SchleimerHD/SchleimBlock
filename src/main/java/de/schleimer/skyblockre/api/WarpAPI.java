package de.schleimer.skyblockre.api;

import de.schleimer.skyblockre.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class WarpAPI {

    public static Location getSpawn() {
        if(isWarpEnabled("spawn")) {
            return getWarp("spawn");
        } else {
            return Bukkit.getWorlds().get(0).getSpawnLocation();
        }
    }

    public static boolean ifWarpExists(String Warpname) {
        Warpname = Warpname.toLowerCase();
        File WarpFile = new File("plugins/"+ Main.getPlugin().getDescription().getName()+"/Warps/"+Warpname+".yml");
        if(WarpFile.exists()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isWarpEnabled(String Warpname) {
        Warpname = Warpname.toLowerCase();
        if(ifWarpExists(Warpname)) {
            File WarpFile = new File("plugins/"+ Main.getPlugin().getDescription().getName()+"/Warps/"+Warpname+".yml");
            YamlConfiguration WF = YamlConfiguration.loadConfiguration(WarpFile);
            if(WF.getBoolean("Warp.isEnabled")) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static void setWarp(String Warpname, World w, double x, double y, double z, float yaw, float pitch, boolean enable) {
        Warpname = Warpname.toLowerCase();
        File WarpFile = new File("plugins/"+ Main.getPlugin().getDescription().getName()+"/Warps/"+Warpname+".yml");
        YamlConfiguration WF = YamlConfiguration.loadConfiguration(WarpFile);
        WF.set("Warp.World",w.getName());
        WF.set("Warp.X",x);
        WF.set("Warp.Y",y);
        WF.set("Warp.Z",z);
        WF.set("Warp.Yaw",yaw);
        WF.set("Warp.Pitch",pitch);
        if(enable) {
            WF.set("Warp.isEnabled",true);
        } else {
            WF.set("Warp.isEnabled",false);
        }
        ConfigAPI.saveConfig(WarpFile,WF);
    }

    public static void setWarp(String Warpname, Player p, boolean enable) {
        Warpname = Warpname.toLowerCase();
        setWarp(Warpname,p.getWorld(),p.getLocation().getX(),p.getLocation().getY(),p.getLocation().getZ(),p.getLocation().getYaw(),p.getLocation().getPitch(),enable);
    }

    public static Location getWarp(String Warpname) {
        Warpname = Warpname.toLowerCase();
        File WarpFile = new File("plugins/"+ Main.getPlugin().getDescription().getName()+"/Warps/"+Warpname+".yml");
        YamlConfiguration WF = YamlConfiguration.loadConfiguration(WarpFile);
        return new Location(Bukkit.getWorld(WF.getString("Warp.World")),WF.getDouble("Warp.X"),WF.getDouble("Warp.Y"),WF.getDouble("Warp.Z"),(float)WF.getDouble("Warp.Yaw"),(float)WF.getDouble("Warp.Pitch"));
    }

    public static void removeWarp(String Warpname) {
        Warpname = Warpname.toLowerCase();
        if(ifWarpExists(Warpname)) {
            File WarpFile = new File("plugins/"+ Main.getPlugin().getDescription().getName()+"/Warps/"+Warpname+".yml");
            WarpFile.delete();
        }
    }

    public static void enableWarp(String Warpname) {
        Warpname = Warpname.toLowerCase();
        if(ifWarpExists(Warpname)) {
            File WarpFile = new File("plugins/"+ Main.getPlugin().getDescription().getName()+"/Warps/"+Warpname+".yml");
            YamlConfiguration WF = YamlConfiguration.loadConfiguration(WarpFile);
            WF.set("Warp.isEnabled",true);
            ConfigAPI.saveConfig(WarpFile,WF);
        }
    }

    public static void disableWarp(String Warpname) {
        Warpname = Warpname.toLowerCase();
        if(ifWarpExists(Warpname)) {
            File WarpFile = new File("plugins/"+ Main.getPlugin().getDescription().getName()+"/Warps/"+Warpname+".yml");
            YamlConfiguration WF = YamlConfiguration.loadConfiguration(WarpFile);
            WF.set("Warp.isEnabled",false);
            ConfigAPI.saveConfig(WarpFile,WF);
        }
    }

    public static void toggleWarp(String Warpname) {
        Warpname = Warpname.toLowerCase();
        if(isWarpEnabled(Warpname)) {
            disableWarp(Warpname);
        } else {
            enableWarp(Warpname);
        }
    }

    public static void getWarpList(CommandSender s) {
        File folder = new File("plugins/"+ Main.getPlugin().getDescription().getName()+"/Warps/");
        File[] listOfFiles = folder.listFiles();
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                s.sendMessage("§a"+listOfFiles[i].getName().replace(".yml",","));
            } else if (listOfFiles[i].isDirectory()) {
                s.sendMessage("§2"+listOfFiles[i].getName().replace(".yml",","));
            }
        }
    }
}