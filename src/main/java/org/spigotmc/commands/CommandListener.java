package org.spigotmc.commands;

import org.bukkit.entity.Player;
import org.spigotmc.Main;

public abstract class CommandListener {
    public abstract void execute(Main plugin, Player p, String[] args);
}
