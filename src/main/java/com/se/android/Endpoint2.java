package com.se.android;

import com.se.pi.Simulation;
import com.se.pi.State;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Endpoint2 {

    private static final int PORT = 8080;
    private static final int PORT2 = 8081;
    private static ServerSocket serverSocketLiveData;
    private static ServerSocket serverSocketRequestData;
    private static Socket[] clientSocket = new Socket[2];
    private static PrintWriter[] outputToClient = new PrintWriter[2];
    private static BufferedReader[] inputFromClient = new BufferedReader[2];
    private Simulation simulation;


    public Endpoint2(Simulation simulation) throws IOException {

        this.simulation = simulation;

        System.out.println("We are up and running");

        serverSocketLiveData = new ServerSocket(PORT);
        clientSocket[0] = serverSocketLiveData.accept();
        System.out.println("We got the first connection!");


        outputToClient[0] = new PrintWriter(clientSocket[0].getOutputStream(), true);
        inputFromClient[0] = new BufferedReader(new InputStreamReader(clientSocket[0].getInputStream()));

        serverSocketRequestData = new ServerSocket(PORT2);
        clientSocket[1] = serverSocketRequestData.accept();
        System.out.println("We got the second connection!");


        outputToClient[1] = new PrintWriter(clientSocket[1].getOutputStream(), true);
        inputFromClient[1] = new BufferedReader(new InputStreamReader(clientSocket[1].getInputStream()));


        int message = -1;

        while (true) {
            message = inputFromClient[1].read();

            if (message == -1)
                continue;

            if (message == 0) {

                int nextState = Math.max(simulation.state.getCurrentState() - 1, 0);

                simulation.requestStateChange(nextState);

            } else if (message == 1) {
                simulation.requestStateChange(simulation.state.getNextState());
            }

        }

        /*outputToClient[0].close();
        inputFromClient[0].close();
        outputToClient[1].close();
        inputFromClient[1].close();
        serverSocketRequestData.close();
        serverSocketLiveData.close();
        clientSocket[0].close();
        clientSocket[1].close();*/

    }

    public static void sendStatusUpdate(int message) {
        outputToClient[0].println(message);

    }

/*    public static void main(String[] args) throws IOException {
        new Endpoint2();
    }*/

}
