/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see mailto:frmichetti@gmail.com
 * */
package br.com.frmichetti.sonicinbox.util;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class MyPath {

	public final static String MUSICS_OPEN_SHIFT = 
			"http://portfolio-frmichetti.rhcloud.com/proj/java/sonicinbox/lib/musics/";

	public final static String SPRITES_OPENSHIFT = 
			"http://portfolio-frmichetti.rhcloud.com/proj/java/sonicinbox/lib/sprites/";

	public final static String MUSICS_LOCAL_HOST =			
			"http://localhost/frmichetti/portfolio/php/proj/java/sonicinbox/lib/musics/";			

	public final static String SPRITES_LOCAL_HOST =			
			"http://localhost/frmichetti/portfolio/php/proj/java/sonicinbox/lib/sprites/";

	public final static String MUSICS_RELATIVE = "file:///META-INF/lib/musics/";

	public final static String SPRITES_RELATIVE = "file:///META-INF/lib/sprites/";	

	public static final String FILE_SEPARATOR = FileSystems.getDefault().getSeparator();

	File fMusics = new File(MUSICS_RELATIVE);

	File fSprites = new File(SPRITES_RELATIVE);

	public static String testPath(String caminho) {

		Path path;

		URI uri = null;

		try {

			uri = new URI(caminho);

			System.out.println("Host " + uri.getHost());

			System.out.println("Path " + uri.getPath());

			System.out.println("Raw Path " + uri.getRawPath());

			uri = uri.normalize();

			System.out.println("Normalize " + uri);

			System.out.println("");

		} catch (URISyntaxException ex) {

			throw new RuntimeException("Erro na Sintaxe da URI : " + ex.getMessage());

		}

		System.out.println("PATH");

		path = FileSystems.getDefault().getPath(uri.getPath());

		System.out.println("Path is absolute ? " + path.isAbsolute());

		System.out.println("Solved Path " + path.resolve(uri.getPath()));

		return uri.toString();

	}

}
