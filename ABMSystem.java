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
        System.out.println(input);
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
