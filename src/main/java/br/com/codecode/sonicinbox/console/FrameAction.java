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
import br.com.codecode.sonicinbox.enumeration.Action;
import br.com.codecode.sonicinbox.enumeration.ConfigEngine;
import br.com.codecode.sonicinbox.motion.Sonic;
import br.com.codecode.sonicinbox.util.Size;


public class FrameAction extends JFrame implements Runnable {

	private static final long serialVersionUID = 1370653725906464274L;    

	private JButton BTN_Acelerar;

	private JButton BTN_Freiar;
	
	public static JButton BTN_Down;	

	public static JButton BTN_Left;

	public static JButton BTN_Right;

	public static JButton BTN_Up;

	private JLabel JL_Titulo, JL_Velocidade;

	private JProgressBar JPB_Velocidade;

	private JToggleButton JTBN_AI, JTBN_SuperSonic, JTB_Musica;

	private JSeparator jSeparator2;	

	private Sonic sonic;

	private Music music;	
	
	private Thread t;

	private FrameAction() {
		
		System.out.println("FrameAction.FrameAction()");
		
		t = new Thread(this);
		
		initComponents();
		
		super.setLocationRelativeTo(null);

		super.setLocation((Size.MAX_WIDTH - getWidth()), 0);
		
		super.setVisible(true);
		
		t.start();
	}

	public FrameAction(Engine engine){		
		this();
		this.sonic = engine.sonic;
		this.music = engine.music;		

		super.addKeyListener(engine.event);	
		
	}

	private void doControlButtons(boolean ai) {

		JButton[] btns = {BTN_Acelerar, BTN_Freiar};

		for (JButton btn : btns) {
			btn.setEnabled(ai);
		}

	}

	private void doRefreshComponent() {

		JPB_Velocidade.setValue((int) sonic.getSpeed());

		JL_Velocidade.setText(String.valueOf(sonic.getSpeed()));

		JTBN_SuperSonic.setSelected(sonic.isSuperSonic());

		JTBN_AI.setSelected(sonic.isAi());

		JTB_Musica.setSelected(music.isOn());
	}

