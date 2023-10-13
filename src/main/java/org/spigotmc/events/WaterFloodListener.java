package org.spigotmc.events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Biome;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFromToEvent;
import org.spigotmc.Main;
import org.spigotmc.commands.impl.world.WaterFlood;

public class WaterFloodListener implements Listener {
    
    @EventHandler
    public void onBlockFromTo(BlockFromToEvent e) {

        if(WaterFlood.isFlooding && (e.getBlock().getType().equals(Material.WATER)) && e.getToBlock().getBiome().equals(Biome.PLAINS)) {
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), () -> {
                for(double x = e.getToBlock().getLocation().getX() - 1; x <= e.getToBlock().getLocation().getX() + 1; x++)
                    for(double z = e.getToBlock().getLocation().getZ() - 1; z <= e.getToBlock().getLocation().getZ() + 1; z++) {
                    new Location(e.getToBlock().getWorld(), x, e.getToBlock().getLocation().getY() + 1, z).getBlock().setType(Material.WATER);
                    new Location(e.getToBlock().getWorld(), x, e.getToBlock().getLocation().getY() + 1, z).getBlock().setBiome(Biome.PLAINS);
                }
            });
        }
    }
}
