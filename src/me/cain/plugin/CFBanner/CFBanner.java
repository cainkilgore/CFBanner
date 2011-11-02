package me.cain.plugin.CFBanner;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.event.Event.Priority;
import org.bukkit.event.Event.Type;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.config.Configuration;

@SuppressWarnings("deprecation")
public class CFBanner extends JavaPlugin {
	
	public static Configuration cfg;
	
	public void onEnable()
	{
		System.out.println("[CFBanner] CFBanner has been enabled!");
		Bukkit.getServer().getPluginManager().registerEvent(Type.PLAYER_JOIN, new CFListener(), Priority.Low, this);
		System.out.println("[CFBanner] " +  this.getDescription().getVersion() + " loaded!");
		cfg = new Configuration(new File(this.getDataFolder(), "config.yml"));
		cfg.load();
		cfgSetup();
		cfg.save();
	}
	
	public void onDisable()
	{
		System.out.println("[CFBanner] Plugin has been disabled!");
	}
	
	/* I don't really get how the kick-player-if-client-detected works. It basically
	 * kicks people without the proper permissions, from the looks of it */
	
	public void cfgSetup()
	{
		if(cfg.getProperty("kick.kick-player-if-client-detected") == null)
		{
			cfg.setProperty("kick.kick-player-if-client-detected", false);
		}
		
		if(cfg.getProperty("kick.kickmessage") == null)
		{
			cfg.setProperty("kick.kickmessage", "This server does not allow client mods. Please remove your mods before joining this server.");
		}
	}

}
