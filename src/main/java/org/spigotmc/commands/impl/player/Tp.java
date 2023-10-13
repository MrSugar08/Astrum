package org.spigotmc.commands.impl.player;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.spigotmc.Main;
import org.spigotmc.commands.CommandListener;
import org.spigotmc.commands.annotation.CommandInfo;
import org.spigotmc.utils.Settings;

@CommandInfo(
    name = "teleport",
    usage = "teleport <player> (player) | teleport * (player)",
    desc = "Teleport someone to someone",
    aliases = "tp",
    blatant = true
)
public class Tp extends CommandListener {

    @Override
    public void execute(Main plugin, Player p, String[] args) {
        if (args.length <= 1) {
            p.sendMessage(Settings.USAGE(Tp.class.getAnnotation(CommandInfo.class).usage()));
        } else {
            if (args[1].equalsIgnoreCase("*")) {
                if (args.length < 3) {
                    p.sendMessage(Settings.USAGE(Tp.class.getAnnotation(CommandInfo.class).usage()));
                    return;
                }
                @SuppressWarnings("deprecation")
                Player target2 = Bukkit.getPlayer(args[2]);
                if (target2 == null) {
                    p.sendMessage(Settings.PREFIX(Settings.PURPLE + args[2] + Settings.WHITE + " is not online"));
                    return;
                }

                for (Player onPlayer : Bukkit.getOnlinePlayers()) {
                    Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), () -> {
                        onPlayer.teleport(target2);
                    });
                }
                p.sendMessage(Settings.PREFIX("Successfully teleported everyone to " + Settings.PURPLE + target2.getName()));
            } else {
                if (args.length < 2) {
                    p.sendMessage(Settings.USAGE(Tp.class.getAnnotation(CommandInfo.class).usage()));
                    return;
                }
                @SuppressWarnings("deprecation")
                Player target1 = Bukkit.getPlayer(args[1]);
                if (target1 == null) {
                    p.sendMessage(Settings.PREFIX(Settings.PURPLE + args[1] + Settings.WHITE + " is not online"));
                    return;
                }

                if (args.length < 3) {
                    Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), () -> {
                        p.teleport(target1);
                    });
                    p.sendMessage(Settings.PREFIX("Successfully teleported to " + Settings.PURPLE + target1.getName()));
                } else {
                    @SuppressWarnings("deprecation")
                    Player target2 = Bukkit.getPlayer(args[2]);
                    if (target2 == null) {
                        p.sendMessage(Settings.PREFIX(Settings.PURPLE + args[2] + Settings.WHITE + " is not online"));
                        return;
                    }
                    Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), () -> {
                        target1.teleport(target2);
                    });         
                    p.sendMessage(Settings.PREFIX("Successfully teleported " + Settings.PURPLE + target1.getName() + Settings.WHITE + " to " + Settings.PURPLE + target2.getName()));
                }
            }
        }
    }
}
