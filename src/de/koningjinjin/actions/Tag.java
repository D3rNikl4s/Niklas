package de.koningjinjin.actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import de.koningjinjin.Main.Main;
import ru.tehkode.permissions.PermissionGroup;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class Tag implements CommandExecutor , Listener {

	public static HashMap<Player, PermissionGroup> tagged = new HashMap<Player, PermissionGroup>();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2,String[] args) {
		if(sender instanceof Player){
			Player p = (Player) sender;
			if(p.hasPermission("piz.tag")){
				PermissionUser u = PermissionsEx.getUser(p);
				if(args.length != 0){
					if(!args[0].equalsIgnoreCase("default")){
						PermissionGroup tagp = null;
						for(PermissionGroup groups : PermissionsEx.getPermissionManager().getGroups()){
							if(groups.getName().equalsIgnoreCase(args[0])){
								tagp = PermissionsEx.getPermissionManager().getGroup(args[0]);
							}
						}
						if(tagp != null){
							if(p.hasPermission("piz.tag." + tagp.getName()) || p.hasPermission("piz.tag.*")){
								tag(p, tagp);
								p.sendMessage(Main.green + "Du siehst nun aus wie die Gruppe: " + tagp.getPrefix().replace("&", "§") + p.getName() + "§7!");
								return true;
							}else{
								Main.noPerm(p, cmd.getName());
							}
						}else{
							p.sendMessage(Main.red + "Es gibt keine Gruppe namens: " + args[0] + ".");
						}
					}else{
						List<PermissionGroup> group = new ArrayList<PermissionGroup>();
						group.clear();
						for(PermissionGroup groups : u.getGroups()){
							group.add(groups);
						}
						tag(p, group.get(0));
						p.sendMessage(Main.green + "Du bist nun wieder normal getaggt! §7(" + u.getPrefix().replace("&", "§") + group.get(0).getName() + "§7)");
					}
				}else{
					List<PermissionGroup> group = new ArrayList<PermissionGroup>();
					group.clear();
					for(PermissionGroup groups : PermissionsEx.getPermissionManager().getGroups()){
						group.add(groups);
					}
					List<String> all = new ArrayList<String>();
					for(PermissionGroup grou : group){
						all.add(grou.getName());
					}
					p.sendMessage(Main.orange + "/tag " + all.toString() + "");
				}
			}else{
				Main.noPerm(p, cmd.getName());
			}
		}
		return false;
	}
	
	
	public static void tag(Player p, PermissionGroup group){
		String name = group.getPrefix().replace("&", "§") + p.getName();
		if(name.length() >= 16){
			name = name.substring(0, 16);
		}
		p.setPlayerListName(name);
		tagged.put(p, group);
	}
	
}
