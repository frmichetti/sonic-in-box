package br.com.frmichetti.sonicinbox;

import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.codecode.sonicinbox.enums.ConfigSonic;
import br.com.codecode.sonicinbox.util.MyPath;


public class TestMyPaths {	

	private ImageIcon icon;

	@Before
	public void setUp() throws Exception {


	}

	@Test
	public void test() throws IOException {

		for(int x = 0; x < ConfigSonic.MAX_SPRITES.getValue(); x++) {

			String path = MyPath.SPRITES_RELATIVE + String.format("sprite_%s.png", x);

			System.out.println(path);		

			icon = new ImageIcon(ImageIO.read(ClassLoader.class.getResourceAsStream(path)));
			
			Assert.assertNotNull(icon);
			
			System.out.println("height of icon : " + icon.getIconHeight() + "px");
			
			System.out.println("width of icon : " + icon.getIconWidth() + "px");
		}		


		
	}

}
