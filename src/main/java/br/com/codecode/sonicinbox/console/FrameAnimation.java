package br.com.codecode.sonicinbox.console;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JButton;

import br.com.codecode.sonicinbox.engine.Engine;
import br.com.codecode.sonicinbox.enumeration.ConfigEngine;
import br.com.codecode.sonicinbox.enumeration.Orientation;
import br.com.codecode.sonicinbox.motion.Sonic;

public final class FrameAnimation extends javax.swing.JFrame implements Runnable {

	private static final long serialVersionUID = -7339748933268786433L;	

	private JButton BTN_Abaixado, BTN_Abaixar, BTN_Andar0, BTN_Andar1,
	BTN_Andar2, BTN_Andar3, BTN_Andar4, BTN_Andar5, BTN_Andar6, BTN_Andar7, BTN_Correr0,
	BTN_Correr1, BTN_Correr2, BTN_Correr3, BTN_Correr4, BTN_Correr5, BTN_Correr6, BTN_Correr7,
	BTN_Dash0, BTN_Dash1, BTN_Dash2, BTN_Dash3, BTN_Dash4, BTN_Dash5, BTN_Dash6, BTN_Dash7,
	BTN_Direita, BTN_Empurrando, BTN_Esperar, BTN_Esquerda, BTN_Freiando, BTN_Girar0, BTN_Girar1,
	BTN_Girar2, BTN_Girar3, BTN_Girar4, BTN_Girar5, BTN_Girar6, BTN_Girar7, BTN_Olhando, BTN_Olhar,
	BTN_Parar, BTN_Transformar;

	private javax.swing.JPanel JP_Acao, JP_Andar, JP_Correr, JP_Dash, JP_Girar, JP_Orientacao;

	private javax.swing.JSlider JSLD_VelAnimacao;	

	private Sonic sonic;

	private FrameAnimation() {		

		System.out.println("FrameAnimation.FrameAnimation()");

		super.setVisible(true);

		super.addKeyListener(Engine.event);

		initComponents();

		super.setLocationRelativeTo(null);

		super.setLocation(0, 0);

	}

	public FrameAnimation(Sonic sonic){
		this();
		this.sonic = sonic;
	}

	private void doControlButtons(boolean ai) {

		JButton[] btns = {BTN_Abaixar, BTN_Abaixado, BTN_Olhar, BTN_Olhando,
				BTN_Parar, BTN_Esperar, BTN_Empurrando, BTN_Transformar, BTN_Freiando,
				BTN_Dash0, BTN_Dash1, BTN_Dash2, BTN_Dash3, BTN_Dash4, BTN_Dash5, BTN_Dash6, BTN_Dash7,
				BTN_Andar0, BTN_Andar1, BTN_Andar2, BTN_Andar3, BTN_Andar4, BTN_Andar5, BTN_Andar6, BTN_Andar7,
				BTN_Correr0, BTN_Correr1, BTN_Correr2, BTN_Correr3, BTN_Correr4, BTN_Correr5, BTN_Correr6, BTN_Correr7,
				BTN_Girar0, BTN_Girar1, BTN_Girar2, BTN_Girar3, BTN_Girar4, BTN_Girar5, BTN_Girar6, BTN_Girar7};

		for (JButton jb : btns) {

			jb.setEnabled(!ai);
		}

		JSLD_VelAnimacao.setEnabled(!ai);
	}

	private void doRefreshComponents() {

		if (sonic.getOrientation() == Orientation.RIGHT) {

			BTN_Direita.setVisible(false);

			BTN_Esquerda.setVisible(true);

		} else {

			BTN_Direita.setVisible(true);

			BTN_Esquerda.setVisible(false);
		}

		if (sonic.isAi()) {

			JSLD_VelAnimacao.setValue(sonic.getAnimeSpeed());
		}
	}

