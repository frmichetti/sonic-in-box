/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see mailto:frmichetti@gmail.com
 * */
package br.com.frmichetti.sonicinbox.util;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Rectangle;

public abstract class Size {
 
	public static GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    
	public static Point centerPoint = ge.getCenterPoint();

	public static Rectangle maximumWindowBounds = ge.getMaximumWindowBounds();
    
	public static GraphicsDevice[] screenDevices = ge.getScreenDevices();
    
	public static GraphicsDevice defaultScreenDevice = ge.getDefaultScreenDevice();
    
	public static int MAX_HEIGHT = maximumWindowBounds.height;
    
	public static int MAX_WIDTH = maximumWindowBounds.width;
    
	public static double CENTER_Y = maximumWindowBounds.getCenterY();
    
	public static double CENTER_X = maximumWindowBounds.getCenterX();

}
