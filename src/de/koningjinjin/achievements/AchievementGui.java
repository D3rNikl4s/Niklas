package de.koningjinjin.achievements;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class AchievementGui implements Listener{

	public static void open(Player p){
		Inventory gui = Bukkit.createInventory(null, 5 * 9, "§c§lAchievements");
		
		frame(gui, 0, 9, new ItemStack(Material.THIN_GLASS));
		
		addIcons(gui, p);
		
		frame(gui, 36, 45, new ItemStack(Material.THIN_GLASS));
		
		p.openInventory(gui);
	}

	private static void addIcons(Inventory gui, Player p) {
		for(Achievement ach : Achievement.values()){
			ItemStack item = new ItemStack(Material.INK_SACK);
			ItemMeta achmeta = item.getItemMeta();
			List<String> desc = ach.getDescription();
			List<String> list = new ArrayList<String>();
			String name = ach.getName();
			if(Achievement.hasAchievement(p, ach)){
				item.setDurability((short) 10);
				achmeta.setDisplayName("§a" + name);
			}else{
				item.setDurability((short) 8);
				achmeta.setDisplayName("§c" + name);
			}
			for(String strg : desc){
				list.add("§7" + strg);
			}
			achmeta.setLore(list);
			item.setItemMeta(achmeta);
			gui.addItem(item.clone());
		}
	}

	private static void frame(Inventory gui, int from, int to, ItemStack itemStack) {
		for(int i = from; i < to; i++){
			gui.setItem(i, itemStack);
		}
	}
	
}
