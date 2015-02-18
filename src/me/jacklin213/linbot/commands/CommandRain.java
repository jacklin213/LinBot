package me.jacklin213.linbot.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

public class CommandRain extends LinBotCommand {

	@Override
	void setName(String commandName) {
		this.commandName = commandName;
	}

	@Override
	public void runCmd(CommandSender sender, String cmdName, String[] args) {
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "weather rain");
		plugin.MSG.broadcastMessage("&bI call the clouds, I call the tears, Pour me with your mighty rain");
	}

}
