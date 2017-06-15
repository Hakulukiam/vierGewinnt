/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viergewinnt;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class VierGewinnt extends Applet implements WindowListener {
    
   private static Label upperLabel;
   private static Panel buttonPanel;   
   private static Frame w;
   private static Font font;
    
   public static void main(java.lang.String[] args) {      
      VierGewinnt applet = new VierGewinnt();
      font = new Font ("Sans Serif", 1, 25);
      w = new Frame("Vier Gewinnt");
      w.addWindowListener(applet);         
      w.setSize(940, 629);
      w.setResizable(false);      
      
      upperLabel = new Label();        
      upperLabel.setAlignment(Label.CENTER);
      upperLabel.setSize(250,100);
      upperLabel.setLocation(702, 0);
      upperLabel.setBackground(Color.GRAY);
      upperLabel.setForeground(Color.WHITE);
      upperLabel.setFont(font);
      upperLabel.setText("Vier Gewinnt!");
      
      Button newGameButton = new Button("Neues Spiel");
      Button closeButton = new Button("Beenden");
      

      newGameButton.addActionListener((ActionEvent e) -> {
          upperLabel.setText("Neues Spiel");
      });

      closeButton.addActionListener((ActionEvent e) -> {
          w.dispose();
      });
      
      buttonPanel = new Panel();
      buttonPanel.setLayout(new GridBagLayout());
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.fill = GridBagConstraints.HORIZONTAL;
      gbc.gridwidth = 3;
      gbc.ipadx = 80;
      gbc.ipady = 15;
      gbc.gridx = 0;
      gbc.gridy = 0;
      buttonPanel.add(newGameButton,gbc);
      gbc.insets = new Insets(10,0,0,0);
      gbc.gridy = 1;
      buttonPanel.add(closeButton,gbc);      
      buttonPanel.setSize(240, 200);
      buttonPanel.setLocation(702, 400);
      buttonPanel.setBackground(Color.GRAY);
      
      w.add(buttonPanel);
      w.add(upperLabel);
      w.add(applet);
      w.setVisible(true);
      
      applet.init();
      applet.start();
   }

   @Override
   public void paint(Graphics g) {
      super.paint(g);
      Image image;
       try {
           image = ImageIO.read(new File("vierGewinntBoardSmall.png"));
           g.drawImage(image, 0, 0, null);
       } catch (IOException ex) {
           Logger.getLogger(VierGewinnt.class.getName()).log(Level.SEVERE, null, ex);
       }
       g.setColor(Color.gray);
       g.fillRect(699, 0, 250, 600);       
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