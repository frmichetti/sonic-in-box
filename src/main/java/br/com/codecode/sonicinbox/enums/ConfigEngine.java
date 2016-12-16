package br.com.codecode.sonicinbox.enums;

// TODO: Auto-generated Javadoc
/**
 * The Enum ConfigEngine.
 */
public enum ConfigEngine {

    /** The width. */
    WIDTH(1024), /** The height. */
 HEIGHT(768);

    /** The value. */
    private int value;

    /**
     * Instantiates a new config engine.
     *
     * @param value the value
     */
    private ConfigEngine(int value) {
	this.value = value;
    }

    /**
     * Gets the value.
     *
     * @return the value
     */
    public int getValue() {

	return value;
    }   
    

}
