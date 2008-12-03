/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package wiimoteconnection;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import wiiremotej.IRLight;
import wiiremotej.WiiRemote;
import wiiremotej.WiiRemoteJ;
import wiiremotej.event.WRIREvent;
import wiiremotej.event.WiiRemoteAdapter;

/**
 *
 * @author catchajaa
 */
public class Wiimote {
   private WiiRemote remote ;
   private WiiRemoteAdapter aListener ;
   private double size;
   private double x;
   private double y;
   private int    irmode;

    public Wiimote(){
        try {
            remote = WiiRemoteJ.findRemote();
            aListener = new WiiRemoteAdapter() {
             @Override
             public void IRInputReceived(WRIREvent evt)
             {
                 for (IRLight light : evt.getIRLights())
                 {
                     if (light != null)
                     {
                         System.out.println("X: "+light.getX());
                         System.out.println("Y: "+light.getY());
                         System.out.println("Size: "+light.getSize());
                         x    = light.getX();
                         y    = light.getY();
                         size = light.getSize();
                      }
                 }
             }
         };
         remote.addWiiRemoteListener(aListener);
         remote.setIRSensorEnabled(true, WRIREvent.EXTENDED);
         irmode = remote.getIRMode();
        } catch (IllegalStateException ex) {
            Logger.getLogger(Wiimote.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Wiimote.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Wiimote.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public double getSize(){
        return size;
    }
    public int getIRMode(){
        return irmode;
    }
}
