package de.koningjinjin.actions;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import de.koningjinjin.Main.Main;

public class BadWords implements Listener{
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e){
		Player p = e.getPlayer();
		if(e.getMessage().equalsIgnoreCase("Hitler") || (e.getMessage().equalsIgnoreCase("Nazi") 
			|| (e.getMessage().equalsIgnoreCase("Heil")))){
			e.setCancelled(true);
			p.sendMessage(Main.red + "Bitte keine Ausdrücke wie diese!");
		}
	}

}
