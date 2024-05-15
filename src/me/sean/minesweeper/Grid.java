/**
 * This class is a representation of the grid for the Minesweeper game
 * provided with the dimensions and the number of mines, upon construction,
 * the module will automatically place all tiles and mines.
 * If the number of mines outnumbers the number of tiles on the board, 
 * the board will remain empty
 * 
 * @author Sean Droll
 * 
 */

package me.sean.minesweeper;

import java.util.Random;

public class Grid {

    private final int width;
    private final int height;
    private final int mines;
    private final Tile[][] grid;

    /**
     * Constructs a grid preloaded with mines
     * @param width the width of the board
     * @param height the height of the board
     * @param mines the number of mines on the board
     */
    public Grid(int width, int height, int mines) {
        this.width = width;
        this.height = height;
        this.mines = mines;
        this.grid = new Tile[height][width];
        loadBoard();
    }

    /**
     * Loads the board with tiles and mines
     */
    private void loadBoard() {
        placeTiles();
        realizeMines();
        realizeTileValues();
    }

    /**
     * Preplaces tiles on the board
     */
    private void placeTiles() {
        // Go through each row
        for(int i = 0; i < height; i++) {
            // Go through each Column
            for(int j = 0; j < width; j++) {
                // Write a new tile to it and initialize to ZERO
                grid[i][j] = new Tile(Value.ZERO);
            }
        }
    }

    /**
     * Places mines in random locations on the grid
     */
    private void realizeMines() {
        // If there are more mines than there are tiles, leave the board empty
        if(this.mines > this.width*this.height) return;
        Random rng = new Random();
        int minesPlaced = 0;
        while(minesPlaced < this.mines) {
            // Create random x and y coordinates on the board
            int x = rng.nextInt(width);
            int y = rng.nextInt(height);
            // If this value is not already a mine, make it a mine
            if(this.grid[y][x].getValue() != Value.MINE) {
                /*
                 * I don't know if minesweeper has a rule against large mine clusters (ie, no 9x9 grid of mines on the map)
                 * Probably not, and I'm not going to implement one
                 */
                this.grid[y][x].setValue(Value.MINE);
                minesPlaced++;
            }
        }
    }

    /**
     * For each non-mine tile, this function assigns
     * a number to each tile with the number of mines it borders
     */
    private void realizeTileValues() {
        // Go through each space on map
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                // If the space is not a mine realize it's value
                if(this.grid[i][j].getValue() != Value.MINE) {
                    realizeSingleTile(j, i);
                }
            }
        }
    }

    /**
     * Realizes the number of mines next to a single tile
     * @param x the x coordinate of the tile
     * @param y th y coordinate of the tile
     */
    private void realizeSingleTile(int x, int y) {
        int mines = 0;
        // Start one space back in both the x and y direction
        for(int i = -1; i <= 1; i++) {
            // Check if you're on the board
            if(y+i < 0 || y+i >= height) continue;
            for(int j = -1; j <= 1; j++) {
                if(x+j < 0 || x+j >= width) continue;
                // Do not count the space you're checking
                if(j == 0 && i == 0) continue;
                //If this space is a mine, increment
                if(this.grid[y+i][x+j].getValue() == Value.MINE) mines++;
            }
        }
        // Set the value of the space to the amoount of mines you found
        this.grid[y][x].setValue(Value.getValFromInt(mines));
    }

    //TODO differentiate between getting a tile and picking a tile, determine how much access the caller has to a TILE (only get value or get tile)

    /**
     * Gets a tile off of it's x and y coordinates
     * @param x the x coordinate of the tile
     * @param y the y coordinate of the tile
     * @return
     */
    public Tile getTile(int x, int y) {
        return this.grid[y][x];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < width; i++) {
            for(int j = 0; j < height; j++) {
                sb.append(this.grid[j][i].toString());
                sb.append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
