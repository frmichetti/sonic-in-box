/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see mailto:frmichetti@gmail.com
 * */
package frmichetti.com.sonicinbox.motion;

import frmichetti.com.sonicinbox.Start;
import frmichetti.com.sonicinbox.engine.Engine;
import frmichetti.com.sonicinbox.enumeration.Action;
import frmichetti.com.sonicinbox.enumeration.ConfigEngine;
import frmichetti.com.sonicinbox.enumeration.Orientation;

public class Movimentation implements Runnable {

    private Thread t;

    public Movimentation() {
        t = new Thread(Start.tgrpSonic, this, "Movimentation Thread");
    }

    private void doLimitScreen() {
        if (Engine.sonic.getX() <= -140) {

            Engine.sonic.setX(900);

        } else if (Engine.sonic.getX() >= 900) {

            Engine.sonic.setX(-150);
        }
    }

    private void doMove() {
        if (Engine.sonic.getAction() == Action.STOP) {

        } else {
            int i = 1;

            if (Engine.sonic.getOrientation() == Orientation.RIGHT) {
                i = 1;

            } else {
                i = (i * (-1));

            }
            assert (Engine.sonic.getAction() != Action.MOVE) : "MOVENDO STOP PELA TELA";

            if (Engine.sonic.isAi() && Engine.sonic.getAcceleration() > 1) {

                if (Engine.sonic.getSpeed() > 20 && Engine.sonic.getSpeed() < 60) {

                    Engine.sonic.setX(Engine.sonic.getX() + (5 * i));

                } else if (Engine.sonic.getSpeed() > 60 && Engine.sonic.getSpeed() < 100) {

                    Engine.sonic.setX(Engine.sonic.getX() + (10 * i));

                } else if (Engine.sonic.getSpeed() > 100 && Engine.sonic.getSpeed() < 10_000) {

                    Engine.sonic.setX(Engine.sonic.getX() + (15 * i));

                } else if (Engine.sonic.getSpeed() > 10_000 && Engine.sonic.getSpeed() < 20_000) {

                    Engine.sonic.setX(Engine.sonic.getX() + (16 * i));

                } else if (Engine.sonic.getSpeed() > 20_000 && Engine.sonic.getSpeed() < 30_000) {

                    Engine.sonic.setX(Engine.sonic.getX() + (17 * i));

                } else if (Engine.sonic.getSpeed() > 30_000 && Engine.sonic.getSpeed() < 40_000) {

                    Engine.sonic.setX(Engine.sonic.getX() + (17 * i));

                } else if (Engine.sonic.getSpeed() > 40_000 && Engine.sonic.getSpeed() < 50_000) {

                    Engine.sonic.setX(Engine.sonic.getX() + (18 * i));

                } else if (Engine.sonic.getSpeed() > 50_000 && Engine.sonic.getSpeed() < 60_000) {

                    Engine.sonic.setX(Engine.sonic.getX() + (18 * i));

                } else if (Engine.sonic.getSpeed() > 60_000 && Engine.sonic.getSpeed() < 70_000) {

                    Engine.sonic.setX(Engine.sonic.getX() + (19 * i));

                } else if (Engine.sonic.getSpeed() > 70_000 && Engine.sonic.getSpeed() < 80_000) {

                    Engine.sonic.setX(Engine.sonic.getX() + (20 * i));

                } else if (Engine.sonic.getSpeed() > 80_000 && Engine.sonic.getSpeed() < 90_000) {

                    Engine.sonic.setX(Engine.sonic.getX() + (21 * i));

                } else if (Engine.sonic.getSpeed() > 90_000 && Engine.sonic.getSpeed() < 100_000) {

                    Engine.sonic.setX(Engine.sonic.getX() + (21 * i));

                } else if (Engine.sonic.getSpeed() > 100_000 && Engine.sonic.getSpeed() < 110_000) {

                    Engine.sonic.setX(Engine.sonic.getX() + (22 * i));

                } else if (Engine.sonic.getSpeed() > 110_000 && Engine.sonic.getSpeed() < 120_000) {

                    Engine.sonic.setX(Engine.sonic.getX() + (23 * i));

                } else if (Engine.sonic.getSpeed() > 120_000 && Engine.sonic.getSpeed() < 130_000) {

                    Engine.sonic.setX(Engine.sonic.getX() + (24 * i));

                } else {
                    Engine.sonic.setX(Engine.sonic.getX() + (25 * i));
                }

                doLimitScreen();

            }
        }

    }

    @Override
    public void run() {

        while (true) {

            doMove();

            try {

                Thread.sleep(ConfigEngine.FPS.getValue());


            } catch (InterruptedException ex) {
            	throw new RuntimeException("Failed to Stop " + t.getName() + " " + ex);
            }
        }

    }

    public Thread getThread() {
        return t;
    }

}
