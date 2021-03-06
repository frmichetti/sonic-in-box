package br.com.codecode.sonicinbox.console;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;

import br.com.codecode.sonicinbox.engine.Engine;
import br.com.codecode.sonicinbox.enums.Action;
import br.com.codecode.sonicinbox.enums.Orientation;
import br.com.codecode.sonicinbox.interfaces.Physicable;
import br.com.codecode.sonicinbox.motion.Sonic;

// TODO: Auto-generated Javadoc
/**
 * The Class FrameAnimation.
 */
public final class FrameAnimation extends JFrame implements Runnable, Observer {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -7339748933268786433L;

    /** The btn transform. */
    private JButton btnDowned, btnDown, btnWalkZero, btnWalkOne, btnWalkTwo, btnWalkThree, btnWalkFour, btnWalkFive,
	    btnWalkSix, btnWalkSeven, btnRunZero, btnRunOne, btnRunTwo, btnRunThree, btnRunFour, btnRunFive, btnRunSix,
	    btnRunSeven, btnDashZero, btnDashOne, btnDashTwo, btnDashThree, btnDashFour, btnDashFive, btnDashSix,
	    btnDashSeven, btnRight, btnPush, btnWait, btnLeft, btnBreaking, btnSpinZero, btnSpinOne, btnSpinTwo,
	    btnSpinThree, btnSpinFour, btnSpinFive, btnSpinSix, btnSpinSeven, btnLooking, btnLook, btnStop,
	    btnTransform;

    /** The jp orientation. */
    private JPanel jpAction, jpWalk, jpRun, jpDash, jpSpin, jpOrientation;

    /** The slider animation. */
    private JSlider sliderAnimation;

    /** The sonic. */
    private Sonic sonic;

    /** The thread. */
    private Thread thread;

    /**
     * Instantiates a new frame animation.
     */
    private FrameAnimation() {

	thread = new Thread(this);

	initComponents();

	super.setLocationRelativeTo(null);

	super.setLocation(0, 0);

	super.setVisible(true);

	thread.start();

    }

    /**
     * Instantiates a new frame animation.
     *
     * @param engine the engine
     */
    public FrameAnimation(Engine engine) {
	this();
	this.sonic = engine.getSonic();

	super.addKeyListener(engine.getEventListener());
	this.sonic.addObserver(this);

    }

    /**
     * Do control buttons.
     *
     * @param enabled the enabled
     * @param buttons the buttons
     */
    private void doControlButtons(boolean enabled, JButton... buttons) {

	if (buttons.length > 0)

	    for (JButton jb : buttons) {

		jb.setEnabled(!enabled);
	    }

	sliderAnimation.setEnabled(!enabled);
    }

    /**
     * Do refresh components.
     */
    private void doRefreshComponents() {

	if (sonic.getOrientation() == Orientation.RIGHT) {

	    btnRight.setVisible(false);

	    btnLeft.setVisible(true);

	} else {

	    btnRight.setVisible(true);

	    btnLeft.setVisible(false);
	}

	if (sonic.isAi()) {

	    sliderAnimation.setValue(sonic.getAnimationSpeed());
	}
    }

    /**
     * Inits the components.
     */
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

	setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	setTitle("Animation Console");

	setAlwaysOnTop(true);

	setResizable(false);

	jpRun.setBorder(
		BorderFactory.createTitledBorder(null, "Run", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));

	jpRun.setForeground(Color.blue);

	jpRun.setDoubleBuffered(false);

	jpRun.setEnabled(false);

	jpRun.setFocusable(false);

	jpRun.setMinimumSize(new Dimension(0, 0));

	jpRun.setPreferredSize(new Dimension(0, 0));

	jpRun.setRequestFocusEnabled(false);

	jpRun.setVerifyInputWhenFocusTarget(false);

	jpRun.setLayout(new GridLayout(1, 0));

	btnRunZero.setForeground(new Color(255, 51, 102));

	btnRunZero.setText("0");

	btnRunZero.addActionListener((evt) -> {
	    BTN_Correr0ActionPerformed(evt);
	});

	jpRun.add(btnRunZero);

	btnRunOne.setForeground(new Color(255, 51, 102));

	btnRunOne.setText("1");

	btnRunOne.addActionListener((evt) -> {
	    BTN_Correr1ActionPerformed(evt);

	});

	jpRun.add(btnRunOne);

	btnRunTwo.setForeground(new Color(255, 51, 102));

