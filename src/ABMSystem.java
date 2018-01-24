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
    public boolean checkLIC1 (ABMInput input) {
        // body-start
        Point p1;
        Point p2;
        Point p3;
        int i = 0;
        int end = 3;
        while (end <= input.NUMPOINTS) {
            p1 = input.POINTS[i];
            p2 = input.POINTS[i + 1];
            p3 = input.POINTS[i + 2];
            
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
    public boolean checkLIC4 (ABMInput input) {
        int qpts = input.PARAMETERS.getQPoints();
        int quads = input.PARAMETERS.getQuads();
 
        for (int i = 0; i < input.NUMPOINTS - qpts + 1; i++) {
            boolean[] qs = new boolean[4];
            int numQuads = 0;
 
            for (int j = 0; j < qpts; j++) {
                int q = input.POINTS[i + j].quadrant();
                qs[q-1] = true;
            }
 
            for (int j = 0; j < 4; j++) {
                if (qs[j]) numQuads++;
            }
            if (numQuads > quads) return true;
        }
        return false;
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
        if (input.NUMPOINTS < 5) return false;
 
        int apts = input.PARAMETERS.getAPoints();
        int bpts = input.PARAMETERS.getBPoints();
        double radius1 = input.PARAMETERS.getRadius1();
        double radius2 = input.PARAMETERS.getRadius2();
        boolean btR1 = false, stR2 = false;
       
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
                if (max > 2 * radius1) btR1 = true;
                if (max < 2 * radius2) stR2 = true;
            } else {
                // Find the smallest circle that fits all three points
                double minRadius = (a*b*c) /
                    Math.sqrt((a+b+c)*(b+c-a)*(c+a-b)*(a+b-c));
 
                if (minRadius > radius1) btR1 = true;
                if (minRadius < radius2) stR2 = true;
            }
            if (btR1 && stR2) return true;
            i++;
            end++;
        }
 
        // Both requirements were not filled
        return false;
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
