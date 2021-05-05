package de.schleimer.skyblockre.commands;

import de.schleimer.skyblockre.api.SpawnAPI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Spawn implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            SpawnAPI.teleportToSpawn(p);
        }
        return false;
    }
}