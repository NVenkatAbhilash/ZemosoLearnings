import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
        //create integer to store count of points with initial value zero
        int countOfPoints=0;
        //iterate each point and increment count by one for every iteration
        for(Point point: s.getPoints()){
            countOfPoints++;
        }
        //return interger storing count of points        
        return countOfPoints;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        //create an integer to store sum of lengths with initial value zero
        double sumOfLengths = 0,averageLength,distance;
        int numberOfPoints;
        //to store the previous point create a point with 
        //initial point as lastPoint
        Point previousPoint = s.getLastPoint();
        //iterate over each point and add distance to sum of lengths
        for(Point point: s.getPoints()){
            distance = point.distance(previousPoint);
            sumOfLengths += distance;
            //store current point in previous point
            previousPoint = point;
        }
        //get number of points
        numberOfPoints = getNumPoints(s);
        //now divide sum of lengths with number of points
        averageLength = sumOfLengths/numberOfPoints;
        //return the above evaluated value
        return averageLength;
    }

    public double getLargestSide(Shape s) {
        // Put code here
        //create a double which stores current maximum side length
        //with initial value 0
        double currentMaximumLength = 0,presentLength;
        //store the previous point and set initial value as lastPoint;
        Point previousPoint = s.getLastPoint();
        //iterate over each point and find length
        for(Point point:s.getPoints()){
            //in loop get length
            presentLength = point.distance(previousPoint);
            //if this is greater than current maximum side length
            if(presentLength>currentMaximumLength){
                //then replace current maximum with present length
                currentMaximumLength = presentLength;
            }
            //update previous point
            previousPoint = point;
        }
        //return current maximum side length
        return currentMaximumLength;
    }

    public double getLargestX(Shape s) {
        // Put code here
        //create variable to store current maximum x value with
        //initial value as x value of last point
        Point lastPoint = s.getLastPoint();
        double currentMaximumXValue = lastPoint.getX();
        double presentXValue;
        //iterate over each point
        for(Point point : s.getPoints()){   
            //get x value of each point
            presentXValue = point.getX();
            //if present x value is greater than current maximum x value
            if(currentMaximumXValue<presentXValue){
                //then replace current maximum with present x value                
                currentMaximumXValue=presentXValue;
            }
        }
        //return current maximum x value
        return currentMaximumXValue;
    }
    
    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        //selet files
        FileResource fileResource;
        double maximumPerimeter = 0,perimeter;
        DirectoryResource files = new DirectoryResource();
        Shape shape;
        //iterate over each file
        for(File file : files.selectedFiles()){
            fileResource = new FileResource(file);
            //get shape
            shape = new Shape(fileResource);
            //get perimeter
            perimeter = getPerimeter(shape);
            //if present perimeter greater than maximum parimeter
            if(maximumPerimeter < perimeter){
                //then replace maximum perimeter with present perimeter
                maximumPerimeter = perimeter;
            }
        }
        //return maximum perimeter
        return maximumPerimeter;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        //selet files
        FileResource fileResource;
        File maximumPerimeterfile = null;
        double maximumPerimeter = 0,perimeter;
        DirectoryResource files = new DirectoryResource();
        Shape shape;
        //iterate over each file
        for(File file : files.selectedFiles()){
            fileResource = new FileResource(file);
            //get shape
            shape = new Shape(fileResource);
            //get perimeter
            perimeter = getPerimeter(shape);
            //if present perimeter greater than maximum parimeter
            if(maximumPerimeter < perimeter){
                //then replace maximum perimeter file and value with present perimeter file and value
                maximumPerimeter = perimeter;
                maximumPerimeterfile = file;
            }
        }
        //return maximum perimeter file name
        return maximumPerimeterfile.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        int numberOfPoints = getNumPoints(s);
        double averageLength = getAverageLength(s);
        double maximumSideLength = getLargestSide(s);
        double largestXValue = getLargestX(s);
        System.out.println("perimeter = " + length);
        System.out.println("number of points = " + numberOfPoints);
        System.out.println("average side length = " + averageLength);
        System.out.println("maximum side length = " + maximumSideLength);
        System.out.println("Largest x value = " + largestXValue);
    }
    
    
    public void testPerimeterMultipleFiles() {
        // Put code here        
        System.out.println("Largest Perimeter Multiple Files = " + getLargestPerimeterMultipleFiles());
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
        System.out.println("File With Largest Perimeter = " + getFileWithLargestPerimeter());
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
