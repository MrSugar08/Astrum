package org.spigotmc.commands.impl.plugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.spigotmc.Main;
import org.spigotmc.commands.CommandListener;
import org.spigotmc.commands.annotation.CommandInfo;
import org.spigotmc.utils.Settings;

@CommandInfo (
    name = "plugins",
    usage = "plugins",
    desc = "Lists the server plugins",
    aliases = "pl",
    blatant = false
)
public class Plugins extends CommandListener{

    @Override
    public void execute(Main plugin, Player p, String[] args) {
        StringBuilder plugins = new StringBuilder();
        int i = 0;
        while (i < Bukkit.getPluginManager().getPlugins().length) {
            if (Bukkit.getPluginManager().getPlugins()[i].isEnabled()) {
                plugins.append(Settings.WHITE).append(Bukkit.getPluginManager().getPlugins()[i].getName()).append(", ");
            } else {
				plugins.append(Settings.WHITE).append(Bukkit.getPluginManager().getPlugins()[i].getName()).append(Settings.WHITE + ", ");
			}
            ++i;
        }
        p.sendMessage(Settings.PREFIX(ChatColor.translateAlternateColorCodes('&', "&8(" +Settings.DARK_PURPLE + Bukkit.getPluginManager().getPlugins().length + "&8) " + Settings.WHITE + plugins.substring(2, plugins.length()))));
    } 
}
