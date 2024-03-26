import javax.swing.ImageIcon;
import javax.swing.JFrame; // Importing JFrame class from javax.swing package

import java.awt.Color; // Importing Color class from java.awt package
import java.awt.Image;

public class SnakeGame { // Declaring a public class named SnakeGame
  public static void main(String[] args) throws Exception { // Main method
    System.out.println("Create JFrame"); // Print statement

    // Creating a new JFrame object
    JFrame frame = new JFrame();

    // Creating a new instance of the Gameplay class
    Gameplay gamePlay = new Gameplay();

    // Centering the JFrame on the screen
    frame.setLocationRelativeTo(null);

    // Title
    frame.setTitle("Snake game");

    // Logo
    try {
      ImageIcon icon = new ImageIcon("assets/images/logo.png");
      Image logo = icon.getImage();
      frame.setIconImage(logo);
    } catch (Exception e) {
      System.err.println("Error loading logo: " + e.getMessage());
    }

    // Setting the size and position of the JFrame
    frame.setBounds(10, 10, 910, 750);

    // Setting the background color of the JFrame
    frame.setBackground(Color.DARK_GRAY);

    // Setting whether the JFrame is resizable or not
    frame.setResizable(false);

    // Making the JFrame visible
    frame.setVisible(true);

    // Setting the default close operation for the JFrame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Adding the Gameplay component to the JFrame
    frame.add(gamePlay);

    
  }
}
