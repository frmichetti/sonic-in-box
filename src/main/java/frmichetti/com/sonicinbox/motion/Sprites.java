/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see mailto:frmichetti@gmail.com
 * */
package frmichetti.com.sonicinbox.motion;

import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JProgressBar;

import frmichetti.com.sonicinbox.enumeration.ConfigSonic;

public final class Sprites {

    public static final String FILE_MASK = "sprite_%s.png";

    private static ImageIcon[] frames;

    private static URL currentURL;

    private static boolean loaded = false;

    private static JProgressBar progressBar = new JProgressBar(0, 241);

    public Sprites(URL from) {		

	currentURL = from;

	System.out.println(currentURL);

	if (currentURL.getFile().equals("")) {

	    throw new IllegalArgumentException("Sprites Url is Empty");


	} else if (currentURL.getFile().isEmpty()){

	    throw new IllegalArgumentException("FIle not Found ");

	}else {

	    System.out.println("Resource Sprites : " + currentURL.toString());

	    System.out.println("");

	    doLoadSprites(currentURL);


	}

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

	loaded = true;

    }

    public Image getImage(int indice) {
	return frames[indice].getImage();
    }

    public static URL getCurrentURL() {
	return currentURL;
    }

    public static boolean isLoaded() {
	return loaded;
    }

    public static double getProgress() {
	return progressBar.getPercentComplete();
    }

}
