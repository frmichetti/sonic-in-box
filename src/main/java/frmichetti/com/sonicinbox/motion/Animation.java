/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see mailto:frmichetti@gmail.com
 * */
package frmichetti.com.sonicinbox.motion;

import static frmichetti.com.sonicinbox.engine.Engine.sonic;
import static frmichetti.com.sonicinbox.enumeration.ConfigEngine.FPS;
import static frmichetti.com.sonicinbox.enumeration.SonicIndex.DOWNED;
import static frmichetti.com.sonicinbox.enumeration.SonicIndex.DOWN;
import static frmichetti.com.sonicinbox.enumeration.SonicIndex.WALK;
import static frmichetti.com.sonicinbox.enumeration.SonicIndex.RUN;
import static frmichetti.com.sonicinbox.enumeration.SonicIndex.DASH;
import static frmichetti.com.sonicinbox.enumeration.SonicIndex.PUSH;
import static frmichetti.com.sonicinbox.enumeration.SonicIndex.WAIT;
import static frmichetti.com.sonicinbox.enumeration.SonicIndex.BREAKUP;
import static frmichetti.com.sonicinbox.enumeration.SonicIndex.SPIN;
import static frmichetti.com.sonicinbox.enumeration.SonicIndex.LOOKING;
import static frmichetti.com.sonicinbox.enumeration.SonicIndex.LOOK;
import static frmichetti.com.sonicinbox.enumeration.SonicIndex.STOP;
import static frmichetti.com.sonicinbox.enumeration.SonicIndex.TRANSFORM;
import static frmichetti.com.sonicinbox.enumeration.SuperSonicIndex.SS_DOWNED;
import static frmichetti.com.sonicinbox.enumeration.SuperSonicIndex.SS_WALK;
import static frmichetti.com.sonicinbox.enumeration.SuperSonicIndex.SS_RUN;
import static frmichetti.com.sonicinbox.enumeration.SuperSonicIndex.SS_PUSH;
import static frmichetti.com.sonicinbox.enumeration.SuperSonicIndex.SS_WAIT;
import static frmichetti.com.sonicinbox.enumeration.SuperSonicIndex.SS_STOP;

import frmichetti.com.sonicinbox.Start;
import frmichetti.com.sonicinbox.engine.Engine;
import frmichetti.com.sonicinbox.enumeration.Action;

public class Animation implements Runnable {

	private int animeSpeed;

	private int initFrame;

	private int currentFrame;

	private int finalFrame;

	private Thread thread;

	public Animation() {

		thread = new Thread(Start.tgrpSonic, this, "Animation Thread");

	}

	private void doChangeFrames(int initFrame, int finalFrame, int animeSpeed) {

		this.initFrame = initFrame;
		this.finalFrame = finalFrame;
		Engine.sonic.setAnimeSpeed(animeSpeed);

		if (this.currentFrame < initFrame) {
			this.currentFrame = initFrame;
		}

	}

	private void doAnimate() {

		doSwitchAction();

		animeSpeed++;

		if (animeSpeed > Engine.sonic.getAnimeSpeed()) {

			currentFrame++;

			animeSpeed = 0;

			if (currentFrame > finalFrame) {

				currentFrame = initFrame;

			}
		}

	}

