package me.jacklin213.linbot.commands;

import java.util.HashMap;

import me.jacklin213.linbot.LinBot;

public class LinBotCommandManager {
	
	private LinBot plugin;
	
	private CommandDate cmdDate;
	private CommandDay cmdDay;
	private CommandInitiate cmdIntiate;
	private CommandH cmdH;
	private CommandReload cmdReload;
	private CommandSay cmdSay;
	private CommandStatus cmdStatus;
	private CommandSun cmdSun;
	private CommandWhoAmI cmdWhoAmI;
	private CommandUpdate cmdUpdate;
	
	private HashMap<String, LinBotCommand> commandList = new HashMap<String, LinBotCommand>();
	
	public LinBotCommandManager(LinBot instance){
		plugin = instance;
		this.registerCmds();
	}
	
	public LinBotCommand matchCommand(String cmdName){
		if (commandList.containsKey(cmdName)){
			return (LinBotCommand)commandList.get(cmdName);
		}
		return null;
	}
	
	private void registerCmds(){
		cmdDay = new CommandDay(plugin);
		cmdDate = new CommandDate(plugin);	
		cmdIntiate = new CommandInitiate(plugin);
		cmdH = new CommandH(plugin);
		cmdReload = new CommandReload(plugin);	
		cmdSay = new CommandSay(plugin);
		cmdStatus = new CommandStatus(plugin);
		cmdSun = new CommandSun(plugin);
		cmdWhoAmI = new CommandWhoAmI(plugin);
		cmdUpdate = new CommandUpdate(plugin);
		
		cmdDay.setName("day");
		cmdDate.setName("date");
		cmdIntiate.setName("initiate");
		cmdH.setName("h");
		cmdReload.setName("reload");
		cmdSay.setName("say");
		cmdStatus.setName("status");
		cmdSun.setName("sun");
		cmdWhoAmI.setName("whoami");
		cmdUpdate.setName("update");
		
		commandList.put("day", cmdDay);
		commandList.put("date", cmdDate);
		commandList.put("initiate", cmdIntiate);
		commandList.put("h", cmdH);
		commandList.put("reload", cmdReload);
		commandList.put("say", cmdSay);
		commandList.put("status", cmdStatus);
		commandList.put("sun", cmdSun);
		commandList.put("whoami", cmdWhoAmI);
		commandList.put("update", cmdUpdate);
	}
}
