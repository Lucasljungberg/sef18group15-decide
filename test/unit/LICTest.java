import java.util.Scanner;
import java.util.Arrays;

public class LICTest {
    public void testLIC0() {
        // contract: correctly check if the LIC1 is met.
        
        // initialization. next four variables should be custom initialized
        int NUMPOINTS = 0;
        Point[] POINTS;
        LICParameters PARAMETERS;
        boolean met = false;
        
        // body
        
        // assertion.
        assert true == met : "Failed test for LIC 0. Got " + met + " but expected true";
    }
    
    public void testLIC1() {
        // contract: correctly check if the LIC1 is met.
        
        // initialization. next four variables should be custom initialized
        int NUMPOINTS = 0;
        Point[] POINTS;
        LICParameters PARAMETERS;
        boolean met = false;
        
        // body
        
        // assertion.
        assert true == met : "Failed test for LIC 1. Got " + met + " but expected true";
    }
    
    public void testLIC2() {
        // contract: correctly check if the LIC1 is met.
        // The test should return a true, as the angle between the lines (POINTS[1], POINTS[2]) and
        // (POINTS[2], POINTS[3]) is somewhere around 0.001
        
        // initialization. next four variables should be custom initialized
        int NUMPOINTS = 3;
        double epsilon = 1;
        Point[] POINTS = { new Point(1,2), new Point(-1, -2.1), new Point(0, 0), new Point(-1, -2)};
        LICParameters PARAMETERS = new LICParameters(3, 3, epsilon, 2, 3, 1, 3, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 2);
        boolean met = false;
        ABMInput input = new ABMInput();
        input.NUMPOINTS = NUMPOINTS;
        input.POINTS = POINTS;
        input.PARAMETERS = PARAMETERS;
        ABMSystem system = new ABMSystem(input);
        
        System.out.print("Testing LIC2... ");
        // body
        met = system.checkLIC2(input);
        
        // assertion.
        assert true == met : "Failed test for LIC 2. Got " + met + " but expected true";
        System.out.println("OK!");
    }
    public void testLIC3() {
        // contract: correctly check if the LIC1 is met.
        // The test should return a true if there is a triangle formed by some three consecutive points with an area > area1
        
        // body
        int NUMPOINTS = 3;
        double area1 = 1;
        Point[] POINTS = { new Point(1,2), new Point(-1, -2.1), new Point(0, 0), new Point(-1, -2)};
        LICParameters PARAMETERS = new LICParameters(3, 3, 1, area1, 3, 1, 3, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 2);
        boolean met = true;
        ABMInput input = new ABMInput();
        input.NUMPOINTS = NUMPOINTS;
        input.POINTS = POINTS;
        input.PARAMETERS = PARAMETERS;
        ABMSystem system = new ABMSystem(input);
        
        System.out.print("Testing LIC3... ");
        
        met = system.checkLIC3(input);
        
        
        // assertion.
        assert false == met : "Failed test for LIC 3. Got " + met + " but expected false";
        System.out.println("OK!");
    }
    
    public void testLIC4() {
        // contract: correctly check if the LIC1 is met.
        
        // initialization. next four variables should be custom initialized
        int NUMPOINTS = 0;
        Point[] POINTS;
        LICParameters PARAMETERS;
        boolean met = false;
        
        // body
        
        // assertion.
        assert true == met : "Failed test for LIC 4. Got " + met + " but expected true";
    }
    
    public void testLIC5() {
        // contract: correctly check if the LIC1 is met.
        
        // initialization. next four variables should be custom initialized
        int NUMPOINTS = 0;
        Point[] POINTS;
        LICParameters PARAMETERS;
        boolean met = false;
        
        // body
        
        // assertion.
        assert true == met : "Failed test for LIC 5. Got " + met + " but expected true";
    }
    public void testLIC6() {
        // contract: correctly check if the LIC1 is met.
        
        // initialization. next four variables should be custom initialized
        int NUMPOINTS = 0;
        Point[] POINTS;
        LICParameters PARAMETERS;
        boolean met = false;
        
        // body
        
        // assertion.
        assert true == met : "Failed test for LIC 6. Got " + met + " but expected true";
    }
    
    public void testLIC7() {
        // contract: correctly check if the LIC1 is met.
        
        // initialization. next four variables should be custom initialized
        int NUMPOINTS = 0;
        Point[] POINTS;
        LICParameters PARAMETERS;
        boolean met = false;
        
        // body
        
        // assertion.
        assert true == met : "Failed test for LIC 7. Got " + met + " but expected true";
    }
    
    public void testLIC8() {
        // contract: correctly check if the LIC1 is met.
        
        // initialization. next four variables should be custom initialized
        int NUMPOINTS = 0;
        Point[] POINTS;
        LICParameters PARAMETERS;
        boolean met = false;
        
        // body
        
        // assertion.
        assert true == met : "Failed test for LIC 8. Got " + met + " but expected true";
    }
    public void testLIC9() {
        // contract: correctly check if the LIC1 is met.
        
        // initialization. next four variables should be custom initialized
        int NUMPOINTS = 0;
        Point[] POINTS;
        LICParameters PARAMETERS;
        boolean met = false;
        
        // body
        
        // assertion.
        assert true == met : "Failed test for LIC 9. Got " + met + " but expected true";
    }
    
    public void testLIC10() {
        // contract: correctly check if the LIC1 is met.
        
        // initialization. next four variables should be custom initialized
        int NUMPOINTS = 0;
        Point[] POINTS;
        LICParameters PARAMETERS;
        boolean met = false;
        
        // body
        
        // assertion.
        assert true == met : "Failed test for LIC 10. Got " + met + " but expected true";
    }
    
    public void testLIC11() {
        // contract: correctly check if the LIC1 is met.
        
        // initialization. next four variables should be custom initialized
        int NUMPOINTS = 0;
        Point[] POINTS;
        LICParameters PARAMETERS;
        boolean met = false;
        
        // body
        
        // assertion.
        assert true == met : "Failed test for LIC 11. Got " + met + " but expected true";
    }
    public void testLIC12() {
        // contract: correctly check if the LIC1 is met.
        
        // initialization. next four variables should be custom initialized
        int NUMPOINTS = 0;
        Point[] POINTS;
        LICParameters PARAMETERS;
        boolean met = false;
        
        // body
        
        // assertion.
        assert true == met : "Failed test for LIC 12. Got " + met + " but expected true";
    }
    
    public void testLIC13() {
        // contract: correctly check if the LIC1 is met.
        
        // initialization. next four variables should be custom initialized
        int NUMPOINTS = 0;
        Point[] POINTS;
        LICParameters PARAMETERS;
        boolean met = false;
        
        // body
        
        // assertion.
        assert true == met : "Failed test for LIC 13. Got " + met + " but expected true";
    }
    
    public void testLIC14() {
        // contract: correctly check if the LIC1 is met.
        
        // initialization. next four variables should be custom initialized
        int NUMPOINTS = 0;
        Point[] POINTS;
        LICParameters PARAMETERS;
        boolean met = false;
        
        // body
        
        // assertion.
        assert true == met : "Failed test for LIC 14. Got " + met + " but expected true";
    }
}

