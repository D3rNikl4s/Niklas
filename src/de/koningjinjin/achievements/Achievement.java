package de.koningjinjin.achievements;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Sound;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public enum Achievement {

	
	//ACHIEVEMENT("Name im Selector" , "Sage", "A", "B", "C"),
	FIRST_JOIN("First Join!", "Join the first time on the server.");

	private Achievement(String name, String... description){
		this.name = name;
		this.description = Arrays.asList(description);
	}
	
	private String name;
	private List<String> description;
	
	private static File file = new File("plugins/Achievements/config.yml");
	private static YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	
	private static String pre = "§7PvPÂ§6Jinjin §7» §e";
	
	public String getName(){
		return name;
	}
	
	public List<String> getDescription(){
		return description;
	}
	
	public static boolean hasAchievement(Player p, Achievement ach){
		return cfg.getBoolean("Achievement." + p.getUniqueId().toString() + "." + ach.getName());
	}
	
	public static void giveAchievement(Player p, Achievement ach) {
		cfg.set("Achievement." + p.getUniqueId().toString() + "." + ach.getName(), true);
		p.sendMessage(pre + "§6§kWER DAS LIEßT IST DUMM!");
		p.sendMessage("");
		p.sendMessage(pre + "§7You got the achievement:");
		p.sendMessage(pre + ach.getName());
		p.sendMessage("");
		p.sendMessage(pre + "§6§kWER DAS LIEßT IST DUMM!");
		p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 10F);
		save();
	}
	
	public static void save(){
		try {
			cfg.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void removeAchievement(Player p, Achievement ach) {
		if(cfg.contains("Achievement." + p.getUniqueId().toString() + "." + ach.getName())){
			cfg.set("Achievement." + p.getUniqueId().toString() + "." + ach.getName(), false);
		}
	}
	
}
