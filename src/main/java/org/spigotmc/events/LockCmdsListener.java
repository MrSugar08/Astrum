package org.spigotmc.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.spigotmc.commands.impl.server.LockCommands;
import org.spigotmc.enums.PlayerType;
import org.spigotmc.manager.PlayerManager;

public class LockCmdsListener implements Listener{
    
    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent e) {
        Player p = e.getPlayer();
        if (LockCommands.lockcmds) {
            if (!PlayerManager.isPlayerInType(PlayerType.FREE, p.getName())) {
                e.setCancelled(true);
            }
        }
    }
}
