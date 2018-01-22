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
    public boolean checkLIC0 () {
        // holds = return result
        boolean holds = true;
        
        // body-start
        
        // -- add here -- Use input.NUMPOINTS, input.length1, etc. 
        
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
    /** check if the LIC2 holds
     * @return true if the LIC holds, false otherwise
     */
    public boolean checkLIC2 () {
        // holds = return result
        boolean holds = true;
        
        // body-start
        
        // -- add here -- Use input.NUMPOINTS, input.length1, etc.
        
        // body-end
        
        return holds;
    }
    /** check if the LIC3 holds
     * @return true if the LIC holds, false otherwise
     */
    public boolean checkLIC3 () {
        // holds = return result
        boolean holds = true;
        
        // body-start
        
        // -- add here -- Use input.NUMPOINTS, input.length1, etc.
        
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
    public boolean checkLIC11 () {
        // holds = return result
        boolean holds = true;
        
        // body-start
        
        // -- add here -- Use input.NUMPOINTS, input.length1, etc.
        
        // body-end
        
        return holds;
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
