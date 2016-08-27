/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see mailto:frmichetti@gmail.com
 * */
package br.com.frmichetti.sonicinbox.engine;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JFrame;

import br.com.frmichetti.sonicinbox.Start;
import br.com.frmichetti.sonicinbox.enumeration.ConfigEngine;
import br.com.frmichetti.sonicinbox.enumeration.Orientation;
import br.com.frmichetti.sonicinbox.motion.Sonic;
import br.com.frmichetti.sonicinbox.util.Size;

public final class Engine extends JFrame implements Runnable {

	private static final long serialVersionUID = -5571398930053263036L;

	private Thread t;

	private final int windowWidth = ConfigEngine.WIDTH.getValue();

	private final int windowHeight = ConfigEngine.HEIGHT.getValue();

	private final int FPS = ConfigEngine.FPS.getValue();
	
	static 
	public StringBuffer lastkeypress = new StringBuffer(30);

	public static Sonic sonic;

	private Physics physics;

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

		music = new Music();

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

		doShowInfoPhysics(true,30,50);		

		doShowInfoCoordinates(true,230,50);		

		doShowInfoAnimation(true,450,50);		

		doShowInfoFPS(false);

		doShowInfoStatus(true, 30, 640);		

		doShowInfoListener(true);

		doShowSonic(true);

		doShowBaseLines(false);

		doShowCopyrights();		

		//==================================================================================
		g.drawImage(backBuffer, 0, 0, this);
	}

	private void doShowInfoPhysics(boolean show,int x,int y) {

		if (show) {

			bbg2d.drawString("-----------Thread Physics------------", x, y+=20);

			bbg2d.drawString("Acceleration : " + String.valueOf(sonic.getAcceleration()), x, y+=20);

			bbg2d.drawString("Speed : " + String.valueOf(sonic.getSpeed()), x, y+=20);

			bbg2d.drawString("Mass : " + String.valueOf(sonic.getMass()), x, y+=20);

			bbg2d.drawString("Resistance : " + String.valueOf(physics.getResistance()), x, y+=20);

			bbg2d.drawString("Gravity : " + String.valueOf(physics.getGravity()), x, y+=20);
		}

	}

	private void doShowInfoCoordinates(boolean show, int x, int y) {
		if (show) {

			bbg2d.drawString("--------Thread Coordinates-----------", x, y+=20);

			bbg2d.drawString("Axys X : " + String.valueOf(sonic.getX()), x, y+=20);

			bbg2d.drawString("Axys Y : " + String.valueOf(sonic.getY()), x, y+=20);

			bbg2d.drawString("Sonic W : " + String.valueOf(sonic.getW()), x, y+=20);

			bbg2d.drawString("Sonic H : " + String.valueOf(sonic.getH()), x, y+=20);
		}

	}

	private void doShowInfoAnimation(boolean show,  int x, int y) {

		if (show) {

			bbg2d.drawString("---------Thread Animation------------", x, y+=20);

			bbg2d.drawString("Init Frame : " + String.valueOf(sonic.animation.getInitFrame()), x, y+=20);

			bbg2d.drawString("End Frame : " + String.valueOf(sonic.animation.getFinalFrame()), x, y+=20);

			bbg2d.drawString("Current Frame : " + String.valueOf(sonic.animation.getCurrentFrame()), x, y+=20);

			bbg2d.drawString("Anime Speed : " + String.valueOf(sonic.getAnimeSpeed()), x, y+=20);
		}

	}

	private void doShowInfoStatus(boolean show,int x, int y) {

		if (show) {

			bbg2d.drawString("------------Thread Sonic--------------", x, y);

			bbg2d.drawString("Orientation : ", x, 660);

			bbg2d.drawString(String.valueOf(String.valueOf(sonic.getOrientation())), x+80, 660);

			bbg2d.drawString("Action : ", x, 680);

			bbg2d.drawString(sonic.getAction().name(), x+50, 680);

			bbg2d.drawString("Supersonic : ", x, 700);

			bbg2d.drawString(String.valueOf((sonic.isSuperSonic() == true ? "On" : "Off")), x + 90, 700);

			bbg2d.drawString("A.I. : ", x, 720);

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

				bbg2d.drawImage(sonic.getSprites().getImage(sonic.animation.getCurrentFrame()),
						sonic.getX(), sonic.getY(), sonic.getW(), sonic.getH(), null);

			} else {

				bbg2d.drawImage(sonic.getSprites().getImage(sonic.animation.getCurrentFrame()),
						sonic.getX() + 290, sonic.getY(), -sonic.getW(), sonic.getH(), null);
			}

		} 

	}

	private void doShowCopyrights() {

		bbg2d.drawString(" - is Hiring ? Mail Me - frmichetti@gmail.com - by Felipe Rodrigues Michetti", 550, this.getHeight() - 25);

		bbg2d.drawString("Sonic by Sega", this.getWidth() - 200, this.getHeight() - 10);
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

		ExecutorService executor = Executors.newFixedThreadPool(3);	

		executor.execute(sonic);

		executor.execute(physics);

		executor.execute(music);	

		t.start();
	}

}
