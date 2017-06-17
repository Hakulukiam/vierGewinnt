/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viergewinnt;

import java.util.Arrays;

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
        for (Integer[] row: this.field)
            Arrays.fill(row, 0);
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
    
    public void makeMove(Integer x, Integer y){
        if(isValidMove()){
            field[x][y] = this.currentTurn;
            gui.updateGUI();
        }       
    }
       
    public Integer hasWon(Integer[] move){
        return 1;
    }
    
    private Integer checkRows(){
        return 1;
    }
    
    private Integer checkCols(){
        return 1;
    }
    
    private Integer checkDiagonals(){
        return 1;
    }
    
    public Integer getCurrentFieldStatus(Integer x, Integer y){
        return field[x][y];
    }
    
    private Integer switchPlayer(){
        if(this.currentTurn == 1){
            return 2;           
        }else{
            return 1;
        }
    }
    
    
    
}
