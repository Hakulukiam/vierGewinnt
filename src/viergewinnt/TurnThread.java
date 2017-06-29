package viergewinnt;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author Marcel Clemeur 4840095 Gruppe 2C
 */
public class TurnThread extends Thread {

    private final Game game;
    final int TURNS = 60000; //Total Turns Duration 30 Sec Long
    private final int time; //Turn avaliable duration
    private int duration; //Turn actual duration
    /**
     *
     * @param game
     * @param time
     */
    public TurnThread(Game game, Integer time) {
        this.game = game;
        this.time = time;
        this.duration = 0;
    }
    
    public TurnThread(Game game) {
        this.game = game;
        this.time = 30000;
        this.duration = 0;
    }
    
    public int changeturn(){
        int newTurnTime = this.TURNS - this.time + this.duration;
        return newTurnTime;
    }
    
    @Override
    public void run(){                   
        do{
            try {
                Thread.sleep(100);
                this.duration = this.duration + 100;
                if(this.duration < this.time){
                    this.game.updateTurnTime(this.duration, this.time);
                }else{
                    this.game.switchPlayer();
                }                
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            if(isInterrupted()){
                break;
            }  
        }while(true);
    }    
}
