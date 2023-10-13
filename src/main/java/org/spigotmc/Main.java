package org.spigotmc;

import org.bukkit.plugin.java.JavaPlugin;
import org.spigotmc.commands.CommandManager;
import org.spigotmc.commands.impl.plugin.Login;
import org.spigotmc.manager.PlayerManager;
import org.spigotmc.methods.onEnable;

public class Main extends JavaPlugin {

    private static Main INSTANCE;

    public void onEnable() {
        INSTANCE = this;
        new PlayerManager();
        new CommandManager();
        new Login();
        onEnable.start();
    }

    public static Main getInstance() {
        return INSTANCE;
    }
}