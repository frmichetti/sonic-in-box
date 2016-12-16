package br.com.codecode.sonicinbox.motion;

import java.awt.Image;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import br.com.codecode.sonicinbox.Start;
import br.com.codecode.sonicinbox.enums.Action;
import br.com.codecode.sonicinbox.enums.ConfigSonic;
import br.com.codecode.sonicinbox.enums.ConfigSuperSonic;
import br.com.codecode.sonicinbox.enums.Orientation;
import br.com.codecode.sonicinbox.interfaces.Animated;
import br.com.codecode.sonicinbox.interfaces.Moveable;
import br.com.codecode.sonicinbox.interfaces.Physicable;
import br.com.codecode.sonicinbox.interfaces.Syncronizeable;

// TODO: Auto-generated Javadoc
/**
 * Sonic Character.
 *
 * @author felipe
 * @version 3.0
 * @see Observable
 * @see Animated
 * @see Moveable
 * @see Physicable
 * @see Observer
 * @see Runnable
 * @since 1.0
 */
public final class Sonic extends Observable implements Animated, Moveable, Physicable, Observer, Runnable, Syncronizeable {

    /** The speed. */
    private float acceleration, mass, resistance, speed;

    /** The action. */
    private Action action;

    /** The ai. */
    private boolean ai;

    /** The animation. */
    private Animation animation;

    /** The animation speed. */
    private int animationSpeed;    

    /** The movimentation. */
    private Movimentation movimentation;

    /** The orientation. */
    private Orientation orientation;

    /** The sprites. */
    private Sprites sprites;

    /** The super sonic. */
    private boolean superSonic;

    /** The thread. */
    private Thread thread;

    /** The h. */
    private int X, Y, W, H;

    /**
     * Instantiates a new sonic.
     */
    private Sonic() {

	super.addObserver(this);

	this.thread = new Thread(Start.tgrpSonic, this, "Sonic Thread");

	this.W = ConfigSonic.WIDTH.getValue();

	this.H = ConfigSonic.HEIGHT.getValue();

	this.X = ConfigSonic.SX.getValue();

	this.Y = ConfigSonic.SY.getValue();

	this.mass = ConfigSonic.MASS.getValue();

	this.resistance = ConfigSonic.RESISTANCE.getValue();

	this.orientation = Orientation.RIGHT;

	this.animationSpeed = 5;

	this.action = Action.STOP;

	this.animation = new Animation(this);

	this.movimentation = new Movimentation(this);

    }

    /**
     * Instantiates a new sonic.
     *
     * @param from the from
     * @param ai the ai
     */
    public Sonic(String from, boolean ai) {
	this();
	this.ai = ai;

	doLoadSprites(from);

	ExecutorService executor = Executors.newFixedThreadPool(2);

	executor.execute(movimentation);

	executor.execute(animation);

	executor.shutdown();
    }

    /**
     * Do brake up.
     *
     * @return the sonic
     */
    public Sonic doBrakeUp() {

	if (getAction() != Action.STOP && getAction() != Action.SPEEDUP && getSpeed() > 10_000
		&& getAcceleration() > 200) {
	    setAcceleration((int) (getAcceleration() - 120));
	    setChanged();
	    notifyObservers(Action.BRAKEUP);

	    if (getSpeed() > 0 && getAcceleration() > 200) {
		setChanged();
		notifyObservers(Action.MOVE);
	    } else {
		setChanged();
		notifyObservers(Action.STOP);
	    }

	} else if (!isAi()) {
	    setChanged();
	    notifyObservers(Action.BRAKEUP);
	}
	return this;
    }

    /**
     * Do dash.
     *
     * @param speed the speed
     * @return the sonic
     */
    public Sonic doDash(int speed) {

	if (getAction() == Action.DASH && getSpeed() == 0) {
	    setChanged();
	    notifyObservers(Action.DASH);
	} else if (!isAi()) {
	    setChanged();
	    notifyObservers(Action.DASH);
	}
	return this;

    }

    /**
     * Do down.
     *
     * @return the sonic
     */
    public Sonic doDown() {

	if (getAction() == Action.DOWN && getSpeed() == 0) {
	    setChanged();
	    notifyObservers(Action.DOWN);
	} else if (!isAi()) {
	    setChanged();
	    notifyObservers(Action.DOWN);
	}

	return this;

    }

