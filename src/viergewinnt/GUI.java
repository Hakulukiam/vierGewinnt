
package viergewinnt;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 
 * @author Marcel Clemeur 4840095 Gruppe 2C
 */
public class GUI extends Applet implements WindowListener {
    
    private Game game;
    private static JFrame window;     
    private static JPanel buttonPanel;
    private static JPanel playPanel;  
    private static JPanel infoPanel;
    private static JPanel inputPanel;   
    private static Label upperLabel;
    private static Label turnLabel;
    private static Label scorep1; 
    private static Label scorep2; 
    private static Label p1; 
    private static Label p2;
    private static Label Timer; 
    private static JButton newGameButton;
    private static JButton startGameButton;
    private static JButton resetGameButton;
    private static JButton closeButton;
    private static JTextField playerOneName;
    private static JTextField playerTwoName;
    private static Font font;
    private static JButton[][] field;
    /**
     * Hier wird das Fenster hergestellt von dem Spiel
     * @param game wird uebergeben
     */
    public GUI(Game game) {
        this.game = game;
        font = new Font("Tahoma", Font.BOLD, 25);
        field = new JButton[this.game.getSize()[0]][this.game.getSize()[1]];
        window = new JFrame("Vier Gewinnt");      
        window.setSize(940, 630);
        window.setResizable(false);
        Image image;
        try {
            image = ImageIO.read(new File("TokenYellow.png"));
            window.setIconImage(image);
        } catch (IOException ex) {
            Logger.getLogger(VierGewinnt.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.buildFrame();
        this.createComponents();
        this.addEvents();
        this.initComponents();
    }
    
    private void buildFrame() {
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());
        buttonPanel.setSize(240, 200);
        buttonPanel.setLocation(700, 400);
        playPanel = new JPanel();
        playPanel.setLayout(new GridBagLayout());      
        playPanel.setSize(700, 600);
        playPanel.setLocation(0, 0);
        infoPanel = new JPanel();
        infoPanel.setLayout(new GridBagLayout());      
        infoPanel.setSize(240, 300);
        infoPanel.setLocation(700, 0);
        infoPanel.setVisible(false);
        inputPanel = new JPanel();
        inputPanel.setLayout(new GridBagLayout());      
        inputPanel.setSize(240, 300);
        inputPanel.setLocation(700, 100);
        inputPanel.setVisible(false);
        
        JPanel glass = new JPanel() {            
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
    }
    
    private void createComponents() {       
        upperLabel = new Label();   
        upperLabel.setAlignment(Label.CENTER);
        upperLabel.setSize(250, 100);
        upperLabel.setLocation(700, 0);
        upperLabel.setFont(font);
        upperLabel.setText("Vier Gewinnt!");
        
        turnLabel = new Label();
        turnLabel.setAlignment(Label.CENTER);
        turnLabel.setFont(new Font("Tahoma", Font.BOLD, 20));        
        
        scorep1 = new Label();   
        scorep1.setAlignment(Label.CENTER);
        scorep1.setFont(new Font("Tahoma", Font.BOLD, 20));
        scorep1.setForeground(Color.RED);        
        
        scorep2 = new Label();   
        scorep2.setAlignment(Label.CENTER);
        scorep2.setFont(new Font("Tahoma", Font.BOLD, 20));
        scorep2.setForeground(Color.YELLOW);
        
        Timer = new Label();   
        Timer.setAlignment(Label.CENTER);
        Timer.setFont(new Font("Tahoma", Font.BOLD, 20));
        Timer.setForeground(Color.BLACK);

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
        startGameButton.setVisible(false);
        
        resetGameButton = new JButton("Reset Score");
        resetGameButton.setBackground(new Color(255, 140, 0));
        resetGameButton.setForeground(Color.WHITE);
        resetGameButton.setFocusPainted(false);
        resetGameButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        resetGameButton.setVisible(false);
        
        //Input Panel
        GridBagConstraints gbc = new GridBagConstraints();
        playerOneName = new JTextField("Player 1");
        Label p1Label = new Label("Spieler 1 Name:");         
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 90;
        gbc.ipady = 15;
        gbc.gridx = 0;
        gbc.gridy = 0;          
        inputPanel.add(p1Label, gbc);
        gbc.gridy = 1;
        inputPanel.add(playerOneName, gbc);        
        Label p2Label = new Label("Spieler 2 Name:"); 
        gbc.insets = new Insets(10, 0, 0, 0);
        gbc.gridy = 2;
        playerTwoName = new JTextField("Player 2");
        inputPanel.add(p2Label, gbc);
        gbc.gridy = 3;
        inputPanel.add(playerTwoName, gbc);    
        
        //Score Panel
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        p1 = new Label("Spieler 1"); 
        p1.setAlignment(Label.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 0; 
        infoPanel.add(p1, gbc);        
        Label space = new Label("  "); 
        gbc.gridx = 1; 
        infoPanel.add(space, gbc);
        p2 = new Label("Spieler 2");
        p2.setAlignment(Label.CENTER);
        gbc.gridx = 2;
        infoPanel.add(p2, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        infoPanel.add(scorep1, gbc);        
        gbc.gridx = 1; 
        infoPanel.add(space, gbc);      
        gbc.gridx = 2; 
        infoPanel.add(scorep2, gbc);        
        gbc.gridwidth = 3;
        gbc.gridx = 0;
        gbc.gridy = 3; 
        infoPanel.add(turnLabel, gbc);  
        gbc.gridwidth = 3;
        gbc.gridx = 0;
        gbc.gridy = 4; 
        infoPanel.add(Timer, gbc);  
        
        
        //Button Panel
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 3;
        gbc.ipadx = 80;
        gbc.ipady = 15;
        gbc.gridx = 0;
        gbc.gridy = 0;
        buttonPanel.add(newGameButton, gbc);
        gbc.insets = new Insets(10, 0, 0, 0);
        gbc.gridy = 1;
        buttonPanel.add(startGameButton, gbc);
        gbc.insets = new Insets(10, 0, 0, 0);
        gbc.gridy = 2;
        buttonPanel.add(resetGameButton, gbc);
        gbc.insets = new Insets(10, 0, 0, 0);
        gbc.gridy = 3;
        buttonPanel.add(closeButton, gbc);
        
        //Play Panel
        gbc = new GridBagConstraints();
        gbc.ipadx = 65;
        gbc.ipady = 90;

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                field[i][j] = new JButton();
                field[i][j].setBackground(Color.WHITE);              
                gbc.gridx = i;
                gbc.gridy = j;
                playPanel.add(field[i][j], gbc);
            }
        }
    }
    
    private void addEvents() {
        newGameButton.addActionListener((ActionEvent e) -> {
            infoPanel.setVisible(false);
            inputPanel.setVisible(true);
            newGameButton.setVisible(false);
            resetGameButton.setVisible(false);
            startGameButton.setVisible(true);
            upperLabel.setText("Vier Gewinnt!");            
            game.newGame(); 
        });
        
        startGameButton.addActionListener((ActionEvent e) -> {
            infoPanel.setVisible(true);
            newGameButton.setVisible(true);
            inputPanel.setVisible(false);
            startGameButton.setVisible(false);
            resetGameButton.setVisible(true);
            upperLabel.setText("Score:");                      
            game.startGame(playerOneName.getText(), playerTwoName.getText());
            p1.setText(this.game.getPlayerOne().getName());
            p2.setText(this.game.getPlayerTwo().getName());
            this.updateScore();              
        });

        closeButton.addActionListener((ActionEvent e) -> {
            window.dispose();
            System.exit(0);
        });
        
        resetGameButton.addActionListener((ActionEvent e) -> {            
            game.reset();
        });
        
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                final int y = j;
                final int x = i;
                field[i][j].addActionListener((ActionEvent e) -> {
                    game.makeMove(x, y);              
                });
            }
        }
        
    }
    
