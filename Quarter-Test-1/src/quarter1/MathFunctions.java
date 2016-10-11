package quarter1;

/**
 * Anything that has to do with math is done in here.
 * @author Bennett DenBleyker
 * @author Skyler Cameron
 */

public class MathFunctions {
    /**
     * Gets the area of a circle.
     * @param radiusEntry The radius to turn into an area
     * @return The area calculated from the radius
     */
    public static double areaOfCircle(int radiusEntry) { // areaOfCircle takes an integer as input
        return (radiusEntry * radiusEntry) * Math.PI; // Square radius then multiply by pi and return it
    }
    /**
     * Retrieves the root of the number then adds three.
     * @param num The number to get the square root of then add three
     * @return three plus the square root of num
     */
    public static double SquareRootAndAddThree(int num) {
        return Math.sqrt((double) num) + 3; // return the inputted number's square root and add three
    }
}