package me.sean.minesweeper;

public enum Icon {
    ZERO(""),
    ONE(""),
    TWO(""),
    THREE(""),
    FOUR(""),
    FIVE(""),
    SIX(""),
    SEVEN(""),
    EIGHT(""),
    MINE(""),
    NOT_MINE(""),
    RED_MINE(""),
    FLAG(""),
    BLANK("");

    private String path;
    private Icon(String path) {
        this.path = path;
    }

    public String getPath() {
        return this.path;
    }

}
