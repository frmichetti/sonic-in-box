package br.com.codecode.sonicinbox.util;

import java.nio.file.FileSystems;

public final class MyPath {
	
	private MyPath(){}
	
	private final static String server = "http://portfolio-frmichetti.rhcloud.com/";

	public final static String MUSICS_OPEN_SHIFT = server + "proj/java/sonicinbox/lib/musics/";

	public final static String SPRITES_OPENSHIFT = server +	"proj/java/sonicinbox/lib/sprites/";	

	public final static String MUSICS_RELATIVE = "/META-INF/lib/musics/";

	public final static String SPRITES_RELATIVE = "/META-INF/lib/sprites/";	

	public final static String FILE_SEPARATOR = FileSystems.getDefault().getSeparator();	
	

}
