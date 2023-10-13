package org.spigotmc.commands.impl.premium.server;

import org.bukkit.entity.Player;
import org.spigotmc.Main;
import org.spigotmc.commands.CommandListener;
import org.spigotmc.commands.annotation.CommandInfo;
import org.spigotmc.enums.PlayerType;
import org.spigotmc.manager.DataManager;
import org.spigotmc.utils.Settings;

@CommandInfo (
    name = "setpassword",
    usage = "setpassword <new password>",
    desc = "Add password to astrum",
    aliases = "pass",
	rank = PlayerType.BOOSTER,
	blatant = false
)
public class Password extends CommandListener{

    private static void set(String str) {
		DataManager.getData().set("pass", str);
		DataManager.saveData();
	}
    
    @Override
    public void execute(Main plugin, Player p, String[] args) {
		if (args.length <= 1) {
			p.sendMessage(Settings.USAGE(Password.class.getAnnotation(CommandInfo.class).usage()));
			p.sendMessage(Settings.PREFIX("Passwords can only be 1 word and are cap sensitive!"));
		} else {
			set(args[1]);
			if (!DataManager.getData().getBoolean("hasPass")) {
				DataManager.getData().set("hasPass", true);
				DataManager.saveData();
			}
			p.sendMessage(Settings.PREFIX("This server is now password protected!"));
		}
	}
}
