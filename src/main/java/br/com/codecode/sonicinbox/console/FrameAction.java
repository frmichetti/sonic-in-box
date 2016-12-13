/**
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see mailto:frmichetti@gmail.com
 */
package br.com.codecode.sonicinbox.console;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JSeparator;
import javax.swing.JToggleButton;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import br.com.codecode.sonicinbox.engine.Engine;
import br.com.codecode.sonicinbox.engine.Music;
import br.com.codecode.sonicinbox.enums.Action;
import br.com.codecode.sonicinbox.interfaces.Physicable;
import br.com.codecode.sonicinbox.motion.Sonic;
import br.com.codecode.sonicinbox.util.Size;

public final class FrameAction extends JFrame implements Runnable, Observer {

    private static final long serialVersionUID = 1370653725906464274L;

    private JButton btnAccelerate, btnBrake;

    public static JButton btnDown, btnLeft, btnRight, btnUp;

    private JLabel lblTitle, lblSpeed;

    private JProgressBar progressBar;

    private JToggleButton toggleAi, toggleSuperSonic, toggleMusic;

    private JSeparator separator;

    private Sonic sonic;

    private Music music;

    private Thread thread;

    private FrameAction() {

	thread = new Thread(this);

	initComponents();

	super.setLocationRelativeTo(null);

	super.setLocation((Size.MAX_WIDTH - getWidth()), 0);

	super.setVisible(true);

	thread.start();
    }

    public FrameAction(Engine engine) {
	this();
	this.sonic = engine.getSonic();
	this.music = engine.getMusic();

	super.addKeyListener(engine.getEventListener());

	this.sonic.addObserver(this);

    }

    private void doControlButtons(boolean ai, JButton... buttons) {

	if (buttons.length > 0)

	    for (JButton btn : buttons) {
		btn.setEnabled(ai);
	    }

    }

    private void doRefreshComponent() {	

	toggleSuperSonic.setSelected(sonic.isSuperSonic());

	toggleAi.setSelected(sonic.isAi());

	toggleMusic.setSelected(music.isOn());
    }

