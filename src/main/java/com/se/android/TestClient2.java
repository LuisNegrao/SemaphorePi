package com.se.android;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TestClient2 {


    private Socket socket;
    private PrintWriter outputToServer;
    private BufferedReader inputFromServer;


    public TestClient2() throws IOException {

        this.socket = new Socket("127.0.0.1", 8080);
        this.outputToServer = new PrintWriter(this.socket.getOutputStream(), true);
        this.inputFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String message = "";
        Scanner input = new Scanner(System.in);

        while (!message.equals("stop")) {

            message = input.nextLine();
            outputToServer.println(message);

            if (message.equals("stop"))
                continue;

            message = inputFromServer.readLine();
            if (message == null) {
                message = "";
            } else {
                System.out.println(message);
            }

        }

        this.socket.close();
        this.inputFromServer.close();
        this.outputToServer.close();

    }


    public static void main(String[] args) throws IOException {
        new TestClient2();
    }

}
