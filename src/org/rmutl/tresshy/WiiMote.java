/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.rmutl.tresshy;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    public static void main(String agrs[]){
        try {
            final WiiRemote remote = WiiRemoteJ.findRemote();
            remote.addWiiRemoteListener(new WiiDataHandler(remote) {

                @Override
                public void battery(WRStatusEvent evt) {
                    System.out.println("\n Status:"+ evt.getBatteryLevel());
                }

                @Override
                public void wiimote(IRLight linght, double x, double y, double size) {
                    System.out.println("\n X:"+x+"\n Y:"+y+" \nSize:"+size);
                }
            });
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
        } catch (InterruptedException ex) {
            Logger.getLogger(WiiDataHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(WiiDataHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(WiiDataHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalStateException ex) {
            Logger.getLogger(WiiDataHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
