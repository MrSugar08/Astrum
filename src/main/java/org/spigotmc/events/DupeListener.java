package org.spigotmc.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;
import org.spigotmc.methods.API;
import org.spigotmc.utils.Settings;

public class DupeListener implements Listener {
	
	@EventHandler
	public void CloseInventory(InventoryCloseEvent e) {
		if (API.dinventory.contains(e.getInventory())) {
			Player p = (Player) e.getPlayer();
			boolean isonground = false;
			for (int i = 0; i <= 27 - 1; ++i) {
				if (e.getInventory().getItem(i) == null) continue;
				ItemStack item = e.getInventory().getItem(i);
				if (p.getInventory().firstEmpty() != -1) {
					p.getInventory().addItem(new ItemStack[]{item});
					continue;
				}
				p.getWorld().dropItem(p.getLocation(), item);
				isonground = true;
			}
			if (isonground) {
				p.sendMessage(Settings.PREFIX("Your items have been dropped on the ground!"));
			}
			API.dinventory.remove(e.getInventory());
		}
	}
}
