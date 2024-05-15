/**
 * This enum represents the various values a tile could contain,
 * which is either a numeric value from 0-9 or -1 if it is a mine
 * 
 * @author Sean Droll
 */
package me.sean.minesweeper;

public enum Value {
    ZERO(0),
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    MINE(-1);

    private final int value;

    /**
     * Creates a new intance of Value
     * @param value the numeric representation of the value
     */
    private Value(int value) {
        this.value = value;
    }

    /**
     * Returns the integer representation of the Value
     * @return the integer representation of the Value
     */
    public int getIntegerValue() {
        return this.value;
    }

    /**
     * Returns a Value based off of an integer representation
     * @param value the integer representation of the Value you want
     * @return the Value that matches the integer provided
     */
    public static Value getValFromInt(int value) {
        // As I feel this module is closed, I opted to go for a switch statement here
        switch (value) {
            case -1:
                return MINE;
            case 0:
                return ZERO;
            case 1:
                return ONE;
            case 2:
                return TWO;
            case 3:
                return THREE;
            case 4:
                return FOUR;
            case 5:
                return FIVE;
            case 6:
                return SIX;
            case 7:
                return SEVEN;
            case 8:
                return EIGHT;
            case 9:
                return NINE;
            default:
                return null;
        }
    }

    @Override
    public String toString() {
        if(this.value == -1) {
            return "M";
        }
        return String.valueOf(this.value);
    }
}
