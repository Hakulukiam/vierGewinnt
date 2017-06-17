/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viergewinnt;

public class VierGewinnt{
    
    public static Game viergewinnt;

    public static void main(java.lang.String[] args) {
        Player p1 = new Player(1,"Markus");
        Player p2 = new Player(2,"Marcel");
        viergewinnt = new Game(p1,p2);

    }    
}