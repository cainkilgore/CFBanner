package me.cain.plugin;

import org.bukkit.entity.Player;
import org.bukkit.event.Event.Result;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerLoginEvent;

public class CFListener extends PlayerListener {
	
	public void onPlayerJoin(PlayerJoinEvent e)
	{
		
	String NO_FLY_MESSAGE = "&f &f &1 &0 &2 &4 &3 &9 &2 &0 &0 &1 ";
	String NO_CHEAT_MESSAGE = "&f &f &2 &0 &4 &8 &3 &9 &2 &0 &0 &2 &3 &9 &2 &0 &0 &3 ";

	String CHEAT_MSG = NO_CHEAT_MESSAGE.replaceAll("(&([a-f0-9]))", "\u00A7$2");
	String FLY_MSG = NO_FLY_MESSAGE.replaceAll("(&([a-f0-9]))", "\u00A7$2");
	
		Player p = e.getPlayer();
		
		if(!PermissionsClass.pCheck(p, "cf.allowfly"))
		{
			p.sendMessage(FLY_MSG);
		}
		
		if(!PermissionsClass.pCheck(p, "cf.allowcheat"))
		{
			p.sendMessage(CHEAT_MSG);
		}
		
		return;
		
	}
	
	public void onPlayerLogin(PlayerLoginEvent e)
	{
		if(!PermissionsClass.pCheck(e.getPlayer(), "cf.allowfly") || !PermissionsClass.pCheck(e.getPlayer(), "cf.allowfly"))
		{
			if(CFBanner.cfg.getProperty("kick.kick-player-if-client-detected").equals(true))
			{
				e.getPlayer().kickPlayer(CFBanner.cfg.getProperty("kick.kickmessage").toString());
			}
		}
		return;
	}

}
