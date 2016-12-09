package br.com.codecode.sonicinbox.engine;

import static br.com.codecode.sonicinbox.console.FrameAction.BTN_Down;
import static br.com.codecode.sonicinbox.console.FrameAction.BTN_Left;
import static br.com.codecode.sonicinbox.console.FrameAction.BTN_Right;
import static br.com.codecode.sonicinbox.console.FrameAction.BTN_Up;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import br.com.codecode.sonicinbox.Start;
import br.com.codecode.sonicinbox.enumeration.Action;
import br.com.codecode.sonicinbox.enumeration.ConfigEngine;
import br.com.codecode.sonicinbox.enumeration.Orientation;
import br.com.codecode.sonicinbox.motion.Sonic;

public class Event implements KeyListener, Runnable {

	private boolean on;

	private Thread thread;

	private Sonic sonic;	

	private Event() {

		thread = new Thread(Start.tgrpEngine, this, "Event Thread");

	}

	public Event(Sonic sonic, boolean on) {
		this();
		this.sonic = sonic;
		this.on = on;
	}

	@Override
	public void keyTyped(KeyEvent e){}

	@Override
	public void keyPressed(KeyEvent e) {

		if (sonic.isAi()) {

			if (e.getKeyCode() == KeyEvent.VK_SPACE) {

				if (sonic.isSuperSonic()) {

					sonic.setSuperSonic(false);

				} else {

					sonic.setSuperSonic(true);
				}

			}
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				
				Engine.lastkeypress.delete(0, 30);
				
				Engine.lastkeypress.append("RIGHT");
				
				BTN_Right.setVisible(false);
				
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
								
				Engine.lastkeypress.delete(0, 30);
				
				Engine.lastkeypress.append("LEFT");
				
				BTN_Left.setVisible(false);

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
				
				Engine.lastkeypress.delete(0, 30);
				
				Engine.lastkeypress.append("UP");
				
				BTN_Up.setVisible(false);
				
				if (sonic.getSpeed() == 0) {
				
					sonic.setAction(Action.LOOK);
					
					sonic.setAction(Action.LOOKING);
				}

			}

			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
								
				Engine.lastkeypress.delete(0, 30);
				
				Engine.lastkeypress.append("DOWN");
				
				BTN_Down.setVisible(false);
				
				if (sonic.getSpeed() == 0) {
					
					sonic.setAction(Action.DOWN);
					
					sonic.setAction(Action.DOWNED);
					
				} else {
					
					sonic.doSpin(sonic.getAnimeSpeed());
				}

			}

		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (sonic.isAi()) {
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				Engine.lastkeypress.delete(0, Engine.lastkeypress.length());
				BTN_Right.setVisible(true);

			}

			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				Engine.lastkeypress.delete(0, Engine.lastkeypress.length());
				BTN_Left.setVisible(true);

			}

			if (e.getKeyCode() == KeyEvent.VK_UP) {
				Engine.lastkeypress.delete(0, Engine.lastkeypress.length());
				BTN_Up.setVisible(true);
				sonic.doStop();

			}

			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				Engine.lastkeypress.delete(0, Engine.lastkeypress.length());
				BTN_Down.setVisible(true);
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

	public Thread getThread() {
		return thread;
	}

	@Override
	public void run() {
		while (isOn()) {
			try {
				Thread.sleep(ConfigEngine.FPS.getValue());

			} catch (InterruptedException ex) {
				throw new RuntimeException("Falha ao Interromper " + thread.getName() + " " + ex);
			}

		}
	}


}
