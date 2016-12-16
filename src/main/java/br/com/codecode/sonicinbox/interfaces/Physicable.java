package br.com.codecode.sonicinbox.interfaces;

// TODO: Auto-generated Javadoc
/**
 * Markup Interface for Physicable Character.
 *
 * @author felipe
 * @version 1.0
 * @since 1.1
 */
public interface Physicable {

    /**
     * Gets the acceleration.
     *
     * @return the acceleration
     */
    float getAcceleration();

    /**
     * Gets the resistance.
     *
     * @return the resistance
     */
    float getResistance();

    /**
     * Gets the speed.
     *
     * @return the speed
     */
    float getSpeed();

    /**
     * Gets the mass.
     *
     * @return the mass
     */
    float getMass();

    /**
     * Sets the acceleration.
     *
     * @param acceleration the new acceleration
     */
    void setAcceleration(float acceleration);

    /**
     * Sets the resistance.
     *
     * @param resistance the new resistance
     */
    void setResistance(float resistance);

    /**
     * Sets the speed.
     *
     * @param speed the new speed
     */
    void setSpeed(float speed);

    /**
     * Sets the mass.
     *
     * @param mass the new mass
     */
    void setMass(float mass);

}
