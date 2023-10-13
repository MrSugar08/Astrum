package org.spigotmc.commands.impl.player;

import org.bukkit.entity.Player;
import org.spigotmc.Main;
import org.spigotmc.commands.CommandListener;
import org.spigotmc.commands.annotation.CommandInfo;
import org.spigotmc.utils.Settings;
import org.spigotmc.manager.PlayerManager;
import org.spigotmc.enums.PlayerType;

@CommandInfo (
    name = "god",
    usage = "god",
    desc = "Enables god mode",
    blatant = false
)
public class God extends CommandListener {

    @Override
    public void execute(Main plugin, Player p, String[] args) {
        if (PlayerManager.isPlayerInType(PlayerType.GOD, p.getName())) {
            PlayerManager.removePlayer(PlayerType.GOD, p.getName());
            p.sendMessage(Settings.PREFIX("god mode is now " + Settings.PURPLE + "disabled"));
        } else {
            PlayerManager.addPlayer(PlayerType.GOD, p.getName());
            p.sendMessage(Settings.PREFIX("god mode is now " + Settings.PURPLE + "enabled"));
        }
    }
}
