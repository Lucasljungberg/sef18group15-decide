import java.lang.Math;
import java.util.ArrayList;

public class ABMSystem {

    public static void main(String[] args) {
        ABMInputHandler inputHandler = new ABMInputHandler();
        ABMInput input = inputHandler.fetch();
        ABMSystem system = new ABMSystem(input);
    }

    /**
     * Conditions Met Vector
     * Each entry represents a LIC (Launch Interceptor Condition).
     * If index i is true, that means the conditions for LIC i has been met
     */
    private boolean[] CMV = new boolean[15];

    /**
     * Preliminary Unlocking Matrix
     * This matrix's entries should depend on the entries of the LCM and CMV.
     * The entries should be entered as follows:
     *     If LCM[i][j] == ORR then
     *         PUM[i][j] = true iff (CMV[i] OR CMV[j])
     *     Else If LCM[i][j] == ANDD then
     *         PUM[i][j] = true iff (CMV[i] AND CMV[j])
     *     Else If LCM[i][j] == NOTUSED then
     *         PUM[i][j] = true
     */
    private boolean[][] PUM = new boolean[15][15];

    /**
     * Final Unlocking Vector
     */
    private boolean[] FUV = new boolean[15];

    /**
     * Holds the input to the ABMSystem
     */
    private ABMInput input;

    
    public ABMSystem (ABMInput input) {
        this.input = input;
    }

    
    /** check if the LIC0 holds
     * @return true if the LIC holds, false otherwise
     */
    public boolean checkLIC0 (ABMInput input) {
        // holds = return result
        boolean holds = false;
        
        // body-start
        ArrayList<Point> points = new ArrayList<Point>();
        for (int i = 0; i < input.NUMPOINTS; i++) {
            points.add(input.POINTS[i]);
        }
        double length1 = input.PARAMETERS.getLength1();
        for (int i = 0; i < points.size() - 1; i++) {
            if (points.get(i).distanceTo(points.get(i+1)) > length1) {
                holds = true;
            }
        }
        // body-end
        
        return holds;
    }
    /** check if the LIC1 holds
     * @return true if the LIC holds, false otherwise
     */
    public boolean checkLIC1 () {
        // holds = return result
        boolean holds = true;
        
        // body-start
        
        // -- add here -- Use input.NUMPOINTS, input.length1, etc.
        
        // body-end
        
        return holds;
    }

