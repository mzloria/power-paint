/*
 * TCSS 305 Autumn 2018
 * Assignment 5
 */

package gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import tools.LineTool;
import tools.Tool;

/**
 * The drawing panel for the paint program.
 * 
 * @author Michael Zachary Loria
 * @version November 16 2018
 */
public final class DrawingPanel extends JPanel
{
    /** A generated serial version ID. */
    private static final long serialVersionUID = 2834178596939362883L;
    
    /** Default color for the paint panel. */
    private static final Color DEFAULT_COLOR = new Color(51, 0, 111);
    
    /** Default thickness for the paint panel. */
    private static final int DEFAULT_THICKNESS = 5;
    
    /** A point outside the bounds of the GUI. */
    private static final Point NO_POINT = new Point(-50, -50);
    
    /** This allows this class to fire property change events. */
    private final PropertyChangeSupport myPCS;
    
    /** List of already painted shapes. */
    private final List<PaintShape> myShapes;
    
    /** Current thickness of the shape. */
    private int myCurrentThickness;
    
    /** Current color of the shape. */
    private Color myCurrentColor;
    
    /** Current tool being used. */
    private Tool myCurrentTool;    
    
    /** Current cap stroke being used. */
    private int myCurrentCapStyle;
    
    /** Current join stroke being used. */
    private int myCurrentJoinStyle;

    /**
     * Initializes the fields and adds mouse listeners
     * to the panel.
     */
    public DrawingPanel()
    {
        myShapes = new ArrayList<>();
        myPCS = new PropertyChangeSupport(this);
        myCurrentThickness = DEFAULT_THICKNESS;
        myCurrentColor = DEFAULT_COLOR;
        myCurrentCapStyle = BasicStroke.CAP_SQUARE;
        myCurrentJoinStyle = BasicStroke.JOIN_MITER;
        myCurrentTool = new LineTool();
        setBackground(Color.WHITE);
        addMouseListener(new DrawMouseAdapter());
        addMouseMotionListener(new DrawMouseMotionAdapter());
    }

    @Override
    public void paintComponent(final Graphics theGraphics)
    {
        super.paintComponent(theGraphics);
        final Graphics2D g2d = (Graphics2D) theGraphics;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                             RenderingHints.VALUE_ANTIALIAS_ON);  
        for (final PaintShape allShapes : myShapes)
        {
            g2d.setPaint(allShapes.getColor());
            g2d.setStroke(new BasicStroke(allShapes.getThickness(),
                                          allShapes.getCapStyle(), 
                                          allShapes.getJoinStyle()));
            g2d.draw(allShapes.getShape());
        }
        g2d.setStroke(new BasicStroke(myCurrentThickness, 
                                      myCurrentCapStyle, myCurrentJoinStyle));
        g2d.setPaint(myCurrentColor);
        g2d.draw(myCurrentTool.getShape());
    }
    
    /**
     * Sets the current color.
     * 
     * @param theColor The color that will be used to set the current color.
     */
    public void setColor(final Color theColor)
    {
        myCurrentColor = theColor;
    }
    
    /**
     * Sets the current thickness.
     * 
     * @param theThickness The thickness that will be used to set the current thickness.
     */
    public void setThickness(final int theThickness)
    {
        myCurrentThickness = theThickness;
    }
    
    /**
     * Sets the current tool.
     * 
     * @param theTool The tool that will be used to set the current tool.
     */
    public void setTool(final Tool theTool)
    {
        myCurrentTool = theTool;
    }
    
    /**
     * Sets the current cap style.
     * 
     * @param theCapStyle The cap style that will be used to set the current cap style.
     */
    public void setCapStyle(final int theCapStyle)
    {
        myCurrentCapStyle = theCapStyle;
    }
    
    /**
     * Sets the current join style. 
     * 
     * @param theJoinStyle The join style that will be used to set the current join style.
     */
    public void setJoinStyle(final int theJoinStyle)
    {
        myCurrentJoinStyle = theJoinStyle;
    }
    
    /**
     * Returns the current color.
     * 
     * @return The current color.
     */
    public Color getColor()
    {
        return myCurrentColor;
    }
    
    /**
     * Returns the current thickness.
     * 
     * @return The current thickness.
     */
    public int getThickness()
    {
        return myCurrentThickness;
    }
    
    /**
     * Clears the drawing panel.
     */
    public void clearPanel()
    {
        myShapes.clear();
        myCurrentTool.setStartPoint(NO_POINT);
        repaint();
        myPCS.firePropertyChange("There are no items to clear.", true, false);
    }
    
    /**
     * Adds a listener for property change events.
     * 
     * @param theListener The PropertyChangeListener that will be added.
     */
    public void addPropertyChangeListener(final PropertyChangeListener theListener) 
    {
        myPCS.addPropertyChangeListener(theListener);
    }
    
    /**
     * Removes a listener for property change events.
     * 
     * @param theListener The PropertyChangeListener that will be removed.
     */
    public void removePropertyChangeListener(final PropertyChangeListener theListener) 
    {
        myPCS.removePropertyChangeListener(theListener);
    }
    
    /**
     * Listens for mouse events to draw on the panel.
     * 
     * @author Michael Zachary Loria
     * @version November 16 2018
     */
    private final class DrawMouseAdapter extends MouseAdapter
    {
        @Override
        public void mousePressed(final MouseEvent theEvent)
        {
            myCurrentTool.setStartPoint(theEvent.getPoint());
            repaint();
        }

        @Override
        public void mouseReleased(final MouseEvent theEvent)
        {
            myShapes.add(new PaintShape(myCurrentColor, myCurrentThickness, 
                myCurrentTool.getShape(), myCurrentCapStyle, myCurrentJoinStyle));
            myPCS.firePropertyChange("There are items to clear.", false, true);
        }
    }

    /**
     * Listens for mouse motion events to draw on the panel.
     * 
     * @author Michael Zachary Loria
     * @version November 16 2018
     */
    private final class DrawMouseMotionAdapter extends MouseMotionAdapter
    {
        @Override
        public void mouseDragged(final MouseEvent theEvent)
        {
            myCurrentTool.setEndPoint(theEvent.getPoint());
            repaint();
        }
    }
}
