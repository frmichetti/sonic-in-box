package br.com.codecode.sonicinbox.enums;

// TODO: Auto-generated Javadoc
/**
 * The Enum ConfigSuperSonic.
 */
public enum ConfigSuperSonic {

    /** The width. */
    WIDTH(300), /** The height. */
 HEIGHT(300), /** The mass. */
 MASS(100), /** The resistence. */
 RESISTENCE(2), /** The anime speed. */
 ANIME_SPEED(5), /** The sx. */
 SX(300), /** The sy. */
 SY(200);

    /** The value. */
    private final int value;

    /**
     * Instantiates a new config super sonic.
     *
     * @param value the value
     */
    private ConfigSuperSonic(int value) {
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