	btnRunTwo.setText("2");

	btnRunTwo.addActionListener((evt) -> {
	    BTN_Correr2ActionPerformed(evt);

	});

	jpRun.add(btnRunTwo);

	btnRunThree.setForeground(new Color(255, 51, 102));

	btnRunThree.setText("3");

	btnRunThree.addActionListener((evt) -> {
	    BTN_Correr3ActionPerformed(evt);

	});

	jpRun.add(btnRunThree);

	btnRunFour.setForeground(new Color(0, 0, 255));
	btnRunFour.setText("4");

	btnRunFour.addActionListener((evt) -> {
	    BTN_Correr4ActionPerformed(evt);
	});

	jpRun.add(btnRunFour);

	btnRunFive.setForeground(new Color(0, 0, 255));

	btnRunFive.setText("5");

	btnRunFive.addActionListener((evt) -> {
	    BTN_Correr5ActionPerformed(evt);
	});

	jpRun.add(btnRunFive);

	btnRunSix.setForeground(new Color(51, 204, 0));

	btnRunSix.setText("6");

	btnRunSix.addActionListener((evt) -> {
	    BTN_Correr6ActionPerformed(evt);
	});

	jpRun.add(btnRunSix);

	btnRunSeven.setForeground(new Color(51, 204, 0));

	btnRunSeven.setText("7");

	btnRunSeven.addActionListener((evt) -> {
	    BTN_Correr7ActionPerformed(evt);
	});

	jpRun.add(btnRunSeven);

	jpWalk.setBorder(
		BorderFactory.createTitledBorder(null, "Walk", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));

	jpWalk.setForeground(Color.blue);

	jpWalk.setDoubleBuffered(false);

	jpWalk.setEnabled(false);

	jpWalk.setFocusable(false);

	jpWalk.setMinimumSize(new Dimension(0, 0));

	jpWalk.setPreferredSize(new Dimension(0, 0));

	jpWalk.setRequestFocusEnabled(false);

	jpWalk.setVerifyInputWhenFocusTarget(false);

	jpWalk.setLayout(new GridLayout(1, 0));

	btnWalkZero.setForeground(new Color(255, 51, 102));

	btnWalkZero.setText("0");

	btnWalkZero.addActionListener((evt) -> {
	    BTN_Andar0ActionPerformed(evt);
	});

	jpWalk.add(btnWalkZero);

	btnWalkOne.setForeground(new Color(255, 51, 102));
	btnWalkOne.setText("1");

	btnWalkOne.addActionListener((evt) -> {
	    BTN_Andar1ActionPerformed(evt);
	});

	jpWalk.add(btnWalkOne);

	btnWalkTwo.setForeground(new Color(255, 51, 102));

	btnWalkTwo.setText("2");

	btnWalkTwo.addActionListener((evt) -> {
	    BTN_Andar2ActionPerformed(evt);
	});

	jpWalk.add(btnWalkTwo);

	btnWalkThree.setForeground(new Color(255, 51, 102));

	btnWalkThree.setText("3");

	btnWalkThree.addActionListener((evt) -> {
	    BTN_Andar3ActionPerformed(evt);
	});

	jpWalk.add(btnWalkThree);

	btnWalkFour.setForeground(new Color(0, 0, 255));

	btnWalkFour.setText("4");

	btnWalkFour.addActionListener((evt) -> {
	    BTN_Andar4ActionPerformed(evt);

	});

	jpWalk.add(btnWalkFour);

	btnWalkFive.setForeground(new Color(0, 0, 255));

	btnWalkFive.setText("5");

	btnWalkFive.addActionListener((evt) -> {
	    BTN_Andar5ActionPerformed(evt);
	});

	jpWalk.add(btnWalkFive);

	btnWalkSix.setForeground(new Color(51, 204, 0));

	btnWalkSix.setText("6");

	btnWalkSix.addActionListener((evt) -> {
	    BTN_Andar6ActionPerformed(evt);
	});

	jpWalk.add(btnWalkSix);

	btnWalkSeven.setForeground(new Color(51, 204, 0));

	btnWalkSeven.setText("7");

	btnWalkSeven.addActionListener((evt) -> {
	    BTN_Andar7ActionPerformed(evt);
	});

	jpWalk.add(btnWalkSeven);

	jpSpin.setBorder(
		BorderFactory.createTitledBorder(null, "Spin", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));

