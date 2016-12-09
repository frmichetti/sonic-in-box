/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see mailto:frmichetti@gmail.com
 * */
package br.com.codecode.sonicinbox.console;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JSeparator;
import javax.swing.JToggleButton;

import br.com.codecode.sonicinbox.engine.Engine;
import br.com.codecode.sonicinbox.engine.Music;
import br.com.codecode.sonicinbox.enums.Action;
import br.com.codecode.sonicinbox.enums.ConfigEngine;
import br.com.codecode.sonicinbox.motion.Sonic;
import br.com.codecode.sonicinbox.util.Size;


public final class FrameAction extends JFrame implements Runnable {

	private static final long serialVersionUID = 1370653725906464274L;    

	private JButton btnAccelerate;

	private JButton btnBrake;
	
	public static JButton btnDown;	

	public static JButton btnLeft;

	public static JButton btnRight;

	public static JButton btnUp;

	private JLabel lblTitle, lblSpeed;

	private JProgressBar progressBar;

	private JToggleButton toggleAi, toggleSuperSonic, toggleMusic;

	private JSeparator separator;	

	private Sonic sonic;

	private Music music;	
	
	private Thread thread;

	private FrameAction() {
		
		System.out.println("FrameAction.FrameAction()");
		
		thread = new Thread(this);
		
		initComponents();
		
		super.setLocationRelativeTo(null);

		super.setLocation((Size.MAX_WIDTH - getWidth()), 0);
		
		super.setVisible(true);
		
		thread.start();
	}

	public FrameAction(Engine engine){		
		this();
		this.sonic = engine.sonic;
		this.music = engine.music;		

		super.addKeyListener(engine.event);	
		
	}

	private void doControlButtons(boolean ai) {

		JButton[] btns = {btnAccelerate, btnBrake};

		for (JButton btn : btns) {
			btn.setEnabled(ai);
		}

	}

	private void doRefreshComponent() {

		progressBar.setValue((int) sonic.getSpeed());

		lblSpeed.setText(String.valueOf(sonic.getSpeed()));

		toggleSuperSonic.setSelected(sonic.isSuperSonic());

		toggleAi.setSelected(sonic.isAi());

		toggleMusic.setSelected(music.isOn());
	}

