import java.util.Scanner;
import java.util.Arrays;

public class LICTest {
    public static void main(String[] args) {
        LICTest test = new LICTest();
        test.testLIC0();
        test.testLIC1();
        test.testLIC2();
        test.testLIC3();
        test.testLIC4();
        test.testLIC5();
        test.testLIC6();
        test.testLIC7();
        test.testLIC8();
        test.testLIC9();
        test.testLIC10();
        test.testLIC11();
        test.testLIC12();
        test.testLIC13();
        test.testLIC14();
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
        
        // Checking case of the shorter legs forming <= 90 degree angle and big enough circle
        int NUMPOINTS = 3;
        Point[] POINTS = {
            new Point(0, 0),
            new Point(3, 5),
            new Point(6, 0),
        };
        double radius = 3;
        LICParameters PARAMETERS = new LICParameters(3, radius, 1, 2, 3, 1, 3, 2, 2, 1, 2, 2, 2, 2, 2, 2, 3, 3, 2);
        ABMInput input = new ABMInput();
        input.NUMPOINTS = NUMPOINTS;
        input.POINTS = POINTS;
        input.PARAMETERS = PARAMETERS;
        ABMSystem system = new ABMSystem(input);
        boolean met = system.checkLIC1(input);
        
        System.out.print("Testing LIC1 (test 1)...");
        assert true == met : "Failed test for LIC 1. Got " + met + " but expected true";
        System.out.println("OK!");
        
        
        // Testing case when the angle of the smaller legs > 90 degrees
        input.NUMPOINTS = 3;
        input.POINTS = new Point[]{
            new Point(0, 0),
            new Point(3, 2),
            new Point(6, 0),
        };
        radius = 4;
        PARAMETERS = new LICParameters(3, radius, 1, 2, 3, 1, 3, 2, 2, 1, 1, 2, 2, 2, 2, 2, 3, 3, 2);
        input.PARAMETERS = PARAMETERS;
        met = system.checkLIC1(input);
        System.out.print("Testing LIC1 (test 2)...");
        assert false == met : "Failed test for LIC 1. Got " + met + " but expected false";
        System.out.println("OK!");
        
    }
    
