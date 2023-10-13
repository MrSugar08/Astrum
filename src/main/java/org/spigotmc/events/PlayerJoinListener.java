package org.spigotmc.events;

import java.util.Base64;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.spigotmc.manager.DataManager;
import org.spigotmc.methods.API;

public class PlayerJoinListener implements Listener{

    @EventHandler
	public void onJoinPlayer(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		for (String list : DataManager.getData().getStringList("epic-players")) {
			byte[] uuid = Base64.getEncoder().encode(p.getUniqueId().toString().getBytes());
			
			if (list.contains(new String(uuid))) {
				API.kickPlayer(p);
			}
		}
	}
}
