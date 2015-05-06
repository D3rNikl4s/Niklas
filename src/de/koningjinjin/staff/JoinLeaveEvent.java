package de.koningjinjin.staff;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinLeaveEvent implements Listener {

	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		if(p.hasPermission("piz.staff")){
			e.setJoinMessage("");
			for(Player op : Bukkit.getOnlinePlayers()){
				if(op.hasPermission("piz.staff") || op.isOp()){	
					op.sendMessage("§2§l✔ §a§l" + p.getDisplayName() + " §a§list gejoined!");
		}else{
			e.setJoinMessage("");
		}
			}
		}else{
			e.setJoinMessage("");
		}
	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e){
		Player p = e.getPlayer();
		if(p.hasPermission("piz.staff")){
			e.setQuitMessage("");
		}else{
			e.setQuitMessage("");
		}
	}
	
}
