package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javacamera.VideoDisplay;
import javax.media.CannotRealizeException;
import javax.media.NoPlayerException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JToggleButton;

//import mouse.MouseControl;
//import calibration.CalibrationFrame;
//import calibration.calibrateWebcam;

public class GUI extends JFrame{
	
	
	static Toolkit t;
	private static final long serialVersionUID = 1L;
	public static VideoDisplay vp = new VideoDisplay();
	//public static IRDotPanel ip = new IRDotPanel();
	static boolean init = false;
	public static JLabel status;
	public static JToggleButton cal;
	JButton cam;
	JButton dot;
	
	public static Thread mc;
//	public static CalibrationFrame cf;
	public static JSlider irsens;

	
	
	public GUI(){
	
		
		JPanel buttons = new JPanel();
		JPanel bottom = new JPanel();

		irsens = new JSlider();
		irsens.setPaintTicks(true);
		irsens.setMajorTickSpacing(20);
		irsens.setPaintLabels(true);
		irsens.setValue(30);
		irsens.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"IR-Sensivity"));
	
		cal = new JToggleButton("start calibration");
		cam = new JButton("Cam Monitor");
		dot = new JButton("IRDot Monitor");
		buttons.add(cal);
		buttons.add(cam);
		buttons.add(dot);
		buttons.setBorder(BorderFactory.createEtchedBorder());

		status = new JLabel();

		bottom.add(status);
		
		
		add(buttons, BorderLayout.NORTH);
		add(bottom, BorderLayout.SOUTH);
		
		t = Toolkit.getDefaultToolkit();
		JFrame d = new JFrame();
		d.setResizable(false);
		d.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel l = new JLabel("Connecting to capture device...");
		d.setTitle("Status");
		JPanel dp = new JPanel();
		dp.add(l);
		d.add(dp);
		d.pack();
		d.setVisible(true);
		d.setLocation((int)(t.getScreenSize().getWidth()-d.getWidth())/2,(int)(t.getScreenSize().getHeight()-d.getHeight())/2);	
		connectToWebcam();
		d.dispose();

		
		cal.addActionListener(new ActionListener(){

			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
//				if(cal.getText() == "start calibration")
//				{
//					cf = new CalibrationFrame();
//
//
//					cal.setText("reset");
//					calibrateWebcam.setTouchScreenVertices();
//					mc = new Thread(new MouseControl());
//					mc.start();
//				} else {
//					status.setText("Ready for calibration.");
//					mc.stop();
//					calibrateWebcam.resetCalibration();
//					cal.setText("start calibration");
//				}
//


			}
			
		});
		cam.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {

					JFrame camd = new JFrame();
					Dimension d = new Dimension(300,260);
					vp.setPreferredSize(d);
					vp.setSize(d);
					vp.setBorder(BorderFactory.createEtchedBorder());
					camd.add(vp);
					camd.setSize(350,310);
					camd.setLocation(100,220);
					camd.setVisible(true);
					camd.setTitle("Cam Monitor");
					camd.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);			
					camd.setAlwaysOnTop(true);
				
				
			}
			
		});
		dot.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
//				JFrame camd = new JFrame();
//				Dimension d = new Dimension(300,260);
//
//				ip.setPreferredSize(d);
//				ip.setSize(d);
//				ip.setBorder(BorderFactory.createEtchedBorder());
//				ip.setBackground(Color.BLACK);
//				JPanel camPanel = new JPanel();
//				camPanel.add(ip, BorderLayout.NORTH);
//				camPanel.add(irsens, BorderLayout.SOUTH);
//				camd.add(camPanel);
////				camd.add(ip);
////				camd.add(irsens);
//				camd.setSize(350,380);
////				camd.pack();
//				camd.setLocation(100,200);
//				camd.setVisible(true);
//				camd.setTitle("IRDot Monitor");
//				camd.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//				camd.setAlwaysOnTop(true);
			}
			
		});
		
		
	
		
	}
	

	
	public void connectToWebcam()
	{
		
		try {	
			init = vp.initialise();
			if(init == true)
				{
//					wiicam.setEnabled(false);
					status.setText("Connected to capture device! Ready for calibration.");
					setVisible(true);
				} else {
					System.exit(0);
				}
		} catch (NoPlayerException e) {
			JOptionPane.showMessageDialog(null, "Could not connect to capture device!");
			System.exit(0);
		} catch (CannotRealizeException e) {
			JOptionPane.showMessageDialog(null, "Could not connect to capture device!");
			System.exit(0);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Could not connect to capture device!");
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		GUI g = new GUI();
		g.setTitle("Webcam-Whiteboard v0.3.1");
		g.pack();
		g.setLocation((int)(t.getScreenSize().getWidth()-g.getWidth())/2,(int)(t.getScreenSize().getHeight()-g.getHeight())/2);
		g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		g.setResizable(false);
		
	}

	
	

}
