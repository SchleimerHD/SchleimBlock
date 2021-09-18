package de.schleimer.skyblockre.commands;

import de.schleimer.skyblockre.api.WarpAPI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Spawn implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player)sender;
            p.teleport(WarpAPI.getSpawn());
        } else {
            sender.sendMessage("§cDazu musst du ein Spieler sein!");
        }
        return false;
    }
}