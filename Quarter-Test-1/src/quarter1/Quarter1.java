/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *
 * @author Bennett DenBleyker
 * @author Skyler Cameron
 */
package quarter1;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * This is the main hub of flow of control. Everything that happens happens in
 * here.
 * @author Bennett DenBleyker
 * @author Skyler Cameron
 *  
 */

public class Quarter1 {
    public static List<Double> circleAreas = new ArrayList();
    public static List<Double> numList = new ArrayList();
    public static double numListSum;
    public static Object circleColor;
    public static int radiusEntry;
    public static double lastEntry;
    private static final JFrame frame = new JFrame();
    private static boolean statsGiven = false;
    private static final Scanner stdIn = new Scanner(System.in);

    public static void main(String[] args) { // Main method
        nonApStuff();
        apStuff();
    }
    /**
     * Runs anything that is not AP required.
     */
    public static void nonApStuff() {
        boolean cont = true; // Set boolean type continue to true
        System.out.print("Please enter a number: "); // Prompt for a number
        int input = stdIn.nextInt(); // Get the user's reply
        for (int i = 1; i<=input; i++) { // Count from the number 1 to the reply number
            System.out.println(i);
        }
        while(cont) { // While we should continue ...
            System.out.print("Please enter another number: "); //  Prompt for a number
            input = stdIn.nextInt(); // Get the user's reply
            if (input >= 0) { // If the reply is not negative
                lastEntry = MathFunctions.SquareRootAndAddThree(input); // Set input to a value returned by an external method
                if (lastEntry > 1000) { // If the output of the external method is greater than 1000
                    cont = false; // Do not continue
                    for (double a : numList) { // For each double in the list numList
                        numListSum += a; // Add its value to numListSum
                    }
                    System.out.println("The sum is: " + numListSum); // Print what the sum is
                } else { // Otherwise ...
                    numList.add(lastEntry); // Add the output to the list numList
                }
            }
        }
    }
    /**
     * Runs anything that is AP required.
     */
    public static void apStuff() {
        radiusCheck();
        colorInput();
        circleStats();
        circleDraw();
    }
    /**
     * Gets the radius that the user would like a the circle to be.
     */
    public static void radiusCheck() {
        Object radius = JOptionPane.showInputDialog(frame, "Please input a radius\nPress 0 or Cancel to exit", null, JOptionPane.QUESTION_MESSAGE); // Asks to input radius in a pop-up
        radiusEntry = Integer.parseInt(radius.toString()); // Turn the input into a string
        if (radiusEntry >= 0) { // If radius is not negative
            circleAreas.add(MathFunctions.areaOfCircle(radiusEntry)); // calculate areaOfCircle via MathFunctions then print...
        } else { // If radiusEntry is less than 0 ...
            JOptionPane.showMessageDialog(null, "Radius is negative", "Error", JOptionPane.ERROR_MESSAGE); // Tell the user why the input was invalid
            radiusCheck(); // Ask again
        }
        if (circleAreas.get(0).equals(0.0)) { // If user hits cancel ...
            JOptionPane.showMessageDialog(null, "User entered 0 or pressed Cancel to exit", "Error", JOptionPane.ERROR_MESSAGE); // State why the program ended
            System.exit(0); // Exit the program
        }
    }
    /**
     * Gets the color that the user would like the circle to be.
     */
    public static void colorInput() {
        Object[] colors = {"Red", "Green", "Blue"}; // Set the text of the buttons
        circleColor = JOptionPane.showOptionDialog(frame, "What color should the circle be?", null, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, colors, colors[1]); // Ask for colors with prespecified inputs
        if (circleColor.equals(0)) {circleColor = "Red";} // If the left button is pressed, it is red
        if (circleColor.equals(1)) {circleColor = "Green";} // If the middle button is pressed, it is green
        if (circleColor.equals(2)) {circleColor = "Blue";} // If the right button is pressed, it is blue
        if (circleColor.equals(-1)) {colorInput();} // If the dialog is closed, reopen it
    }
    /**
     * Tells the user the color and surface area of the circle.
     */
    public static void circleStats() {
        if(!statsGiven) { // If this pop-up hasn't appeared before ...
            JOptionPane.showMessageDialog(null, "CIRCLE:\n  Color: "+circleColor+"\n  Area : "+circleAreas.get(0), null, JOptionPane.INFORMATION_MESSAGE); // Give circle statistics in a pop-up
            statsGiven = true; // Make it so that this pop-up won't appear again
        }
    }
    /**
     * Draws the circle with the parameters given.
     */
    public static void circleDraw() {
        frame.getContentPane().add(new CircleMaker(), BorderLayout.CENTER); // Creates the drawing
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Sets how you can close the drawing
        frame.setSize(1500, 1500); // Sets the drawing's canvas size
        frame.setVisible(true); // Makes the drawing visible
    }
}