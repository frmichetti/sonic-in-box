package br.com.codecode.sonicinbox.engine;

import java.util.Observable;
import java.util.Observer;

import br.com.codecode.sonicinbox.Start;
import br.com.codecode.sonicinbox.enums.ConfigPhysics;
import br.com.codecode.sonicinbox.interfaces.Physicable;
import br.com.codecode.sonicinbox.interfaces.Syncronizeable;

/**
 * This Class Apply Physics on Physicable Characters
 * 
 * @author felipe
 * @see Physicable
 * @see Observable
 * @see Runnable
 * @see Observer
 * @since 1.0
 * @version 1.1
 */
public final class Physics extends Observable implements Runnable, Observer , Syncronizeable{

    private final float gravity = ConfigPhysics.GRAVITY.getValue();

    private boolean on;

    protected Thread thread;

    private Physicable physicable;

    private Physics() {

	thread = new Thread(Start.tgrpEngine, this, "Physics Thread");

	addObserver(this);

    }

    public Physics(Physicable physicable, boolean on) {

	this();

	this.physicable = physicable;

	this.on = on;
    }

    private float doCalculateSpeed(float acceleration, float mass) {

	float res;

	res = acceleration * mass;

	setChanged();

	notifyObservers(res);

	return res;
    }

    public void doApplyPhysics(Physicable physicable) {

	doCalculateSpeed(physicable.getAcceleration(), physicable.getMass());

	if (physicable.getSpeed() > 0 && physicable.getSpeed() < 60) {

	    physicable.setAcceleration((int) (physicable.getAcceleration() - (physicable.getResistance() / 10)));

	} else if (physicable.getSpeed() > 60 && physicable.getSpeed() < 100) {

	    physicable.setAcceleration((int) (physicable.getAcceleration() - (physicable.getResistance() / 3)));

	} else if (physicable.getSpeed() > 100 && physicable.getSpeed() < 160) {

	    physicable.setAcceleration((int) (physicable.getAcceleration() - (physicable.getResistance() / 2)));

	} else if (physicable.getSpeed() > 160) {

	    physicable.setAcceleration((int) (physicable.getAcceleration() - physicable.getResistance()));

	}

    }

    public float getGravity() {

	return gravity;
    }

    @Override
    public void update(Observable o, Object arg) {

	physicable.setSpeed((float) arg);
    }

    public boolean isOn() {

	return on;
    }

    public void setOn(boolean on) {

	this.on = on;
    }

    @Override
    public void run() {

	while (isOn()) {

	    if (physicable != null)

		doApplyPhysics(physicable);

	    try {

		Thread.sleep(FPS);

	    } catch (InterruptedException ex) {

		throw new RuntimeException(ex);
	    }

	}

    }

}
