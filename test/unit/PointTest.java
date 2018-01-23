public class PointTest {
    
    public static void main (String[] args) {
        PointTest test = new PointTest(); 
        test.testGetX();
        test.testGetY();
        test.testQuadrant();
        test.testDistanceTo();
        test.testDotProduct();
        test.testMinus();
    }

    private void testGetX() {
        // Test that the returned x-component is correct
        // The returned x-component should be 13.2
        Point p = new Point(13.2, 0); 

        System.out.print("Testing getX...");
        assert 13.2 == p.getX() : String.format (
            "Failed! Expected 13.2 but got %f",
            p.getX());
        System.out.println("OK!");
    }

    private void testGetY() {
        // Test that the returned y-component is correct
        // The returned y-component should be 13.2
        Point p = new Point(0, 13.2); 

        System.out.print("Testing getY...");
        assert 13.2 == p.getY() : String.format (
            "Failed! Expected 13.2 but got %f",
            p.getX());
        System.out.println("OK!");
    }

    private void testQuadrant () {
        // Test that the return quadrant is returned.

        // Edge-cases go to the lower quadrant.
        // This test case should return quadrant 1
        Point p = new Point (0, 1);
        System.out.print("Testing quadrant (test 1)..."); 
        assert 1 == p.quadrant() : String.format (
            "Failed! Expected 1 but got %d",
            p.quadrant());
        System.out.println("OK!"); 

        p = new Point(-3, -3);
        System.out.print("Testing quadrant (test 2)...");
        assert 3 == p.quadrant() : String.format (
            "Failed! Expected 3 but got %d",
            p.quadrant());
        System.out.println("OK!");
    }

    private void testDistanceTo () {
        Point p1 = new Point(0, 0); 
        Point p2 = new Point(3, 0);

        // Distance between (0,0) and (3,0) should be 3
        System.out.print("Testing distanceTo (test 1)...");
        assert 3 == p1.distanceTo(p2) : String.format(
            "Failed! Expected 3 but got %f",
            p1.distanceTo(p2));
        System.out.println("OK!");

        p2 = new Point(3, 4);
        // Pythagoras tells us this should be 5
        System.out.print("Testing distanceTo (test 2)...");
        assert 5 == p1.distanceTo(p2) : String.format(
            "Failed! Expected 5 but got %f",
            p1.distanceTo(p2));
        System.out.println("OK!");

        // Reverse the order to see that it works that way
        p2 = new Point(0, 0);
        p1 = new Point(4, 3);
        System.out.print("Testing distanceTo (test 3)...");
        assert 5 == p1.distanceTo(p2) : String.format(
            "Failed! Expected 5 but got %f",
            p1.distanceTo(p2));
        System.out.println("OK!");
    }

    private void testDotProduct () {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(3, 4);

        // The following test should be 1*3 + 2*4 = 3+8 = 11
        System.out.print("Testing dotProduct (test 1)...");
        assert 11 == p1.dotProduct(p2) : String.format(
            "Failed! Expected 14 but got %f",
            p1.dotProduct(p2));
        System.out.println("OK!");

        // Check negative numbers. -1*3 + 2*4 = -3 + 8 = 5
        System.out.print("Testing dotProduct (test 2)...");
        p1 = new Point(-1, 2);
        assert 5 == p1.dotProduct(p2) : String.format(
            "Failed! Expected 10 but got %f",
            p1.dotProduct(p2));
        System.out.println("OK!");

        // Check base-case (0,0) and (0,0). The result should be 0
        p1 = new Point(0,0);
        p2 = new Point(0,0);
        System.out.print("Testing dotProduct (test 3)...");
        assert 0 == p1.dotProduct(p2) : String.format(
            "Failed! Expected 0 but got %f",
            p1.dotProduct(p2));
        System.out.println("OK!");
    }

    private void testMinus () {
        Point p1 = new Point(2, 2);
        Point p2 = new Point(1, 1);
        Point pc = new Point(1, 1);
        
        // The new point should have 0 distance to a point (1,1) 
        Point pn = p1.minus(p2);
        System.out.print("Testing minus (test 1)...");
        assert 0 == pn.distanceTo(pc) : String.format(
            "Failed! Expected 0 distance to %s, but new point has coordinates %s",
            pc.toString(), pn.toString());
        System.out.println("OK!");
        
        // Test that negative numbers work
        p1 = new Point(0, 0);
        p2 = new Point(-1, -1);
        pn = p1.minus(p2);
        System.out.print("Testing minus (test 2)...");
        assert 0 == pn.distanceTo(pc) : String.format(
            "Failed! Expected 0 distance to %s, but new point has coordinates %s",
            pc.toString(), pn.toString());
        System.out.println("OK!");
    }
}
