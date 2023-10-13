package org.spigotmc.events;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;
import org.spigotmc.enums.PlayerType;
import org.spigotmc.manager.PlayerManager;

public class TNTFlyListener implements Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();

        if (PlayerManager.isPlayerInType(PlayerType.TNTFLY, player.getName())) {
            player.setAllowFlight(true);
            player.setFlying(true);
            player.setVelocity(new Vector(0.0D, 0.4D, 0.0D));
            player.getWorld().spawnEntity(player.getLocation(), EntityType.PRIMED_TNT);
        }
    }
}
