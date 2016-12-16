package br.com.codecode.sonicinbox.util;

// TODO: Auto-generated Javadoc
/**
 * The Class SignBoard.
 */
public class SignBoard {    
    
    /**
     * Instantiates a new sign board.
     */
    private SignBoard(){}

    /** The string buffer. */
    private static StringBuffer stringBuffer;

    /**
     * Substring.
     *
     * @param s the s
     */
    public static void substring(String s) {

	stringBuffer = new StringBuffer(s.length());

	stringBuffer.append(s);

	for (int i = 0; i < stringBuffer.length(); i++) {

	    s = stringBuffer.substring(i);	    
	}

    }

}
