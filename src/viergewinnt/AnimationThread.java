/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viergewinnt;

/**
 *
 * @author Markus
 */
public class AnimationThread extends Thread {
    private final Game game;
    private Integer x;
    
    public AnimationThread(Game game, Integer x) {
        this.game = game;
        this.x = x;
    }
    
}
