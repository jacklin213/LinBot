package me.jacklin213.linbot.commands;

import java.util.Date;

import me.jacklin213.linbot.LinBot;

import org.bukkit.command.CommandSender;

public class CommandDate extends LinBotCommand {
	
	public CommandDate(LinBot instance) {
		this.plugin = instance;
	}
	
	@Override
	void setName(String commandName) {
		this.commandName = commandName;
	}

	@Override
	public void runCmd(CommandSender sender, String cmdName, String[] args) {
		if (cmdName.equalsIgnoreCase(commandName)) {
			if (args.length == 0) {
				Date date = new Date();
				plugin.MSG.broadcastMessage(date.toString());
			}
		}
	}

}
