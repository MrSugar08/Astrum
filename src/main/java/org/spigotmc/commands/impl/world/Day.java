package org.spigotmc.commands.impl.world;

import org.bukkit.entity.Player;
import org.spigotmc.Main;
import org.spigotmc.commands.CommandListener;
import org.spigotmc.commands.annotation.CommandInfo;
import org.spigotmc.methods.API;
import org.spigotmc.utils.Settings;

@CommandInfo (
    name = "day",
    desc = "Set the time to day",
    usage = "day",
    blatant = false
)

public class Day extends CommandListener {

    @Override
    public void execute(Main plugin, Player p, String[] args) {
        API.changeTime(p, 6000);
        p.sendMessage(Settings.PREFIX("Successfully changed the time to day"));
    }
}
