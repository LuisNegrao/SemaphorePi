package com.se.pi;

public class Config {

    public static final int RED_TIMER = 15000;
    public static final int YELLOW_TIMER = 5000;
    public static final int GREEN_TIMER = 15000;
    public static final int MAX_CAR_WAIT = 5000;

    public static int getTimer(int color) {
        switch (color) {
            case 0:
                return RED_TIMER;
            case 1:
                return GREEN_TIMER;
            case 2:
                return YELLOW_TIMER;
            default:
                return -1;
        }

    }

}
