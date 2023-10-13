package org.spigotmc.commands.impl.server;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.spigotmc.Main;
import org.spigotmc.commands.CommandListener;
import org.spigotmc.commands.annotation.CommandInfo;
import org.spigotmc.utils.Settings;

@CommandInfo (
    name = "clearchat",
    usage = "clearchat",
    desc = "Clear chat",
    blatant = true
)

public class ClearChat extends CommandListener{

    @Override
    public void execute(Main plugin, Player p, String[] args) {
        for (int i=0;i<1000;i++) {
            Bukkit.broadcastMessage("");
        }
        p.sendMessage(Settings.PREFIX("Successfully cleared chat"));
    }
}
