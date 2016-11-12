package me.linxx.minigameapi;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class MinigameAPI {

	
	private ArrayList<Player> players = new ArrayList<>();
	private int maxplayers;
	private int minplayers;
	private int startinseconds;
	
	private GameState state;

	private ArrayList<Location> spawns = new ArrayList<>();
	private Location lobbyspawn;
	private Location endspawn;
	
	private Plugin pl;
	
	public MinigameAPI(int maxplayers, int minplayers, int startinseconds, GameState state, ArrayList<Location> spawns, Location lobbyspawn, Location endspawn, Plugin pl) {
		this.maxplayers = maxplayers;
		this.minplayers = minplayers;
		this.startinseconds = startinseconds;
		this.state = state;
		this.spawns = spawns;
		this.lobbyspawn = lobbyspawn;
		this.endspawn = endspawn;
		this.pl = pl;
	}
	
	
	
	
	
	
	
	
	public ArrayList<Player> getPlayers() {
		return players;
	}
	
	
	private enum GameState {

		LOBBY,
		INGAME,
		ENDING,
		CLOSE;
		
	}
	
	private class StartCMD implements CommandExecutor {

		@Override
		public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
			
			return false;
		}
		
		
	}

	public int getMaxplayers() {
		return maxplayers;
	}

	public void setMaxplayers(int maxplayers) {
		this.maxplayers = maxplayers;
	}

	public int getMinplayers() {
		return minplayers;
	}

	public void setMinplayers(int minplayers) {
		this.minplayers = minplayers;
	}

	public int getStartinseconds() {
		return startinseconds;
	}


	public void setStartinseconds(int startinseconds) {
		this.startinseconds = startinseconds;
	}


	public GameState getState() {
		return state;
	}


	public void setState(GameState state) {
		this.state = state;
	}


	public ArrayList<Location> getSpawns() {
		return spawns;
	}

	public void setSpawns(ArrayList<Location> spawns) {
		this.spawns = spawns;
	}

	public Location getLobbyspawn() {
		return lobbyspawn;
	}

	public void setLobbyspawn(Location lobbyspawn) {
		this.lobbyspawn = lobbyspawn;
	}

	public Location getEndspawn() {
		return endspawn;
	}

	public void setEndspawn(Location endspawn) {
		this.endspawn = endspawn;
	}
	
	
}
