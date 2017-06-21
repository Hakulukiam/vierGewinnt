
package viergewinnt;

/**
 * 
 * @author Marcel Clemeur 4840095 Gruppe 2C
 */
public class Player {
    
    private final Integer playerNumber;
    private Integer score;
    private String name;
    /**
     * 
     * @param playerNumber wird uebergeben
     * @param name wird uebergeben
     */
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
