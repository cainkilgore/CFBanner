package me.cain.plugin;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.event.Event.Priority;
import org.bukkit.event.Event.Type;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.config.Configuration;

public class CFBanner extends JavaPlugin {
	
	public static Configuration cfg;
	
	public void onEnable()
	{
		System.out.println("[CFBanner] CFBanner has been enabled!");
		Bukkit.getServer().getPluginManager().registerEvent(Type.PLAYER_JOIN, new CFListener(), Priority.Low, this);
		Bukkit.getServer().getPluginManager().registerEvent(Type.PLAYER_LOGIN, new CFListener(), Priority.Normal, this);
		PermissionsClass.setupPerms();
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
	
	public void cfgSetup()
	{
		if(cfg.getProperty("kick.kick-player-if-client-detected") == null)
		{
			cfg.setProperty("kick.kick-player-if-client-detected", false);
		}
		
		if(cfg.getProperty("kick.kickmessage") == null)
		{
			cfg.setProperty("kick.kickmessage", "The admin has blocked Zombe + CJB. Please remove from your client.");
		}
	}

}
