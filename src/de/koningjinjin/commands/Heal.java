package de.koningjinjin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.koningjinjin.Main.Main;

public class Heal implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(sender instanceof Player){
		Player p = (Player)sender;
		if(cmd.getName().equalsIgnoreCase("heal")){
			if(p.hasPermission("piz.staff")){
				p.setHealth(20.0);
				p.setFoodLevel((int) 20.0);
				p.sendMessage(Main.green + "Du wurdest geheilt!");
			}
		}else{
			p.sendMessage(Main.perm + "Du hast keine Rechte für diesen Befehl!");
		}
			
		}
		return false;
	}
	
	

}
