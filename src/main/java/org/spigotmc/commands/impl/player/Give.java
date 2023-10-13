package org.spigotmc.commands.impl.player;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.spigotmc.Main;
import org.spigotmc.commands.CommandListener;
import org.spigotmc.commands.annotation.CommandInfo;
import org.spigotmc.utils.Settings;

@CommandInfo(
    name = "give",
    usage = "give <item>",
    desc = "Give yourself the amount of items you want",
    aliases = "gave",
    blatant = false
)

public class Give extends CommandListener{

    @Override
    public void execute(Main plugin, Player p, String[] args) {
        if (args.length <= 1) {
            p.sendMessage(Settings.USAGE(Give.class.getAnnotation(CommandInfo.class).usage()));
        } else {
            Material mat = Material.getMaterial(args[1].toUpperCase()); 
            if (mat == null) {
                p.sendMessage(Settings.PREFIX("The material " + Settings.PURPLE + args[1] + Settings.WHITE +"does not exist"));
            } else {
                try {   
                    int amount = Integer.parseInt(args[1]);
                    p.getInventory().addItem(new ItemStack(mat, amount));
                    p.sendMessage(Settings.PREFIX("Successfully gave you " + Settings.PURPLE + amount + Settings.WHITE + " of " + Settings.PURPLE + mat.name()));
                } catch (Exception ignored) {
                    p.getInventory().addItem(new ItemStack(mat, 1));
                    p.sendMessage(Settings.PREFIX("Successfully gave you " + Settings.PURPLE + "1" + Settings.WHITE + " of a " + Settings.PURPLE + mat.name()));
                }
            }
        }
    }
}
