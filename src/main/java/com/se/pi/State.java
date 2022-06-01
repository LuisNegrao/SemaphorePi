package com.se.pi;

import java.util.concurrent.ConcurrentHashMap;

public class State {

    /*
     * this should store for each traffic light the amount of cars waiting
     * and the tome left for them to change in case of normal operation.
     * The key is the light id and the array should contain a timeleft and a
     * number of cars in line
     *
     * Current color : 0 RED, 1 GREEN, 2 YELLOW
     *
     */
    private ConcurrentHashMap<Integer, Integer[]> state; // [current color, cars in wait, first to arrive time]
    private int currentState;

    public State() {
        currentState = 0;
        state = new ConcurrentHashMap<Integer, Integer[]>();
        state.put(0, new Integer[]{1, 0, 0});
        state.put(1, new Integer[]{0, 0, 0});
        state.put(2, new Integer[]{1, 0, 0});
    }


    public void addToState(int id, Integer[] internalstate) {
        state.put(id, internalstate);
    }

    public void setTime(int id) {

        Integer[] internalState = state.get(id);
        internalState[1] = (int) System.currentTimeMillis();
        state.put(id, internalState);

    }

    public void alterWaiting(int id, int alter) {

        if (this.state.get(id)[1] == 0) {
            this.state.get(id)[2] = (int) System.currentTimeMillis();
        }

        this.state.get(id)[1] += alter;

        if (this.state.get(id)[1] >= 10) {
            System.out.println("Congestion Detected!");
        }

    }

    public ConcurrentHashMap<Integer, Integer[]> getState() {
        return this.state;
    }

    public int getNextState() {
        return (currentState + 1) % 4;
    }

    public void setCurrentState(int currentState) {
        this.currentState = currentState;

    }

    public int getCurrentState() {
        return currentState;
    }
}
