package br.com.codecode.sonicinbox.util;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;

public class FileHelper {    
    
    private FileHelper(){}

    private static File f;

    public static File[] getFiles(Path path) {

	f = path.toFile();
	
	if (f.exists() && f.isDirectory() && f.canRead()) {
	    return f.listFiles();
	}

	return null;
    }

    public static File[] getFiles(String caminho) {

	f = new File(caminho);

	if (f.exists() && f.isDirectory() && f.canRead()) {
	    return f.listFiles();
	}

	return null;

    }

    public static File[] getFiles(URL path) throws URISyntaxException {

	f = new File(path.toURI());

	if (f.exists() && f.isDirectory() && f.canRead()) {
	    return f.listFiles();
	}

	return null;
    }

    public static File[] getFiles(URI path) {

	f = new File(path);
	
	if (f.exists() && f.isDirectory() && f.canRead()) {
	    return f.listFiles();
	}

	return null;
    }

}
