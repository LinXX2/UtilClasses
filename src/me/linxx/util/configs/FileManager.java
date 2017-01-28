package me.linxx.util.configs;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class FileManager {

	String filename;
	private JavaPlugin pl;
	private File file;
	private YamlConfiguration cfg;
	
	public FileManager(String filename, JavaPlugin pl) {
		this.pl = pl;
		this.filename = filename;
		cfg = new YamlConfiguration();
		this.file = new File(pl.getDataFolder().getPath(), this.filename);
		if(!(this.file.exists())) {
			pl.saveResource(this.filename, true);
			try {
				this.cfg.load(this.file);
			} catch (IOException | InvalidConfigurationException e) {e.printStackTrace();}
		}
	}
	
	public void save() {
		try {
			this.cfg.save(this.file);
		} catch (IOException e) {e.printStackTrace();}
	}
	
	public void load() {
		try {
			this.cfg.load(this.file);
		} catch (IOException | InvalidConfigurationException e) {e.printStackTrace();}
	}
	
	public YamlConfiguration getConfig() {
		return cfg;
	}
	
}