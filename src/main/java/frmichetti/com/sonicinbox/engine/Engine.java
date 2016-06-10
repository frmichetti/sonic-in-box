/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see mailto:frmichetti@gmail.com
 * */
package frmichetti.com.sonicinbox.engine;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import frmichetti.com.sonicinbox.Start;
import frmichetti.com.sonicinbox.enumeration.ConfigEngine;
import frmichetti.com.sonicinbox.enumeration.Orientation;
import frmichetti.com.sonicinbox.motion.Sonic;
import frmichetti.com.sonicinbox.motion.Sprites;
import frmichetti.com.sonicinbox.util.MyPath;
import frmichetti.com.sonicinbox.util.Size;

public final class Engine extends JFrame implements Runnable {

	private static final long serialVersionUID = -5571398930053263036L;

	private Thread t;
	
	private final int windowWidth = ConfigEngine.WIDTH.getValue();
	
	private final int windowHeight = ConfigEngine.HEIGHT.getValue();
	
	private final int FPS = ConfigEngine.FPS.getValue();
	
	public static StringBuffer lastkeypress = new StringBuffer(30);

	public static Sonic sonic;
	
	private static Physics physics;
	
	public static Event event;
	
	public static Music music;

	private Graphics g, bbg;
	
	private Graphics2D bbg2d;
	
	private BufferedImage backBuffer;

	public Engine() {
		
		super("Sonic in Box v3 [Demo]");
		
		t = new Thread(Start.tgrpEngine, this, "Engine Thread");

		super.setSize(windowWidth, windowHeight);
		
		super.setResizable(false);
		
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		super.setLayout(null);
		
		super.setLocationRelativeTo(null);
		
		super.setLocation(((Size.MAX_WIDTH - super.getWidth()) + 80) / 2, 0);
		
		super.setFocusable(true);
		
		super.setAlwaysOnTop(true);
		
		super.requestFocus();

		sonic = new Sonic(true);

		physics = new Physics(true);

		event = new Event(true);

		try {

			music = new Music(MyPath.urlMusicsOpenShift, true);

		} catch (InterruptedException ex) {

			throw new RuntimeException("Erro ao reproduzir arquivo de Musica "+ ex);
		}

		super.addKeyListener(event);

		super.setVisible(true);

		doInitGraphics();

		start();

	}

	private void doInitGraphics() {

		g = getGraphics();

		backBuffer = new BufferedImage(windowWidth, windowHeight, BufferedImage.TYPE_INT_RGB);

		bbg = backBuffer.getGraphics();

		bbg2d = (Graphics2D) backBuffer.getGraphics();

	}

	public void doDrawGraphics() {

		bbg.setColor(new Color(0, 128, 128, 255));

		bbg.fillRect(0, 0, windowWidth, windowHeight);

		doShowInfoPhisics(true);		
		
		doShowInfoCoordinates(true);		
		
		doShowInfoAnimation(true);		
		
		doShowInfoFPS(false);
		
		doShowInfoStatus(true);		
		
		doShowInfoListener(true);
		
		doShowSonic(true);
		
		doShowBaseLines(false);
		
		doShowCopyrights();		

		//==================================================================================
		g.drawImage(backBuffer, 0, 0, this);
	}

	private void doShowInfoPhisics(boolean show) {

		if (show) {
			
			bbg2d.drawString("-----------Thread Physics------------", 30, 50);
			
			bbg2d.drawString("Acceleration : " + String.valueOf(sonic.getAcceleration()), 30, 70);
			
			bbg2d.drawString("Speed : " + String.valueOf(sonic.getSpeed()), 30, 90);
			
			bbg2d.drawString("Mass : " + String.valueOf(sonic.getMass()), 30, 110);
			
			bbg2d.drawString("Resistance : " + String.valueOf(physics.getResistance()), 30, 130);
			
			bbg2d.drawString("Gravity : " + String.valueOf(physics.getGravity()), 30, 150);
		}

	}

	private void doShowInfoCoordinates(boolean show) {
		if (show) {
			
			bbg2d.drawString("--------Thread Coordinates-----------", 200, 50);
			
			bbg2d.drawString("Axys X : " + String.valueOf(sonic.getX()), 200, 70);
			
			bbg2d.drawString("Axys Y : " + String.valueOf(sonic.getY()), 200, 90);
			
			bbg2d.drawString("Sonic W : " + String.valueOf(sonic.getW()), 200, 110);
			
			bbg2d.drawString("Sonic H : " + String.valueOf(sonic.getH()), 200, 130);
		}

	}

