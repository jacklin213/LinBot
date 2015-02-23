package me.jacklin213.linbot.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHeal extends LinBotCommand {

	@Override
	void setName(String commandName) {
		this.commandName = commandName;
	}

	@SuppressWarnings("deprecation")
	@Override
	void runCmd(CommandSender sender, String cmdName, String[] args) {
		if (args.length == 0) {
			Player player = (Player) sender;
			player.setHealth(20);
			plugin.MSG.commandReply(sender, "&eYou have been &aHealed!");
		} 
		if (args.length == 1) {
			Player tarPlayer = Bukkit.getPlayer(args[0]);
			if (tarPlayer != null) tarPlayer.setHealth(20);
			plugin.MSG.commandReply(sender, "&eYou have &aHealed &6 " + tarPlayer.getName());
			plugin.MSG.commandReply(sender, "&eYou have been &aHealed &eby &6" + sender.getName());
		}
	}

}
