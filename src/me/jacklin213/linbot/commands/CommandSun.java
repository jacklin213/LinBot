package me.jacklin213.linbot.commands;

import me.jacklin213.linbot.LinBot;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

public class CommandSun extends LinBotCommand {

	public CommandSun(LinBot instance) {
		plugin = instance;
	}
	
	@Override
	void setName(String commandName) {
		this.commandName = commandName;
	}

	@Override
	public void runCmd(CommandSender sender, String cmdName, String[] args) {
		if (cmdName.equalsIgnoreCase(commandName)) {
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "weather clear");
			plugin.MSG.broadcastMessage("&6Rain rain go away, come back another day ~~");
		}
	}

}
