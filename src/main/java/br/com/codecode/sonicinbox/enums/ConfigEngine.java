package br.com.codecode.sonicinbox.enums;

public enum ConfigEngine {

    WIDTH(1024), HEIGHT(768);

    private int value;

    private ConfigEngine(int value) {
	this.value = value;
    }

    public int getValue() {

	return value;
    }   
    

}
