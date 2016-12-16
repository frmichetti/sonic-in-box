package br.com.codecode.sonicinbox.enums;

// TODO: Auto-generated Javadoc
/**
 * Index of Actions Sprites for Sonic.
 *
 * @author felipe
 * @version 1.0
 * @since 1.0
 */
public enum SonicIndex {

    /** The stop. */
    STOP(0, 0), /** The wait. */
 WAIT(0, 12), /** The look. */
 LOOK(13, 14), /** The looking. */
 LOOKING(14, 14), /** The down. */
 DOWN(15, 16), /** The downed. */
 DOWNED(16, 16), /** The breakup. */
 BREAKUP(173, 175), /** The push. */
 PUSH(197,
	    200), 
 /** The walk. */
 WALK(17, 24), 
 /** The run. */
 RUN(25, 28), 
 /** The jump. */
 JUMP(), 
 /** The spin. */
 SPIN(41, 45), 
 /** The dash. */
 DASH(46, 51), 
 /** The transform. */
 TRANSFORM(206, 210);

    /** The init. */
    private int init;

    /** The end. */
    private int end;

    /**
     * Instantiates a new sonic index.
     *
     * @param init the init
     * @param end the end
     */
    private SonicIndex(int init, int end) {
	this.init = init;
	this.end = end;
    }

    /**
     * Instantiates a new sonic index.
     */
    private SonicIndex() {
	this.init = 0;
	this.end = 0;
    }

    /**
     * Gets the inits the.
     *
     * @return the inits the
     */
    public int getInit() {

	return init;
    }

    /**
     * Gets the end.
     *
     * @return the end
     */
    public int getEnd() {

	return end;
    }

}