    /**
     * Do downed.
     *
     * @return the sonic
     */
    public Sonic doDowned() {

	if (getAction() == Action.DOWNED && getSpeed() == 0) {
	    setChanged();
	    notifyObservers(Action.DOWNED);
	} else if (!isAi()) {
	    setChanged();
	    notifyObservers(Action.DOWNED);
	}

	return this;
    }

    /**
     * Do jump.
     *
     * @return the sonic
     */
    public Sonic doJump() {

	setChanged();
	notifyObservers(Action.JUMP);
	return this;
    }

    /**
     * Do load sprites.
     *
     * @param from the from
     */
    private void doLoadSprites(String from) {

	sprites = new Sprites(from);

	ExecutorService taskExecutor = Executors.newFixedThreadPool(1);

	taskExecutor.execute(sprites);

	taskExecutor.shutdown();

	try {

	    taskExecutor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);

	} catch (InterruptedException e) {
	    throw new RuntimeException(e);
	}

    }

    /**
     * Do look.
     *
     * @return the sonic
     */
    public Sonic doLook() {

	if (getAction() == Action.LOOK && getSpeed() == 0) {
	    setChanged();
	    notifyObservers(Action.LOOK);
	} else if (!isAi()) {
	    setChanged();
	    notifyObservers(Action.LOOK);
	}
	return this;

    }

    /**
     * Do looking.
     *
     * @return the sonic
     */
    public Sonic doLooking() {

	if (getAction() == Action.LOOKING && getSpeed() == 0) {
	    setChanged();
	    notifyObservers(Action.LOOKING);
	} else if (!isAi()) {
	    setChanged();
	    notifyObservers(Action.LOOKING);
	}

	return this;

    }

    /**
     * Do push.
     *
     * @return the sonic
     */
    public Sonic doPush() {

	if (getAction() == Action.STOP) {
	    setChanged();
	    notifyObservers(Action.PUSH);
	} else if (!isAi()) {
	    setChanged();
	    notifyObservers(Action.PUSH);
	}
	return this;
    }

    /**
     * Do run.
     *
     * @param speed the speed
     * @return the sonic
     */
    public Sonic doRun(int speed) {

	if (getAction() == Action.MOVE) {
	    setAnimationSpeed(speed);
	    setChanged();
	    notifyObservers(Action.RUN);
	} else if (!isAi()) {
	    setChanged();
	    notifyObservers(Action.RUN);
	}

	return this;

    }

    /**
     * Do speed up.
     *
     * @return the sonic
     */
    public Sonic doSpeedUp() {

	if (getAction() != Action.BRAKEUP && getAcceleration() <= 1_700) {
	    setAcceleration((int) (getAcceleration() + 200));
	    setChanged();
	    notifyObservers(Action.MOVE);
	}
	return this;

    }

    /**
     * Do spin.
     *
     * @param speed the speed
     * @return the sonic
     */
    public Sonic doSpin(int speed) {

	if (getAction() == Action.MOVE && getSpeed() > 100) {
	    setAnimationSpeed(speed);
	    setChanged();
	    notifyObservers(Action.SPIN);
	} else if (!isAi()) {
	    setChanged();
	    notifyObservers(Action.SPIN);
	}

	return this;

    }

    /**
     * Do stop.
     *
     * @return the sonic
     */
    public Sonic doStop() {

	if (getAction() != Action.STOP && getSpeed() == 0) {
	    setChanged();
	    notifyObservers(Action.STOP);
	} else if (!isAi()) {
	    setChanged();
	    notifyObservers(Action.STOP);
	}
	return this;
    }

    /**
     * Do transform.
     *
     * @return the sonic
     */
    public Sonic doTransform() {

	if (getAction() == Action.TRANSFORM && !isSuperSonic() && getSpeed() == 0) {
	    setChanged();
	    notifyObservers(Action.TRANSFORM);

	} else if (!isAi()) {
	    setChanged();
	    notifyObservers(Action.TRANSFORM);
	}
	return this;
    }

    /**
     * Do wait.
     *
     * @return the sonic
     */
    public Sonic doWait() {

	if (getAction() == Action.WAIT && getSpeed() == 0) {
	    setChanged();
	    notifyObservers(Action.WAIT);
	} else if (!isAi()) {
	    setChanged();
	    notifyObservers(Action.WAIT);
	}

	return this;
    }

    /**
     * Do walk.
     *
     * @param speed the speed
     * @return the sonic
     */
    public Sonic doWalk(int speed) {

	if (getAction() == Action.MOVE) {
	    setAnimationSpeed(speed);
	    setChanged();
	    notifyObservers(Action.WALK);
	} else if (!isAi()) {
	    setChanged();
	    notifyObservers(Action.WALK);
	}

	return this;
    }

    /* (non-Javadoc)
     * @see br.com.codecode.sonicinbox.interfaces.Physicable#getAcceleration()
     */
    @Override
    public float getAcceleration() {

	return acceleration;
    }

    /* (non-Javadoc)
     * @see br.com.codecode.sonicinbox.interfaces.Animated#getAction()
     */
    @Override
    public Enum<? extends Action> getAction() {

	return action;
    }

    /* (non-Javadoc)
     * @see br.com.codecode.sonicinbox.interfaces.Animated#getAnimationSpeed()
     */
    @Override
    public int getAnimationSpeed() {

	return animationSpeed;
    }

    /* (non-Javadoc)
     * @see br.com.codecode.sonicinbox.interfaces.Animated#getCurrentFrame()
     */
    @Override
    public int getCurrentFrame() {

	return animation.getCurrentFrame();
    }

    /* (non-Javadoc)
     * @see br.com.codecode.sonicinbox.interfaces.Animated#getFinalFrame()
     */
    @Override
    public int getFinalFrame() {

	return animation.getFinalFrame();
    }

    /**
     * Gets the h.
     *
     * @return the h
     */
    public int getH() {

	return H;
    }

    /**
     * Gets the image.
     *
     * @param index the index
     * @return the image
     */
    public Image getImage(int index) {

	return sprites.getImage(index);
    }

    /* (non-Javadoc)
     * @see br.com.codecode.sonicinbox.interfaces.Animated#getInitFrame()
     */
    @Override
    public int getInitFrame() {

	return animation.getInitFrame();
    }

    /* (non-Javadoc)
     * @see br.com.codecode.sonicinbox.interfaces.Physicable#getMass()
     */
    @Override
    public float getMass() {

	return mass;
    }

    /**
     * Gets the movimentation.
     *
     * @return the movimentation
     */
    public Movimentation getMovimentation() {

	return movimentation;
    }

    /**
     * Gets the orientation.
     *
     * @return the orientation
     */
    public Orientation getOrientation() {

	return orientation;

    }

    /* (non-Javadoc)
     * @see br.com.codecode.sonicinbox.interfaces.Physicable#getResistance()
     */
    @Override
    public float getResistance() {

	return resistance;
    }

    /* (non-Javadoc)
     * @see br.com.codecode.sonicinbox.interfaces.Physicable#getSpeed()
     */
    @Override
    public float getSpeed() {

	return speed;
    }

    /**
     * Gets the thread.
     *
     * @return the thread
     */
    public Thread getThread() {

	return thread;
    }

    /**
     * Gets the w.
     *
     * @return the w
     */
    public int getW() {

	return W;
    }

    /* (non-Javadoc)
     * @see br.com.codecode.sonicinbox.interfaces.Moveable#getX()
     */
    @Override
    public int getX() {

	return X;
    }

    /* (non-Javadoc)
     * @see br.com.codecode.sonicinbox.interfaces.Moveable#getY()
     */
    @Override
    public int getY() {

	return Y;
    }

    /**
     * Checks if is ai.
     *
     * @return true, if is ai
     */
    public boolean isAi() {

	return ai;
    }

    /**
     * Checks if is super sonic.
     *
     * @return true, if is super sonic
     */
    public boolean isSuperSonic() {

	return superSonic;
    }

    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {

	while (true) {

	    setAI(isAi());

	    {
		try {

		    Thread.sleep(FPS);

		} catch (InterruptedException ex) {

		    throw new RuntimeException(ex);

		}

	    }

	}
    }

    /* (non-Javadoc)
     * @see br.com.codecode.sonicinbox.interfaces.Physicable#setAcceleration(float)
     */
    @Override
    public synchronized void setAcceleration(float acceleration) {

	this.acceleration = acceleration;
    }

    /**
     * Sets the action.
     *
     * @param action the new action
     */
    public synchronized void setAction(Action action) {

	this.action = action;
    }

    /**
     * Sets the ai.
     *
     * @param ai the new ai
     */
    public void setAi(boolean ai) {

	this.ai = ai;
    }

    /**
     * Sets the ai.
     *
     * @param ai the new ai
     */
    private void setAI(boolean ai) {

	if (isAi()) {

	    switch ((Action) getAction()) {

		case STOP: {} break;

		case WAIT: {

		    assert (getSpeed() == 0) : "Forbidden";

		    doWait();

		}
		    break;

		case DOWN: {

		    assert (getSpeed() == 0) : "Forbidden";

		    doDown();

		}
		case DOWNED: {

		    assert (getSpeed() == 0) : "Forbidden";

		    doDowned();

		}
		    break;

		case LOOK: {

		    assert (getSpeed() == 0) : "Forbidden";

		    doLook();

		}
		case LOOKING: {

		    assert (getSpeed() == 0) : "Forbidden";

		    doLooking();

		}
		    break;
		case PUSH: {

		    assert (getSpeed() == 0) : "Forbidden";

		    doPush();

		}
		    break;

		case SPIN: {

		    if (getSpeed() > 0 && getSpeed() < 8) {

			doSpin(8);

		    } else if (getSpeed() >= 8 && getSpeed() < 20) {

			doSpin(7);

		    } else if (getSpeed() >= 20 && getSpeed() < 60) {

			doSpin(6);

		    } else if (getSpeed() >= 60 && getSpeed() < 100) {

			doSpin(5);

		    } else if (getSpeed() >= 100 && getSpeed() < 10_000) {

			doSpin(4);

		    } else if (getSpeed() >= 10_000 && getSpeed() < 20_000) {

			doSpin(3);

		    } else if (getSpeed() >= 20_000 && getSpeed() < 30_000) {

			doSpin(2);

		    } else if (getSpeed() >= 30_000 && getSpeed() < 40_000) {

			doSpin(1);

		    } else if (getSpeed() >= 40_000 && getSpeed() < 50_000) {

			doSpin(5);

		    } else if (getSpeed() >= 50_000 && getSpeed() < 60_000) {

			doSpin(4);

		    } else if (getSpeed() >= 60_000 && getSpeed() < 70_000) {

			doSpin(3);

		    } else if (getSpeed() >= 70_000 && getSpeed() < 80_000) {

			doSpin(2);

		    } else if (getSpeed() >= 80_000 && getSpeed() < 90_000) {

			doSpin(1);

		    } else if (getSpeed() >= 90_000 && getSpeed() < 100_000) {

			doSpin(0);

		    } else if (getSpeed() >= 100_000 && getSpeed() < 110_000) {

			doSpin(0);

		    } else if (getSpeed() >= 110_000 && getSpeed() < 120_000) {

			doSpin(0);

		    } else if (getSpeed() >= 120_000 && getSpeed() < 130_000) {

			doSpin(0);

		    } else if (getSpeed() >= 130_000) {

			doSpin(0);

		    } else if (getSpeed() == 0) {

			doStop();

			setChanged();

			notifyObservers(Action.STOP);

		    }

		}
		    break;

		case TRANSFORM: {

		    doTransform();
		}

		    break;

		case DASH: {

		    doDash(0);
		}

		    break;

		case BRAKEUP: {

		    assert (getAction() == Action.MOVE && getSpeed() > 0) : "Forbidden - FREIANDO PARADO";

		    doBrakeUp();

		    setChanged();

		    notifyObservers(Action.MOVE);

		}
		    break;

		case SPEEDUP: {

		    assert (getAction() != Action.BRAKEUP) : "Forbidden";

		    doSpeedUp();

		}
		    break;

		case MOVE: {
		    if (getSpeed() > 0 && getSpeed() < 8) {

			doWalk(8);

			setChanged();

			notifyObservers(Action.MOVE);

		    } else if (getSpeed() >= 8 && getSpeed() < 20) {

			doWalk(7);

			setChanged();

			notifyObservers(Action.MOVE);

		    } else if (getSpeed() >= 20 && getSpeed() < 60) {

			doWalk(6);

			setChanged();

			notifyObservers(Action.MOVE);

		    } else if (getSpeed() >= 60 && getSpeed() < 100) {

			doWalk(5);

			setChanged();

			notifyObservers(Action.MOVE);

		    } else if (getSpeed() >= 100 && getSpeed() < 10_000) {

			doWalk(4);

			setChanged();

			notifyObservers(Action.MOVE);

		    } else if (getSpeed() >= 10_000 && getSpeed() < 20_000) {

			doWalk(3);

			setChanged();

			notifyObservers(Action.MOVE);

		    } else if (getSpeed() >= 20_000 && getSpeed() < 30_000) {

			doWalk(2);

			setChanged();

			notifyObservers(Action.MOVE);

		    } else if (getSpeed() >= 30_000 && getSpeed() < 40_000) {

			doWalk(1);

			setChanged();

			notifyObservers(Action.MOVE);

		    } else if (getSpeed() >= 40_000 && getSpeed() < 50_000) {

			doRun(5);

			setChanged();

			notifyObservers(Action.MOVE);

		    } else if (getSpeed() >= 50_000 && getSpeed() < 60_000) {

			doRun(4);

			setChanged();

			notifyObservers(Action.MOVE);

		    } else if (getSpeed() >= 60_000 && getSpeed() < 70_000) {

			doRun(3);

			setChanged();

			notifyObservers(Action.MOVE);

		    } else if (getSpeed() >= 70_000 && getSpeed() < 80_000) {

			doRun(2);

			setChanged();

			notifyObservers(Action.MOVE);

		    } else if (getSpeed() >= 80_000 && getSpeed() < 90_000) {

			doRun(1);

			setChanged();

			notifyObservers(Action.MOVE);

		    } else if (getSpeed() >= 90_000 && getSpeed() < 100_000) {

			doRun(0);

			setChanged();

			notifyObservers(Action.MOVE);

		    } else if (getSpeed() >= 100_000 && getSpeed() < 110_000) {

			doRun(0);

			setChanged();

			notifyObservers(Action.MOVE);

		    } else if (getSpeed() >= 110_000 && getSpeed() < 120_000) {

			doRun(0);

			setChanged();

			notifyObservers(Action.MOVE);

		    } else if (getSpeed() >= 120_000 && getSpeed() < 130_000) {

			doRun(0);

			setChanged();

			notifyObservers(Action.MOVE);

		    } else if (getSpeed() >= 130_000) {

			doRun(0);

			setChanged();

			notifyObservers(Action.MOVE);

		    } else if (getSpeed() == 0) {

			doStop();

			setChanged();

			notifyObservers(Action.STOP);

		    }

		}
		    break;
		case WALK:
		    break;
		case RUN:
		    break;
		case JUMP:
		    break;
		default:
		    break;

	    }

	}

    }

    /* (non-Javadoc)
     * @see br.com.codecode.sonicinbox.interfaces.Animated#setAnimationSpeed(int)
     */
    @Override
    public void setAnimationSpeed(int animationSpeed) {

	this.animationSpeed = animationSpeed;
    }

    /**
     * Sets the h.
     *
     * @param H the new h
     */
    public void setH(int H) {

	this.H = H;
    }

    /* (non-Javadoc)
     * @see br.com.codecode.sonicinbox.interfaces.Physicable#setMass(float)
     */
    @Override
    public void setMass(float mass) {

	this.mass = mass;
    }

    /**
     * Sets the orientation.
     *
     * @param orientation the new orientation
     */
    public void setOrientation(Orientation orientation) {

	this.orientation = orientation;
    }

    /* (non-Javadoc)
     * @see br.com.codecode.sonicinbox.interfaces.Physicable#setResistance(float)
     */
    @Override
    public void setResistance(float resistance) {

	this.resistance = resistance;
    }

    /* (non-Javadoc)
     * @see br.com.codecode.sonicinbox.interfaces.Physicable#setSpeed(float)
     */
    @Override
    public synchronized void setSpeed(float speed) {

	this.speed = speed;
    }

    /**
     * Sets the super sonic.
     *
     * @param superSonic the super sonic
     * @return the sonic
     */
    public Sonic setSuperSonic(boolean superSonic) {

	this.superSonic = superSonic;

	if (this.superSonic) {
	    mass = ConfigSuperSonic.MASS.getValue();
	    resistance = ConfigSuperSonic.RESISTENCE.getValue();
	} else {
	    mass = ConfigSonic.MASS.getValue();
	    resistance = ConfigSonic.RESISTANCE.getValue();
	}
	return this;
    }

    /**
     * Sets the w.
     *
     * @param W the new w
     */
    public void setW(int W) {

	this.W = W;
    }

    /* (non-Javadoc)
     * @see br.com.codecode.sonicinbox.interfaces.Moveable#setX(int)
     */
    @Override
    public void setX(int X) {

	this.X = X;
    }

    /* (non-Javadoc)
     * @see br.com.codecode.sonicinbox.interfaces.Moveable#setY(int)
     */
    @Override
    public void setY(int Y) {

	this.Y = Y;
    }

    /* (non-Javadoc)
     * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
     */
    @Override
    public void update(Observable o, Object arg) {

	setAction((Action) arg);

	try {

	    Thread.sleep(FPS);

	} catch (InterruptedException ex) {

	    throw new RuntimeException(ex);
	}

    }

}
