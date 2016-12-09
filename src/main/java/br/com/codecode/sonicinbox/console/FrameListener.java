package br.com.codecode.sonicinbox.console;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.WindowConstants;

import br.com.codecode.sonicinbox.engine.Engine;
import br.com.codecode.sonicinbox.enumeration.ConfigEngine;
import br.com.codecode.sonicinbox.motion.Sonic;
import br.com.codecode.sonicinbox.util.Size;

public class FrameListener extends JFrame implements Runnable {

	private static final long serialVersionUID = -8266452496408906017L;	

	private JProgressBar JPB_Aceleracao;

	private JLabel LBL_Aceleracao, jLabel1;    

	private Sonic sonic;	

	private FrameListener() {    	

		System.out.println("FrameListener.FrameListener()");

		initComponents();		

		super.setLocationRelativeTo(null);

		super.setLocation((Size.MAX_WIDTH - getWidth()) / 2, (Size.MAX_HEIGHT - getHeight()));
		
		super.setVisible(true);

	}

	public FrameListener(Engine engine){		
		this();		
		this.sonic = engine.sonic;	

		super.addKeyListener(engine.event);		
		
	}

	private void initComponents() {

		JPB_Aceleracao = new JProgressBar();

		jLabel1 = new JLabel();

		LBL_Aceleracao = new JLabel();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		setTitle("Console Key Listener ");

		setAlwaysOnTop(true);

		setLocation(new java.awt.Point(0, 0));

		setResizable(false);

		JPB_Aceleracao.setMaximum(2000);

		JPB_Aceleracao.setFocusable(false);

		JPB_Aceleracao.setStringPainted(true);

		jLabel1.setFont(new java.awt.Font("Tahoma", 1, 9)); 

		jLabel1.setForeground(new java.awt.Color(0, 51, 255));

		jLabel1.setText("Aceleração");

		LBL_Aceleracao.setFont(new java.awt.Font("Tahoma", 0, 9));

		LBL_Aceleracao.setForeground(new java.awt.Color(0, 204, 255));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());

		getContentPane().setLayout(layout);

		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(JPB_Aceleracao, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addGroup(layout.createSequentialGroup()
						.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(LBL_Aceleracao, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
				);

		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(LBL_Aceleracao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(JPB_Aceleracao, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
				);

		pack();
	}


	private void doRefreshComponents() {

		JPB_Aceleracao.setValue((int) sonic.getAcceleration());

		LBL_Aceleracao.setText(String.valueOf(sonic.getAcceleration()));
	}

	@Override
	public void run() {

		while (true) {
			
			if (sonic != null){
				doRefreshComponents();
			}		

			try {

				Thread.sleep(ConfigEngine.FPS.getValue());

			} catch (InterruptedException ex) {

				throw new RuntimeException("Falha ao Interromper " + ex.getMessage());
			}

		}
	}
}
