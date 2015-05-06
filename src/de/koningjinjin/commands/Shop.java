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

public class Shop implements CommandExecutor, Listener{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(sender instanceof Player){
		Player p = (Player)sender;
		Inventory inv = Bukkit.createInventory(null, 45, "§c§lKaufbare Ränge:");
		
		ItemStack iron = new ItemStack(Material.GOLD_INGOT, 1);
		ItemMeta ironMeta = iron.getItemMeta();
		ironMeta.setDisplayName("§6§lGold-Rang §7§l[§65 Euro§7§l]");
		ArrayList<String> lore1 = new ArrayList<String>();
		lore1.add("");
		lore1.add("§6§lDauer:");
		lore1.add("§61 Monat");
		lore1.add("");
		lore1.add("§6§lVorteile:");
		lore1.add("§6+ /fly Rechte");
		lore1.add("§6+ Farbiges Schreiben");
		lore1.add("§6+ Betrete den Server, wenn");
		lore1.add("§6  er voll ist");
		lore1.add("§6+ Oranger Nametag");
		lore1.add("§6+ Du hilfst mit, den Server");
		lore1.add("§6  am Leben zu halten! §c❤");
		ironMeta.setLore(lore1);
		iron.setItemMeta(ironMeta);
		
		ItemStack dia = new ItemStack(Material.DIAMOND, 1);
		ItemMeta diaMeta = dia.getItemMeta();
		diaMeta.setDisplayName("§b§lDiamant-Rang §7§l[§b10 Euro§7§l]");
		ArrayList<String> lore2 = new ArrayList<String>();
		lore2.add("");
		lore2.add("§b§lDauer:");
		lore2.add("§b3 Monate");
		lore2.add("");
		lore2.add("§b§lVorteile:");
		lore2.add("§b+ /fly Rechte");
		lore2.add("§b+ Farbiges Schreiben");
		lore2.add("§b+ Betrete den Server, wenn");
		lore2.add("§b  er voll ist");
		lore2.add("§b+ Blauer Nametag");
		lore2.add("§b+ Du hilfst mit, den Server");
		lore2.add("§b  am Leben zu halten! §c❤");
		diaMeta.setLore(lore2);
		dia.setItemMeta(diaMeta);
		
		ItemStack em = new ItemStack(Material.EMERALD, 1);
		ItemMeta emMeta = em.getItemMeta();
		emMeta.setDisplayName("§a§lSmaragt-Rang §7§l[§a15 Euro§7§l]");
		ArrayList<String> lore3 = new ArrayList<String>();
		lore3.add("");
		lore3.add("§a§lDauer:");
		lore3.add("§aLebenslang");
		lore3.add("");
		lore3.add("§a§lVorteile:");
		lore3.add("§a+ /fly Rechte");
		lore3.add("§a+ Farbiges Schreiben");
		lore3.add("§a+ Betrete den Server, wenn");
		lore3.add("§a  er voll ist");
		lore3.add("§a+ Grüner Nametag");
		lore3.add("§a+ Du hilfst mit, den Server");
		lore3.add("§a  am Leben zu halten! §c❤");
		emMeta.setLore(lore3);
		em.setItemMeta(emMeta);
		
		ItemStack buy = new ItemStack(Material.BLAZE_POWDER, 1);
		ItemMeta buyMeta = buy.getItemMeta();
		buyMeta.setDisplayName("§c§lDu willst einen Rang kaufen?");
		ArrayList<String> buy1 = new ArrayList<String>();
		buy1.add("");
		buy1.add("§cWenn du einen der hier");
		buy1.add("§caufgelisteten Ränge kaufen");
		buy1.add("§cmöchtest, wende dich an einen");
		buy1.add("§cAdmin oder Owner (roter Name).");
		buyMeta.setLore(buy1);
		buy.setItemMeta(buyMeta);
		
		if(cmd.getName().equalsIgnoreCase("shop")){
			inv.setItem(10, iron);
			inv.setItem(13, dia);
			inv.setItem(16, em);
			inv.setItem(31, buy);
			p.openInventory(inv);
			}
		}
		return false;
}
	@EventHandler
	public void onClick(InventoryClickEvent e){
		if(e.getInventory().getName().equalsIgnoreCase("§c§lKaufbare Ränge:")){
			e.setCancelled(true);
		}
	}
}
