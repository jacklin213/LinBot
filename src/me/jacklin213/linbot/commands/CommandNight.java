package me.jacklin213.linbot.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandNight extends LinBotCommand {

	@Override
	void setName(String commandName) {
		this.commandName = commandName;
	}

	@Override
	void runCmd(CommandSender sender, String cmdName, String[] args) {
		if (sender instanceof Player) { //linbot commands only work if its player?
			Player player = (Player) sender;
			player.getWorld().setTime(18000);
			plugin.MSG.broadcastMessage("&aShine your billiance &bLunar Queen");
		} 
		//TODO: Different worlds
//		else {
//			plugin.getServer().getWorld("world").setTime(18000);
//			plugin.MSG.broadcastMessage("&aShine your billiance &bLunar Queen");
//		}
	}

}