	private void initComponents() {

		btnAccelerate = new javax.swing.JButton();

		toggleAi = new javax.swing.JToggleButton();

		btnLeft = new javax.swing.JButton();

		btnDown = new javax.swing.JButton();

		btnRight = new javax.swing.JButton();

		btnUp = new javax.swing.JButton();

		toggleMusic = new javax.swing.JToggleButton();

		toggleSuperSonic = new javax.swing.JToggleButton();

		btnBrake = new javax.swing.JButton();

		progressBar = new javax.swing.JProgressBar();

		lblSpeed = new javax.swing.JLabel();

		lblTitle = new javax.swing.JLabel();

		separator = new javax.swing.JSeparator();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		setTitle("Action Console");

		setAlwaysOnTop(true);

		setLocation(new java.awt.Point(1347, 0));

		setResizable(false);

		btnAccelerate.setFont(new java.awt.Font("Tahoma", 1, 14));

		btnAccelerate.setForeground(new java.awt.Color(0, 0, 255));

		btnAccelerate.setText("Acelerar");

		btnAccelerate.setFocusable(false);

		btnAccelerate.setRequestFocusEnabled(false);

		btnAccelerate.setVerifyInputWhenFocusTarget(false);

		btnAccelerate.addActionListener((evt) -> {
			BTN_AcelerarActionPerformed(evt);

		});

		toggleAi.setFont(new java.awt.Font("Tahoma", 1, 14));

		toggleAi.setForeground(new java.awt.Color(255, 0, 102));

		toggleAi.setText("A.I.");

		toggleAi.setFocusable(false);

		toggleAi.setRequestFocusEnabled(false);

		toggleAi.setVerifyInputWhenFocusTarget(false);

		toggleAi.addActionListener((evt) -> {
			JTBN_AIActionPerformed(evt);

		});

		btnLeft.setFont(new java.awt.Font("Tahoma", 1, 9));

		btnLeft.setText("RIGHT");

		btnLeft.setEnabled(false);

		btnLeft.setFocusable(false);

		btnLeft.setRequestFocusEnabled(false);

		btnLeft.setVerifyInputWhenFocusTarget(false);

		btnDown.setFont(new java.awt.Font("Tahoma", 1, 9));

		btnDown.setText("DOWN");

		btnDown.setEnabled(false);

		btnDown.setFocusable(false);

		btnDown.setRequestFocusEnabled(false);

		btnDown.setVerifyInputWhenFocusTarget(false);

		btnRight.setFont(new java.awt.Font("Tahoma", 1, 9));

		btnRight.setText("LEFT");

		btnRight.setEnabled(false);

		btnRight.setFocusable(false);

		btnRight.setRequestFocusEnabled(false);

		btnRight.setVerifyInputWhenFocusTarget(false);

		btnUp.setFont(new java.awt.Font("Tahoma", 1, 9));

		btnUp.setText("UP");

		btnUp.setEnabled(false);

		btnUp.setFocusable(false);

		btnUp.setRequestFocusEnabled(false);

		btnUp.setVerifyInputWhenFocusTarget(false);

		toggleMusic.setFont(new java.awt.Font("Tahoma", 1, 14));

		toggleMusic.setForeground(new java.awt.Color(204, 0, 204));

		toggleMusic.setText("Música");

		toggleMusic.setFocusable(false);

		toggleMusic.setRequestFocusEnabled(false);

		toggleMusic.setVerifyInputWhenFocusTarget(false);

		toggleMusic.addActionListener((evt) -> {
			JTB_MusicaActionPerformed(evt);

		});

		toggleSuperSonic.setFont(new java.awt.Font("Tahoma", 1, 14));

		toggleSuperSonic.setForeground(new java.awt.Color(255, 204, 0));

		toggleSuperSonic.setText("Super Sonic");

		toggleSuperSonic.setFocusable(false);

		toggleSuperSonic.setOpaque(true);

		toggleSuperSonic.setRequestFocusEnabled(false);

		toggleSuperSonic.setVerifyInputWhenFocusTarget(false);

		toggleSuperSonic.addActionListener((evt) -> {
			JTBN_SuperSonicActionPerformed(evt);

		});

		btnBrake.setFont(new java.awt.Font("Tahoma", 1, 14));

		btnBrake.setForeground(new java.awt.Color(0, 0, 255));

		btnBrake.setText("Freiar");

		btnBrake.setFocusable(false);

		btnBrake.setRequestFocusEnabled(false);

		btnBrake.setVerifyInputWhenFocusTarget(false);

		btnBrake.addActionListener((evt) -> {
			BTN_FreiarActionPerformed(evt);

		});

		progressBar.setMaximum(130000);

		progressBar.setOrientation(1);

		progressBar.setFocusable(false);

		lblSpeed.setFont(new java.awt.Font("Tahoma", 0, 10));

		lblSpeed.setForeground(new java.awt.Color(0, 204, 255));

		lblSpeed.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

		lblTitle.setFont(new java.awt.Font("Tahoma", 1, 9));

		lblTitle.setForeground(new java.awt.Color(51, 51, 255));

		lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

		lblTitle.setText("Velocidade");

		separator.setOrientation(javax.swing.SwingConstants.VERTICAL);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(toggleAi, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
								.addComponent(toggleMusic, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
								.addComponent(btnAccelerate, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
								.addComponent(btnBrake, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
								.addComponent(toggleSuperSonic, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
								.addGroup(layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(layout.createSequentialGroup()
														.addComponent(btnLeft, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addGap(5, 5, 5)
														.addComponent(btnRight, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE))
												.addComponent(btnUp, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
												.addComponent(btnDown, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
										.addGap(2, 2, 2)))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(separator)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(lblSpeed, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(progressBar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))
						.addGap(25, 25, 25))
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addComponent(toggleMusic, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(toggleAi, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(btnAccelerate, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(btnBrake, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(toggleSuperSonic, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
										.addGap(30, 30, 30)
										.addComponent(btnUp, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(btnLeft, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(btnRight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(btnDown, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
								.addGroup(layout.createSequentialGroup()
										.addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(lblSpeed, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(progressBar, javax.swing.GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE))
								.addComponent(separator, javax.swing.GroupLayout.DEFAULT_SIZE, 635, Short.MAX_VALUE))
						.addContainerGap())
				);

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
		
		while (true) {
			
			if(sonic != null){
				
				doRefreshComponent();

				doControlButtons(sonic.isAi());
			}			

			try {

				Thread.sleep(ConfigEngine.FPS.getValue());

			} catch (InterruptedException ex) {

				throw new RuntimeException(ex);

			}
		}
	}
	
}
