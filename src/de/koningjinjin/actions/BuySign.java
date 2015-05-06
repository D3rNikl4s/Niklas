package de.koningjinjin.actions;

import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class BuySign implements Listener{
	
	@EventHandler
	public void onClick(PlayerInteractEvent e){
		Player p = e.getPlayer();
		Block b = e.getClickedBlock();
		if(b != null){
			if(b.getState() instanceof Sign){
				Sign sign = (Sign) b.getState();
				if(sign.getLine(0).equalsIgnoreCase("§lKaufbare")){
					p.performCommand("shop");
				}
			}
		}
	}
	@EventHandler
	public void onClick2(PlayerInteractEvent e){
		Player p = e.getPlayer();
		Block b = e.getClickedBlock();
		if(b != null){
			if(b.getState() instanceof Sign){
				Sign sign = (Sign) b.getState();
				if(sign.getLine(0).equalsIgnoreCase("§lKlicke hier")){
					p.performCommand("staff");
				}
			}
		}
	}
				}
