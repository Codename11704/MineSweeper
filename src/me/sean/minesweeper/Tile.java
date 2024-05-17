/**
 * Represents a tile on the grid in the game. Each tile has a value,
 * which is either a number 0-9 or a mine which is represented as -1 for simlplicity sake.
 * A tile can either be hidden or revealed, which represents whether the player has picked it or not.
 * 
 * @author Sean Droll
 */

package me.sean.minesweeper;

public class Tile {

    private Value value;
    private boolean isHidden = true;
    private boolean isFlagged = false;

    /**
     * Creates a new instance of the Tile class
     * @param value the intitial value of the Tile, will likely be ZERO
     */
    public Tile(Value value) {
        this.value = value;
    }

    /**
     * Returns the current value of the tile
     * @return The current value of the tile
     */
    public Value getValue() {
        return this.value;
    }

    /**
     * Sets the value of the tile to whatever is specified
     * @param value the value to assign to the tile
     */
    public void setValue(Value value) {
        this.value = value;
    }

    /**
     * Checks whether the tile is currently hidden
     * @return true if the tile is hidden, false otherwise
     */
    public boolean isHidden() {
        return this.isHidden;
    }

    /**
     * Sets the hidden parameter to false if the tile is not flagged
     */
    public void reveal() {
        if(this.isFlagged) return;
        this.isHidden = false;
    }

    /**
     * Checks if the current tile is flagged
     * @return whether or not the tile is flagged or not
     */
    public boolean isFlagged() {
        return this.isFlagged;
    }

    /**
     * Turns the isFlagged value to the inverse of its current state
     * @return the new state of isFlagged
     */
    public boolean flag() {
        if(!this.isHidden) return isFlagged;
        this.isFlagged = !this.isFlagged;
        return isFlagged;
    }

    @Override
    public String toString() {
        if(isHidden) {
            if(isFlagged) {
                return "[!]";
            }
            return "[]";
        }
        return this.value.toString();

    }
}