	jpSpin.setForeground(Color.blue);

	jpSpin.setDoubleBuffered(false);

	jpSpin.setEnabled(false);

	jpSpin.setFocusable(false);

	jpSpin.setMinimumSize(new Dimension(0, 0));

	jpSpin.setPreferredSize(new Dimension(0, 0));

	jpSpin.setRequestFocusEnabled(false);

	jpSpin.setVerifyInputWhenFocusTarget(false);

	jpSpin.setLayout(new GridLayout(1, 0));

	btnSpinZero.setForeground(new Color(255, 51, 102));

	btnSpinZero.setText("0");

	btnSpinZero.addActionListener((evt) -> {
	    BTN_Girar0ActionPerformed(evt);
	});

	jpSpin.add(btnSpinZero);

	btnSpinOne.setForeground(new Color(255, 51, 102));

	btnSpinOne.setText("1");

	btnSpinOne.addActionListener((evt) -> {
	    BTN_Girar1ActionPerformed(evt);
	});

	jpSpin.add(btnSpinOne);

	btnSpinTwo.setForeground(new Color(255, 51, 102));

	btnSpinTwo.setText("2");

	btnSpinTwo.addActionListener((evt) -> {
	    BTN_Girar2ActionPerformed(evt);
	});

	jpSpin.add(btnSpinTwo);

	btnSpinThree.setForeground(new Color(255, 51, 102));

	btnSpinThree.setText("3");

	btnSpinThree.addActionListener((evt) -> {
	    BTN_Girar3ActionPerformed(evt);
	});

	jpSpin.add(btnSpinThree);

	btnSpinFour.setForeground(new Color(0, 0, 255));

	btnSpinFour.setText("4");

	btnSpinFour.addActionListener((evt) -> {
	    BTN_Girar4ActionPerformed(evt);
	});

	jpSpin.add(btnSpinFour);

	btnSpinFive.setForeground(new Color(0, 0, 255));

	btnSpinFive.setText("5");

	btnSpinFive.addActionListener((evt) -> {
	    BTN_Girar5ActionPerformed(evt);
	});

	jpSpin.add(btnSpinFive);

	btnSpinSix.setForeground(new Color(51, 204, 0));

	btnSpinSix.setText("6");

	btnSpinSix.addActionListener((evt) -> {
	    BTN_Girar6ActionPerformed(evt);
	});

	jpSpin.add(btnSpinSix);

	btnSpinSeven.setForeground(new Color(51, 204, 0));
	btnSpinSeven.setText("7");

	btnSpinSeven.addActionListener((evt) -> {
	    BTN_Girar7ActionPerformed(evt);
	});

	jpSpin.add(btnSpinSeven);

	jpDash.setBorder(
		BorderFactory.createTitledBorder(null, "Dash", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));

	jpDash.setForeground(Color.blue);

	jpDash.setDoubleBuffered(false);

	jpDash.setEnabled(false);

	jpDash.setFocusable(false);

	jpDash.setMinimumSize(new Dimension(0, 0));

	jpDash.setPreferredSize(new Dimension(0, 0));

	jpDash.setRequestFocusEnabled(false);

	jpDash.setVerifyInputWhenFocusTarget(false);

	jpDash.setLayout(new GridLayout(1, 0));

	btnDashZero.setForeground(new Color(255, 51, 102));

	btnDashZero.setText("0");

	btnDashZero.addActionListener((evt) -> {
	    BTN_Dash0ActionPerformed(evt);
	});

	jpDash.add(btnDashZero);

	btnDashOne.setForeground(new Color(255, 51, 102));

	btnDashOne.setText("1");

	btnDashOne.addActionListener((evt) -> {
	    BTN_Dash1ActionPerformed(evt);
	});

	jpDash.add(btnDashOne);

	btnDashTwo.setForeground(new Color(255, 51, 102));

	btnDashTwo.setText("2");

	btnDashTwo.addActionListener((evt) -> {
	    BTN_Dash2ActionPerformed(evt);
	});

	jpDash.add(btnDashTwo);

	btnDashThree.setForeground(new Color(255, 51, 102));

	btnDashThree.setText("3");

	btnDashThree.addActionListener((evt) -> {
	    BTN_Dash3ActionPerformed(evt);
	});

	jpDash.add(btnDashThree);

	btnDashFour.setForeground(new Color(0, 0, 255));

	btnDashFour.setText("4");

