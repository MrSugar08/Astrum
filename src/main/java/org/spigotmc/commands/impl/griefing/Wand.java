package org.spigotmc.commands.impl.griefing;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.spigotmc.Main;
import org.spigotmc.commands.CommandListener;
import org.spigotmc.commands.annotation.CommandInfo;
import org.spigotmc.utils.Settings;

@CommandInfo (
    name = "wand",
    usage = "wand <block> <radius>",
    desc = "Use the griefing wands",
    aliases = "wands",
    blatant = false
)
public class Wand extends CommandListener {

    private Material wandMaterial;
    private int wandRadius;

    @Override
    public void execute(Main plugin, Player p, String[] args) {
        if (args.length <= 2) {
            p.sendMessage(Settings.USAGE(Wand.class.getAnnotation(CommandInfo.class).usage()));
            return;
        }
        if (args.length == 3) {
            try {
                wandMaterial = Material.valueOf(args[1].toUpperCase());
            } catch (IllegalArgumentException e) {
                p.sendMessage(Settings.PREFIX("The block " + Settings.PURPLE + args[1] + Settings.WHITE + " was not found!"));
                return;
            }
            try {
                wandRadius = Integer.parseInt(args[2]);
            } catch(NumberFormatException ex) {
                p.sendMessage(Settings.PREFIX("The radius has to be a number"));
				return;
            }
            ItemStack wandItem = new ItemStack(Material.DIAMOND_AXE, 1);
			ItemMeta wandMeta = wandItem.getItemMeta();
			p.sendMessage(Settings.PREFIX("You received a "  +Settings.PURPLE + wandMaterial.toString() + Settings.WHITE + " wand"));
			wandMeta.setDisplayName(Settings.WHITE+Settings.NAME + " wand: " + Settings.PURPLE + wandMaterial.toString());
			
			ArrayList<String> lore = new ArrayList<>();
			lore.add(Settings.WHITE + "Radius: " + Settings.PURPLE + wandRadius);
			wandMeta.setLore(lore);
			
			wandItem.setItemMeta(wandMeta);
			p.getInventory().addItem(wandItem);
        }    
    }
}
