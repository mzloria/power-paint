/*
 * TCSS 305 Autumn 2018
 * Assignment 5
 */

package gui;

import action.ColorAction;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

/**
 * A toolbar used by the GUI.
 * 
 * @author Michael Zachary Loria
 * @version November 12 2018
 */
public final class GUIToolBar extends JToolBar
{
    /** A generated serialization ID. */
    private static final long serialVersionUID = 5872004772521482231L;
    
    /** A button group for the buttons for the tools. */ 
    private final ButtonGroup myGroup;
    
    /** The drawing panel where color will be set. */
    private final DrawingPanel myDrawingPanel;
    
    /**
     * Constructs the toolbar.
     * 
     * @param theDrawingPanel The drawing panel where the color will be set.
     */
    protected GUIToolBar(final DrawingPanel theDrawingPanel)
    {
        myDrawingPanel = theDrawingPanel;
        myGroup = new ButtonGroup();
        add(new JButton(new ColorAction(myDrawingPanel)));
    }
    
    /**
     * Creates a JToggleButton and adds it the JButtonGroup and the
     * toolbar.
     * 
     * @param theAction The action that is associated with each respective JToggleButton.
     */
    protected void createButton(final Action theAction) 
    {
        final JToggleButton toggleButton = new JToggleButton(theAction);
        myGroup.add(toggleButton);
        myGroup.clearSelection();
        add(toggleButton);
    }
}