	btnDashFour.addActionListener((evt) -> {
	    BTN_Dash4ActionPerformed(evt);
	});

	jpDash.add(btnDashFour);

	btnDashFive.setForeground(new Color(0, 0, 255));

	btnDashFive.setText("5");

	btnDashFive.addActionListener((evt) -> {
	    BTN_Dash5ActionPerformed(evt);
	});

	jpDash.add(btnDashFive);

	btnDashSix.setForeground(new Color(51, 204, 0));

	btnDashSix.setText("6");

	btnDashSix.addActionListener((evt) -> {
	    BTN_Dash6ActionPerformed(evt);
	});

	jpDash.add(btnDashSix);

	btnDashSeven.setForeground(new Color(51, 204, 0));

	btnDashSeven.setText("7");

	btnDashSeven.addActionListener((evt) -> {
	    BTN_Dash7ActionPerformed(evt);
	});

	jpDash.add(btnDashSeven);

	jpAction.setBorder(
		BorderFactory.createTitledBorder(null, "Actions", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));

	jpAction.setDoubleBuffered(false);

	jpAction.setEnabled(false);

	jpAction.setFocusable(false);

	jpAction.setLayout(new GridLayout(3, 0));

	btnStop.setFont(new Font("Tahoma", 1, 9));

	btnStop.setForeground(new Color(102, 255, 0));

	btnStop.setText("Stop");

	btnStop.setFocusable(false);

	btnStop.setMinimumSize(new Dimension(0, 0));

	btnStop.setPreferredSize(new Dimension(0, 0));

	btnStop.setRequestFocusEnabled(false);

	btnStop.setVerifyInputWhenFocusTarget(false);

	btnStop.addActionListener((evt) -> {
	    BTN_PararActionPerformed(evt);
	});

	jpAction.add(btnStop);

	btnStop.getAccessibleContext().setAccessibleDescription("");

	btnWait.setFont(new Font("Tahoma", 1, 9));

	btnWait.setForeground(new Color(255, 0, 102));

	btnWait.setText("Wait");

	btnWait.setFocusable(false);

	btnWait.setMinimumSize(new Dimension(0, 0));

	btnWait.setPreferredSize(new Dimension(0, 0));

	btnWait.setRequestFocusEnabled(false);

	btnWait.setVerifyInputWhenFocusTarget(false);

	btnWait.addActionListener((evt) -> {
	    BTN_EsperarActionPerformed(evt);
	});

	jpAction.add(btnWait);

	btnWait.getAccessibleContext().setAccessibleDescription("");

	btnTransform.setFont(new Font("Tahoma", 1, 9));

	btnTransform.setForeground(new Color(255, 51, 0));

	btnTransform.setText("Transform");

	btnTransform.setFocusable(false);

	btnTransform.setMinimumSize(new Dimension(0, 0));

	btnTransform.setPreferredSize(new Dimension(0, 0));

	btnTransform.setRequestFocusEnabled(false);

	btnTransform.setVerifyInputWhenFocusTarget(false);

	btnTransform.addActionListener((evt) -> {
	    BTN_TransformarActionPerformed(evt);
	});

	jpAction.add(btnTransform);

	btnTransform.getAccessibleContext().setAccessibleDescription("");

	btnDown.setFont(new Font("Tahoma", 1, 9));

	btnDown.setForeground(new Color(0, 204, 255));

	btnDown.setText("Down");

	btnDown.setFocusable(false);

	btnDown.setHorizontalTextPosition(SwingConstants.CENTER);

	btnDown.setMaximumSize(new Dimension(0, 0));

	btnDown.setMinimumSize(new Dimension(0, 0));

	btnDown.setPreferredSize(new Dimension(200, 200));

	btnDown.setRequestFocusEnabled(false);

	btnDown.setVerifyInputWhenFocusTarget(false);

	btnDown.addActionListener((evt) -> {
	    BTN_AbaixarActionPerformed(evt);
	});

	jpAction.add(btnDown);

	btnDown.getAccessibleContext().setAccessibleDescription("");

	btnDowned.setFont(new Font("Tahoma", 1, 9));

	btnDowned.setForeground(new Color(0, 204, 255));

	btnDowned.setText("Downed");

	btnDowned.addActionListener((evt) -> {
	    BTN_AbaixadoActionPerformed(evt);
	});

	jpAction.add(btnDowned);

	btnPush.setFont(new Font("Tahoma", 1, 9));

