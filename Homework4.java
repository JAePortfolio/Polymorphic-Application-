package homework.pkg4;
import javax.swing.JFrame;
// Import necessary packages

public class Homework4 {
    public static void main(String[] args) {
        LayoutManager layoutManager = new LayoutManager(); // New LayoutManager object
        layoutManager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close button
        layoutManager.setSize(400,110); // Size of the Layout manager
        layoutManager.setLocationRelativeTo(null); // For my computer, I put this so it centers on the screen (the layout manager)
        layoutManager.setVisible(true); // Make it visible
    }
}
