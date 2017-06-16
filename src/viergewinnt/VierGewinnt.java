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
import javax.swing.*;

public class VierGewinnt extends Applet implements WindowListener {
    
   private static Label upperLabel;
   private static JPanel buttonPanel;
   private static JPanel playPanel;   
   private static JFrame w;
   private static Font font;
   private static JButton[][] field;
   private static final Integer[] SIZE = {7,6};
    
   public static void main(java.lang.String[] args) {      
      VierGewinnt applet = new VierGewinnt();
      font = new Font ("Tahoma", Font.BOLD, 25);
      field = new JButton[SIZE[0]][SIZE[1]];
      w = new JFrame("Vier Gewinnt");
      w.addWindowListener(applet);         
      w.setSize(940, 630);
      w.setResizable(false);
      
      upperLabel = new Label();   
      upperLabel.setAlignment(Label.CENTER);
      upperLabel.setSize(250,100);
      upperLabel.setLocation(700, 0);
      upperLabel.setFont(font);
      upperLabel.setText("Vier Gewinnt!");
      
      JButton newGameButton = new JButton("Neues Spiel");
      newGameButton.setBackground(new Color(255, 140, 0));
      newGameButton.setForeground(Color.WHITE);
      newGameButton.setFocusPainted(false);
      newGameButton.setFont(new Font("Tahoma", Font.BOLD, 12));      
      JButton closeButton = new JButton("Beenden");
      closeButton.setBackground(new Color(255, 140, 0));
      closeButton.setForeground(Color.WHITE);
      closeButton.setFocusPainted(false);
      closeButton.setFont(new Font("Tahoma", Font.BOLD, 12));
      

      newGameButton.addActionListener((ActionEvent e) -> {
          upperLabel.setText("Neues Spiel");
      });

      closeButton.addActionListener((ActionEvent e) -> {
          w.dispose();
      });
      
      buttonPanel = new JPanel();
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
      buttonPanel.setLocation(700, 400);
      
      playPanel = new JPanel();
      playPanel.setLayout(new GridBagLayout());      
      playPanel.setSize(700, 600);
      playPanel.setLocation(0, 0);    
      gbc = new GridBagConstraints();
      gbc.ipadx = 65;
      gbc.ipady = 90;
      
      for(int i=0; i<field.length; i++) {
        for(int j=0; j<field[i].length; j++) {
            field[i][j] = new JButton();
            field[i][j].setBackground(Color.WHITE);            
            gbc.gridx = i;
            gbc.gridy = j;
            final int y = j;
            final int x = i;
            field[i][j].addActionListener((ActionEvent e) -> {
                if(field[x][y].getBackground() == Color.RED){
                    field[x][y].setBackground(Color.YELLOW);
                }else{
                    field[x][y].setBackground(Color.RED);
                }                
            });
            playPanel.add(field[i][j], gbc);
        }
      }   
           
      w.add(buttonPanel);
      w.add(upperLabel);
      w.add(playPanel);        
      w.add(applet);   
      
      JPanel glass = new JPanel(){          
          @Override
          public void paint(Graphics g) {
              Image image;
              try {
                  image = ImageIO.read(new File("vierGewinntBoardSmall.png"));
                  g.drawImage(image, 0, 0, null);
              } catch (IOException ex) {
                  Logger.getLogger(VierGewinnt.class.getName()).log(Level.SEVERE, null, ex);
              } 
          }
      };
      glass.setSize(940, 630);
      glass.setLocation(0, 0);    
      w.setGlassPane(glass);
      glass.setVisible(true);  
      glass.setOpaque(false);    
       
      //Show the window.
      w.setVisible(true);      
      applet.init();
      applet.start();
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