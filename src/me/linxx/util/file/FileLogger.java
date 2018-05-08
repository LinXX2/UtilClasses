package me.linxx.util.file;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import org.bukkit.plugin.java.JavaPlugin;

public class FileLogger {
	
	PrintWriter writer;
	LogLevel level;
	Calendar cal = Calendar.getInstance();
	String message = "[" + cal.get(Calendar.DAY_OF_MONTH) + ", " + (cal.get(Calendar.MONTH) + 1) + ", " + cal.get(Calendar.YEAR) + "] " + "[" + cal.get(Calendar.HOUR_OF_DAY) + ":" + cal.get(Calendar.MINUTE) + ":" + cal.get(Calendar.SECOND) + "]";
	
	
	public FileLogger(JavaPlugin pl, String filename, LogLevel level) throws SecurityException, IOException {
		this.level = level;
		try{
			this.writer = new PrintWriter(pl.getDataFolder().getPath() + filename, "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void warning(String message) {
		if(this.level.getLevel() <= LogLevel.WARNING.getLevel()) {
			 this.log(message);
		}
	}
	
	public void info(String message) {
		if(this.level.getLevel() <= LogLevel.INFO.getLevel()) {
			this.log(message);
		}
	}
	
	public void config(String message) {
		if(this.level.getLevel() <= LogLevel.CONFIG.getLevel()) {
			this.log(message);
		}
	}
	
	public void fine(String message) {
		if(this.level.getLevel() <= LogLevel.FINE.getLevel()) {
			this.log(message);
		}
	}
	
	public void finer(String message) {
		if(this.level.getLevel() <= LogLevel.FINER.getLevel()) {
			this.log(message);
		}
	}
	
	public void finest(String message) {
		if(this.level.getLevel() <= LogLevel.FINEST.getLevel()) {
			this.log(message);
		}
	}
	
	private void log(String message) {
		writer.println(this.message + message);
	}

	private enum LogLevel {

		WARNING("WARNING", 0),
		INFO("INFO", 1),
		CONFIG("CONIFG", 2),
		FINE("FINE", 3),
		FINER("FINER", 4),
		FINEST("FINEST", 5);
		
		private String name;
		private int level;
		
		private LogLevel(String name, int level) {
			this.name = name;
		}
		
		public String getName() {
			return name;
		}
		
		public int getLevel() {
			return level;
		}
		
		public static LogLevel BY_STRING(String name) {
			for(LogLevel levels : LogLevel.values()) {
				if(levels.getName().equalsIgnoreCase(name)) {
					return levels;
				}
			}
			return null;
		}
	}
}
