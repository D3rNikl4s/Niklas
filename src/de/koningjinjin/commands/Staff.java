package de.koningjinjin.commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Staff implements CommandExecutor, Listener{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(sender instanceof Player){
			Player p = (Player)sender;
			Inventory staffgen = Bukkit.createInventory(null, 27, "§c§lKlicke auf einen Rang:");
			
			ItemStack owner = new ItemStack(Material.DIAMOND_HELMET, 1);
			ItemMeta ownerMeta = owner.getItemMeta();
			ownerMeta.setDisplayName("§4§lOwner");
			ArrayList<String> owner1 = new ArrayList<String>();
			owner1.add("§7§oClicke hier um");
			owner1.add("§7§oalle Owner zu sehen.");
			ownerMeta.setLore(owner1);
			owner.setItemMeta(ownerMeta);
			
			ItemStack owner2 = new ItemStack(Material.GOLD_HELMET, 1);
			ItemMeta owner2Meta = owner2.getItemMeta();
			owner2Meta.setDisplayName("§4§lAdmins");
			ArrayList<String> owner12 = new ArrayList<String>();
			owner12.add("§7§oClicke hier um");
			owner12.add("§7§oalle Admins zu sehen.");
			owner2Meta.setLore(owner12);
			owner2.setItemMeta(owner2Meta);
			
			ItemStack owner3 = new ItemStack(Material.IRON_HELMET, 1);
			ItemMeta owner3Meta = owner3.getItemMeta();
			owner3Meta.setDisplayName("§c§lMods");
			ArrayList<String> owner13 = new ArrayList<String>();
			owner13.add("§7§oClicke hier um");
			owner13.add("§7§oalle Mods zu sehen.");
			owner3Meta.setLore(owner13);
			owner3.setItemMeta(owner3Meta);
			
			ItemStack owner34 = new ItemStack(Material.CHAINMAIL_HELMET, 1);
			ItemMeta owner34Meta = owner34.getItemMeta();
			owner34Meta.setDisplayName("§5§lSupporter");
			ArrayList<String> owner134 = new ArrayList<String>();
			owner134.add("§7§oClicke hier um");
			owner134.add("§7§oalle Supporter zu sehen.");
			owner34Meta.setLore(owner134);
			owner34.setItemMeta(owner34Meta);
			
			if(cmd.getName().equalsIgnoreCase("staff")){
				staffgen.setItem(11, owner);
				staffgen.setItem(12, owner2);
				staffgen.setItem(13, owner3);
				staffgen.setItem(14, owner34);
				p.openInventory(staffgen);
				
			}
		}
		return false;
	}
		@EventHandler
		public void onClick(InventoryClickEvent e){
			if(e.getInventory().getName().equalsIgnoreCase("§c§lKlicke auf einen Rang:")
			|| (e.getInventory().getName().equalsIgnoreCase("§c§lOwner")
					|| (e.getInventory().getName().equalsIgnoreCase("§4KoningJinjin")))){
				e.setCancelled(true);
	}
	}
		@EventHandler
		public void onClickOwner(InventoryClickEvent e){
			Player p = (Player) e.getWhoClicked();
			Inventory ownerinv = Bukkit.createInventory(null, 27, "§c§lOwner");
			
			ItemStack koningjinjin = new ItemStack(Material.DIAMOND_HELMET, 1);
			ItemMeta koningjinjinMeta = koningjinjin.getItemMeta();
			koningjinjinMeta.setDisplayName("§4KoningJinjin");
			ArrayList<String> koningjinjin1 = new ArrayList<String>();
			koningjinjin1.add("§7§oOwner und Coder");
			koningjinjinMeta.setLore(koningjinjin1);
			koningjinjin.setItemMeta(koningjinjinMeta);
			if(e.getInventory().getName().equalsIgnoreCase("§c§lKlicke auf einen Rang:")){
				if(e.getCurrentItem().getType() == Material.DIAMOND_HELMET){
					ownerinv.setItem(12, koningjinjin);
					p.openInventory(ownerinv);
				}
			}
		}
}
