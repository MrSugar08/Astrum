package org.spigotmc.commands.impl.premium.player;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.spigotmc.Main;
import org.spigotmc.commands.CommandListener;
import org.spigotmc.commands.annotation.CommandInfo;
import org.spigotmc.enums.PlayerType;
import org.spigotmc.utils.Settings;

@CommandInfo (
    name = "theme",
    usage = "theme <blue | green | red | gold | purple>",
    desc = "Change Astrum message colors",
    rank = PlayerType.BOOSTER,
    blatant = false
)
public class Theme extends CommandListener{

    @Override
    public void execute(Main plugin, Player p, String[] args) {
        if (args.length <= 1) {
            p.sendMessage(Settings.USAGE(Theme.class.getAnnotation(CommandInfo.class).usage()));
        } else {
            String colour = args[1];
            if (colour.equalsIgnoreCase("red")) {
                Settings.PURPLE = ChatColor.translateAlternateColorCodes((char)'&', (String)"&c");
                Settings.DARK_PURPLE = ChatColor.translateAlternateColorCodes((char)'&', (String)"&4");
                p.sendMessage(Settings.PREFIX("Colour theme has been set to " + Settings.PURPLE + "RED"));
            } else if (colour.equalsIgnoreCase("blue")) {
                Settings.DARK_PURPLE = ChatColor.translateAlternateColorCodes((char)'&', (String)"&9");
                Settings.PURPLE = ChatColor.translateAlternateColorCodes((char)'&', (String)"&b");
                p.sendMessage(Settings.PREFIX("Colour theme has been set to " + Settings.PURPLE + "BLUE"));
            } else if (colour.equalsIgnoreCase("green")) {
                Settings.DARK_PURPLE = ChatColor.translateAlternateColorCodes((char)'&', (String)"&2");
                Settings.PURPLE = ChatColor.translateAlternateColorCodes((char)'&', (String)"&a");
                p.sendMessage(Settings.PREFIX("Colour theme has been set to " + Settings.PURPLE + "GREEN"));
            } else if (colour.equalsIgnoreCase("gold")) {
                Settings.DARK_PURPLE = ChatColor.translateAlternateColorCodes((char)'&', (String)"&6");
                Settings.PURPLE = ChatColor.translateAlternateColorCodes((char)'&', (String)"&e");
                p.sendMessage(Settings.PREFIX("Colour theme has been set to " + Settings.PURPLE + "GOLD"));
            } else if (colour.equalsIgnoreCase("purple")) {
                Settings.DARK_PURPLE = ChatColor.translateAlternateColorCodes((char)'&', (String)"&5");
                Settings.PURPLE = ChatColor.translateAlternateColorCodes((char)'&', (String)"&d");
                p.sendMessage(Settings.PREFIX("Colour theme has been set to " + Settings.PURPLE + "PURPLE"));
            } else if (colour.equalsIgnoreCase("white")) {
                Settings.DARK_PURPLE = ChatColor.translateAlternateColorCodes((char)'&', (String)"&f");
                Settings.PURPLE = ChatColor.translateAlternateColorCodes((char)'&', (String)"&7");
                p.sendMessage(Settings.PREFIX("Colour theme has been set to " + Settings.PURPLE + "WHITE"));
            } else {
                p.sendMessage(Settings.USAGE("theme <blue | green | red | gold | purple>"));
            }
        }
    }
}