package me.jacklin213.linbot.commands;

import org.bukkit.command.CommandSender;

public class CommandSleep extends LinBotCommand {

	@Override
	void setName(String commandName) {
		this.commandName = commandName;
	}

	@Override
	void runCmd(CommandSender sender, String cmdName, String[] args) {
		if (plugin.isSleep()) {
			plugin.setSleep(false);
			plugin.MSG.broadcastMessage("&eI have awaken from my slumber");
		} else {
			plugin.setSleep(true);
			plugin.MSG.broadcastMessage("&eSystem is now tired, Sleepmode: &aON");
		}
	}

}
