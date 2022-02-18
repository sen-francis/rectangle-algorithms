package rectangle;

import static org.junit.jupiter.api.Assertions.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import javax.imageio.ImageIO;
import org.junit.jupiter.api.Test;

/**
 * This class implements unit tests to test the Rectangle algorithms.
 */

/**
 * @author Sen Francis
 *
 */
public class RectangleAlgorithmsTest {

	/**
	* This test checks if the intersection algorithm is working properly.
	*/
	@Test
	public void IntersectionTest1() {
		Rectangle a = new Rectangle(0.0, 0.0, 3.5, 2.0);
		Rectangle b = new Rectangle(1.5, -1.0, 1.5, 4.0);
		Point2D.Double[] result = RectangleAlgorithms.checkIntersection(a, b);
		Point2D.Double[] expected = new Point2D.Double[4];
		expected[0] = new Point2D.Double(1.5,-1.0);
		expected[1] = new Point2D.Double(3.0,-1.0);
		expected[2] = new Point2D.Double(1.5,-2.0);
		expected[3] = new Point2D.Double(3,-2.0);
		assertArrayEquals(result,expected);
	}

	/**
	* This test checks if the intersection algorithm is working properly.
	*/
	@Test
	public void IntersectionTest2() {
		Rectangle a = new Rectangle(2.0, -2.0, 4.0, 5.5);
		Rectangle b = new Rectangle(0.0, 0.0, 3.0, 4.0);
		Point2D.Double[] result = RectangleAlgorithms.checkIntersection(a, b);
		Point2D.Double[] expected = new Point2D.Double[4];
		expected[0] = new Point2D.Double(2.0,-2.0);
		expected[1] = new Point2D.Double(3,-2.0);
		expected[2] = new Point2D.Double(2,-4.0);
		expected[3] = new Point2D.Double(3.0,-4.0);
		assertArrayEquals(result,expected);
	}
	
	/**
	* This test checks if the intersection algorithm is working properly when there is no intersection.
	*/
	@Test
	public void NoIntersectionTest() {
		Rectangle a = new Rectangle(0.0, 0.0, 3.5, 2.0);
		Rectangle b = new Rectangle(4.5, 0.0, 3.5, 2.0);
		Point2D.Double[] result = RectangleAlgorithms.checkIntersection(a, b);
		assertNull(result);
	}
	
	/**
	* This test checks if the containment algorithm is working properly.
	*/
	@Test
	public void ContainmentTest1() {
		Rectangle a = new Rectangle(0.0, 0.0, 3.5, 2.0);
		Rectangle b = new Rectangle(1.0, -0.5, 1.5, 1.0);
		boolean result = RectangleAlgorithms.checkContainment(a, b);
		assertTrue(result);
	}
	
	/**
	* This test checks if the containment algorithm is working properly.
	*/
	@Test
	public void ContainmentTest2() {
		Rectangle a = new Rectangle(2.0, -2.0, 1.0, 1.0);
		Rectangle b = new Rectangle(0.0, 0.0, 6.0, 4.0);
		boolean result = RectangleAlgorithms.checkContainment(a, b);
		assertTrue(result);
	}
	
	/**
	* This test checks if the containment algorithm is working properly when there is no containment.
	*/
	@Test
	public void NoContainmentTest() {
		Rectangle a = new Rectangle(0.0, 0.0, 3.5, 2.0);
		Rectangle b = new Rectangle(4.5, 0.0, 3.5, 2.0);
		boolean result = RectangleAlgorithms.checkContainment(a, b);
		assertFalse(result);
	}
	
	/**
	* This test checks if the proper adjacency algorithm is working properly.
	*/
	@Test
	public void ProperAdjacencyTest1() {
		Rectangle a = new Rectangle(0.0, 0.0, 3.5, 2.0);
		Rectangle b = new Rectangle(3.5, 0.0, 3.5, 2.0);
		String result = RectangleAlgorithms.checkAdjacency(a, b);
		assertEquals(result,"proper Adjacent");
	}
	
	/**
	* This test checks if the proper adjacency algorithm is working properly.
	*/
	@Test
	public void ProperAdjacencyTest2() {
		Rectangle a = new Rectangle(5.0, 0.0, 5.0, 6.0);
		Rectangle b = new Rectangle(0.0, 0.0, 5.0, 6.0);
		String result = RectangleAlgorithms.checkAdjacency(a, b);
		assertEquals(result,"proper Adjacent");
	}
	
