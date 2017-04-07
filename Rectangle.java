package homework.pkg4;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Arrays;
import javax.swing.JOptionPane;

public class Rectangle extends Shapes {

    double width, height, area, perimeter, x, y;
    int colorChoice;
    
    public Rectangle(double width, double height, double x, double y, int colorChoice){ // Constructor with appropriate parameters
        super(x,y,1); // default shapes object with passed in coordinates, with 1 being the default color of the shapes object
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.colorChoice = colorChoice;
    }
    
    public double getArea(){ // Gets area
        area = width*height; // Formula for area
        return area; // Returns area
    }
    
    public double getPerim(){ // Get perimeter
        perimeter = (width+height)*2; // Formula for perimeter, can be written muliple ways but I figured this be the most clean to program
        return perimeter; // Returns perimeter
    }
    
    public double getWidth() { // gets width
        return width; // returns width
    }
    
    public double getHeight() { // gets height
        return height; // returns height
    }
    
     public void setWidth(double width) { // takes in a new width length to set a new length
        this.width = width; // sets the new length
    }
     
     public void setHeight(double height){ // takes in the new height to set a new height
         this.height = height; // sets the new height
     }
     
     public String toString() { // to String descrption, returns the width and height of the rectangle
         return ("The width of this rectangle is " + getWidth() + ". The height of this rectangle is " + getHeight() + ".");
     }
     
     public Color assignColor(){ // Same function as the one in shapes
        switch(colorChoice){
            case 1: color = Color.white;
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
     
     public void draw(Graphics g, double x1, double y1){
         g.setColor(assignColor());
         g.fillRect((int)x1,(int)y1,(int) width,(int) height);
     }
}
