package ejercicioPrueba.utils.terminalUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileUtils {
	public static List<String> readLines(String filePathString) throws IOException{
		//lee todas las lineas de la ruta que se le pasa por el Paths
		List<String> lines = Files.readAllLines(Paths.get(filePathString));
		return lines;
	}
	//guardar texto en un archivo
	public static void exportText(String filePathString, String text) throws IOException {
		Files.write(Paths.get(filePathString), text.getBytes());
	}
	//Busca el directorio de un archivo
	public static Path getFolderPath() {
		//se pone esto porque en vez de coger el proyecto coge una carpeta de eclipse
	    return Path.of(System.getProperty("user.dir"));
	}
}