    /** 
     * check if the LIC2 holds
     * @return true if the LIC holds, false otherwise
     */
    public boolean checkLIC2 (ABMInput input) {
        ArrayList<Point> points = new ArrayList<Point>();
        for (int i = 0; i < input.NUMPOINTS; i++) {
            points.add(input.POINTS[i]);
        }

        // Define origin 
        Point orig = new Point(0,0);

        // Fetch the two starting points so that the loop starts by fetching the third.
        // Point p2 is always the vertex.
        Point p1 = null;
        Point p2 = points.remove(0);
        Point p3 = points.remove(0);

        for (Point p: points) {
            // Prepare next iteration by moving the points one step forward in the input
            p1 = p2;
            p2 = p3;
            p3 = p;

            // Lengths of the legs of the "triangle" formed by the three points
            double length1 = p2.distanceTo(p1);
            double length2 = p2.distanceTo(p3);
            double length3 = p1.distanceTo(p3);

            // Using the Law of Cosines with p2 as c
            double angle = Math.acos(
                    (Math.pow(length1, 2) + Math.pow(length2, 2) - Math.pow(length3, 2)) / 
                    (2 * length1 * length2)
                );
            
            if (angle < (Math.PI - input.PARAMETERS.getEpsilon()) || 
                angle > (Math.PI + input.PARAMETERS.getEpsilon())) return true;

        }
    
        return false;
    }
    /** check if the LIC3 holds
     * @return true if the LIC holds, false otherwise
     */
    public boolean checkLIC3 (ABMInput input) {
        ArrayList<Point> points = new ArrayList<Point>();
        for (int i = 0; i < input.NUMPOINTS; i++) {
            points.add(input.POINTS[i]);
        }
        // holds = return result
        boolean holds = false;
        
        // body-start
        double area;
        // half perimeter.
        double p;
        double side1;
        double side2;
        double side3;
        
        double area1 = input.PARAMETERS.getArea1();
        
        for (int i = 0; i < points.size() - 2; i++) {
            side1 = points.get(i).distanceTo(points.get(i+1));
            side2 = points.get(i+1).distanceTo(points.get(i+2));
            side3 = points.get(i+2).distanceTo(points.get(i));
            p = (side1 + side2 + side3) / 2;
            area = Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
            if (area > area1) {
                holds = true;
            }
            
        }
        
        // body-end
        
        return holds;
    }
    /** check if the LIC4 holds
     * @return true if the LIC holds, false otherwise
     */
    public boolean checkLIC4 () {
        // holds = return result
        boolean holds = true;
        
        // body-start
        
        // -- add here -- Use input.NUMPOINTS, input.length1, etc.
        
        // body-end
        
        return holds;
    }
    /** check if the LIC5 holds
     * @return true if the LIC holds, false otherwise
     */
    public boolean checkLIC5 (ABMInput input) {
        // body-start
        Point p1 = null;
        Point p2 = null;

        // -- add here -- Use input.NUMPOINTS, input.length1, etc.
        for (int i = 1; i < input.NUMPOINTS; i++) {
            p1 = input.POINTS[i-1];
            p2 = input.POINTS[i];

            if (p2.getX() - p1.getX() < 0) return true;
        }
        
        // body-end
        
        return false;
    }
    /** check if the LIC6 holds
     * @return true if the LIC holds, false otherwise
     */
    public boolean checkLIC6 () {
        // holds = return result
        boolean holds = true;
        
        // body-start
        
        // -- add here -- Use input.NUMPOINTS, input.length1, etc.
        
        // body-end
        
        return holds;
    }
    /** check if the LIC7 holds
     * @return true if the LIC holds, false otherwise
     */
    public boolean checkLIC7 () {
        // holds = return result
        boolean holds = true;
        
        // body-start
        
        // -- add here -- Use input.NUMPOINTS, input.length1, etc.
        
        // body-end
        
        return holds;
    }
    /** check if the LIC8 holds
     * @return true if the LIC holds, false otherwise
     */
    public boolean checkLIC8 () {
        // holds = return result
        boolean holds = true;
        
        // body-start
        
        // -- add here -- Use input.NUMPOINTS, input.length1, etc.
        
        // body-end
        
        return holds;
    }
    /** check if the LIC9 holds
     * @return true if the LIC holds, false otherwise
     */
    public boolean checkLIC9 () {
        // holds = return result
        boolean holds = true;
        
        // body-start
        
        // -- add here -- Use input.NUMPOINTS, input.length1, etc.
        
        // body-end
        
        return holds;
    }
    /** check if the LIC10 holds
     * @return true if the LIC holds, false otherwise
     */
    public boolean checkLIC10 () {
        // holds = return result
        boolean holds = true;
        
        // body-start
        
        // -- add here -- Use input.NUMPOINTS, input.length1, etc.
        
        // body-end
        
        return holds;
    }
    /** check if the LIC11 holds
     * @return true if the LIC holds, false otherwise
     */
    public boolean checkLIC11 (ABMInput input) {
        if (input.NUMPOINTS < 3) return false;
        int gpts = input.PARAMETERS.getGPoints();

        int i = 0, end = gpts + 1;
        while (end < input.NUMPOINTS) {
            if (input.POINTS[i + gpts + 1].getX() - input.POINTS[i].getX() < 0) {
                return true;
            }
            i++;
            end++;
        }
        return false;
    }
    /** check if the LIC12 holds
     * @return true if the LIC holds, false otherwise
     */
    public boolean checkLIC12 () {
        // holds = return result
        boolean holds = true;
        
        // body-start
        
        // -- add here -- Use input.NUMPOINTS, input.length1, etc.
        
        // body-end
        
        return holds;
    }
    /** check if the LIC13 holds
     * @return true if the LIC holds, false otherwise
     */
    public boolean checkLIC13 () {
        // holds = return result
        boolean holds = true;
        
        // body-start
        
        // -- add here -- Use input.NUMPOINTS, input.length1, etc.
        
        // body-end
        
        return holds;
    }
    /** check if the LIC14 holds
     * @return true if the LIC holds, false otherwise
     */
    public boolean checkLIC14 () {
        // holds = return result
        boolean holds = true;
        
        // body-start
        
        // -- add here -- Use input.NUMPOINTS, input.length1, etc.
        
        // body-end
        
        return holds;
    }
    
    
    /**
     * Function to be implemented
     * 
     * Decides whether or not to fire an Anti-Ballistic missile based on
     * observational data points.
     * @return  whether or not the ABM should be fired. Returns true to fire and false 
     *                  to not fire.
     */
    
    private boolean decide (ABMInput input) {
        return false;
    }
    
    
}
