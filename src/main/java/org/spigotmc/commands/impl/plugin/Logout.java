package org.spigotmc.commands.impl.plugin;

import org.bukkit.entity.Player;
import org.spigotmc.Main;
import org.spigotmc.commands.CommandListener;
import org.spigotmc.commands.annotation.CommandInfo;
import org.spigotmc.manager.PlayerManager;
import org.spigotmc.enums.PlayerType;
import org.spigotmc.utils.Settings;

@CommandInfo (
    name = "logout",
    usage = "logout",
    desc = "Logs out so you can speak again!",
    blatant = false
)
public class Logout extends CommandListener{

    @Override
    public void execute(Main plugin, Player p, String[] args) {
        PlayerManager.removePlayer(PlayerType.FREE, p.getName());
        PlayerManager.removePlayer(PlayerType.BOOSTER, p.getName());
        PlayerManager.removePlayer(PlayerType.PREMIUM, p.getName());
        PlayerManager.removePlayer(PlayerType.ADMIN, p.getName());
        p.sendMessage(Settings.PREFIX("You can now talk in chat and no longer execute " + Settings.NAME + " commands"));
    }
}
