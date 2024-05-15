package me.sean.minesweeper;

import java.util.ArrayList;
import java.util.List;

public class Game implements Observable{

    private final List<Observer> observers;
    private final Grid grid;
    private final int width;
    private final int height;
    private final int mines;
    private GameState state;
    


    public Game(int width, int height, int mines) {
        this.observers = new ArrayList<>();
        this.grid = new Grid(width, height, mines);
        this.width = width;
        this.height = height;
        this.mines = mines;
        this.state = GameState.ONGOING;
    }

    private void pick(int x, int y) {
        //TODO create a way to pick any tile, making it non hidden, however not tiles that are flagged
        return;
    }

    private Icon getIcon(int x, int y) {
        //TODO get the icon of any tile on the grid
        return null;
    }

    private void flag(int x, int y) {
        //TODO be able to flag any any hidden tile
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
    
}
