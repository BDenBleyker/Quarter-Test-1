package quarter1;

import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.text.html.StyleSheet;

/**
 * Draws circles
 * @author Bennett DenBleyker
 * @author Skyler Cameron
 */

public class CircleMaker extends JPanel { // CircleMaker is a JPanel
    private final StyleSheet s = new StyleSheet(); // Creates a StyleSheet named s (A StyleSheet converts HTML into visual characteristics)
    @Override // Makes it so that any time someone calls JPanel.paintComponent(g), it runs here instead
    public void paintComponent(Graphics g) { // Takes a Graphics object as input
    super.paintComponent(g); // Runs the paintComponent provided by JPanel directly
    g.setColor(s.stringToColor(Quarter1.circleColor.toString())); // Sets the color
    g.drawOval(0, 0, Quarter1.radiusEntry, Quarter1.radiusEntry); // Draws the circle
    g.fillOval(0, 0, Quarter1.radiusEntry, Quarter1.radiusEntry); // Fills the circle in
    }
}