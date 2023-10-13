package org.spigotmc.utils;

import org.bukkit.ChatColor;

public class Settings {
    public static final String NAME = "Astrum";
    public static final String AUTHOR = "Java";
    public static final String VERSION = "5.0-openbeta";
    public static final String URL = "http://elixia.fun";

    public static String DARK_PURPLE = ChatColor.translateAlternateColorCodes((char)'&', (String)"&5");
    public static String WHITE = ChatColor.translateAlternateColorCodes((char)'&', (String)"&f");
    public static String PURPLE = ChatColor.translateAlternateColorCodes((char)'&', (String)"&d");
    public static String GRAY = ChatColor.translateAlternateColorCodes((char)'&', (String)"&7");
    public static String DARK_GRAY = ChatColor.translateAlternateColorCodes((char)'&', (String)"&8");

    public static String PREFIX(String msg) {
        return DARK_PURPLE + NAME + ChatColor.translateAlternateColorCodes((char)'&', (String)" &8| ") + WHITE + msg;
    }
    public static String USAGE(String msg) {
        return DARK_PURPLE + "Usage" + ChatColor.translateAlternateColorCodes((char)'&', (String)" &8| ") + WHITE + msg;
    }
}
