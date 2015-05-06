package de.koningjinjin.actions;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class ChatManager implements Listener{
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e){
		if(Tag.tagged.containsKey(e.getPlayer())){
			Player p = e.getPlayer();
			String pre = Tag.tagged.get(p).getPrefix();
			pre = pre.replace("&", "§");
			if(e.getPlayer().hasPermission("piz.staff")){
				e.setFormat(pre + e.getPlayer().getName() + " §7» §7§l" + e.getMessage().replace("&", "§"));
			}else{
				e.setFormat(pre + e.getPlayer().getName() + " §7» §7" + e.getMessage());
			}
		}else{
			PermissionUser u = PermissionsEx.getUser(e.getPlayer());
			String pre = u.getPrefix();
			pre = pre.replace("&", "§");
			if(e.getPlayer().hasPermission("piz.staff")){
				e.setFormat(pre + e.getPlayer().getName() + " §7» §7§l" + e.getMessage().replace("&", "§"));
			}else{
				e.setFormat(pre + e.getPlayer().getDisplayName() + " §7» §7" + e.getMessage());
			}
		}
	}
	
}
