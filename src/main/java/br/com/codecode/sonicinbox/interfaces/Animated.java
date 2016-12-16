package br.com.codecode.sonicinbox.interfaces;

import br.com.codecode.sonicinbox.enums.Action;

// TODO: Auto-generated Javadoc
/**
 * The Interface Animated.
 */
public interface Animated {
    
    /**
     * Gets the animation speed.
     *
     * @return the animation speed
     */
    int getAnimationSpeed();
    
    /**
     * Gets the current frame.
     *
     * @return the current frame
     */
    int getCurrentFrame();
    
    /**
     * Gets the final frame.
     *
     * @return the final frame
     */
    int getFinalFrame();
    
    /**
     * Gets the inits the frame.
     *
     * @return the inits the frame
     */
    int getInitFrame();
    
    /**
     * Gets the action.
     *
     * @return the action
     */
    Enum<? extends Action> getAction();
    
    /**
     * Sets the animation speed.
     *
     * @param animationSpeed the new animation speed
     */
    void setAnimationSpeed(int animationSpeed);  

}
