package com.test;

/**
 * Created by chirag on 6/19/15.
 */
public class LogClass {
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    private String message;
    private int level;

    public LogClass(String message, int level) {
        this.message = message;
        this.level = level;

    }
}
