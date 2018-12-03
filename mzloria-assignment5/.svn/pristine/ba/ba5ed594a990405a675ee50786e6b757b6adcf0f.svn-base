/*
 * TCSS 305 Autumn 2018
 * Assignment 5
 */

package action;

import gui.DrawingPanel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JColorChooser;



/**
 * A color action for the Paint program.
 * 
 * @author Michael Zachary Loria
 * @version November 16 2018
 */
public final class ColorAction extends AbstractAction
{
    
    /** A generated serialization ID. */
    private static final long serialVersionUID = 1564105703913928581L;
    
    /** The drawing panel where the color will be used. */
    private final DrawingPanel myDrawingPanel;
    
    /**
     * The constructor that initializes the fields.
     * 
     * @param theDrawingPanel The drawing panel where the color will be used.
     */
    public ColorAction(final DrawingPanel theDrawingPanel)
    {
        super("Color...");
        myDrawingPanel = theDrawingPanel;
    }

    /**
     * Opens color chooser and sets the proper color
     * when painting on the draw panel.
     * 
     * {@inheritDoc}
     */
    @Override
    public void actionPerformed(final ActionEvent arg0)
    {
        final Color currentColor = JColorChooser.showDialog(null, "Color Chooser", 
                                                            myDrawingPanel.getColor());
        if (currentColor != null)
        {
            myDrawingPanel.setColor(currentColor);
        }
    }

}