	btnPush.setForeground(new Color(153, 0, 153));

	btnPush.setText("Push");

	btnPush.addActionListener((evt) -> {
	    BTN_EmpurrandoActionPerformed(evt);
	});

	jpAction.add(btnPush);

	btnLook.setFont(new Font("Tahoma", 1, 9));

	btnLook.setForeground(new Color(0, 204, 204));

	btnLook.setText("Look");

	btnLook.setFocusable(false);

	btnLook.setMinimumSize(new Dimension(0, 0));

	btnLook.setPreferredSize(new Dimension(0, 0));

	btnLook.setRequestFocusEnabled(false);

	btnLook.setVerifyInputWhenFocusTarget(false);

	btnLook.addActionListener((evt) -> {
	    BTN_OlharActionPerformed(evt);
	});

	jpAction.add(btnLook);

	btnLook.getAccessibleContext().setAccessibleDescription("");

	btnLooking.setFont(new Font("Tahoma", 1, 9));

	btnLooking.setForeground(new Color(0, 204, 204));

	btnLooking.setText("Looking");

	btnLooking.addActionListener((evt) -> {
	    BTN_OlhandoActionPerformed(evt);
	});

	jpAction.add(btnLooking);

	btnBreaking.setFont(new Font("Tahoma", 1, 9));

	btnBreaking.setForeground(new Color(255, 0, 51));

	btnBreaking.setText("Breaking");

	btnBreaking.addActionListener((evt) -> {
	    BTN_FreiandoActionPerformed(evt);
	});

	jpAction.add(btnBreaking);

	jpOrientation.setBorder(BorderFactory.createTitledBorder(null, "Orientation", TitledBorder.CENTER,
		TitledBorder.DEFAULT_POSITION));

	jpOrientation.setDoubleBuffered(false);

	jpOrientation.setEnabled(false);

	jpOrientation.setFocusable(false);

	jpOrientation.setLayout(new GridLayout(1, 0));

	btnLeft.setFont(new Font("Tahoma", 1, 9));

	btnLeft.setForeground(new Color(51, 51, 255));

	btnLeft.setText("Left");

	btnLeft.setFocusable(false);

	btnLeft.setHorizontalTextPosition(SwingConstants.CENTER);

	btnLeft.setMaximumSize(new Dimension(0, 0));

	btnLeft.setMinimumSize(new Dimension(0, 0));

	btnLeft.setPreferredSize(new Dimension(200, 200));

	btnLeft.setRequestFocusEnabled(false);

	btnLeft.setVerifyInputWhenFocusTarget(false);

	btnLeft.addActionListener((evt) -> {
	    BTN_EsquerdaActionPerformed(evt);
	});

	jpOrientation.add(btnLeft);

	btnLeft.getAccessibleContext().setAccessibleDescription("");

	btnRight.setFont(new Font("Tahoma", 1, 9));

	btnRight.setForeground(new Color(51, 51, 255));

	btnRight.setText("Right");

	btnRight.setFocusable(false);

	btnRight.setMinimumSize(new Dimension(0, 0));

	btnRight.setPreferredSize(new Dimension(0, 0));

	btnRight.setRequestFocusEnabled(false);

	btnRight.setVerifyInputWhenFocusTarget(false);

	btnRight.addActionListener((evt) -> {
	    BTN_DireitaActionPerformed(evt);

	});

	jpOrientation.add(btnRight);

	btnRight.getAccessibleContext().setAccessibleDescription("");

	sliderAnimation.setForeground(Color.blue);

	sliderAnimation.setMajorTickSpacing(1);

	sliderAnimation.setMaximum(9);

	sliderAnimation.setMinorTickSpacing(1);

	sliderAnimation.setPaintLabels(true);

	sliderAnimation.setPaintTicks(true);

	sliderAnimation.setSnapToTicks(true);

	sliderAnimation.setBorder(BorderFactory.createTitledBorder(null, "Animation Speed", TitledBorder.CENTER,
		TitledBorder.DEFAULT_POSITION, new Font("Tahoma", 0, 10)));

	sliderAnimation.setEnabled(false);

	sliderAnimation.setFocusable(false);

	sliderAnimation.setMinimumSize(new Dimension(0, 0));

	sliderAnimation.setPreferredSize(new Dimension(0, 0));

	sliderAnimation.setRequestFocusEnabled(false);

	sliderAnimation.setVerifyInputWhenFocusTarget(false);

