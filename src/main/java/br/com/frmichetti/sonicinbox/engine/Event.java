/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see mailto:frmichetti@gmail.com
 * */
package br.com.frmichetti.sonicinbox.engine;

import static br.com.frmichetti.sonicinbox.console.FrameAction.BTN_Down;
import static br.com.frmichetti.sonicinbox.console.FrameAction.BTN_Left;
import static br.com.frmichetti.sonicinbox.console.FrameAction.BTN_Right;
import static br.com.frmichetti.sonicinbox.console.FrameAction.BTN_Up;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import br.com.frmichetti.sonicinbox.Start;
import br.com.frmichetti.sonicinbox.enumeration.Action;
import br.com.frmichetti.sonicinbox.enumeration.ConfigEngine;
import br.com.frmichetti.sonicinbox.enumeration.Orientation;

public class Event implements KeyListener, Runnable {

	private boolean on;

	private Thread thread;	

	public Event() {

		thread = new Thread(Start.tgrpEngine, this, "Event Thread");

	}

	public Event(boolean on) {
		this();
		this.on = on;
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {

		if (Engine.sonic.isAi()) {

			if (e.getKeyCode() == KeyEvent.VK_SPACE) {

				if (Engine.sonic.isSuperSonic()) {

					Engine.sonic.setSuperSonic(false);

				} else {

					Engine.sonic.setSuperSonic(true);
				}

			}
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				
				Engine.lastkeypress.delete(0, 30);
				
				Engine.lastkeypress.append("RIGHT");
				
				BTN_Right.setVisible(false);
				
				delay();

				if (Engine.sonic.getAction() == Action.STOP && Engine.sonic.getOrientation() == Orientation.LEFT) {
				
					Engine.sonic.setOrientation(Orientation.RIGHT);
					
					Engine.sonic.doSpeedUp();
					
				} else if (Engine.sonic.getAction() == Action.MOVE && Engine.sonic.getOrientation() != Orientation.RIGHT) {

					Engine.sonic.doBrakeUp();

				} else {

					Engine.sonic.doSpeedUp();
				}

			}

			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
								
				Engine.lastkeypress.delete(0, 30);
				
				Engine.lastkeypress.append("LEFT");
				
				BTN_Left.setVisible(false);

				delay();
				
				if (Engine.sonic.getAction() == Action.STOP && Engine.sonic.getOrientation() == Orientation.RIGHT) {
				
					Engine.sonic.setOrientation(Orientation.LEFT);
					
					Engine.sonic.doSpeedUp();
					
				} else if (Engine.sonic.getAction() == Action.MOVE && Engine.sonic.getOrientation() != Orientation.LEFT) {

					Engine.sonic.doBrakeUp();

				} else {

					Engine.sonic.doSpeedUp();
				}

			}
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				
				Engine.lastkeypress.delete(0, 30);
				
				Engine.lastkeypress.append("UP");
				
				BTN_Up.setVisible(false);
				
				if (Engine.sonic.getSpeed() == 0) {
				
					Engine.sonic.setAction(Action.LOOK);
					
					Engine.sonic.setAction(Action.LOOKING);
				}

			}

			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
								
				Engine.lastkeypress.delete(0, 30);
				
				Engine.lastkeypress.append("DOWN");
				
				BTN_Down.setVisible(false);
				
				if (Engine.sonic.getSpeed() == 0) {
					
					Engine.sonic.setAction(Action.DOWN);
					
					Engine.sonic.setAction(Action.DOWNED);
					
				} else {
					
					Engine.sonic.doSpin(Engine.sonic.getAnimeSpeed());
				}

			}

		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (Engine.sonic.isAi()) {
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
				Engine.sonic.doStop();

			}

			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				Engine.lastkeypress.delete(0, Engine.lastkeypress.length());
				BTN_Down.setVisible(true);
				Engine.sonic.doStop();

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

		if (Engine.sonic.getSpeed() == 0) {

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
