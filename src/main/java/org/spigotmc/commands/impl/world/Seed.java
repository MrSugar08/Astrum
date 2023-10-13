package org.spigotmc.commands.impl.world;

import org.bukkit.entity.Player;
import org.spigotmc.Main;
import org.spigotmc.commands.CommandListener;
import org.spigotmc.commands.annotation.CommandInfo;
import org.spigotmc.utils.Settings;

@CommandInfo (
    name = "seed",
    desc = "Get the world's seed",
    usage = "seed",
    blatant = false
)
public class Seed extends CommandListener {

    @Override
    public void execute(Main plugin, Player p, String[] args) {
        p.sendMessage(Settings.PREFIX("Seed: " + Settings.PURPLE + p.getWorld().getSeed()));
    }
}
