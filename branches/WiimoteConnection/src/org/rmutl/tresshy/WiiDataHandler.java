/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.rmutl.tresshy;

import wiiremotej.IRLight;
import wiiremotej.WiiRemote;
import wiiremotej.event.WRIREvent;
import wiiremotej.event.WRStatusEvent;
import wiiremotej.event.WiiRemoteAdapter;

/**
 *
 * @author catchajaa
 */
public abstract   class WiiDataHandler extends WiiRemoteAdapter {
   private WiiRemote remote;
   abstract  public void battery(WRStatusEvent evt);
   abstract  public void wiimote(IRLight linght,double x,double y,double size);
   public WiiDataHandler(WiiRemote remote)
    {
        this.remote = remote;
    }

    @Override
    public void statusReported(WRStatusEvent evt)
    {
       battery(evt);
    }
    @Override
    public void IRInputReceived(WRIREvent evt)
    {
       for (IRLight light : evt.getIRLights())
        {
            if (light != null)
            {
                wiimote(light,light.getX(),light.getY(),light.getSize());
            }
        }

    }
}
