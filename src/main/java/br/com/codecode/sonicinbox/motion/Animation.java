package br.com.codecode.sonicinbox.motion;

import static br.com.codecode.sonicinbox.enums.SonicIndex.BREAKUP;
import static br.com.codecode.sonicinbox.enums.SonicIndex.DASH;
import static br.com.codecode.sonicinbox.enums.SonicIndex.DOWN;
import static br.com.codecode.sonicinbox.enums.SonicIndex.DOWNED;
import static br.com.codecode.sonicinbox.enums.SonicIndex.LOOK;
import static br.com.codecode.sonicinbox.enums.SonicIndex.LOOKING;
import static br.com.codecode.sonicinbox.enums.SonicIndex.PUSH;
import static br.com.codecode.sonicinbox.enums.SonicIndex.RUN;
import static br.com.codecode.sonicinbox.enums.SonicIndex.SPIN;
import static br.com.codecode.sonicinbox.enums.SonicIndex.STOP;
import static br.com.codecode.sonicinbox.enums.SonicIndex.TRANSFORM;
import static br.com.codecode.sonicinbox.enums.SonicIndex.WAIT;
import static br.com.codecode.sonicinbox.enums.SonicIndex.WALK;
import static br.com.codecode.sonicinbox.enums.SuperSonicIndex.SS_DOWNED;
import static br.com.codecode.sonicinbox.enums.SuperSonicIndex.SS_PUSH;
import static br.com.codecode.sonicinbox.enums.SuperSonicIndex.SS_RUN;
import static br.com.codecode.sonicinbox.enums.SuperSonicIndex.SS_STOP;
import static br.com.codecode.sonicinbox.enums.SuperSonicIndex.SS_WAIT;
import static br.com.codecode.sonicinbox.enums.SuperSonicIndex.SS_WALK;

import br.com.codecode.sonicinbox.Start;
import br.com.codecode.sonicinbox.enums.Action;
import br.com.codecode.sonicinbox.interfaces.Animated;
import br.com.codecode.sonicinbox.interfaces.Syncronizeable;

// TODO: Auto-generated Javadoc
/**
 * The Class Animation.
 */
public class Animation implements Runnable, Syncronizeable {

    /** The anime speed. */
    private int animeSpeed;

    /** The init frame. */
    private int initFrame;

    /** The current frame. */
    private int currentFrame;

    /** The final frame. */
    private int finalFrame;

    /** The thread. */
    protected Thread thread;

    /** The animated. */
    private Animated animated;

    /**
     * Instantiates a new animation.
     */
    private Animation() {

	thread = new Thread(Start.tgrpSonic, this, "Animation Thread");

    }

    /**
     * Instantiates a new animation.
     *
     * @param animated the animated
     */
    public Animation(Animated animated) {
	this();
	this.animated = animated;
    }

    /**
     * Do change frames.
     *
     * @param initFrame the init frame
     * @param finalFrame the final frame
     * @param animationSpeed the animation speed
     */
    private void doChangeFrames(int initFrame, int finalFrame, int animationSpeed) {

	this.initFrame = initFrame;

	this.finalFrame = finalFrame;

	animated.setAnimationSpeed(animationSpeed);

	if (this.currentFrame < initFrame) {
	    this.currentFrame = initFrame;
	}

    }

    /**
     * Do animate.
     */
    private void doAnimate() {

	doSwitchAction();

	animeSpeed++;

	if (animeSpeed > animated.getAnimationSpeed()) {

	    currentFrame++;

	    animeSpeed = 0;

	    if (currentFrame > finalFrame) {

		currentFrame = initFrame;

	    }
	}

    }

