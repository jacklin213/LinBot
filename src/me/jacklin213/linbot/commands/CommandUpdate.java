package me.jacklin213.linbot.commands;

import me.jacklin213.linbot.LinBot;

import org.bukkit.command.CommandSender;
import org.bukkit.plugin.PluginManager;

public class CommandUpdate extends LinBotCommand{

	public CommandUpdate(LinBot instance) {
		plugin = instance;
	}
	
	@Override
	void setName(String commandName) {
		this.commandName = commandName;
	}

	@Override
	public void runCmd(CommandSender sender, String cmdName, String[] args) {
		if (cmdName.equalsIgnoreCase(commandName)){
			final PluginManager pm = plugin.getServer().getPluginManager();
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
				public void run() {
					pm.disablePlugin(plugin);
					pm.enablePlugin(plugin);
					plugin.MSG.broadcastMessage("&aHorray I have been updated!");
				}
			}, 20);
		}
	}
	
	

}
