package br.com.codecode.sonicinbox.util;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Rectangle;

// TODO: Auto-generated Javadoc
/**
 * The Class Size.
 */
public class Size {
    
    /**
     * Instantiates a new size.
     */
    private Size(){};

    /** The ge. */
    public static GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();

    /** The center point. */
    public static Point centerPoint = ge.getCenterPoint();

    /** The maximum window bounds. */
    public static Rectangle maximumWindowBounds = ge.getMaximumWindowBounds();

    /** The screen devices. */
    public static GraphicsDevice[] screenDevices = ge.getScreenDevices();

    /** The default screen device. */
    public static GraphicsDevice defaultScreenDevice = ge.getDefaultScreenDevice();

    /** The max height. */
    public static int MAX_HEIGHT = maximumWindowBounds.height;

    /** The max width. */
    public static int MAX_WIDTH = maximumWindowBounds.width;

    /** The center y. */
    public static double CENTER_Y = maximumWindowBounds.getCenterY();

    /** The center x. */
    public static double CENTER_X = maximumWindowBounds.getCenterX();

}
