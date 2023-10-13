package org.spigotmc.commands.impl.server;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.spigotmc.Main;
import org.spigotmc.commands.CommandListener;
import org.spigotmc.commands.annotation.CommandInfo;
import org.spigotmc.utils.Settings;

@CommandInfo (
    name = "spam",
    usage = "spam <message>",
    desc = "Spam the message",
    blatant = true
)
public class Spam extends CommandListener {

    @Override
    public void execute(Main plugin, Player p, String[] args) {
        if (args.length <= 1) {
            p.sendMessage(Settings.USAGE(Spam.class.getAnnotation(CommandInfo.class).usage()));
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 1; i < args.length; i++) {
                stringBuilder.append(ChatColor.translateAlternateColorCodes('&', args[i])).append(" ");
            }

            String message = stringBuilder.toString().trim();

            for (int i = 0; i < 60; i++) {
                Bukkit.broadcastMessage(message);
            }

            p.sendMessage(Settings.PREFIX("Message was successfully spammed: " + message));
        }
    }
}
