/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package wiimoteconnection;

import wiiremotej.IRLight;
import wiiremotej.WiiRemote;
import wiiremotej.WiiRemoteJ;
import wiiremotej.event.WRIREvent;

/**
 *
 * @author catchajaa
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      try {
         
         WiiRemote remote = WiiRemoteJ.findRemote();
         remote.addWiiRemoteListener(new WRLImpl(remote));
         remote.setAccelerometerEnabled(false);


         remote.setIRSensorEnabled(true, WRIREvent.EXTENDED);


         if (remote.isExtensionEnabled()) System.out.println("Extension enabled");
         else System.out.println("No Extension");

         System.out.println("IR-Mode: "+remote.getIRMode());



      } catch (Exception e) {

         e.printStackTrace();
      }
   }
   public void IRInputReceived(WRIREvent evt)
    {
        for (IRLight light : evt.getIRLights())
        {
            if (light != null)
            {
                System.out.println("X: "+light.getX());
                System.out.println("Y: "+light.getY());
                System.out.println("Size: "+light.getSize());
            }
        }

    }


}
