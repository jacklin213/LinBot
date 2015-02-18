package me.jacklin213.linbot.commands;

import me.jacklin213.linbot.LinBot;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandShutdown extends LinBotCommand {

	public CommandShutdown(LinBot instance){
		plugin = instance;
	}
	
	@Override
	void setName(String commandName) {
		this.commandName = commandName;
	}

	@Override
	public void runCmd(CommandSender sender, String cmdName, String args[]) {
		if (cmdName.equalsIgnoreCase(this.commandName)) {
			if (args.length == 0) {
				plugin.MSG.broadcastMessage("&cLogging out & Shutting down");
				plugin.setOnline(false);
			}
			if (args.length == 1) {
				if (args[0].equalsIgnoreCase("cancel")) {
					plugin.getServer().getScheduler().cancelTasks(plugin);
					plugin.MSG.commandReply(sender, "&6Server Shutdown &cCancelled");
				}
				if (args[0].equalsIgnoreCase("server")) {
					plugin.MSG.broadcastMessage("&6Server Shutting down..... We will be back in 5!");
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "save-all");
					Bukkit.getServer().shutdown();
				}
			}
			if (args.length == 2 && args[0].equalsIgnoreCase("server")) {
				int time = Integer.parseInt(args[1]);
				if (time <= 300 && time >= 10) {
					if (time >= 60) {
						this.timedShutdown(time);
						plugin.MSG.broadcastMessage("&6Server Shutting down in &c" + time/60 + " &6minutes");
						plugin.MSG.broadcastMessage("&6Please log off safetly before then !");
						plugin.MSG.broadcastDelayedMessage("&4Be warned You will be kicked then", 30);
					} else {
						this.timedShutdown(time);
						plugin.MSG.broadcastMessage("&6Server Shutting down &c" + time + " &6seconds");
						plugin.MSG.broadcastMessage("&6Please log off safetly before then !");
						plugin.MSG.broadcastDelayedMessage("&4Be warned You will be kicked then", 5);
					}
				} else {
					plugin.MSG.commandReply(sender, "&cTime must be under &6500&cs and above &610&cs");
				}
			}
		}
	}
	
	private void timedShutdown(int seconds) {
		plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
			public void run() {
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "save-all");
				for (Player p : plugin.getServer().getOnlinePlayers()) {
					p.kickPlayer("Server Closed");
					Bukkit.getServer().shutdown();
				}
			}
		}, seconds * 20);
	}

}
