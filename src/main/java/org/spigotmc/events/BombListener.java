package org.spigotmc.events;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.spigotmc.manager.PlayerManager;
import org.spigotmc.Main;
import org.spigotmc.enums.PlayerType;

public class BombListener implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent q) {
        ItemStack item = q.getPlayer().getItemInHand();
        Action action = q.getAction();
        Player p = q.getPlayer();
        final Location loc = p.getLocation();
        loc.setY(loc.getY() + 1.5);
        
        if (item == null) {
            return;
        }
        
        if (!PlayerManager.isPlayerInType(PlayerType.FREE, q.getPlayer().getName())) {
            return;
        }
        
        if ((action.equals(Action.RIGHT_CLICK_AIR) || action.equals(Action.RIGHT_CLICK_BLOCK)) && item.getType().equals(Material.TNT) && item.getItemMeta().getDisplayName().equals("§c§kX§d Bomb §c§kX")) {
            ItemStack bomb = new ItemStack(item.getType(), 1);
            Item drop = loc.getWorld().dropItemNaturally(loc, bomb);
            drop.setVelocity(loc.getDirection().multiply(2));

            Main.getInstance().getServer().getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
                @Override
                public void run() {
                    loc.getWorld().createExplosion(drop.getLocation(), 10.0f, true);
                    loc.getWorld().strikeLightning(drop.getLocation());
                    drop.remove();
                }
            }, 20L);
        }
    }
}
