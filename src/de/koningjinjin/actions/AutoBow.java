package de.koningjinjin.actions;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.koningjinjin.Main.Main;

public class AutoBow implements CommandExecutor, Listener{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		Player p = (Player)sender;
		ItemStack owner3 = new ItemStack(Material.BOW, 1);
		ItemMeta owner3Meta = owner3.getItemMeta();
		owner3Meta.setDisplayName("§a§lSuperbow");
		owner3Meta.addEnchant(Enchantment.ARROW_DAMAGE, 0, true);
		owner3.setItemMeta(owner3Meta);
		if(cmd.getName().equalsIgnoreCase("givebow")){
			if(p.hasPermission("piz.owner") || (p.hasPermission("piz.autobow"))){
				p.getInventory().addItem(new ItemStack(owner3));
				p.sendMessage(Main.green + "Du hast einen Superbow bekommen!");
			}
		}
		return false;
	}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onBow(PlayerInteractEvent e){
		Player p = e.getPlayer();
		if(e.getAction() == Action.RIGHT_CLICK_AIR || (e.getAction() == Action.RIGHT_CLICK_BLOCK)){
			if(p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§a§lSuperbow")){
				e.setCancelled(true);
				p.shootArrow();
			}
			
		}
	}
	

}
