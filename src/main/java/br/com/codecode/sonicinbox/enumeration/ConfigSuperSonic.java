package br.com.codecode.sonicinbox.enumeration;


public enum ConfigSuperSonic {
    WIDTH(300), HEIGHT(300), MASS(100), RESISTENCE(2), ANIME_SPEED(5), SX(300), SY(200);

    private final int value;

    private ConfigSuperSonic(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}