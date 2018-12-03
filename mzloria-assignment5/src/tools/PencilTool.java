/*
 * TCSS 305 Autumn 2018
 * Assignment 5
 */

package tools;

import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Path2D;
import java.util.ArrayList;
import java.util.List;

/**
 * This is the class that handles the pencil
 * tool.
 * 
 * @author Michael Zachary Loria
 * @version November 16 2018
 */
public final class PencilTool extends AbstractTool
{
    /** The list of points that the path will go through. */
    private final List<Point> myPoints;

    /**
     * Implicitly calls parent constructor and initializes
     * the list of points for the path.
     */
    public PencilTool()
    {
        myPoints = new ArrayList<>();
    }
    
    /**
     * Sets start point and end point to the specified point,
     * and also clears the list of points in the path.
     * 
     * {@inheritDoc}
     */
    @Override
    public void setStartPoint(final Point theStartPoint)
    {
        myPoints.clear();
        super.setStartPoint((Point) theStartPoint.clone());
        super.setEndPoint((Point) theStartPoint.clone());      
    } 
    
    /**
     * Returns a specified path with the start points and 
     * end points.
     * 
     * {@inheritDoc}
     */
    @Override
    public Shape getShape()
    {
        final Path2D pencilShape = new Path2D.Double();
        pencilShape.moveTo(getStartPoint().getX(), getStartPoint().getY());
        myPoints.add(getEndPoint());
        for (Point pathPoint : myPoints)
        {
            pencilShape.lineTo(pathPoint.getX(),  pathPoint.getY());
        }
        return pencilShape;
    }
}
