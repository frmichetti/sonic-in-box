package br.com.codecode.sonicinbox.motion;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import br.com.codecode.sonicinbox.Start;
import br.com.codecode.sonicinbox.enumeration.Action;
import br.com.codecode.sonicinbox.enumeration.ConfigEngine;
import br.com.codecode.sonicinbox.enumeration.ConfigSonic;
import br.com.codecode.sonicinbox.enumeration.ConfigSuperSonic;
import br.com.codecode.sonicinbox.enumeration.Orientation;

/**
 * Sonic Character
 * @author felipe
 * @since 1.0
 * @version 3.0
 */
public final class Sonic extends Observable implements Observer, Runnable {
	
	private static Sonic instance;

	private boolean ai;

	private int X, Y, W, H;

	private Sprites sprites;

	private Action action;

	private Orientation orientation;

	private float acceleration, mass;

	private float speed;

	private float resistance;

	private boolean superSonic;

	private int animeSpeed;

	private Thread thread;

	public Animation animation; 
	
	private Movimentation movimentation;

	private String from;
	
	public static synchronized Sonic getInstance(){
		if(instance == null){
			instance = new Sonic();
		}
		return instance;
	}

	private Sonic() {		

		thread = new Thread(Start.tgrpSonic, this, "Sonic Thread");

		addObserver(this);        

		this.W = ConfigSonic.WIDTH.getValue();

		this.H = ConfigSonic.HEIGHT.getValue();

		this.X  = ConfigSonic.SX.getValue();

		this.Y = ConfigSonic.SY.getValue();		

		this.mass = ConfigSonic.MASS.getValue();

		this.resistance = ConfigSonic.RESISTANCE.getValue();

		this.orientation = Orientation.RIGHT;

		this.animeSpeed = 5;		

		this.action = Action.STOP;		
		
		animation = new Animation(this);
		
		movimentation = new Movimentation(this);					

	}


	public Sonic(String from,boolean ai) {		
		this();		
		this.ai = ai;		
		this.from = from;		
		
		doLoadSprites();
		
		ExecutorService executor = Executors.newFixedThreadPool(2);

		executor.execute(movimentation);

		executor.execute(animation);	
	}

	private void doLoadSprites() {
		sprites = new Sprites(from);
	}

	public Sprites getSprites() {
		return sprites;
	}

	public Orientation getOrientation() {
		return orientation;

	}

	public float getSpeed() {
		return speed;
	}

	public float getAcceleration() {
		return acceleration;
	}

	public float getMass() {
		return mass;
	}

	public int getX() {
		return X;
	}

	public int getY() {
		return Y;
	}

	public int getW() {
		return W;
	}

	public int getH() {
		return H;
	}

	public Enum<?> getAction() {
		return action;
	}

	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}

	public void setAcceleration(int acceleration) {
		this.acceleration = acceleration;
	}

	public void setX(int X) {
		this.X = X;
	}

	public void setY(int Y) {
		this.Y = Y;
	}

	public void setW(int W) {
		this.W = W;
	}

	public void setH(int H) {
		this.H = H;
	}

	public void setMass(float mass) {
		this.mass = mass;
	}

	public void setAi(boolean ai) {
		this.ai = ai;
	}

	public boolean isAi() {
		return ai;
	}

	public boolean isSuperSonic() {
		return superSonic;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	public Movimentation getMovimentation() {
		return movimentation;
	}


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

	public Sonic doWalk(int speed) {

		if (getAction() == Action.MOVE) {
			setAnimeSpeed(speed);
			setChanged();
			notifyObservers(Action.WALK);
		} else if (!isAi()) {
			setChanged();
			notifyObservers(Action.WALK);
		}

		return this;
	}

	public Sonic doRun(int speed) {
		if (getAction() == Action.MOVE) {
			setAnimeSpeed(speed);
			setChanged();
			notifyObservers(Action.RUN);
		} else if (!isAi()) {
			setChanged();
			notifyObservers(Action.RUN);
		}

		return this;

	}

	public Sonic doSpin(int speed) {
		if (getAction() == Action.MOVE && getSpeed() > 100) {
			setAnimeSpeed(speed);
			setChanged();
			notifyObservers(Action.SPIN);
		} else if (!isAi()) {
			setChanged();
			notifyObservers(Action.SPIN);
		}

		return this;

	}

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

	public Sonic doJump() {
		setChanged();
		notifyObservers(Action.JUMP);
		return this;
	}

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

	public Sonic doSpeedUp() {
		if (getAction() != Action.BRAKEUP && getAcceleration() <= 1_700) {
			setAcceleration((int) (getAcceleration() + 200));
			setChanged();
			notifyObservers(Action.MOVE);
		}
		return this;

	}

	public Sonic doBrakeUp() {
		if (getAction() != Action.STOP && getAction() != Action.SPEEDUP && getSpeed() > 10_000 && getAcceleration() > 200) {
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


	private void setAI(boolean ai) {

		if (isAi()) {

			switch ((Action) getAction()) {

			case STOP: {

				assert (getAction() != Action.MOVE) : "Parado com Velocidade > 0, Velocidade == " + getSpeed();
			}
			break;

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

	public float getResistance() {
		return resistance;
	}

	public void setResistance(float resistance) {
		this.resistance = resistance;
	}


	public synchronized void setSpeed(float speed) {
		this.speed = speed;
	}


	public int getAnimeSpeed() {
		return animeSpeed;
	}


	public void setAnimeSpeed(int animeSpeed) {
		this.animeSpeed = animeSpeed;
	}

	public Thread getThread() {
		return thread;
	}

	@Override
	public void update(Observable o, Object arg) {

		setAction((Action) arg);

		try {

			Thread.sleep(ConfigEngine.FPS.getValue());

		} catch (InterruptedException ex) {

			System.err.println("Failed to Stop " + thread.getName() + " " + ex);
		}

	}

	@Override
	public void run() {

		while (true) {

			setAI(isAi());

			{
				try {

					Thread.sleep(ConfigEngine.FPS.getValue());

				} catch (InterruptedException ex) {

					throw new RuntimeException("Failed to Stop " + thread.getName() + " " + ex);

				}

			}

		}
	}



}
