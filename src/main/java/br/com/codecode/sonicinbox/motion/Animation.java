package br.com.codecode.sonicinbox.motion;

import static br.com.codecode.sonicinbox.enumeration.ConfigEngine.FPS;
import static br.com.codecode.sonicinbox.enumeration.SonicIndex.BREAKUP;
import static br.com.codecode.sonicinbox.enumeration.SonicIndex.DASH;
import static br.com.codecode.sonicinbox.enumeration.SonicIndex.DOWN;
import static br.com.codecode.sonicinbox.enumeration.SonicIndex.DOWNED;
import static br.com.codecode.sonicinbox.enumeration.SonicIndex.LOOK;
import static br.com.codecode.sonicinbox.enumeration.SonicIndex.LOOKING;
import static br.com.codecode.sonicinbox.enumeration.SonicIndex.PUSH;
import static br.com.codecode.sonicinbox.enumeration.SonicIndex.RUN;
import static br.com.codecode.sonicinbox.enumeration.SonicIndex.SPIN;
import static br.com.codecode.sonicinbox.enumeration.SonicIndex.STOP;
import static br.com.codecode.sonicinbox.enumeration.SonicIndex.TRANSFORM;
import static br.com.codecode.sonicinbox.enumeration.SonicIndex.WAIT;
import static br.com.codecode.sonicinbox.enumeration.SonicIndex.WALK;
import static br.com.codecode.sonicinbox.enumeration.SuperSonicIndex.SS_DOWNED;
import static br.com.codecode.sonicinbox.enumeration.SuperSonicIndex.SS_PUSH;
import static br.com.codecode.sonicinbox.enumeration.SuperSonicIndex.SS_RUN;
import static br.com.codecode.sonicinbox.enumeration.SuperSonicIndex.SS_STOP;
import static br.com.codecode.sonicinbox.enumeration.SuperSonicIndex.SS_WAIT;
import static br.com.codecode.sonicinbox.enumeration.SuperSonicIndex.SS_WALK;

import br.com.codecode.sonicinbox.Start;
import br.com.codecode.sonicinbox.enumeration.Action;

public class Animation implements Runnable {

	private int animeSpeed;

	private int initFrame;

	private int currentFrame;

	private int finalFrame;

	private Thread thread;

	private Sonic sonic;

	private Animation() {

		thread = new Thread(Start.tgrpSonic, this, "Animation Thread");

	}
	
	public Animation(Sonic sonic){
		this();
		this.sonic = sonic;
	}

	private void doChangeFrames(Sonic sonic, int initFrame, int finalFrame, int animeSpeed) {

		this.initFrame = initFrame;

		this.finalFrame = finalFrame;

		sonic.setAnimeSpeed(animeSpeed);

		if (this.currentFrame < initFrame) {
			this.currentFrame = initFrame;
		}

	}

	private void doAnimate(Sonic sonic) {

		doSwitchAction(sonic);

		animeSpeed++;

		if (animeSpeed > sonic.getAnimeSpeed()) {

			currentFrame++;

			animeSpeed = 0;

			if (currentFrame > finalFrame) {

				currentFrame = initFrame;

			}
		}

	}

