package org.spigotmc.commands.impl.server;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.spigotmc.Main;
import org.spigotmc.commands.CommandListener;
import org.spigotmc.commands.annotation.CommandInfo;
import org.spigotmc.utils.Settings;

@CommandInfo (
    name = "save",
    usage = "save",
    desc = "Save server and worlds",
    blatant = false
)
public class Save extends CommandListener {

    @Override
    public void execute(Main plugin, Player p, String[] args) {
        Bukkit.getServer().savePlayers();
        Bukkit.getWorlds().forEach(World::save);
        p.sendMessage(Settings.PREFIX("Successfully recorded everything"));
    }
}