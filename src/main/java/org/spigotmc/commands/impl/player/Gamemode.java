package org.spigotmc.commands.impl.player;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.spigotmc.Main;
import org.spigotmc.commands.CommandListener;
import org.spigotmc.commands.annotation.CommandInfo;
import org.spigotmc.methods.API;
import org.spigotmc.utils.Settings;

@CommandInfo(
    name = "gamemode",
    usage = "gamemode <mode>",
    desc = "Change the gamemode of a player",
    aliases = "gm",
    blatant = true
)
public class Gamemode extends CommandListener {

    private static final String[] GAMEMODE_NAMES = {
        "Creative",
        "Survival",
        "Adventure",
        "Spectator"
    };

    @Override
    public void execute(Main plugin, Player p, String[] args) {
        if (args.length < 2) {
            p.sendMessage(Settings.USAGE(Gamemode.class.getAnnotation(CommandInfo.class).usage()));
            return;
        }

        String modeStr = args[1].toLowerCase();

        GameMode mode = null;
        if (modeStr.equals("0") || modeStr.equals("survival") || modeStr.equals("s")) {
            mode = GameMode.SURVIVAL;
        } else if (modeStr.equals("1") || modeStr.equals("creative") || modeStr.equals("c")) {
            mode = GameMode.CREATIVE;
        } else if (modeStr.equals("2") || modeStr.equals("adventure") || modeStr.equals("a")) {
            mode = GameMode.ADVENTURE;
        } else if (modeStr.equals("3") || modeStr.equals("spectator") || modeStr.equals("sp")) {
            mode = GameMode.SPECTATOR;
        }

        if (mode == null) {
            p.sendMessage(Settings.USAGE("Invalid gamemode! Use §d0§7/§dsurvival§7/§ds§7, §d1§7/§dcreative§7/§dc§7, §d2§7/§dadventure§7/§da§7, or §d3§7/§dspectator§7/§dsp."));
            return;
        }

        final String modeName = GAMEMODE_NAMES[mode.ordinal()];
        final GameMode finalMode = mode;

        API.setPlayerGamemode(p, finalMode);
        p.sendMessage(Settings.PREFIX("Your gamemode has been updated to " + Settings.PURPLE + modeName));
    }
}
