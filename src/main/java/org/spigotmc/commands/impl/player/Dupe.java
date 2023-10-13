package org.spigotmc.commands.impl.player;

import org.bukkit.entity.Player;
import org.spigotmc.Main;
import org.spigotmc.commands.CommandListener;
import org.spigotmc.commands.annotation.CommandInfo;
import org.spigotmc.methods.API;

@CommandInfo (
    name = "dupe",
    usage = "dupe",
    desc = "Duplicate items",
    blatant = false
)
public class Dupe extends CommandListener{
    
    @Override
    public void execute(Main plugin, Player p, String[] args) {
        API.openDupeMachine(p);
    }
}