	private void doSwitchAction() {

		switch ((Action) Engine.sonic.getAction()) {

		case STOP: {

			if (Engine.sonic.isSuperSonic()) {

				doChangeFrames(SS_STOP.getInit(),
						SS_STOP.getEnd(),
						(Engine.sonic.isAi() ? 5 : sonic.getAnimeSpeed()));
			} else {

				doChangeFrames(STOP.getInit(),
						STOP.getEnd(), (Engine.sonic.isAi() ? 5 : sonic.getAnimeSpeed()));

			}

		}
		break;

		case WAIT: {

			if (Engine.sonic.isSuperSonic()) {

				doChangeFrames(SS_WAIT.getInit(),
						SS_WAIT.getEnd(),
						(Engine.sonic.isAi() ? 5 : sonic.getAnimeSpeed()));
			} else {

				doChangeFrames(WAIT.getInit(),
						WAIT.getEnd(),
						(Engine.sonic.isAi() ? 5 : sonic.getAnimeSpeed()));

			}

		}
		break;

		case DOWN: {

			if (Engine.sonic.isSuperSonic()) {

			} else {
				doChangeFrames(DOWN.getInit(),
						DOWN.getEnd(),
						(Engine.sonic.isAi() ? 5 : sonic.getAnimeSpeed()));
			}

		}
		break;
		case DOWNED: {

			if (Engine.sonic.isSuperSonic()) {

				doChangeFrames(SS_DOWNED.getInit(),
						SS_DOWNED.getEnd(),
						(Engine.sonic.isAi() ? 5 : sonic.getAnimeSpeed()));

			} else {

				doChangeFrames(DOWNED.getInit(),
						DOWNED.getEnd(),
						(Engine.sonic.isAi() ? 5 : sonic.getAnimeSpeed()));

			}
		}
		break;

		case LOOK: {

			if (Engine.sonic.isSuperSonic()) {

			} else {

				doChangeFrames(LOOK.getInit(), LOOK.getEnd(),
						(Engine.sonic.isAi() ? 5 : sonic.getAnimeSpeed()));
			}

		}
		break;
		case LOOKING: {

			if (Engine.sonic.isSuperSonic()) {

			} else {

				doChangeFrames(LOOKING.getInit(),
						LOOKING.getEnd(),
						(Engine.sonic.isAi() ? 5 : sonic.getAnimeSpeed()));

			}

		}
		break;
		case BRAKEUP: {

			if (Engine.sonic.isSuperSonic()) {

			} else {
				doChangeFrames(BREAKUP.getInit(),
						BREAKUP.getEnd(),
						(Engine.sonic.isAi() ? 7 : sonic.getAnimeSpeed()));
			}

		}
		break;

		case WALK: {
			if (Engine.sonic.isSuperSonic()) {

				doChangeFrames(SS_WALK.getInit(),
						SS_WALK.getEnd(),
						sonic.getAnimeSpeed());

			} else {

				doChangeFrames(WALK.getInit(),
						WALK.getEnd(),
						sonic.getAnimeSpeed());

			}
		}
		break;

		case RUN: {
			if (Engine.sonic.isSuperSonic()) {

				doChangeFrames(SS_RUN.getInit(),
						SS_RUN.getEnd(),
						sonic.getAnimeSpeed());

			} else {

				doChangeFrames(RUN.getInit(),
						RUN.getEnd(),
						sonic.getAnimeSpeed());
			}
		}

		break;
		case SPIN: {

			if (Engine.sonic.isSuperSonic()) {

			} else {

				doChangeFrames(SPIN.getInit(),
						SPIN.getEnd(),
						sonic.getAnimeSpeed());

			}

		}
		break;

		case TRANSFORM: {

			doChangeFrames(TRANSFORM.getInit(),
					TRANSFORM.getEnd(),
					(Engine.sonic.isAi() ? 5 : sonic.getAnimeSpeed()));

		}
		break;

		case PUSH: {

			if (Engine.sonic.isSuperSonic()) {
				doChangeFrames(SS_PUSH.getInit(),
						SS_PUSH.getEnd(),
						(Engine.sonic.isAi() ? 9 : sonic.getAnimeSpeed()));
			} else {
				doChangeFrames(PUSH.getInit(),
						PUSH.getEnd(),
						(Engine.sonic.isAi() ? 9 : sonic.getAnimeSpeed()));
			}

		}
		break;
		case DASH: {
			if (Engine.sonic.isSuperSonic()) {

			} else {

				doChangeFrames(DASH.getInit(),
						DASH.getEnd(),
						sonic.getAnimeSpeed());

			}
		}
		break;
		case SPEEDUP:
			break;
		case MOVE:
			break;
		case JUMP:
			break;
		default:
			break;

		}

	}

	public int getAnimeSpeed() {
		return animeSpeed;
	}

	public void setAnimeSpeed(int animeSpeed) {
		this.animeSpeed = animeSpeed;
	}

	public int getInitFrame() {
		return initFrame;
	}

	public void setInitFrame(int initFrame) {
		this.initFrame = initFrame;
	}

	public int getCurrentFrame() {
		return currentFrame;
	}

	public void setCurrentFrame(int currentFrame) {
		this.currentFrame = currentFrame;
	}

	public int getFinalFrame() {
		return finalFrame;
	}

	public void setFrameFinal(int finalFrame) {
		this.finalFrame = finalFrame;
	}
	
	public Thread getThread() {
		return thread;
	}

	@Override
	public void run() {

		while (true) {

			doAnimate();

			try {

				Thread.sleep(FPS.getValue());

			} catch (InterruptedException ex) {
				throw new RuntimeException("Failed to Stop " + thread.getName() + " " + ex);
			}
		}

	}



}
