package org.spigotmc.commands.impl.server;

import org.bukkit.entity.Player;
import org.spigotmc.Main;
import org.spigotmc.commands.CommandListener;
import org.spigotmc.commands.annotation.CommandInfo;
import org.spigotmc.methods.API;
import org.spigotmc.utils.Settings;

@CommandInfo (
    name = "serverchat",
    desc = "serverchat <message>",
    usage = "Send a message to signed users",
    aliases = "sc",
    blatant = false
)
public class ServerChat extends CommandListener{

    @Override
    public void execute(Main plugin, Player p, String[] args) {
        if (args.length <= 1) {
            p.sendMessage(Settings.USAGE(ServerChat.class.getAnnotation(CommandInfo.class).usage()));
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 1; i < args.length; i++) {
                stringBuilder.append(args[i]).append(" ");
            }
            API.sendToServerChat(p, stringBuilder.toString().trim());
        }
    }   
}
