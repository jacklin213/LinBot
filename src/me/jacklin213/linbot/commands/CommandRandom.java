package me.jacklin213.linbot.commands;

import java.util.Random;

import me.jacklin213.linbot.LinBot;

import org.bukkit.command.CommandSender;

public class CommandRandom extends LinBotCommand{

	public CommandRandom(LinBot instance) {
		plugin = instance;
	}
	
	@Override
	void setName(String commandName) {
		this.commandName = commandName;
	}

	@Override
	public void runCmd(CommandSender sender, String cmdName, String[] args) {
		if (cmdName.equalsIgnoreCase(commandName)) {
			if (args.length == 0) {
				Random rand = new Random();
				plugin.MSG.broadcastMessage("&6Random Number: &c" + rand.nextInt());
			} 
			if (args.length == 1) {
				long num = Long.parseLong(args[0]);
				Random rand = new Random(num);
				plugin.MSG.broadcastMessage("&6Random Number Between: &c0-" + num + "&6: &c" + rand.nextInt());
			}
		}
	}
	
	

}
