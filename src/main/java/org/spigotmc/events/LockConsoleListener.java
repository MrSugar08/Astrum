package org.spigotmc.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerCommandEvent;
import org.spigotmc.commands.impl.server.LockConsole;

public class LockConsoleListener implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onConsoleCommand(ServerCommandEvent e) {
        if (LockConsole.isLocked) {
            e.setCancelled(true);
        }
    }
}
