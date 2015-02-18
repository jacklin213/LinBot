package me.jacklin213.linbot.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandKill extends LinBotCommand {

	@Override
	void setName(String commandName) {
		this.commandName = commandName;
	}

	@SuppressWarnings("deprecation")
	@Override
	void runCmd(CommandSender sender, String cmdName, String[] args) {
		if (args.length == 0) {
			Player player = (Player) sender;
			player.setHealth(0);
			plugin.MSG.broadcastMessage("&eYour death wish has been granted &6" + player.getName());
		}
		if (args.length == 1) {
			Player tarPlayer = Bukkit.getPlayer(args[0]);
			if (tarPlayer != null) {
				tarPlayer.setHealth(0);
				plugin.MSG.broadcastMessage("&eSomeone told me to kill you &6" + tarPlayer.getName());
				plugin.MSG.broadcastMessage("&aSorry :)");
			}
		}
	}

}
