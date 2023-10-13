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
    name = "freeze",
    usage = "freeze <name>",
    desc = "Freeze any",
    blatant = false
)

public class Freeze extends CommandListener{

    @Override
    public void execute(Main plugin, Player p, String[] args) {
        if (args.length <= 1) {
            p.sendMessage(Settings.USAGE(Freeze.class.getAnnotation(CommandInfo.class).usage()));
        } else {
            if (args[1].equals("*")) {
                for (Player a : Bukkit.getOnlinePlayers()) {
                    if (!PlayerManager.isPlayerInType(PlayerType.FREE, a.getName())) {
                        if (!PlayerManager.isPlayerInType(PlayerType.FREEZE, a.getName())) {
                            PlayerManager.addPlayer(PlayerType.FREEZE, a.getName());
                        }
                    }
                }
                p.sendMessage(Settings.PREFIX("Everyone is now frozen"));
            } else {
                @SuppressWarnings("deprecation")
                Player target = Bukkit.getServer().getPlayer(args[1]);
                if (target == null) {
                    p.sendMessage(Settings.PREFIX("The player " + Settings.PURPLE + args[1] + Settings.WHITE + " is not online."));
                } else {
                    if (PlayerManager.isPlayerInType(PlayerType.FREEZE, target.getName())) {
                        p.sendMessage(Settings.PREFIX("The player " + Settings.PURPLE + target.getName() + Settings.WHITE + " is already frozen"));
                    } else {
                        PlayerManager.addPlayer(PlayerType.FREEZE, target.getName());
                        p.sendMessage(Settings.PREFIX("The player " + Settings.PURPLE + target.getName() + Settings.WHITE + " is now frozen!"));
                    }
                }
            }
        }
    }
}
