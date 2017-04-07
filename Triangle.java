package homework.pkg4;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Arrays;
import javax.swing.JOptionPane;

 class Triangle extends Shapes { // Extends shapes class
    Color color;
    double sideA, sideB, sideC, angle, angleA, angleB, angleC, orig_x, orig_y; 
    int[] x = new int[4]; // Arrays for x coordinates
    int[] y = new int[4]; // Arrays for y coordinates
    int colorChoice; // Color choice
    
    public Triangle(double a, double b, double c, int colorChoice) { // constructor 1 using parameters for sides and a color choice
        super(0,0,1); // Initializing shapes class with default values of choice
        //super(x,y,color);
        sideA = a;
        sideB = b;
        sideC = c;
        this.colorChoice = colorChoice;
    }
    
    public Triangle(double side, double angle,int colorChoice){ // constructor 2 using parameters for a length for 2 sides and an angle between them with user color choice
        super(0,0,1); // Again initializing class with default values of choice
        sideA = side;
        sideB = side;
        angleC = angle;
        sideC = Math.sqrt(Math.pow(sideA,2)+Math.pow(sideB,2)-(2*sideA*sideB*Math.cos(Math.toRadians(angle)))); // Figuring out sideC with formula sqrt((sideA)^2+(sideB)^((2-2sideAsideB)*cos(angle))
        angleB = (180-angle)/2; // Iscoleces triangles always have equal angles with the base of the triangle, so it finds the remaining degrees available for a triangle and divides it by 2
        angleA = (180-angle)/2; // Same as above assigns it to the other angle
        this.colorChoice = colorChoice; 
    }
    
    //Checks if this is a triangle
    public boolean isTriangle () 
    {
        if(sideA+sideB>sideC && sideA+sideC>sideB && sideB+sideC>sideA){ // Rules of triangle is if you add 2 sides, it should be greater then the third one
            return true;
        }
        else
            return false; // If those requirements arent met, a triangle can't be made
    }
    
    public double getPerim(){ // Gets the perimeter
        return sideA+sideB+sideC;
    }
    //return Area
    public double getArea(){
       double p=(getPerim()/2);
       double area = Math.sqrt(p*(p-sideA)*(p-sideB)*(p-sideC)); // We use Herons formula which lets you find the area of a triangle with any values for the sides, where P 
       // here is the perimeter divded by 2 which I assigned above
       return (int) area; // Casted to an int just to round, don't need to do this if you want to be much more accurate
    }
    //get sides
    public double getSideA(){ // These return the side lengths
        return sideA;
    }
    public double getSideB(){
        return sideB;
    }
    public double getSideC(){
        return sideC;
    }
    public double getAngleA(){
        angleA = Math.acos((Math.pow(sideB,2)+Math.pow(sideC,2)-Math.pow(sideA,2))/(2*sideB*sideC)) * (180/Math.PI); // This returns the angles depending on the sides, * (180/Math.PI) to change to degrees
        return angleA;
    }
    public double getAngleB(){
        angleB = Math.acos((Math.pow(sideA,2)+Math.pow(sideC,2)-Math.pow(sideB,2))/(2*sideA*sideC)) * (180/Math.PI);
        return angleB;
    }
    public double getAngleC(){
        angleC = Math.acos((Math.pow(sideA,2)+Math.pow(sideB,2)-Math.pow(sideC,2))/(2*sideA*sideB)) * (180/Math.PI);
        return angleC;
    }
    public void getAngles(){ // Returns angles added together, didn't know if homework instructions meant return each individually, but this shows they all add to 180
        double angle_total = getAngleA()+getAngleB()+getAngleC();
        System.out.print(angle_total);
    }

    //set sides
    public void setSides(double a, double b, double c){ // Sets the sides
        sideA = a;
        sideB = b;
        sideC = c;
    }

    //@Override
    public void draw(Graphics g, double x1, double y1){  // Draw function for Triangle
        double phi = 90; // You can set this to anything, if you set it to 90 the base will be parallel with the x axis, I let it at 45 to see symmetry with the diagonal of the Panel
        double beta = getAngleC()/2; // Beta is half the angleC (the angle of the apex)
        setCoords(x1,y1); // Sets the first point of the triangle (the apex) to the points passed in
        x[0] = (int) get_X(); // Assigning that point as the first point in the x and y arrays
        y[0] = (int) get_Y();
        moveTo(sideB*(Math.cos(Math.toRadians(phi-beta))),sideB*(Math.sin(Math.toRadians(phi-beta)))); // Formula for finding the next point depending on how far it should be and
        //depending on the angle of the diagonal to X axis and the bet aangle to the X axiss
        x[1] = (int) get_X(); // Pushes the new coords into the arrays
        y[1] = (int) get_Y();
        moveTo(-sideB*(Math.cos(Math.toRadians(phi-beta))),-sideB*(Math.sin(Math.toRadians(phi-beta)))); // Moves back to the apex point by using the same formula as before but negating it
        moveTo(sideA*(Math.cos(Math.toRadians(phi+beta))),sideA*(Math.sin(Math.toRadians(phi+beta)))); // Finding new coords again...
        x[2] = (int) get_X(); // Push coords into array
        y[2] = (int) get_Y();
        moveTo(-sideA*(Math.cos(Math.toRadians(phi+beta))),-sideA*(Math.sin(Math.toRadians(phi+beta)))); // Moves back to the apex point by using the same formula as before but negating it
        x[3] = (int) get_X(); // Push coords into array
        y[3] = (int) get_Y();
        //System.out.println(Arrays.toString(x)); Used to see if correct coordinates are being produced for each vertice
        //System.out.println(Arrays.toString(y)); ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
        g.setColor(assignColor()); // sets the color of the triangle depending on the user choice by calling the assignColor function
        g.fillPolygon(x,y,4); // Passes the arrays with the coords into the fillPolygon function, 4 as in the inputs
        JOptionPane.showMessageDialog(null, toString(),"Triangle Description",JOptionPane.INFORMATION_MESSAGE); // Displays a message with the triangles description in toString (which is below)
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

    public String toString(){ // toString of this class describes the triangle
        return ("Triangles in this program are as follows:\nThe left side is side A, the right side is side B and the bottom side is side C.\n"
                + "The length of side A is " + getSideA()+".\nThe length of side B is " + getSideB()+".\nThe legnth of side C is " + getSideC()+".\nThe area of the triangle"
                + " is " + getArea()+".\nThe perimeter of the triangle is " + getPerim() + ".\nVertex angles are opposite of their corresponding sides.\nAngle A is " + getAngleA()
                + ".\nAngle B is " + getAngleB() + ".\nAngle C is " + getAngleC());
    }
    /* Probably the most difficult part of this program was trying to figure out the other points given a distance for the sides, everything else was trigonometry and geometry
    and also a knowledge of hiearchies
    */
}
