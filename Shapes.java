package homework.pkg4;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

abstract public class Shapes extends Object { // extending Objects and declaring this class abstract
    double pointX, pointY, orig_X, orig_Y; // declaring variables
    int colorChoice;
    Color color;
    
    
    public Shapes(double x, double y, int colorChoice) { // Constructor
        pointX = x; // assigning values to variables
        pointY = y;
        orig_X = x;
        orig_Y = y;
        this.colorChoice = colorChoice;
    }
    //get values
    public double get_X(){ // returns x coord
        return pointX;
    }
    public double get_Y(){ // returns y coord
        return pointY;
    }    
    public int getColor(){ // returns color value
        return colorChoice;
    }
    //set values
    public void setCoords(double x, double y){ // sets the Coords to the values passed into it
        pointX = x;
        pointY = y;
    }
    public void setColor(int colorChoice){ // sets the color to its variable color
        this.colorChoice = colorChoice;
    }
    //Moving to another point
    public void moveTo(double deltaX, double deltaY){ // moveTo function takes in value deltaX and deltaY (basically how much you wanna move X and Y)
        setCoords(pointX+deltaX,pointY+deltaY); // Then adds the change to the current coordinate, creating a new coordinate, and passes it to setCoords to set the new coord.
    }
    //Objects Description
    public String toString(){
        return ("Generic Shape"); // Returns the String Generic Shape for the Shapes class
        //return ("The (x,y) coordinates are (" + get_X() + "," + get_Y() + "). The color is " + getColor()); // Was used for testing, not used
    }
    
     public Color assignColor(){ // a Color type called assignColor
        switch(colorChoice){ // Switch using the users colorChoice they inputted
            case 1: color = Color.white; // Depending on what they chose, it assigns the corresponding color
            break;
            case 2: color = Color.black;
            break;
            case 3: color = Color.gray;
            break;
            case 4: color = Color.red;
            break;
            case 5: color = Color.green;
            break;
            case 6: color = Color.blue;
            break;
            case 7: color = Color.orange;
            break;
            case 8: color = Color.yellow;
            break;
            case 9: color = Color.cyan;
            break;
            case 10: color = Color.magenta;
            break;
            case 11: color = Color.pink;
            break;
            default:
                color = Color.black;
                break;
        }
        return color;
     }
    // Sets Panel Background to a default color

    public void draw(Graphics g){
        JOptionPane.showMessageDialog(null, toString(),"Description",JOptionPane.INFORMATION_MESSAGE); //Displays a message to the user, the message from method toString()
        //setBackground(Color.cyan); // Sets it to a default color <---- I had this as a default option, but im not sure if you wanted a user to still specify a color, so
        // this below will set the drawing panel's color to the users choice
       // setBackground(assignColor()); // Sets it to the users Choice of color
    }

}