package de.schleimer.skyblockre.objects;

import de.schleimer.skyblockre.Main;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import javax.xml.stream.Location;
import java.io.File;
import java.util.HashMap;

public class Warps {
    private static HashMap <String, Warps> warps;
    private String name;
    private Location location;
    private boolean isEnabled;
    private File WarpFile;
    private YamlConfiguration Warps = YamlConfiguration.loadConfiguration(WarpFile);

    public Warps(Player p , String name){
        warps.put(name,this);
    }
    private Warps(){
        return;
    }
    public static Warps getWarp(String s){
        s =s.toLowerCase();
        Warps w = warps.get(s);
        return w;
    }
    public boolean  teleportTo(Player p){
        if (isEnabled){
            p.teleport((org.bukkit.Location) location);
            return true;
        }
        return false;

    }
    private boolean isEnabled() {
        return isEnabled;
    }
    public boolean toggle(){
        if (isEnabled){
            isEnabled = false;
            return isEnabled;
        }
        else {
            isEnabled = true;
            return isEnabled;
        }

    }
    public Warps(File file){
        this.WarpFile = file;
        this.Warps = YamlConfiguration.loadConfiguration(WarpFile);
        isEnabled = Warps.getBoolean("Warp.isEnabled");
        location = new Location(
                Bukkit.getWorld(Warps.getString("Warp.World"))
                ,Warps.getDouble("Warp.X")
                ,Warps.getDouble("Warp.Y")
                , Warps.getDouble("Warp.Z")
                ,(float)Warps.getDouble("Warp.Yaw")
                ,(float)Warps.getDouble("Warps.Pitch"));
    }
    public static boolean loadAllWarps(){
        File folder = new File("plugins/"+ Main.getPlugin().getDescription().getName()+"/Warps/");
        File[] listOfFiles = folder.listFiles();
        for (int i = 0; i < listOfFiles.length; i++)
            new Warps(listOfFiles[i]);
        return true;
    }


}
