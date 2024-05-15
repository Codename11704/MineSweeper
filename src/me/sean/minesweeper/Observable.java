package me.sean.minesweeper;

public interface Observable {
    void addObserver(Observer o);
    void notifyObservers(String message);
}
