package org.cain.cfbanner;

import org.bukkit.event.Event.Priority;
import org.bukkit.event.Event.Type;
import org.bukkit.plugin.java.JavaPlugin;
import org.cain.cfbanner.listeners.playerListener;

public class CFBanner extends JavaPlugin {
	
	public void onEnable() {
		registerEvents();
		System.out.println("[CFBanner] CFBanner has been enabled!");
	}
	
	public void onDisable() {
		System.out.println("[CFBanner] CFBanner has been disabled!");
	}
	
	public void registerEvents() {
		getServer().getPluginManager().registerEvent(Type.PLAYER_LOGIN, new playerListener(), Priority.Normal, this);
	}

}