    private void initComponents() {

	btnAccelerate = new JButton();

	toggleAi = new JToggleButton();

	btnLeft = new JButton();

	btnDown = new JButton();

	btnRight = new JButton();

	btnUp = new JButton();

	toggleMusic = new JToggleButton();

	toggleSuperSonic = new JToggleButton();

	btnBrake = new JButton();

	progressBar = new JProgressBar();

	lblSpeed = new JLabel();

	lblTitle = new JLabel();

	separator = new JSeparator();

	setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	setTitle("Action Console");

	setAlwaysOnTop(true);

	setLocation(new Point(1347, 0));

	setResizable(false);

	btnAccelerate.setFont(new Font("Tahoma", 1, 14));

	btnAccelerate.setForeground(new Color(0, 0, 255));

	btnAccelerate.setText("SpeedUp");

	btnAccelerate.setFocusable(false);

	btnAccelerate.setRequestFocusEnabled(false);

	btnAccelerate.setVerifyInputWhenFocusTarget(false);

	btnAccelerate.addActionListener((evt) -> {
	    BTN_AcelerarActionPerformed(evt);

	});

	toggleAi.setFont(new Font("Tahoma", 1, 14));

	toggleAi.setForeground(new Color(255, 0, 102));

	toggleAi.setText("A.I.");

	toggleAi.setFocusable(false);

	toggleAi.setRequestFocusEnabled(false);

	toggleAi.setVerifyInputWhenFocusTarget(false);

	toggleAi.addActionListener((evt) -> {
	    JTBN_AIActionPerformed(evt);

	});

	btnLeft.setFont(new Font("Tahoma", 1, 9));

	btnLeft.setText("Right");

	btnLeft.setEnabled(false);

	btnLeft.setFocusable(false);

	btnLeft.setRequestFocusEnabled(false);

	btnLeft.setVerifyInputWhenFocusTarget(false);

	btnDown.setFont(new Font("Tahoma", 1, 9));

	btnDown.setText("Down");

	btnDown.setEnabled(false);

	btnDown.setFocusable(false);

	btnDown.setRequestFocusEnabled(false);

	btnDown.setVerifyInputWhenFocusTarget(false);

	btnRight.setFont(new Font("Tahoma", 1, 9));

	btnRight.setText("Left");

	btnRight.setEnabled(false);

	btnRight.setFocusable(false);

	btnRight.setRequestFocusEnabled(false);

	btnRight.setVerifyInputWhenFocusTarget(false);

	btnUp.setFont(new Font("Tahoma", 1, 9));

	btnUp.setText("Up");

	btnUp.setEnabled(false);

	btnUp.setFocusable(false);

	btnUp.setRequestFocusEnabled(false);

	btnUp.setVerifyInputWhenFocusTarget(false);

	toggleMusic.setFont(new Font("Tahoma", 1, 14));

	toggleMusic.setForeground(new Color(204, 0, 204));

	toggleMusic.setText("Music");

	toggleMusic.setFocusable(false);

	toggleMusic.setRequestFocusEnabled(false);

	toggleMusic.setVerifyInputWhenFocusTarget(false);

	toggleMusic.addActionListener((evt) -> {
	    JTB_MusicaActionPerformed(evt);

	});

	toggleSuperSonic.setFont(new Font("Tahoma", 1, 14));

	toggleSuperSonic.setForeground(new Color(255, 204, 0));

	toggleSuperSonic.setText("Super Sonic");

	toggleSuperSonic.setFocusable(false);

	toggleSuperSonic.setOpaque(true);

	toggleSuperSonic.setRequestFocusEnabled(false);

	toggleSuperSonic.setVerifyInputWhenFocusTarget(false);

	toggleSuperSonic.addActionListener((evt) -> {
	    JTBN_SuperSonicActionPerformed(evt);

	});

	btnBrake.setFont(new Font("Tahoma", 1, 14));

	btnBrake.setForeground(new Color(0, 0, 255));

	btnBrake.setText("BreakUp");

	btnBrake.setFocusable(false);

	btnBrake.setRequestFocusEnabled(false);

	btnBrake.setVerifyInputWhenFocusTarget(false);

	btnBrake.addActionListener((evt) -> {
	    BTN_FreiarActionPerformed(evt);

	});

	progressBar.setMaximum(130000);

	progressBar.setOrientation(1);

	progressBar.setFocusable(false);

	lblSpeed.setFont(new Font("Tahoma", 0, 10));

	lblSpeed.setForeground(new Color(0, 204, 255));

	lblSpeed.setHorizontalAlignment(SwingConstants.CENTER);

	lblTitle.setFont(new Font("Tahoma", 1, 9));

	lblTitle.setForeground(new Color(51, 51, 255));

	lblTitle.setHorizontalAlignment(SwingConstants.CENTER);

	lblTitle.setText("Speed");

	separator.setOrientation(SwingConstants.VERTICAL);

	GroupLayout layout = new GroupLayout(getContentPane());
	getContentPane().setLayout(layout);
	layout.setHorizontalGroup(
		layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup()
			.addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(toggleAi, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE).addComponent(
					toggleMusic, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
				.addComponent(btnAccelerate, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
				.addComponent(btnBrake, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
				.addComponent(toggleSuperSonic, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
				.addGroup(layout.createSequentialGroup().addGroup(layout
					.createParallelGroup(GroupLayout.Alignment.LEADING)
					.addGroup(layout.createSequentialGroup()
						.addComponent(btnLeft, GroupLayout.DEFAULT_SIZE,
							GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGap(5, 5, 5)
						.addComponent(btnRight, GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE))
					.addComponent(btnUp, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
					.addComponent(btnDown, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
					.addGap(2, 2, 2)))
			.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(separator)
			.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
				.addComponent(lblSpeed, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
					GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(progressBar, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
					GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(lblTitle, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))
			.addGap(25, 25, 25)));
	layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		.addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout
			.createParallelGroup(GroupLayout.Alignment.LEADING)
			.addGroup(layout.createSequentialGroup()
				.addComponent(toggleMusic, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addComponent(toggleAi, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				.addComponent(btnAccelerate, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addComponent(btnBrake, GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addComponent(toggleSuperSonic, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
				.addGap(30, 30, 30).addComponent(btnUp, GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(btnLeft, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
					.addComponent(btnRight, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addComponent(btnDown, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
			.addGroup(layout.createSequentialGroup()
				.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addComponent(lblSpeed, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addComponent(progressBar, GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE))
			.addComponent(separator, GroupLayout.DEFAULT_SIZE, 635, Short.MAX_VALUE)).addContainerGap()));

	pack();
    }

    private void JTBN_AIActionPerformed(ActionEvent evt) {

	sonic.setAi(toggleAi.isSelected());
    }

    private void BTN_AcelerarActionPerformed(ActionEvent evt) {

	if (sonic.isAi()) {
	    sonic.setAction(Action.SPEEDUP);
	}
    }

    private void JTB_MusicaActionPerformed(ActionEvent evt) {

	music.setOn(toggleMusic.isSelected());
    }

    private void JTBN_SuperSonicActionPerformed(ActionEvent evt) {

	if (toggleSuperSonic.isSelected()) {
	    sonic.setSuperSonic(true);
	} else {
	    sonic.setSuperSonic(false);
	}
    }

    private void BTN_FreiarActionPerformed(ActionEvent evt) {

	if (sonic.isAi()) {
	    sonic.setAction(Action.BRAKEUP);
	}
    }

    @Override
    public void run() {

	JButton[] btns = { btnAccelerate, btnBrake };

	while (this.isVisible()) {

	    if (sonic != null)		

		doUpdateSpeed((int) sonic.getSpeed());
	    	
	    	doRefreshComponent();

	    	doControlButtons(sonic.isAi(), btns);
	   
	}
    }

    private void doUpdateSpeed(int speed) {

	progressBar.setValue(speed);

	lblSpeed.setText(String.valueOf(speed));

    }

    @Override
    public void update(Observable o, Object arg) {

	if (o instanceof Physicable) {
	    
	}

    }

}
