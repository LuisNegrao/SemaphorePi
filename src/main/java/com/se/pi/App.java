package com.se.pi;

import com.fazecast.jSerialComm.SerialPort;
import com.se.android.Endpoint2;

import java.io.IOException;

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

        final Endpoint2 server = new Endpoint2(simulation);

        //Thread.sleep(3000);


    }
}