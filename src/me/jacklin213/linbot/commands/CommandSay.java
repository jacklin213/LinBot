package me.jacklin213.linbot.commands;

import me.jacklin213.linbot.LinBot;

import org.bukkit.command.CommandSender;

public class CommandSay extends LinBotCommand{
	
	public CommandSay(LinBot instance) {
		plugin = instance;
	}

	@Override
	void setName(String commandName) {
		this.commandName = commandName;
	}

	@Override
	public void runCmd(CommandSender sender, String cmdName, String[] args) {
		if (cmdName.equalsIgnoreCase(commandName)){
			StringBuilder sb = new StringBuilder();
			for (String s : args){
				if (sb.length() > 0) {
			        sb.append(" ");
			    }
			    sb.append(s);
			}
			plugin.MSG.broadcastMessage(sb.toString());
		}
	}
	
	

}
