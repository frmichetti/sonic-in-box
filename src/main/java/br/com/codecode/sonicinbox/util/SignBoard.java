package br.com.codecode.sonicinbox.util;

public abstract class SignBoard implements Runnable {

    private static StringBuffer stringBuffer;

    public static void substring(String s) throws InterruptedException {

	stringBuffer = new StringBuffer(s.length());

	stringBuffer.append(s);

	for (int i = 0; i < stringBuffer.length(); i++) {

	    s = stringBuffer.substring(i);

	    System.out.println(s);

	    Thread.sleep(1000);

	    System.out.println(s);
	}

    }

}
