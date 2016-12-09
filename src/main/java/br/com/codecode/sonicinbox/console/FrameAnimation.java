package br.com.codecode.sonicinbox.console;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;

import br.com.codecode.sonicinbox.engine.Engine;
import br.com.codecode.sonicinbox.enums.ConfigEngine;
import br.com.codecode.sonicinbox.enums.Orientation;
import br.com.codecode.sonicinbox.motion.Sonic;

public final class FrameAnimation extends JFrame implements Runnable {

	private static final long serialVersionUID = -7339748933268786433L;

	private JButton btnDowned, btnDown, btnWalkZero, btnWalkOne, btnWalkTwo, btnWalkThree, btnWalkFour, btnWalkFive,
			btnWalkSix, btnWalkSeven, btnRunZero, btnRunOne, btnRunTwo, btnRunThree, btnRunFour, btnRunFive,
			btnRunSix, btnRunSeven, btnDashZero, btnDashOne, btnDashTwo, btnDashThree, btnDashFour, btnDashFive, btnDashSix,
			btnDashSeven, btnRight, btnPush, btnWait, btnLeft, btnBreaking, btnSpinZero, btnSpinOne,
			btnSpinTwo, btnSpinThree, btnSpinFour, btnSpinFive, btnSpinSix, btnSpinSeven, btnLooking, btnLook, btnStop,
			btnTransform;

	private JPanel jpAction, jpWalk, jpRun, jpDash, jpSpin, jpOrientation;

	private JSlider sliderAnimation;

	private Sonic sonic;
	
	private Thread thread;

	private FrameAnimation() {
		
		thread = new Thread(this);	
		
		initComponents();

		super.setLocationRelativeTo(null);

		super.setLocation(0, 0);
		
		super.setVisible(true);
		
		thread.start();

	}

	public FrameAnimation(Engine engine) {
		this();
		this.sonic = engine.sonic;	

		super.addKeyListener(engine.event);
		
	}

	private void doControlButtons(boolean ai) {

		JButton[] btns = { btnDown, btnDowned, btnLook, btnLooking, btnStop, btnWait, btnPush,
				btnTransform, btnBreaking, btnDashZero, btnDashOne, btnDashTwo, btnDashThree, btnDashFour, btnDashFive,
				btnDashSix, btnDashSeven, btnWalkZero, btnWalkOne, btnWalkTwo, btnWalkThree, btnWalkFour, btnWalkFive,
				btnWalkSix, btnWalkSeven, btnRunZero, btnRunOne, btnRunTwo, btnRunThree, btnRunFour, btnRunFive,
				btnRunSix, btnRunSeven, btnSpinZero, btnSpinOne, btnSpinTwo, btnSpinThree, btnSpinFour, btnSpinFive,
				btnSpinSix, btnSpinSeven };

		for (JButton jb : btns) {

			jb.setEnabled(!ai);
		}

		sliderAnimation.setEnabled(!ai);
	}

	private void doRefreshComponents() {

		if (sonic.getOrientation() == Orientation.RIGHT) {

			btnRight.setVisible(false);

			btnLeft.setVisible(true);

		} else {

			btnRight.setVisible(true);

			btnLeft.setVisible(false);
		}

		if (sonic.isAi()) {

			sliderAnimation.setValue(sonic.getAnimeSpeed());
		}
	}

