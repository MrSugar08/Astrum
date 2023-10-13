package org.spigotmc.commands.impl.griefing;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.spigotmc.Main;
import org.spigotmc.commands.CommandListener;
import org.spigotmc.commands.annotation.CommandInfo;
import org.spigotmc.utils.Settings;

@CommandInfo (
    name = "bomb",
    desc = "Gives yourself a bomb",
    usage = "bomb",
    aliases = "bombs",
    blatant = true
)
public class Bomb extends CommandListener{

    @Override
    public void execute(Main plugin, Player p, String[] args) {
        ItemStack stack = new ItemStack(Material.TNT);
        ItemMeta meta = stack.getItemMeta();
        meta.setDisplayName("§c§kX§d Bomb §c§kX");
        stack.setItemMeta(meta);

        p.getInventory().addItem(stack);
        p.sendMessage(Settings.PREFIX("You have successfully picked up a bomb!"));
    }
}
