package me.jacklin213.linbot.commands;

import java.util.HashMap;

import me.jacklin213.linbot.LinBot;

public class LinBotCommandManager {
	
	private LinBot plugin;
	
	private CommandDate cmdDate;
	private CommandDay cmdDay;
	private CommandFly cmdFly;
	private CommandGod cmdGod;
	private CommandH cmdH;
	private CommandHeal cmdHeal;
	private CommandInitiate cmdIntiate;
	private CommandKill cmdKill;
	private CommandNight cmdNight;
	private CommandRain cmdRain;
	private CommandRandom cmdRandom;
	private CommandReload cmdReload;
	private CommandSay cmdSay;
	private CommandSleep cmdSleep;
	private CommandShutdown cmdShutdown;
	private CommandStatus cmdStatus;
	private CommandSun cmdSun;
	private CommandWhoAmI cmdWhoAmI;
	private CommandUpdate cmdUpdate;
	
	private HashMap<String, LinBotCommand> commandList = new HashMap<String, LinBotCommand>();
	
	public LinBotCommandManager(LinBot instance) {
		plugin = instance;
		this.registerCmds();
	}
	
	public LinBotCommand matchCommand(String cmdName) {
		if (commandList.containsKey(cmdName)) {
			return (LinBotCommand)commandList.get(cmdName);
		}
		return null;
	}
	
	public HashMap<String, LinBotCommand> getCommandList() {
		return commandList;
	}
	
	private void registerCmds() {
		cmdDay = new CommandDay(plugin);
		cmdDate = new CommandDate(plugin);
		cmdFly = new CommandFly();
		cmdGod = new CommandGod();
		cmdH = new CommandH(plugin);
		cmdHeal = new CommandHeal();
		cmdIntiate = new CommandInitiate(plugin);
		cmdKill = new CommandKill();
		cmdNight = new CommandNight();
		cmdRain = new CommandRain();
		cmdRandom = new CommandRandom(plugin);
		cmdReload = new CommandReload(plugin);	
		cmdSay = new CommandSay(plugin);
		cmdSleep = new CommandSleep();
		cmdShutdown = new CommandShutdown(plugin);
		cmdStatus = new CommandStatus(plugin);
		cmdSun = new CommandSun(plugin);
		cmdWhoAmI = new CommandWhoAmI(plugin);
		cmdUpdate = new CommandUpdate(plugin);
		
		cmdDay.setName("day");
		cmdDate.setName("date");
		cmdFly.setName("fly");
		cmdGod.setName("god");
		cmdH.setName("h");
		cmdHeal.setName("heal");
		cmdIntiate.setName("initiate");
		cmdKill.setName("kill");
		cmdNight.setName("night");
		cmdRain.setName("rain");
		cmdRandom.setName("random");
		cmdReload.setName("reload");
		cmdSay.setName("say");
		cmdSleep.setName("sleep");
		cmdShutdown.setName("shutdown");
		cmdStatus.setName("status");
		cmdSun.setName("sun");
		cmdWhoAmI.setName("whoami");
		cmdUpdate.setName("update");
		
		commandList.put("day", cmdDay);
		commandList.put("date", cmdDate);
		commandList.put("fly", cmdFly);
//		commandList.put("god", cmdGod);
		commandList.put("h", cmdH);
		commandList.put("heal", cmdHeal);
		commandList.put("initiate", cmdIntiate);
		commandList.put("kill", cmdKill);
		commandList.put("night", cmdNight);
		commandList.put("rain", cmdRain);
		commandList.put("random", cmdRandom);
		commandList.put("reload", cmdReload);
		commandList.put("say", cmdSay);
		commandList.put("sleep", cmdSleep);
		commandList.put("shutdown", cmdShutdown);
		commandList.put("status", cmdStatus);
		commandList.put("sun", cmdSun);
		commandList.put("whoami", cmdWhoAmI);
		commandList.put("update", cmdUpdate);
	}
}
