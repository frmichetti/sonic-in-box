package br.com.codecode.sonicinbox.engine;

import static br.com.codecode.sonicinbox.enumeration.ConfigEngine.FPS;

import java.util.Observable;
import java.util.Observer;

import br.com.codecode.sonicinbox.Start;
import br.com.codecode.sonicinbox.enumeration.ConfigPhysics;

public class Physics extends Observable implements Runnable, Observer {

	private final float gravity = ConfigPhysics.GRAVITY.getValor();

	private boolean on;

	private Thread thread;	

	public Physics() {

		thread = new Thread(Start.tgrpEngine, this, "Physics Thread");

		addObserver(this);

	}

	public Physics(boolean on) {

		this();

		this.on = on;
	}

	private float doCalculateSpeed(float acceleration, float mass) {

		float res;

		res = acceleration * mass;

		setChanged();

		notifyObservers(res);

		return res;
	}

	public void doApplyPhysics() {

		if (Engine.sonic.getSpeed() > 0 && Engine.sonic.getSpeed() < 60) {

			Engine.sonic.setAcceleration((int) (Engine.sonic.getAcceleration() - (getResistance() / 10)));

		} else if (Engine.sonic.getSpeed() > 60 && Engine.sonic.getSpeed() < 100) {

			Engine.sonic.setAcceleration((int) (Engine.sonic.getAcceleration() - (getResistance() / 3)));

		} else if (Engine.sonic.getSpeed() > 100 && Engine.sonic.getSpeed() < 160) {

			Engine.sonic.setAcceleration((int) (Engine.sonic.getAcceleration() - (getResistance() / 2)));

		} else if (Engine.sonic.getSpeed() > 160) {

			Engine.sonic.setAcceleration((int) (Engine.sonic.getAcceleration() - getResistance()));

		}

	}

	public float getGravity() {
		return gravity;
	}

	public float getResistance() {
		return Engine.sonic.getResistance();
	}

	public synchronized void setSpeed(float speed) {
		Engine.sonic.setSpeed(speed);
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

			doCalculateSpeed(Engine.sonic.getAcceleration(), Engine.sonic.getMass());

			doApplyPhysics();

			assert (Engine.sonic.getSpeed() >= 0) : "VELOCIDADE NAO PERMITIDA " + Engine.sonic.getSpeed();

			try {
				
				Thread.sleep(FPS.getValue());

			} catch (InterruptedException ex) {

				throw new RuntimeException("Falha ao Interromper " + thread.getName() + " " + ex);
			}

		}

	}


}