    public void testLIC2() {
        // contract: correctly check if the LIC2 is met.
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
        
        System.out.print("Testing LIC2 (test 1)... ");
        // body
        met = system.checkLIC2(input);
        
        // assertion.
        assert true == met : "Failed test for LIC 2. Got " + met + " but expected true";
        System.out.println("OK!");

        
        // Test that coinciding points are not considered. Because only 3
        // points are present, and p1 coinsides with p2, this should return false
        input.NUMPOINTS = 3;
        input.POINTS = new Point[] { new Point(1, 1), new Point(1, 1), new Point(-3, -2.5) };
        System.out.print("Testing LIC2 (test 2)...");
        met = system.checkLIC2(input);
        assert false == met : "Failed test for LIC 2. Got " + met + " but expected false";
        System.out.println("OK!");
        
        

    }
    public void testLIC3() {
        // contract: correctly check if the LIC3 is met.
        // The test should return a true if there is a triangle formed by some three consecutive points with an area > area1
        
        // body
        int NUMPOINTS = 4;
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
        // The test should return true if there are qpoints consecutive points that lie in more than quads quadrants.

        // test 1: smallest case
        int NUMPOINTS = 2;
        int qPoints = 2;
        int quads = 1;
        LICParameters PARAMETERS = new LICParameters(3, 3, 1, 2, qPoints, quads, 3, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 2);
        boolean met = true;
        ABMInput input = new ABMInput();
        input.NUMPOINTS = NUMPOINTS;
        input.POINTS = new Point[]{ new Point(1,2), new Point(-1, -2.1)};
        input.PARAMETERS = PARAMETERS;
        ABMSystem system = new ABMSystem(input);
        
        System.out.print("Testing LIC4... (test 1) ");
        
        met = system.checkLIC4(input);
        
        // assertion.
        assert true == met : "Failed test for LIC 4. Got " + met + " but expected true";
        System.out.println("OK!");

        // test 2: big case
        NUMPOINTS = 6;
        qPoints = 4;
        quads = 3;
        Point[] POINTS = { new Point(-1, 2), new Point(-1, -2.1), new Point(-1, 1), new Point(1, -2), new Point(1, 2.1), new Point(-1, -1)};
        PARAMETERS = new LICParameters(3, 3, 1, 2, qPoints, quads, 3, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 2);
        met = true;
        input = new ABMInput();
        input.NUMPOINTS = NUMPOINTS;
        input.POINTS = POINTS;
        input.PARAMETERS = PARAMETERS;
        system = new ABMSystem(input);
        
        System.out.print("Testing LIC4... (test 2) ");
        
        met = system.checkLIC4(input);
        
        // assertion.
        assert true == met : "Failed test for LIC 4. Got " + met + " but expected true";
        System.out.println("OK!");


        // test 3: false case
        NUMPOINTS = 4;
        qPoints = 4;
        quads = 3;
        PARAMETERS = new LICParameters(3, 3, 1, 2, qPoints, quads, 3, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 2);
        met = true;
        input = new ABMInput();
        input.NUMPOINTS = NUMPOINTS;
        input.POINTS = new Point[]{ new Point(-1,2), new Point(-1, -2.1), new Point(-1, -2), new Point(-1, -1)};
        input.PARAMETERS = PARAMETERS;
        system = new ABMSystem(input);
        
        System.out.print("Testing LIC4... (test 3) ");
        
        met = system.checkLIC4(input);
        
        // assertion.
        assert false == met : "Failed test for LIC 4. Got " + met + " but expected false";
        System.out.println("OK!");

        // test 4: false case
        NUMPOINTS = 4;
        qPoints = 4;
        quads = 3;
        PARAMETERS = new LICParameters(3, 3, 1, 2, qPoints, quads, 3, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 2);
        met = true;
        input = new ABMInput();
        input.NUMPOINTS = NUMPOINTS;
        input.POINTS = new Point[]{ new Point(-1,2), new Point(1, -2.1), new Point(-1, -2), new Point(-1, -1)};
        input.PARAMETERS = PARAMETERS;
        system = new ABMSystem(input);
        
        System.out.print("Testing LIC4... (test 4) ");
        
        met = system.checkLIC4(input);
        
        // assertion.
        assert false == met : "Failed test for LIC 4. Got " + met + " but expected false";
        System.out.println("OK!");
    }
    
    public void testLIC5() {
        // contract: correctly check if the LIC5 is met.
        // Point[2].x - Point[1].x = -1 < 0
        // The test should return true
        
        // initialization. next four variables should be custom initialized
        int NUMPOINTS = 4;
        Point[] POINTS = { new Point(0, 0), new Point(1, 2), new Point(-1, -2), new Point(3, 3) };
        LICParameters PARAMETERS;
        ABMInput input = new ABMInput();
        input.NUMPOINTS = NUMPOINTS;
        input.POINTS = POINTS;
        ABMSystem system = new ABMSystem(input);

        System.out.print("Testing LIC5 (test 1)...");
        boolean met = system.checkLIC5(input);
        
        // body
        
        // assertion.
        assert true == met : "Failed test for LIC 5. Got " + met + " but expected true";
        System.out.println("OK!");

        // The second test should fail, because each new data point has an x value greater
        // than the previous
        POINTS = new Point[]{ new Point(0, 0), new Point(1, 2), new Point(1, 3), new Point(3, 3) };
        input.POINTS = POINTS;

        System.out.print("Testing LIC5 (test 2)...");
        met = system.checkLIC5(input);

        assert false == met : "Failed test for LIC 5. Got " + met + " but expected false";
        System.out.println("OK!");
    }
    public void testLIC6() {
        // contract: correctly check if the LIC6 is met.

        // body
        int NUMPOINTS = 5;
        int nPoints = 3;
        double dist = 2;
        Point[] POINTS = { new Point(1,0), new Point(1.5, 2.1), new Point(2, 0), new Point(-1, -2), new Point(1.5, 0)};
        LICParameters PARAMETERS = new LICParameters(3, 3, 1, 2, 3, 1, dist, nPoints, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 2);
        ABMInput input = new ABMInput();
        input.NUMPOINTS = NUMPOINTS;
        input.POINTS = POINTS;
        input.PARAMETERS = PARAMETERS;
        ABMSystem system = new ABMSystem(input);
        
        System.out.print("Testing LIC6... ");
        
        boolean met = system.checkLIC6(input);
        
        
        // assertion.
        assert true == met : "Failed test for LIC 6. Got " + met + " but expected true";
        System.out.println("OK!");
    }
    
