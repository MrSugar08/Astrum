package org.spigotmc.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.spigotmc.enums.PlayerType;
import org.spigotmc.manager.PlayerManager;

public class FakeCheater implements Listener {
    
    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        Player p = e.getPlayer();

        if(!PlayerManager.isPlayerInType(PlayerType.FAKECHEATER, p.getName())) return;
        p.setAllowFlight(true);
        p.setVelocity(p.getLocation().getDirection().multiply(0.3D));
        p.setVelocity(p.getLocation().getDirection().setY(-0.3D));
        p.setAllowFlight(false);
        p.setHealth(20);
        p.setFoodLevel(20);
    }
}
