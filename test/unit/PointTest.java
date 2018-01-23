public class PointTest {
    
    public static void main (String[] args) {
        PointTest test = new PointTest(); 
    }

    private void testGetX() {
        // Test that the returned x-component is correct
        // The returned x-component should be 13.2
        Point p = new Point(13.2, 0); 

        assert 13.2 == p.getX() : String.format (
            "Failed! Expected 13.2 but got %f",
            p.getX());
    }

    private void testGetY() {
        // Test that the returned y-component is correct
        // The returned y-component should be 13.2
        Point p = new Point(0, 13.2); 

        assert 13.2 == p.getY() : String.format (
            "Failed! Expected 13.2 but got %f",
            p.getX());
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
        System.out.print("Testing distanceTo (test 1)...");
        assert 5 == p1.distanceTo(p2) : String.format(
            "Failed! Expected 5 but got %f",
            p1.distanceTo(p2));
        System.out.println("OK!");

        // Reverse the order to see that it works that way
        p2 = new Point(0, 0);
        p1 = new Point(4, 3);
        System.out.print("Testing distanceTo (test 1)...");
        assert 5 == p1.distanceTo(p2) : String.format(
            "Failed! Expected 5 but got %f",
            p1.distanceTo(p2));
        System.out.println("OK!");
    }
}
