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
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter outputToClient;
    private BufferedReader inputFromClient;
    private Simulation simulation;


    public Endpoint2() throws IOException {

        //this.simulation = state;

        System.out.println("We are up and running");

        this.serverSocket = new ServerSocket(PORT);
        this.clientSocket = serverSocket.accept();

        System.out.println("We got a connection!");

        this.outputToClient = new PrintWriter(clientSocket.getOutputStream(), true);
        this.inputFromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        String message = "";

        while (!message.equals("stop")) {
            message = inputFromClient.readLine();

            if (message == null) {
                message = "";
                continue;
            }

            System.out.println(message);

            if (message.equals("fetch_state")) {

                //this.outputToClient.println(state.getState().getCurrentState());
                this.outputToClient.println(1);

            } else if (message.contains("change_state")){

                //this.simulation.requestStateChange(0);

            } else {
                this.outputToClient.println("Message not recognised!!");
            }
        }

        outputToClient.close();
        inputFromClient.close();
        serverSocket.close();
        clientSocket.close();

    }

    public static void main(String[] args) throws IOException {
        new Endpoint2();
    }

}
