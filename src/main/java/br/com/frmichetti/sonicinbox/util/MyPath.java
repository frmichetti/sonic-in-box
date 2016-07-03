/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see mailto:frmichetti@gmail.com
 * */
package br.com.frmichetti.sonicinbox.util;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MyPath {

	private final static String MUSICS_OPEN_SHIFT = "http://portfolio-frmichetti.rhcloud.com/proj/java/br.com.frmichetti.sonicinbox/lib/musics/";

	private final static String SPRITES_OPENSHIFT = "http://portfolio-frmichetti.rhcloud.com/proj/java/br.com.frmichetti.sonicinbox/lib/sprites/";

	private final static String MUSICS_LOCAL_HOST = "http://127.0.0.1/portfolio/proj/java/br.com.frmichetti.sonicinbox/lib/musics/";

	private final static String SPRITES_LOCAL_HOST = "http://127.0.0.1/portfolio/proj/java/br.com.frmichetti.sonicinbox/lib/sprites/";

	public static URL urlMusicsOpenShift,urlSpritesOpenShift,
	urlMusicsLocalHost,urlSpritesLocalHost,urlMusicsRelative,urlSpritesRelative;

	public static final String FILE_SEPARATOR = FileSystems.getDefault().getSeparator();

	private MyPath() {
		// STUB
	}

	static {

		System.out.println("[STATIC MyPath]");

		Path path;

		try {

			path = Paths.get(MyPath.class.getProtectionDomain().getCodeSource().getLocation().toURI());			

			System.out.println(path);

		} catch (URISyntaxException e1) {

			throw new RuntimeException("Could not Resolve Path ",e1);
		}

		try {		

			urlMusicsOpenShift = new URL(MUSICS_OPEN_SHIFT);

			urlSpritesOpenShift = new URL(SPRITES_OPENSHIFT);

			urlMusicsLocalHost = new URL(MUSICS_LOCAL_HOST);

			urlSpritesLocalHost = new URL(SPRITES_LOCAL_HOST);

			String MUSICS_RELATIVE = "./META-INF/lib/musics/";

			String SPRITES_RELATIVE = "./META-INF/lib/sprites/";				

			File fMusics = new File(MUSICS_RELATIVE);

			File fSprites = new File(SPRITES_RELATIVE);

			System.out.println(MUSICS_RELATIVE);

			System.out.println(SPRITES_RELATIVE);

		} catch (MalformedURLException e) {

			throw new RuntimeException("Problema ao Instanciar URLs");
		}

	}

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
