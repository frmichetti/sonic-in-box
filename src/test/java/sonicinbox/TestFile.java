package sonicinbox;

import java.io.File;
import java.net.URL;

public class TestFile {

	public static void main(String[] args) throws Exception {
		
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
