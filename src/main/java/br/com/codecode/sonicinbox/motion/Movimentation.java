package br.com.codecode.sonicinbox.motion;

import br.com.codecode.sonicinbox.Start;
import br.com.codecode.sonicinbox.enums.Action;
import br.com.codecode.sonicinbox.enums.ConfigEngine;
import br.com.codecode.sonicinbox.enums.Orientation;
import br.com.codecode.sonicinbox.interfaces.Moveable;

public class Movimentation implements Runnable {

    protected Thread thread;

    private Moveable moveable;

    private Movimentation() {
	thread = new Thread(Start.tgrpSonic, this, "Movimentation Thread");
    }

    public Movimentation(Moveable moveable) {
	this();
	this.moveable = moveable;
    }

    private void doLimitScreen() {

	if (moveable.getX() <= -140) {

	    moveable.setX(900);

	} else if (moveable.getX() >= 900) {

	    moveable.setX(-150);
	}
    }

    private void doMove() {
	
	if(moveable instanceof Sonic){
	    
	    Sonic s = (Sonic) moveable;
	    
	    if (s.getAction() == Action.STOP) {

		} else {
		    int i = 1;

		    if (s.getOrientation() == Orientation.RIGHT) {
			i = 1;

		    } else {
			i = (i * (-1));

		    }

		    if (s.isAi() && s.getAcceleration() > 1) {

			if (s.getSpeed() > 20 && s.getSpeed() < 60) {

			    s.setX(s.getX() + (5 * i));

			} else if (s.getSpeed() > 60 && s.getSpeed() < 100) {

			    s.setX(s.getX() + (10 * i));

			} else if (s.getSpeed() > 100 && s.getSpeed() < 10_000) {

			    s.setX(s.getX() + (15 * i));

			} else if (s.getSpeed() > 10_000 && s.getSpeed() < 20_000) {

			    s.setX(s.getX() + (16 * i));

			} else if (s.getSpeed() > 20_000 && s.getSpeed() < 30_000) {

			    s.setX(s.getX() + (17 * i));

			} else if (s.getSpeed() > 30_000 && s.getSpeed() < 40_000) {

			    s.setX(s.getX() + (17 * i));

			} else if (s.getSpeed() > 40_000 && s.getSpeed() < 50_000) {

			    s.setX(s.getX() + (18 * i));

			} else if (s.getSpeed() > 50_000 && s.getSpeed() < 60_000) {

			    s.setX(s.getX() + (18 * i));

			} else if (s.getSpeed() > 60_000 && s.getSpeed() < 70_000) {

			    s.setX(s.getX() + (19 * i));

			} else if (s.getSpeed() > 70_000 && s.getSpeed() < 80_000) {

			    s.setX(s.getX() + (20 * i));

			} else if (s.getSpeed() > 80_000 && s.getSpeed() < 90_000) {

			    s.setX(s.getX() + (21 * i));

			} else if (s.getSpeed() > 90_000 && s.getSpeed() < 100_000) {

			    s.setX(s.getX() + (21 * i));

			} else if (s.getSpeed() > 100_000 && s.getSpeed() < 110_000) {

			    s.setX(s.getX() + (22 * i));

			} else if (s.getSpeed() > 110_000 && s.getSpeed() < 120_000) {

			    s.setX(s.getX() + (23 * i));

			} else if (s.getSpeed() > 120_000 && s.getSpeed() < 130_000) {

			    s.setX(s.getX() + (24 * i));

			} else {
			    s.setX(s.getX() + (25 * i));
			}	

			doLimitScreen();

		    }
	    
	    
	    
	    
	    
	    
	    
	    
	    
	}

	
	}

    }

    @Override
    public void run() {

	while (true) {

	    if (moveable != null)
		doMove();

	    try {

		Thread.sleep(ConfigEngine.FPS.getValue());

	    } catch (InterruptedException ex) {
		throw new RuntimeException(ex);
	    }
	}

    }

}
