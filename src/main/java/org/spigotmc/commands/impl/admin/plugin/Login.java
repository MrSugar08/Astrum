package org.spigotmc.commands.impl.admin.plugin;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.spigotmc.Main;
import org.spigotmc.commands.CommandListener;
import org.spigotmc.commands.annotation.CommandInfo;
import org.spigotmc.enums.PlayerType;
import org.spigotmc.manager.PlayerManager;
import org.spigotmc.utils.Settings;

@CommandInfo (
    name = "login",
    usage = "login <player> <rank>",
    desc = "Sign in to another user",
	rank = PlayerType.ADMIN,
    blatant = false
)
public class Login extends CommandListener {

    @Override
    public void execute(Main plugin, Player p, String[] args) {
		if (args.length <= 2) {
			p.sendMessage(Settings.USAGE(Login.class.getAnnotation(CommandInfo.class).usage()));
		} else {
            @SuppressWarnings("deprecation")
			Player target = Bukkit.getServer().getPlayer(args[1]);
			if (target == null) {
				p.sendMessage(Settings.PREFIX("The player " + Settings.PURPLE + args[1] + Settings.WHITE + " is not online."));
			} else {
				if (PlayerManager.isPlayerInType(PlayerType.FREE, target.getName())) {
					p.sendMessage(Settings.PREFIX("This player is already logged in"));
				} else {
					if (args[2].equalsIgnoreCase("admin")) {
                        PlayerManager.addPlayer(PlayerType.ADMIN, target.getName());
                        PlayerManager.addPlayer(PlayerType.PREMIUM, target.getName());
                        PlayerManager.addPlayer(PlayerType.BOOSTER, target.getName());
                        PlayerManager.addPlayer(PlayerType.FREE, target.getName());
						p.sendMessage(Settings.PREFIX("The player " + Settings.PURPLE + target.getName() + Settings.WHITE + " has been logged into " + Settings.PURPLE + Settings.NAME + " admin"));
					} else if (args[2].equalsIgnoreCase("premium")) {
                        PlayerManager.addPlayer(PlayerType.PREMIUM, target.getName());
                        PlayerManager.addPlayer(PlayerType.BOOSTER, target.getName());
                        PlayerManager.addPlayer(PlayerType.FREE, target.getName());
						p.sendMessage(Settings.PREFIX("The player " + Settings.PURPLE + target.getName() + Settings.WHITE + " has been logged into " + Settings.PURPLE + Settings.NAME + " premium"));
					} else if (args[2].equalsIgnoreCase("booster")) {
                        PlayerManager.addPlayer(PlayerType.BOOSTER, target.getName());
                        PlayerManager.addPlayer(PlayerType.FREE, target.getName());
						p.sendMessage(Settings.PREFIX("The player " + Settings.PURPLE + target.getName() + Settings.WHITE + " has been logged into " + Settings.PURPLE + Settings.NAME + " booster"));
					} else if (args[2].equalsIgnoreCase("free")) {
                        PlayerManager.addPlayer(PlayerType.FREE, target.getName());
						p.sendMessage(Settings.PREFIX("The player " + Settings.PURPLE + target.getName() + Settings.WHITE + " has been logged into " + Settings.PURPLE + Settings.NAME + " free"));
					} else if (args[2].equalsIgnoreCase("unregistered")) {
						
					}
					target.sendMessage(Settings.PREFIX("You have been logged into " + Settings.PURPLE + Settings.NAME + " " + args[2].toLowerCase() + Settings.WHITE + " by an admin"));
				}
			}
		}
	}
}