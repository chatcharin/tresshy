/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.rmutl.tresshy;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.media.jai.PerspectiveTransform;
import org.rmutl.tresshy.calibration.ScreenFrame;
import org.rmutl.tresshy.monitor.WiiMonitor;
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
public class WiiMote {
    private WhiteBoard whiteboard;
    private WiiRemote remote;
    private ScreenFrame screen;
    public static boolean calibrat;
    private int i;
    private int j;
    private static PerspectiveTransform perspective;
    private RobotMouse mouse;
    private static final byte[] SENSITIVITY_BLOCK1 = new byte[] { 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, (byte) 0x90, 0x00, 0x41 };
	private static final byte[] SENSITIVITY_BLOCK2 = new byte[] { 0x40, 0x00 };
    public WiiMote(WhiteBoard whitboard){
        this.whiteboard = whitboard;
    }
    public boolean sleep;
    public int index;
    public void disConnection(){
        remote.disconnect();
    }
    public boolean isConnect(){
       return remote.isConnected();
    }
    public void connection(){
        try {
            remote = WiiRemoteJ.findRemote();
        } catch (IllegalStateException ex) {
            Logger.getLogger(WiiMote.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(WiiMote.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(WiiMote.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void calibration(){
        whiteboard.startCalibration();
       try {
                remote.addWiiRemoteListener(new WiiDataHandler(remote) {
                //  remote.se
                @Override
                public void battery(WRStatusEvent evt) {
                    System.out.println("\n Status:"+ evt.getBatteryLevel());
                }

                @Override
                public void wiimote(IRLight linght, double x, double y, double size) {
                    if(calibrat)
                     whiteboard.calibration(x,y,size);
                     whiteboard.action(x,y,size);
                     System.out.println("\n X:"+x+"\n Y:"+y+" \nSize:"+size);
                }
            });
            //remote.setIRSensorEnabled(true, WRIREvent.BASIC, new IRSensitivitySettings(SENSITIVITY_BLOCK1, SENSITIVITY_BLOCK2));
            remote.setIRSensorEnabled(true, WRIREvent.BASIC);
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

   public void showMonitor() {
                new WiiMonitor(remote).setVisible(true);
    }

}