	/**
	* This test checks if the sub-line adjacency algorithm is working properly.
	*/
	@Test
	public void SublineAdjacencyTest1() {
		Rectangle a = new Rectangle(0.0, 0.0, 3.5, 2.0);
		Rectangle b = new Rectangle(3.5, -0.5, 3.5, 1.0);
		String result = RectangleAlgorithms.checkAdjacency(a, b);
		assertEquals(result,"sub-line adjacent");
	}
	
	/**
	* This test checks if the sub-line adjacency algorithm is working properly.
	*/
	@Test
	public void SublineAdjacencyTest2() {
		Rectangle a = new Rectangle(5.0, -1.0, 5.0, 2.0);
		Rectangle b = new Rectangle(0.0, 0.0, 5.0, 4.0);
		String result = RectangleAlgorithms.checkAdjacency(a, b);
		assertEquals(result,"sub-line adjacent");
	}
	
	/**
	* This test checks if the partial adjacency algorithm is working properly.
	*/
	@Test
	public void PartialAdjacencyTest1() {
		Rectangle a = new Rectangle(0.0, 0.0, 3.5, 2.0);
		Rectangle b = new Rectangle(3.5, 1.0, 3.5, 2.0);
		String result = RectangleAlgorithms.checkAdjacency(a, b);
		assertEquals(result,"partial adjacent");
	}
	
	/**
	* This test checks if the partial adjacency algorithm is working properly.
	*/
	@Test
	public void PartialAdjacencyTest2() {
		Rectangle a = new Rectangle(6.5, 2.0, 6.5, 4.0);
		Rectangle b = new Rectangle(0.0, 0.0, 6.5, 4.0);
		String result = RectangleAlgorithms.checkAdjacency(a, b);
		assertEquals(result,"partial adjacent");
	}
	
	/**
	* This test checks if the adjacency algorithm is working properly when there is no adjacency.
	*/
	@Test
	public void NoAdjacencyTest() {
		Rectangle a = new Rectangle(0.0, 0.0, 3.5, 2.0);
		Rectangle b = new Rectangle(4.5, 0.0, 3.5, 2.0);
		String result = RectangleAlgorithms.checkAdjacency(a, b);
		assertEquals(result,"not adjacent");
	}
	
	/**
	* This test checks if rectangle images are being properly produced by comparing it to an expected image.
	 * @throws IOException 
	*/
	@Test
	public void ImageVerificationTest() throws IOException {
		Rectangle a = new Rectangle(0.0, 0.0, 350, 200);
		Rectangle b = new Rectangle(450, 0.0, 350, 200);
		RectangleAlgorithms.drawRectangles(a, b, "rect-drawing");
		BufferedImage actualImage = ImageIO.read(new File("./output-images/rect-drawing.png"));
		BufferedImage expectedImage = ImageIO.read(new File("./expected-images/rect1.png"));
		byte[] actualArray = ((DataBufferByte) actualImage.getData().getDataBuffer()).getData();
		byte[] expectedArray = ((DataBufferByte) expectedImage.getData().getDataBuffer()).getData();
		assertArrayEquals(expectedArray, actualArray);
	}
	
	/**
	* This test checks if images are being compared properly, by comparing the rectangle image to a random image.
	 * @throws IOException 
	*/
	@Test
	public void BadImageVerificationTest() throws IOException {
		Rectangle a = new Rectangle(0.0, 0.0, 400, 230);
		Rectangle b = new Rectangle(450, 0.0, 550, 320);
		RectangleAlgorithms.drawRectangles(a, b, "rect-drawing");
		BufferedImage actualImage = ImageIO.read(new File("./output-images/rect-drawing.png"));
		BufferedImage expectedImage = ImageIO.read(new File("./expected-images/bladee.jpg"));
		byte[] actualArray = ((DataBufferByte) actualImage.getData().getDataBuffer()).getData();
		byte[] expectedArray = ((DataBufferByte) expectedImage.getData().getDataBuffer()).getData();
		assertFalse(Arrays.equals(expectedArray, actualArray));
	}
}
