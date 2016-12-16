package br.com.codecode.sonicinbox.console;


import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.util.Observable;
import java.util.Observer;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

import br.com.codecode.sonicinbox.engine.Engine;
import br.com.codecode.sonicinbox.interfaces.Physicable;
import br.com.codecode.sonicinbox.motion.Sonic;
import br.com.codecode.sonicinbox.util.Size;

// TODO: Auto-generated Javadoc
/**
 * The listener interface for receiving frame events.
 * The class that is interested in processing a frame
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addFrameListener<code> method. When
 * the frame event occurs, that object's appropriate
 * method is invoked.
 *
 * @see FrameEvent
 */
public final class FrameListener extends JFrame implements Runnable, Observer {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -8266452496408906017L;

    /** The progress. */
    private JProgressBar progress;

    /** The j label 1. */
    private JLabel lblAccelation, jLabel1;

    /** The sonic. */
    private Sonic sonic;

    /** The thread. */
    private Thread thread;

    /**
     * Instantiates a new frame listener.
     */
    private FrameListener() {

	thread = new Thread(this);

	initComponents();

	super.setLocationRelativeTo(null);

	super.setLocation((Size.MAX_WIDTH - getWidth()) / 2, (Size.MAX_HEIGHT - getHeight()));

	super.setVisible(true);

	thread.start();

    }

    /**
     * Instantiates a new frame listener.
     *
     * @param engine the engine
     */
    public FrameListener(Engine engine) {
	this();
	this.sonic = engine.getSonic();

	super.addKeyListener(engine.getEventListener());
	this.sonic.addObserver(this);
    }

    /**
     * Inits the components.
     */
    private void initComponents() {

	progress = new JProgressBar();

	progress.setStringPainted(true);

	jLabel1 = new JLabel();

	lblAccelation = new JLabel();

	setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	setTitle("Listener Console ");

	setAlwaysOnTop(true);

	setLocation(new Point(0, 0));

	setResizable(false);

	progress.setMaximum(2000);

	progress.setFocusable(false);

	progress.setStringPainted(true);

	jLabel1.setFont(new Font("Tahoma", 1, 9));

	jLabel1.setForeground(new Color(0, 51, 255));

	jLabel1.setText("Aceleration");

	lblAccelation.setFont(new Font("Tahoma", 0, 9));

	lblAccelation.setForeground(new Color(0, 204, 255));

	GroupLayout layout = new GroupLayout(getContentPane());

	getContentPane().setLayout(layout);

	layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		.addComponent(progress, GroupLayout.PREFERRED_SIZE, 536, GroupLayout.PREFERRED_SIZE)
		.addGroup(layout.createSequentialGroup()
			.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
			.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
			.addComponent(lblAccelation, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)));

	layout.setVerticalGroup(
		layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING,
			layout.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
					.addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
					.addComponent(lblAccelation, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addComponent(progress, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)));

	pack();
    }

    /**
     * Do refresh components.
     */
    private void doRefreshComponents() {

	
    }

    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {

	while (true) {

	    if (sonic != null)
		
		doUpdateSpeed((int) sonic.getAcceleration());
	    	
	    	doRefreshComponents();
	   

	}
    }

    /**
     * Do update speed.
     *
     * @param speed the speed
     */
    private void doUpdateSpeed(int speed) {

	progress.setValue(speed);

	lblAccelation.setText(String.valueOf(speed));
	
    }

    /* (non-Javadoc)
     * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
     */
    @Override
    public void update(Observable o, Object arg) {
	
	if(o != null)

	if (o instanceof Physicable) {
	    
	}
	
    }
}
