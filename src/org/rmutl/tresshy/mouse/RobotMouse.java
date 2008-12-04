/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.rmutl.tresshy.mouse;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.geom.Point2D;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author catchajaa
 */
public class RobotMouse {
    private Robot robot;
    public RobotMouse(){
        try {
            robot = new Robot();
        } catch (AWTException ex) {
            Logger.getLogger(RobotMouse.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   public void mouseClick(int x,int y){
       robot.mouseMove(x, y);
       robot.mousePress(InputEvent.BUTTON1_MASK);
       robot.mouseRelease(InputEvent.BUTTON1_MASK);
   }
   public void mouseClick(Point2D p){
       robot.mouseMove((int)p.getX(),(int)p.getY());
   }
   public void mouseMove(int x,int y){
       robot.mouseMove(x, y);
   }
   public static void main(String args[]){
       new RobotMouse().mouseClick(20, 20);
   }
}
