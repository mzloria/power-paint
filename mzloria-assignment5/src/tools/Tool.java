/*
 * TCSS 305 Autumn 2018
 * Assignment 5
 */

package tools;

import java.awt.Point;
import java.awt.Shape;

/**
 * An interface for the tools needed to draw shapes.
 * 
 * @author Michael Zachary Loria
 * @version November 16 2018
 */
public interface Tool
{
    /**
     * Sets the start point for the shape of the tool,
     * which is needed to draw the shape in the correct location.
     * 
     * @param theStartPoint The start point for the shape of the tool.
     */
    void setStartPoint(Point theStartPoint);
 
    /**
     * Sets the end point for the shape of the tool,
     * which is needed to draw the shape in the correct location.
     * 
     * @param theEndPoint The end point for the shape of the tool.
     */
    void setEndPoint(Point theEndPoint);
    
    /**
     * Returns the start point for the shape of the tool.
     * 
     * @return The start point for the shape of the tool.
     */
    Point getStartPoint();
    
    /**
     * Returns the end point for the shape of the tool.
     * 
     * @return The end point for the shape of the tool.
     */
    Point getEndPoint();
    
    /**
     * Returns the shape of the tool using the
     * correct start and end points.
     * 
     * @return The shape that will be drawn.
     */
    Shape getShape();
}
