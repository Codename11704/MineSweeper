package me.sean.minesweeper;

/**
 * Represents a View in the MVC architecture
 * 
 * @author Sean Droll
 */
public interface Observer {

    /**
     * Updates the view upon a change in the Model
     * @param message message on the change
     */
    void update(String message);
}
