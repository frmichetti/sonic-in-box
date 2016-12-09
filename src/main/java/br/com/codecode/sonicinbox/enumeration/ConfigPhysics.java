package br.com.codecode.sonicinbox.enumeration;

public enum ConfigPhysics {

	GRAVITY(3f), RESISTANCE(4f);

	private final float value;

	private ConfigPhysics(float value) {
		this.value = value;
	}

	public float getValue() {
		return value;
	}

}