    public void testLIC7() {
        // contract: correctly check if the LIC7 is met.
        // the test should return false if no two points, separated by two consecutive points, are farther than 10 apart
        
        // initialization. next four variables should be custom initialized
        int NUMPOINTS = 4;
        int kpoints = 2;
        double length1 = 10;
        Point[] POINTS = { new Point(1,2), new Point(-1, -2.1), new Point(0, 0), new Point(-1, -2)};
        LICParameters PARAMETERS = new LICParameters(length1, 5, 2, 3, 2, 6, 3, 3, kpoints, 3, 2, 1, 2, 10, 2, 5, 2, 3, 1);
        boolean met = false;
        ABMInput input = new ABMInput();
        input.NUMPOINTS = NUMPOINTS;
        input.POINTS = POINTS;
        input.PARAMETERS = PARAMETERS;
        ABMSystem system = new ABMSystem(input);
        
        System.out.print("Testing LIC7... ");
        // body
        met = system.checkLIC7(input);
    

        // assertion.
        assert false == met : "Failed test for LIC 7. Got " + met + " but expected false";
        System.out.println("OK!");
    }
    
    public void testLIC8() {
        // contract: correctly check if the LIC8 is met.
        
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
        assert true == met : "Failed test for LIC 8. Got " + met + " but expected true";
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
        assert true == met : "Failed test for LIC 8. Got " + met + " but expected true";
        System.out.println("OK!");

    }
    public void testLIC9() {
        // contract: correctly check if the LIC9 is met.
        // The test should return a true, as the angle between the lines (POINTS[0], POINTS[2]) and
        // (POINTS[2], POINTS[4]) is somewhere around 0.001
        
        // initialization. next four variables should be custom initialized
        int NUMPOINTS = 5;
        double epsilon = 1;
        int C_PTS = 1;
        int D_PTS = 1;
        Point[] POINTS = { new Point(-1, -2.1), new Point(0, 0), new Point(1,2), new Point(-1, -2.1), new Point(-1, -2)};
        LICParameters PARAMETERS = new LICParameters(3, 3, epsilon, 2, 3, 1, 3, 2, 2, 2, 2, C_PTS, D_PTS, 2, 2, 2, 3, 3, 2);
        
        ABMInput input = new ABMInput();
        input.NUMPOINTS = NUMPOINTS;
        input.POINTS = POINTS;
        input.PARAMETERS = PARAMETERS;
        ABMSystem system = new ABMSystem(input);
        
        System.out.print("Testing LIC9... ");
        // body
        boolean met = system.checkLIC9(input);
        
        // assertion.
        assert true == met : "Failed test for LIC 9. Got " + met + " but expected true";
        System.out.println("OK!");
    }
    public void testLIC10() {
        // contract: correctly check if the LIC10 is met.
        
        /* The test should return a true if there is a triangle formed by three points, 
        separated by e and f consecutive points respectively, with an area > area1 */

        // test 1
        int NUMPOINTS = 6;
        double area1 = 1;
        int epts = 1;
        int fpts = 2;
        Point[] POINTS = { new Point(1,2), new Point(-1, -2), new Point(-1, -2.1), new Point(-10, 5), new Point(3, 5), new Point(0, 0)};
        LICParameters PARAMETERS = new LICParameters(3, 3, 1, area1, 3, 1, 3, 2, 2, 2, 2, 2, 2, epts, fpts, 2, 3, 3, 2);
        boolean met = true;
        ABMInput input = new ABMInput();
        input.NUMPOINTS = NUMPOINTS;
        input.POINTS = POINTS;
        input.PARAMETERS = PARAMETERS;
        ABMSystem system = new ABMSystem(input);
        
        System.out.print("Testing LIC10... (test 1)");
        
        met = system.checkLIC10(input);
        // assertion.
        assert false == met : "Failed test for LIC 10. Got " + met + " but expected false";
        System.out.println("OK!");
        
        // test 2
        NUMPOINTS = 7;
        area1 = 10;
        Point[] POINTS2 = { new Point(1,2), new Point(-1, -2), new Point(-1, -2.1), new Point(-10, 5), new Point(3, 5), new Point(1.5, 3.2), new Point(0, 0)};
        PARAMETERS = new LICParameters(3, 3, 1, area1, 3, 1, 3, 2, 2, 2, 2, 2, 2, epts, fpts, 2, 3, 3, 2);
        met = true;
        input = new ABMInput();
        input.NUMPOINTS = NUMPOINTS;
        input.POINTS = POINTS2;
        input.PARAMETERS = PARAMETERS;
        system = new ABMSystem(input);
        
        System.out.print("Testing LIC10... (test 2)");
        
        met = system.checkLIC10(input);
        // assertion.
        assert true == met : "Failed test for LIC 10. Got " + met + " but expected true";
        System.out.println("OK!");
    }

