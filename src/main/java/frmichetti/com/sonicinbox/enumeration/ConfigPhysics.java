/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see mailto:frmichetti@gmail.com
 * */
package frmichetti.com.sonicinbox.enumeration;

public enum ConfigPhysics {

	GRAVITY(3f), RESISTANCE(4f);

	private final float value;

	private ConfigPhysics(float value) {
		this.value = value;
	}

	public float getValor() {
		return value;
	}



}
