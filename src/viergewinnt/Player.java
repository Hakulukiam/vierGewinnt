/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viergewinnt;

/**
 *
 * @author Marcel
 */
public class Player {
    
    private Player playerOne;
    private Player playerTwo;
    private Player score;
    
    public Player getPlayerOne() {
        return this.playerOne;
    }
    
    public Player getPlayerTwo() {
        return this.playerTwo;
    }
    
    public Player getScore() {
        return this.score;
    }
    
    public void setPlayerOne(Player e) {
        this.playerOne = e;
    }
    
     public void setPlayerTwo(Player e) {
        this.playerTwo = e;
    }
     
      public void setScore(Player e) {
        this.score = e;
    }
      
}
