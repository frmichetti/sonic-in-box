/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see mailto:frmichetti@gmail.com
 * */
package frmichetti.com.sonicinbox.enumeration;


public enum SuperSonicIndex {

    SS_STOP(211, 213),SS_WAIT(239, 241),SS_LOOK(),SS_LOOKING(),SS_DOWN(214, 214),SS_DOWNED(214, 214),SS_BREAKUP(),SS_PUSH(235, 238),
    SS_WALK(216, 222),SS_RUN(223, 224),SS_JUMP(),SS_SPIN(),SS_DASH();
	
    private int init;
    
    private int end;

    private SuperSonicIndex(int init, int end) {
        this.init = init;
        this.end = end;
    }

    private SuperSonicIndex() {
        this.init = 0;
        this.end = 0;
    }

    /**
     * @return the init
     */
    public int getInit() {
        return init;
    }

    /**
     * @return the end
     */
    public int getEnd() {
        return end;
    }

}
