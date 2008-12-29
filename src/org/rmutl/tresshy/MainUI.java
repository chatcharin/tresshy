/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MainUI.java
 *
 * Created on Dec 3, 2008, 7:15:55 PM
 */

package org.rmutl.tresshy;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.MetalLookAndFeel;
import org.rmutl.tresshy.camera.CalibrationFrame;
import org.rmutl.tresshy.camera.IRDotPanel;
import org.rmutl.tresshy.camera.MouseControl;
import org.rmutl.tresshy.camera.VideoDisplay;
import org.rmutl.tresshy.camera.calibrateWebcam;

/**
 *
 * @author catchajaa
 */
public class MainUI extends javax.swing.JFrame {
    private static MainUI mainui;
    private WhiteBoard whiteboard;
    private boolean connect;
    private boolean webcamconnect;
    /** Creates new form MainUI */
    public MainUI() {
        initComponents();
        connect = false;
        whiteboard = new WhiteBoard(this);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        buttonMonitor = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        buttonConnect = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        screensize = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        selectdevice = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        jLabel4.setText("jLabel4");

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                mainClose(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Setting"));

        buttonMonitor.setText("Monitor");
        buttonMonitor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMonitorActionPerformed(evt);
            }
        });

        jButton2.setText("Calibration");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        buttonConnect.setText("Connection");
        buttonConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonConnectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonConnect, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                    .addComponent(buttonMonitor, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(buttonConnect)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonMonitor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Status"));

        jLabel1.setText("Battery ");

        jLabel2.setText("WiiID");

        screensize.setText("Display Size :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addComponent(screensize))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(screensize)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Mouse Setting"));

        jCheckBox1.setText("Smooth");
        jCheckBox1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jCheckBox1StateChanged(evt);
            }
        });

        jCheckBox2.setText("ClickRigth");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox1)
                    .addComponent(jCheckBox2))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jCheckBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox2)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        selectdevice.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "WiiMote", "WebCam" }));
        selectdevice.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                selectdeviceItemStateChanged(evt);
            }
        });

        jLabel9.setText("Select Device:");

        jMenu1.setText("File");

        jMenuItem3.setText("Close");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        jMenuItem2.setText("WebCamSetting");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Help?");

        jMenuItem1.setText("About..");
        jMenu3.add(jMenuItem1);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(selectdevice, 0, 67, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectdevice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonMonitorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMonitorActionPerformed
        whiteboard.showMonitor();
}//GEN-LAST:event_buttonMonitorActionPerformed

    private void buttonConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonConnectActionPerformed
     if(!connect){
      whiteboard.select(selectdevice.getSelectedIndex());
      System.out.println("SelectItem"+selectdevice.getSelectedIndex());
      whiteboard.run();
      whiteboard.connect();
      connect = true;
      screensize.setText("Display Size :"+whiteboard.getScreenSize());
     }
}//GEN-LAST:event_buttonConnectActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        whiteboard.calibration();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void selectdeviceItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_selectdeviceItemStateChanged
        if(connect){
            whiteboard.disconnect();
            connect = false;
        }
    }//GEN-LAST:event_selectdeviceItemStateChanged

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        if(webcamconnect)
          webcamSetting();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void mainClose(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_mainClose
         if(connect){
            whiteboard.disconnect();
            connect = false;
        }
         while(true){
             if(!whiteboard.isConnect()){
                  mainui.setVisible(false);
                  System.exit(0);
             }
         }
    }//GEN-LAST:event_mainClose

    private void jCheckBox1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jCheckBox1StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1StateChanged

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
       if(connect){
            whiteboard.disconnect();
            connect = false;
        }
         while(true){
             if(!whiteboard.isConnect()){
                  mainui.setVisible(false);
                  System.exit(0);
             }
         }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {


            mainui =     new MainUI();
            mainui.setVisible(true);
            try
               {
            try {
                // Con questa imposto il tema
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                SwingUtilities.updateComponentTreeUI(mainui);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        catch(UnsupportedLookAndFeelException e)
        {
    	e.printStackTrace();
      }
    }


	static Toolkit t;
	private static final long serialVersionUID = 1L;
	public static VideoDisplay vp = new VideoDisplay();
	public static IRDotPanel ip = new IRDotPanel();
	public static boolean init = false;
	public static JLabel status;
	public static JToggleButton cal;
	JButton cam;
	JButton dot;

	public static Thread mc;
	public static CalibrationFrame cf;
	public static JSlider irsens;



	public void WebCam(){

        webcamconnect = true;
		JPanel buttons = new JPanel();
		JPanel bottom = new JPanel();

		irsens = new JSlider();
		irsens.setPaintTicks(true);
		irsens.setMajorTickSpacing(20);
		irsens.setPaintLabels(true);
		irsens.setValue(70);
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
				if(cal.getText() == "start calibration")
				{
					cf = new CalibrationFrame();


					cal.setText("reset");
					calibrateWebcam.setTouchScreenVertices();
					mc = new Thread(new MouseControl());
					mc.start();
				} else {
					status.setText("Ready for calibration.");
					mc.stop();
					calibrateWebcam.resetCalibration();
					cal.setText("start calibration");
				}



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
				JFrame camd = new JFrame();
				Dimension d = new Dimension(300,260);

				ip.setPreferredSize(d);
				ip.setSize(d);
				ip.setBorder(BorderFactory.createEtchedBorder());
				ip.setBackground(Color.BLACK);
				JPanel camPanel = new JPanel();
				camPanel.add(ip, BorderLayout.NORTH);
				camPanel.add(irsens, BorderLayout.SOUTH);
				camd.add(camPanel);
//				camd.add(ip);
//				camd.add(irsens);
				camd.setSize(350,380);
//				camd.pack();
				camd.setLocation(100,200);
				camd.setVisible(true);
				camd.setTitle("IRDot Monitor");
				camd.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				camd.setAlwaysOnTop(true);
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
    public void showWebCam(){
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
    public void calibratWebCam(){
                    cf = new CalibrationFrame();
					cal.setText("reset");
					calibrateWebcam.setTouchScreenVertices();
					mc = new Thread(new MouseControl());
					mc.start();
    }
   public void webcamSetting(){
            	JFrame camd = new JFrame();
				Dimension d = new Dimension(300,260);

				ip.setPreferredSize(d);
				ip.setSize(d);
				ip.setBorder(BorderFactory.createEtchedBorder());
				ip.setBackground(Color.BLACK);
				JPanel camPanel = new JPanel();
				camPanel.add(ip, BorderLayout.NORTH);
				camPanel.add(irsens, BorderLayout.SOUTH);
				camd.add(camPanel);
//				camd.add(ip);
//				camd.add(irsens);
				camd.setSize(350,380);
//				camd.pack();
				camd.setLocation(100,200);
				camd.setVisible(true);
				camd.setTitle("IRDot Monitor");
				camd.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				camd.setAlwaysOnTop(true);
   }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonConnect;
    private javax.swing.JButton buttonMonitor;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JLabel screensize;
    private javax.swing.JComboBox selectdevice;
    // End of variables declaration//GEN-END:variables

}