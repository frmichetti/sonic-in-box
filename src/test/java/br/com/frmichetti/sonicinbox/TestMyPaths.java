package br.com.frmichetti.sonicinbox;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import org.junit.Before;
import org.junit.Test;

import br.com.codecode.sonicinbox.util.MyPath;

public class TestMyPaths {	
	
	private ImageIcon icon;
	
	@Before
	public void setUp() throws Exception {
		
		String path = MyPath.SPRITES_RELATIVE + "sprite_0.png";
		
		System.out.println(path);		
		
		icon = new ImageIcon(ImageIO.read(ClassLoader.class.getResourceAsStream(path)));
		
	}
	
	@Test
	public void test() {
		System.out.println(icon.getIconHeight());
	}

}
