package me.jacklin213.linbot.commands;

import me.jacklin213.linbot.LinBot;

import org.bukkit.command.CommandSender;

public class CommandWhoAmI extends LinBotCommand{
	
	public CommandWhoAmI(LinBot instance){
		plugin = instance;
	}

	@Override
	void setName(String commandName) {
		this.commandName = commandName;
	}

	@Override
	public void runCmd(CommandSender sender, String cmdName, String[] args) {
		if (cmdName.equalsIgnoreCase(commandName)){
			plugin.MSG.broadcastMessage("&6 I am a bot created by &aJacklin213&6, I can do a lot of things but that is classified");
		}
	}

}
