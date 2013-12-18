package me.jacklin213.linbot.commands;

import me.jacklin213.linbot.LinBot;

import org.bukkit.command.CommandSender;

public abstract class LinBotCommand {

	String commandName;
	LinBot plugin;
	
	abstract void setName(String commandName);
	
	public abstract void runCmd(CommandSender sender, String cmdName, String args[]);
}