	sliderAnimation.addChangeListener((evt) -> {
	    JSLD_VelAnimacaoStateChanged(evt);

	});

	GroupLayout layout = new GroupLayout(getContentPane());

	getContentPane().setLayout(layout);

	layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout
		.createSequentialGroup()
		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
			.addComponent(jpAction, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
			.addComponent(jpOrientation, GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
			.addComponent(jpDash, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
			.addComponent(jpSpin, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
			.addComponent(jpWalk, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
			.addComponent(jpRun, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
			.addComponent(sliderAnimation, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
				Short.MAX_VALUE))
		.addContainerGap()));

	layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		.addGroup(layout.createSequentialGroup()
			.addComponent(jpRun, GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
			.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
			.addComponent(jpWalk, GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
			.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
			.addComponent(jpSpin, GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
			.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
			.addComponent(jpDash, GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
			.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
			.addComponent(jpAction, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
			.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
			.addComponent(jpOrientation, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
			.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
			.addComponent(sliderAnimation, GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)));

	jpRun.getAccessibleContext().setAccessibleDescription("");

	jpWalk.getAccessibleContext().setAccessibleDescription("");

	jpSpin.getAccessibleContext().setAccessibleDescription("");

	sliderAnimation.getAccessibleContext().setAccessibleDescription("");

	pack();
    }

    /**
     * BT N esperar action performed.
     *
     * @param evt the evt
     */
    private void BTN_EsperarActionPerformed(ActionEvent evt) {

	sonic.doWait();
    }

    /**
     * BT N olhar action performed.
     *
     * @param evt the evt
     */
    private void BTN_OlharActionPerformed(ActionEvent evt) {

	sonic.doLook();
    }

    /**
     * BT N abaixar action performed.
     *
     * @param evt the evt
     */
    private void BTN_AbaixarActionPerformed(ActionEvent evt) {

	sonic.doDown();
    }

    /**
     * BT N transformar action performed.
     *
     * @param evt the evt
     */
    private void BTN_TransformarActionPerformed(ActionEvent evt) {

	sonic.doTransform();
    }

    /**
     * BT N andar 1 action performed.
     *
     * @param evt the evt
     */
    private void BTN_Andar1ActionPerformed(ActionEvent evt) {

	sonic.doWalk(1).setAnimationSpeed(1);
    }

    /**
     * BT N correr 1 action performed.
     *
     * @param evt the evt
     */
    private void BTN_Correr1ActionPerformed(ActionEvent evt) {

	sonic.doRun(1).setAnimationSpeed(1);
    }

    /**
     * BT N girar 0 action performed.
     *
     * @param evt the evt
     */
    private void BTN_Girar0ActionPerformed(ActionEvent evt) {

	sonic.doSpin(0).setAnimationSpeed(0);
    }

    /**
     * BT N correr 2 action performed.
     *
     * @param evt the evt
     */
    private void BTN_Correr2ActionPerformed(ActionEvent evt) {

	sonic.doRun(2).setAnimationSpeed(2);
    }

    /**
     * BT N correr 3 action performed.
     *
     * @param evt the evt
     */
    private void BTN_Correr3ActionPerformed(ActionEvent evt) {

	sonic.doRun(3).setAnimationSpeed(3);
    }

    /**
     * BT N correr 4 action performed.
     *
     * @param evt the evt
     */
    private void BTN_Correr4ActionPerformed(ActionEvent evt) {

	sonic.doRun(4).setAnimationSpeed(4);
    }

    /**
     * BT N correr 5 action performed.
     *
     * @param evt the evt
     */
    private void BTN_Correr5ActionPerformed(ActionEvent evt) {

	sonic.doRun(5).setAnimationSpeed(5);
    }

    /**
     * BT N andar 2 action performed.
     *
     * @param evt the evt
     */
    private void BTN_Andar2ActionPerformed(ActionEvent evt) {

	sonic.doWalk(2).setAnimationSpeed(2);
    }

    /**
     * BT N andar 3 action performed.
     *
     * @param evt the evt
     */
    private void BTN_Andar3ActionPerformed(ActionEvent evt) {

	sonic.doWalk(3).setAnimationSpeed(3);
    }

    /**
     * BT N andar 4 action performed.
     *
     * @param evt the evt
     */
    private void BTN_Andar4ActionPerformed(ActionEvent evt) {

	sonic.doWalk(4).setAnimationSpeed(4);
    }

    /**
     * BT N andar 5 action performed.
     *
     * @param evt the evt
     */
    private void BTN_Andar5ActionPerformed(ActionEvent evt) {

	sonic.doWalk(5).setAnimationSpeed(5);
    }

    /**
     * BT N girar 1 action performed.
     *
     * @param evt the evt
     */
    private void BTN_Girar1ActionPerformed(ActionEvent evt) {

	sonic.doSpin(1).setAnimationSpeed(1);
    }

    /**
     * BT N girar 2 action performed.
     *
     * @param evt the evt
     */
    private void BTN_Girar2ActionPerformed(ActionEvent evt) {

	sonic.doSpin(2).setAnimationSpeed(2);
    }

    /**
     * BT N girar 3 action performed.
     *
     * @param evt the evt
     */
    private void BTN_Girar3ActionPerformed(ActionEvent evt) {

	sonic.doSpin(3).setAnimationSpeed(3);
    }

    /**
     * BT N girar 4 action performed.
     *
     * @param evt the evt
     */
    private void BTN_Girar4ActionPerformed(ActionEvent evt) {

	sonic.doSpin(4).setAnimationSpeed(4);
    }

    /**
     * BT N parar action performed.
     *
     * @param evt the evt
     */
    private void BTN_PararActionPerformed(ActionEvent evt) {

	sonic.doStop();
    }

    /**
     * BT N esquerda action performed.
     *
     * @param evt the evt
     */
    private void BTN_EsquerdaActionPerformed(ActionEvent evt) {

	sonic.setOrientation(Orientation.LEFT);
    }

    /**
     * BT N direita action performed.
     *
     * @param evt the evt
     */
    private void BTN_DireitaActionPerformed(ActionEvent evt) {

	sonic.setOrientation(Orientation.RIGHT);
    }

    /**
     * JSL D vel animacao state changed.
     *
     * @param evt the evt
     */
    private void JSLD_VelAnimacaoStateChanged(ChangeEvent evt) {

	sonic.setAnimationSpeed(sliderAnimation.getValue());
    }

    /**
     * BT N correr 0 action performed.
     *
     * @param evt the evt
     */
    private void BTN_Correr0ActionPerformed(ActionEvent evt) {

	sonic.doRun(0).setAnimationSpeed(0);
    }

    /**
     * BT N correr 6 action performed.
     *
     * @param evt the evt
     */
    private void BTN_Correr6ActionPerformed(ActionEvent evt) {

	sonic.doRun(6).setAnimationSpeed(6);
    }

    /**
     * BT N correr 7 action performed.
     *
     * @param evt the evt
     */
    private void BTN_Correr7ActionPerformed(ActionEvent evt) {

	sonic.doRun(7).setAnimationSpeed(7);
    }

    /**
     * BT N andar 7 action performed.
     *
     * @param evt the evt
     */
    private void BTN_Andar7ActionPerformed(ActionEvent evt) {

	sonic.doWalk(7).setAnimationSpeed(7);
    }

    /**
     * BT N andar 6 action performed.
     *
     * @param evt the evt
     */
    private void BTN_Andar6ActionPerformed(ActionEvent evt) {

	sonic.doWalk(6).setAnimationSpeed(6);
    }

    /**
     * BT N andar 0 action performed.
     *
     * @param evt the evt
     */
    private void BTN_Andar0ActionPerformed(ActionEvent evt) {

	sonic.doWalk(0).setAnimationSpeed(0);
    }

    /**
     * BT N girar 5 action performed.
     *
     * @param evt the evt
     */
    private void BTN_Girar5ActionPerformed(ActionEvent evt) {

	sonic.doSpin(5).setAnimationSpeed(5);
    }

    /**
     * BT N girar 6 action performed.
     *
     * @param evt the evt
     */
    private void BTN_Girar6ActionPerformed(ActionEvent evt) {

	sonic.doSpin(6).setAnimationSpeed(6);
    }

    /**
     * BT N girar 7 action performed.
     *
     * @param evt the evt
     */
    private void BTN_Girar7ActionPerformed(ActionEvent evt) {

	sonic.doSpin(7).setAnimationSpeed(7);
    }

    /**
     * BT N dash 0 action performed.
     *
     * @param evt the evt
     */
    private void BTN_Dash0ActionPerformed(ActionEvent evt) {

	sonic.doDash(0).setAnimationSpeed(0);
    }

    /**
     * BT N dash 1 action performed.
     *
     * @param evt the evt
     */
    private void BTN_Dash1ActionPerformed(ActionEvent evt) {

	sonic.doDash(1).setAnimationSpeed(1);
    }

    /**
     * BT N dash 2 action performed.
     *
     * @param evt the evt
     */
    private void BTN_Dash2ActionPerformed(ActionEvent evt) {

	sonic.doDash(2).setAnimationSpeed(2);
    }

    /**
     * BT N dash 3 action performed.
     *
     * @param evt the evt
     */
    private void BTN_Dash3ActionPerformed(ActionEvent evt) {

	sonic.doDash(3).setAnimationSpeed(3);
    }

    /**
     * BT N dash 4 action performed.
     *
     * @param evt the evt
     */
    private void BTN_Dash4ActionPerformed(ActionEvent evt) {

	sonic.doDash(4).setAnimationSpeed(4);
    }

    /**
     * BT N dash 5 action performed.
     *
     * @param evt the evt
     */
    private void BTN_Dash5ActionPerformed(ActionEvent evt) {

	sonic.doDash(5).setAnimationSpeed(5);
    }

    /**
     * BT N dash 6 action performed.
     *
     * @param evt the evt
     */
    private void BTN_Dash6ActionPerformed(ActionEvent evt) {

	sonic.doDash(6).setAnimationSpeed(6);
    }

    /**
     * BT N dash 7 action performed.
     *
     * @param evt the evt
     */
    private void BTN_Dash7ActionPerformed(ActionEvent evt) {

	sonic.doDash(7).setAnimationSpeed(7);
    }

    /**
     * BT N abaixado action performed.
     *
     * @param evt the evt
     */
    private void BTN_AbaixadoActionPerformed(ActionEvent evt) {

	sonic.doDowned();
    }

    /**
     * BT N olhando action performed.
     *
     * @param evt the evt
     */
    private void BTN_OlhandoActionPerformed(ActionEvent evt) {

	sonic.doLooking();
    }

    /**
     * BT N freiando action performed.
     *
     * @param evt the evt
     */
    private void BTN_FreiandoActionPerformed(ActionEvent evt) {

	sonic.doBrakeUp();
    }

    /**
     * BT N empurrando action performed.
     *
     * @param evt the evt
     */
    private void BTN_EmpurrandoActionPerformed(ActionEvent evt) {

	sonic.doPush();
    }

    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {

	JButton[] btns = { btnDown, btnDowned, btnLook, btnLooking, btnStop, btnWait, btnPush, btnTransform,
		btnBreaking, btnDashZero, btnDashOne, btnDashTwo, btnDashThree, btnDashFour, btnDashFive, btnDashSix,
		btnDashSeven, btnWalkZero, btnWalkOne, btnWalkTwo, btnWalkThree, btnWalkFour, btnWalkFive, btnWalkSix,
		btnWalkSeven, btnRunZero, btnRunOne, btnRunTwo, btnRunThree, btnRunFour, btnRunFive, btnRunSix,
		btnRunSeven, btnSpinZero, btnSpinOne, btnSpinTwo, btnSpinThree, btnSpinFour, btnSpinFive, btnSpinSix,
		btnSpinSeven };

	while (true) {

	    if (sonic != null)

		doControlButtons(sonic.isAi(), btns);	    	
	    
	    	doRefreshComponents();
	}
	   
    }

    /* (non-Javadoc)
     * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
     */
    @Override
    public void update(Observable o, Object arg) {
	
	if(o != null)
	
	if (o instanceof Physicable) {	    
	    
	    switch ((Action) arg) {
		
		case BRAKEUP:
		    break;
		
		case DASH:
		    break;
		
		case DOWN:
		    break;
		
		case DOWNED:
		    break;
		
		case JUMP:
		    break;
		
		case LOOK:
		    break;
		
		case LOOKING:
		    break;
		
		case MOVE:
		    break;
		
		case PUSH:
		    break;
		
		case RUN:
		    break;
		
		case SPEEDUP:
		    break;
		
		case SPIN:
		    break;
		
		case STOP:{
		    btnStop.setForeground(Color.CYAN);
		}
		    break;
		
		case TRANSFORM:
		    break;
		
		case WAIT:
		    break;
		
		case WALK:
		    break;
		
		default:
		    break;
		
	    }
	    
	}
	
    }

}
