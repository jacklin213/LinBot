package me.jacklin213.linbot.commands;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import me.jacklin213.linbot.LinBot;

import org.bukkit.command.CommandSender;

import com.google.common.collect.Sets;

public class CommandH extends LinBotCommand {

	public CommandH(LinBot instance) {
		plugin = instance;
	}
	
	@Override
	void setName(String commandName) {
		this.commandName = commandName;
	}

	@Override
	public void runCmd(CommandSender sender, String cmdName, String[] args) {
		if (cmdName.equalsIgnoreCase(commandName)) {
			if (args.length == 0) 
				plugin.MSG.commandReply(sender, "&cPish incorrect usage. Correct usage: &6!h <path>");
			if (args.length == 1) {
				if (args[0].equalsIgnoreCase("server-name")) {
					plugin.MSG.commandReply(sender, "&cThis is not a valid message to broadcast");
					return;
				}
				if (args[0].equalsIgnoreCase("list")) {
					showHelp(sender);
					return;
				}
				String info = plugin.getConfig().getString(args[0]);
				if (info == null) 
					plugin.MSG.commandReply(sender, "&cThat msg doesnt exist");
				else
					plugin.MSG.broadcastMessage(info);
			}
		}
	}
	
	
	private void showHelp(CommandSender sender) {
		List<String> msg = new ArrayList<String>();
		//TODO: Sort these command list into alphabetical order
		if (sender.hasPermission("linbot.command.admin")) {
			msg.add("&eList of avalible commands:");
			msg.addAll(plugin.commandHandler.getCommandList().keySet());
			String[] toSend = msg.toArray(new String[msg.size()]);
			plugin.MSG.commandReply(sender, toSend);
		} else if (sender.hasPermission("linbot.command.mod") || sender.isOp()) {
			msg.add("&eList of avalible commands:");
			msg.addAll(plugin.commandHandler.getCommandList().keySet());
			msg.remove("reload");
			msg.remove("shutdown");
			msg.remove("update");
			String[] toSend = msg.toArray(new String[msg.size()]);
			plugin.MSG.commandReply(sender, toSend);
		} else {
			plugin.MSG.commandReply(sender,"&cYou do not have the permission to view this");
		}
	}
}
