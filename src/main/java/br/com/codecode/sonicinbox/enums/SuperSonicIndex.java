package br.com.codecode.sonicinbox.enums;

// TODO: Auto-generated Javadoc
/**
 * Index of Actions Sprites for Super Sonic.
 *
 * @author felipe
 * @version 1.0
 * @since 1.0
 */
public enum SuperSonicIndex {

    /** The ss stop. */
    SS_STOP(211, 213), /** The ss wait. */
 SS_WAIT(239, 241), /** The ss look. */
 SS_LOOK(), /** The ss looking. */
 SS_LOOKING(), /** The ss down. */
 SS_DOWN(214, 214), /** The ss downed. */
 SS_DOWNED(214,
	    214), 
 /** The ss breakup. */
 SS_BREAKUP(), 
 /** The ss push. */
 SS_PUSH(235, 238), 
 /** The ss walk. */
 SS_WALK(216, 222), 
 /** The ss run. */
 SS_RUN(223, 224), 
 /** The ss jump. */
 SS_JUMP(), 
 /** The ss spin. */
 SS_SPIN(), 
 /** The ss dash. */
 SS_DASH();

    /** The init. */
    private int init;

    /** The end. */
    private int end;

    /**
     * Instantiates a new super sonic index.
     *
     * @param init the init
     * @param end the end
     */
    private SuperSonicIndex(int init, int end) {
	this.init = init;
	this.end = end;
    }

    /**
     * Instantiates a new super sonic index.
     */
    private SuperSonicIndex() {
	this.init = 0;
	this.end = 0;
    }

    /**
     * Gets the inits the.
     *
     * @return the init
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
