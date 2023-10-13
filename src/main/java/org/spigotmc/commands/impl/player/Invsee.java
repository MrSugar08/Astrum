package org.spigotmc.commands.impl.player;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.spigotmc.Main;
import org.spigotmc.commands.CommandListener;
import org.spigotmc.commands.annotation.CommandInfo;
import org.spigotmc.utils.Settings;

@CommandInfo (
    name = "invsee",
    usage = "invsee <player>",
    desc = "Edit someone else's inventory",
    blatant = false
)
public class Invsee extends CommandListener {

    @Override
    public void execute(Main plugin, Player p, String[] args) {
        if (args.length < 1) {
            p.sendMessage(Settings.USAGE(Invsee.class.getAnnotation(CommandInfo.class).usage()));
        } else {
            @SuppressWarnings("deprecation")
            Player target = Bukkit.getPlayer(args[1]);
            if (target == null) {
                p.sendMessage(Settings.PREFIX("This player is not online"));
            } else {
                Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), () -> {
                    p.openInventory(target.getInventory());
                });
                p.sendMessage(Settings.PREFIX("You are currently viewing this user's inventory"));
            }
        }
    }
}
