package de.koningjinjijn.fun;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import de.koningjinjin.api.ParticleEffect;

public class FunBlock implements Listener{
	
	@EventHandler
	public void onClick(PlayerInteractEvent e){
		Player p = e.getPlayer();
		if(e.getClickedBlock().getType() == Material.ENDER_PORTAL_FRAME){
			if(e.getAction() == Action.RIGHT_CLICK_BLOCK){
				if(p.getItemInHand().getType() == Material.PAPER){
					ParticleEffect.LAVA.display(p.getLocation(), 1, 1, 1, 1, 120);
					p.sendMessage("test");
				}
			}
		}
	}

}
