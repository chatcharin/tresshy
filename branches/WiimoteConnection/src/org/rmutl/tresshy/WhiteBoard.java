/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.rmutl.tresshy;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.media.jai.PerspectiveTransform;
import org.rmutl.tresshy.calibration.ScreenFrame;
import org.rmutl.tresshy.mouse.RobotMouse;
import wiiremotej.IRLight;
import wiiremotej.WiiRemote;
import wiiremotej.WiiRemoteJ;
import wiiremotej.event.WRIREvent;
import wiiremotej.event.WRStatusEvent;

/**
 *
 * @author catchajaa
 */
public class WhiteBoard {
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
   public WhiteBoard(){
        i = 0;
        j = 1;
        screensize = "1280 x 800";
        calibrat = true;
        sleep = true;
        mouse = new RobotMouse();
        try {
            screen = new ScreenFrame();
        } catch (MalformedURLException ex) {
            Logger.getLogger(WiiMote.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void  calibration(double x,double y,double size){
        if(index < 30 && (index != 3)){
            index++;
        }else if(calibrat && (index==3)){
          screen.setPoint(i,j,x,y);
          calibrat = screen.nextState();
          screen.refresh();
          if(!calibrat)
          {
            perspective = screen.calculateTransformation();
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
        if(!calibrat)
           mouse.mouseClick(perspective.transform(new IRDot(1,x,y,size),null));
    }

    public void select(int select){
        this.select = select;
    }

    public void run(){
        switch(select){
              case  0:wiimote = new WiiMote(this) ;
              case  1:webcam  = new WebCam(this);
              case  2:wiimote = new WiiMote(this);
              default:wiimote = new WiiMote(this);
        }
    }

    public void disconnect(){
         switch(select){
              case  0:wiimote.disConnection() ;
              case  1:webcam.disConnection();
              case  2:wiimote.disConnection();
              default:wiimote.disConnection();
        }
    }

    public void connect(){
        switch(select){
              case  0:wiimote.connection() ;
              case  1:webcam.connection();
              case  2:wiimote.connection();
              default:wiimote.connection();
        }
    }

    public String getScreenSize() {
        return screensize;
    }
}
