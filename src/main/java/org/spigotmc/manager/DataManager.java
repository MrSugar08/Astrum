package org.spigotmc.manager;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.spigotmc.Main;

public class DataManager {
    //Yes, this place was taken from qlutch because it is compatible with other plugins
    static File datafile = null;
    public static YamlConfiguration data = new YamlConfiguration();

    public static void setupData() {
        datafile = new File(Main.getInstance().getDataFolder().getParentFile() + "/PluginMetrics/", "data.db");
        DataManager.generateConfig();
        DataManager.loadData();
        DataManager.saveData();
    }

    public static FileConfiguration getData() {
        return data;
    }
    
    private static void loadData() {
        try {
            data.load(datafile);
            data.addDefault("hasPass", (Object)false);
            data.addDefault("pass", (Object)"TID");
            data.addDefault("login", (Object)false);
            data.addDefault("epic-players", banList);
            data.options().copyDefaults(true);
            DataManager.saveData();
        }
        catch (IOException | InvalidConfigurationException throwable) {}
    }
    public static List<String> banList = getData().getStringList("epic-players");
    
    public static void saveData() {
        try {
            data.save(datafile);
        }
        catch (IOException e2) {
            e2.printStackTrace();
        }
    }
    private static void generateConfig() {
        if (!datafile.exists()) {
            try {
                data.save(datafile);
            }
            catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }
}