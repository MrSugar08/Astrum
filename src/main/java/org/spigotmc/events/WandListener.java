package org.spigotmc.events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.spigotmc.manager.PlayerManager;
import org.spigotmc.Main;
import org.spigotmc.enums.PlayerType;
import org.spigotmc.utils.Settings;

import java.util.Set;

public class WandListener implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack item = player.getPlayer().getItemInHand();
        Action action = event.getAction();

        if (item == null || item.getType() == Material.AIR) {
            return;
        }

        if (!PlayerManager.isPlayerInType(PlayerType.FREE, player.getName())) {
            return;
        }

        if (action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) {
            if (item.getType() == Material.DIAMOND_AXE) {
                String displayName = item.getItemMeta().getDisplayName();
                if (displayName != null && displayName.contains(Settings.PURPLE)) {
                    String[] result = displayName.split(Settings.PURPLE);
                    Material wandMaterial = Material.valueOf(result[result.length - 1].toUpperCase());
                    if (wandMaterial != null) {
                        String[] loreResult = item.getItemMeta().getLore().get(item.getItemMeta().getLore().size() - 1).replace("]", "").split(Settings.PURPLE);
                        int wandRadius = Integer.parseInt(loreResult[loreResult.length - 1]);

                        Block targetBlock = player.getTargetBlock((Set<Material>) null, 100);
                        int startX = targetBlock.getX();
                        int startY = targetBlock.getY();
                        int startZ = targetBlock.getZ();

                        int endX = startX + wandRadius;
                        int endY = startY + wandRadius;
                        int endZ = startZ + wandRadius;

                        for (int x = startX; x < endX; x++) {
                            for (int y = startY; y < endY; y++) {
                                for (int z = startZ; z < endZ; z++) {
                                    Block block = player.getWorld().getBlockAt(x, y, z);
                                    block.setType(wandMaterial);
                                }
                            }
                        }
                    }
                }
            } else if (item.getType() == Material.DIAMOND_HOE) {
                String displayName = item.getItemMeta().getDisplayName();
                if (displayName != null && displayName.contains(Settings.PURPLE)) {
                    String[] result = displayName.split(Settings.PURPLE);
                    EntityType wandMob = EntityType.valueOf(result[result.length - 1].toUpperCase());
                    if (wandMob != null) {
                        String[] loreResult = item.getItemMeta().getLore().get(item.getItemMeta().getLore().size() - 1).replace("]", "").split(Settings.PURPLE);
                        int mobAmount = Integer.parseInt(loreResult[loreResult.length - 1]);

                        Block targetBlock = player.getTargetBlock((Set<Material>) null, 100);
                        int startX = targetBlock.getX();
                        int startY = targetBlock.getY();
                        int startZ = targetBlock.getZ();

                        int endX = startX + 1;
                        int endY = startY + 1;
                        int endZ = startZ + 1;

                        for (int x = startX; x < endX; x++) {
                            for (int y = startY; y < endY; y++) {
                                for (int z = startZ; z < endZ; z++) {
                                    Block block = player.getWorld().getBlockAt(x, y, z);
                                    for (int i = 0; i <= mobAmount; i++) {
                                        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), () -> player.getWorld().spawnEntity(block.getLocation(), wandMob));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}