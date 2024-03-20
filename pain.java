import ecs100.*;
import java.awt.Color;
import javax.swing.JColorChooser;

/**
 * pain
 *
 * @author CP
 * @version 14/03/24
 */
public class pain
{
    // instance variables
    private double startX, startY; // Fields to remeber pressed position
    private Color currentColor = Color.black; // Current colour set to black
    private double width = 5.0; // Set og linewidth to 5
    
 
    /**
     * Constructor for objects of class Line
     */
    public pain()
    {
        // initialise instance variables
        UI.setLineWidth(10);
        UI.addButton("Random Colour", this::randomColour); // Call back to change to random colours
        UI.addButton("Choose Colour", this::doChooseColor); // Call back to change to random colours
        UI.addButton("Change shape", this::doChangeShape); // Change the circle to the rectangle click
        UI.addSlider("Line Width", 1, 100,10, this::setWidth);
        UI.addButton("Clear", UI::clearGraphics);
        UI.addButton("Quit", UI::quit);
        UI.setMouseListener(this::doMouse);
        
    }

    /**
     * Call back random colour changer
     * 
     */
    public void randomColour(){
        // Set random RGB values beween 0.0 and 1.0
        Color col = new Color((float) Math.random(),(float) Math.random(),(float) Math.random());
        UI.setColor(col);
    }
    
    public void doChooseColor(){
        this.currentColor = JColorChooser.showDialog(null, "Choose colour", this.currentColor);
        UI.setColor(this.currentColor);
    }
    
    public void setWidth(double newWidth) {
        this.width = newWidth;
        UI.setLineWidth(newWidth);
    }
    
    public void doChangeShape(){
        
    }
    
    
    
    /**
     * Call back method fo mouse
     * Draws a line
     * 
     */
    public void doMouse(String action, double x, double y) {
        if (action.equals("pressed")){
            // store the pressed position
            this.startX = x;
            this.startY = y;
        } else if (action.equals("released")){
            // stored the released position
            UI.drawLine(this.startX, this.startY, x, y); // Draw line when mouse is released
            
        } else if  (action.equals("clicked")){
            UI.fillOval(x-25 ,y-25, 50, 50);
        }
    }
    
}