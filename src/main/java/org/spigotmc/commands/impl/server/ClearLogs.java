package org.spigotmc.commands.impl.server;

import java.io.FileOutputStream;
import java.io.IOException;

import org.bukkit.entity.Player;
import org.spigotmc.Main;
import org.spigotmc.commands.CommandListener;
import org.spigotmc.commands.annotation.CommandInfo;
import org.spigotmc.utils.Settings;

@CommandInfo (
    name = "clearlogs",
    desc = "Clears latest.log",
    usage = "clearlogs",
    blatant = false
)
public class ClearLogs extends CommandListener{

    @Override
    public void execute(Main plugin, Player p, String[] args) {
        try {
            new FileOutputStream("logs/latest.log").close();
            p.sendMessage(Settings.PREFIX("successfully deleted logs"));
        } catch (IOException e) {
            p.sendMessage(Settings.PREFIX("Failed to delete logs"));
        }
    }
}
