package me.jacklin213.linbot;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class MSG {
	
	private LinBot plugin;
	
	public String displayName = "&a[Server]&c[LinBot]&f: ";
	
	public MSG(LinBot instance) {
		plugin = instance;
	}
	
	public void broadcastMessage(String... msg) {
		for (String string : msg) {
			plugin.getServer().broadcastMessage(format(displayName) + format(string));
		}
	}
	
	public void broadcastDelayedMessage(final String msg, int seconds) {
		plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
			public void run() {
				plugin.getServer().broadcastMessage(format(displayName) + format(msg));
			}
		}, seconds * 20);
	}
	
	public void commandReply(CommandSender sender, String... msg) {
		for (String string : msg) {
			sender.sendMessage(format(displayName) + format(string));
		}
	}
	
	public String format(String msg) {
		String formated = ChatColor.translateAlternateColorCodes('&', msg);
		return formated;
	}
}
