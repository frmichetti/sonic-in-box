package br.com.codecode.sonicinbox.engine;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import br.com.codecode.sonicinbox.console.FrameAction;
import br.com.codecode.sonicinbox.enums.Action;
import br.com.codecode.sonicinbox.enums.Orientation;
import br.com.codecode.sonicinbox.motion.Sonic;

public final class EventListener implements KeyListener {

    private boolean on;

    private Sonic sonic;

    private StringBuffer lastkeypress;

    private EventListener(){}

    public EventListener(Engine engine, boolean on) {
	this();
	this.sonic = engine.getSonic();
	this.lastkeypress = engine.getLastkeypress();
	this.on = on;
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {

	if (sonic != null)

	    if (sonic.isAi()) {

		if (e.getKeyCode() == KeyEvent.VK_SPACE) {

		    if (sonic.isSuperSonic()) {

			sonic.setSuperSonic(false);

		    } else {

			sonic.setSuperSonic(true);
		    }

		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

		    lastkeypress.delete(0, 30);

		    lastkeypress.append("RIGHT");

		    FrameAction.btnRight.setVisible(false);

		    delay();

		    if (sonic.getAction() == Action.STOP && sonic.getOrientation() == Orientation.LEFT) {

			sonic.setOrientation(Orientation.RIGHT);

			sonic.doSpeedUp();

		    } else if (sonic.getAction() == Action.MOVE && sonic.getOrientation() != Orientation.RIGHT) {

			sonic.doBrakeUp();

		    } else {

			sonic.doSpeedUp();
		    }

		}

		if (e.getKeyCode() == KeyEvent.VK_LEFT) {

		    lastkeypress.delete(0, 30);

		    lastkeypress.append("LEFT");

		    FrameAction.btnLeft.setVisible(false);

		    delay();

		    if (sonic.getAction() == Action.STOP && sonic.getOrientation() == Orientation.RIGHT) {

			sonic.setOrientation(Orientation.LEFT);

			sonic.doSpeedUp();

		    } else if (sonic.getAction() == Action.MOVE && sonic.getOrientation() != Orientation.LEFT) {

			sonic.doBrakeUp();

		    } else {

			sonic.doSpeedUp();
		    }

		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {

		    lastkeypress.delete(0, 30);

		    lastkeypress.append("UP");

		    FrameAction.btnUp.setVisible(false);

		    if (sonic.getSpeed() == 0) {

			sonic.setAction(Action.LOOK);

			sonic.setAction(Action.LOOKING);
		    }

		}

		if (e.getKeyCode() == KeyEvent.VK_DOWN) {

		    lastkeypress.delete(0, 30);

		    lastkeypress.append("DOWN");

		    FrameAction.btnDown.setVisible(false);

		    if (sonic.getSpeed() == 0) {

			sonic.setAction(Action.DOWN);

			sonic.setAction(Action.DOWNED);

		    } else {

			sonic.doSpin(sonic.getAnimationSpeed());
		    }

		}

	    }

    }

    @Override
    public void keyReleased(KeyEvent e) {

	if (sonic != null)

	    if (sonic.isAi()) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
		    lastkeypress.delete(0, lastkeypress.length());
		    FrameAction.btnRight.setVisible(true);

		}

		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
		    lastkeypress.delete(0, lastkeypress.length());
		    FrameAction.btnLeft.setVisible(true);

		}

		if (e.getKeyCode() == KeyEvent.VK_UP) {
		    lastkeypress.delete(0, lastkeypress.length());
		    FrameAction.btnUp.setVisible(true);
		    sonic.doStop();

		}

		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
		    lastkeypress.delete(0, lastkeypress.length());
		    FrameAction.btnDown.setVisible(true);
		    sonic.doStop();

		}
	    }

    }

    public boolean isOn() {

	return on;
    }

    public void setOn(boolean on) {

	this.on = on;
    }

    private void delay() {

	int i = 0;

	if (sonic.getSpeed() == 0) {

	    do {
		i++;
	    } while (i < 7_000);

	}
    }
    

}
