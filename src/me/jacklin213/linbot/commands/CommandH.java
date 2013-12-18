package me.jacklin213.linbot.commands;

import me.jacklin213.linbot.LinBot;

import org.bukkit.command.CommandSender;

public class CommandH extends LinBotCommand{

	public CommandH(LinBot instance){
		plugin = instance;
	}
	
	@Override
	void setName(String commandName) {
		this.commandName = commandName;
	}

	@Override
	public void runCmd(CommandSender sender, String cmdName, String[] args) {
		if (cmdName.equalsIgnoreCase(commandName)){
			if (args.length == 0){
				plugin.MSG.commandReply(sender, "&cPish incorrect usage. Correct usage: &6/h <path>");
			}
			if (args.length == 1){
				String info = plugin.getConfig().getString(args[0]);
				if (info == null){
					plugin.MSG.commandReply(sender, "&cThat msg doesnt exist");
				}
				plugin.MSG.broadcastMessage(info);
			}
		}
	}

}
