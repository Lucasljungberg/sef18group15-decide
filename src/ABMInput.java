import java.util.Scanner;
import java.util.Arrays;

public class ABMInput {

    /**
     * Number of observed data-points
     */
    public int NUMPOINTS;

    /**
     * The observed data-points
     */
    public Point[] POINTS;

    /** 
     * Holds parameters for the LIC calculations
     */
    public LICParameters PARAMETERS;

    /**
     * Logical connector signals to be used for the LCM (Logical Connector Matrix).
     * toString methods exists for debugging purposes.
     */
    public static enum Connector {
        NOTUSED { public String toString () { return "NOTUSED"; }},
        ANDD { public String toString () { return "ANDD" ; }},
        ORR { public String toString () { return "ORR"; }}
    }

    /** 
     * Logical Connector Matrix
     * Used in conjunction with the CMV to construct the 
     * PUM (Preliminary Unlocking Matrix). The entries in the LCM represent
     * the logical connectors to be used between pairs of LICs to determine the
     * corresponding entry in the PUM.
     */
    public Connector[][] LCM;

    /**
     * Preliminary Unlocking Vector
     * Indicates which of the LICs should be considered for the decision.
     */
    public boolean[] PUV;

    public int getNumpoints () {
        return this.NUMPOINTS;
    }

    public Point[] getPoints () {
        return this.POINTS;
    }

    public LICParameters getLICParameters () {
        return this.PARAMETERS;
    }

    public Connector[][] getLCM () {
        return this.LCM;
    }

    /**
     * Returns a string representation of the object
     * @return a string representing the object
     */
    public String toString () {
        StringBuilder sb = new StringBuilder();
        sb.append("Numpoints: ").append(this.NUMPOINTS).append('\n');
        sb.append("Points: ").append(Arrays.toString(this.POINTS)).append('\n');

        // Creates a stream of LCM, creates a list with string representations for each row of LCM
        // and prints that as a string.
        sb.append("LCM: ").append(Arrays.toString(Arrays.stream(this.LCM).map(c -> Arrays.toString(c)).toArray())).append('\n');
        sb.append("PUV: ").append(Arrays.toString(this.PUV));

        return sb.toString();
    }

    /**
     * Fetches data from input
     * @param io - initialized  
     */
    public void fetchInput (Scanner io) {
        this.NUMPOINTS = io.nextInt();
        this.POINTS = new Point[this.NUMPOINTS];
        for (int i = 0; i < this.NUMPOINTS; i++) {
            this.POINTS[i] = new Point(io.nextDouble(), io.nextDouble());
        }

        // We need to fetch each individual LIC parameters
        double length1 = io.nextDouble();
        double radius1 = io.nextDouble();
        double epsilon = io.nextDouble();
        double area1 = io.nextDouble();
        int qPoints = io.nextInt();
        int quads = io.nextInt();
        double dist = io.nextDouble();
        int nPoints = io.nextInt();
        int kPoints = io.nextInt();
        int aPoints = io.nextInt();
        int bPoints = io.nextInt();
        int cPoints = io.nextInt();
        int dPoints = io.nextInt();
        int ePoints = io.nextInt();
        int fPoints = io.nextInt();
        int gPoints = io.nextInt();
        double length2 = io.nextDouble();
        double radius2 = io.nextDouble();
        double area2 = io.nextDouble();

        // Could be changed to using a Builder class
        this.PARAMETERS = new LICParameters(length1, radius1, epsilon, 
            area1, qPoints, quads, dist, nPoints, kPoints, aPoints, 
            bPoints, cPoints, dPoints, ePoints, fPoints, gPoints, 
            length2, radius2, area2);

        this.LCM = new Connector[15][15];
        for (int i = 0; i < 15; i++) {
            for (int j = i; j < 15; j++) {
                if (i == j) {
                    this.LCM[i][j] = Connector.NOTUSED;
                    continue;
                }
                String con = io.next();
                switch(con) {
                    case "ANDD": 
                        this.LCM[i][j] = Connector.ANDD;
                        this.LCM[j][i] = Connector.ANDD;
                        break;
                    case "ORR":
                        this.LCM[i][j] = Connector.ORR;
                        this.LCM[j][i] = Connector.ORR;
                        break;
                    case "NOTUSED":
                        this.LCM[i][j] = Connector.NOTUSED;
                        this.LCM[j][i] = Connector.NOTUSED;
                        break;
                }                
            }
        }

        this.PUV = new boolean[15];
        for (int i = 0; i < 15; i++) {
            this.PUV[i] = io.nextBoolean();
        }

    }
}
