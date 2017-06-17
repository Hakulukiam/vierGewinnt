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
    
    private final Integer playerNumber;
    private Integer score;
    private String name;

    public Player(Integer playerNumber, String name) {
        this.playerNumber = playerNumber;
        this.name = name;
        this.score = 0;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }   
}
