package me.sean.minesweeper;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the Minesweeper game, a player is able to pick or flag tiles. If the player picks a mine, the player loses
 */
public class Game implements Observable {

    private final List<Observer> observers;
    private final Grid grid;
    private GameState gameState;
    

    /**
     * Creates a new minesweeper game
     * @param width width of the board
     * @param height height of the board
     * @param mines the number of mines on the board
     */
    public Game(int width, int height, int mines) {
        this.observers = new ArrayList<>();
        this.grid = new Grid(width, height, mines);
        this.gameState = GameState.ONGOING;
    }

    /**
     * Picks and reveals a tile on the board
     * @param x x coordinate of the tile
     * @param y y coordinate of the tile
     */
    public void pick(int x, int y) {
        if(this.gameState == GameState.WIN || this.gameState == GameState.LOSS) return;
        this.grid.pickTile(x, y);
        this.gameState = this.grid.evaluateBoard();
        notifyObservers("Picked");
    }

    /**
     * Gets the value a player should see on a tile
     * @param x x coordinate of the tile
     * @param y y coordinate of the tile
     * @return the value a player will see of that tile on the baord
     */
    public Value getIcon(int x, int y) {
        Tile tile = grid.getTile(x, y);
        if(tile.getValue() == Value.MINE && this.gameState == GameState.LOSS && tile.isHidden()) {
            return Value.MINE;
        } else if(tile.isFlagged()) {
            return Value.FLAG;
        } else if(tile.isHidden()) {
            return Value.BLANK;
        } else if(tile.getValue() == Value.MINE) {
            return Value.RED_MINE;
        }
        return tile.getValue();
    }

    /**
     * Flags a tile on the board
     * @param x x coordinate of the tile
     * @param y y coordinate of the tile
     */
    public void flag(int x, int y) {
        if(this.gameState == GameState.WIN || this.gameState == GameState.LOSS) return;
        this.grid.flagTile(x, y);
        notifyObservers("Flag Set");
    }

    @Override
    public void addObserver(Observer o) {
        this.observers.add(o);
    }

    @Override
    public void notifyObservers(String message) {
        for(Observer o : this.observers) {
            o.update(message);
        }
    }

    @Override
    public String toString() {
        return this.grid.toString();
    }
    
}
