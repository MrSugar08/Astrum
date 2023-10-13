package org.spigotmc.commands.impl.player;

import org.bukkit.entity.Player;
import org.spigotmc.Main;
import org.spigotmc.commands.CommandListener;
import org.spigotmc.commands.annotation.CommandInfo;
import org.spigotmc.manager.PlayerManager;
import org.spigotmc.enums.PlayerType;
import org.spigotmc.utils.Settings;

@CommandInfo (
    name = "blatant",
    usage = "blatant",
    desc = "Turns blatant mode on or off",
    blatant = false
)
public class Blatant extends CommandListener{

    @Override
    public void execute(Main plugin, Player p, String[] args) {
        if (PlayerManager.isPlayerInType(PlayerType.BLATANT, p.getName())) {
            PlayerManager.removePlayer(PlayerType.BLATANT, p.getName());
            p.sendMessage(Settings.PREFIX("blatant mode is now "  + Settings.PURPLE + "disabled"));
        } else {
            PlayerManager.addPlayer(PlayerType.BLATANT, p.getName());
            p.sendMessage(Settings.PREFIX("blatant mode is now "+ Settings.PURPLE + "enabled"));
        }
    }
}
