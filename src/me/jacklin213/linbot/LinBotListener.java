package me.jacklin213.linbot;

import me.jacklin213.linbot.commands.LinBotCommand;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class LinBotListener implements Listener{
	
	private LinBot plugin;
	
	public LinBotListener(LinBot instance){
		plugin = instance;
	}
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent event){
		final Player player = event.getPlayer();
		if (player.getName().equalsIgnoreCase("jacklin213") || player.hasPermission("linbot.access")){
			String msg = event.getMessage();
			String[] words = msg.split(" ");
			if (words[0].startsWith("!")){
				final String[] args = this.toArgs(words);
				final String cmdName = this.toCmdName(words[0]);
				final LinBotCommand cmd = plugin.commandHandler.matchCommand(cmdName);
				if (this.execptionCheck(cmdName)){
					event.setCancelled(true);
					plugin.MSG.commandReply(player, msg);
				}
				if (plugin.getOnline() == false){
					if (this.offlineCmd(cmdName)){
						Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
							@Override
							public void run() {
								cmd.runCmd(player, cmdName, args);
							}
						}, 10);
						return;
					}
					event.setMessage(msg);
					return;
				}
				if (cmd != null){
					Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
						@Override
						public void run() {
							cmd.runCmd(player, cmdName, args);
						}
					}, 10);
				}
			}
		}
	}
	
	private String[] toArgs(String[] array){
		String[] args = new String[array.length - 1];
		for (int i = 1; i < array.length; i++){
			args[i-1] = array[i];
		}
		return args;
	}
	
	private String toCmdName(String string){
		StringBuilder sb = new StringBuilder(string);
		sb.deleteCharAt(0);
		return sb.toString();
	}
	
	private Boolean execptionCheck(String cmd){
		if (cmd.equalsIgnoreCase("say") || cmd.equalsIgnoreCase("initiate")){
			return true;
		}
		return false;
	}
	
	private Boolean offlineCmd(String cmd){
		if (cmd.equalsIgnoreCase("initiate") || cmd.equalsIgnoreCase("status")){
			return true;
		}
		return false;
	}
}
