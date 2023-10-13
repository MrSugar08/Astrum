package org.spigotmc.commands.impl.plugin;

import org.spigotmc.manager.DataManager;
import org.spigotmc.manager.PlayerManager;
import org.spigotmc.Main;
import org.spigotmc.enums.PlayerType;
import org.spigotmc.methods.API;
import org.spigotmc.utils.Settings;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.io.IOException;

public class Login implements Listener {

    public Login() {
        Bukkit.getPluginManager().registerEvents(this, Main.getInstance());
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        String[] split = event.getMessage().split(" ");
        String[] args = Arrays.copyOfRange(split, 1, split.length);

        if (event.getMessage().startsWith("./login")) {
            try {
                String response = API.getRank(player.getName());
                if (response.contains("\"rank\":\"unregistered\"")) {
                    event.setCancelled(false);
                } else {
                    event.setCancelled(true);
                    boolean hasPass = DataManager.getData().getBoolean("hasPass");
                    boolean hasArgs = args.length > 0;

                    if (hasPass && !hasArgs) {
                        player.sendMessage(Settings.PREFIX("This server has a password. Login with ./login <password>"));
                        return;
                    }

                    if (response.contains("\"rank\":\"free\"")) {
                        PlayerManager.addPlayer(PlayerType.FREE, player.getName());
                        player.sendMessage(Settings.PREFIX("Logged in as " + Settings.PURPLE + "FREE " + Settings.WHITE + "rank"));
                    } else if (response.contains("\"rank\":\"booster\"")) {
                        PlayerManager.addPlayer(PlayerType.FREE, player.getName());
                        PlayerManager.addPlayer(PlayerType.BOOSTER, player.getName());
                        player.sendMessage(Settings.PREFIX("Logged in as " + Settings.PURPLE + "BOOSTER " + Settings.WHITE + "rank"));
                    } else if (response.contains("\"rank\":\"premium\"")) {
                        PlayerManager.addPlayer(PlayerType.FREE, player.getName());
                        PlayerManager.addPlayer(PlayerType.BOOSTER, player.getName());
                        PlayerManager.addPlayer(PlayerType.PREMIUM, player.getName());
                        player.sendMessage(Settings.PREFIX("Logged in as " + Settings.PURPLE + "PREMIUM " + Settings.WHITE + "rank"));
                    } else if (response.contains("\"rank\":\"admin\"")) {
                        PlayerManager.addPlayer(PlayerType.FREE, player.getName());
                        PlayerManager.addPlayer(PlayerType.BOOSTER, player.getName());
                        PlayerManager.addPlayer(PlayerType.PREMIUM, player.getName());
                        PlayerManager.addPlayer(PlayerType.ADMIN, player.getName());
                        player.sendMessage(Settings.PREFIX("Logged in as " + Settings.PURPLE + "ADMIN " + Settings.WHITE + "rank"));
                    } else if (response.contains("\"rank\":\"suspended\"")) {
                        player.sendMessage(Settings.PREFIX("Your account has been suspended"));
                    } else {
                        player.sendMessage(Settings.PREFIX("Invalid password"));
                    }       
                }
            } catch (IOException e) {
                player.sendMessage(Settings.PREFIX("An error occurred while logging in"));
            }
        }
    }
}