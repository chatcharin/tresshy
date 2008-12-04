/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.rmutl.tresshy.calibration;

import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Rectangle;
import java.net.MalformedURLException;
import javax.media.jai.PerspectiveTransform;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author catchajaa
 */
public class ScreenFrame extends JFrame{
  	// this line is needed to avoid serialization warnings
    private final Image VISIBLE = new ImageIcon(ScreenFrame.class.getResource("francisco-ok.png")).getImage();
    private final ImageIcon NOT_VISIBLE = new ImageIcon(ScreenFrame.class.getResource("francisco-warning.png"));
	private final Image CROSS_HAIR = new ImageIcon(ScreenFrame.class.getResource("francisco-crosshair.png")).getImage();
	private static final long serialVersionUID = 1L;
    private int status;
    private Rectangle bounds;
    private Double[] d;
	Image screenImage; // downloaded image
	int w, h; // Display height and width


	// Program entry
	public static void main(String[] args) throws Exception {
      
	}

	// Class constructor
	public ScreenFrame() throws MalformedURLException {
          d = new Double[16];
		// Exiting program on window close
//		addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosing(WindowEvent e) {
//                System.exit(0);
//            }
//        });
//
//		// Exitig program on mouse click
//		addMouseListener(new MouseListener() {
//			public void mouseClicked(MouseEvent e) {
//              if(status >= 4)
//                  System.exit(0);
//              else{
//                status++;
//                refresh();
//              }
//             //   myrepaint();
//
//            }
//			public void mousePressed(MouseEvent e) {}
//			public void mouseReleased(MouseEvent e) {}
//			public void mouseEntered(MouseEvent e) {}
//			public void mouseExited(MouseEvent e) {}
//		}
//		);

		// remove window frame
		this.setUndecorated(true);

		// window should be visible
		this.setVisible(true);

		// switching to fullscreen mode
		GraphicsEnvironment.getLocalGraphicsEnvironment().
		getDefaultScreenDevice().setFullScreenWindow(this);
      //  this.setBackground(Color.);
        bounds = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration().getBounds();
		// getting display resolution: width and height
		w = this.getWidth();
		h = this.getHeight();
		System.out.println("Display resolution: " + String.valueOf(w) + "x" + String.valueOf(h));
		// loading image
//		if (source.startsWith("http://")) // http:// URL was specified
//			screenImage = Toolkit.getDefaultToolkit().getImage(new URL(source));
//		else
//			screenImage = Toolkit.getDefaultToolkit().getImage(source); // otherwise - file
	}
    public void refresh(){
//        if(status == 1){
//           int x = this.getX(bounds,0.1,0.9) - bounds.x;
//		   int y = this.getY(bounds,0.1,0.9) - bounds.y;
//           add(statusLabel(VISIBLE,1,x,y));
//        }else if(status == 2){
//           int x =this.getX(bounds,0.1,0.1) - bounds.x;
//		   int y =this.getY(bounds,0.1,0.1) - bounds.y;
//           add(statusLabel(VISIBLE,1,x,y));
//        }else if(status == 3){
//           int x = this.getX(bounds,0.9,0.1) - bounds.x;
//		   int y = this.getY(bounds,0.9,0.1) - bounds.y;
//           add(statusLabel(VISIBLE,1,x,y));
//        }else if(status == 4){
//         int x = this.getX(bounds,0.9,0.9) - bounds.x;
//		   int y = this.getY(bounds,0.9,0.9) - bounds.y;
//           add(statusLabel(VISIBLE,1,x,y));
//        }
         this.repaint();
//      add(statusLabel(points.get(wiimote).get(s) != null ? VISIBLE : NOT_VISIBLE, wiimote.getId(), x, y));
       
    }
    public void reset(){
        
    }
    public boolean nextState(){
        status++;
      return (status <= 3);
    }
    public PerspectiveTransform calculateTransformation() {
//           d[8] = 80.0;
//           d[9] = 80.0;
//           d[10] = 720.0;
//           d[11] = 80.0;
//           d[12] = 720.0;
//           d[13] = 1152.0;
        for(int i=0;i<16;i++)
            System.out.println(d[i]);
        return PerspectiveTransform.getQuadToQuad(d[2], d[3], d[4], d[5], d[6], d[7], d[0], d[1], d[8], d[9], d[10], d[11], d[12], d[13], d[14], d[15]);
	}
    public int getX(Rectangle bounds,double xMargin,double yMargin) {
			return bounds.x + (int) Math.round(bounds.width * xMargin);
	}