    /**
     * Do switch action.
     */
    private void doSwitchAction() {
	
	if(animated instanceof Sonic){
	    
	    Sonic s = (Sonic) animated;
	    
	    switch ((Action) s.getAction()) {

		    case STOP: {

			if (s.isSuperSonic()) {

			    doChangeFrames(SS_STOP.getInit(), SS_STOP.getEnd(), (s.isAi() ? 5 : s.getAnimationSpeed()));
			} else {

			    doChangeFrames(STOP.getInit(), STOP.getEnd(), (s.isAi() ? 5 : s.getAnimationSpeed()));

			}

		    }
			break;

		    case WAIT: {

			if (s.isSuperSonic()) {

			    doChangeFrames(SS_WAIT.getInit(), SS_WAIT.getEnd(), (s.isAi() ? 5 : s.getAnimationSpeed()));
			} else {

			    doChangeFrames(WAIT.getInit(), WAIT.getEnd(), (s.isAi() ? 5 : s.getAnimationSpeed()));

			}

		    }
			break;

		    case DOWN: {

			if (s.isSuperSonic()) {

			} else {
			    doChangeFrames(DOWN.getInit(), DOWN.getEnd(), (s.isAi() ? 5 : s.getAnimationSpeed()));
			}

		    }
			break;

		    case DOWNED: {

			if (s.isSuperSonic()) {

			    doChangeFrames(SS_DOWNED.getInit(), SS_DOWNED.getEnd(), (s.isAi() ? 5 : s.getAnimationSpeed()));

			} else {

			    doChangeFrames(DOWNED.getInit(), DOWNED.getEnd(), (s.isAi() ? 5 : s.getAnimationSpeed()));

			}
		    }
			break;

		    case LOOK: {

			if (s.isSuperSonic()) {

			} else {

			    doChangeFrames(LOOK.getInit(), LOOK.getEnd(), (s.isAi() ? 5 : s.getAnimationSpeed()));
			}

		    }
			break;

		    case LOOKING: {

			if (s.isSuperSonic()) {

			} else {

			    doChangeFrames(LOOKING.getInit(), LOOKING.getEnd(), (s.isAi() ? 5 : s.getAnimationSpeed()));

			}

		    }
			break;

		    case BRAKEUP: {

			if (s.isSuperSonic()) {

			} else {
			    doChangeFrames(BREAKUP.getInit(), BREAKUP.getEnd(), (s.isAi() ? 7 : s.getAnimationSpeed()));
			}

		    }
			break;

		    case WALK: {
			if (s.isSuperSonic()) {

			    doChangeFrames(SS_WALK.getInit(), SS_WALK.getEnd(), s.getAnimationSpeed());

			} else {

			    doChangeFrames(WALK.getInit(), WALK.getEnd(), s.getAnimationSpeed());

			}
		    }
			break;

		    case RUN: {
			if (s.isSuperSonic()) {

			    doChangeFrames(SS_RUN.getInit(), SS_RUN.getEnd(), s.getAnimationSpeed());

			} else {

			    doChangeFrames(RUN.getInit(), RUN.getEnd(), s.getAnimationSpeed());
			}
		    }

			break;

		    case SPIN: {

			if (s.isSuperSonic()) {

			} else {

			    doChangeFrames(SPIN.getInit(), SPIN.getEnd(), s.getAnimationSpeed());

			}

		    }
			break;

		    case TRANSFORM: {

			doChangeFrames(TRANSFORM.getInit(), TRANSFORM.getEnd(), (s.isAi() ? 5 : s.getAnimationSpeed()));

		    }
			break;

		    case PUSH: {

			if (s.isSuperSonic()) {
			    doChangeFrames(SS_PUSH.getInit(), SS_PUSH.getEnd(), (s.isAi() ? 9 : s.getAnimationSpeed()));
			} else {
			    doChangeFrames(PUSH.getInit(), PUSH.getEnd(), (s.isAi() ? 9 : s.getAnimationSpeed()));
			}

		    }
			break;

		    case DASH: {
			if (s.isSuperSonic()) {

			} else {

			    doChangeFrames(DASH.getInit(), DASH.getEnd(), s.getAnimationSpeed());

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

	

    }

    /**
     * Gets the anime speed.
     *
     * @return the anime speed
     */
    public int getAnimeSpeed() {

	return animeSpeed;
    }

    /**
     * Sets the anime speed.
     *
     * @param animeSpeed the new anime speed
     */
    public void setAnimeSpeed(int animeSpeed) {

	this.animeSpeed = animeSpeed;
    }

    /**
     * Gets the inits the frame.
     *
     * @return the inits the frame
     */
    public int getInitFrame() {

	return initFrame;
    }

    /**
     * Sets the inits the frame.
     *
     * @param initFrame the new inits the frame
     */
    public void setInitFrame(int initFrame) {

	this.initFrame = initFrame;
    }

    /**
     * Gets the current frame.
     *
     * @return the current frame
     */
    public int getCurrentFrame() {

	return currentFrame;
    }

    /**
     * Sets the current frame.
     *
     * @param currentFrame the new current frame
     */
    public void setCurrentFrame(int currentFrame) {

	this.currentFrame = currentFrame;
    }

    /**
     * Gets the final frame.
     *
     * @return the final frame
     */
    public int getFinalFrame() {

	return finalFrame;
    }

    /**
     * Sets the frame final.
     *
     * @param finalFrame the new frame final
     */
    public void setFrameFinal(int finalFrame) {

	this.finalFrame = finalFrame;
    }  

    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {

	while (true) {	   
	   
	    if(animated != null)
		doAnimate();

	    try {

		Thread.sleep(FPS);

	    } catch (InterruptedException ex) {
		throw new RuntimeException(ex);
	    }
	}

    }

}
