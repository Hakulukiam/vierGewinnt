
package viergewinnt;

import java.util.Arrays;

/**
 * 
 * @author Marcel Clemeur 4840095 Gruppe 2C
 */
public class Game {
    
    private Player playerOne;
    private Player playerTwo;
    private Integer currentTurn;
    private final GUI gui;
    private final Integer[][] field;
    private final Integer[] size = {7, 6};
    private TurnThread Timer;

    public Integer[] getSize() {
        return size;
    }
    /**
     * 
     */
    public Game() {
        this.currentTurn = 0;
        this.field = new Integer[size[0]][size[1]];
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
    /**
     * 
     * @param x X-Koordinate wird uebergeben
     * @param y Y-Koordinate wird uebergeben
     * @return gibt das Spielfeld zurueck
     */
    public Boolean isValidMove(Integer x, Integer y) {
        return field[x][0] == 0;
    }
    /**
     * 
     * @return gibt zuruek ob der Zug möglich ist
     */
    public Boolean noValidMoves() {
        for (int i = 0; i < 7; i++) {
            if (field[i][0] == 0) {
                return false;
            }
        }
        return true;
    }
    /**
     * 
     */
    public void newGame() {
        this.resetField();
        gui.updateGUI();
        Timer.interrupt();        
        this.currentTurn = 0;
    }
    /**
     * 
     * @param playerEins Spieler eins wird uebergeben
     * @param playerZwei Spieler zwei wird uebergeben
     */
    public void startGame(String playerEins, String playerZwei) {
        this.playerOne = new Player(1, playerEins);
        this.playerTwo = new Player(2, playerZwei);
        this.currentTurn = 1;
        Timer = new TurnThread(this);       
        gui.setPlayer();
        Timer.start();
    }
    /**
     * Hier wird der Zug gesetzt und ueberprueft ob dieser zum Sieg fuehrt
     * Dementsprechend wird eine neue Runde gestartet und der Score angepasst
     * @param x X-koordinate wird uebergeben
     * @param y Y-Koordinate wird uebergeben
     */
    public void makeMove(Integer x, Integer y) {
        y = 5;
        for (int i = 5; i >= 0; i--) {
            if (field[x][i] == 0) {
                y = i;
                break;
            }
        } 
        if (isValidMove(x, y) && this.currentTurn != 0) {
            field[x][y] = this.currentTurn;
            gui.updateGUI();
            if (this.hasWon(x, y)) {
                if (currentTurn == 1) {
                    playerOne.setScore(playerOne.getScore() + 1);
                } else if (currentTurn == 2) {
                    playerTwo.setScore(playerTwo.getScore() + 1);
                }
                gui.updateScore();
                this.resetField();
                gui.updateGUI();
                this.switchPlayer(); 
            } else {
                this.switchPlayer(); 
            }
            if (this.noValidMoves()) {
                resetField();
                gui.updateGUI();
            }            
        }   
    }
    /**
     * Hier wird das Spielfeld neu aufgebaut
     */
    private void resetField() {
        for (Integer[] row: this.field) {
            Arrays.fill(row, 0);
        }
    }
    /**
     * Hier wird das Spielfeld und die scores/Gui neu aufgebaut
     */
    public void reset() {
        this.resetField();
        Timer.interrupt();
        Timer = new TurnThread(this);        
        playerOne.setScore(0);
        playerTwo.setScore(0);
        gui.updateScore();
        gui.updateGUI();
        Timer.start();
    }
    /**
     * Hier wird geprueft ob die Runde gewonnen ist
     * @param x X-Koordinate wird uebergeben
     * @param y Y-Koordinate wird uebergeben
     * @return falls eine Runde gewonnen ist
     */
    public Boolean hasWon(Integer x, Integer y) {
        if (this.checkRows(x, y) == true) {
            return true;
        }
        if (this.checkCols(x, y) == true) {
            return true;
        }
        return this.checkDiagonals(x, y) == true;
    }
    /**
     * Hier wird in der Reihe X geprueft ob sie Gewonnen ist.
     * @param x X-Koordinate wird uebergeben
     * @param y Y-Koordinate wird uebergeben
     * @return das gefundene Ergebniss
     */
    private Boolean checkRows(Integer x, Integer y) {
        int d = 0;
        for (int i = 0; i < 7; i++) {
            if (field[i][y].equals(currentTurn)) {
                d++;
            } else {
                d = 0;
            }  
            if (d >= 4) {
                return true;
            }                                                                            
        }   
        return false;        
    }
    /**
     * Hier wird in der Spalte Y geprueft ob sie gewonnen ist
     * @param x X-Koordinate wird uebergeben
     * @param y Y-Koordinate wird uebergeben
     * @return das gefundene Ergebniss
     */
    private Boolean checkCols(Integer x, Integer y) {
        int d = 0;
        for (int i = 0; i < 6; i++) {
            if (field[x][i].equals(currentTurn)) {
                d++;
            } else {
                d = 0;
            }  
            if (d >= 4) {
                return true;
            }                                                                            
        }   
        return false;  
    }
    /**
     * Hier werden die Diagonalen der Position X, Y geprueft ob sie gewonnen sind
     * @param x X-Koordinate wird uebergeben
     * @param y Y-Koordinate wird uebergeben
     * @return das gefundene Ergebniss
     */
    private Boolean checkDiagonals(Integer x, Integer y) {
        int d = 0;    
        int relX;
        int relY;
        //von links nach rechts
        if (x - y <= 0) {  
            relY = (x - y) * (-1);            
            relX = 0;              
        } else {
            relX = x - y;
            relY = 0;                                    
        }
        
        for (int i = 0; i <= 5; i++) {
            if (size[0] > relX + i && size[1] > relY + i && relY + i >= 0 && relX + i >= 0) {          
                if (field[relX + i][relY + i].equals(currentTurn)) {
                    d++;
                } else {
                    d = 0;
                }
            } else {
                break;
            }
            if (d >= 4) {
                return true;
            }
        }
        
        d = 0;

        //von rechts nach links
        if (x + y >= 6) {            
            relY = (x + y) - 6;          
            relX = 6;
        } else {
            relX = x + y;
            relY = 0; 
        }
        for (int i = 0; i <= 5; i++) {
            if (size[0] > relX - i && size[1] > relY + i && y + i >= 0 && relX - i >= 0) {  
                if (field[relX - i][relY + i].equals(currentTurn)) {
                    d++;
                } else {
                    d = 0;
                }                
            } else {
                break;
            } 
            if (d >= 4) {
                return true;
            }
        }       
        return false;
    }
    /**
     * Hier wird das aktuelle Spielfeld zurueck gegeben
     * @param x X-Koordinate wird uebergeben
     * @param y Y-Koordinate wird uebergeben
     * @return das aktuelle Spielfeld
     */    
    public Integer getCurrentFieldStatus(Integer x, Integer y) {
        return field[x][y];
    }
    
    public void updateTurnTime(Integer time, Integer avaliable){
        this.gui.updateTimer(time,avaliable);
    }
    
    /**
     * Hier findet der Wechsel zwischen den Spielern statt
     */
    public void switchPlayer() {
        Timer.interrupt();        
        if (this.currentTurn == 1) {
            this.currentTurn = 2;           
        } else {
            this.currentTurn = 1;
        }
        gui.setPlayer();
        System.out.println(Timer.changeturn());  
        Timer = new TurnThread(this, Timer.changeturn());
        Timer.start();
    }  
}