	public int getY(Rectangle bounds,double xMargin,double yMargin) {
			return bounds.y + (int) Math.round(bounds.height * yMargin);
	}
    public void setPoint(int i,int j,double x,double y){
        d[i] = x;
        d[j] = y;
    }
    @Override
	public void paint (Graphics g) {
//		if (screenImage != null) // if screenImage is not null (image loaded and ready)
//			g.drawImage(screenImage, // draw it
//						w/2 - screenImage.getWidth(this) / 2, // at the center
//						h/2 - screenImage.getHeight(this) / 2, // of screen
//						this);
       // super.paint(g);
		//	((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if(status == 0){
           int x = this.getX(bounds,0.1,0.9) - bounds.x;
		   int y = this.getY(bounds,0.1,0.9) - bounds.y;
               x =  x - CROSS_HAIR.getWidth(null)/2 + 1;
               y =  y - CROSS_HAIR.getHeight(null)/2 + 1;
           d[14] =  (double)x;
           d[15] =  (double)y;
		   g.drawImage(CROSS_HAIR, x, y , null);
        }else if(status == 1){
           int x = this.getX(bounds,0.1,0.9) - bounds.x;
		   int y = this.getY(bounds,0.1,0.9) - bounds.y;
//           setPoint(8,9,x,y);
		   g.drawImage(VISIBLE, x - VISIBLE.getWidth(null)/2 + 1, y - VISIBLE.getHeight(null)/2 + 1, null);
            x =this.getX(bounds,0.1,0.1) - bounds.x;
		    y =this.getY(bounds,0.1,0.1) - bounds.y;
		    x =  x - CROSS_HAIR.getWidth(null)/2 + 1;
            y =  y - CROSS_HAIR.getHeight(null)/2 + 1;
           d[8] =  (double)x;
           d[9] =  (double)y;
		   g.drawImage(CROSS_HAIR, x, y , null);
        }else if(status == 2){
           int x =this.getX(bounds,0.1,0.1) - bounds.x;
		   int y =this.getY(bounds,0.1,0.1) - bounds.y;

//            setPoint(10,11,x,y);
           g.drawImage(VISIBLE, x - VISIBLE.getWidth(null)/2 + 1, y - VISIBLE.getHeight(null)/2 + 1, null);
            x = this.getX(bounds,0.9,0.1) - bounds.x;
		    y = this.getY(bounds,0.9,0.1) - bounds.y;
		    x =  x - CROSS_HAIR.getWidth(null)/2 + 1;
            y =  y - CROSS_HAIR.getHeight(null)/2 + 1;
           d[10] =  (double)x;
           d[11] =  (double)y;
		   g.drawImage(CROSS_HAIR, x, y , null);
        }else if(status == 3){
           int x = this.getX(bounds,0.9,0.1) - bounds.x;
		   int y = this.getY(bounds,0.9,0.1) - bounds.y;
//            setPoint(12,13,x,y);
           g.drawImage(VISIBLE, x - VISIBLE.getWidth(null)/2 + 1, y - VISIBLE.getHeight(null)/2 + 1, null);
            x = this.getX(bounds,0.9,0.9) - bounds.x;
		    y = this.getY(bounds,0.9,0.9) - bounds.y;
		    x =  x - CROSS_HAIR.getWidth(null)/2 + 1;
            y =  y - CROSS_HAIR.getHeight(null)/2 + 1;
           d[12] =  (double)x;
           d[13] =  (double)y;
		   g.drawImage(CROSS_HAIR, x, y , null);
        }else if(status == 4){
           int x = this.getX(bounds,0.9,0.9) - bounds.x;
		   int y = this.getY(bounds,0.9,0.9) - bounds.y;
//           setPoint(12,13,x,y);
           g.drawImage(VISIBLE, x - VISIBLE.getWidth(null)/2 + 1, y - VISIBLE.getHeight(null)/2 + 1, null);
        }
	}
  
}
