package me.cain.plugin.CFBanner;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerListener;

public class CFListener extends PlayerListener {
	
	public static boolean pCheck(Player player, String node)
	{
		return player.hasPermission(node);
	}
	
	public void onPlayerJoin(PlayerJoinEvent e)
	{
		
	String FLY_DISABLER = "&f &f &1 &0 &2 &4 &3 &9 &2 &0 &0 &1 ";
	String CHEAT_DISABLER = "&f &f &2 &0 &4 &8 &3 &9 &2 &0 &0 &2 &3 &9 &2 &0 &0 &3 ";
	
	String FLY_MSG = FLY_DISABLER.replaceAll("(&([a-f0-9]))", "\u00A7$2");
	String CHEAT_MSG = CHEAT_DISABLER.replaceAll("(&([a-f0-9]))", "\u00A7$2");
	
		Player p = e.getPlayer();
		
		if(!p.hasPermission("cf.allowfly"))
		{
			p.sendMessage(FLY_MSG);
		}
		
		if(!p.hasPermission("cf.allowcheat"))
		{
			p.sendMessage(CHEAT_MSG);
		}

		if(!p.hasPermission("cf.allowfly") || !p.hasPermission("cf.allowcheat"))
		{
			if(CFBanner.cfg.getProperty("kick.kick-player-if-client-detected").equals(true))
			{
				e.getPlayer().kickPlayer(CFBanner.cfg.getProperty("kick.kickmessage").toString());
			}
		}
		
		return;
		
	}

}
