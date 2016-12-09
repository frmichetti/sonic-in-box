package br.com.codecode.sonicinbox.engine;



import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import br.com.codecode.sonicinbox.Start;
import br.com.codecode.sonicinbox.enumeration.Action;
import br.com.codecode.sonicinbox.enumeration.ConfigEngine;
import br.com.codecode.sonicinbox.enumeration.Orientation;
import br.com.codecode.sonicinbox.motion.Sonic;

public final class EventListener implements KeyListener, Runnable {	

	private boolean on;

	private Thread thread;

	private Sonic sonic;
	
	private StringBuffer lastkeypress;

	private EventListener() {

		thread = new Thread(Start.tgrpEngine, this, "EventListener Thread");

	}

	public EventListener(Engine engine, boolean on) {
		this();		
		this.sonic = engine.sonic;
		this.lastkeypress = engine.lastkeypress;		
		this.on = on;
	}

	@Override
	public void keyTyped(KeyEvent e){}

	@Override
	public void keyPressed(KeyEvent e) {
		
		if(sonic != null)

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
				
				//frameAction.BTN_Right.setVisible(false);
				
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
				
				//frameAction.BTN_Left.setVisible(false);

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
				
				//frameAction.BTN_Up.setVisible(false);
				
				if (sonic.getSpeed() == 0) {
				
					sonic.setAction(Action.LOOK);
					
					sonic.setAction(Action.LOOKING);
				}

			}

			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
								
				lastkeypress.delete(0, 30);
				
				lastkeypress.append("DOWN");
				
				//frameAction.BTN_Down.setVisible(false);
				
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
		
		if(sonic != null)
			
		if (sonic.isAi()) {
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				lastkeypress.delete(0, lastkeypress.length());
				//frameAction.BTN_Right.setVisible(true);

			}

			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				lastkeypress.delete(0, lastkeypress.length());
				//frameAction.BTN_Left.setVisible(true);

			}

			if (e.getKeyCode() == KeyEvent.VK_UP) {
				lastkeypress.delete(0, lastkeypress.length());
				//frameAction.BTN_Up.setVisible(true);
				sonic.doStop();

			}

			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				lastkeypress.delete(0, lastkeypress.length());
				//frameAction.BTN_Down.setVisible(true);
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


	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(ConfigEngine.FPS.getValue());

			} catch (InterruptedException ex) {
				throw new RuntimeException("Falha ao Interromper " + thread.getName() + " " + ex);
			}

		}
	}


}