	private void doSwitchAction(Sonic sonic) {

		switch ((Action) sonic.getAction()) {

		case STOP: {

			if (sonic.isSuperSonic()) {

				doChangeFrames(sonic,SS_STOP.getInit(),
						SS_STOP.getEnd(),
						(sonic.isAi() ? 5 : sonic.getAnimeSpeed()));
			} else {

				doChangeFrames(sonic,STOP.getInit(),
						STOP.getEnd(), (sonic.isAi() ? 5 : sonic.getAnimeSpeed()));

			}

		}
		break;

		case WAIT: {

			if (sonic.isSuperSonic()) {

				doChangeFrames(sonic,SS_WAIT.getInit(),
						SS_WAIT.getEnd(),
						(sonic.isAi() ? 5 : sonic.getAnimeSpeed()));
			} else {

				doChangeFrames(sonic,WAIT.getInit(),
						WAIT.getEnd(),
						(sonic.isAi() ? 5 : sonic.getAnimeSpeed()));

			}

		}
		break;

		case DOWN: {

			if (sonic.isSuperSonic()) {

			} else {
				doChangeFrames(sonic,DOWN.getInit(),
						DOWN.getEnd(),
						(sonic.isAi() ? 5 : sonic.getAnimeSpeed()));
			}

		}
		break;
		case DOWNED: {

			if (sonic.isSuperSonic()) {

				doChangeFrames(sonic,SS_DOWNED.getInit(),
						SS_DOWNED.getEnd(),
						(sonic.isAi() ? 5 : sonic.getAnimeSpeed()));

			} else {

				doChangeFrames(sonic,DOWNED.getInit(),
						DOWNED.getEnd(),
						(sonic.isAi() ? 5 : sonic.getAnimeSpeed()));

			}
		}
		break;

		case LOOK: {

			if (sonic.isSuperSonic()) {

			} else {

				doChangeFrames(sonic,LOOK.getInit(), LOOK.getEnd(),
						(sonic.isAi() ? 5 : sonic.getAnimeSpeed()));
			}

		}
		break;
		case LOOKING: {

			if (sonic.isSuperSonic()) {

			} else {

				doChangeFrames(sonic,LOOKING.getInit(),
						LOOKING.getEnd(),
						(sonic.isAi() ? 5 : sonic.getAnimeSpeed()));

			}

		}
		break;
		case BRAKEUP: {

			if (sonic.isSuperSonic()) {

			} else {
				doChangeFrames(sonic,BREAKUP.getInit(),
						BREAKUP.getEnd(),
						(sonic.isAi() ? 7 : sonic.getAnimeSpeed()));
			}

		}
		break;

		case WALK: {
			if (sonic.isSuperSonic()) {

				doChangeFrames(sonic,SS_WALK.getInit(),
						SS_WALK.getEnd(),
						sonic.getAnimeSpeed());

			} else {

				doChangeFrames(sonic,WALK.getInit(),
						WALK.getEnd(),
						sonic.getAnimeSpeed());

			}
		}
		break;

		case RUN: {
			if (sonic.isSuperSonic()) {

				doChangeFrames(sonic,SS_RUN.getInit(),
						SS_RUN.getEnd(),
						sonic.getAnimeSpeed());

			} else {

				doChangeFrames(sonic,RUN.getInit(),
						RUN.getEnd(),
						sonic.getAnimeSpeed());
			}
		}

		break;
		case SPIN: {

			if (sonic.isSuperSonic()) {

			} else {

				doChangeFrames(sonic,SPIN.getInit(),
						SPIN.getEnd(),
						sonic.getAnimeSpeed());

			}

		}
		break;

		case TRANSFORM: {

			doChangeFrames(sonic,TRANSFORM.getInit(),
					TRANSFORM.getEnd(),
					(sonic.isAi() ? 5 : sonic.getAnimeSpeed()));

		}
		break;

		case PUSH: {

			if (sonic.isSuperSonic()) {
				doChangeFrames(sonic,SS_PUSH.getInit(),
						SS_PUSH.getEnd(),
						(sonic.isAi() ? 9 : sonic.getAnimeSpeed()));
			} else {
				doChangeFrames(sonic,PUSH.getInit(),
						PUSH.getEnd(),
						(sonic.isAi() ? 9 : sonic.getAnimeSpeed()));
			}

		}
		break;
		case DASH: {
			if (sonic.isSuperSonic()) {

			} else {

				doChangeFrames(sonic,DASH.getInit(),
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

			doAnimate(sonic);

			try {

				Thread.sleep(FPS.getValue());

			} catch (InterruptedException ex) {
				throw new RuntimeException("Failed to Stop " + thread.getName() + " " + ex);
			}
		}

	}



}
