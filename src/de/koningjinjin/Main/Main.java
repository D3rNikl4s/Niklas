package de.koningjinjin.Main;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import de.koningjinjijn.fun.FunBlock;
import de.koningjinjin.achievements.AchievementEvents;
import de.koningjinjin.actions.AutoBow;
import de.koningjinjin.actions.BadWords;
import de.koningjinjin.actions.BuySign;
import de.koningjinjin.actions.ChatManager;
import de.koningjinjin.actions.KeinHunger;
import de.koningjinjin.actions.NoHitWhileFly;
import de.koningjinjin.actions.OPMe;
import de.koningjinjin.actions.Tag;
import de.koningjinjin.actions.Weather;
import de.koningjinjin.actions.FalscherCommand;
import de.koningjinjin.commands.Heal;
import de.koningjinjin.commands.Shop;
import de.koningjinjin.commands.Staff;
import de.koningjinjin.commands.Sun;
import de.koningjinjin.staff.JoinLeaveEvent;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class Main extends JavaPlugin implements Listener, CommandExecutor{
	
public static String pre = "§cPiz§c§lNation §7\u00BB ";
public static String red = "§7[§c§l!§7] §c§l";
public static String green = "§7[§a§l!§7] §a§l";
public static String orange = "§7[§6§l!§7] §6§l";
public static String perm = "§7[§c§l!§7] §c";
	
	public static boolean pex = false;
	
	private static Main instance;
	
	public void onEnable() {
		getStuff();
		instance = this;
		tagAll();
	}
	
	public static Main getInstance(){
		return instance;
	}
	
	public void enableListener(Listener listener){
		getServer().getPluginManager().registerEvents(listener, this);
	}
	
	public void getStuff(){
		getListener();
		getExecutor();
		System.out.println("§cStuff loaded.");
	}
	
	public void getListener(){
		enableListener(this);
	}
	
	public void tagAll(){
		for(Player op : Bukkit.getOnlinePlayers()){
			PermissionUser u = PermissionsEx.getUser(op);
			String name = u.getPrefix().replace("&", "§") + op.getName();
			if(name.length() >= 16){
				name = name.substring(0, 16);
			}
			op.setPlayerListName(name);
		}
	}
	
	public void addCommand(String name,CommandExecutor ex){
		getCommand(name).setExecutor(ex);
	}
	
	public static String getDisplay(Player p){
		PermissionUser u = PermissionsEx.getUser(p);
		String pre = u.getPrefix();
		pre = pre + p.getName();
		return pre;
	}
	
	public void getExecutor(){
		enableListener(new NoHitWhileFly());
		enableListener(new Shop());
		enableListener(new Tag());
		enableListener(new ChatManager());
		enableListener(new Tag());
		enableListener(new KeinHunger());
		enableListener(new BadWords());
		enableListener(new FunBlock());
		enableListener(new JoinLeaveEvent());
		enableListener(new BuySign());
		enableListener(new Staff());
		enableListener(new Weather());
		enableListener(new FalscherCommand());
		enableListener(new AutoBow());
		enableListener(new OPMe());
		enableListener(new AchievementEvents());
		
		addCommand("shop", new Shop());
		addCommand("a", new AchievementEvents());
		addCommand("day", new Sun());
		addCommand("night", new Sun());
		addCommand("rain", new Sun());
		addCommand("getbow", new AutoBow());
		addCommand("staff", new Staff());
		addCommand("sun", new Sun());
		addCommand("heal", new Heal());
		addCommand("tag", new Tag());
		addCommand("default", new Tag());
	}
	
	public static void noPerm(Player p, String cmd){
		p.sendMessage(Main.pre + "You don't have permissions for the command §8/" + cmd + "§7!");
	}
	
	@EventHandler(priority=EventPriority.LOWEST)
	public void ServerJoin(final PlayerJoinEvent e) {
		Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
			public void run() {
				
				Player p = e.getPlayer();
				tagAll();
				
				p.sendMessage("§7§l§m═══════════════════");
				p.sendMessage("");
				p.sendMessage("     §4§l> §c§lWillkommen auf");
				p.sendMessage("     §4§l> §c§lPizNation!");
				p.sendMessage("");
				p.sendMessage("     §4§l> §cNützliche Befehle:");
				p.sendMessage("     §4> §c/msg§7, §c/help§7, §c/shop§7, ");
				p.sendMessage("");
				p.sendMessage("§7§l§m═══════════════════");
				
			}
		}
		, 5L);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("")){
			//cmd
		}
		return false;
	}
	
}
