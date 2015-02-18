package me.jacklin213.linbot.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;

public class CommandGod extends LinBotCommand implements Listener {

	@Override
	void setName(String commandName) {
		this.commandName = commandName;
	}

	@Override
	void runCmd(CommandSender sender, String cmdName, String[] args) {
//		Player player = (Player) sender;
//		LinBotCommandEvent event = new LinBotCommandEvent(player, this);
//		plugin.getServer().getPluginManager().callEvent(event);
	}

}
