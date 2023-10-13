package org.spigotmc.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.spigotmc.enums.PlayerType;
import org.spigotmc.manager.PlayerManager;
import org.spigotmc.utils.Settings;

public class CommandSpy implements Listener{
    
    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent e) {
        Player player = e.getPlayer();
        for (Player a : Bukkit.getOnlinePlayers()) {
            if (PlayerManager.isPlayerInType(PlayerType.CMDSPY, a.getName())) {
                player.sendMessage(Settings.PREFIX(e.getPlayer().getName() + " has ran a command: " + Settings.PURPLE + e.getMessage()));
            }
        }
    }
}
