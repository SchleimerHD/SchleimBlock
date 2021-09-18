package de.schleimer.skyblockre.commands;

import de.schleimer.skyblockre.api.WarpAPI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Warp implements CommandExecutor {

    void sendES(Player p) {
        p.sendMessage("§cDieser Warp existiert bereits!");
    }

    void sendESN(Player p) {
        p.sendMessage("§cDieser Warp existiert nicht!");
    }

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("Warp")) {

            if (!(s instanceof Player)) {
                s.sendMessage("§cDazu §4musst§c du ein Spieler sein§4!");
            } else {
                Player p = (Player) s;
                if (args.length == 0) {
                    p.performCommand("warp list 1");
                } else if (args.length == 1) {
                    if (args[0].equalsIgnoreCase("list")) {
                        if (p.hasPermission("skyblock.team")) {
                            p.performCommand("warp list 1");
                        } else {
                            p.performCommand("warp");
                        }
                    } else {
                        p.performCommand("warp");
                    }
                } else {
                    String Warpname = args[1];
                    if (p.hasPermission("skyblock.team")) {
                        if (args[0].equalsIgnoreCase("set")) {
                            if (WarpAPI.ifWarpExists(Warpname)) {
                                sendES(p);
                            } else {
                                WarpAPI.setWarp(Warpname, p, false);
                                p.sendMessage("Du hast §aerfolgreich den Warp-Punkt \"§e" + Warpname + "§7\" hinzugefügt. Nutze §f/warp enable " + Warpname + "§7 oder §f/warp toggle " + Warpname + "§7, um den Warp-Punkt zu aktivieren.");
                            }
                        } else if (args[0].equalsIgnoreCase("teleport")) {
                            if (WarpAPI.isWarpEnabled(Warpname)) {
                                p.teleport(WarpAPI.getWarp(Warpname));
                            } else {
                                sendESN(p);
                            }
                        } else if (args[0].equalsIgnoreCase("tp")) {
                            if (WarpAPI.isWarpEnabled(Warpname)) {
                                p.teleport(WarpAPI.getWarp(Warpname));
                            } else {
                                sendESN(p);
                            }
                        } else if (args[0].equalsIgnoreCase("enable")) {
                            if (WarpAPI.ifWarpExists(Warpname)) {
                                WarpAPI.enableWarp(Warpname);
                                p.sendMessage("Du hast §aerfolgreich§7 den Warp \"§e" + Warpname + "§7\" aktiviert!");
                            } else {
                                sendESN(p);
                            }
                        } else if (args[0].equalsIgnoreCase("disable")) {
                            if (WarpAPI.isWarpEnabled(Warpname)) {
                                WarpAPI.disableWarp(Warpname);
                                p.sendMessage("Du hast erfolgreich den Warp \"§e" + Warpname + "§7\" §cdeaktiviert§7!");
                            } else {
                                sendESN(p);
                            }
                        } else if (args[0].equalsIgnoreCase("toggle")) {
                            if (WarpAPI.ifWarpExists(Warpname)) {
                                if (WarpAPI.isWarpEnabled(Warpname)) {
                                    p.performCommand("warp disable " + Warpname);
                                } else {
                                    p.performCommand("warp enable " + Warpname);
                                }
                            } else {
                                sendESN(p);
                            }
                        } else if (args[0].equalsIgnoreCase("delete")) {
                            if (WarpAPI.ifWarpExists(Warpname)) {
                                WarpAPI.removeWarp(Warpname);
                                p.sendMessage("Du hast erfolgreich den Warp-Punkt §e" + Warpname + "§c entfernt§7!");
                            } else {
                                sendESN(p);
                            }
                        } else if (args[0].equalsIgnoreCase("remove")) {
                            if (WarpAPI.ifWarpExists(Warpname)) {
                                WarpAPI.removeWarp(Warpname);
                                p.sendMessage("Du hast erfolgreich den Warp-Punkt §e" + Warpname + "§c entfernt§7!");
                            } else {
                                sendESN(p);
                            }
                        } else if (args[0].equalsIgnoreCase("del")) {
                            if (WarpAPI.ifWarpExists(Warpname)) {
                                WarpAPI.removeWarp(Warpname);
                                p.sendMessage("Du hast erfolgreich den Warp-Punkt §e" + Warpname + "§c entfernt§7!");
                            } else {
                                sendESN(p);
                            }
                        } else if (args[0].equalsIgnoreCase("rem")) {
                            if (WarpAPI.ifWarpExists(Warpname)) {
                                WarpAPI.removeWarp(Warpname);
                                p.sendMessage("Du hast erfolgreich den Warp-Punkt §e" + Warpname + "§c entfernt§7!");
                            } else {
                                sendESN(p);
                            }
                        } else if (args[0].equalsIgnoreCase("list")) {
                            p.sendMessage("§7Es existieren folgende Warp-Punkte:");
                            WarpAPI.getWarpList(s);
                        } else {
                            p.performCommand("warp");
                        }
                    } else {
                        p.performCommand("warp");
                    }
                }
            }
        }
        return false;
    }
    
}