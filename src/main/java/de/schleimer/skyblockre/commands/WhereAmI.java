package de.schleimer.skyblockre.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WhereAmI implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player)sender;
            player.sendMessage("Du bist in der Welt: " + player.getWorld());
        }
        else {
            sender.sendMessage("Nur ein Spieler kann den whereami befehl nutzen");
        }
        return true;
    }
}