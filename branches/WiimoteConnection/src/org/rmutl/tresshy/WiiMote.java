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
import wiiremotej.IRSensitivitySettings;
import wiiremotej.WiiRemote;
import wiiremotej.WiiRemoteJ;
import wiiremotej.event.WRIREvent;
import wiiremotej.event.WRStatusEvent;

/**
 *
 * @author catchajaa
 */
public class WiiMote {
    private WiiRemote remote;
    private ScreenFrame screen;
    private boolean calibrat;
    private int i;
    private int j;
    private PerspectiveTransform perspective;
    private RobotMouse mouse;
    private static final byte[] SENSITIVITY_BLOCK1 = new byte[] { 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, (byte) 0x90, 0x00, 0x41 };
	private static final byte[] SENSITIVITY_BLOCK2 = new byte[] { 0x40, 0x00 };
    public WiiMote(final WiiRemote remote){
        i = 0;
        j = 1;
        calibrat = true;
        sleep = true;
        mouse = new RobotMouse();
        try {
            screen = new ScreenFrame();
        } catch (MalformedURLException ex) {
            Logger.getLogger(WiiMote.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
//              remote  = WiiRemoteJ.findRemote();
              remote.addWiiRemoteListener(new WiiDataHandler(remote) {
            //  remote.se
                @Override
                public void battery(WRStatusEvent evt) {
                    System.out.println("\n Status:"+ evt.getBatteryLevel());
                }

                @Override
                public void wiimote(IRLight linght, double x, double y, double size) {
                    if(calibrat)
                     WiiCalibration(linght,x,y,size);
                     Wiiaction(linght,x,y,size);
                 System.out.println("\n X:"+x+"\n Y:"+y+" \nSize:"+size);
                }
            });
            remote.setIRSensorEnabled(true, WRIREvent.BASIC, new IRSensitivitySettings(SENSITIVITY_BLOCK1, SENSITIVITY_BLOCK2));
            remote.setLEDIlluminated(0, true);
            new Thread(new Runnable() {
			public void run() {
				while (true) {
					try {
						// triggers #statusReported(WRStatusEvent)
						if (remote.isConnected())
							remote.requestStatus();
					} catch (Exception e) {
						e.printStackTrace();
					//	WiimoteWhiteboard.getLogger().log(Level.WARNING, "Error on requesting status from Wii Remote", e);
					}
					try {
						Thread.sleep(60 * 1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
        } catch (IOException ex) {
            Logger.getLogger(WiiDataHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(WiiDataHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalStateException ex) {
            Logger.getLogger(WiiDataHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    boolean sleep;
    int index;
    public void  WiiCalibration(IRLight light,double x,double y,double size){
        if(index < 30 && (index != 3)){
            index++;
        }else if(calibrat && (index==3)){
          screen.setPoint(i,j,x,y);
          calibrat = screen.nextState();
          screen.refresh();
          if(!calibrat)
          {
            perspective = screen.calculateTransformation();
            screen.setEnabled(false);
          }
          i+=2;
          j+=2;
//       try {
//			Thread.sleep(700);
//		  } catch (InterruptedException e) {
//		  e.printStackTrace();
//		  }
          index++;
        }else if(index > 15){
            index =0;
        }
        // transform
        // Mouse Robot
    }

    public void  Wiiaction(IRLight light,double x,double y,double size){
        if(!calibrat)
        mouse.mouseClick(perspective.transform(new IRDot(1,light),null));
    }
   public static void main(String args[]){
        try {
            new WiiMote(WiiRemoteJ.findRemote());
        } catch (IllegalStateException ex) {
            Logger.getLogger(WiiMote.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(WiiMote.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(WiiMote.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
}
