package org.spigotmc.commands.impl.player;

import org.bukkit.entity.Player;
import org.spigotmc.Main;
import org.spigotmc.commands.CommandListener;
import org.spigotmc.commands.annotation.CommandInfo;
import org.spigotmc.enums.PlayerType;
import org.spigotmc.manager.PlayerManager;
import org.spigotmc.utils.Settings;

@CommandInfo (
    name = "commandspy",
    usage = "commandspy",
    desc = "See commands that everyone enters",
    aliases = "cmdspy",
    blatant = false
)
public class CommandSpy extends CommandListener {

    @Override
    public void execute(Main plugin, Player p, String[] args) {
        if (PlayerManager.isPlayerInType(PlayerType.CMDSPY, p.getName())) {
            PlayerManager.removePlayer(PlayerType.CMDSPY, p.getName());
            p.sendMessage(Settings.PREFIX("You no longer spy people's commands"));
        } else {
            PlayerManager.addPlayer(PlayerType.CMDSPY, p.getName());
            p.sendMessage(Settings.PREFIX("You can now spy on people's commands"));
        }
    }
}