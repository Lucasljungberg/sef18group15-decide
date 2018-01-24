public class DecideTest {
    public static void main (String[] args) {
        DecideTest test = new DecideTest();
        //test.test1();
    }
    
    private ABMInput input;
    private ABMSystem system;
    
    public DecideTest () {
        this.input = new ABMInput();
        this.system = new ABMSystem(this.input);
        // this.setup();
        this.test1();
        this.test2();
        this.test3();

    }
    
    private void test1 () {
        // set up for computePUM
        this.input.LCM = new ABMInput.Connector[][] {
            { ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD },
            { ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD },
            { ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD },
            { ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD },
            { ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD },
            { ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD },
            { ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD },
            { ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD },
            { ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD },
            { ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD },
            { ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD },
            { ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD },
            { ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD },
            { ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD },
            { ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD }
        };
        this.input.PUV = new boolean[] {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true};
        // setup for LIC
        int NUMPOINTS = 10;
        // double length1 = 10;
        Point[] POINTS = { new Point(1,9), new Point(8, 6), new Point(7, 3), new Point(1, 45), new Point(1, 18), new Point(21,45), new Point(3,8), new Point(6,7), new Point(99,4), new Point(3,8)};
        LICParameters PARAMETERS = new LICParameters(3, 3, 1, 2, 3, 1, 3, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 2);
        this.input.NUMPOINTS = NUMPOINTS;
        this.input.POINTS = POINTS;
        this.input.PARAMETERS = PARAMETERS;
        System.out.print("Testing decide...");
        assert false == this.system.decide(this.input): String.format(
                                                                      "Failed decide test1! Expected false but got %b", this.system.decide(this.input));
        System.out.println("OK!");
    }
    private void test2 () {
        // set up for computePUM
        this.input.LCM = new ABMInput.Connector[][] {
            { ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED },
            { ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED },
            { ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED },
            { ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED },
            { ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED },
            { ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED },
            { ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED },
            { ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED },
            { ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED },
            { ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED },
            { ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED },
            { ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED },
            { ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED },
            { ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED },
            { ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED }
        };
        // still setup for PUM
        //        this.system.CMV = new boolean[] {  false, true, false, true, true,
        //            true, true, true, true, true,
        //            true, true, true, true, true };
        // setup for FUV
        this.input.PUV = new boolean[] {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true};
        // setup for LIC
        int NUMPOINTS = 10;
        // double length1 = 10;
        Point[] POINTS = { new Point(1,9), new Point(8, 6), new Point(7, 3), new Point(1, 45), new Point(1, 18), new Point(21,45), new Point(3,8), new Point(6,7), new Point(99,4), new Point(3,8)};
        LICParameters PARAMETERS = new LICParameters(3, 3, 1, 2, 3, 1, 3, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 2);
        this.input.NUMPOINTS = NUMPOINTS;
        this.input.POINTS = POINTS;
        this.input.PARAMETERS = PARAMETERS;
        System.out.print("Testing decide...");
        assert true == this.system.decide(this.input): String.format(
                                                                     "Failed decide test2! Expected true but got %b", this.system.decide(this.input));
        System.out.println("OK!");
    }
    private void test3 () {
        // set up for computePUM
        this.input.LCM = new ABMInput.Connector[][] {
            { ABMInput.Connector.NOTUSED, ABMInput.Connector.ANDD, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED },
            { ABMInput.Connector.ANDD, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED },
            { ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED },
            { ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED },
            { ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED },
            { ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED },
            { ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED },
            { ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED },
            { ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED },
            { ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED },
            { ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED },
            { ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED },
            { ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED },
            { ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED },
            { ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED, ABMInput.Connector.NOTUSED }
        };
        // still setup for PUM
//        this.system.CMV = new boolean[] {  false, true, false, true, true,
//            true, true, true, true, true,
//            true, true, true, true, true };
        // setup for FUV
        this.input.PUV = new boolean[] {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true};
        // setup for LIC
        int NUMPOINTS = 10;
        // double length1 = 10;
        Point[] POINTS = { new Point(3,2), new Point(-1, -2.1), new Point(0, 0), new Point(3, 5), new Point(3, 0), new Point(0,0), new Point(3,0), new Point(0,0), new Point(0,0), new Point(0,0)};
        LICParameters PARAMETERS = new LICParameters(3, 10, 1, 2, 3, 1, 3, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 2);
        this.input.NUMPOINTS = NUMPOINTS;
        this.input.POINTS = POINTS;
        this.input.PARAMETERS = PARAMETERS;
        System.out.print("Testing decide...");
        assert true == this.system.decide(this.input): String.format(
                                                                   "Failed decide test3! Expected true but got %b", this.system.decide(this.input));
        System.out.println("OK!");
    }


}
        
        

