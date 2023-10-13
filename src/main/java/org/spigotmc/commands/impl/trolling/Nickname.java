package org.spigotmc.commands.impl.trolling;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.spigotmc.Main;
import org.spigotmc.commands.CommandListener;
import org.spigotmc.commands.annotation.CommandInfo;
import org.spigotmc.utils.Settings;

@CommandInfo (
    name = "nickname",
    usage = "nickname <player> <newname>",
    desc = "Change the nick-name of a player",
    blatant = true
)

public class Nickname extends CommandListener {

    @Override
    public void execute(Main plugin, Player p, String[] args) {
        if (args.length <= 2) {
            p.sendMessage(Settings.USAGE(Nickname.class.getAnnotation(CommandInfo.class).usage()));
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 2; i < args.length; i++) {
                stringBuilder.append(ChatColor.translateAlternateColorCodes('&', args[i])).append(" ");
            }

            @SuppressWarnings("deprecation")
            Player target = Bukkit.getPlayer(args[1]);
            if (target == null) {
                p.sendMessage(Settings.PREFIX("This player could not be found"));
            } else {
                String nick = (ChatColor.translateAlternateColorCodes('&', stringBuilder.toString().trim()));
                target.setDisplayName(nick);
                target.setCustomName(nick);
                target.setCustomNameVisible(true);
                target.setPlayerListName(ChatColor.stripColor(nick));
                p.sendMessage(Settings.PREFIX("Successfully changed the nick-name of " + Settings.PURPLE + target.getName()));
            }
        }
    }
}
