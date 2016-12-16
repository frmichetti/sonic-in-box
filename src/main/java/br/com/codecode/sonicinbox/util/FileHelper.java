package br.com.codecode.sonicinbox.util;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;

// TODO: Auto-generated Javadoc
/**
 * The Class FileHelper.
 */
public class FileHelper {    
    
    /**
     * Instantiates a new file helper.
     */
    private FileHelper(){}

    /** The f. */
    private static File f;

    /**
     * Gets the files.
     *
     * @param path the path
     * @return the files
     */
    public static File[] getFiles(Path path) {

	f = path.toFile();
	
	if (f.exists() && f.isDirectory() && f.canRead()) {
	    return f.listFiles();
	}

	return null;
    }

    /**
     * Gets the files.
     *
     * @param caminho the caminho
     * @return the files
     */
    public static File[] getFiles(String caminho) {

	f = new File(caminho);

	if (f.exists() && f.isDirectory() && f.canRead()) {
	    return f.listFiles();
	}

	return null;

    }

    /**
     * Gets the files.
     *
     * @param path the path
     * @return the files
     * @throws URISyntaxException the URI syntax exception
     */
    public static File[] getFiles(URL path) throws URISyntaxException {

	f = new File(path.toURI());

	if (f.exists() && f.isDirectory() && f.canRead()) {
	    return f.listFiles();
	}

	return null;
    }

    /**
     * Gets the files.
     *
     * @param path the path
     * @return the files
     */
    public static File[] getFiles(URI path) {

	f = new File(path);
	
	if (f.exists() && f.isDirectory() && f.canRead()) {
	    return f.listFiles();
	}

	return null;
    }

}
