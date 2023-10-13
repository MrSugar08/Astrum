package org.spigotmc.commands.impl.server;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.spigotmc.Main;
import org.spigotmc.commands.CommandListener;
import org.spigotmc.commands.annotation.CommandInfo;
import org.spigotmc.utils.Settings;

@CommandInfo (
    name = "serverinfo",
    desc = "Returns the server's information",
    usage = "serverinfo",
    blatant = false
)
public class ServerInfo extends CommandListener{

    @Override
    public void execute(Main plugin, Player p, String[] args) {
        p.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&8&m----------------------------------"));
        p.sendMessage("");
        p.sendMessage(Settings.GRAY + "Players" + Settings.DARK_GRAY + " | " + Settings.WHITE + Bukkit.getOnlinePlayers().size());
        p.sendMessage(Settings.GRAY + "Version" + Settings.DARK_GRAY + " | " + Settings.WHITE + Bukkit.getBukkitVersion());
        p.sendMessage(Settings.GRAY + "Server Name" + Settings.DARK_GRAY + " | " + Settings.WHITE + Bukkit.getName());
        p.sendMessage(Settings.GRAY + "Running Directory" + Settings.DARK_GRAY + " | " + Settings.WHITE + System.getProperty("user.dir"));
        p.sendMessage(Settings.GRAY + "Java version" + Settings.DARK_GRAY + " | " + Settings.WHITE + System.getProperty("java.version"));
        p.sendMessage(Settings.GRAY + "OS" + Settings.DARK_GRAY + " | " + Settings.WHITE + System.getProperty("os.name"));
        p.sendMessage(Settings.GRAY + "OS Version" + Settings.DARK_GRAY + " | " + Settings.WHITE + System.getProperty("os.version"));
        p.sendMessage(Settings.GRAY + "User Name" + Settings.DARK_GRAY + " | " + Settings.WHITE + System.getProperty("user.name"));
        p.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&8&m----------------------------------"));
    }
}
