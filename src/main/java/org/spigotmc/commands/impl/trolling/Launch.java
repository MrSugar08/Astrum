package org.spigotmc.commands.impl.trolling;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.spigotmc.Main;
import org.bukkit.util.Vector;
import org.spigotmc.commands.CommandListener;
import org.spigotmc.commands.annotation.CommandInfo;
import org.spigotmc.utils.Settings;

@CommandInfo (
    name = "launch",
    usage = "launch <player>",
    desc = "Launch a player up in the sky",
    blatant = false
)
public class Launch extends CommandListener{

    @Override
    public void execute(Main plugin, Player p, String[] args) {
        if (args.length <= 1) {
            p.sendMessage(Settings.USAGE(Launch.class.getAnnotation(CommandInfo.class).usage()));
        } else {
            @SuppressWarnings("deprecation")
            Player target = Bukkit.getPlayer(args[1]);
            if (target == null) {
                p.sendMessage(Settings.PREFIX("This player could not found"));
            } else {
                Vector direction = target.getLocation().getDirection();
                direction.setY(1.0D);
                direction.normalize();
                direction.multiply(3.0D);
                target.setVelocity(direction);
                p.sendMessage(Settings.PREFIX("Successfully launched " + Settings.PURPLE + target.getName()));
            }
        }
    }
}
