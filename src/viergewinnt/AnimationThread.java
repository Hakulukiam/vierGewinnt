/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viergewinnt;

import java.awt.Color;

/**
 *
 * @author Markus
 */
public class AnimationThread extends Thread {
    private final GUI gui;
    private final Game game;
    private final Integer turn;
    private final Integer x;    
    
    public AnimationThread(GUI gui, Game game,Integer turn, Integer x) {
        this.gui = gui;
        this.game = game;
        this.turn = turn;
        this.x = x;
    }

    @Override
    public void run(){                   
        do{
            try {
                int d = 0;
                for (int i = 0; i < 6; i++) {
                    if (game.getCurrentFieldStatus(x, i) != 0) {
                        d++;
                    } else {
                        if(x-1 >= 0)gui.getFieldElement(x-1, i).setBackground(Color.WHITE);
                        gui.getFieldElement(x, i).setBackground(Color.WHITE);
                        switch (turn) {
                            case 1:
                                gui.getFieldElement(x, i).setBackground(Color.RED);
                                break;                    
                            case 2:
                                gui.getFieldElement(x, i).setBackground(Color.YELLOW);
                                break;
                        }
                    }  
                    if (d >= 3) { //Try 3 Times
                        Thread.currentThread().interrupt();
                    }                                                                            
                }
                Thread.sleep(500); 
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            if(isInterrupted()){
                break;
            }  
        }while(true);
    }    
}
