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
        int[][] a;
        int[] c = {0,0,0,0,0,0,0};
        int d = 0;
        if(currentTurn == 1){
           for(int i = 1; i < 8; i++) {
           if(a[i][y] == 1) {
              c[i] = 1;
           }else{
              c[i] = 0;
           }              
        }
        for(int j = 0; j < 8; j++) {
            if(c[j] == c[j+1]){
                d++;
            }else{
                d = 0;
            }                      
        }                     
           if(d >= 4){
               return true;
           }else{
               return false;
           }                        
        }      
        return false;
    }
}
