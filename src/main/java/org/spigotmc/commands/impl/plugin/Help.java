package org.spigotmc.commands.impl.plugin;

import org.spigotmc.commands.CommandListener;
import org.spigotmc.commands.CommandManager;
import org.spigotmc.commands.annotation.CommandInfo;
import org.spigotmc.manager.PlayerManager;
import org.spigotmc.enums.PlayerType;
import org.spigotmc.utils.Settings;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.spigotmc.Main;

import java.util.ArrayList;
import java.util.List;

@CommandInfo(
    name = "help",
    usage = "help <page>",
    desc = "Shows you list of all commands",
    blatant = false
)
public class Help extends CommandListener {

    private static final int COMMANDS_PER_PAGE = 10;

    @Override
    public void execute(Main plugin, Player p, String[] args) {
        if (args.length < 2) {
            p.sendMessage(Settings.USAGE(Help.class.getAnnotation(CommandInfo.class).usage()));
            return;
        }

        int page;
        try {
            page = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            p.sendMessage(Settings.USAGE(Help.class.getAnnotation(CommandInfo.class).usage()));
            return;
        }


        PlayerType playerRank = PlayerManager.getPlayerRank(p);

        List<CommandInfo> commandList = new ArrayList<>();
        for (CommandListener command : CommandManager.getCommands()) {
            CommandInfo commandInfo = command.getClass().getAnnotation(CommandInfo.class);
            PlayerType commandRank = commandInfo.rank();
            
            if (commandInfo != null && playerRank.ordinal() >= commandRank.ordinal()) {
                if (playerRank == PlayerType.FREE && (commandRank == PlayerType.BOOSTER || commandRank == PlayerType.PREMIUM || commandRank == PlayerType.ADMIN)) {
                    continue; 
                } else if (playerRank == PlayerType.BOOSTER && (commandRank == PlayerType.PREMIUM || commandRank == PlayerType.ADMIN)) {
                    continue;
                } else if (playerRank == PlayerType.PREMIUM && commandRank == PlayerType.ADMIN) {
                    continue;
                }
                commandList.add(commandInfo);
            }
        }

        int maxPages = (int) Math.ceil((double) commandList.size() / COMMANDS_PER_PAGE);

        if (page < 1 || page > maxPages) {
            p.sendMessage(Settings.PREFIX("Invalid page number."));
            return;
        }

        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&m----------------------------------"));
        p.sendMessage("         " + Settings.DARK_PURPLE + Settings.NAME + " by " + Settings.AUTHOR);
        p.sendMessage("");

        int startIndex = (page - 1) * COMMANDS_PER_PAGE;
        int endIndex = Math.min(startIndex + COMMANDS_PER_PAGE, commandList.size());

        for (int i = startIndex; i < endIndex; i++) {
            CommandInfo commandInfo = commandList.get(i);
            p.sendMessage(Settings.GRAY + commandInfo.name() + Settings.DARK_GRAY + " | " + Settings.WHITE + commandInfo.desc());
        }

        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&m----------------------------------"));
    }
}
