package org.spigotmc.commands.impl.griefing;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.spigotmc.Main;
import org.spigotmc.commands.CommandListener;
import org.spigotmc.commands.annotation.CommandInfo;
import org.spigotmc.manager.PlayerManager;
import org.spigotmc.methods.API;
import org.spigotmc.enums.PlayerType;
import org.spigotmc.utils.Settings;

@CommandInfo (
    name = "kick",
    usage = "kick <player>",
    desc = "Kick a player",
    blatant = false
)
public class Kick extends CommandListener{

    @Override
    public void execute(Main plugin, Player p, String[] args) {
		if (args.length <= 1) {
			p.sendMessage(Settings.USAGE(Kick.class.getAnnotation(CommandInfo.class).usage()));
		} else {
			if (args[1].equals("*")) {
				for (Player a : Bukkit.getOnlinePlayers()) {
					if (!PlayerManager.isPlayerInType(PlayerType.FREE, a.getName())) {
						API.kickPlayer(a);
					}
				}
				p.sendMessage(Settings.PREFIX("Everyone not logged in was kicked!"));
			} else {
				@SuppressWarnings("deprecation")
				Player target = Bukkit.getServer().getPlayer(args[1]);
				if (target == null) {
					p.sendMessage(Settings.PREFIX("The player " + Settings.PURPLE + args[1] + Settings.WHITE + " is not online."));
				} else {
					API.kickPlayer(target);
					p.sendMessage(Settings.PREFIX(target.getName() + " was kicked!"));
				}
			}
		}
	}
}