	private void initComponents() {

		BTN_Acelerar = new javax.swing.JButton();

		JTBN_AI = new javax.swing.JToggleButton();

		BTN_Left = new javax.swing.JButton();

		BTN_Down = new javax.swing.JButton();

		BTN_Right = new javax.swing.JButton();

		BTN_Up = new javax.swing.JButton();

		JTB_Musica = new javax.swing.JToggleButton();

		JTBN_SuperSonic = new javax.swing.JToggleButton();

		BTN_Freiar = new javax.swing.JButton();

		JPB_Velocidade = new javax.swing.JProgressBar();

		JL_Velocidade = new javax.swing.JLabel();

		JL_Titulo = new javax.swing.JLabel();

		jSeparator2 = new javax.swing.JSeparator();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		setTitle("Console Ação");

		setAlwaysOnTop(true);

		setLocation(new java.awt.Point(1347, 0));

		setResizable(false);

		BTN_Acelerar.setFont(new java.awt.Font("Tahoma", 1, 14));

		BTN_Acelerar.setForeground(new java.awt.Color(0, 0, 255));

		BTN_Acelerar.setText("Acelerar");

		BTN_Acelerar.setFocusable(false);

		BTN_Acelerar.setRequestFocusEnabled(false);

		BTN_Acelerar.setVerifyInputWhenFocusTarget(false);

		BTN_Acelerar.addActionListener((evt) -> {
			BTN_AcelerarActionPerformed(evt);

		});

		JTBN_AI.setFont(new java.awt.Font("Tahoma", 1, 14));

		JTBN_AI.setForeground(new java.awt.Color(255, 0, 102));

		JTBN_AI.setText("A.I.");

		JTBN_AI.setFocusable(false);

		JTBN_AI.setRequestFocusEnabled(false);

		JTBN_AI.setVerifyInputWhenFocusTarget(false);

		JTBN_AI.addActionListener((evt) -> {
			JTBN_AIActionPerformed(evt);

		});

		BTN_Left.setFont(new java.awt.Font("Tahoma", 1, 9));

		BTN_Left.setText("RIGHT");

		BTN_Left.setEnabled(false);

		BTN_Left.setFocusable(false);

		BTN_Left.setRequestFocusEnabled(false);

		BTN_Left.setVerifyInputWhenFocusTarget(false);

		BTN_Down.setFont(new java.awt.Font("Tahoma", 1, 9));

		BTN_Down.setText("DOWN");

		BTN_Down.setEnabled(false);

		BTN_Down.setFocusable(false);

		BTN_Down.setRequestFocusEnabled(false);

		BTN_Down.setVerifyInputWhenFocusTarget(false);

		BTN_Right.setFont(new java.awt.Font("Tahoma", 1, 9));

		BTN_Right.setText("LEFT");

		BTN_Right.setEnabled(false);

		BTN_Right.setFocusable(false);

		BTN_Right.setRequestFocusEnabled(false);

		BTN_Right.setVerifyInputWhenFocusTarget(false);

		BTN_Up.setFont(new java.awt.Font("Tahoma", 1, 9));

		BTN_Up.setText("UP");

		BTN_Up.setEnabled(false);

		BTN_Up.setFocusable(false);

		BTN_Up.setRequestFocusEnabled(false);

		BTN_Up.setVerifyInputWhenFocusTarget(false);

		JTB_Musica.setFont(new java.awt.Font("Tahoma", 1, 14));

		JTB_Musica.setForeground(new java.awt.Color(204, 0, 204));

		JTB_Musica.setText("Música");

		JTB_Musica.setFocusable(false);

		JTB_Musica.setRequestFocusEnabled(false);

		JTB_Musica.setVerifyInputWhenFocusTarget(false);

		JTB_Musica.addActionListener((evt) -> {
			JTB_MusicaActionPerformed(evt);

		});

		JTBN_SuperSonic.setFont(new java.awt.Font("Tahoma", 1, 14));

		JTBN_SuperSonic.setForeground(new java.awt.Color(255, 204, 0));

		JTBN_SuperSonic.setText("Super Sonic");

		JTBN_SuperSonic.setFocusable(false);

		JTBN_SuperSonic.setOpaque(true);

		JTBN_SuperSonic.setRequestFocusEnabled(false);

		JTBN_SuperSonic.setVerifyInputWhenFocusTarget(false);

		JTBN_SuperSonic.addActionListener((evt) -> {
			JTBN_SuperSonicActionPerformed(evt);

		});

		BTN_Freiar.setFont(new java.awt.Font("Tahoma", 1, 14));

		BTN_Freiar.setForeground(new java.awt.Color(0, 0, 255));

		BTN_Freiar.setText("Freiar");

		BTN_Freiar.setFocusable(false);

		BTN_Freiar.setRequestFocusEnabled(false);

		BTN_Freiar.setVerifyInputWhenFocusTarget(false);

		BTN_Freiar.addActionListener((evt) -> {
			BTN_FreiarActionPerformed(evt);

		});

		JPB_Velocidade.setMaximum(130000);

		JPB_Velocidade.setOrientation(1);

		JPB_Velocidade.setFocusable(false);

		JL_Velocidade.setFont(new java.awt.Font("Tahoma", 0, 10));

		JL_Velocidade.setForeground(new java.awt.Color(0, 204, 255));

		JL_Velocidade.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

		JL_Titulo.setFont(new java.awt.Font("Tahoma", 1, 9));

		JL_Titulo.setForeground(new java.awt.Color(51, 51, 255));

		JL_Titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

		JL_Titulo.setText("Velocidade");

		jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(JTBN_AI, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
								.addComponent(JTB_Musica, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
								.addComponent(BTN_Acelerar, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
								.addComponent(BTN_Freiar, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
								.addComponent(JTBN_SuperSonic, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
								.addGroup(layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(layout.createSequentialGroup()
														.addComponent(BTN_Left, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addGap(5, 5, 5)
														.addComponent(BTN_Right, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE))
												.addComponent(BTN_Up, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
												.addComponent(BTN_Down, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
										.addGap(2, 2, 2)))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jSeparator2)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(JL_Velocidade, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(JPB_Velocidade, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(JL_Titulo, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))
						.addGap(25, 25, 25))
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addComponent(JTB_Musica, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(JTBN_AI, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(BTN_Acelerar, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(BTN_Freiar, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(JTBN_SuperSonic, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
										.addGap(30, 30, 30)
										.addComponent(BTN_Up, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(BTN_Left, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(BTN_Right, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(BTN_Down, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
								.addGroup(layout.createSequentialGroup()
										.addComponent(JL_Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(JL_Velocidade, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(JPB_Velocidade, javax.swing.GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE))
								.addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 635, Short.MAX_VALUE))
						.addContainerGap())
				);

		pack();
	}

	private void JTBN_AIActionPerformed(ActionEvent evt) {
		sonic.setAi(JTBN_AI.isSelected());
	}

	private void BTN_AcelerarActionPerformed(ActionEvent evt) {
		if (sonic.isAi()) {
			sonic.setAction(Action.SPEEDUP);
		}
	}

	private void JTB_MusicaActionPerformed(ActionEvent evt) {
		music.setOn(JTB_Musica.isSelected());
	}

	private void JTBN_SuperSonicActionPerformed(ActionEvent evt) {
		if (JTBN_SuperSonic.isSelected()) {
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

				throw new RuntimeException("Falha ao Interromper " , ex);

			}
		}
	}
	
}