    public void testLIC11() {
        // contract: correctly check if the LIC11 is met.
        
        // Test initial condition NUMPOINTS < 3 results in false
        ABMInput input = new ABMInput();
        input.NUMPOINTS = 2;
        input.POINTS = new Point[] { new Point(1, 3), new Point(3, 1) };
        int gpts = 1;
        input.PARAMETERS = new LICParameters(3, 3, 1, 1, 3, 1, 3, 2, 2, 2, 2, 2, 2, 2, 2, gpts, 3, 3, 2);
        ABMSystem system = new ABMSystem(input);
        
        System.out.print("Testing LIC11 (test 1)...");
        boolean met = system.checkLIC11(input);
        assert false == met : "Failed test for LIC 11. Got " + met + " but expected false";
        System.out.println("OK!");

        // Test successful case
        input.NUMPOINTS = 4;
        input.POINTS = new Point[] { new Point(1, 3), new Point(3, 1), new Point(2, 3), new Point(0, 0) };
        gpts = 1;
        input.PARAMETERS = new LICParameters(3, 3, 1, 1, 3, 1, 3, 2, 2, 2, 2, 2, 2, 2, 2, gpts, 3, 3, 2);

        System.out.print("Testing LIC11 (test 2)...");
        met = system.checkLIC11(input);
        assert true == met : "Failed test for LIC 11. Got " + met + " but expected true";
        System.out.println("OK!");

        // Test failed case
        input.NUMPOINTS = 4;
        input.POINTS = new Point[] { new Point(0, 3), new Point(1, 1), new Point(2, 3), new Point(3, 0) };
        gpts = 1;
        input.PARAMETERS = new LICParameters(3, 3, 1, 1, 3, 1, 3, 2, 2, 2, 2, 2, 2, 2, 2, gpts, 3, 3, 2);

        System.out.print("Testing LIC11 (test 3)...");
        met = system.checkLIC11(input);
        assert false == met : "Failed test for LIC 11. Got " + met + " but expected false";
        System.out.println("OK!");
    }
    public void testLIC12() {
        // contract: correctly check if the LIC12 is met.

        // the test should return false if no two points separated by 2 points are farther than 3, or less than 10 apart
        
        // test 1
        int NUMPOINTS = 4;
        double length1 = 1;
        double length2 = 1;
        int kPoints = 1;
        
        Point[] POINTS = { new Point(1,0), new Point(-1, 0), new Point(0, 0), new Point(-2, 0)};
        LICParameters PARAMETERS = new LICParameters(length1, 3, 2, 2, 3, 1, 3, 2, kPoints, 2, 2, 2, 2, 2, 2, 2, length2, 3, 2);
    
        ABMInput input = new ABMInput();
        input.NUMPOINTS = NUMPOINTS;
        input.POINTS = POINTS;
        input.PARAMETERS = PARAMETERS;
        ABMSystem system = new ABMSystem(input);
        
        System.out.print("Testing LIC12... ");
        boolean met = system.checkLIC12(input);
        
        // assertion.
        assert false == met : "Failed test1 for LIC 12. Got " + met + " but expected false";
        System.out.println("OK!");
        
        // test 2
        NUMPOINTS = 4;
        length1 = 0.9;
        length2 = 2;
        kPoints = 1;
        
        Point[] POINTS2 = { new Point(1,0), new Point(-1, 0), new Point(0, 0), new Point(-2, 0)};
        PARAMETERS = new LICParameters(length1, 3, 2, 2, 3, 1, 3, 2, kPoints, 2, 2, 2, 2, 2, 2, 2, length2, 3, 2);
        
        //ABMInput input = new ABMInput();
        input.NUMPOINTS = NUMPOINTS;
        input.POINTS = POINTS2;
        input.PARAMETERS = PARAMETERS;
        ABMSystem system2 = new ABMSystem(input);
        
        System.out.print("Testing LIC12... ");
        met = system2.checkLIC12(input);
        
        // assertion.
        assert true == met : "Failed test2 for LIC 12. Got " + met + " but expected true";
        System.out.println("OK!");
        
        // test 3
        NUMPOINTS = 4;
        length1 = 0.9;
        length2 = 1;
        kPoints = 1;
        
        Point[] POINTS3 = { new Point(1,0), new Point(-1, 0), new Point(0, 0), new Point(-2, 0)};
        PARAMETERS = new LICParameters(length1, 3, 2, 2, 3, 1, 3, 2, kPoints, 2, 2, 2, 2, 2, 2, 2, length2, 3, 2);
        
        //ABMInput input = new ABMInput();
        input.NUMPOINTS = NUMPOINTS;
        input.POINTS = POINTS2;
        input.PARAMETERS = PARAMETERS;
        ABMSystem system3 = new ABMSystem(input);
        
        System.out.print("Testing LIC12... ");
        met = system3.checkLIC12(input);
        
        // assertion.
        assert false == met : "Failed test3 for LIC 12. Got " + met + " but expected false";
        System.out.println("OK!");
    }
    public void testLIC13() {
        // contract: correctly check if the LIC13 is met.
        
        // Positive test
        boolean met = false;
        ABMInput input = new ABMInput();
        input.NUMPOINTS = 6;
        input.POINTS = new Point[] { new Point(-2,-2),new Point(1,0),new Point(-2,2),new Point(0,0),new Point(0,0),new Point(0.5,-0.5)};
        int apts = 1, bpts = 1;
        double radius1 = 1.0, radius2 = 2.0;
        input.PARAMETERS = new LICParameters(3, radius1, 1, 1, 3, 1, 3, 2, 2, apts, bpts, 2, 2, 1, 1, 1, 3, radius2, 1);
        ABMSystem system = new ABMSystem(input);

        System.out.print("Testing LIC13 (test 1)...");
        met = system.checkLIC13(input);
        assert true == met : "Failed test for LIC 13. Got " + met + " but expected true";
        System.out.println("OK!");

        // Negative test
        radius2 = 1.5;
        input.NUMPOINTS = 5;
        input.PARAMETERS = new LICParameters(3, radius1, 1, 1, 3, 1, 3, 2, 2, apts, bpts, 2, 2, 1, 1, 1, 3, radius2, 1);
        input.POINTS = new Point[] {new Point(2,0),new Point(9,9),new Point(0,-2),new Point(10,10),new Point(-2,2)};
        System.out.print("Testing LIC13 (test 2)...");
        met = system.checkLIC13(input);
        assert false == met : "Failed test for LIC 13. Got " + met + " but expected false";
        System.out.println("OK!");

        // Test NUMPOINTS < 5 condition
        input.NUMPOINTS = 3;
        input.PARAMETERS = new LICParameters(3, radius1, 1, 1, 3, 1, 3, 2, 2, apts, bpts, 2, 2, 1, 1, 1, 3, radius2, 1);
        input.POINTS = new Point[] {new Point(1,1),new Point(1,0),new Point(-1,-1)};
        System.out.print("Testing LIC13 (test 3)...");
        met = system.checkLIC13(input);
        assert false == met : "Failed test for LIC 13. Got " + met + " but expected false";
        System.out.println("OK!");
    }
    
