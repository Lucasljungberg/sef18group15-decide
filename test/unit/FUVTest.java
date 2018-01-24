public class FUVTest {
    public static void main (String[] args) {
        FUVTest test = new FUVTest();
    }
    
    private ABMInput input;
    private ABMSystem system;
    
    public FUVTest () {
        this.input = new ABMInput();
        this.system = new ABMSystem(this.input);
        this.setup();
        this.testPositiveFUV();
        this.testNegativeFUV();
        this.test3FUV();
    }
    
    private void setup () {
        this.system.PUM = new boolean[][] { {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true}, {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true}, {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true}, {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true}, {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true}, {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true}, {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true}, {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true}, {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true}, {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true}, {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true}, {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true}, {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true}, {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true}, {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true} };
        
    };
    
    
    private void testPositiveFUV () {
        // contract: given PUM and PUV, FUV should be computed correctly. In this particular test, all the entries of FUV should be == true.
        this.input.PUV = new boolean[] {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};
        System.out.print("Testing positive FUV-cases...");
        this.system.computeFUV(this.input);
        for (int i = 0; i < 15; i++) {
            assert true == this.system.FUV[i]: String.format(
                                                                 "Failed FUV[%d]! Expected true but got %b", i, this.system.FUV[i]);
        }
        
        System.out.println("OK!");
    }

    private void testNegativeFUV () {
        // contract: given PUM and PUV, FUV should be computed correctly. In this particular test, FUV[0] should be == false.
        this.system.PUM = new boolean[][] { {false, true, true, true, true, true, true, true, true, true, true, true, true, true, true}, {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true}, {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true}, {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true}, {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true}, {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true}, {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true}, {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true}, {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true}, {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true}, {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true}, {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true}, {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true}, {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true}, {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true} };
        
        this.input.PUV = new boolean[] {true, false, false, false, false, false, false, false, false, false, false, false, false, false, false};
        
        System.out.print("Testing negative FUV-cases...");
        this.system.computeFUV(this.input);
        assert false == this.system.FUV[0]: String.format(
                                                         "Failed FUV[0]! Expected false but got %b", this.system.FUV[0]);
        
        System.out.println("OK!");
    }

    private void test3FUV () {
        // contract: given PUM and PUV, FUV should be computed correctly. In this particular test, all the entries of FUV should be == true..
        this.system.PUM = new boolean[][] { {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false}, {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false}, {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false}, {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false}, {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false}, {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false}, {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false}, {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false}, {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false}, {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false}, {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false}, {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false}, {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false}, {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false}, {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false} };
        
        this.input.PUV = new boolean[] {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};
        
        System.out.print("Testing other FUV-cases...");
        this.system.computeFUV(this.input);
        for (int i = 0; i < 15; i++) {
            assert true == this.system.FUV[i]: String.format(
                                                             "Failed FUV[%d]! Expected true but got %b", i, this.system.FUV[i]);
        }
        
        System.out.println("OK!");
    }
}
