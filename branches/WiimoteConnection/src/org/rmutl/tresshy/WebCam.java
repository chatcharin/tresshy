/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.rmutl.tresshy;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.geom.Point2D;
import java.io.IOException;
import java.util.Vector;
import javax.media.CannotRealizeException;
import javax.media.NoPlayerException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import org.rmutl.tresshy.camera.CameraAdapter;
import org.rmutl.tresshy.camera.CameraIRDot;
import org.rmutl.tresshy.camera.VideoDisplay;

/**
 *
 * @author catchajaa
 */
public class WebCam {
private CameraAdapter adapter;
static Toolkit t;
public static JSlider irsens;
static boolean init = false;
private static final long serialVersionUID = 1L;
public static VideoDisplay vp = new VideoDisplay();
private WhiteBoard whiteboard;
private boolean calibrat;
public WebCam(WhiteBoard whiteboard){
       this.whiteboard = whiteboard;
       irsens = new JSlider();
		irsens.setPaintTicks(true);
		irsens.setMajorTickSpacing(20);
		irsens.setPaintLabels(true);
		irsens.setValue(70);
     //  adapter = new CameraAdapter();
}
public void connection(){
 	try {
			init = vp.initialise();
			if(init == true)
				{
//					wiicam.setEnabled(false);
					System.out.println("Connected to capture device! Ready .");
				//	setVisible(true);
				} else {
					System.exit(0);
				}
		} catch (NoPlayerException e) {
			JOptionPane.showMessageDialog(null, "Could not connect to capture device!");
			System.exit(0);
		} catch (CannotRealizeException e) {
			JOptionPane.showMessageDialog(null, "Could not connect to capture device!");
			System.exit(0);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Could not connect to capture device!");
			System.exit(0);
		}
    p = new Thread(new process());
 //   adapter = new CameraAdapter();
}
public void disConnection(){
    vp.disconnect();
}
@SuppressWarnings("unchecked")
    private Vector <Double> vertices = new Vector();
	private Thread p;

  public  void calibration() {
        p.start();
    }

	public  class process extends Thread
	{
        @Override
		public void run()
		{
           while(true){
			boolean tip = false;
            Vector <Point2D> irdot = CameraIRDot.getIRDotCoords();
           if(irdot.size()>0){
                  System.out.println("irdot"+irdot.elementAt(0).getX());
                    whiteboard.calibration(irdot.elementAt(0).getX(),irdot.elementAt(0).getY(),irdot.size());
                    whiteboard.action(irdot.elementAt(0).getX(),irdot.elementAt(0).getY(),irdot.size());
			} else if(irdot.size()==0){
				    tip = false;
			}

        }
		}
	}

	@SuppressWarnings("deprecation")
	public  void resetCalibration()
	{
		p.stop();
		vertices.clear();
	}

	public  Vector<Double> getCurrentVertices()
	{
		return vertices;
	}
    public void showMonitor(){
        JFrame monitor =   new JFrame("WebCam Monitor");
        Dimension d = new Dimension(300,260);
        vp.setPreferredSize(d);
        vp.setSize(d);
        monitor.add(vp);
		monitor.setVisible(true);
        System.out.println(" hello world");
     

    }
}
