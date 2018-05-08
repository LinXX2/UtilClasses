package me.linxx.util.player;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R1.CraftServer;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.java.JavaPlugin;

public class UtilPlayer extends CraftPlayer {
	
	
	private static final HashMap<String, UtilPlayer> PLAYERS = new HashMap<>();
	
	private final Player PLAYER;
	
	private UtilPlayer(Player player) {
		super((CraftServer) Bukkit.getServer(), ((CraftPlayer) player).getHandle());
		PLAYERS.put(player.getName().toLowerCase(), this);
		PLAYER = player;
	}
	
	/**
	 * Call this in onEnable
	 */
	public static void onInit(JavaPlugin pl) {
		pl.getServer().getPluginManager().registerEvents(new UtilPlayer.UPLeave(), pl);
	}
	
	public static UtilPlayer getPlayer(String player) {
		if (PLAYERS.containsKey(player.toLowerCase())) {
			return PLAYERS.get(player.toLowerCase());
		} else {
			Player p = Bukkit.getPlayer(player);
			return p == null ? null : new UtilPlayer(p);
			}
		}
	
	@Override
	public boolean hasPermission(String str) {
		return PLAYER.hasPermission(str);
	}

	@Override
	public boolean hasPermission(Permission perm) {
		 return PLAYER.hasPermission(perm);
	}
	
	/**
	 * Dont call this method
	 */
	public void onLeave() {
		if (PLAYERS.containsKey(getName().toLowerCase())) {
			PLAYERS.remove(getName().toLowerCase());
		}
	}
	
	public static class UPLeave implements Listener {
		@EventHandler
		public void onLeave(PlayerQuitEvent e) {
			UtilPlayer up = UtilPlayer.getPlayer(e.getPlayer().getName());
			up.onLeave();
		}
	}
}
