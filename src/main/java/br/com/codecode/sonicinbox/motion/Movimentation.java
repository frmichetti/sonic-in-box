package br.com.codecode.sonicinbox.motion;

import br.com.codecode.sonicinbox.Start;
import br.com.codecode.sonicinbox.enumeration.Action;
import br.com.codecode.sonicinbox.enumeration.ConfigEngine;
import br.com.codecode.sonicinbox.enumeration.Orientation;

public class Movimentation implements Runnable {

    private Thread t;
	
    private Sonic sonic;    

    private Movimentation() {
        t = new Thread(Start.tgrpSonic, this, "Movimentation Thread");
    }
    
    public Movimentation(Sonic sonic){
    	this();
    	this.sonic = sonic;
    }

    private void doLimitScreen() {
        if (sonic.getX() <= -140) {

            sonic.setX(900);

        } else if (sonic.getX() >= 900) {

            sonic.setX(-150);
        }
    }

    private void doMove(Sonic sonic) {
      
    	if (sonic.getAction() == Action.STOP) {

        } else {
            int i = 1;

            if (sonic.getOrientation() == Orientation.RIGHT) {
                i = 1;

            } else {
                i = (i * (-1));

            } 
            

            if (sonic.isAi() && sonic.getAcceleration() > 1) {

                if (sonic.getSpeed() > 20 && sonic.getSpeed() < 60) {

                    sonic.setX(sonic.getX() + (5 * i));

                } else if (sonic.getSpeed() > 60 && sonic.getSpeed() < 100) {

                    sonic.setX(sonic.getX() + (10 * i));

                } else if (sonic.getSpeed() > 100 && sonic.getSpeed() < 10_000) {

                    sonic.setX(sonic.getX() + (15 * i));

                } else if (sonic.getSpeed() > 10_000 && sonic.getSpeed() < 20_000) {

                    sonic.setX(sonic.getX() + (16 * i));

                } else if (sonic.getSpeed() > 20_000 && sonic.getSpeed() < 30_000) {

                    sonic.setX(sonic.getX() + (17 * i));

                } else if (sonic.getSpeed() > 30_000 && sonic.getSpeed() < 40_000) {

                    sonic.setX(sonic.getX() + (17 * i));

                } else if (sonic.getSpeed() > 40_000 && sonic.getSpeed() < 50_000) {

                    sonic.setX(sonic.getX() + (18 * i));

                } else if (sonic.getSpeed() > 50_000 && sonic.getSpeed() < 60_000) {

                    sonic.setX(sonic.getX() + (18 * i));

                } else if (sonic.getSpeed() > 60_000 && sonic.getSpeed() < 70_000) {

                    sonic.setX(sonic.getX() + (19 * i));

                } else if (sonic.getSpeed() > 70_000 && sonic.getSpeed() < 80_000) {

                    sonic.setX(sonic.getX() + (20 * i));

                } else if (sonic.getSpeed() > 80_000 && sonic.getSpeed() < 90_000) {

                    sonic.setX(sonic.getX() + (21 * i));

                } else if (sonic.getSpeed() > 90_000 && sonic.getSpeed() < 100_000) {

                    sonic.setX(sonic.getX() + (21 * i));

                } else if (sonic.getSpeed() > 100_000 && sonic.getSpeed() < 110_000) {

                    sonic.setX(sonic.getX() + (22 * i));

                } else if (sonic.getSpeed() > 110_000 && sonic.getSpeed() < 120_000) {

                    sonic.setX(sonic.getX() + (23 * i));

                } else if (sonic.getSpeed() > 120_000 && sonic.getSpeed() < 130_000) {

                    sonic.setX(sonic.getX() + (24 * i));

                } else {
                    sonic.setX(sonic.getX() + (25 * i));
                }

                doLimitScreen();

            }
        }

    }

    @Override
    public void run() {

        while (true) {
        	
        	if(sonic!= null)
        		doMove(sonic);	        	

            try {

                Thread.sleep(ConfigEngine.FPS.getValue());


            } catch (InterruptedException ex) {
            	throw new RuntimeException("Failed to Stop " + t.getName(), ex);
            }
        }

    }   

}
