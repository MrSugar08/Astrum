package org.spigotmc.commands.impl.plugin;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.spigotmc.Main;
import org.spigotmc.commands.CommandListener;
import org.spigotmc.commands.annotation.CommandInfo;
import org.spigotmc.methods.API;

@CommandInfo (
    name = "loggedinlist",
    usage = "loggedinlist",
    desc = "See who's logged in",
    blatant = false
)

public class LoggedInList extends CommandListener{

    @Override
    public void execute(Main plugin, Player p, String[] args) {
        p.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&8&m----------------------------------"));
        p.sendMessage("");
        API.getLoggedInUsers(p);
        p.sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&8&m----------------------------------"));
    }
}
