/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viergewinnt;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class VierGewinnt extends Applet implements WindowListener {

   public static void main(java.lang.String[] args) {
      VierGewinnt applet = new VierGewinnt();
      Frame w = new Frame("Applet");
      w.addWindowListener(applet);
      w.add("Center", applet);
      w.setSize(150, 50);
      w.setVisible(true);
      applet.init();
      applet.start();
   }

   @Override
   public void paint(Graphics g) {
      super.paint(g);
      g.drawString("Hello World", 10, 10);	// Upper left corner
   }

   @Override
   public void windowClosing(WindowEvent e) {
      System.exit(0);	// Exit the application when the window is closed
   }

    @Override
    public void windowOpened(WindowEvent we) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosed(WindowEvent we) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowIconified(WindowEvent we) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeiconified(WindowEvent we) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowActivated(WindowEvent we) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeactivated(WindowEvent we) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}