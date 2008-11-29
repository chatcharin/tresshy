/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package wiimoteconnection;

import wiiremotej.IRLight;
import wiiremotej.WiiRemote;
import wiiremotej.WiiRemoteJ;
import wiiremotej.event.WRIREvent;
import wiiremotej.event.WiiRemoteAdapter;

/**
 *
 * @author catchajaa
 */
public class IRtest {
public static void main(String[] args) {
    double point_1;
    double point_2;
    double point_3;
    double point_4;
      try {

         WiiRemote remote = WiiRemoteJ.findRemote();
         WiiRemoteAdapter aListener = new WiiRemoteAdapter()
         {
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
                      }
                 }
             }
         };
         remote.addWiiRemoteListener(aListener);
         remote.setIRSensorEnabled(true, WRIREvent.EXTENDED);
         System.out.println("IR-Mode: "+remote.getIRMode());
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}
