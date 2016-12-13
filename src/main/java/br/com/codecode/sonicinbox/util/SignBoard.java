package br.com.codecode.sonicinbox.util;

public class SignBoard {    
    
    private SignBoard(){}

    private static StringBuffer stringBuffer;

    public static void substring(String s) {

	stringBuffer = new StringBuffer(s.length());

	stringBuffer.append(s);

	for (int i = 0; i < stringBuffer.length(); i++) {

	    s = stringBuffer.substring(i);	    
	}

    }

}
