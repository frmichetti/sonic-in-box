package br.com.codecode.sonicinbox.interfaces;

import br.com.codecode.sonicinbox.enums.Action;

public interface Animated {
    
    int getAnimationSpeed();
    
    int getCurrentFrame();
    
    int getFinalFrame();
    
    int getInitFrame();
    
    Enum<? extends Action> getAction();
    
    void setAnimationSpeed(int animationSpeed);  

}
