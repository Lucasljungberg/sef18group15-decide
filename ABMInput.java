import java.util.Scanner;
import java.util.Arrays;

public class ABMInput {

    /**
     * Number of observed data-points
     */
    private int NUMPOINTS;

    /**
     * The observed data-points
     */
    private double[] POINTS;

    /** 
     * Holds parameters for the LIC calculations
     */
    private LICParameters PARAMETERS;

    /**
     * Logical connector signals to be used for the LCM (Logical Connector Matrix).
     * toString methods exists for debugging purposes.
     */
    public enum Connector {
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
    private Connector[][] LCM;

    /**
     * Preliminary Unlocking Vector
     * Indicates which of the LICs should be considered for the decision.
     */
    private boolean[] PUV;

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
        this.POINTS = new double[this.NUMPOINTS];
        for (int i = 0; i < this.NUMPOINTS; i++) {
            this.POINTS[i] = io.nextDouble();
        }

        // We need to fetch each individual LIC parameters
        this.PARAMETERS = new LICParameters();
        this.PARAMETERS.LENGTH1 = io.nextDouble();
        this.PARAMETERS.RADIUS1 = io.nextDouble();
        this.PARAMETERS.EPSILON = io.nextDouble();
        this.PARAMETERS.AREA1 = io.nextDouble();
        this.PARAMETERS.Q_POINTS = io.nextInt();
        this.PARAMETERS.QUADS = io.nextInt();
        this.PARAMETERS.DIST = io.nextDouble();
        this.PARAMETERS.N_POINTS = io.nextInt();
        this.PARAMETERS.K_POINTS = io.nextInt();
        this.PARAMETERS.A_POINTS = io.nextInt();
        this.PARAMETERS.B_POINTS = io.nextInt();
        this.PARAMETERS.C_POINTS = io.nextInt();
        this.PARAMETERS.D_POINTS = io.nextInt();
        this.PARAMETERS.E_POINTS = io.nextInt();
        this.PARAMETERS.F_POINTS = io.nextInt();
        this.PARAMETERS.G_POINTS = io.nextInt();
        this.PARAMETERS.LENGTH2 = io.nextDouble();
        this.PARAMETERS.RADIUS2 = io.nextDouble();
        this.PARAMETERS.AREA2 = io.nextDouble();

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
