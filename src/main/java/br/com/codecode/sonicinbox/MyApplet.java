package br.com.codecode.sonicinbox;

import java.applet.Applet;

public class MyApplet extends Applet{

	private static final long serialVersionUID = -8998700725003389219L;

	@Override
	public void init() {		
		
		super.init();
		
		new Start();
	}

}
