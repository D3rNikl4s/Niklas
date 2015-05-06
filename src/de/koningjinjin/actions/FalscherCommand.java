package de.koningjinjin.actions;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.help.HelpTopic;

import de.koningjinjin.Main.Main;

public class FalscherCommand implements Listener{

	@EventHandler(priority = EventPriority.NORMAL)
	public void onUnknown(PlayerCommandPreprocessEvent event){
		if(!(event.isCancelled())){
			Player p = event.getPlayer();
			String msg = event.getMessage().split(" ")[0];
			HelpTopic topic = Bukkit.getServer().getHelpMap().getHelpTopic(msg);
			if(topic == null){
				p.sendMessage(Main.red + "Der Befehl §f§l" + msg + " §c§lexistiert nicht!");
				event.setCancelled(true);
			}
		}
	}
	
	@EventHandler
	public void Reload(PlayerCommandPreprocessEvent event){
		Player p = event.getPlayer();
		String command = event.getMessage();
		if(command.equalsIgnoreCase("/rl") || command.equalsIgnoreCase("/reload")){
			if(p.isOp()){
				event.setCancelled(true);
				Bukkit.broadcastMessage(Main.orange + "ACHTUNG: Der Server wird reloaded!");
				Bukkit.reload();
				Bukkit.broadcastMessage(Main.green + "Der Server wurde reloaded!");
			}
		}
				}
}
