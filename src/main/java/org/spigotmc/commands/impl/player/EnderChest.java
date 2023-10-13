package org.spigotmc.commands.impl.player;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.spigotmc.Main;
import org.spigotmc.commands.CommandListener;
import org.spigotmc.commands.annotation.CommandInfo;
import org.spigotmc.utils.Settings;

@CommandInfo(
        name = "enderchest",
        usage = "enderchest <player>",
        desc = "View the enderchest of a player",
        aliases = "ec",
        blatant = false
)
public class EnderChest extends CommandListener {

    @Override
    public void execute(Main plugin, Player p, String[] args) {
        if (args.length < 2) {
            p.sendMessage(Settings.USAGE(getClass().getAnnotation(CommandInfo.class).usage()));
        } else {
            @SuppressWarnings("deprecation")
            Player target = Bukkit.getPlayer(args[1]); 
            if (target == null) {
                p.sendMessage(Settings.PREFIX("This player is not online"));
            } else {
                Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), () -> {
                    p.openInventory(target.getEnderChest());
                });
            }
        }
    }
}
