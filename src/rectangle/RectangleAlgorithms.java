package rectangle;

import java.util.Scanner;
import java.awt.geom.Point2D;
import java.io.IOException;

/**
 * This class implements algorithms to be performed on pairs of rectangles.
 */

/**
 * @author Sen Francis
 *
 */
public class RectangleAlgorithms {
	
	/**
	* This method draws the two rectangles and saves them as a PNG in the output-images directory (inside the root directory).
	*
	* @param  a  the first rectangle
	* @param  b  the second rectangle
	* @param  filename  the desired name to save the file as
	*/
	public static void drawRectangles(Rectangle a, Rectangle b, String filename) throws IOException {
		DrawRectangles draw = new DrawRectangles();
		draw.updatePaint(a,b);
		draw.save(filename);
	}
	
	/**
	* This method checks if two rectangles have intersecting lines and identifies what their points of intersection are (if applicable).
	*
	* @param  a  the first rectangle
	* @param  b  the second rectangle
	* @return    an array containing the intersection points of the resulting intersection rectangle, if no intersection points, returns null
	*/
	public static Point2D.Double[] checkIntersection(Rectangle a, Rectangle b) {
        if ((a.getX1() < b.getX2() && b.getX1() < a.getX2() && a.getY1() > b.getY2() && b.getY1() > a.getY2()) ||
        	(b.getX1() < a.getX2() && a.getX1() < b.getX2() && b.getY1() > a.getY2() && a.getY1() > b.getY2())){
        	Point2D.Double[] points = new Point2D.Double[4];
        	double leftX = Math.max(a.getX1(),b.getX1());
        	double rightX = Math.min(a.getX2(),b.getX2());
        	double topY = Math.min(a.getY1(),b.getY1());
        	double bottomY = Math.max(a.getY2(),b.getY2());
        	points[0] = new Point2D.Double(leftX, topY);
        	points[1] = new Point2D.Double(rightX, topY);
        	points[2] = new Point2D.Double(leftX, bottomY);
        	points[3] = new Point2D.Double(rightX, bottomY);
        	return points;
        }
        return null;
	}
	
	/**
	* This method checks if a rectangle is wholly contained within another rectangle.
	*
	* @param  a  the first rectangle
	* @param  b  the second rectangle
	* @return    true if either of the rectangles are wholly contained within the other, false otherwise
	*/
	public static boolean checkContainment(Rectangle a, Rectangle b) {
		return((a.getX1() < b.getX1() && a.getX2() > b.getX2() && a.getY1() > b.getY1() && a.getY2() < b.getY2()) || //if a is outer rectangle
		   (b.getX1() < a.getX1() && b.getX2() > a.getX2() && b.getY1() > a.getY1() && b.getY2() < a.getY2())); //if b is outer rectangle
	}
	
	/**
	* This method checks if a rectangle is adjacent to another.
	*
	* @param  a  the first rectangle
	* @param  b  the second rectangle
	* @return    a string indicating the type of adjacency of the rectangles (if any).
	*/
	public static String checkAdjacency(Rectangle a, Rectangle b) {
		if((a.getX2() == b.getX1() && a.getY1() == b.getY1() && a.getY2() == b.getY2()) ||
		   (b.getX2() == a.getX1() && b.getY1() == a.getY1() && b.getY2() == a.getY2())) {
			return "proper Adjacent";
		}
		if((a.getX2() == b.getX1() && a.getY1() > b.getY1() && a.getY2() < b.getY2()) ||
		   (b.getX2() == a.getX1() && b.getY1() > a.getY1() && b.getY2()< a.getY2())) {
			return "sub-line adjacent";
		}
		if(((a.getX2() == b.getX1()) && ((b.getY1() <= a.getY1() && b.getY1() >= a.getY2()) || (b.getY2() <= a.getY1() && b.getY2() >= a.getY2()))) ||
		   ((b.getX2() == a.getX1()) && ((a.getY1() <= b.getY1() && a.getY1() >= b.getY2()) || (a.getY2() <= b.getY1() && a.getY2() >= b.getY2())))	) {
			return "partial adjacent";
		}
		return "not adjacent";
	}
	
	/**
	* The main method of the program. Prompts user to provide rectangle properties and if valid, performs each of the above algorithms on
	* the two rectangles
	*
	* @param  args  command line arguments
	 * @throws IOException 
	*/
	public static void main(String[] args) throws IOException {
		 //prompt for user input
		 Scanner scan = new Scanner(System.in);
		 System.out.println("Enter properties for rectangles in the format: x,y,w,h\n"
		 					 + "Where x,y are the coordinates of the top left point of the rectangle, and w,h are the width and height (respectively) "
		 					 + "of the rectangle.\nPlease enter the properties of rectangle 1.");
		 String r1 = scan.nextLine();
		 //parse user input and check if valid inputs
		 String[] r1Arr =r1.split(",");
		 double[] r1Vals = new double[r1Arr.length];
		 for(int i = 0; i < r1Arr.length; i++) {
			 try {
				 r1Vals[i] = Double.parseDouble(r1Arr[i]);
			 } 
			 catch (NumberFormatException e) {
				 System.out.println("Error: Please enter only real numbers for rectangle properties.");
				 return;
			 }
		 }
		 if(r1Vals[2] <= 0 || r1Vals[3] <= 0) {
			 System.out.println("Error: Please enter only positive values for width and height.");
			 return;
		 }
		 System.out.println("Please enter the properties of rectangle 2.");
		 String r2 = scan.nextLine();
		 String[] r2Arr =r2.split(",");
		 double[] r2Vals = new double[r2Arr.length];
		 for(int i = 0; i < r1Arr.length; i++) {
			 try {
				 r2Vals[i] = Double.parseDouble(r2Arr[i]);
			 } 
			 catch (NumberFormatException e) {
				 System.out.println("Error: Please enter only real numbers for rectangle properties.");
				 return;
			 }
		 }
		 if(r2Vals[2] <= 0 || r2Vals[3] <= 0) {
			 System.out.println("Error: Please enter only positive values for width and height.");
			 return;
		 }
		 
		 //if rectangles are valid, create Rectangle objects and run all algorithms on them and output results
		 Rectangle a = new Rectangle(r1Vals[0],r1Vals[1],r1Vals[2],r1Vals[3]);
		 Rectangle b = new Rectangle(r2Vals[0],r2Vals[1],r2Vals[2],r2Vals[3]);
		 Point2D.Double[] points = checkIntersection(a,b);
		 if(points!=null) {
			 System.out.println("The rectangles have intersecting lines! The points of intersection are: "+
					 			"["+points[0].getX()+", "+points[0].getY()+"], "+ 
					 			"["+points[1].getX()+", "+points[1].getY()+"], "+
					 			"["+points[2].getX()+", "+points[2].getY()+"], "+
					 			"["+points[3].getX()+", "+points[3].getY()+"].");
		 }
		 else {
			 System.out.println("The rectangles do not have intersecting lines.");
		 }
		 if(checkContainment(a,b)) {
			 System.out.println("One of the rectangles is wholly contained with the other!");
		 }
		 else {
			 System.out.println("Neither of the rectangles are wholly contained with one another.");
		 }
		 System.out.println("The rectangles are "+checkAdjacency(a,b)+".");
		 drawRectangles(a, b, "./output-images/rect-drawing.png");
	}
	
}
