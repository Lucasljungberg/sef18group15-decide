import java.util.Scanner;
import java.util.Arrays;

public class LICTest {
    public static void main(String[] args) {
        LICTest test = new LICTest();
        test.testLIC8();
    }
    public void testLIC0() {
        // contract: correctly check if the LIC0 is met.
        // the test should return false if no two consecutive points are farther than 10 apart
        
        // initialization. next four variables should be custom initialized
        int NUMPOINTS = 3;
        double length1 = 10;
        Point[] POINTS = { new Point(1,2), new Point(-1, -2.1), new Point(0, 0), new Point(-1, -2)};
        LICParameters PARAMETERS = new LICParameters(length1, 3, 2, 2, 3, 1, 3, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 2);
        boolean met = false;
        ABMInput input = new ABMInput();
        input.NUMPOINTS = NUMPOINTS;
        input.POINTS = POINTS;
        input.PARAMETERS = PARAMETERS;
        ABMSystem system = new ABMSystem(input);
        
        System.out.print("Testing LIC0... ");
        // body
        met = system.checkLIC0(input);
        
        // assertion.
        assert false == met : "Failed test for LIC 0. Got " + met + " but expected false";
        System.out.println("OK!");
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
        
        // initialization. next four variables should be custom initialized
        int NUMPOINTS = 0;
        Point[] POINTS;
        LICParameters PARAMETERS;
        boolean met = false;
        
        // body
        
        // assertion.
        assert true == met : "Failed test for LIC 3. Got " + met + " but expected true";
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
        
        // Checking case of the shorter legs forming < 90 degree angle and big enough circle
        int NUMPOINTS = 6;
        Point[] POINTS = { 
            new Point(0, 0), 
            new Point(0, 0), 
            new Point(2, 3), 
            new Point(0, 0), 
            new Point(0, 0), 
            new Point(4, 4)
        };
        int apts = 1, bpts = 2;
        double radius = 3;
        LICParameters PARAMETERS = new LICParameters(3, radius, 1, 2, 3, 1, 3, 2, 2, apts, bpts, 2, 2, 2, 2, 2, 3, 3, 2);
        ABMInput input = new ABMInput();
        input.NUMPOINTS = NUMPOINTS;
        input.POINTS = POINTS;
        input.PARAMETERS = PARAMETERS;
        ABMSystem system = new ABMSystem(input);
        boolean met = system.checkLIC8(input);

        System.out.print("Testing LIC8 (test 1)...");
        assert false == met : "Failed test for LIC 8. Got " + met + " but expected false";
        System.out.println("OK!");

        // Testing case when NUMPOINTS < 5
        input.NUMPOINTS = 4;
        input.POINTS = new Point[]{ 
            new Point(1, 1), 
            new Point(0, 0), 
            new Point(2, 3), 
            new Point(0, 0), 
        };
        apts = 1;
        bpts = 1;
        radius = 3;
        PARAMETERS = new LICParameters(3, radius, 1, 2, 3, 1, 3, 2, 2, apts, bpts, 2, 2, 2, 2, 2, 3, 3, 2);
        input.PARAMETERS = PARAMETERS;
        met = system.checkLIC8(input);
        System.out.print("Testing LIC8 (test 2)...");
        assert false == met : "Failed test for LIC 8. Got " + met + " but expected false";
        System.out.println("OK!");


        // Testing case when the angle of the smaller legs > 90 degrees
        input.NUMPOINTS = 6;
        input.POINTS = new Point[]{ 
            new Point(0, 0), 
            new Point(0, 0), 
            new Point(-1, 9), 
            new Point(0, 0), 
            new Point(0, 11)
        };
        apts = 1; 
        bpts = 1;
        radius = 8;
        PARAMETERS = new LICParameters(3, radius, 1, 2, 3, 1, 3, 2, 2, apts, bpts, 2, 2, 2, 2, 2, 3, 3, 2);
        input.PARAMETERS = PARAMETERS;
        met = system.checkLIC8(input);
        System.out.print("Testing LIC8 (test 3)...");
        assert false == met : "Failed test for LIC 8. Got " + met + " but expected false";
        System.out.println("OK!");

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
        // contract: correctly check if the LIC10 is met.
        
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

