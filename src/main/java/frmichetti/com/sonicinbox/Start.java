/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see mailto:frmichetti@gmail.com
 * */
package frmichetti.com.sonicinbox;

import java.lang.reflect.InvocationTargetException;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import frmichetti.com.sonicinbox.console.FrameAction;
import frmichetti.com.sonicinbox.console.FrameAnimation;
import frmichetti.com.sonicinbox.console.FrameListener;
import frmichetti.com.sonicinbox.engine.Engine;

public final class Start {

    public static ThreadGroup tgrpEngine, tgrpSonic, tgrpConsole;
    
    private static Thread t;

    public Start() {
    	
        tgrpEngine = new ThreadGroup("Engine Threads");
        
        tgrpSonic = new ThreadGroup(tgrpEngine, "Sonic Threads");
        
        tgrpConsole = new ThreadGroup(tgrpEngine, "Console Threads");

        tgrpConsole.setMaxPriority(Thread.MIN_PRIORITY);
        
        tgrpEngine.setMaxPriority(Thread.NORM_PRIORITY);
        
        tgrpSonic.setMaxPriority(Thread.MAX_PRIORITY);

        t = Thread.currentThread();
        
        t.setName("Thread Sonic In Box");

        doChangeTheme();
        
        doCreateFrame();

    }


    private void doChangeTheme() {

        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            	
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
            
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
        	
            throw new RuntimeException("Não foi Possivel Definir o Tema Nimbus : " + ex.getMessage());
            
        }

    }

    public void doCreateFrame() {

        try {
            SwingUtilities.invokeAndWait(() -> {

                new Engine();

            });
        } catch (InterruptedException | InvocationTargetException ex) {
        	
        	throw new RuntimeException(ex);
        	
        }

        SwingUtilities.invokeLater(() -> {

            new FrameListener();

            new FrameAnimation();

            new FrameAction();

        });

    }

    public static void main(String ... args) {
        new Start();
    }

}
