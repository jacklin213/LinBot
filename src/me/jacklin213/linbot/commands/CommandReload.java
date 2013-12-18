package me.jacklin213.linbot.commands;

import me.jacklin213.linbot.LinBot;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandReload extends LinBotCommand {
	
	public CommandReload(LinBot instance){
		plugin = instance;
	}
	
	@Override
	void setName(String commandName) {
		this.commandName = commandName;
	}

	@Override
	public void runCmd(CommandSender sender, String cmdName, String args[]) {
		if (cmdName.equalsIgnoreCase(this.commandName)){
			if (args.length == 0){
				plugin.MSG.broadcastMessage("&aServer Reloading..... Please stand still!");
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "save-all");
				Bukkit.getServer().reload();
				plugin.MSG.broadcastMessage("&aReload Complete :D");
			}
			if (args.length == 1){
				if (args[0].equalsIgnoreCase("cancel")){
					plugin.getServer().getScheduler().cancelTasks(plugin);
					plugin.MSG.commandReply(sender, "&6 Current tasks Cancelled");
				} else if (args[0].equalsIgnoreCase("config")){
					plugin.reloadConfig();
					plugin.MSG.broadcastMessage("&aMy configuration has been reloaded");
				} else {
					int time = Integer.parseInt(args[0]);
					if (time <= 300 && time >= 30){
						if (time >= 60){
							this.timedReload(time);
							plugin.MSG.broadcastMessage("&6Server Reloading in &c" + time/60 + " &6minutes");
							plugin.MSG.broadcastMessage("&6Please log off safetly before then !");
							plugin.MSG.broadcastDelayedMessage("&4Be warned You will be kicked then", 30);
						} else {
							this.timedReload(time);
							plugin.MSG.broadcastMessage("&6Server Reloading in &c" + time + " &6seconds");
							plugin.MSG.broadcastMessage("&6Please log off safetly before then !");
							plugin.MSG.broadcastDelayedMessage("&4Be warned You will be kicked then", 10);
						}
					} else {
						plugin.MSG.commandReply(sender, "&cTime must be under &6500&cs and above &630&cs");
					}
				}
			}
		}
	}
	
	private void timedReload(int seconds){
		plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
			public void run() {
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "save-all");
				for (Player p : plugin.getServer().getOnlinePlayers()){
					p.kickPlayer("Server reloading...");
					Bukkit.getServer().reload();
				}
			}
		}, seconds * 20);
	}
	

}
