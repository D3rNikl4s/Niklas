package de.koningjinjin.actions;

import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import de.koningjinjin.Main.Main;

public class NoHitWhileFly implements Listener{
	
	@EventHandler
	public void onDamage(EntityDamageByEntityEvent e){
		if(e.getDamager() instanceof Player){
			if(e.getEntity() instanceof Player){
				Player p = (Player) e.getDamager();
				if(p.isFlying() || (p.getGameMode() == GameMode.CREATIVE)){
					e.setCancelled(true);
					p.sendMessage(Main.red + "Du kannst beim fliegen nicht schlagen!");
					p.playSound(p.getLocation(), Sound.ANVIL_LAND, 1000, 1);
				      p.setVelocity(p.getLocation().getDirection().multiply(-0.5D).setY(1.0D));
				}
			}
			}
	}
}
