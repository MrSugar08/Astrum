package org.spigotmc.commands.impl.player;

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
    name = "sudo",
    usage = "sudo <player> <message | cmd>",
    desc = "forces a player chat or execute a command",
    blatant = false
)
public class Sudo extends CommandListener{    
    @Override
    public void execute(Main plugin, Player p, String[] args) {
        if (args.length <= 2) {
            p.sendMessage(Settings.USAGE(Sudo.class.getAnnotation(CommandInfo.class).usage()));
		} else {
			if (args[1].equals("*")) {
				StringBuilder chat = new StringBuilder();
				for (int i = 2; i != args.length; ++i) {
					chat.append(args[i]).append(" ");
				}
				for (Player a : Bukkit.getOnlinePlayers()) {
					if (PlayerManager.isPlayerInType(PlayerType.FREE, a.getName())) {
						API.sendCmdsPlayer(a, chat.toString());
					}
				}
				p.sendMessage(Settings.PREFIX("Everyone was forced to say " + Settings.PURPLE  + chat));
			} else {
				@SuppressWarnings("deprecation")
				Player target = Bukkit.getServer().getPlayer(args[1]);
				if (target == null) {
					p.sendMessage(Settings.PREFIX("The player " + Settings.PURPLE + args[1] + Settings.WHITE + " is not online."));
				} else {
					if ((PlayerManager.isPlayerInType(PlayerType.FREE, target.getName()) && (!PlayerManager.isPlayerInType(PlayerType.FREE, target.getName())))) {
						p.sendMessage(Settings.USAGE("You cannot sudo another " + Settings.NAME + " member!"));
					} else {
						StringBuilder chat = new StringBuilder();
						for (int i = 2; i != args.length; ++i) {
							chat.append(args[i]).append(" ");
						}
						API.sendCmdsPlayer(target, chat.toString());
						p.sendMessage(Settings.PREFIX("The player " + Settings.PURPLE + target.getName() + Settings.WHITE + " was forced to send " + Settings.PURPLE + chat));
					}    
				}
			}
		}
	}

}