    public void testLIC14() {
        // contract: correctly check if the LIC14 is met.
        
        // Check initial condition of NUMPOINTS < 5 which should fail
        ABMInput input = new ABMInput();
        input.NUMPOINTS = 3;
        input.POINTS = new Point[] { new Point(1, 3), new Point(3, 1), new Point(1, 1) };
        int epts = 1, fpts = 1;
        double area1 = 2.0, area2 = 4.0;
        input.PARAMETERS = new LICParameters(3, 3, 1, area1, 3, 1, 3, 2, 2, 2, 2, 2, 2, epts, fpts, 1, 3, 3, area2);
        ABMSystem system = new ABMSystem(input);

        System.out.print("Testing LIC14 (test 1)...");
        boolean met = system.checkLIC14(input);
        assert false == met : "Failed test for LIC 14. Got " + met + " but expected false";
        System.out.println("OK!");

        // Check a successful case where both are succeeded at once
        input.NUMPOINTS = 6;
        input.POINTS = new Point[] { 
            new Point(0, 0), 
            new Point(0, 0), 
            new Point(2, 0),
            new Point(0, 0),
            new Point(0, 3),
            new Point(0, 0)
        };
        epts = 1; fpts = 1;
        area1 = 2.0; area2 = 4.0;
        input.PARAMETERS = new LICParameters(3, 3, 1, area1, 3, 1, 3, 2, 2, 2, 2, 2, 2, epts, fpts, 1, 3, 3, area2);

        System.out.print("Testing LIC14 (test 2)...");
        met = system.checkLIC14(input);
        assert true == met : "Failed test for LIC 14. Got " + met + " but expected true";
        System.out.println("OK!");

        // Check a failed case where only one part succeeds
        input.NUMPOINTS = 6;
        input.POINTS = new Point[] { 
            new Point(0, 0), 
            new Point(0, 0), 
            new Point(2, 0),
            new Point(2, 0),
            new Point(0, 5),
            new Point(0, 5)
        };
        epts = 1; fpts = 1;
        area1 = 2.0; area2 = 4.0;
        input.PARAMETERS = new LICParameters(3, 3, 1, area1, 3, 1, 3, 2, 2, 2, 2, 2, 2, epts, fpts, 1, 3, 3, area2);

        System.out.print("Testing LIC14 (test 3)...");
        met = system.checkLIC14(input);
        assert false == met : "Failed test for LIC 14. Got " + met + " but expected false";
        System.out.println("OK!");
    }
}

