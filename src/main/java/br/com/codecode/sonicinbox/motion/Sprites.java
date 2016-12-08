package br.com.codecode.sonicinbox.motion;

import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JProgressBar;

import br.com.codecode.sonicinbox.enumeration.ConfigSonic;

public final class Sprites {

	public static final String FILE_MASK = "sprite_%s.png";

	private ImageIcon[] frames;   

	private JProgressBar progressBar = new JProgressBar(0, 241);

	public Sprites(URL from) {	

		System.out.println("Resource Sprites : " + from);

		System.out.println("");

		doLoadSprites(from);
	}

	private void doLoadSprites(URL from) {

		DecimalFormat df = new DecimalFormat("0.##");

		frames = new ImageIcon[ConfigSonic.MAX_SPRITES.getValue()];

		for (int c = 0; c < frames.length; c++) {

			progressBar.setValue(c);

			try {

				frames[c] = new ImageIcon(new URL(String.format(from.toString() + FILE_MASK, String.valueOf(c))));

			} catch (MalformedURLException ex) {

				throw new RuntimeException("It was not possible load Sprites " + ex);
			}

			System.out.println("Download Sprite (" + progressBar.getValue() + "/" + progressBar.getMaximum() +")");  

			System.out.println(df.format(progressBar.getPercentComplete() * 100)  + "%");

			System.out.println(String.format(from.toString() + FILE_MASK, String.valueOf(c)));

			System.out.println("");

		}

		System.out.println("End Download");

	}

	public Image getImage(int indice) {
		return frames[indice].getImage();
	}




}
