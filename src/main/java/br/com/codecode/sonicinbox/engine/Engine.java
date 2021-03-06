package br.com.codecode.sonicinbox.engine;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JFrame;

import br.com.codecode.sonicinbox.Start;
import br.com.codecode.sonicinbox.enums.ConfigEngine;
import br.com.codecode.sonicinbox.enums.Orientation;
import br.com.codecode.sonicinbox.interfaces.Syncronizeable;
import br.com.codecode.sonicinbox.motion.Sonic;
import br.com.codecode.sonicinbox.util.MyPath;
import br.com.codecode.sonicinbox.util.Size;

// TODO: Auto-generated Javadoc
/**
 * The Class Engine.
 */
public final class Engine extends JFrame implements Runnable, Syncronizeable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -5571398930053263036L;

    /** The back buffer. */
    private BufferedImage backBuffer;

    /** The bbg 2 d. */
    private Graphics2D bbg2d;

    /** The event listener. */
    private EventListener eventListener;    

    /** The bbg. */
    private Graphics g, bbg;

    /** The lastkeypress. */
    private StringBuffer lastkeypress;
    
    /** The music. */
    private Music music;
    
    /** The physics. */
    private Physics physics;

    /** The sonic. */
    private Sonic sonic;
    
    /** The thread. */
    private Thread thread;

    /** The window height. */
    private final int windowHeight = ConfigEngine.HEIGHT.getValue();

    /** The window width. */
    private final int windowWidth = ConfigEngine.WIDTH.getValue();

    /**
     * Instantiates a new engine.
     */
    public Engine() {

	super("Sonic in Box v3 [Demo]");

	thread = new Thread(Start.tgrpEngine, this, "Engine Thread");

	super.setSize(windowWidth, windowHeight);

	super.setResizable(false);

	super.setDefaultCloseOperation(EXIT_ON_CLOSE);

	super.setLayout(null);

	super.setLocationRelativeTo(null);

	super.setLocation(((Size.MAX_WIDTH - super.getWidth()) + 80) / 2, 0);

	super.setFocusable(true);

	super.setAlwaysOnTop(true);

	super.requestFocus();

	lastkeypress = new StringBuffer(30);

	sonic = new Sonic(MyPath.SPRITES_RELATIVE, true);

	physics = new Physics(sonic, true);

	music = new Music(MyPath.MUSICS_RELATIVE);

	eventListener = new EventListener(this, true);

	super.addKeyListener(eventListener);

	super.setVisible(true);

	doInitGraphics();

	start();

    }

    /**
     * Do draw graphics.
     */
    public void doDrawGraphics() {

	bbg.setColor(new Color(0, 128, 128, 255));

	bbg.fillRect(0, 0, windowWidth, windowHeight);

	doShowInfoPhysics(true, 30, 50);

	doShowInfoCoordinates(true, 230, 50);

	doShowInfoAnimation(true, 450, 50);

	doShowInfoFPS(false);

	doShowInfoStatus(true, 30, 640);

	doShowInfoListener(true);

	doShowSonic(true);

	doShowBaseLines(false);

	doShowCopyrights();

	// ==================================================================================
	g.drawImage(backBuffer, 0, 0, this);
    }

    /**
     * Do init graphics.
     */
    private void doInitGraphics() {

	g = getGraphics();

	backBuffer = new BufferedImage(windowWidth, windowHeight, BufferedImage.TYPE_INT_RGB);

	bbg = backBuffer.getGraphics();

	bbg2d = (Graphics2D) backBuffer.getGraphics();

    }

    /**
     * Do show base lines.
     *
     * @param show the show
     */
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

    /**
     * Do show copyrights.
     */
    private void doShowCopyrights() {

	bbg2d.drawString(" - is Hiring ? Mail Me - frmichetti@gmail.com - by Felipe Rodrigues Michetti", 550,
		this.getHeight() - 25);

	bbg2d.drawString("Sonic by Sega", this.getWidth() - 200, this.getHeight() - 10);
    }

    /**
     * Do show info animation.
     *
     * @param show the show
     * @param x the x
     * @param y the y
     */
    private void doShowInfoAnimation(boolean show, int x, int y) {

	if (show) {

	    bbg2d.drawString("---------Thread Animation------------", x, y += 20);

	    bbg2d.drawString("Init Frame : " + String.valueOf(sonic.getInitFrame()), x, y += 20);

	    bbg2d.drawString("End Frame : " + String.valueOf(sonic.getFinalFrame()), x, y += 20);

	    bbg2d.drawString("Current Frame : " + String.valueOf(sonic.getCurrentFrame()), x, y += 20);

	    bbg2d.drawString("Anime Speed : " + String.valueOf(sonic.getAnimationSpeed()), x, y += 20);
	}

    }

    /**
     * Do show info coordinates.
     *
     * @param show the show
     * @param x the x
     * @param y the y
     */
    private void doShowInfoCoordinates(boolean show, int x, int y) {

	if (show) {

	    bbg2d.drawString("--------Thread Coordinates-----------", x, y += 20);

	    bbg2d.drawString("Axys X : " + String.valueOf(sonic.getX()), x, y += 20);

	    bbg2d.drawString("Axys Y : " + String.valueOf(sonic.getY()), x, y += 20);

	    bbg2d.drawString("Sonic W : " + String.valueOf(sonic.getW()), x, y += 20);

	    bbg2d.drawString("Sonic H : " + String.valueOf(sonic.getH()), x, y += 20);
	}

    }

    /**
     * Do show info FPS.
     *
     * @param show the show
     */
    private void doShowInfoFPS(boolean show) {

	if (show) {

	    bbg2d.drawString("FPS", 970, 50);

	    bbg2d.drawString(String.valueOf(FPS), 1000, 50);
	}

    }

    /**
     * Do show info listener.
     *
     * @param show the show
     */
    private void doShowInfoListener(boolean show) {

	if (show) {

	    bbg2d.drawString("-------------Key Listener-------------", 220, 640);

	    bbg2d.drawString(lastkeypress.toString(), 270, 660);
	}

    }

    /**
     * Do show info physics.
     *
     * @param show the show
     * @param x the x
     * @param y the y
     */
    private void doShowInfoPhysics(boolean show, int x, int y) {

	if (show) {

	    bbg2d.drawString("-----------Thread Physics------------", x, y += 20);

	    bbg2d.drawString("Acceleration : " + String.valueOf(sonic.getAcceleration()), x, y += 20);

	    bbg2d.drawString("Speed : " + String.valueOf(sonic.getSpeed()), x, y += 20);

	    bbg2d.drawString("Mass : " + String.valueOf(sonic.getMass()), x, y += 20);

	    bbg2d.drawString("Resistance : " + String.valueOf(sonic.getResistance()), x, y += 20);

	    bbg2d.drawString("Gravity : " + String.valueOf(physics.getGravity()), x, y += 20);
	}

    }

    /**
     * Do show info status.
     *
     * @param show the show
     * @param x the x
     * @param y the y
     */
    private void doShowInfoStatus(boolean show, int x, int y) {

	if (show) {

	    bbg2d.drawString("------------Thread Sonic--------------", x, y);

	    bbg2d.drawString("Orientation : ", x, 660);

	    bbg2d.drawString(String.valueOf(String.valueOf(sonic.getOrientation())), x + 80, 660);

	    bbg2d.drawString("Action : ", x, 680);

	    bbg2d.drawString(sonic.getAction().name(), x + 50, 680);

	    bbg2d.drawString("Supersonic : ", x, 700);

	    bbg2d.drawString(String.valueOf((sonic.isSuperSonic() == true ? "On" : "Off")), x + 90, 700);

	    bbg2d.drawString("A.I. : ", x, 720);

	    bbg2d.drawString(String.valueOf((sonic.isAi() == true ? "On" : "Off")), 60, 720);
	}

    }

    /**
     * Do show sonic.
     *
     * @param show the show
     */
    private void doShowSonic(boolean show) {

	if (show) {

	    if (sonic.getOrientation() == Orientation.RIGHT) {

		bbg2d.drawImage(sonic.getImage(sonic.getCurrentFrame()), sonic.getX(), sonic.getY(), sonic.getW(),
			sonic.getH(), null);

	    } else {

		bbg2d.drawImage(sonic.getImage(sonic.getCurrentFrame()), sonic.getX() + 290, sonic.getY(),
			-sonic.getW(), sonic.getH(), null);
	    }

	}

    }

    /**
     * Gets the event listener.
     *
     * @return the event listener
     */
    public EventListener getEventListener() {
    
        return eventListener;
    }

    /**
     * Gets the lastkeypress.
     *
     * @return the lastkeypress
     */
    public StringBuffer getLastkeypress() {
    
        return lastkeypress;
    }

    /**
     * Gets the music.
     *
     * @return the music
     */
    public Music getMusic() {

	return music;
    }

    /**
     * Gets the sonic.
     *
     * @return the sonic
     */
    public Sonic getSonic() {
    
        return sonic;
    }

    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {

	while (true) {

	    doDrawGraphics();

	    try {

		Thread.sleep(FPS);

	    } catch (InterruptedException e) {

		throw new RuntimeException(e);
	    }
	}
    }

    /**
     * Sets the lastkeypress.
     *
     * @param lastkeypress the new lastkeypress
     */
    public void setLastkeypress(StringBuffer lastkeypress) {
    
        this.lastkeypress = lastkeypress;
    }

    /**
     * Start.
     */
    private void start() {

	ExecutorService executor = Executors.newFixedThreadPool(3);

	executor.execute(sonic);

	executor.execute(physics);

	executor.execute(getMusic());
	
	executor.shutdown();

	thread.start();
    }
 

}
