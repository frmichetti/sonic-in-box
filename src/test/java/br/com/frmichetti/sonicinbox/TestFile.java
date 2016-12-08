package br.com.frmichetti.sonicinbox;

import java.io.File;
import java.net.URL;

import org.junit.Test;

public class TestFile {

	@Test
	public void startupPath() throws Exception {
		
		URL url = TestFile.class.getResource("./teste.txt");
		
		System.out.println(url);
		
		File f = new File(url.toURI());
		
		if (f.exists() && f.isDirectory()) {
			
			File[] fs = f.listFiles();
			
			for (File file : fs) {
				System.out.println(file.getName());
			}
			
			
		}
		
		System.out.println(url);

	}

}
