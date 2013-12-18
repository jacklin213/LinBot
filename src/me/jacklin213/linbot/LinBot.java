package me.jacklin213.linbot;

import java.io.File;
import java.util.logging.Logger;

import me.jacklin213.linbot.commands.LinBotCommandManager;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class LinBot extends JavaPlugin {

	public LinBot plugin;
	
	public Logger log;
	public LinBotListener LBL = new LinBotListener(this);
	public LinBotCommandManager commandHandler = new LinBotCommandManager(this);
	public MSG MSG = new MSG(this);
	
	private boolean online = false;
	
	@Override
	public void onEnable() {
		this.setLogger();
		this.createConfig();
		getServer().getPluginManager().registerEvents(LBL, this);
	}
	
	@Override
	public void onDisable() {
		this.setOnline(false);
		log.info(String.format("Disabled Version %s", getDescription().getVersion()));
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd,	String commandLabel, String[] args) {
		if (commandLabel.equalsIgnoreCase("linbot") && sender.hasPermission("linbot.access")){
			sender.sendMessage(ChatColor.GOLD + "+=========+" + ChatColor.WHITE + "[ " + ChatColor.GREEN + "LinBot" + ChatColor.WHITE + " ]" + ChatColor.GOLD + "+=========+");
			sender.sendMessage(ChatColor.GOLD + "Name: " + ChatColor.AQUA + "LinBot");
			sender.sendMessage(ChatColor.GOLD + "Version: " + ChatColor.AQUA + "v?");
			sender.sendMessage(ChatColor.GOLD + "Description: " + ChatColor.AQUA + "?");
			sender.sendMessage(ChatColor.GOLD + "Author: " + ChatColor.GREEN + "jacklin213");
		}
		return false;
	}
	
	public void setOnline(boolean toggle){
		if (toggle){
			this.online = true;
		} else {
			this.online = false;
		}
	}
	
	public Boolean getOnline(){
		return this.online;
	}
	
	private void setLogger() {
		log = getLogger();
		log.info(String.format("Enabled Version %s by jacklin213", getDescription().getVersion()));
	}
	
	private void createConfig(){
		File configFile = new File(getDataFolder() + File.separator + "config.yml");
			
		if (!configFile.exists()){
			saveDefaultConfig();
			log.info("Cannot find config.yml, Generating now....");
			log.info("Config generated !");
		}
	}
}
