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

public final class FrameListener extends JFrame implements Runnable, Observer {

    private static final long serialVersionUID = -8266452496408906017L;

    private JProgressBar progress;

    private JLabel lblAccelation, jLabel1;

    private Sonic sonic;

    private Thread thread;

    private FrameListener() {

	thread = new Thread(this);

	initComponents();

	super.setLocationRelativeTo(null);

	super.setLocation((Size.MAX_WIDTH - getWidth()) / 2, (Size.MAX_HEIGHT - getHeight()));

	super.setVisible(true);

	thread.start();

    }

    public FrameListener(Engine engine) {
	this();
	this.sonic = engine.getSonic();

	super.addKeyListener(engine.getEventListener());
	this.sonic.addObserver(this);
    }

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

    private void doRefreshComponents() {

	
    }

    @Override
    public void run() {

	while (true) {

	    if (sonic != null)
		
		doUpdateSpeed((int) sonic.getAcceleration());
	    	
	    	doRefreshComponents();
	   

	}
    }

    private void doUpdateSpeed(int speed) {

	progress.setValue(speed);

	lblAccelation.setText(String.valueOf(speed));
	
    }

    @Override
    public void update(Observable o, Object arg) {
	
	if(o != null)

	if (o instanceof Physicable) {
	    
	}
	
    }
}
