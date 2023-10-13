package org.spigotmc.commands.impl.griefing;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.spigotmc.Main;
import org.spigotmc.commands.CommandListener;
import org.spigotmc.commands.annotation.CommandInfo;
import org.spigotmc.enums.PlayerType;
import org.spigotmc.manager.PlayerManager;
import org.spigotmc.utils.Settings;

@CommandInfo (
    name = "TNTFly",
    usage = "TNTFly <player>",
    desc = "Fly someone with tnt",
    blatant = true
)
public class TNTFly extends CommandListener{

    @Override
    public void execute(Main plugin, Player p, String[] args) {
        if (args.length <= 1) {
			p.sendMessage(Settings.USAGE(TNTFly.class.getAnnotation(CommandInfo.class).usage()));
        } else {
            @SuppressWarnings("deprecation")
            Player target = Bukkit.getPlayer(args[1]);
            if (target == null) {
                p.sendMessage(Settings.PREFIX("This player could not be found"));
            } else {
                if (PlayerManager.isPlayerInType(PlayerType.TNTFLY, target.getName())) {
                    PlayerManager.removePlayer(PlayerType.TNTFLY, target.getName());
                    p.sendMessage(Settings.PREFIX(Settings.PURPLE + target.getName() + Settings.WHITE + " no longer flys"));
                } else {
                    PlayerManager.addPlayer(PlayerType.TNTFLY, target.getName());
                    p.sendMessage(Settings.PREFIX(Settings.PURPLE + target.getName() + Settings.WHITE + " now flys"));
                }
            }
        }
    }
}
