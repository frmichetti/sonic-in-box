package br.com.codecode.sonicinbox.enumeration;

public enum ConfigEngine {
    FPS(1000 / 60), WIDTH(1024), HEIGHT(768);

    private int value;

    ConfigEngine(int value) {
        this.value = value;
    }

 
    public int getValue() {
        return value;
    }

}
