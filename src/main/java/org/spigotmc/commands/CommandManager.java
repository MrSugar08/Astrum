package org.spigotmc.commands;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.spigotmc.Main;
import org.spigotmc.commands.annotation.CommandInfo;
import org.spigotmc.enums.PlayerType;
import org.spigotmc.manager.PlayerManager;
import org.spigotmc.utils.Settings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandManager implements Listener {
    private final static Map<String, CommandListener> commands = new HashMap<>();
    private static List<CommandListener> loadedCommands = new ArrayList<>();
    private static CommandManager instance;
    private static Main plugin; 

    public CommandManager() {
        instance = this;
        CommandLoader.registerCommand();
        Bukkit.getPluginManager().registerEvents(this, Main.getInstance());
    }   

    public static void loadCommand(CommandListener command) {
        CommandInfo commandInfo = command.getClass().getAnnotation(CommandInfo.class);
        if (commandInfo != null) {
            commands.put(commandInfo.name().toLowerCase(), command);
    
            for (String alias : commandInfo.aliases()) {
                commands.put(alias.toLowerCase(), command);
            }
        }
        loadedCommands.add(command);
    }

    public void executeCommand(Main plugin, Player player, String command, String[] args) {
        CommandListener cmd = commands.get(command.toLowerCase());
        if (cmd == null) {
            player.sendMessage(Settings.PREFIX("Unknown Command. Run " + Settings.PURPLE + "help" + Settings.WHITE + " for a list of commands!"));
            return;
        }

        CommandInfo commandInfo = cmd.getClass().getAnnotation(CommandInfo.class);
        
        if (!PlayerManager.isPlayerInType(PlayerType.BLATANT, player.getName()) && commandInfo.blatant()) {
            player.sendMessage(Settings.PREFIX("This command has been marked as " + Settings.PURPLE + "blatant" + Settings.WHITE));
            player.sendMessage(Settings.USAGE("Enable blatant mode using " + Settings.PURPLE + "blatant"));
            return;
        }

        PlayerType requiredRank = commandInfo.rank();
        PlayerType playerRank = PlayerManager.getPlayerRank(player);

        if (playerRank.ordinal() < requiredRank.ordinal()) {
            player.sendMessage(Settings.PREFIX("You need to be at least " + Settings.PURPLE + requiredRank + Settings.WHITE + " to use this command."));
            return;
        }

        cmd.execute(plugin, player, args);
    }


    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        try {
            final Player player = event.getPlayer();
            String replace = event.getMessage().toLowerCase().contains(" ") ? event.getMessage().toLowerCase().substring(0, event.getMessage().indexOf(" ")) : event.getMessage();
            String[] split = event.getMessage().split(" ");
            String[] args = Arrays.copyOfRange(split, 1, split.length);

            if (PlayerManager.isPlayerInType(PlayerType.FREE, player.getName())) {
                if (event.getMessage().toLowerCase().startsWith("chat")) {
                    if (args.length == 0) {
                        player.sendMessage(Settings.USAGE("chat <message>"));
                        event.setCancelled(true);
                    } else {
                        String message = String.join(" ", args);
                        event.setCancelled(false);
                        event.setMessage(message);
                    }
                } else {
                    event.setCancelled(true);
                    executeCommand(plugin, player, replace, split);
                }
            }
        } catch (Exception ignored) {
            ignored.printStackTrace();
        }
    }

    public static CommandManager getInstance() {
        return instance;
    }

    public static List<CommandListener> getCommands() {
        return loadedCommands;
    }
}