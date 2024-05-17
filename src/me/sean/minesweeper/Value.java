/**
 * This enum represents the various values a tile could contain,
 * which is either a numeric value from 0-9, it also contains
 * other tile types as negative values
 * 
 * @author Sean Droll
 */
package me.sean.minesweeper;

public enum Value {
    ZERO(0, "./img/0.png"),
    ONE(1, "./img/1.png"),
    TWO(2, "./img/2.png"),
    THREE(3, "./img/3.png"),
    FOUR(4, "./img/4.png"),
    FIVE(5, "./img/5.png"),
    SIX(6, "./img/6.png"),
    SEVEN(7, "./img/7.png"),
    EIGHT(8, "./img/8.png"),
    MINE(-1, "./img/mine.png"),
    NOT_MINE(-2, "./img/notmine.png"),
    RED_MINE(-3, "./img/redmine.png"),
    FLAG(-4, "./img/flag.png"),
    BLANK(-5, "./img/blank.png");

    private final int value;
    private final String path;
    /**
     * Creates a new intance of Value
     * @param value the numeric representation of the value
     */
    private Value(int value, String path) {
        this.value = value;
        this.path = path;
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
            case -2:
                return NOT_MINE;
            case -3:
                return RED_MINE;
            case -4:
                return FLAG;
            case -5:
                return BLANK;
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
            default:
                return null;
        }
    }

    public String getPath() {
        return this.path;
    }

    @Override
    public String toString() {
        if(this.value == -1) {
            return "M";
        }
        return String.valueOf(this.value);
    }
}
