package org.spigotmc.commands.impl.plugin;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.spigotmc.Main;
import org.spigotmc.commands.CommandListener;
import org.spigotmc.commands.annotation.CommandInfo;
import org.spigotmc.utils.Settings;

@CommandInfo (
    name = "version",
    usage = "version",
    desc = "version",
    aliases = "ver",
    blatant = false
)
public class Version extends CommandListener{

    @Override
    public void execute(Main plugin, Player p, String[] args) {
        p.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&8&m----------------------------------"));
        p.sendMessage("");
        p.sendMessage(Settings.GRAY + "Author" + Settings.DARK_GRAY + " | " + Settings.WHITE + Settings.AUTHOR);
        p.sendMessage(Settings.GRAY + "Version" + Settings.DARK_GRAY + " | " + Settings.WHITE + Settings.VERSION);
        p.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&8&m----------------------------------"));
    } 
}
