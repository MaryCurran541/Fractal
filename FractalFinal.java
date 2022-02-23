package fractalFinal;

/* Mary Curran Computer Science 2 Final 
* 
* Program that makes a fractal out of squares using recursion, method overloading, and JFrame.  
* 
* 
* @author Mary Curran 
* @since 4/10/21
* @version 1.0
*/

	import javax.swing.*;
	import java.awt.*;

	public class FractalFinal {
		public static void main(String[] args)
		{
			FractalFrame frame = new FractalFrame();
			frame.setVisible(true);
		}
	}

	class FractalFrame extends JFrame
	{
		private JPanel panel;
	    private int width, height;
	    private int x = 200;
	    private int limit = 15;

		public FractalFrame()
		{
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			final int defaultWidth  = 800;
			final int defaultHeight = 800;
			setSize(defaultWidth, defaultHeight);
			setLocation(300,50);

			panel = new JPanel();
			Container contentPane = getContentPane();
			contentPane.add(panel, "Center");
		}

		/*
		 * Sets the variables in the JPanel and sets the starting variables of the fractal
		 */
		public void paint(Graphics g) {
	        super.paint(g);
	        Graphics2D g2 = (Graphics2D) g;
	        //Gets the size of the frame
	        width  = getWidth();
	        height = getHeight();
	        g.setColor(Color.BLACK);

	        //Creates the starting position of the first square to fit center to the frame.
	        int w = (width/2)-(x/2);
	        int h = (height/2)-(x/2);
	        //Draws the first square
	        g.fillRect(w, h, x, x);
	        //Starts the recursive fractal generation if the limit is greater than 0.
	        if(limit > 0) drawSquare(w,h,g);
	    }
		
		/*
	    Draws the first level of squares and then recursively draws the remaining amount. Stops when n equals limit.
	     Each concurrent square will be exactly half that of its parent. 
	     */
	    private void drawSquare(int w, int h, Graphics g) {
	        // N will be used as a checker to count how many levels of recursion have occurred.
	        int n = 0;
	        //Draws Pos 0 (Top-Left)
	        g.fillRect(w-(x/2), h-(x/2), x/2, x/2);
	        drawSquare(w-(x/2), h-(x/2), g, n, 0, x/2);
	        //Draws Pos 1 (Top-Right)
	        g.fillRect(w+x, h-(x/2), x/2, x/2);        
	        drawSquare(w+x, h-(x/2), g, n, 1, x/2);
	        //Draws pos 2 (Bottom-Right)
	        g.fillRect(w+x, h+x, x/2, x/2);
	        drawSquare(w+x, h+x, g, n, 2, x/2);
	        //Draws pos 3 (Bottom-Left)
	        g.fillRect(w-(x/2), h+x, x/2, x/2);
	        drawSquare(w-(x/2), h+x, g, n, 3, x/2);
	    }

	    /*
	     * Recursive function to draw squares
	     */
	    private void drawSquare(int w, int h, Graphics g, int n, int origin, int size) {
	        // Stops the recursion loop when it has reached its complexity limit.
	        if(n == limit) return;
	        n++;
	        //prevents the program from drawing a square at the location of its parent.
	        origin = (origin+2)%4;
	        //Draws Pos 0
	        if(origin != 0) {
	            g.fillRect(w-(size/2), h-(size/2), size/2, size/2);
	            //Recursive Call
	            drawSquare(w-(size/2), h-(size/2),g,n,0,size/2);
	        }
	        //Draws Pos 1
	        if(origin != 1) {
	            g.fillRect(w+size, h-(size/2), size/2, size/2);
	            //Recursive Call        
	            drawSquare(w+size, h-(size/2),g,n,1,size/2);
	        }
	        //Draws pos 2
	        if(origin != 2) {
	            g.fillRect(w+size, h+size, size/2, size/2);
	            //Recursive Call
	            drawSquare(w+size, h+size,g,n,2,size/2);
	        }
	        //Draws pos 3
	        if(origin != 3) {
	            g.fillRect(w-(size/2), h+size, size/2, size/2);
	            //Recursive Call
	            drawSquare(w-(size/2), h+size,g,n,3,size/2);
	        }
	    }
	}
