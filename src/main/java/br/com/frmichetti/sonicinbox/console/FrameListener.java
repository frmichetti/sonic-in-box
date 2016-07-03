/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see mailto:frmichetti@gmail.com
 * */
package br.com.frmichetti.sonicinbox.console;

import br.com.frmichetti.sonicinbox.Start;
import br.com.frmichetti.sonicinbox.engine.Engine;
import br.com.frmichetti.sonicinbox.enumeration.ConfigEngine;
import br.com.frmichetti.sonicinbox.util.Size;

public class FrameListener extends javax.swing.JFrame implements Runnable {

	private static final long serialVersionUID = -8266452496408906017L;
	
	private Thread t;	

    private javax.swing.JProgressBar JPB_Aceleracao;
    
    private javax.swing.JLabel LBL_Aceleracao;
    
    private javax.swing.JLabel jLabel1;

    public FrameListener() {
        
    	t = new Thread(Start.tgrpConsole, this, "Listener Thread");
        
        super.addKeyListener(Engine.event);

        initComponents();
        
        super.setVisible(true);
        
        super.setLocationRelativeTo(null);
        
        super.setLocation((Size.MAX_WIDTH - getWidth()) / 2, (Size.MAX_HEIGHT - getHeight()));

        t.start();
    }

    private void initComponents() {

        JPB_Aceleracao = new javax.swing.JProgressBar();
        
        jLabel1 = new javax.swing.JLabel();
        
        LBL_Aceleracao = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        setTitle("Console Key Listener ");
        
        setAlwaysOnTop(true);
        
        setLocation(new java.awt.Point(0, 0));
        
        setResizable(false);

        JPB_Aceleracao.setMaximum(2000);
        
        JPB_Aceleracao.setFocusable(false);
        
        JPB_Aceleracao.setStringPainted(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 9)); 
        
        jLabel1.setForeground(new java.awt.Color(0, 51, 255));
        
        jLabel1.setText("Aceleração");

        LBL_Aceleracao.setFont(new java.awt.Font("Tahoma", 0, 9));
        
        LBL_Aceleracao.setForeground(new java.awt.Color(0, 204, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        
        getContentPane().setLayout(layout);
        
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPB_Aceleracao, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LBL_Aceleracao, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LBL_Aceleracao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JPB_Aceleracao, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }


    private void doRefreshComponents() {
    	
        JPB_Aceleracao.setValue((int) Engine.sonic.getAcceleration());
        
        LBL_Aceleracao.setText(String.valueOf(Engine.sonic.getAcceleration()));
    }

    @Override
    public void run() {
    	
        while (true) {
        	
            doRefreshComponents();
            
            try {
            	
                Thread.sleep(ConfigEngine.FPS.getValue());

            } catch (InterruptedException ex) {
            	
            	throw new RuntimeException("Falha ao Interromper " + t.getName() + " " + ex.getMessage());
            }

        }
    }
}