	private void doShowInfoAnimation(boolean show) {
		
		if (show) {
			
			bbg2d.drawString("---------Thread Animation------------", 390, 50);
			
			bbg2d.drawString("Init Frame : " + String.valueOf(Sonic.getAnimation().getInitFrame()), 390, 70);
			
			bbg2d.drawString("End Frame : " + String.valueOf(Sonic.getAnimation().getFinalFrame()), 390, 90);
			
			bbg2d.drawString("Current Frame : " + String.valueOf(Sonic.getAnimation().getCurrentFrame()), 390, 110);
			
			bbg2d.drawString("Anime Speed : " + String.valueOf(sonic.getAnimeSpeed()), 390, 130);
		}

	}

	private void doShowInfoStatus(boolean show) {
		
		if (show) {
			
			bbg2d.drawString("------------Thread Sonic--------------", 30, 640);
			
			bbg2d.drawString("Orientation : ", 30, 660);
			
			bbg2d.drawString(String.valueOf(String.valueOf(sonic.getOrientation())), 100, 660);
			
			bbg2d.drawString("Action : ", 30, 680);
			
			bbg2d.drawString(sonic.getAction().name(), 100, 680);
			
			bbg2d.drawString("Supersonic : ", 30, 700);
			
			bbg2d.drawString(String.valueOf((sonic.isSuperSonic() == true ? "On" : "Off")), 100, 700);
			
			bbg2d.drawString("A.I. : ", 30, 720);
			
			bbg2d.drawString(String.valueOf((sonic.isAi() == true ? "On" : "Off")), 60, 720);
		}

	}

	private void doShowInfoListener(boolean show) {
		
		if (show) {
			
			bbg2d.drawString("-------------Key Listener-------------", 220, 640);
			
			bbg2d.drawString(lastkeypress.toString(), 270, 660);
		}

	}

	private void doShowInfoFPS(boolean show) {
		
		if (show) {
			
			bbg2d.drawString("FPS", 970, 50);
			
			bbg2d.drawString(String.valueOf(FPS), 1000, 50);
		}

	}

	private void doShowBaseLines(boolean show) {
		
		if (show) {
			
			if (sonic.getOrientation() == Orientation.RIGHT) {

				bbg2d.draw3DRect(sonic.getX(), sonic.getY(), sonic.getW(), sonic.getH(), false);
				
				bbg2d.drawLine(sonic.getX() + 150, sonic.getY() + 150, (this.getWidth() / 2), (this.getHeight() / 2));

			} else {

				bbg2d.draw3DRect(sonic.getX(), sonic.getY(), sonic.getW(), sonic.getH(), false);
				
				bbg2d.drawLine(sonic.getX() + 150, sonic.getY() + 150, (this.getWidth() / 2), (this.getHeight() / 2));

			}
		}

	}

	private void doShowSonic(boolean show) {

		if (show) {

			if (sonic.getOrientation() == Orientation.RIGHT) {

				bbg2d.drawImage(sonic.getSprites().getImage(Sonic.getAnimation().getCurrentFrame()),
						sonic.getX(), sonic.getY(), sonic.getW(), sonic.getH(), null);

			} else {

				bbg2d.drawImage(sonic.getSprites().getImage(Sonic.getAnimation().getCurrentFrame()),
						sonic.getX() + 290, sonic.getY(), -sonic.getW(), sonic.getH(), null);
			}

		} else {

			bbg2d.drawString("Loading Sprites " + Sprites.getProgress() + "%", sonic.getX(), getY());

		}

	}

	private void doShowCopyrights() {
		
		bbg2d.drawString(" - is Hiring ? Mail Me - frmichetti@gmail.com - by Felipe Rodrigues Michetti", 600, this.getHeight() - 25);
		
		bbg2d.drawString("Sonic by Sega", this.getWidth() - 100, this.getHeight() - 10);
	}

	@Override
	public void run() {

		while (true) {

			doDrawGraphics();

			try {

				Thread.sleep(FPS);

			} catch (InterruptedException e) {
				
				throw new RuntimeException("Falha ao Interromper " + t.getName() + " " + e);
			}
		}
	}

	private void start() {
		
		sonic.getThread().start();
		
		Sonic.getAnimation().getThread().start();
		
		Sonic.getMovimentacao().getThread().start();
		
		physics.getThread().start();
		
		music.getThread().start();
		
		t.start();
	}

}
