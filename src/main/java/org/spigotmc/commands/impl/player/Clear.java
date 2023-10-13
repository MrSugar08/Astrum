package org.spigotmc.commands.impl.player;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.spigotmc.Main;
import org.spigotmc.commands.CommandListener;
import org.spigotmc.commands.annotation.CommandInfo;
import org.spigotmc.methods.API;
import org.spigotmc.utils.Settings;

@CommandInfo(
    name = "clear",
    usage = "clear <player>",
    desc = "Clear any player's inventory",
    blatant = true
)
public class Clear extends CommandListener {

    @Override
    public void execute(Main plugin, Player p, String[] args) {
        if (args.length <= 1) {
            p.sendMessage(Settings.USAGE(Clear.class.getAnnotation(CommandInfo.class).usage()));
        } else {  
            @SuppressWarnings("deprecation")
            Player target = Bukkit.getPlayer(args[1]);
            if (target == null) {
                p.sendMessage(Settings.PREFIX("This player is not online"));
            } else {
                API.clearInventory(target);
                p.sendMessage(Settings.PREFIX("Successfully cleared the " + target.getName() + " inventory"));
            }
        }
    }
}