	private void initComponents() {

		jpRun = new JPanel();

		btnRunZero = new JButton();

		btnRunOne = new JButton();

		btnRunTwo = new JButton();

		btnRunThree = new JButton();

		btnRunFour = new JButton();

		btnRunFive = new JButton();

		btnRunSix = new JButton();

		btnRunSeven = new JButton();

		jpWalk = new JPanel();

		btnWalkZero = new JButton();

		btnWalkOne = new JButton();

		btnWalkTwo = new JButton();

		btnWalkThree = new JButton();

		btnWalkFour = new JButton();

		btnWalkFive = new JButton();

		btnWalkSix = new JButton();

		btnWalkSeven = new JButton();

		jpSpin = new JPanel();

		btnSpinZero = new JButton();

		btnSpinOne = new JButton();

		btnSpinTwo = new JButton();

		btnSpinThree = new JButton();

		btnSpinFour = new JButton();

		btnSpinFive = new JButton();

		btnSpinSix = new JButton();

		btnSpinSeven = new JButton();

		jpDash = new JPanel();

		btnDashZero = new JButton();

		btnDashOne = new JButton();

		btnDashTwo = new JButton();

		btnDashThree = new JButton();

		btnDashFour = new JButton();

		btnDashFive = new JButton();

		btnDashSix = new JButton();

		btnDashSeven = new JButton();

		jpAction = new JPanel();

		btnStop = new JButton();

		btnWait = new JButton();

		btnTransform = new JButton();

		btnDown = new JButton();

		btnDowned = new JButton();

		btnPush = new JButton();

		btnLook = new JButton();

		btnLooking = new JButton();

		btnBreaking = new JButton();

		jpOrientation = new JPanel();

		btnLeft = new JButton();

		btnRight = new JButton();

		sliderAnimation = new JSlider();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		setTitle("Animation Console");

		setAlwaysOnTop(true);

		setResizable(false);

		jpRun.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Run",
				javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

		jpRun.setForeground(Color.blue);

		jpRun.setDoubleBuffered(false);

		jpRun.setEnabled(false);

		jpRun.setFocusable(false);

		jpRun.setMinimumSize(new java.awt.Dimension(0, 0));

		jpRun.setPreferredSize(new java.awt.Dimension(0, 0));

		jpRun.setRequestFocusEnabled(false);

		jpRun.setVerifyInputWhenFocusTarget(false);

		jpRun.setLayout(new java.awt.GridLayout(1, 0));

		btnRunZero.setForeground(new java.awt.Color(255, 51, 102));

		btnRunZero.setText("0");

		btnRunZero.addActionListener((evt) -> {
			BTN_Correr0ActionPerformed(evt);
		});

		jpRun.add(btnRunZero);

		btnRunOne.setForeground(new java.awt.Color(255, 51, 102));

		btnRunOne.setText("1");

		btnRunOne.addActionListener((evt) -> {
			BTN_Correr1ActionPerformed(evt);

		});

		jpRun.add(btnRunOne);

		btnRunTwo.setForeground(new java.awt.Color(255, 51, 102));

		btnRunTwo.setText("2");

		btnRunTwo.addActionListener((evt) -> {
			BTN_Correr2ActionPerformed(evt);

		});

		jpRun.add(btnRunTwo);

		btnRunThree.setForeground(new java.awt.Color(255, 51, 102));

		btnRunThree.setText("3");

		btnRunThree.addActionListener((evt) -> {
			BTN_Correr3ActionPerformed(evt);

		});

		jpRun.add(btnRunThree);

		btnRunFour.setForeground(new java.awt.Color(0, 0, 255));
		btnRunFour.setText("4");

		btnRunFour.addActionListener((evt) -> {
			BTN_Correr4ActionPerformed(evt);
		});

		jpRun.add(btnRunFour);

		btnRunFive.setForeground(new java.awt.Color(0, 0, 255));

		btnRunFive.setText("5");

		btnRunFive.addActionListener((evt) -> {
			BTN_Correr5ActionPerformed(evt);
		});

		jpRun.add(btnRunFive);

		btnRunSix.setForeground(new java.awt.Color(51, 204, 0));

		btnRunSix.setText("6");

		btnRunSix.addActionListener((evt) -> {
			BTN_Correr6ActionPerformed(evt);
		});

		jpRun.add(btnRunSix);

		btnRunSeven.setForeground(new java.awt.Color(51, 204, 0));

		btnRunSeven.setText("7");

		btnRunSeven.addActionListener((evt) -> {
			BTN_Correr7ActionPerformed(evt);
		});

		jpRun.add(btnRunSeven);

		jpWalk.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Walk",
				javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

		jpWalk.setForeground(java.awt.Color.blue);

		jpWalk.setDoubleBuffered(false);

		jpWalk.setEnabled(false);

		jpWalk.setFocusable(false);

		jpWalk.setMinimumSize(new java.awt.Dimension(0, 0));

		jpWalk.setPreferredSize(new java.awt.Dimension(0, 0));

		jpWalk.setRequestFocusEnabled(false);

		jpWalk.setVerifyInputWhenFocusTarget(false);

		jpWalk.setLayout(new java.awt.GridLayout(1, 0));

		btnWalkZero.setForeground(new java.awt.Color(255, 51, 102));

		btnWalkZero.setText("0");

		btnWalkZero.addActionListener((evt) -> {
			BTN_Andar0ActionPerformed(evt);
		});

		jpWalk.add(btnWalkZero);

		btnWalkOne.setForeground(new java.awt.Color(255, 51, 102));
		btnWalkOne.setText("1");

		btnWalkOne.addActionListener((evt) -> {
			BTN_Andar1ActionPerformed(evt);
		});

		jpWalk.add(btnWalkOne);

		btnWalkTwo.setForeground(new java.awt.Color(255, 51, 102));

		btnWalkTwo.setText("2");

		btnWalkTwo.addActionListener((evt) -> {
			BTN_Andar2ActionPerformed(evt);
		});

		jpWalk.add(btnWalkTwo);

		btnWalkThree.setForeground(new java.awt.Color(255, 51, 102));

		btnWalkThree.setText("3");

		btnWalkThree.addActionListener((evt) -> {
			BTN_Andar3ActionPerformed(evt);
		});

		jpWalk.add(btnWalkThree);

		btnWalkFour.setForeground(new java.awt.Color(0, 0, 255));

		btnWalkFour.setText("4");

		btnWalkFour.addActionListener((evt) -> {
			BTN_Andar4ActionPerformed(evt);

		});

		jpWalk.add(btnWalkFour);

		btnWalkFive.setForeground(new java.awt.Color(0, 0, 255));

		btnWalkFive.setText("5");

		btnWalkFive.addActionListener((evt) -> {
			BTN_Andar5ActionPerformed(evt);
		});

		jpWalk.add(btnWalkFive);

		btnWalkSix.setForeground(new java.awt.Color(51, 204, 0));

		btnWalkSix.setText("6");

		btnWalkSix.addActionListener((evt) -> {
			BTN_Andar6ActionPerformed(evt);
		});

		jpWalk.add(btnWalkSix);

		btnWalkSeven.setForeground(new java.awt.Color(51, 204, 0));

		btnWalkSeven.setText("7");

		btnWalkSeven.addActionListener((evt) -> {
			BTN_Andar7ActionPerformed(evt);
		});

		jpWalk.add(btnWalkSeven);

		jpSpin.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Spin",
				javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

		jpSpin.setForeground(java.awt.Color.blue);

		jpSpin.setDoubleBuffered(false);

		jpSpin.setEnabled(false);

		jpSpin.setFocusable(false);

		jpSpin.setMinimumSize(new java.awt.Dimension(0, 0));

		jpSpin.setPreferredSize(new java.awt.Dimension(0, 0));

		jpSpin.setRequestFocusEnabled(false);

		jpSpin.setVerifyInputWhenFocusTarget(false);

		jpSpin.setLayout(new java.awt.GridLayout(1, 0));

		btnSpinZero.setForeground(new java.awt.Color(255, 51, 102));

		btnSpinZero.setText("0");

		btnSpinZero.addActionListener((evt) -> {
			BTN_Girar0ActionPerformed(evt);
		});

		jpSpin.add(btnSpinZero);

		btnSpinOne.setForeground(new java.awt.Color(255, 51, 102));

		btnSpinOne.setText("1");

		btnSpinOne.addActionListener((evt) -> {
			BTN_Girar1ActionPerformed(evt);
		});

		jpSpin.add(btnSpinOne);

		btnSpinTwo.setForeground(new java.awt.Color(255, 51, 102));

		btnSpinTwo.setText("2");

		btnSpinTwo.addActionListener((evt) -> {
			BTN_Girar2ActionPerformed(evt);
		});

		jpSpin.add(btnSpinTwo);

		btnSpinThree.setForeground(new java.awt.Color(255, 51, 102));

		btnSpinThree.setText("3");

		btnSpinThree.addActionListener((evt) -> {
			BTN_Girar3ActionPerformed(evt);
		});

		jpSpin.add(btnSpinThree);

		btnSpinFour.setForeground(new java.awt.Color(0, 0, 255));

		btnSpinFour.setText("4");

		btnSpinFour.addActionListener((evt) -> {
			BTN_Girar4ActionPerformed(evt);
		});

		jpSpin.add(btnSpinFour);

		btnSpinFive.setForeground(new java.awt.Color(0, 0, 255));

		btnSpinFive.setText("5");

		btnSpinFive.addActionListener((evt) -> {
			BTN_Girar5ActionPerformed(evt);
		});

		jpSpin.add(btnSpinFive);

		btnSpinSix.setForeground(new java.awt.Color(51, 204, 0));

		btnSpinSix.setText("6");

		btnSpinSix.addActionListener((evt) -> {
			BTN_Girar6ActionPerformed(evt);
		});

		jpSpin.add(btnSpinSix);

		btnSpinSeven.setForeground(new java.awt.Color(51, 204, 0));
		btnSpinSeven.setText("7");

		btnSpinSeven.addActionListener((evt) -> {
			BTN_Girar7ActionPerformed(evt);
		});

		jpSpin.add(btnSpinSeven);

		jpDash.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dash",
				javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

		jpDash.setForeground(java.awt.Color.blue);

		jpDash.setDoubleBuffered(false);

		jpDash.setEnabled(false);

		jpDash.setFocusable(false);

		jpDash.setMinimumSize(new java.awt.Dimension(0, 0));

		jpDash.setPreferredSize(new java.awt.Dimension(0, 0));

		jpDash.setRequestFocusEnabled(false);

		jpDash.setVerifyInputWhenFocusTarget(false);

		jpDash.setLayout(new java.awt.GridLayout(1, 0));

		btnDashZero.setForeground(new java.awt.Color(255, 51, 102));

		btnDashZero.setText("0");

		btnDashZero.addActionListener((evt) -> {
			BTN_Dash0ActionPerformed(evt);
		});

		jpDash.add(btnDashZero);

		btnDashOne.setForeground(new java.awt.Color(255, 51, 102));

		btnDashOne.setText("1");

		btnDashOne.addActionListener((evt) -> {
			BTN_Dash1ActionPerformed(evt);
		});

		jpDash.add(btnDashOne);

		btnDashTwo.setForeground(new java.awt.Color(255, 51, 102));

		btnDashTwo.setText("2");

		btnDashTwo.addActionListener((evt) -> {
			BTN_Dash2ActionPerformed(evt);
		});

		jpDash.add(btnDashTwo);

		btnDashThree.setForeground(new java.awt.Color(255, 51, 102));

		btnDashThree.setText("3");

		btnDashThree.addActionListener((evt) -> {
			BTN_Dash3ActionPerformed(evt);
		});

		jpDash.add(btnDashThree);

		btnDashFour.setForeground(new java.awt.Color(0, 0, 255));

		btnDashFour.setText("4");

		btnDashFour.addActionListener((evt) -> {
			BTN_Dash4ActionPerformed(evt);
		});

		jpDash.add(btnDashFour);

		btnDashFive.setForeground(new java.awt.Color(0, 0, 255));

		btnDashFive.setText("5");

		btnDashFive.addActionListener((evt) -> {
			BTN_Dash5ActionPerformed(evt);
		});

		jpDash.add(btnDashFive);

		btnDashSix.setForeground(new java.awt.Color(51, 204, 0));

		btnDashSix.setText("6");

		btnDashSix.addActionListener((evt) -> {
			BTN_Dash6ActionPerformed(evt);
		});

		jpDash.add(btnDashSix);

		btnDashSeven.setForeground(new java.awt.Color(51, 204, 0));

		btnDashSeven.setText("7");

		btnDashSeven.addActionListener((evt) -> {
			BTN_Dash7ActionPerformed(evt);
		});

		jpDash.add(btnDashSeven);

		jpAction.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Actions",
				javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

		jpAction.setDoubleBuffered(false);

		jpAction.setEnabled(false);

		jpAction.setFocusable(false);

		jpAction.setLayout(new java.awt.GridLayout(3, 0));

		btnStop.setFont(new java.awt.Font("Tahoma", 1, 9));

		btnStop.setForeground(new java.awt.Color(102, 255, 0));

		btnStop.setText("Stop");

		btnStop.setFocusable(false);

		btnStop.setMinimumSize(new java.awt.Dimension(0, 0));

		btnStop.setPreferredSize(new java.awt.Dimension(0, 0));

		btnStop.setRequestFocusEnabled(false);

		btnStop.setVerifyInputWhenFocusTarget(false);

		btnStop.addActionListener((evt) -> {
			BTN_PararActionPerformed(evt);
		});

		jpAction.add(btnStop);

		btnStop.getAccessibleContext().setAccessibleDescription("");

		btnWait.setFont(new java.awt.Font("Tahoma", 1, 9));

		btnWait.setForeground(new java.awt.Color(255, 0, 102));

		btnWait.setText("Wait");

		btnWait.setFocusable(false);

		btnWait.setMinimumSize(new java.awt.Dimension(0, 0));

		btnWait.setPreferredSize(new java.awt.Dimension(0, 0));

		btnWait.setRequestFocusEnabled(false);

		btnWait.setVerifyInputWhenFocusTarget(false);

		btnWait.addActionListener((evt) -> {
			BTN_EsperarActionPerformed(evt);
		});

		jpAction.add(btnWait);

		btnWait.getAccessibleContext().setAccessibleDescription("");

		btnTransform.setFont(new java.awt.Font("Tahoma", 1, 9));

		btnTransform.setForeground(new java.awt.Color(255, 51, 0));

		btnTransform.setText("Transform");

		btnTransform.setFocusable(false);

		btnTransform.setMinimumSize(new java.awt.Dimension(0, 0));

		btnTransform.setPreferredSize(new java.awt.Dimension(0, 0));

		btnTransform.setRequestFocusEnabled(false);

		btnTransform.setVerifyInputWhenFocusTarget(false);

		btnTransform.addActionListener((evt) -> {
			BTN_TransformarActionPerformed(evt);
		});

		jpAction.add(btnTransform);

		btnTransform.getAccessibleContext().setAccessibleDescription("");

		btnDown.setFont(new java.awt.Font("Tahoma", 1, 9));

		btnDown.setForeground(new java.awt.Color(0, 204, 255));

		btnDown.setText("Down");

		btnDown.setFocusable(false);

		btnDown.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

		btnDown.setMaximumSize(new java.awt.Dimension(0, 0));

		btnDown.setMinimumSize(new java.awt.Dimension(0, 0));

		btnDown.setPreferredSize(new java.awt.Dimension(200, 200));

		btnDown.setRequestFocusEnabled(false);

		btnDown.setVerifyInputWhenFocusTarget(false);

		btnDown.addActionListener((evt) -> {
			BTN_AbaixarActionPerformed(evt);
		});

		jpAction.add(btnDown);

		btnDown.getAccessibleContext().setAccessibleDescription("");

		btnDowned.setFont(new java.awt.Font("Tahoma", 1, 9));

		btnDowned.setForeground(new java.awt.Color(0, 204, 255));

		btnDowned.setText("Downed");

		btnDowned.addActionListener((evt) -> {
			BTN_AbaixadoActionPerformed(evt);
		});

		jpAction.add(btnDowned);

		btnPush.setFont(new java.awt.Font("Tahoma", 1, 9));

		btnPush.setForeground(new java.awt.Color(153, 0, 153));

		btnPush.setText("Push");

		btnPush.addActionListener((evt) -> {
			BTN_EmpurrandoActionPerformed(evt);
		});

		jpAction.add(btnPush);

		btnLook.setFont(new java.awt.Font("Tahoma", 1, 9));

		btnLook.setForeground(new java.awt.Color(0, 204, 204));

		btnLook.setText("Look");

		btnLook.setFocusable(false);

		btnLook.setMinimumSize(new java.awt.Dimension(0, 0));

		btnLook.setPreferredSize(new java.awt.Dimension(0, 0));

		btnLook.setRequestFocusEnabled(false);

		btnLook.setVerifyInputWhenFocusTarget(false);

		btnLook.addActionListener((evt) -> {
			BTN_OlharActionPerformed(evt);
		});

		jpAction.add(btnLook);

		btnLook.getAccessibleContext().setAccessibleDescription("");

		btnLooking.setFont(new java.awt.Font("Tahoma", 1, 9));

		btnLooking.setForeground(new java.awt.Color(0, 204, 204));

		btnLooking.setText("Looking");

		btnLooking.addActionListener((evt) -> {
			BTN_OlhandoActionPerformed(evt);
		});

		jpAction.add(btnLooking);

		btnBreaking.setFont(new java.awt.Font("Tahoma", 1, 9));

		btnBreaking.setForeground(new java.awt.Color(255, 0, 51));

		btnBreaking.setText("Breaking");

		btnBreaking.addActionListener((evt) -> {
			BTN_FreiandoActionPerformed(evt);
		});

		jpAction.add(btnBreaking);

		jpOrientation.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Orientation",
				javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

		jpOrientation.setDoubleBuffered(false);

		jpOrientation.setEnabled(false);

		jpOrientation.setFocusable(false);

		jpOrientation.setLayout(new java.awt.GridLayout(1, 0));

		btnLeft.setFont(new java.awt.Font("Tahoma", 1, 9));

		btnLeft.setForeground(new java.awt.Color(51, 51, 255));

		btnLeft.setText("Left");

		btnLeft.setFocusable(false);

		btnLeft.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

		btnLeft.setMaximumSize(new java.awt.Dimension(0, 0));

		btnLeft.setMinimumSize(new java.awt.Dimension(0, 0));

		btnLeft.setPreferredSize(new java.awt.Dimension(200, 200));

		btnLeft.setRequestFocusEnabled(false);

		btnLeft.setVerifyInputWhenFocusTarget(false);

		btnLeft.addActionListener((evt) -> {
			BTN_EsquerdaActionPerformed(evt);
		});

		jpOrientation.add(btnLeft);

		btnLeft.getAccessibleContext().setAccessibleDescription("");

		btnRight.setFont(new java.awt.Font("Tahoma", 1, 9));

		btnRight.setForeground(new java.awt.Color(51, 51, 255));

		btnRight.setText("Right");

		btnRight.setFocusable(false);

		btnRight.setMinimumSize(new java.awt.Dimension(0, 0));

		btnRight.setPreferredSize(new java.awt.Dimension(0, 0));

		btnRight.setRequestFocusEnabled(false);

		btnRight.setVerifyInputWhenFocusTarget(false);		

		btnRight.addActionListener((evt) -> {
			BTN_DireitaActionPerformed(evt);

		});

		jpOrientation.add(btnRight);

		btnRight.getAccessibleContext().setAccessibleDescription("");

		sliderAnimation.setForeground(java.awt.Color.blue);

		sliderAnimation.setMajorTickSpacing(1);

		sliderAnimation.setMaximum(9);

		sliderAnimation.setMinorTickSpacing(1);

		sliderAnimation.setPaintLabels(true);

		sliderAnimation.setPaintTicks(true);

		sliderAnimation.setSnapToTicks(true);

		sliderAnimation.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Animation Speed",
				javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Tahoma", 0, 10)));

		sliderAnimation.setEnabled(false);

		sliderAnimation.setFocusable(false);

		sliderAnimation.setMinimumSize(new java.awt.Dimension(0, 0));

		sliderAnimation.setPreferredSize(new java.awt.Dimension(0, 0));

		sliderAnimation.setRequestFocusEnabled(false);

		sliderAnimation.setVerifyInputWhenFocusTarget(false);

		sliderAnimation.addChangeListener((evt) -> {
			JSLD_VelAnimacaoStateChanged(evt);

		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());

		getContentPane().setLayout(layout);

		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
								.addComponent(jpAction, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
								.addComponent(jpOrientation, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
								.addComponent(jpDash, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jpSpin, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jpWalk, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jpRun, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(sliderAnimation, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap()));

		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(jpRun, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jpWalk, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jpSpin, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jpDash, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jpAction, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jpOrientation, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(sliderAnimation, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)));

		jpRun.getAccessibleContext().setAccessibleDescription("");

		jpWalk.getAccessibleContext().setAccessibleDescription("");

		jpSpin.getAccessibleContext().setAccessibleDescription("");

		sliderAnimation.getAccessibleContext().setAccessibleDescription("");

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
		sonic.doWalk(1).setAnimeSpeed(1);
	}

	private void BTN_Correr1ActionPerformed(ActionEvent evt) {
		sonic.doRun(1).setAnimeSpeed(1);
	}

	private void BTN_Girar0ActionPerformed(ActionEvent evt) {
		sonic.doSpin(0).setAnimeSpeed(0);
	}

	private void BTN_Correr2ActionPerformed(ActionEvent evt) {
		sonic.doRun(2).setAnimeSpeed(2);
	}

	private void BTN_Correr3ActionPerformed(ActionEvent evt) {
		sonic.doRun(3).setAnimeSpeed(3);
	}

	private void BTN_Correr4ActionPerformed(ActionEvent evt) {
		sonic.doRun(4).setAnimeSpeed(4);
	}

	private void BTN_Correr5ActionPerformed(ActionEvent evt) {
		sonic.doRun(5).setAnimeSpeed(5);
	}

	private void BTN_Andar2ActionPerformed(ActionEvent evt) {
		sonic.doWalk(2).setAnimeSpeed(2);
	}

	private void BTN_Andar3ActionPerformed(ActionEvent evt) {
		sonic.doWalk(3).setAnimeSpeed(3);
	}

	private void BTN_Andar4ActionPerformed(ActionEvent evt) {
		sonic.doWalk(4).setAnimeSpeed(4);
	}

	private void BTN_Andar5ActionPerformed(ActionEvent evt) {
		sonic.doWalk(5).setAnimeSpeed(5);
	}

	private void BTN_Girar1ActionPerformed(ActionEvent evt) {
		sonic.doSpin(1).setAnimeSpeed(1);
	}

	private void BTN_Girar2ActionPerformed(ActionEvent evt) {
		sonic.doSpin(2).setAnimeSpeed(2);
	}

	private void BTN_Girar3ActionPerformed(ActionEvent evt) {
		sonic.doSpin(3).setAnimeSpeed(3);
	}

	private void BTN_Girar4ActionPerformed(ActionEvent evt) {
		sonic.doSpin(4).setAnimeSpeed(4);
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

	private void JSLD_VelAnimacaoStateChanged(javax.swing.event.ChangeEvent evt) {
		sonic.setAnimeSpeed(sliderAnimation.getValue());
	}

	private void BTN_Correr0ActionPerformed(ActionEvent evt) {
		sonic.doRun(0).setAnimeSpeed(0);
	}

	private void BTN_Correr6ActionPerformed(ActionEvent evt) {
		sonic.doRun(6).setAnimeSpeed(6);
	}

	private void BTN_Correr7ActionPerformed(ActionEvent evt) {
		sonic.doRun(7).setAnimeSpeed(7);
	}

	private void BTN_Andar7ActionPerformed(ActionEvent evt) {
		sonic.doWalk(7).setAnimeSpeed(7);
	}

	private void BTN_Andar6ActionPerformed(ActionEvent evt) {
		sonic.doWalk(6).setAnimeSpeed(6);
	}

	private void BTN_Andar0ActionPerformed(ActionEvent evt) {
		sonic.doWalk(0).setAnimeSpeed(0);
	}

	private void BTN_Girar5ActionPerformed(ActionEvent evt) {
		sonic.doSpin(5).setAnimeSpeed(5);
	}

	private void BTN_Girar6ActionPerformed(ActionEvent evt) {
		sonic.doSpin(6).setAnimeSpeed(6);
	}

	private void BTN_Girar7ActionPerformed(ActionEvent evt) {
		sonic.doSpin(7).setAnimeSpeed(7);
	}

	private void BTN_Dash0ActionPerformed(ActionEvent evt) {
		sonic.doDash(0).setAnimeSpeed(0);
	}

	private void BTN_Dash1ActionPerformed(ActionEvent evt) {
		sonic.doDash(1).setAnimeSpeed(1);
	}

	private void BTN_Dash2ActionPerformed(ActionEvent evt) {
		sonic.doDash(2).setAnimeSpeed(2);
	}

	private void BTN_Dash3ActionPerformed(ActionEvent evt) {
		sonic.doDash(3).setAnimeSpeed(3);
	}

	private void BTN_Dash4ActionPerformed(ActionEvent evt) {
		sonic.doDash(4).setAnimeSpeed(4);
	}

	private void BTN_Dash5ActionPerformed(ActionEvent evt) {
		sonic.doDash(5).setAnimeSpeed(5);
	}

	private void BTN_Dash6ActionPerformed(ActionEvent evt) {
		sonic.doDash(6).setAnimeSpeed(6);
	}

	private void BTN_Dash7ActionPerformed(ActionEvent evt) {
		sonic.doDash(7).setAnimeSpeed(7);
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

			if (sonic != null) {

				doControlButtons(sonic.isAi());

				doRefreshComponents();
			}

			try {

				Thread.sleep(ConfigEngine.FPS.getValue());

			} catch (InterruptedException ex) {

				throw new RuntimeException(ex);
			}

		}
	}

}
