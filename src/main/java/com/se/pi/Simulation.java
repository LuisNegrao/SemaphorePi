package com.se.pi;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Simulation {

    private static Arduino arduino;
    public Communication communication;
    public static State state;
    private long lastStateChange;
    private Runnable timer;


    public Simulation(Arduino _arduino, Communication _communication, State _state) throws IOException {

        arduino = _arduino;
        communication = _communication;
        state = _state;

        communication.goToState0(state);

        this.lastStateChange = System.currentTimeMillis();

        timer = () -> state.getState().forEach((key, value) -> {

            int waited = (int) (System.currentTimeMillis() - this.lastStateChange);

            if (value[0] == 1 && value[1] > 0) {
                value[1] = 0;
                value[2] = 0;
            }

            if (key == 0) System.out.println("Running");

            if (waited + 100 >= Config.getTimer(value[0])) { // Try and remove the error of initialization
                try {
                    System.out.println("Waited: " + waited);
                    changeState("Timer");


                } catch (IOException e) {
                    e.printStackTrace();
                }

            } else if ((value[1] >= 10 && value[0] == 0)) {

                try {
                    System.out.println("Waited: " + waited);
                    changeState("Congestion");

                } catch (IOException e) {
                    e.printStackTrace();
                }

            } else if (((int) (System.currentTimeMillis() - value[2]) + 100 > Config.MAX_CAR_WAIT) && value[1] > 0 && value[0] == 0) {

                try {

                    System.out.println("Waited: " + waited);
                    value[2] = (int) System.currentTimeMillis();
                    changeState("Waiting car");

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

    }

    private void changeState(String reason) throws IOException {
        System.out.println("State change due to " + reason);

        int nextState = state.getNextState();
        communication.goToNextState(nextState, state);
        this.lastStateChange = (int) System.currentTimeMillis();
    }

    public void requestStateChange(int state) throws IOException {

        changeState("User Request");

    }


    public void run() {

        final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(this.timer, 0, 1, TimeUnit.SECONDS);
    }

}
