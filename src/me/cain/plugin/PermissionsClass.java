package me.cain.plugin;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import com.nijiko.permissions.PermissionHandler;
import com.nijikokun.bukkit.Permissions.Permissions;

public class PermissionsClass {

	public static PermissionHandler permissionHandler;
	
	public static void setupPerms() {
	if (permissionHandler != null) {
		return;
	}
	
	Plugin permissionsPlugin = Bukkit.getServer().getPluginManager().getPlugin("Permissions");
	if (permissionsPlugin == null) {
		System.out.println("[CFBanner] Permissions not detected. Going to Bukkit Permissions!");
		return;
	}
	permissionHandler = ((Permissions) permissionsPlugin).getHandler();
	System.out.println("[CFBanner] Permissions found. Using " + ((Permissions)permissionsPlugin).getDescription().getFullName());
	}
	
	public static boolean pCheck(Player player, String node)
	{
		if(permissionHandler != null)
		{
			return permissionHandler.has(player,  node);
		}
		else
		{
			player.hasPermission(node);
		}
		return false;
	}
	
	
}
