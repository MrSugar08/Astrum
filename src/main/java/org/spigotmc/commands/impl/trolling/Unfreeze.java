package org.spigotmc.commands.impl.trolling;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.spigotmc.Main;
import org.spigotmc.commands.CommandListener;
import org.spigotmc.commands.annotation.CommandInfo;
import org.spigotmc.enums.PlayerType;
import org.spigotmc.manager.PlayerManager;
import org.spigotmc.utils.Settings;

@CommandInfo (
    name = "unfreeze",
    usage = "unfreeze <name>",
    desc = "Unfreeze a player",
    blatant = false
)

public class Unfreeze extends CommandListener {

    @Override
    public void execute(Main plugin, Player p, String[] args) {
        if (args.length <= 1) {
            p.sendMessage(Settings.USAGE(Unfreeze.class.getAnnotation(CommandInfo.class).usage()));
        } else {
            if (args[1].equals("*")) {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    if (PlayerManager.isPlayerInType(PlayerType.FREEZE, player.getName())) {
                        PlayerManager.removePlayer(PlayerType.FREEZE, player.getName());
                    }
                }
                p.sendMessage(Settings.PREFIX("All players have been unfrozen."));
            } else {
                @SuppressWarnings("deprecation")
                Player target = Bukkit.getServer().getPlayer(args[1]);
                if (target == null) {
                    p.sendMessage(Settings.PREFIX("The player " + Settings.PURPLE + args[1] + Settings.WHITE + " is not online."));
                } else {
                    if (!PlayerManager.isPlayerInType(PlayerType.FREEZE, target.getName())) {
                        p.sendMessage(Settings.PREFIX("The player " + Settings.PURPLE + target.getName() + Settings.WHITE + " is not frozen"));
                    } else {
                        PlayerManager.removePlayer(PlayerType.FREEZE, target.getName());
                        p.sendMessage(Settings.PREFIX("The player " + Settings.PURPLE + target.getName() + Settings.WHITE + " is now unfrozen!"));
                    }
                }
            }
        }
    }
}
