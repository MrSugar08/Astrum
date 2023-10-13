package org.spigotmc.commands.impl.player;

import org.bukkit.entity.Player;
import org.spigotmc.Main;
import org.spigotmc.commands.CommandListener;
import org.spigotmc.commands.annotation.CommandInfo;
import org.spigotmc.utils.Settings;

@CommandInfo (
    name = "antiban",
    usage = "antiban",
    desc = "Turns antiban mode on or off (default on)",
    blatant = false
)

public class AntiBan extends CommandListener {
    public static boolean isAntiBanEnabled = true;

    @Override
    public void execute(Main plugin, Player p, String[] args) {
        if (isAntiBanEnabled) {
            isAntiBanEnabled = false;
            p.sendMessage(Settings.PREFIX("Antiban disabled"));
        } else {
            isAntiBanEnabled = true;
            p.sendMessage(Settings.PREFIX("Antiban enabled"));
        }
    }
}
