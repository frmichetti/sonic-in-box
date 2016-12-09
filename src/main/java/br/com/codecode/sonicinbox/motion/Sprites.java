package br.com.codecode.sonicinbox.motion;

import java.awt.Image;
import java.io.IOException;
import java.text.DecimalFormat;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;

import br.com.codecode.sonicinbox.enums.ConfigSonic;

public final class Sprites implements Runnable {

	public final String filePattern = "sprite_%s.png";

	private ImageIcon[] frames;   

	private JProgressBar progressBar = new JProgressBar(0, ConfigSonic.MAX_SPRITES.getValue() -1);

	private String from;
	
	private Sprites(){};

	public Sprites(String from) {	
		
		this();
		
		this.from = from;

		System.out.println("Resource Sprites : " + from);

		System.out.println("");

		
	}

	private void doLoadSprites(String from) {

		DecimalFormat df = new DecimalFormat("0.##");

		frames = new ImageIcon[ConfigSonic.MAX_SPRITES.getValue()];

		for (int c = 0; c < frames.length; c++) {

			progressBar.setValue(c);

			try {

				frames[c] = new ImageIcon(ImageIO.read(
						ClassLoader.class.getResourceAsStream(
								String.format(from + filePattern, String.valueOf(c)))));
						

			} catch (IOException ex) {

				throw new RuntimeException(ex);
			}

			System.out.println("Download Sprite (" + progressBar.getValue() + "/" + progressBar.getMaximum() +")");  

			System.out.println(df.format(progressBar.getPercentComplete() * 100)  + "%");

			System.out.println(String.format(from + filePattern, String.valueOf(c)));

			System.out.println("");

		}

		System.out.println("End Download");
		
		System.out.println("");

	}

	public Image getImage(int index) {
		return frames[index].getImage();
	}

	@Override
	public void run() {
		doLoadSprites(from);		
	}


}
