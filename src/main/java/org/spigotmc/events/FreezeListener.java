package org.spigotmc.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.spigotmc.enums.PlayerType;
import org.spigotmc.manager.PlayerManager;

public class FreezeListener implements Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        if (PlayerManager.isPlayerInType(PlayerType.FREEZE, player.getName())) {
            event.setCancelled(true);
        }
    }
}
