package rectangle;
/**
 * This class implements a rectangle entity, so that it can be represented in one object.
 */
/**
 * @author Sen Francis
 *
 */
public class Rectangle {

	/**
	 * Private variable declaration.
	 */
	private double x1;
	private double y1;
	private double x2;
	private double y2;
	private double width;
	private double height;
	
	/**
	* This is the constructor to create the rectangle object.
	*
	* @param  x1     the upper left x coordinate of the rectangle
	* @param  y1     the upper left y coordinate of the rectangle
	* @param  width  the width of the rectangle
	* @param  height the height of the rectangle
	*/
	public Rectangle(double x1, double y1, double width, double height ) {
		this.x1 = x1;
		this.y1 = y1;
		this.width = width;
		this.height = height;
		this.x2 = x1+width;
		this.y2 = y1-height;
	}
	
	/**
	* This method gets the upper left x coordinate of the rectangle.
	*
	* @return  the upper left x coordinate of the rectangle
	*/
	public double getX1() {
		return this.x1;
	}
	
	/**
	* This method gets the upper left y coordinate of the rectangle.
	*
	* @return  the upper left y coordinate of the rectangle
	*/
	public double getY1() {
		return this.y1;
	}
	
	/**
	* This method gets the bottom right x coordinate of the rectangle.
	*
	* @return  the bottom right x coordinate of the rectangle
	*/
	public double getX2() {
		return this.x2;
	}
	
	/**
	* This method gets the bottom right y coordinate of the rectangle.
	*
	* @return  the bottom right y coordinate of the rectangle
	*/
	public double getY2() {
		return this.y2;
	}
	
	/**
	* This method gets the width of the rectangle.
	*
	* @return  the width of the rectangle
	*/
	public double getWidth() {
		return this.width;
	}

	/**
	* This method gets the height of the rectangle.
	*
	* @return  the height of the rectangle
	*/
	public double getHeight() {
		return this.height;
	}
}
