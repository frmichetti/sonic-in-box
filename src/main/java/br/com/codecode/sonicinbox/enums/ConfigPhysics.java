package br.com.codecode.sonicinbox.enums;

// TODO: Auto-generated Javadoc
/**
 * The Enum ConfigPhysics.
 */
public enum ConfigPhysics {

    /** The gravity. */
    GRAVITY(3f), /** The resistance. */
 RESISTANCE(4f);

    /** The value. */
    private final float value;

    /**
     * Instantiates a new config physics.
     *
     * @param value the value
     */
    private ConfigPhysics(float value) {
	this.value = value;
    }

    /**
     * Gets the value.
     *
     * @return the value
     */
    public float getValue() {

	return value;
    }

}
