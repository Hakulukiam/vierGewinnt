/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viergewinnt;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Marcel
 */
public class Game {
    
    private Player playerOne;
    private Player playerTwo;
    private Integer currentTurn;
    private GUI gui;
    private Integer[][] field;
    public final Integer[] SIZE = {7,6};

    public Game(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.currentTurn = 1;
        this.field = new Integer[SIZE[0]][SIZE[1]];
        this.resetField();
        this.gui = new GUI(this);
    }
    
    public Player getPlayerOne() {
        return playerOne;
    }

    public void setPlayerOne(Player playerOne) {
        this.playerOne = playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    public void setPlayerTwo(Player playerTwo) {
        this.playerTwo = playerTwo;
    }
    
    public Boolean isValidMove(){
        return true;
    }
    
    public void newGame(){
        
    }
    
    public void startGame(){
        
    }
    
    public void makeMove(Integer x, Integer y){
        if(isValidMove()){
            field[x][y] = this.currentTurn;
            gui.updateGUI();
            if(this.hasWon(x,y)){
                if(currentTurn == 1){
                    playerOne.setScore(playerOne.getScore() + 1);
                }else if(currentTurn == 2){
                    playerTwo.setScore(playerTwo.getScore() + 1);
                }
                gui.updateScore();
                this.resetField();
                gui.updateGUI();
            }else{
                this.switchPlayer(); 
            }
        }       
    }
    
    private void resetField(){
        for (Integer[] row: this.field)
            Arrays.fill(row, 0);
    }
    
    public void reset(){
        this.resetField();
        playerOne.setScore(0);
        playerTwo.setScore(0);
        gui.updateScore();
        gui.updateGUI();
    }
       
    public Boolean hasWon(Integer x, Integer y){
        if(this.checkRows(x,y) == true)return true;
        if(this.checkCols(x,y) == true)return true;
        return this.checkDiagonals(x,y) == true;
    }
    
    private Boolean checkRows(Integer x, Integer y){
        return false;
    }
    
    private Boolean checkCols(Integer x, Integer y){
        return false;
    }
    
    private Boolean checkDiagonals(Integer x, Integer y){
        return false;
    }
    
    public Integer getCurrentFieldStatus(Integer x, Integer y){
        return field[x][y];
    }
    
    private void switchPlayer(){
        if(this.currentTurn == 1){
            this.currentTurn = 2;           
        }else{
            this.currentTurn = 1;
        }
    }  
}