/*
 * TCSS 305 Autumn 2018
 * Assignment 5
 */

package tools;

import java.awt.Shape;
import java.awt.geom.Rectangle2D;

/**
 * This is the class that handles the 
 * rectangle tool.
 * 
 * @author Michael Zachary Loria
 * @version November 14 2018
 */
public final class RectangleTool extends AbstractTool
{
    /**
     * Returns a rectangle with specified start point
     * and the width and height.
     * 
     * {@inheritDoc}
     */
    @Override
    public Shape getShape()
    {
        final int startX = (int) Math.min(getStartPoint().getX(), getEndPoint().getX());
        final int startY = (int) Math.min(getStartPoint().getY(), getEndPoint().getY());
        final int endX = (int) Math.max(getStartPoint().getX(), getEndPoint().getX());
        final int endY = (int) Math.max(getStartPoint().getY(), getEndPoint().getY());
        return new Rectangle2D.Double(startX, startY, endX - startX, endY - startY);
    }
}
