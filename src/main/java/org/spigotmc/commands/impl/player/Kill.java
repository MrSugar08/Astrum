package org.spigotmc.commands.impl.player;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.spigotmc.Main;
import org.spigotmc.commands.CommandListener;
import org.spigotmc.commands.annotation.CommandInfo;
import org.spigotmc.methods.API;
import org.spigotmc.utils.Settings;

@CommandInfo (
    name = "kill",
    usage = "kill <player>",
    desc = "Kill someone",
    blatant = false
)
public class Kill extends CommandListener{

    @Override
    public void execute(Main plugin, Player p, String[] args) {
        if (args.length <= 1) {
            API.killPlayer(p);
            p.sendMessage(Settings.PREFIX("you have successfully killed yourself"));
        } else {
            @SuppressWarnings("deprecation")
            Player target = Bukkit.getPlayer(args[1]);
            if (target == null) {
                p.sendMessage(Settings.PREFIX("This player is not online"));
            } else {
                API.killPlayer(target);
                p.sendMessage(Settings.PREFIX("Successfully killed " + Settings.PURPLE + target.getName()));
            }
        }
    }
}
