package me.jacklin213.linbot.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandFly extends LinBotCommand {

	@Override
	void setName(String commandName) {
		this.commandName = commandName;
	}

	@SuppressWarnings("deprecation")
	@Override
	void runCmd(CommandSender sender, String cmdName, String[] args) {
		if (args.length == 0) {
			Player player = (Player) sender;
			if (player.isFlying()) {
				player.setFlying(false);
			} else {
				player.setFlying(true);
				player.setFlySpeed(0.1F);
			}
		}
		if (args.length == 1) {
			Player tarPlayer = Bukkit.getPlayer(args[0]);
			if (tarPlayer != null) {
				if (tarPlayer.isFlying()) {
					tarPlayer.setFlying(false);
				} else {
					tarPlayer.setFlying(true);
					tarPlayer.setFlySpeed(0.1F);
				}
			}
		}
	}

}
