/*
Creates a circle 
 */
package homework.pkg4;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JOptionPane;
/**
 *
 * @author John
 */
public class Circle extends Shapes { // Extends shapes class
    public static double radius, x,y;
    public int colorChoice;
    
    public Circle(double radius, double x, double y, int colorChoice) { // Constructor assigning values to radius, x,y center coordinates, and the color choice
        super(0,0,1);
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.colorChoice = colorChoice;
    }
    
    public void setRadius(double radius){
        this.radius = radius; // function to reset circle radius
    }
    
    public static double getRadius(){
        return radius; // returns radius
    }
    
    public double getArea(){
        return Math.PI*Math.pow(radius,2); // Formula for getting area of a circle and returns it
    }
    
    public double getPerim(){
        return 2*Math.PI*radius; // Formula for getting perimeter and returns it
    }
    
    public String toString(){
        return ("The circle's radius is " + getRadius() + ". The circles perimeter is " + getPerim() + ". The circle's area is " + getArea() + ".");
    } // String description of the circle
    
    public void draw(Graphics g, double x, double y){
        g.setColor(assignColor()); // gets color for the circle 
        g.fillOval((int)(x-radius),(int)(y-radius),2*(int)radius,2*(int)radius); // Oval draws in an invisible rectange box, x-radius and y-radius is the top left corner,
        // this starts the circle so it will be centered at the point given by te user, 2*r is the diameter along x and y
        JOptionPane.showMessageDialog(null, toString(),"Circle Description",JOptionPane.INFORMATION_MESSAGE); // Displays string description of the circle's properties
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
}
