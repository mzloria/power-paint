/*
 * TCSS 305 Autumn 2018
 * Assignment 5
 */

package gui;

import java.awt.Color;
import java.awt.Shape;

/**
 * This class keeps track of the different aspects
 * of the shape to be painted, including the color,
 * thickness, the shape, and cap and join style.
 * 
 * @author Michael Zachary Loria
 * @version November 16 2018
 */
public final class PaintShape
{
    /** The color of the shape. */
    private final Color myColor;
    
    /** The thickness of the shape. */
    private final int myThickness;
    
    /** The shape to be painted. */
    private final Shape myShape;
    
    /** The cap style for the stroke. */
    private final int myCapStyle;
    
    /** The join style for the stroke. */
    private final int myJoinStyle;
    
    /**
     * Initializes the color, thickness, shape, cap style,
     * and join style. 
     * 
     * @param theColor The color of the shape.
     * @param theThickness The thickness of the shape.
     * @param theShape The shape to be painted.
     * @param theCapStyle The cap style of the shape.
     * @param theJoinStyle The join style of the shape.
     */
    protected PaintShape(final Color theColor, final int theThickness, final Shape theShape,
                         final int theCapStyle, final int theJoinStyle)
    {
        myColor = theColor;
        myThickness = theThickness;
        myShape = theShape;
        myCapStyle = theCapStyle;
        myJoinStyle = theJoinStyle;
    }
    
    /**
     * Returns the color of the shape.
     * 
     * @return The color of the shape.
     */
    protected Color getColor()
    {
        return myColor;
    }
    
    /**
     * Returns the thickness of the shape.
     * 
     * @return The thickness of the shape.
     */
    protected int getThickness()
    {
        return myThickness;
    }
    
    /**
     * Returns the shape to be painted.
     * 
     * @return The shape that will be painted.
     */
    protected Shape getShape()
    {
        return myShape;
    }
    
    /**
     * Returns the cap style of the shape.
     * 
     * @return The cap style of the shape.
     */
    protected int getCapStyle()
    {
        return myCapStyle;
    }
    
    /**
     * Returns the join style of the shape.
     * 
     * @return The join style of the shape.
     */
    protected int getJoinStyle()
    {
        return myJoinStyle;
    }
}
