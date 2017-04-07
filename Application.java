package homework.pkg4;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Application extends Shapes {

    double x, y, side;
    int colorChoiceOne, colorChoiceTwo;
    
    /*public Application(double side, double x, double y) { // Constructor for exercise 1
        super(x, y, 1); // creates default shapes object with the passed in coordinates, 1 being the default color for shapes
        this.side = side; // Assigns the variables to the parameters passed in.. 
        this.x = x;
        this.y = y;
    } */ // Got rid of this constructor as colorGenerator didnt work, so for either exercise, user would be choosing color

    public Application(double x, double y, double side, int colorChoiceOne, int colorChoiceTwo) { // Constructor for exercise 3
        super(x, y, 1); // creates default shapes object with the passed in coordinates, 1 being the default color for shapes
        this.side = side; // Assigns the variables to the parameters passed in..
        this.colorChoiceOne = colorChoiceOne; // Colors picked by the user
        this.colorChoiceTwo = colorChoiceTwo;
        this.x = x;
        this.y = y;
    }

    public void drawCaseOne() { // Method for Exercise 1
        JPanel panel = new JPanel() { // Create a new JPanel
            public void paintComponent(Graphics g) { // new paint component for this JPanel
                super.paintComponent(g);
                Rectangle Rect = new Rectangle(side, side, x, y,colorChoiceOne); // New rectangle object which creates a square, 1 being the default color
                Circle C1 = new Circle(side/2,x,y,colorChoiceTwo);
                int[] x = new int[5]; // Arrays for x and y coordinates 
                int[] y = new int[5];
                x[0] = (int) get_X(); // Assign first top left point of the square to the first index of the array...
                y[0] = (int) get_Y();
                for (int i = 1; i <= 10; i++) { // Loop to basically draw multiple squares and circles, you can change 10 to any amount you'd like
                    if (i < 5) { // You can set this to any value you'd like also, 6, 7, but you must increase the array size as you do
                        /*int R_rect = (int) (Math.random() * 256); // This is a random color generator I made in exercise 1 that I brought here
                        int G_rect = (int) (Math.random() * 256); // It will make random colors for each loop
                        int B_rect = (int) (Math.random() * 256);
                        int R_oval = (int) (Math.random() * 256);
                        int G_oval = (int) (Math.random() * 256);
                        int B_oval = (int) (Math.random() * 256);
                        Color colorGeneratorRect = new Color(R_rect, G_rect, B_rect); // Random colors for rectangles, in this case, squares
                        Color colorGeneratorOval = new Color(R_oval, G_oval, B_oval); // Random colors for ovals, in this case, circles*/
                        
                        // Just showing above that the color randomizer from exercise 1 no longer operates properly as users now select the color, so it interferes
                        // with the draw functions of rectangle and circle. 
                        x[i] = (int) (((Rect.getWidth() - Math.sqrt(Rect.getArea() / 2.0)) / 2.0) + x[i - 1]); // I will discuss this formula below 
                        y[i] = (int) (((Rect.getHeight() - Math.sqrt(Rect.getArea() / 2.0)) / 2.0) + y[i - 1]); // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^
                        //g.setColor(colorGeneratorRect); // Random color.., this will override the color set in Rectangles draw function
                        Rect.draw(g,x[i - 1], y[i - 1]); // new rectangle drawing, starting from the first index to get the first point of the top left corner
                        //g.setColor(colorGeneratorOval); // Same as above.. 
                        C1.draw(g,x[i - 1]+(Rect.getWidth()/2), y[i - 1]+(Rect.getHeight()/2)); // Described below
                        double new_side = Math.sqrt(Rect.getArea() / 2.0); // Explained below... 
                        C1.setRadius(new_side/2); // new radius
                        Rect.setWidth(new_side); // Sets the new width of the smaller square
                        Rect.setHeight(new_side); // sets the new height of the smaller square
                    }
                }
            }
        };
        JFrame application = new JFrame();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.add(panel);
        application.setSize(316, 339);
        application.setLocationRelativeTo(null);
        application.setVisible(true);
    }

    public void drawCaseTwo() { // Exercise 3 
        JPanel panel = new JPanel() {
            public void paintComponent(Graphics g) {
                System.out.print(get_Y());
                super.paintComponent(g);
                double radius = side * (Math.sqrt(3) / 6); // Radius of a circle inscribed a equilateral triangle is side of triangle * sqrt(3)/6
                Triangle T1 = new Triangle(side, side, side, colorChoiceOne); // New triangle object with same 3 sides
                T1.draw(g, x, y); // draw
                double y2 = y + (side * (Math.cos(Math.toRadians(30)))); // Angle cause phi = 90 - the angle, which in equilateral triangle is always 60, 90-60 = 30 We are calculating the triangle base's y coordinate
                double height = y2 - y; // Find the height of the triangle
                double center_y = ((height) * (2.0 / 3.0)) + y; // The center point of a circle in an equilateral triangle is 2/3rd down the height from the apex point
                Circle C1 = new Circle(radius, x, center_y, colorChoiceTwo); // New circle with the calculated point
                C1.draw(g,x,center_y);
            }
        };
        JFrame application = new JFrame();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.add(panel);
        application.setSize(316, 339);
        application.setLocationRelativeTo(null);
        application.setVisible(true);
    }
}

// For exercise 1, i wasn't able to calculate how to fit another square inside in each circle inscribed  in the last one
// After some research, I saw the size of the next square is a 2:1 ratio to the last one. Using this, we know the area is half the last one
//So I calculate the area of the first square, divide it by 2 to get the area of the next. I take the square root of that to get the side length of this next square
// Then, you find the difference in side length between the first length and the second length. Then you divide it by 2 to find the distance of the next coordinates for the 2nd
// square. Then you draw the next square with these points and the new side, and loop through this as many times as you want, depending how many rectangles and circles you want
// As for drawing the circle, the circles draw function is designed to draw a circle using its center point, not the top left corner. It does it by doing the point minus the
//radius length, for x and y. To avoid this, when you call the draw function, just call it with x+radius and y+radius, then in the draw function it will do -radius, canceling 
// the +radius, just leaving us with the original x and y coordinate. 