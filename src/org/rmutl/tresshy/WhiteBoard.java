/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.rmutl.tresshy;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.geom.Point2D;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.media.jai.PerspectiveTransform;
import org.rmutl.tresshy.calibration.ScreenFrame;
import org.rmutl.tresshy.mouse.RobotMouse;

/**
 *
 * @author catchajaa
 */
public class WhiteBoard {
   private MainUI   mainui;
   private  WiiMote wiimote;
   private  WebCam  webcam;
   private  int     EMTY   = 0;
   private  int     WEBCAM = 1;
   private  int     WII    = 2;
   private  int     select;
   private  boolean sleep;
   private  int     index;
   // select Device
   // new Webcam
   // new WiiMote
   // sent X,Y to Calibrat
   // Select Device Camera
   /**
     *  - WiiMote
     *  - Webcam
     *
     *
     *
     *
     *
     * */
   private ScreenFrame screen;
   private String screensize;
   private boolean calibrat;
   private int i;
   private int j;
   private static PerspectiveTransform perspective;
   private RobotMouse mouse;
   public WhiteBoard(MainUI mainui){
        i = 0;
        j = 1;
        this.mainui = mainui;
        screensize  = "1280 x 800";
        WiiMote.calibrat    = true;
        sleep       = true;
        mouse       = new RobotMouse();
    }

	static PerspectiveTransform pt;

	public static void setTransform(double[] src)
	{
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

//		the destination quad is the screen. Because the calibration-points are not the real vertices of the
//		screen, the destination quad is smaller than the screen
		double[] dest = {90,90,screen.width-90,90,screen.width-90,screen.height-90,90,screen.height-90};
		pt = PerspectiveTransform.getQuadToQuad(
				src[0],src[1],src[2],src[3],src[4],src[5],src[6],src[7],
				dest[0],dest[1],dest[2],dest[3],dest[4],dest[5],dest[6],dest[7]);
	}

//	transforms the given point
	public static Point2D getTransformedPoint(Point2D pp)
	{
		if(pt!=null){
			Point2D p =  pt.transform(pp,null);
			return p;
		} else {
			return null;
		}
	}
    public void startCalibration(){
         try {
            screen = new ScreenFrame();
        } catch (MalformedURLException ex) {
            Logger.getLogger(WiiMote.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void  calibration(double x,double y,double size){
        if(index < 30 && (index != 3)){
            index++;
        }else if(WiiMote.calibrat && (index==3)){
          screen.setPoint(i,j,x,y);
          WiiMote.calibrat = screen.nextState();
          screen.refresh();
          if(!WiiMote.calibrat)
          {
            perspective = screen.calculateTransformation();
          //  screen.clean();
          //  screen.setEnabled(false);
            screen.dispose();
            screen.setVisible(false);
          }
          i+=2;
          j+=2;
          index++;
        }else if(index > 15){
            index =0;
        }
        // transform
        // Mouse Robot
    }

    public void  action(double x,double y,double size){
        if(!WiiMote.calibrat)
           mouse.mouseClick(perspective.transform(new IRDot(1,x,y,size),null));
    }

    public void select(int select){
        this.select = select;
    }

    public void run(){
        switch(select){
              case  0:wiimote = new WiiMote(this) ;break;
              case  1:webcam  = new WebCam(this);break;
              case  2:wiimote = new WiiMote(this);break;
              default:wiimote = new WiiMote(this);break;
        }
    }

    public void disconnect(){
         switch(select){
              case  0:wiimote.disConnection();break;
              case  1:webcam.disConnection();break;
              case  2:wiimote.disConnection();break;
              default:wiimote.disConnection();break;
        }
    }

    public void connect(){
        switch(select){
              case  0:wiimote.connection();break;
              case  1:mainui.WebCam();break;
              case  2:wiimote.connection();break;
              default:wiimote.connection();break;
        }
    }

    public String getScreenSize() {
        return screensize;
    }
   public void calibration(){
       switch(select){
              case  0:wiimote.calibration();break;
              case  1:mainui.calibratWebCam();break;
              case  2:wiimote.calibration();break;
              default:wiimote.calibration();break;
        }
   }
   public void showMonitor() {
           switch(select){
              case  0:wiimote.showMonitor();break;
              case  1:mainui.showWebCam();break;
              case  2:wiimote.showMonitor();break;
              default:wiimote.showMonitor();break;
        }
    }
   public boolean isConnect(){
       return  wiimote.isConnect();
   }
}
