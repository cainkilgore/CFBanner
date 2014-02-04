package org.cain.cfbanner.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class playerListener implements Listener {
	
	String ZOMBE_FLY = "§f §f §1 §0 §2 §4";
	String ZOMBE_CHEAT = "§f §f §2 §0 §4 §8";
	String ZOMBE_NOCLIP = "§f §f §4 §0 §9 §6";
	String REI_MINIMAP = "§0 §0 §1 §2 §3 §4 §5 §6 §7 §e §f";
	
	@EventHandler(priority = EventPriority.HIGH)
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
		if(p.hasPermission("cfbanner.rei.minimap")) {
			p.sendMessage(REI_MINIMAP);
		}
		return;
	}

}