	private void initComponents() {

		JP_Correr = new javax.swing.JPanel();

		BTN_Correr0 = new JButton();

		BTN_Correr1 = new JButton();

		BTN_Correr2 = new JButton();

		BTN_Correr3 = new JButton();

		BTN_Correr4 = new JButton();

		BTN_Correr5 = new JButton();

		BTN_Correr6 = new JButton();

		BTN_Correr7 = new JButton();

		JP_Andar = new javax.swing.JPanel();

		BTN_Andar0 = new JButton();

		BTN_Andar1 = new JButton();

		BTN_Andar2 = new JButton();

		BTN_Andar3 = new JButton();

		BTN_Andar4 = new JButton();

		BTN_Andar5 = new JButton();

		BTN_Andar6 = new JButton();

		BTN_Andar7 = new JButton();

		JP_Girar = new javax.swing.JPanel();

		BTN_Girar0 = new JButton();

		BTN_Girar1 = new JButton();

		BTN_Girar2 = new JButton();

		BTN_Girar3 = new JButton();

		BTN_Girar4 = new JButton();

		BTN_Girar5 = new JButton();

		BTN_Girar6 = new JButton();

		BTN_Girar7 = new JButton();

		JP_Dash = new javax.swing.JPanel();

		BTN_Dash0 = new JButton();

		BTN_Dash1 = new JButton();

		BTN_Dash2 = new JButton();

		BTN_Dash3 = new JButton();

		BTN_Dash4 = new JButton();

		BTN_Dash5 = new JButton();

		BTN_Dash6 = new JButton();

		BTN_Dash7 = new JButton();

		JP_Acao = new javax.swing.JPanel();

		BTN_Parar = new JButton();

		BTN_Esperar = new JButton();

		BTN_Transformar = new JButton();

		BTN_Abaixar = new JButton();

		BTN_Abaixado = new JButton();

		BTN_Empurrando = new JButton();

		BTN_Olhar = new JButton();

		BTN_Olhando = new JButton();

		BTN_Freiando = new JButton();

		JP_Orientacao = new javax.swing.JPanel();

		BTN_Esquerda = new JButton();

		BTN_Direita = new JButton();

		JSLD_VelAnimacao = new javax.swing.JSlider();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		setTitle("Console Animação");

		setAlwaysOnTop(true);

		setResizable(false);

		JP_Correr.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Correr", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

		JP_Correr.setForeground(Color.blue);

		JP_Correr.setDoubleBuffered(false);

		JP_Correr.setEnabled(false);

		JP_Correr.setFocusable(false);

		JP_Correr.setMinimumSize(new java.awt.Dimension(0, 0));

		JP_Correr.setPreferredSize(new java.awt.Dimension(0, 0));

		JP_Correr.setRequestFocusEnabled(false);

		JP_Correr.setVerifyInputWhenFocusTarget(false);

		JP_Correr.setLayout(new java.awt.GridLayout(1, 0));

		BTN_Correr0.setForeground(new java.awt.Color(255, 51, 102));

		BTN_Correr0.setText("0");

		BTN_Correr0.addActionListener((evt) -> {
				BTN_Correr0ActionPerformed(evt);			
		});

		JP_Correr.add(BTN_Correr0);

		BTN_Correr1.setForeground(new java.awt.Color(255, 51, 102));

		BTN_Correr1.setText("1");

		BTN_Correr1.addActionListener((evt) -> {
				BTN_Correr1ActionPerformed(evt);
			
		});

		JP_Correr.add(BTN_Correr1);

		BTN_Correr2.setForeground(new java.awt.Color(255, 51, 102));

		BTN_Correr2.setText("2");

		BTN_Correr2.addActionListener((evt) -> {
				BTN_Correr2ActionPerformed(evt);
			
		});

		JP_Correr.add(BTN_Correr2);

		BTN_Correr3.setForeground(new java.awt.Color(255, 51, 102));
		
		BTN_Correr3.setText("3");
		
		BTN_Correr3.addActionListener((evt) -> {
				BTN_Correr3ActionPerformed(evt);
			
		});
		
		JP_Correr.add(BTN_Correr3);

		BTN_Correr4.setForeground(new java.awt.Color(0, 0, 255));
		BTN_Correr4.setText("4");
		
		BTN_Correr4.addActionListener((evt) -> {
				BTN_Correr4ActionPerformed(evt);			
		});
		
		JP_Correr.add(BTN_Correr4);

		BTN_Correr5.setForeground(new java.awt.Color(0, 0, 255));

		BTN_Correr5.setText("5");

		BTN_Correr5.addActionListener((evt) -> {
				BTN_Correr5ActionPerformed(evt);			
		});
		
		JP_Correr.add(BTN_Correr5);

		BTN_Correr6.setForeground(new java.awt.Color(51, 204, 0));

		BTN_Correr6.setText("6");

		BTN_Correr6.addActionListener((evt) -> {
				BTN_Correr6ActionPerformed(evt);			
		});
		
		JP_Correr.add(BTN_Correr6);

		BTN_Correr7.setForeground(new java.awt.Color(51, 204, 0));

		BTN_Correr7.setText("7");

		BTN_Correr7.addActionListener((evt) -> {
				BTN_Correr7ActionPerformed(evt);			
		});
		
		JP_Correr.add(BTN_Correr7);

		JP_Andar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Andar", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

		JP_Andar.setForeground(java.awt.Color.blue);

		JP_Andar.setDoubleBuffered(false);

		JP_Andar.setEnabled(false);

		JP_Andar.setFocusable(false);

		JP_Andar.setMinimumSize(new java.awt.Dimension(0, 0));

		JP_Andar.setPreferredSize(new java.awt.Dimension(0, 0));

		JP_Andar.setRequestFocusEnabled(false);

		JP_Andar.setVerifyInputWhenFocusTarget(false);

		JP_Andar.setLayout(new java.awt.GridLayout(1, 0));

		BTN_Andar0.setForeground(new java.awt.Color(255, 51, 102));

		BTN_Andar0.setText("0");

		BTN_Andar0.addActionListener((evt) -> {
				BTN_Andar0ActionPerformed(evt);			
		});
		
		JP_Andar.add(BTN_Andar0);

		BTN_Andar1.setForeground(new java.awt.Color(255, 51, 102));
		BTN_Andar1.setText("1");
		
		BTN_Andar1.addActionListener((evt) -> {
				BTN_Andar1ActionPerformed(evt);			
		});
		
		JP_Andar.add(BTN_Andar1);

		BTN_Andar2.setForeground(new java.awt.Color(255, 51, 102));

		BTN_Andar2.setText("2");

		BTN_Andar2.addActionListener((evt) -> {
				BTN_Andar2ActionPerformed(evt);			
		});
		
		JP_Andar.add(BTN_Andar2);

		BTN_Andar3.setForeground(new java.awt.Color(255, 51, 102));

		BTN_Andar3.setText("3");

		BTN_Andar3.addActionListener((evt) -> {
			BTN_Andar3ActionPerformed(evt);
		});

		JP_Andar.add(BTN_Andar3);

		BTN_Andar4.setForeground(new java.awt.Color(0, 0, 255));

		BTN_Andar4.setText("4");

		BTN_Andar4.addActionListener((evt) -> {
			BTN_Andar4ActionPerformed(evt);

		});

		JP_Andar.add(BTN_Andar4);

		BTN_Andar5.setForeground(new java.awt.Color(0, 0, 255));

		BTN_Andar5.setText("5");

		BTN_Andar5.addActionListener((evt) -> {
			BTN_Andar5ActionPerformed(evt);			
		});

		JP_Andar.add(BTN_Andar5);

		BTN_Andar6.setForeground(new java.awt.Color(51, 204, 0));

		BTN_Andar6.setText("6");

		BTN_Andar6.addActionListener((evt) -> {  
			BTN_Andar6ActionPerformed(evt);			
		});

		JP_Andar.add(BTN_Andar6);

		BTN_Andar7.setForeground(new java.awt.Color(51, 204, 0));

		BTN_Andar7.setText("7");

		BTN_Andar7.addActionListener((evt) -> {
			BTN_Andar7ActionPerformed(evt);			
		});

		JP_Andar.add(BTN_Andar7);

		JP_Girar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Girar", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

		JP_Girar.setForeground(java.awt.Color.blue);

		JP_Girar.setDoubleBuffered(false);

		JP_Girar.setEnabled(false);

		JP_Girar.setFocusable(false);

		JP_Girar.setMinimumSize(new java.awt.Dimension(0, 0));

		JP_Girar.setPreferredSize(new java.awt.Dimension(0, 0));

		JP_Girar.setRequestFocusEnabled(false);

		JP_Girar.setVerifyInputWhenFocusTarget(false);

		JP_Girar.setLayout(new java.awt.GridLayout(1, 0));

		BTN_Girar0.setForeground(new java.awt.Color(255, 51, 102));

		BTN_Girar0.setText("0");

		BTN_Girar0.addActionListener((evt) -> {
			BTN_Girar0ActionPerformed(evt);			
		});

		JP_Girar.add(BTN_Girar0);

		BTN_Girar1.setForeground(new java.awt.Color(255, 51, 102));

		BTN_Girar1.setText("1");

		BTN_Girar1.addActionListener((evt) -> {
			BTN_Girar1ActionPerformed(evt);			
		});

		JP_Girar.add(BTN_Girar1);

		BTN_Girar2.setForeground(new java.awt.Color(255, 51, 102));

		BTN_Girar2.setText("2");

		BTN_Girar2.addActionListener((evt) -> {
			BTN_Girar2ActionPerformed(evt);			
		});

		JP_Girar.add(BTN_Girar2);

		BTN_Girar3.setForeground(new java.awt.Color(255, 51, 102));

		BTN_Girar3.setText("3");

		BTN_Girar3.addActionListener((evt) -> {
			BTN_Girar3ActionPerformed(evt);			
		});

		JP_Girar.add(BTN_Girar3);

		BTN_Girar4.setForeground(new java.awt.Color(0, 0, 255));

		BTN_Girar4.setText("4");

		BTN_Girar4.addActionListener((evt) -> {
			BTN_Girar4ActionPerformed(evt);			
		});

		JP_Girar.add(BTN_Girar4);

		BTN_Girar5.setForeground(new java.awt.Color(0, 0, 255));

		BTN_Girar5.setText("5");

		BTN_Girar5.addActionListener((evt) -> {
			BTN_Girar5ActionPerformed(evt);			
		});

		JP_Girar.add(BTN_Girar5);

		BTN_Girar6.setForeground(new java.awt.Color(51, 204, 0));

		BTN_Girar6.setText("6");

		BTN_Girar6.addActionListener((evt) -> {
			BTN_Girar6ActionPerformed(evt);			
		});

		JP_Girar.add(BTN_Girar6);

		BTN_Girar7.setForeground(new java.awt.Color(51, 204, 0));
		BTN_Girar7.setText("7");

		BTN_Girar7.addActionListener((evt) -> {
			BTN_Girar7ActionPerformed(evt);			
		});

		JP_Girar.add(BTN_Girar7);

		JP_Dash.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dash", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

		JP_Dash.setForeground(java.awt.Color.blue);

		JP_Dash.setDoubleBuffered(false);

		JP_Dash.setEnabled(false);

		JP_Dash.setFocusable(false);

		JP_Dash.setMinimumSize(new java.awt.Dimension(0, 0));

		JP_Dash.setPreferredSize(new java.awt.Dimension(0, 0));

		JP_Dash.setRequestFocusEnabled(false);

		JP_Dash.setVerifyInputWhenFocusTarget(false);

		JP_Dash.setLayout(new java.awt.GridLayout(1, 0));

		BTN_Dash0.setForeground(new java.awt.Color(255, 51, 102));

		BTN_Dash0.setText("0");

		BTN_Dash0.addActionListener((evt) -> {
			BTN_Dash0ActionPerformed(evt);			
		});

		JP_Dash.add(BTN_Dash0);

		BTN_Dash1.setForeground(new java.awt.Color(255, 51, 102));

		BTN_Dash1.setText("1");

		BTN_Dash1.addActionListener((evt) -> {
			BTN_Dash1ActionPerformed(evt);			
		});

		JP_Dash.add(BTN_Dash1);

		BTN_Dash2.setForeground(new java.awt.Color(255, 51, 102));

		BTN_Dash2.setText("2");

		BTN_Dash2.addActionListener((evt) -> {
			BTN_Dash2ActionPerformed(evt);			
		});

		JP_Dash.add(BTN_Dash2);

		BTN_Dash3.setForeground(new java.awt.Color(255, 51, 102));

		BTN_Dash3.setText("3");

		BTN_Dash3.addActionListener((evt) -> {
				BTN_Dash3ActionPerformed(evt);			
		});

		JP_Dash.add(BTN_Dash3);

		BTN_Dash4.setForeground(new java.awt.Color(0, 0, 255));

		BTN_Dash4.setText("4");

		BTN_Dash4.addActionListener((evt) -> {
				BTN_Dash4ActionPerformed(evt);			
		});
		
		JP_Dash.add(BTN_Dash4);

		BTN_Dash5.setForeground(new java.awt.Color(0, 0, 255));

		BTN_Dash5.setText("5");

		BTN_Dash5.addActionListener((evt) -> {
				BTN_Dash5ActionPerformed(evt);			
		});

		JP_Dash.add(BTN_Dash5);

		BTN_Dash6.setForeground(new java.awt.Color(51, 204, 0));

		BTN_Dash6.setText("6");

		BTN_Dash6.addActionListener((evt) -> {
				BTN_Dash6ActionPerformed(evt);			
		});

		JP_Dash.add(BTN_Dash6);

		BTN_Dash7.setForeground(new java.awt.Color(51, 204, 0));

		BTN_Dash7.setText("7");

		BTN_Dash7.addActionListener((evt) -> {
				BTN_Dash7ActionPerformed(evt);			
		});

		JP_Dash.add(BTN_Dash7);

		JP_Acao.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ações", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

		JP_Acao.setDoubleBuffered(false);

		JP_Acao.setEnabled(false);

		JP_Acao.setFocusable(false);

		JP_Acao.setLayout(new java.awt.GridLayout(3, 0));

		BTN_Parar.setFont(new java.awt.Font("Tahoma", 1, 9));

		BTN_Parar.setForeground(new java.awt.Color(102, 255, 0));

		BTN_Parar.setText("Parar");

		BTN_Parar.setFocusable(false);

		BTN_Parar.setMinimumSize(new java.awt.Dimension(0, 0));

		BTN_Parar.setPreferredSize(new java.awt.Dimension(0, 0));

		BTN_Parar.setRequestFocusEnabled(false);

		BTN_Parar.setVerifyInputWhenFocusTarget(false);

		BTN_Parar.addActionListener((evt) -> {
				BTN_PararActionPerformed(evt);			
		});

		JP_Acao.add(BTN_Parar);

		BTN_Parar.getAccessibleContext().setAccessibleDescription("");

		BTN_Esperar.setFont(new java.awt.Font("Tahoma", 1, 9));

		BTN_Esperar.setForeground(new java.awt.Color(255, 0, 102));

		BTN_Esperar.setText("Esperar");

		BTN_Esperar.setFocusable(false);

		BTN_Esperar.setMinimumSize(new java.awt.Dimension(0, 0));

		BTN_Esperar.setPreferredSize(new java.awt.Dimension(0, 0));

		BTN_Esperar.setRequestFocusEnabled(false);

		BTN_Esperar.setVerifyInputWhenFocusTarget(false);

		BTN_Esperar.addActionListener((evt) -> {
				BTN_EsperarActionPerformed(evt);			
		});

		JP_Acao.add(BTN_Esperar);

		BTN_Esperar.getAccessibleContext().setAccessibleDescription("");

		BTN_Transformar.setFont(new java.awt.Font("Tahoma", 1, 9));

		BTN_Transformar.setForeground(new java.awt.Color(255, 51, 0));

		BTN_Transformar.setText("Transformar");

		BTN_Transformar.setFocusable(false);

		BTN_Transformar.setMinimumSize(new java.awt.Dimension(0, 0));

		BTN_Transformar.setPreferredSize(new java.awt.Dimension(0, 0));

		BTN_Transformar.setRequestFocusEnabled(false);

		BTN_Transformar.setVerifyInputWhenFocusTarget(false);

		BTN_Transformar.addActionListener((evt) -> {
				BTN_TransformarActionPerformed(evt);			
		});

		JP_Acao.add(BTN_Transformar);

		BTN_Transformar.getAccessibleContext().setAccessibleDescription("");

		BTN_Abaixar.setFont(new java.awt.Font("Tahoma", 1, 9));

		BTN_Abaixar.setForeground(new java.awt.Color(0, 204, 255));

		BTN_Abaixar.setText("Abaixar");

		BTN_Abaixar.setFocusable(false);

		BTN_Abaixar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

		BTN_Abaixar.setMaximumSize(new java.awt.Dimension(0, 0));

		BTN_Abaixar.setMinimumSize(new java.awt.Dimension(0, 0));

		BTN_Abaixar.setPreferredSize(new java.awt.Dimension(200, 200));

		BTN_Abaixar.setRequestFocusEnabled(false);

		BTN_Abaixar.setVerifyInputWhenFocusTarget(false);

		BTN_Abaixar.addActionListener((evt) -> {
				BTN_AbaixarActionPerformed(evt);			
		});

		JP_Acao.add(BTN_Abaixar);

		BTN_Abaixar.getAccessibleContext().setAccessibleDescription("");

		BTN_Abaixado.setFont(new java.awt.Font("Tahoma", 1, 9));

		BTN_Abaixado.setForeground(new java.awt.Color(0, 204, 255));

		BTN_Abaixado.setText("Abaixado");

		BTN_Abaixado.addActionListener((evt) -> {
				BTN_AbaixadoActionPerformed(evt);			
		});
		
		JP_Acao.add(BTN_Abaixado);

		BTN_Empurrando.setFont(new java.awt.Font("Tahoma", 1, 9));

		BTN_Empurrando.setForeground(new java.awt.Color(153, 0, 153));

		BTN_Empurrando.setText("Empurrando");

		BTN_Empurrando.addActionListener((evt) -> {
				BTN_EmpurrandoActionPerformed(evt);			
		});

		JP_Acao.add(BTN_Empurrando);

		BTN_Olhar.setFont(new java.awt.Font("Tahoma", 1, 9));

		BTN_Olhar.setForeground(new java.awt.Color(0, 204, 204));

		BTN_Olhar.setText("Olhar");

		BTN_Olhar.setFocusable(false);

		BTN_Olhar.setMinimumSize(new java.awt.Dimension(0, 0));

		BTN_Olhar.setPreferredSize(new java.awt.Dimension(0, 0));

		BTN_Olhar.setRequestFocusEnabled(false);

		BTN_Olhar.setVerifyInputWhenFocusTarget(false);

		BTN_Olhar.addActionListener((evt) -> {
				BTN_OlharActionPerformed(evt);			
		});

		JP_Acao.add(BTN_Olhar);

		BTN_Olhar.getAccessibleContext().setAccessibleDescription("");

		BTN_Olhando.setFont(new java.awt.Font("Tahoma", 1, 9));

		BTN_Olhando.setForeground(new java.awt.Color(0, 204, 204));

		BTN_Olhando.setText("Olhando");

		BTN_Olhando.addActionListener((evt) -> {
				BTN_OlhandoActionPerformed(evt);			
		});

		JP_Acao.add(BTN_Olhando);

		BTN_Freiando.setFont(new java.awt.Font("Tahoma", 1, 9));

		BTN_Freiando.setForeground(new java.awt.Color(255, 0, 51));

		BTN_Freiando.setText("Freiando");

		BTN_Freiando.addActionListener((evt) -> {
				BTN_FreiandoActionPerformed(evt);			
		});

		JP_Acao.add(BTN_Freiando);

		JP_Orientacao.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Orientação", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

		JP_Orientacao.setDoubleBuffered(false);

		JP_Orientacao.setEnabled(false);

		JP_Orientacao.setFocusable(false);

		JP_Orientacao.setLayout(new java.awt.GridLayout(1, 0));

		BTN_Esquerda.setFont(new java.awt.Font("Tahoma", 1, 9));

		BTN_Esquerda.setForeground(new java.awt.Color(51, 51, 255));

		BTN_Esquerda.setText("Esquerda");

		BTN_Esquerda.setFocusable(false);

		BTN_Esquerda.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

		BTN_Esquerda.setMaximumSize(new java.awt.Dimension(0, 0));

		BTN_Esquerda.setMinimumSize(new java.awt.Dimension(0, 0));

		BTN_Esquerda.setPreferredSize(new java.awt.Dimension(200, 200));

		BTN_Esquerda.setRequestFocusEnabled(false);

		BTN_Esquerda.setVerifyInputWhenFocusTarget(false);

		BTN_Esquerda.addActionListener((evt) -> {
				BTN_EsquerdaActionPerformed(evt);			
		});

		JP_Orientacao.add(BTN_Esquerda);

		BTN_Esquerda.getAccessibleContext().setAccessibleDescription("");

		BTN_Direita.setFont(new java.awt.Font("Tahoma", 1, 9));

		BTN_Direita.setForeground(new java.awt.Color(51, 51, 255));

		BTN_Direita.setText("Direita");

		BTN_Direita.setFocusable(false);

		BTN_Direita.setMinimumSize(new java.awt.Dimension(0, 0));

		BTN_Direita.setPreferredSize(new java.awt.Dimension(0, 0));

		BTN_Direita.setRequestFocusEnabled(false);

		BTN_Direita.setVerifyInputWhenFocusTarget(false);

		BTN_Direita.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent evt) {
				BTN_DireitaMouseDragged(evt);
			}
		});

		BTN_Direita.addActionListener((evt) -> {
			BTN_DireitaActionPerformed(evt);

		});

		JP_Orientacao.add(BTN_Direita);

		BTN_Direita.getAccessibleContext().setAccessibleDescription("");

		JSLD_VelAnimacao.setForeground(java.awt.Color.blue);

		JSLD_VelAnimacao.setMajorTickSpacing(1);

		JSLD_VelAnimacao.setMaximum(9);

		JSLD_VelAnimacao.setMinorTickSpacing(1);

		JSLD_VelAnimacao.setPaintLabels(true);

		JSLD_VelAnimacao.setPaintTicks(true);

		JSLD_VelAnimacao.setSnapToTicks(true);

		JSLD_VelAnimacao.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Velocidade da Animação", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 10)));

		JSLD_VelAnimacao.setEnabled(false);

		JSLD_VelAnimacao.setFocusable(false);

		JSLD_VelAnimacao.setMinimumSize(new java.awt.Dimension(0, 0));

		JSLD_VelAnimacao.setPreferredSize(new java.awt.Dimension(0, 0));

		JSLD_VelAnimacao.setRequestFocusEnabled(false);

		JSLD_VelAnimacao.setVerifyInputWhenFocusTarget(false);

		JSLD_VelAnimacao.addChangeListener((evt) -> {
			JSLD_VelAnimacaoStateChanged(evt);

		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());

		getContentPane().setLayout(layout);

		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
								.addComponent(JP_Acao, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
								.addComponent(JP_Orientacao, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
								.addComponent(JP_Dash, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(JP_Girar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(JP_Andar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(JP_Correr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(JSLD_VelAnimacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap())
				);

		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(JP_Correr, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(JP_Andar, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(JP_Girar, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(JP_Dash, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(JP_Acao, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(JP_Orientacao, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(JSLD_VelAnimacao, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE))
				);

		JP_Correr.getAccessibleContext().setAccessibleDescription("");

		JP_Andar.getAccessibleContext().setAccessibleDescription("");

		JP_Girar.getAccessibleContext().setAccessibleDescription("");

		JSLD_VelAnimacao.getAccessibleContext().setAccessibleDescription("");

		pack();
	}

	private void BTN_EsperarActionPerformed(ActionEvent evt) {
		sonic.doWait();
	}

	private void BTN_OlharActionPerformed(ActionEvent evt) {
		sonic.doLook();

	}

	private void BTN_AbaixarActionPerformed(ActionEvent evt) {

		sonic.doDown();
	}

	private void BTN_TransformarActionPerformed(ActionEvent evt) {

		sonic.doTransform();


	}

	private void BTN_Andar1ActionPerformed(ActionEvent evt) {
		sonic.doWalk(1);
		sonic.setAnimeSpeed(1);
	}

	private void BTN_Correr1ActionPerformed(ActionEvent evt) {
		sonic.doRun(1);
		sonic.setAnimeSpeed(1);
	}

	private void BTN_Girar0ActionPerformed(ActionEvent evt) {
		sonic.doSpin(0);
		sonic.setAnimeSpeed(0);
	}

	private void BTN_Correr2ActionPerformed(ActionEvent evt) {
		sonic.doRun(2);
		sonic.setAnimeSpeed(2);
	}

	private void BTN_Correr3ActionPerformed(ActionEvent evt) {
		sonic.doRun(3);
		sonic.setAnimeSpeed(3);
	}

	private void BTN_Correr4ActionPerformed(ActionEvent evt) {
		sonic.doRun(4);
		sonic.setAnimeSpeed(4);
	}

	private void BTN_Correr5ActionPerformed(ActionEvent evt) {
		sonic.doRun(5);
		sonic.setAnimeSpeed(5);
	}

	private void BTN_Andar2ActionPerformed(ActionEvent evt) {
		sonic.doWalk(2);
		sonic.setAnimeSpeed(2);
	}

	private void BTN_Andar3ActionPerformed(ActionEvent evt) {
		sonic.doWalk(3);
		sonic.setAnimeSpeed(3);
	}

	private void BTN_Andar4ActionPerformed(ActionEvent evt) {
		sonic.doWalk(4);
		sonic.setAnimeSpeed(4);
	}

	private void BTN_Andar5ActionPerformed(ActionEvent evt) {
		sonic.doWalk(5);
		sonic.setAnimeSpeed(5);
	}

	private void BTN_Girar1ActionPerformed(ActionEvent evt) {
		sonic.doSpin(1);
		sonic.setAnimeSpeed(1);
	}

	private void BTN_Girar2ActionPerformed(ActionEvent evt) {
		sonic.doSpin(2);
		sonic.setAnimeSpeed(2);
	}

	private void BTN_Girar3ActionPerformed(ActionEvent evt) {
		sonic.doSpin(3);
		sonic.setAnimeSpeed(3);
	}

	private void BTN_Girar4ActionPerformed(ActionEvent evt) {
		sonic.doSpin(4);
		sonic.setAnimeSpeed(4);
	}

	private void BTN_PararActionPerformed(ActionEvent evt) {
		sonic.doStop();

	}

	private void BTN_EsquerdaActionPerformed(ActionEvent evt) {
		sonic.setOrientation(Orientation.LEFT);
	}

	private void BTN_DireitaActionPerformed(ActionEvent evt) {
		sonic.setOrientation(Orientation.RIGHT);
	}

	private void BTN_DireitaMouseDragged(MouseEvent evt) {

	}


	private void JSLD_VelAnimacaoStateChanged(javax.swing.event.ChangeEvent evt) {

		sonic.setAnimeSpeed(JSLD_VelAnimacao.getValue());

	}

	private void BTN_Correr0ActionPerformed(ActionEvent evt) {
		sonic.doRun(0);
		sonic.setAnimeSpeed(0);
	}

	private void BTN_Correr6ActionPerformed(ActionEvent evt) {
		sonic.doRun(6);
		sonic.setAnimeSpeed(6);
	}

	private void BTN_Correr7ActionPerformed(ActionEvent evt) {
		sonic.doRun(7);
		sonic.setAnimeSpeed(7);
	}

	private void BTN_Andar7ActionPerformed(ActionEvent evt) {
		sonic.doWalk(7);
		sonic.setAnimeSpeed(7);
	}

	private void BTN_Andar6ActionPerformed(ActionEvent evt) {
		sonic.doWalk(6);
		sonic.setAnimeSpeed(6);
	}

	private void BTN_Andar0ActionPerformed(ActionEvent evt) {
		sonic.doWalk(0);
		sonic.setAnimeSpeed(0);
	}

	private void BTN_Girar5ActionPerformed(ActionEvent evt) {
		sonic.doSpin(5);
		sonic.setAnimeSpeed(5);
	}

	private void BTN_Girar6ActionPerformed(ActionEvent evt) {
		sonic.doSpin(6);
		sonic.setAnimeSpeed(6);
	}

	private void BTN_Girar7ActionPerformed(ActionEvent evt) {
		sonic.doSpin(7);
		sonic.setAnimeSpeed(7);
	}

	private void BTN_Dash0ActionPerformed(ActionEvent evt) {
		sonic.doDash(0);
		sonic.setAnimeSpeed(0);
	}

	private void BTN_Dash1ActionPerformed(ActionEvent evt) {
		sonic.doDash(1);
		sonic.setAnimeSpeed(1);
	}

	private void BTN_Dash2ActionPerformed(ActionEvent evt) {
		sonic.doDash(2);
		sonic.setAnimeSpeed(2);
	}

	private void BTN_Dash3ActionPerformed(ActionEvent evt) {
		sonic.doDash(3);
		sonic.setAnimeSpeed(3);
	}

	private void BTN_Dash4ActionPerformed(ActionEvent evt) {
		sonic.doDash(4);
		sonic.setAnimeSpeed(4);
	}

	private void BTN_Dash5ActionPerformed(ActionEvent evt) {
		sonic.doDash(5);
		sonic.setAnimeSpeed(5);
	}

	private void BTN_Dash6ActionPerformed(ActionEvent evt) {
		sonic.doDash(6);
		sonic.setAnimeSpeed(6);
	}

	private void BTN_Dash7ActionPerformed(ActionEvent evt) {
		sonic.doDash(7);
		sonic.setAnimeSpeed(7);
	}

	private void BTN_AbaixadoActionPerformed(ActionEvent evt) {
		sonic.doDowned();
	}

	private void BTN_OlhandoActionPerformed(ActionEvent evt) {
		sonic.doLooking();
	}

	private void BTN_FreiandoActionPerformed(ActionEvent evt) {
		sonic.doBrakeUp();
	}

	private void BTN_EmpurrandoActionPerformed(ActionEvent evt) {
		sonic.doPush();
	}


	@Override
	public void run() {
		
		while (true) {

			doControlButtons(sonic.isAi());

			doRefreshComponents();

			try {

				Thread.sleep(ConfigEngine.FPS.getValue());

			} catch (InterruptedException ex) {

				throw new RuntimeException("Falha ao Interromper " + ex.getMessage());
			}

		}
	}

}
