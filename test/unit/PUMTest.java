public class PUMTest {
    public static void main (String[] args) {
        PUMTest test = new PUMTest();
    }
    
    private ABMInput input;
    private ABMSystem system;
    
    public PUMTest () {
        this.input = new ABMInput();
        this.system = new ABMSystem(this.input);
        this.setup();
        this.testPositivePUM();
        this.testNegativePUM();
        this.test3PUM();
    }
    
    private void setup () {
        this.input.LCM = new ABMInput.Connector[][] {
            { ABMInput.Connector.NOTUSED, ABMInput.Connector.ORR, ABMInput.Connector.ORR, ABMInput.Connector.ORR, ABMInput.Connector.ORR, ABMInput.Connector.ORR, ABMInput.Connector.ORR, ABMInput.Connector.ORR, ABMInput.Connector.ORR, ABMInput.Connector.ORR, ABMInput.Connector.ORR, ABMInput.Connector.ORR, ABMInput.Connector.ORR, ABMInput.Connector.ORR, ABMInput.Connector.ORR },
            { ABMInput.Connector.ORR, ABMInput.Connector.NOTUSED, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD },
            { ABMInput.Connector.ORR, ABMInput.Connector.ANDD, ABMInput.Connector.NOTUSED, ABMInput.Connector.ORR, ABMInput.Connector.ORR, ABMInput.Connector.ORR, ABMInput.Connector.ORR, ABMInput.Connector.ORR, ABMInput.Connector.ORR, ABMInput.Connector.ORR, ABMInput.Connector.ORR, ABMInput.Connector.ORR, ABMInput.Connector.ORR, ABMInput.Connector.ORR, ABMInput.Connector.ORR },
            { ABMInput.Connector.ORR, ABMInput.Connector.ANDD, ABMInput.Connector.ORR, ABMInput.Connector.NOTUSED, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD },
            { ABMInput.Connector.ORR, ABMInput.Connector.ANDD, ABMInput.Connector.ORR, ABMInput.Connector.ANDD, ABMInput.Connector.NOTUSED, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD },
            { ABMInput.Connector.ORR, ABMInput.Connector.ANDD, ABMInput.Connector.ORR, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.NOTUSED, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD },
            { ABMInput.Connector.ORR, ABMInput.Connector.ANDD, ABMInput.Connector.ORR, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.NOTUSED, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD },
            { ABMInput.Connector.ORR, ABMInput.Connector.ANDD, ABMInput.Connector.ORR, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.NOTUSED, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD },
            { ABMInput.Connector.ORR, ABMInput.Connector.ANDD, ABMInput.Connector.ORR, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.NOTUSED, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD },
            { ABMInput.Connector.ORR, ABMInput.Connector.ANDD, ABMInput.Connector.ORR, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.NOTUSED, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD },
            { ABMInput.Connector.ORR, ABMInput.Connector.ANDD, ABMInput.Connector.ORR, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.NOTUSED, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD },
            { ABMInput.Connector.ORR, ABMInput.Connector.ANDD, ABMInput.Connector.ORR, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.NOTUSED, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD },
            { ABMInput.Connector.ORR, ABMInput.Connector.ANDD, ABMInput.Connector.ORR, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.NOTUSED, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD },
            { ABMInput.Connector.ORR, ABMInput.Connector.ANDD, ABMInput.Connector.ORR, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.NOTUSED, ABMInput.Connector.ANDD },
            { ABMInput.Connector.ORR, ABMInput.Connector.ANDD, ABMInput.Connector.ORR, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.ANDD, ABMInput.Connector.NOTUSED }
        };
    }
    
    private void testPositivePUM () {
        // contract: given LCM and CMV, PUM should be computed correctly. In this particular test, all the entries of PUM should be == true.
        this.system.CMV = new boolean[] {  false, true, true, true, true,
            true, true, true, true, true,
            true, true, true, true, true };
        System.out.print("Testing positive PUM-cases...");
        this.system.computePUM(this.input);
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                assert true == this.system.PUM[i][j] : String.format(
                                                                     "Failed PUM[%d,%d]! Expected true but got %b", i, j,  this.system.PUM[i][j]);
            }
        }
        System.out.println("OK!");
    }
    
    private void testNegativePUM () {
        // contract: given LCM and CMV, PUM should be computed correctly. In this particular test, PUM[0][2] should be == false.
        this.system.CMV = new boolean[] {  false, true, false, true, true,
            true, true, true, true, true,
            true, true, true, true, true };
        System.out.print("Testing negative PUM-case...");
        // Because LCM[0][2] is set to ORR, but CMV[0] and CMV[2] is false, it should result in false
        this.system.computePUM(this.input);
        assert false == this.system.PUM[0][2] : String.format(
                                                              "Failed! Expected false but got PUB[0][2] = %b", this.system.PUM[0][2]);
        System.out.println("OK!");
    }
    
    private void test3PUM () {
        // contract: given LCM and CMV, PUM should be computed correctly. In this particular test, all the entries of PUM should be == false, except the ones on the main diagonal.
        this.system.CMV = new boolean[] {  false, false, false, false, false,
            false, false, false, false, false,
            false, false, false, false, false };
        System.out.print("Testing positive PUM-cases...");
        this.system.computePUM(this.input);
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                if (i != j) {
                    assert false == this.system.PUM[i][j] : String.format(
                                                                         "Failed PUM[%d,%d]! Expected false but got %b", i, j,  this.system.PUM[i][j]);
                }
            }
        }
        System.out.println("OK!");
    }
}
