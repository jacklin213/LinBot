package me.jacklin213.linbot.commands;

import me.jacklin213.linbot.LinBot;

import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

public class CommandUpdate extends LinBotCommand {

	public CommandUpdate(LinBot instance) {
		plugin = instance;
	}
	
	@Override
	void setName(String commandName) {
		this.commandName = commandName;
	}

	@Override
	public void runCmd(final CommandSender sender, String cmdName, String[] args) {
		if (cmdName.equalsIgnoreCase(commandName)) {
			if(args.length == 0) {
				final PluginManager pm = plugin.getServer().getPluginManager();
				plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
					public void run() {
						try {
							plugin.MSG.broadcastMessage("&aUpdate detected! &cNOTE: &6I may crash the server :(");
							pm.disablePlugin(plugin);
							pm.enablePlugin(plugin);
							plugin.MSG.broadcastMessage("&aHorray I have been updated to &cv" + plugin.getDescription().getVersion());
						} catch (NullPointerException e) {
							e.printStackTrace();
							plugin.MSG.commandReply(sender, "&cError while updating &6LinBot");
							plugin.MSG.commandReply(sender, "&cCheck the console for more info");
							plugin.MSG.broadcastMessage("&cSomething went wrong. &6Please fix me &ajacklin213");
						}
					}
				}, 20);
			}
			if (args.length == 1) {
				Plugin target = plugin.getServer().getPluginManager().getPlugin(args[0]);
				if (target != null) {
					try {
						plugin.getServer().getPluginManager().disablePlugin(target);
						plugin.getServer().getPluginManager().enablePlugin(target);
						plugin.MSG.broadcastMessage("&6Plugin: &c" + args[0] + " &6 has been updated to &cv" + target.getDescription().getVersion() + " :D");
					} catch (NullPointerException e) {
						e.printStackTrace();
						plugin.MSG.commandReply(sender, "&cError while updating &6" + args[0]);
						plugin.MSG.commandReply(sender, "&cCheck the console for more info");
						plugin.MSG.broadcastMessage("&cSomething went wrong. &6Please fix me &ajacklin213");
					}
				} else {
					plugin.MSG.commandReply(sender, "&cInvalid plugin");
				}
			}
		}
	}
	
	

}
