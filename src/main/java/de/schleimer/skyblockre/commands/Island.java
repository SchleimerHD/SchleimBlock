package de.schleimer.skyblockre.commands;

import de.schleimer.skyblockre.objects.Islands;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Island implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player)sender;
            Islands is = Islands.getIslandsbyPlayer(player);
            if (is == null){
                is = new Islands(player);
            }
            if(args.length == 1){
                if (args[0].equalsIgnoreCase("tp")){
                    is.teleportto(player);
                }
            }

        }
        else {
            sender.sendMessage("Only a player can use this command");
        }
        return true;
    }
}
