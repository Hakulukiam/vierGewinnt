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
public class test {
 private Boolean checkRows(Integer x, Integer y){
        
           int d = 0;
           for(int i = 0; i < 8; i++) {
           if(field[i][y] == currentTurn) {
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