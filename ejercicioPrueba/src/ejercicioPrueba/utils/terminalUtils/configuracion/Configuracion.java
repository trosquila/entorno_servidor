package ejercicioPrueba.utils.terminalUtils.configuracion;

import java.io.IOException;
import java.lang.module.Configuration;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ejercicioPrueba.utils.terminalUtils.FileUtils;

public class Configuracion {
	BDConfig bdConfig;
	
	public Configuracion() {
		
	}
	
	public BDConfig getDatabaseConfigurations() {
		return this.bdConfig;
	}
	
	public void setDataBaseConfiguration(BDConfig bdConfig) {
		this.bdConfig = bdConfig;
	}
	private static Configuration configuracion;
	public static Configuration getInstance() throws IOException{
		if(configuracion != null) {
			return configuracion;
		}
		Path envPath = FileUtils.getFolderPath().toAbsolutePath();
		
		List<String> configLines = FileUtils.readLines(envPath.toString());
		Map<String, String> configMap = new HashMap<String, String>();
		for(String line : configLines) {
			if(!line.trim().equals("")) {
				String[] args = line.split("=");
				configMap.put(args[0].trim(), args[1].trim());
			}
		}
		
		BDConfig bdConfig = new BDConfig();
		
		
		return configuracion;
	}
}
