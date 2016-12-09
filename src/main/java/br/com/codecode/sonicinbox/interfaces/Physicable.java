package br.com.codecode.sonicinbox.interfaces;

/**
 * Markup Interface for Physicable Character
 * @author felipe
 * @since 1.1
 * @version 1.0
 */
public interface Physicable {
	
	float getAcceleration();
	
	float getResistance();
	
	float getSpeed();
	
	float getMass();
	
	void setAcceleration(float acceleration);
	
	void setResistance(float resistance);
	
	void setSpeed(float speed);
	
	void setMass(float mass);

}
