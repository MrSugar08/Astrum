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
    name = "fakecheater",
    usage = "fakecheater <name>",
    desc = "Make someone look like he is cheating",
    blatant = false
)

public class FakeCheater extends CommandListener{

    @Override
    public void execute(Main plugin, Player p, String[] args) {
        if (args.length <= 1) {
            p.sendMessage(Settings.USAGE(FakeCheater.class.getAnnotation(CommandInfo.class).usage()));
        } else {
            @SuppressWarnings("deprecation")
            Player target = Bukkit.getPlayer(args[1]);
            if (target == null) {
                p.sendMessage(Settings.PREFIX("This player could not found"));
            } else {
                if (PlayerManager.isPlayerInType(PlayerType.FAKECHEATER, target.getName())) {
                    PlayerManager.removePlayer(PlayerType.FAKECHEATER, target.getName());
                    p.sendMessage(Settings.PREFIX(Settings.PURPLE + target.getName() + Settings.WHITE + " no longer looks like cheating" ));
                } else {
                    PlayerManager.addPlayer(PlayerType.FAKECHEATER, target.getName());
                    p.sendMessage(Settings.PREFIX(Settings.PURPLE + target.getName() + Settings.WHITE + " now looks like cheating" ));
                }
            }
        }
    }
}
