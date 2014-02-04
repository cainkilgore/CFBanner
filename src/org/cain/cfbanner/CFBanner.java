package org.cain.cfbanner;

import org.bukkit.plugin.java.JavaPlugin;
import org.cain.cfbanner.listeners.playerListener;

public class CFBanner extends JavaPlugin {
	
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new playerListener(), this);
		System.out.println("[CFBanner] CFBanner has been enabled!");
	}
	
	@Override
	public void onDisable() {
		System.out.println("[CFBanner] CFBanner has been disabled!");
	}

}
