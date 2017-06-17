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
    private final GUI gui;
    private final Integer[][] field;
    public final Integer[] SIZE = {7,6};

    public Game() {
        this.currentTurn = 0;
        this.field = new Integer[SIZE[0]][SIZE[1]];
        this.resetField();
        this.gui = new GUI(this);
    }
    
    public Integer getCurrentTurn() {
        return currentTurn;
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
    
    public Boolean isValidMove(Integer x, Integer y){
        return field[x][0] == 0;
    }
    
    public Boolean noValidMoves(){
        for(int i = 0; i < 7; i++) {
            if(field[i][0] == 0)return false;
        }
        return true;
    }
    
    public void newGame(){
        this.resetField();
        gui.updateGUI();
        this.currentTurn = 0;
    }
    
    public void startGame(String Player1, String Player2){
        this.playerOne = new Player(1,Player1);
        this.playerTwo = new Player(2,Player2);
        this.currentTurn = 1;
        gui.setPlayer();
    }
    
    public void makeMove(Integer x, Integer y){
        if(isValidMove(x, y) && this.currentTurn != 0){
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
                this.switchPlayer(); 
            }else{
                this.switchPlayer(); 
            }
            if(this.noValidMoves()){
                resetField();
                gui.updateGUI();
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
        int d = 0;
        for(int i = 0; i < 7; i++) {
            if(field[i][y].equals(currentTurn)) {
                d++;
            }else{
                d = 0;
            }  
            if(d >= 4){
                return true;
            }                                                                            
        }   
        return false;        
    }
    
    private Boolean checkCols(Integer x, Integer y){
        int d = 0;
        for(int i = 0; i < 6; i++) {
            if(field[x][i].equals(currentTurn)) {
                d++;
            }else{
                d = 0;
            }  
            if(d >= 4){
                return true;
            }                                                                            
        }   
        return false;  
    }
    
    private Boolean checkDiagonals(Integer x, Integer y){
        int d = 0;    
        int rel_x;
        int rel_y;
        //Left to Right
        if(x-y <= 0) {  
            rel_y = (x-y) * (-1);            
            rel_x = 0;              
        }else{
            rel_x = x-y;
            rel_y = 0;                                    
        }
        
        for(int i = 0; i <= 5; i++) {
           if (SIZE[0] > rel_x+i && SIZE[1] > rel_y+i && rel_y+i >= 0 && rel_x+i >= 0) {          
                if(field[rel_x+i][rel_y+i].equals(currentTurn)) {
                    d++;
                }else{
                    d = 0;
                }
            }else{
               break;
            }
            if(d >= 4){
                return true;
            }
        }    

        //Right to Left 
        if(x+y >= 6){            
            rel_y = (x+y) - 6;          
            rel_x = 6;
        }else{
            rel_x = x+y;
            rel_y = 0; 
        }
        for(int i = 0; i <= 5; i++) {
            if (SIZE[0] > rel_x-i && SIZE[1] > rel_y+i && y+i >= 0 && rel_x-i >= 0) {  
                System.out.println("x: "+(rel_x-i)+" | y: "+(rel_y+i)+" -> "+field[rel_x-i][rel_y+i]+" == "+currentTurn);
                if(field[rel_x-i][rel_y+i].equals(currentTurn)) {
                    d++;
                }else{
                    d = 0;
                }                
            }else{
                break;
            } 
            if(d >= 4){
                return true;
            }
        }       
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
        gui.setPlayer();
    }  
}