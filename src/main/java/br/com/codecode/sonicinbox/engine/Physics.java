package br.com.codecode.sonicinbox.engine;

import java.util.Observable;
import java.util.Observer;

import br.com.codecode.sonicinbox.Start;
import br.com.codecode.sonicinbox.enums.ConfigPhysics;
import br.com.codecode.sonicinbox.interfaces.Physicable;
import br.com.codecode.sonicinbox.interfaces.Syncronizeable;

// TODO: Auto-generated Javadoc
/**
 * This Class Apply Physics on Physicable Characters.
 *
 * @author felipe
 * @version 1.1
 * @see Physicable
 * @see Observable
 * @see Runnable
 * @see Observer
 * @since 1.0
 */
public final class Physics extends Observable implements Runnable, Observer , Syncronizeable{

    /** The gravity. */
    private final float gravity = ConfigPhysics.GRAVITY.getValue();

    /** The on. */
    private boolean on;

    /** The thread. */
    protected Thread thread;

    /** The physicable. */
    private Physicable physicable;

    /**
     * Instantiates a new physics.
     */
    private Physics() {

	thread = new Thread(Start.tgrpEngine, this, "Physics Thread");

	addObserver(this);

    }

    /**
     * Instantiates a new physics.
     *
     * @param physicable the physicable
     * @param on the on
     */
    public Physics(Physicable physicable, boolean on) {

	this();

	this.physicable = physicable;

	this.on = on;
    }

    /**
     * Do calculate speed.
     *
     * @param acceleration the acceleration
     * @param mass the mass
     * @return the float
     */
    private float doCalculateSpeed(float acceleration, float mass) {

	float res;

	res = acceleration * mass;

	setChanged();

	notifyObservers(res);

	return res;
    }

    /**
     * Do apply physics.
     *
     * @param physicable the physicable
     */
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

    /**
     * Gets the gravity.
     *
     * @return the gravity
     */
    public float getGravity() {

	return gravity;
    }

    /* (non-Javadoc)
     * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
     */
    @Override
    public void update(Observable o, Object arg) {

	physicable.setSpeed((float) arg);
    }

    /**
     * Checks if is on.
     *
     * @return true, if is on
     */
    public boolean isOn() {

	return on;
    }

    /**
     * Sets the on.
     *
     * @param on the new on
     */
    public void setOn(boolean on) {

	this.on = on;
    }

    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
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
