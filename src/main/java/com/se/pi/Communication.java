package com.se.pi;

import java.io.IOException;

public class Communication {

    private Arduino arduino;

    public Communication(Arduino arduino) {
        this.arduino = arduino;
    }

    public void goToState0(State state) throws IOException {

        arduino.send("CT00G\n");
        arduino.send("CT02G\n");
        arduino.send("CT01R\n");
        arduino.send("CP00R\n");
        arduino.send("CP01G\n");
        arduino.send("CW02Y\n");

        state.getState().get(0)[0] = 1;
        state.getState().get(2)[0] = 1;
        state.getState().get(1)[0] = 0;

    }

    public void goToState1(State state) throws IOException {


        arduino.send("CT00Y\n");
        arduino.send("CT02Y\n");
        arduino.send("CT01R\n");
        arduino.send("CP00R\n");
        arduino.send("CP01G\n");
        arduino.send("CW02O\n");

        state.getState().get(0)[0] = 2;
        state.getState().get(2)[0] = 2;

    }

    public void goToState2(State state) throws IOException {


        arduino.send("CT00R\n");
        arduino.send("CT02R\n");
        arduino.send("CT01G\n");
        arduino.send("CP00G\n");
        arduino.send("CP01R\n");

        state.getState().get(0)[0] = 0;
        state.getState().get(2)[0] = 0;
        state.getState().get(1)[0] = 1;



    }

    public void goToState3(State state) throws IOException {


        arduino.send("CT00R\n");
        arduino.send("CT02R\n");
        arduino.send("CT01Y\n");
        arduino.send("CP00G\n");
        arduino.send("CP01R\n");

        state.getState().get(1)[0] = 2;

    }

    public void goToNextState(int nextState, State state) throws IOException {

        state.setCurrentState(nextState);

        switch (nextState) {
            case 0:
                goToState0(state);
                break;
            case 1:
                goToState1(state);
                break;
            case 2:
                goToState2(state);
                break;
            case 3:
                goToState3(state);
                break;
            default:
                break;
        }
    }
}
