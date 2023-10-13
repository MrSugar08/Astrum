package org.spigotmc.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.entity.Player;
import org.spigotmc.enums.PlayerType;

public class PlayerManager {
    private static Map<String, ArrayList<String>> playerDataMap = new HashMap<>();

    public PlayerManager() {
        for (PlayerType type : PlayerType.values()) {
            playerDataMap.put(type.name(), new ArrayList<>());
        }
    }

    public static void addPlayer(PlayerType type, String playerName) {
        ArrayList<String> playerList = playerDataMap.get(type.name());
        playerList.add(playerName);
    }
    public static void removePlayer(PlayerType type, String playerName) {
        ArrayList<String> playerList = playerDataMap.get(type.name());
        if (playerList != null) {
            playerList.remove(playerName);
        }
    }

    public static boolean isPlayerInType(PlayerType type, String playerName) {
        ArrayList<String> playerList = playerDataMap.get(type.name());
        return playerList != null && playerList.contains(playerName);
    }

    public static PlayerType getPlayerRank(Player player) {
        if (isPlayerInType(PlayerType.ADMIN, player.getName())) {
            return PlayerType.ADMIN;
        } else if (isPlayerInType(PlayerType.PREMIUM, player.getName())) {
            return PlayerType.PREMIUM;
        } else if (isPlayerInType(PlayerType.BOOSTER, player.getName())) {
            return PlayerType.BOOSTER;
        } else if (isPlayerInType(PlayerType.FREE, player.getName())) {
            return PlayerType.FREE;
        } else {
            return PlayerType.FREE;
        }
    }
}