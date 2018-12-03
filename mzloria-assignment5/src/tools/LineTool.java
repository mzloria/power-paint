/*
 * TCSS 305 Autumn 2018
 * Assignment 5
 */

package tools;

import java.awt.Shape;
import java.awt.geom.Line2D;

/**
 * This is the class that handles the
 * line tool. 
 * 
 * @author Michael Zachary Loria
 * @version November 16 2018
 */
public final class LineTool extends AbstractTool
{
    /**
     * Returns a line from the start point and 
     * the end point.
     * 
     * {@inheritDoc}
     */
    @Override
    public Shape getShape()
    {
        return new Line2D.Double(getStartPoint(), getEndPoint());
    }
}
