package br.com.frmichetti.sonicinbox;

import java.io.File;
import java.net.URL;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestFile {

	private URL url;
	
	@Before
	public void startupPath() throws Exception {
		
		url = new URL("file:///teste.txt");				
		
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
	
	@Test
	public void test(){
		Assert.assertNotNull(url);
	}

}
