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

            // Check if point 1 or 3 coincides with point 2
            if ((length1 == 0) || (length2 == 0)) continue;

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
    public boolean checkLIC6 (ABMInput input) {
        ArrayList<Point> points = new ArrayList<Point>();
        for (int i = 0; i < input.NUMPOINTS; i++) {
            points.add(input.POINTS[i]);
        }
        Point endPoint1;
        Point endPoint2;
        // equation of a line connecting the 1st and the last point in a sequnce of N_PTS points: ax + by + c = 0
        double a;
        double b;
        double c;
        double distance;
        
        // holds = return result
        boolean holds = false;
        
        // body-start
        // N_PTS < 3
        if (input.PARAMETERS.getNPoints() < 3) {
            return false;
        }
        for (int i = 0; i < input.NUMPOINTS - input.PARAMETERS.getNPoints(); i++) {
            endPoint1 = points.get(i);
            endPoint2 = points.get(i + input.PARAMETERS.getNPoints() - 1);
            // if endPoint1 != endPoint2
            if (endPoint2.getY() != endPoint1.getY() || endPoint2.getX() != endPoint1.getX()) {
                // equation of a line connecting endPoint1 and endPoint2
                c = 1;
                a = (endPoint2.getY() - endPoint1.getY()) / (endPoint1.getY() * endPoint2.getX() - endPoint2.getY() * endPoint1.getX());
                b = (endPoint1.getX() - endPoint2.getX()) / (endPoint1.getY() * endPoint2.getX() - endPoint2.getY() * endPoint1.getX());
                // for each point in the sequence check if the distance to the line ax + by + c = 0 is greater than DIST
                for (int j = 0; j < input.PARAMETERS.getNPoints(); j++) {
                    distance = Math.abs(a * points.get(i + j).getX() + b * points.get(i + j).getY() + c) / Math.sqrt(a * a + b * b);
                    if (distance > input.PARAMETERS.getDist()) {
                        holds = true;
                    }
                }
            // endPoint1 == endPoint2
            } else {
                // for each point in the sequence check if the distance from it to the point endPoint1 is greater than DIST
                for (int j = 0; j < input.PARAMETERS.getNPoints(); j++) {
                    distance = endPoint1.distanceTo(points.get(i + j));
                    if (distance > input.PARAMETERS.getDist()) {
                        holds = true;
                    }
                }
            }
            
        }
        
        // body-end
        
        return holds;
    }

     /** check if the LIC7 holds
     * @return true if the LIC holds, false otherwise
     */
    public boolean checkLIC7 (ABMInput input) {
        if (input.NUMPOINTS < 3) return false;

        int kpts = input.PARAMETERS.getKPoints();
        
        Point p1;
        Point p2;

        int i = 0;
        int end = kpts + 2;
        while (end <= input.NUMPOINTS) {
            p1 = input.POINTS[i];
            p2 = input.POINTS[i + kpts + 1];

            double distance = p1.distanceTo(p2);

            if (distance > input.PARAMETERS.getLength1()) {
            	return true;
            }
            i++;
            end++;
        }
        // no pair of points far enough apart
        return false;  
    }


    /** 
     * check if the LIC8 holds
     * @return true if the LIC holds, false otherwise
     */
    public boolean checkLIC8 (ABMInput input) {
        if (input.NUMPOINTS < 5) return false;

        int apts = input.PARAMETERS.getAPoints();
        int bpts = input.PARAMETERS.getBPoints();
        
        // body-start
        Point p1;
        Point p2;
        Point p3;
        int i = 0;
        int end = apts + bpts + 3;
        while (end <= input.NUMPOINTS) {
            p1 = input.POINTS[i];
            p2 = input.POINTS[i + apts + 1];
            p3 = input.POINTS[i + apts + 1 + bpts + 1];

            // Find the length of all legs that form a triangle
            double a = p1.distanceTo(p2);
            double b = p1.distanceTo(p3);
            double c = p2.distanceTo(p3);

            double angle = Math.PI;
            double max = 0.0;

            // Find the longest leg. Check if angle of the other two legs are < 90 degrees
            if (a > b && a > c) {
                angle = Math.acos(
                    (Math.pow(b, 2) + Math.pow(c, 2) - Math.pow(a, 2)) / 
                    (2 * b * c)
                );
                max = a;
            } else if (b > a && b > c) {
                angle = Math.acos(
                    (Math.pow(a, 2) + Math.pow(c, 2) - Math.pow(b, 2)) / 
                    (2 * a * c)
                );
                max = b;
            } else if (c > a && c > b) {
                angle = Math.acos(
                    (Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 2)) / 
                    (2 * a * b)
                );
                max = c;
            }

            if (angle > Math.PI) {
                if (max > 2 * input.PARAMETERS.getRadius1()) return false;
            } else {
                // Find the smallest circle that fits all three points
                double minRadius = (a*b*c) / 
                    Math.sqrt((a+b+c)*(b+c-a)*(c+a-b)*(a+b-c));

                if (minRadius > input.PARAMETERS.getRadius1()) return true;
            }
            i++;
            end++;
        }

        // All points fit inside a circle
        return false;
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
    public boolean checkLIC10 (ABMInput input) {
    	if (input.NUMPOINTS < 5) return false;

        double area1 = input.PARAMETERS.getArea1();

        int epts = input.PARAMETERS.getEPoints();
        int fpts = input.PARAMETERS.getFPoints();
        
        Point p1;
        Point p2;
        Point p3;

		double side1;
        double side2;
        double side3;

        double area;

        // half perimeter.
        double p;

        // finding and checking relevant combinations of points
        int i = 0;
        int end = epts + fpts + 3;
        while (end <= input.NUMPOINTS) {
            p1 = input.POINTS[i];
            p2 = input.POINTS[i + epts + 1];
            p3 = input.POINTS[i + epts + 1 + fpts + 1];

            side1 = p1.distanceTo(p2);
	        side2 = p2.distanceTo(p3);
	        side3 = p3.distanceTo(p1);

	        // calculate area using Heron's formula
	        p = (side1 + side2 + side3) / 2;
            area = Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));

            if (area > area1) {
                return true;
            }

			i++;
            end++;
	    }
	    // No area big enough
	    return false;
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
    public boolean checkLIC12 (ABMInput input) {
        // condition is not met if NUMPOINTS < 3
        if (input.NUMPOINTS < 3) {
            return false;
        }
        // holds = return result
        boolean holds = false;
        boolean holds1 = false;
        boolean holds2 = false;
        
        // body-start
        ArrayList<Point> points = new ArrayList<Point>();
        for (int i = 0; i < input.NUMPOINTS; i++) {
            points.add(input.POINTS[i]);
        }
        double length1 = input.PARAMETERS.getLength1();
        double length2 = input.PARAMETERS.getLength2();
        int kpts = input.PARAMETERS.getKPoints();
        
        for (int i = 0; i < points.size() - kpts - 1; i++) {
            if (points.get(i).distanceTo(points.get(i+kpts+1)) > length1) {
                System.out.println("more than " + length1 + " apart");
                holds1 = true;
            }
            if (points.get(i).distanceTo(points.get(i+kpts+1)) < length2) {
                System.out.println("less than " + length2 + " apart");
                holds2 = true;
            }
        }
        // body-end
        if (holds1 == true && holds2 == true) {
            holds = true;
        }
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
    public boolean checkLIC14 (ABMInput input) {
        if (input.NUMPOINTS < 5) return false;
        double area1 = input.PARAMETERS.getArea1();
        double area2 = input.PARAMETERS.getArea2();
        boolean gtArea1 = false;
        boolean ltArea2 = false;
        int epts = input.PARAMETERS.getEPoints();
        int fpts = input.PARAMETERS.getFPoints();
        int i = 0;
        int end = epts + 1 + fpts + 1;
        Point p1, p2, p3;
        double side1, side2, side3, area, s;
        while (end < input.NUMPOINTS) {
            p1 = input.POINTS[i];
            p2 = input.POINTS[i + epts + 1];
            p3 = input.POINTS[i + epts + 1 + fpts + 1];

            // Get lengths of sides
            side1 = p1.distanceTo(p2);
            side2 = p1.distanceTo(p3);
            side3 = p2.distanceTo(p3);

            // Calculate semi-perimiter
            s = (side1 + side2 + side3) / 2;

            // Get area using Heron's Formula
            area = Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
            if (area > area1) gtArea1 = true;
            if (area < area2) ltArea2 = true;

            if (gtArea1 && ltArea2) return true;

            end++; i++;
        }
        return false;
    }


    /**
     * Computes the PUM based on the results of the CMV from the LIC-checks
     */
    private void computePUM (ABMInput input) {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                switch (input.LCM[i][j]) {
                    case ANDD:
                        this.PUM[i][j] = (this.CMV[i] && this.CMV[j]);
                        break;
                    case ORR:
                        this.PUM[i][j] = (this.CMV[i] || this.CMV[j]);
                        break;
                    case NOTUSED:
                        this.PUM[i][j] = true;
                        break;
                }
            }
        }
    }

    /**
     * Computes the FUV based on PUM and PUV 
     */
    private void computeFUV (ABMInput input) {
        for (int i = 0; i < 15; i++) {
            if (!input.PUV[i]) {
                this.FUV[i] = true;
            } else {
                for (int j = 0; j < 15; j++) {
                    if (!this.PUM[i][j]) break;
                }
            }

        }
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
        
        // Check the FUV. Return true afterwards iff no entries in the
        // FUV is false
        for (int i = 0; i < 15; i++) {
            if (!this.FUV[i]) {
                return false;
            }
        }
        return true;
    }
    
    
}
