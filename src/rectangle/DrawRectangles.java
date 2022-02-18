package rectangle;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter;
import java.util.Date;  

/**
 * This class utilizes the Swing library to draw rectangles so users can visualize the problem better.
 */
/**
 * @author Sen Francis
 *
 */
public class DrawRectangles extends JPanel {
	
	/**
	* private variable declaration
	*/
	private BufferedImage paintImage;	
	
	/**
	* This method draws the two input rectangles on the JPanel.
	* @param  a  the first rectangle
	* @param  b  the second rectangle
	*/
    public void updatePaint(Rectangle a, Rectangle b){
    	int maxW = (int)Math.max(b.getX1()+b.getWidth(), a.getX1()+a.getWidth())+10;
    	int maxH = (int)Math.max(b.getY1()+b.getHeight(), a.getY1()+a.getHeight())+10;
    	paintImage = new BufferedImage(maxW, maxH, BufferedImage.TYPE_3BYTE_BGR);
        Graphics g = paintImage.createGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, maxW, maxH);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.red);
        g2d.draw(new Rectangle2D.Double(a.getX1()+5, a.getY1()+5, a.getWidth(), a.getHeight()));
        // draw on paintImage using Graphics
        g2d.setColor(Color.blue);
        g2d.draw(new Rectangle2D.Double(b.getX1()+5, b.getY1()+5, b.getWidth(), b.getHeight()));
        g2d.dispose();
        // repaint panel with new modified paint
        repaint();
    }

	/**
	* This method saves the drawing as a PNG based on the given filename
	* @param  filename  the desired filename
	*/
    public void save(String filename) throws IOException{;
        ImageIO.write(paintImage, "PNG", new File(filename));
    }
}
