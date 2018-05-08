package me.linxx.util.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

public class UTF8YamlConfiguration extends YamlConfiguration{
	
	public UTF8YamlConfiguration(File file){
		try {
			load(file);
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void load( File file ) throws FileNotFoundException, IOException, InvalidConfigurationException {
		this.load( new InputStreamReader(new FileInputStream( file ), Charsets.UTF_8 ) );
	}
	
	@Override
	public void save(File file) throws IOException {
		Files.createParentDirs(file);
		String data = this.saveToString();
		Writer writer = new OutputStreamWriter( new FileOutputStream(file), Charsets.UTF_8 );
		try {
			writer.write( data );
		} finally {
			writer.close();
		}
	}

}