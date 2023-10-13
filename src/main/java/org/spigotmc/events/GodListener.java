package org.spigotmc.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.spigotmc.manager.PlayerManager;
import org.spigotmc.enums.PlayerType;

public class GodListener implements Listener {

    @EventHandler
    public void onEntityDamage(EntityDamageEvent e) {
        if (e.getEntity() instanceof Player) {
            Player player = (Player) e.getEntity();
            if (PlayerManager.isPlayerInType(PlayerType.GOD, player.getName())) {
                if (e.getCause() != DamageCause.VOID) {
                    double newHealth = player.getHealth() - e.getDamage();
                    if (newHealth <= 0) {
                        player.setHealth(1);
                        e.setCancelled(true);
                        player.setHealth(5);
                    }
                }
            }
        }
    }
}
