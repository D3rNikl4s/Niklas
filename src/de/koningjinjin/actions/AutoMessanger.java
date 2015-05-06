package de.koningjinjin.actions;

import java.util.Random;

import org.bukkit.Bukkit;

import de.koningjinjin.Main.Main;

public class AutoMessanger {

	private static void start() {
		Bukkit.getScheduler().runTaskTimer(Main.getInstance(), new Runnable(){

			@Override
			public void run() {
				Random r = new Random();
				int i = r.nextInt(3);
				if(i == 0){
					broadcast("§eDu willst einen Rang kaufen? §a/shop");
				}
				if(i == 1){
					broadcast("§eBei Fragen, kannst du dich gerne an unsere Mods wenden!");
				}
				if(i == 2){
					broadcast("§eWünsche oder Verbesserungsvorschläge? Sag es einem Admin!");
				}
}
			
		}, 1, 5 * 120 * 20);
	}
	
	public static void start(boolean trueorfalse){
		if(trueorfalse = true){
			start();
		}
	}
	
	private static void broadcast(String message){
		Bukkit.broadcastMessage(Main.pre + message);
	}
	
}
