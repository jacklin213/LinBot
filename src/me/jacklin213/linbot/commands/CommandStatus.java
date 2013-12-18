package me.jacklin213.linbot.commands;

import me.jacklin213.linbot.LinBot;

import org.bukkit.command.CommandSender;

public class CommandStatus extends LinBotCommand {

	public CommandStatus(LinBot instance){
		plugin = instance;
	}
	
	@Override
	void setName(String commandName) {
		this.commandName = commandName;
	}

	@Override
	public void runCmd(CommandSender sender, String cmdName, String[] args) {
		if (cmdName.equalsIgnoreCase(commandName)){
			boolean online = plugin.getOnline();
			if (online){
				plugin.MSG.broadcastMessage("&6Status: &aOnline");
			} else {
				plugin.MSG.broadcastMessage("&6Status: &cOffline");
			}
		}
	}

}
