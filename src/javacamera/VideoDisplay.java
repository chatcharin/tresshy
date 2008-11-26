/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package javacamera;


import gui.GUI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.media.Buffer;
import javax.media.CannotRealizeException;
import javax.media.CaptureDeviceInfo;
import javax.media.Format;
import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.NoPlayerException;
import javax.media.Player;
import javax.media.control.FormatControl;
import javax.media.control.FrameGrabbingControl;
import javax.media.format.VideoFormat;
import javax.media.util.BufferToImage;
import javax.swing.JPanel;



public class VideoDisplay extends JPanel {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	protected Component visualComponent = null;
	protected MediaLocator ml = null;
	protected CaptureDeviceInfo devInfo = null;
	protected Player player = null;
	protected FormatControl formatControl = null;
	protected Format[] videoFormats = null;
	protected Format currentFormat = null;

	public boolean initialise() throws NoPlayerException, CannotRealizeException, IOException
	{

		devInfo = autoDetect.getDeviceInfo();

		if(devInfo != null)
		{
			ml = devInfo.getLocator();

			if(ml != null)
			{
				player = Manager.createRealizedPlayer(ml);

				if (player != null)
				{
					player.start();
					visualComponent = player.getVisualComponent();

					add(visualComponent, BorderLayout.CENTER);
					return true;
				} else {
					GUI.status.setText("Could not connect to the Webcam.");
					return false;
				}
			} else {
				GUI.status.setText("Could not connect to the Webcam.");
				return false;
			}
		} else {
			GUI.status.setText("Could not connect to the Webcam.");
			return false;
		}


	}



	public BufferedImage getImage(){
		BufferedImage image = null;

		FrameGrabbingControl fgc = null;
		Buffer buffer = null;

		if(player != null)
		{
			fgc = (FrameGrabbingControl) player.getControl("javax.media.control.FrameGrabbingControl");

			if(fgc != null)
			{
				buffer = fgc.grabFrame();

				if(buffer != null)
				{
					BufferToImage btoi = new BufferToImage((VideoFormat)buffer.getFormat());
					image = (BufferedImage)btoi.createImage(buffer);
				} else {
					System.err.println("Error : Buffer is null");
					return null;
				}
			} else {
				System.err.println("Error : FrameGrabbingControl is null");
				return null;
			}
		} else {
			System.err.println("Error : Player is null");
			return null;
		}
		return image;
		}

}

