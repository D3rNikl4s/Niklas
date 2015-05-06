package de.koningjinjin.achievements;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class AchievementEvents implements Listener, CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(sender instanceof Player){
			Player p = (Player)sender;
			if(cmd.getName().equalsIgnoreCase("a")){
				AchievementGui.open(p);
			}
		}
		return false;
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent e){
		if(e.getInventory().getTitle().equalsIgnoreCase("§c§lAchievements")){
			e.setCancelled(true);
		}
	}
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		if(!Achievement.hasAchievement(p, Achievement.FIRST_JOIN)){
			Achievement.giveAchievement(p, Achievement.FIRST_JOIN);
		}
	}
}