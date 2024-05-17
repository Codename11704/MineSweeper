package me.sean.minesweeper;

/**
 * Represents a Model in the MVC architecture
 * 
 * @author Sean Droll
 */
public interface Observable {

    /**
     * Adds an observer that should be updated upon a change in the model
     * @param o the observer to add
     */
    void addObserver(Observer o);

    /**
     * Notifies all the observers upon change in the Model
     * @param message
     */
    void notifyObservers(String message);
}