    private void initComponents() {
        window.add(buttonPanel);
        window.add(upperLabel);
        window.add(infoPanel);
        window.add(inputPanel);
        window.add(playPanel);        
        window.add(this);
        window.setVisible(true);      
        this.init();
        this.start();
    }
    /**
     * Hier wird das GUI vom Spielfeld nach jeden Zug geupdatet
     */
    public void updateGUI() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                switch (game.getCurrentFieldStatus(i, j)) {
                    case 0:
                        field[i][j].setBackground(Color.WHITE);
                        break;
                    case 1:
                        field[i][j].setBackground(Color.RED);
                        break;                    
                    case 2:
                        field[i][j].setBackground(Color.YELLOW);
                        break;
                }                         
            }
        }    
    }
    
    public void updateTimer(Integer time, Integer avalaible){
        int seconds = (int) (time / 1000) % 60 ;
        int milisec = (int) (time - seconds*1000) / 10;
        int a_seconds = (int) (avalaible / 1000) % 60 ;
        int a_milisec = (int) (avalaible - a_seconds*1000) / 10;
        Timer.setText(seconds+ ":" +milisec+ " / "+ a_seconds +":"+ a_milisec);
    }
    
    /**
     * Hier wird ausgegeben welcher Spieler am Zug ist
     */
    public void setPlayer() {
        if (this.game.getCurrentTurn() == 1) {
            turnLabel.setText(game.getPlayerOne().getName() + " ist am Zug");
        }
        if (this.game.getCurrentTurn() == 2) {
            turnLabel.setText(game.getPlayerTwo().getName() + " ist am Zug");
        }
    }
    /**
     * Hier wird der score der Spieler zurueckgegeben
     */
    public void updateScore() {
        scorep1.setText(this.game.getPlayerOne().getScore().toString());
        scorep2.setText(this.game.getPlayerTwo().getScore().toString());
    }

    @Override
    public void windowOpened(WindowEvent we) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosing(WindowEvent we) {
        window.dispose();
        System.exit(0);
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