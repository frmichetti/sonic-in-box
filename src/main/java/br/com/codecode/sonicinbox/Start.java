package br.com.codecode.sonicinbox;

import java.lang.reflect.InvocationTargetException;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import br.com.codecode.sonicinbox.console.FrameAction;
import br.com.codecode.sonicinbox.console.FrameAnimation;
import br.com.codecode.sonicinbox.console.FrameListener;
import br.com.codecode.sonicinbox.engine.Engine;

// TODO: Auto-generated Javadoc
/**
 * The Class Start.
 */
public class Start {

    /** The tgrp sonic. */
    public static ThreadGroup tgrpEngine, tgrpSonic;

    /** The t. */
    private Thread t;

    /**
     * Instantiates a new start.
     */
    public Start() {

	tgrpEngine = new ThreadGroup("Engine Threads");

	tgrpSonic = new ThreadGroup(tgrpEngine, "Sonic Threads");

	tgrpEngine.setMaxPriority(Thread.NORM_PRIORITY);

	tgrpSonic.setMaxPriority(Thread.MAX_PRIORITY);

	t = Thread.currentThread();

	t.setName("Thread Sonic In Box");

	doChangeTheme();

	doCreateFrame();

    }

    /**
     * Do change theme.
     */
    private void doChangeTheme() {

	try {

	    for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {

		if ("Nimbus".equals(info.getName())) {
		    UIManager.setLookAndFeel(info.getClassName());
		    break;
		}
	    }

	} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
		| javax.swing.UnsupportedLookAndFeelException ex) {

	    throw new RuntimeException(ex);

	}

    }

    /**
     * Do create frame.
     */
    public void doCreateFrame() {

	try {

	    SwingUtilities.invokeAndWait(() -> {

		Engine e = new Engine();

		new FrameAnimation(e);

		new FrameAction(e);

		new FrameListener(e);

	    });
	} catch (InvocationTargetException | InterruptedException ex) {

	    throw new RuntimeException(ex);
	}

    }

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String... args) {

	new Start();
    }

}
