package me.jacklin213.linbot.commands;

import me.jacklin213.linbot.LinBot;

import org.bukkit.command.CommandSender;

public class CommandInitiate extends LinBotCommand{

	public CommandInitiate(LinBot instance) {
		plugin = instance;
	}
	
	@Override
	void setName(String commandName) {
		this.commandName = commandName;
	}

	@Override
	public void runCmd(CommandSender sender, String cmdName, String[] args) {
		if (cmdName.equalsIgnoreCase(commandName)){
			plugin.MSG.broadcastMessage("&aInitiating......");
			plugin.setOnline(true);
		}
	}
	
	

}
