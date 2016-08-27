package br.com.frmichetti.sonicinbox;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Test;

import br.com.frmichetti.sonicinbox.util.MyPath;

public class TestPath {

	@Test
	public void testFileSeparator() {
		assertEquals(MyPath.FILE_SEPARATOR,"/");		
	}
	
	@Test
	public void testOpenShiftPath(){	
			
			try {
				
				URI u = new URI("file://.");	
				
				u = u.resolve(u);
																						
				assertEquals(".", u.toURL());				
				
			} catch (URISyntaxException | MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 	
		
	}

}
