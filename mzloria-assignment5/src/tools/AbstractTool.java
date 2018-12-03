/*
 * TCSS 305 Autumn 2018
 * Assignment 5
 */

package tools;

import java.awt.Point;

/**
 * This is the class for an abstract tool.
 * 
 * @author Michael Zachary Loria
 * @version November 16 2018
 */
public abstract class AbstractTool implements Tool
{
    /** A point outside the bounds of the GUI. */
    private static final Point NO_POINT = new Point(-50, -50);
    
    /** The start point of the tool. */
    private Point myStartPoint;
    
    /** The end point of the tool. */
    private Point myEndPoint;
    
    /** Initialize the start and end points. */
    public AbstractTool()
    {
        myStartPoint = NO_POINT;
        myEndPoint = NO_POINT;
    }
    
    @Override
    public void setStartPoint(final Point theStartPoint)
    {
        myStartPoint = (Point) theStartPoint.clone();
        myEndPoint = (Point) theStartPoint.clone();
    }
    
    @Override
    public void setEndPoint(final Point theEndPoint)
    {
        myEndPoint = (Point) theEndPoint.clone();
    }
    
    @Override
    public Point getStartPoint()
    {
        return myStartPoint;
    }
    
    @Override
    public Point getEndPoint()
    {
        return myEndPoint;
    }
}
