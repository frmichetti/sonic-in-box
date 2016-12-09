package br.com.codecode.sonicinbox.util;

import java.nio.file.FileSystems;

public final class MyPath {
	
	private MyPath(){}		

	public final static String MUSICS_RELATIVE = "/META-INF/lib/musics/";

	public final static String SPRITES_RELATIVE = "/META-INF/lib/sprites/";	

	public final static String FILE_SEPARATOR = FileSystems.getDefault().getSeparator();	
	

}
