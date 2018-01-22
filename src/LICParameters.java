public class LICParameters {
    final private double length1;       // Length in LICs 0, 7, 12
    final private double radius1;       // Radius in LICs 1, 8, 13
    final private double epsilon;       // Deviations from PI in LICs 2, 9
    final private double area1;         // Area in LICs 3, 10, 14
    final private int qPoints;          // No. of consecutive points in LIC 4
    final private int quads;            // No. of quadrants in LIC 4
    final private double dist;          // Distance in LIC 6
    final private int nPoints;          // No. of consecutive points in LIC 6
    final private int kPoints;          // No. of int. points in LICs 7, 12
    final private int aPoints;          // No. of int. points in LICs 8, 13
    final private int bPoints;          // No. of int. points in LICs 8, 13
    final private int cPoints;          // No. of int. points in LIC 9
    final private int dPoints;          // No. of int. points in LIC 9
    final private int ePoints;          // No. of int. points in LICs 10, 14
    final private int fPoints;          // No. of int. points in LICs 10, 14
    final private int gPoints;          // No. of int. points in LIC 11
    final private double length2;       // Maximum length in LIC 12
    final private double radius2;       // Maximum radius in LIC 13
    final private double area2;         // Maximum area in LIC 14


    // Could be changed to using a Builder-class
    public LICParameters (double length1, double radius1, double epsilon, double area1,
        int qPoints, int quads, double dist, int nPoints, int kPoints, int aPoints,
        int bPoints, int cPoints, int dPoints, int ePoints, int fPoints, int gPoints,
        double length2, double radius2, double area2) {

        this.length1 = length1;
        this.radius1 = radius1;
        this.epsilon = epsilon;
        this.area1 = area1;
        this.qPoints = qPoints;
        this.quads = quads;
        this.dist = dist;
        this.nPoints = nPoints;
        this.kPoints = kPoints;
        this.aPoints = aPoints;
        this.bPoints = bPoints;
        this.cPoints = cPoints;
        this.dPoints = dPoints;
        this.ePoints = ePoints;
        this.fPoints = fPoints;
        this.gPoints = gPoints;
        this.length2 = length2;
        this.radius2 = radius2;
        this.area2 = area2;
    }

    public double getLength1 () {
        return this.length1;
    }
    
    public double getRadius1 () {
        return this.radius1;
    }
    
    public double getEpsilon () {
        return this.epsilon;
    }
    
    public double getArea1 () {
        return this.area1;
    }
    
    public int getQPoints () {
        return this.qPoints;
    }
    
    public int getQuads () {
        return this.quads;
    }
    
    public double getDist () {
        return this.dist;
    }
    
    public int getNPoints () {
        return this.nPoints;
    }
    
    public int getKPoints () {
        return this.kPoints;
    }
    
    public int getAPoints () {
        return this.aPoints;
    }
    
    public int getBPoints () {
        return this.bPoints;
    }
    
    public int getCPoints () {
        return this.cPoints;
    }
    
    public int getDPoints () {
        return this.dPoints;
    }
    
    public int getEPoints () {
        return this.ePoints;
    }
    
    public int getFPoints () {
        return this.fPoints;
    }
    
    public int getGPoints () {
        return this.gPoints;
    }
    
    public double getLength2 () {
        return this.length2;
    }
    
    public double getRadius2 () {
        return this.radius2;
    }
    
    public double getArea2 () {
        return this.area2;
    }
    
}
