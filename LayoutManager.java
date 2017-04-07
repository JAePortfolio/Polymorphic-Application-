package homework.pkg4;

import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class LayoutManager extends JFrame {

    private final JButton leftButton; // Declare 2 buttons for the two assignments, this one is for Exercise 1
    private final JButton rightButton; // Exercise 3
    private final FlowLayout layout;  // FlowLayout 

    public LayoutManager() {
        super("Homework 4 - User Selection");
        layout = new FlowLayout(); // New flow layout
        setLayout(layout);
        leftButton = new JButton("Shrinking Circles inside Shrinking Squares (Exercise 1)"); // Exercise 1
        add(leftButton); // Add the button
        leftButton.addActionListener( // listen for actions from users
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) { // Adaptation of previous programs from previous exercises
                String input_1 = JOptionPane.showInputDialog("Please enter the side length of the square"); // Inputs
                double side = Double.parseDouble(input_1);
                String input_2 = JOptionPane.showInputDialog("Enter the x coordinate of the top left of the rectangle (Must be between 0 and 300)");
                double x = Double.parseDouble(input_2);
                if(x < 0 || x > 300) { // Checks if coordinate is not in range of the panel size, if not display an error message and it will exit
                    JOptionPane.showMessageDialog(null,"Your coordinate cannot be less then 0 or greater then 300! Program will now close","Error!",JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                }
                String input_3 = JOptionPane.showInputDialog("Enter the y coordinate of the top left of the rectangle (Must be between 0 and 300)");
                double y = Double.parseDouble(input_3);
                if(y < 0 || y > 300) { // Checks if coordinate is not in the range of panel size
                    JOptionPane.showMessageDialog(null,"Your coordinate cannot be less than 0 or greater than 300! Program will now close", "Error!",JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                }
                String input_4 = JOptionPane.showInputDialog("Enter a number for color of the squares\n" + "1 for white\n" + "2 for black\n" + "3 for gray\n" + "4 for red\n" + "5 for green\n"
                        + "6 for blue\n" + "7 for orange\n" + "8 for yellow\n" + "9 for cyan\n" + "10 for magenta\n" + "11 for pink\n");
                int colorSquare = Integer.parseInt(input_4);
                String input_5 = JOptionPane.showInputDialog("Enter a number for color of the circles\n" + "1 for white\n" + "2 for black\n" + "3 for gray\n" + "4 for red\n" + "5 for green\n"
                        + "6 for blue\n" + "7 for orange\n" + "8 for yellow\n" + "9 for cyan\n" + "10 for magenta\n" + "11 for pink\n");
                int colorCircle = Integer.parseInt(input_5);
                Application Application = new Application(x, y, side, colorSquare, colorCircle); // Creates an application object with the appropriate parameters
                Application.drawCaseOne(); // Calls the drawCaseOne method which draws Exercise 1
            }
        }
        );
        rightButton = new JButton("Inscribe a circle inside a triangle (Exercise 3)"); // Right button to do exercise 3
        add(rightButton); // Adding right button
        rightButton.addActionListener( // Listening for user actions
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) { // Adaptation of previous programs from previous exercises
                String input_1 = JOptionPane.showInputDialog("Enter the side length of the triangle sides"); // Inputs
                double length = Double.parseDouble(input_1);
                String input_2 = JOptionPane.showInputDialog("Enter the x coordinate of the apex point (Must be between 0 and 300");
                double x = Double.parseDouble(input_2);
                if(x < 0 || x > 300) { // Checks if coordinate is not in the range of panel size
                    JOptionPane.showMessageDialog(null,"Your coordinate cannot be less then 0 or greater then 300! Program will now close","Error!",JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                }
                String input_3 = JOptionPane.showInputDialog("Enter the y coordinate of the apex point (Must be between 0 and 300)");
                double y = Double.parseDouble(input_3); // Checks if coordinate is not in the range of panel size
                if(y < 0 || y > 300) {
                    JOptionPane.showMessageDialog(null,"Your coordinate cannot be less than 0 or greater than 300! Program will now close", "Error!",JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                }
                String input_4 = JOptionPane.showInputDialog("Enter a number for color of the triangle\n" + "1 for white\n" + "2 for black\n" + "3 for gray\n" + "4 for red\n" + "5 for green\n"
                        + "6 for blue\n" + "7 for orange\n" + "8 for yellow\n" + "9 for cyan\n" + "10 for magenta\n" + "11 for pink\n");
                int colorTriangle = Integer.parseInt(input_4);
                String input_5 = JOptionPane.showInputDialog("Enter a number for color of the circle\n" + "1 for white\n" + "2 for black\n" + "3 for gray\n" + "4 for red\n" + "5 for green\n"
                        + "6 for blue\n" + "7 for orange\n" + "8 for yellow\n" + "9 for cyan\n" + "10 for magenta\n" + "11 for pink\n");
                int colorCircle = Integer.parseInt(input_5);
                Application Application = new Application(x, y, length, colorTriangle, colorCircle); // Creates new application object with the appropriate parameters
                Application.drawCaseTwo(); // calls the drawCaseTwo method which draws Exercise 3

            }
        }
        );
    }
}
