package javacamera;

import gui.GUI;

import java.util.Vector;

import javax.media.CaptureDeviceInfo;
import javax.media.CaptureDeviceManager;

import com.sun.media.protocol.vfw.VFWCapture;

public class autoDetect {


	public static CaptureDeviceInfo getDeviceInfo()
	{
		CaptureDeviceInfo devInfo = null;
		String name;
		Vector list = CaptureDeviceManager.getDeviceList(null);

		if(list != null)
		{
			for(int i = 0; i < list.size(); i++)
			{
				devInfo = (CaptureDeviceInfo) list.elementAt(i);
				name = devInfo.getName();


				if(name.startsWith("vfw:"))
				{
					break;
				}
			}

			if(devInfo != null && devInfo.getName().startsWith("vfw:"))
			{
				return devInfo;
			} else {
				for(int i = 0; i < 10; i++)
				{
					name = VFWCapture.capGetDriverDescriptionName(i);
					if(name != null && name.length() > 1)
					{
						devInfo = com.sun.media.protocol.vfw.VFWSourceStream.autoDetect(i);

						if(devInfo != null)
						{
							return devInfo;
						}
					} else {
						GUI.status.setText("Could not connect to the Webcam.");
						return null;
					}

				}
				GUI.status.setText("Could not connect to the Webcam.");
				return null;
			}
		} else {
			GUI.status.setText("Could not connect to the Webcam.");
			return null;
		}


	}



}
