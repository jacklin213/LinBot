package me.jacklin213.linbot;

import me.jacklin213.linbot.commands.LinBotCommand;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class LinBotCommandEvent extends Event {
	
	private static final HandlerList handlers = new HandlerList();
	private Player player;
	private LinBotCommand command;
	
	public LinBotCommandEvent(Player player, LinBotCommand command) {
		this.player = player;
		this.command = command;
	}
	
	public LinBotCommand getCommand() {
		return command;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public HandlerList getHandlers() {
	    return handlers;
	}
	 
	public static HandlerList getHandlerList() {
	    return handlers;
	}
}
