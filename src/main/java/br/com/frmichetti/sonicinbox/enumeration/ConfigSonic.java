/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see mailto:frmichetti@gmail.com
 * */
package br.com.frmichetti.sonicinbox.enumeration;

public enum ConfigSonic {

    WIDTH(300), HEIGHT(300), MASS(70), RESISTANCE(4), ANIME_SPEED(5), SX(300), SY(200), MAX_SPRITES(242);

    private final int value;

    private ConfigSonic(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
