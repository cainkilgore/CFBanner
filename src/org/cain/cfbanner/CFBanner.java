package org.cain.cfbanner;

import org.bukkit.plugin.java.JavaPlugin;
import org.cain.cfbanner.listeners.playerListener;

public class CFBanner extends JavaPlugin {
	
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new playerListener(), this);
	}
	
	public void onDisable() {
		// Enabled/Disabled messages are not necessary.
	}

}
