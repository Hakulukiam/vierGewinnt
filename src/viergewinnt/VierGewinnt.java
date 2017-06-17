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
    private static JFrame window;    
    private static JButton newGameButton;
    private static JButton startGameButton;
    private static JButton closeButton;
    private static Font font;
    private static VierGewinnt app;
    private static JButton[][] field;
    private static final Integer[] SIZE = {7,6};


    public static void main(java.lang.String[] args) {      
    app = new VierGewinnt();
    font = new Font ("Tahoma", Font.BOLD, 25);
    field = new JButton[SIZE[0]][SIZE[1]];
    window = new JFrame("Vier Gewinnt");
    window.addWindowListener(app);         
    window.setSize(940, 630);
    window.setResizable(false);
    Image image;
    try {
        image = ImageIO.read(new File("TokenYellow.png"));
        window.setIconImage(image);
    } catch (IOException ex) {
        Logger.getLogger(VierGewinnt.class.getName()).log(Level.SEVERE, null, ex);
    } 
    upperLabel = new Label();   
    upperLabel.setAlignment(Label.CENTER);
    upperLabel.setSize(250,100);
    upperLabel.setLocation(700, 0);
    upperLabel.setFont(font);
    upperLabel.setText("Vier Gewinnt!");

    newGameButton = new JButton("Neues Spiel");
    newGameButton.setBackground(new Color(255, 140, 0));
    newGameButton.setForeground(Color.WHITE);
    newGameButton.setFocusPainted(false);
    newGameButton.setFont(new Font("Tahoma", Font.BOLD, 12));      
    closeButton = new JButton("Beenden");
    closeButton.setBackground(new Color(255, 140, 0));
    closeButton.setForeground(Color.WHITE);
    closeButton.setFocusPainted(false);
    closeButton.setFont(new Font("Tahoma", Font.BOLD, 12));
    startGameButton = new JButton("Starte Spiel");
    startGameButton.setBackground(new Color(255, 140, 0));
    startGameButton.setForeground(Color.WHITE);
    startGameButton.setFocusPainted(false);
    startGameButton.setFont(new Font("Tahoma", Font.BOLD, 12)); 

    newGameButton.addActionListener((ActionEvent e) -> {
       app.newGame(); 
    });

    closeButton.addActionListener((ActionEvent e) -> {
        window.dispose();
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
           playPanel.add(field[i][j],gbc);
           final int y = j;
           final int x = i;
           field[i][j].addActionListener((ActionEvent e) -> {
               if(field[x][y].getBackground() == Color.RED){
                   field[x][y].setBackground(Color.YELLOW);
               }else{
                   field[x][y].setBackground(Color.RED);
               }                
           });
        }
    }   

    window.add(buttonPanel);
    window.add(upperLabel);
    window.add(playPanel);        
    window.add(app);   

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
    window.setGlassPane(glass);
    glass.setVisible(true);  
    glass.setOpaque(false);    

    //Show the window.
    window.setVisible(true);      
    app.init();
    app.start();
}
    
private void newGame(){
    upperLabel.setText("Neues Spiel:");
    buttonPanel.remove(newGameButton);    
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.gridwidth = 3;
    gbc.ipadx = 80;
    gbc.ipady = 15;
    gbc.gridx = 0;
    gbc.gridy = 0;
    buttonPanel.add(startGameButton,gbc);
    buttonPanel.revalidate();
    buttonPanel.repaint();    
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