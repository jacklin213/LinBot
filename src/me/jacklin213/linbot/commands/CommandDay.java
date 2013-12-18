package me.jacklin213.linbot.commands;

import me.jacklin213.linbot.LinBot;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandDay extends LinBotCommand{

	public CommandDay(LinBot instance){
		plugin = instance;
	}
	
	@Override
	void setName(String commandName) {
		this.commandName = commandName;
	}

	@Override
	public void runCmd(CommandSender sender, String cmdName, String[] args) {
		if (cmdName.equalsIgnoreCase(commandName)){
			if (sender instanceof Player){
				Player player = (Player) sender;
				player.getWorld().setTime(0);
				plugin.MSG.broadcastMessage("&aI call forth the &6Sun God RA");
			}
		}
	}
	
	

}
