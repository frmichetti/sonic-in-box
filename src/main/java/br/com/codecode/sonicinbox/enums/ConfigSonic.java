package br.com.codecode.sonicinbox.enums;

// TODO: Auto-generated Javadoc
/**
 * The Enum ConfigSonic.
 */
public enum ConfigSonic {

    /** The width. */
    WIDTH(300), /** The height. */
 HEIGHT(300), /** The mass. */
 MASS(70), /** The resistance. */
 RESISTANCE(4), /** The anime speed. */
 ANIME_SPEED(5), /** The sx. */
 SX(300), /** The sy. */
 SY(200), /** The max sprites. */
 MAX_SPRITES(242);

    /** The value. */
    private final int value;

    /**
     * Instantiates a new config sonic.
     *
     * @param value the value
     */
    private ConfigSonic(int value) {
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
