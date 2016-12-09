package br.com.codecode.sonicinbox.engine;

import static br.com.codecode.sonicinbox.enumeration.ConfigEngine.FPS;

import java.util.Observable;
import java.util.Observer;

import br.com.codecode.sonicinbox.Start;
import br.com.codecode.sonicinbox.enumeration.ConfigPhysics;
import br.com.codecode.sonicinbox.interfaces.Physicable;
import br.com.codecode.sonicinbox.motion.Sonic;
/**
 * This Class Apply Physics on Physicable Characters
 * @author felipe
 * @see Physicable
 * @see Observable
 * @see Runnable
 * @see Observer  
 * @since 1.0
 * @version 1.1
 */
public class Physics extends Observable implements Runnable, Observer {

	private final float gravity = ConfigPhysics.GRAVITY.getValue();

	private boolean on;

	private Thread thread;	
	
	private Physicable sonic;

	private Physics() {

		thread = new Thread(Start.tgrpEngine, this, "Physics Thread");

		addObserver(this);

	}

	public Physics(Sonic sonic,boolean on) {

		this();		
		
		this.sonic = sonic;
		
		this.on = on;
	}

	private float doCalculateSpeed(float acceleration, float mass) {

		float res;

		res = acceleration * mass;

		setChanged();

		notifyObservers(res);

		return res;
	}

	public void doApplyPhysics(Physicable sonic) {
		
		doCalculateSpeed(sonic.getAcceleration(), sonic.getMass());

		if (sonic.getSpeed() > 0 && sonic.getSpeed() < 60) {

			sonic.setAcceleration((int) (sonic.getAcceleration() - (getResistance() / 10)));

		} else if (sonic.getSpeed() > 60 && sonic.getSpeed() < 100) {

			sonic.setAcceleration((int) (sonic.getAcceleration() - (getResistance() / 3)));

		} else if (sonic.getSpeed() > 100 && sonic.getSpeed() < 160) {

			sonic.setAcceleration((int) (sonic.getAcceleration() - (getResistance() / 2)));

		} else if (sonic.getSpeed() > 160) {

			sonic.setAcceleration((int) (sonic.getAcceleration() - getResistance()));

		}

	}

	public float getGravity() {
		return gravity;
	}

	public float getResistance() {
		return sonic.getResistance();
	}

	public synchronized void setSpeed(float speed) {
		sonic.setSpeed(speed);
	}

	@Override
	public void update(Observable o, Object arg) {
		setSpeed((float) arg);
	}

	public boolean isOn() {
		return on;
	}

	public void setOn(boolean on) {
		this.on = on;
	}


	public Thread getThread() {
		return thread;
	}

	@Override
	public void run() {

		while (isOn()) {
			
			if(sonic != null)			

			doApplyPhysics(sonic);			

			try {
				
				Thread.sleep(FPS.getValue());

			} catch (InterruptedException ex) {

				throw new RuntimeException("Falha ao Interromper " + thread.getName() + " " + ex);
			}

		}

	}


}
