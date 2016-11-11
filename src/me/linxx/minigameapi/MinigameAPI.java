package me.linxx.minigameapi;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class MinigameAPI {

	
	private ArrayList<Player> players = new ArrayList<>();
	private int maxplayers;
	private int minplayers;
	
	private GameState state;

	private ArrayList<Location> spawns = new ArrayList<>();
	private Location lobbyspawn;
	private Location endspawn;
	
	private Plugin pl;
	
	public MinigameAPI() {
		
	}
	
	
	
	
	
	
	
	private enum GameState {

		LOBBY,
		INGAME,
		ENDING,
		CLOSE;
		
	}
}
