package org.cain.cfbanner.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerLoginEvent;

public class playerListener extends PlayerListener {
	
	String ZOMBE_FLY = "§f §f §1 §0 §2 §4";
	String ZOMBE_CHEAT = "§f §f §2 §0 §4 §8";
	String ZOMBE_NOCLIP = "§f §f §4 §0 §9 §6";
	
	public void onPlayerLogin(PlayerLoginEvent e) {
		Player p = e.getPlayer();
		if(!p.hasPermission("cfbanner.zombe.fly")) {
			p.sendMessage(ZOMBE_FLY);
		}
		if(!p.hasPermission("cfbanner.zombe.cheat")) {
			p.sendMessage(ZOMBE_CHEAT);
		}
		if(!p.hasPermission("cfbanner.zombe.noclip")) {
			p.sendMessage(ZOMBE_NOCLIP);
		}
		return;
	}

}
