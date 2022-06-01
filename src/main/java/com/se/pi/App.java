package com.se.pi;

import com.fazecast.jSerialComm.SerialPort;
import com.se.android.Endpoint;

import java.io.IOException;
import java.util.Arrays;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IOException, InterruptedException {

        SerialPort list = SerialPort.getCommPort("ttyACM0");

        State state = new State();
        Arduino arduino = new Arduino(list, state);
        Communication communication = new Communication(arduino);
        arduino.startListening();

        Thread.sleep(3000);
        System.out.println();

        Simulation simulation = new Simulation(arduino, communication, state);
        simulation.run();

        final Endpoint server = new Endpoint(simulation);
        server.start();
        server.blockUntilShutdown();

    }
}