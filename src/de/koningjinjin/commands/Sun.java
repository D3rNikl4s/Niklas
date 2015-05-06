package de.koningjinjin.commands;

import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.koningjinjin.Main.Main;

public class Sun implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player){
		Player p = (Player)sender;
		World w = p.getWorld();
		if(cmd.getName().equalsIgnoreCase("sun")){
			if(p.hasPermission("piz.staff")){
				w.setThundering(false);
				w.setStorm(false);
				p.sendMessage(Main.green + "In der Welt: §c" + w.getName() + "§a§l scheint nun die Sonne!");
			}
		}else if(cmd.getName().equalsIgnoreCase("night")){
			if(p.hasPermission("piz.staff")){
				w.setTime(22500);
				p.sendMessage(Main.green + "In der Welt: §c" + w.getName() + "§a§l ist nun Nacht!");
			}
		}else if(cmd.getName().equalsIgnoreCase("rain")){
			if(p.hasPermission("piz.staff")){
			w.setThundering(false);
			w.setStorm(true);
			p.sendMessage(Main.green + "In der Welt: §c" + w.getName() + "§a§l regnet es nun!");
			}
		}else if(cmd.getName().equalsIgnoreCase("day")){
			if(p.hasPermission("piz.staff")){
				w.setTime(2000);
				p.sendMessage(Main.green + "In der Welt: §c" + w.getName() + "§a§l ist nun Tag!");
			}
		}
		}
		return false;
	}
}
