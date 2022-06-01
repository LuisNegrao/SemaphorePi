package com.se.pi;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

import com.fazecast.jSerialComm.SerialPort;
import com.google.rpc.Help;

public class Arduino {

    final SerialPort arduino;
    private static InputStream inputStream;
    private static OutputStream outputStream;
    private static Scanner scanner;
    private static PrintWriter printerWritter;
    public static LinkedList<String> commands = new LinkedList<>();
    public static State state;

    public Arduino(SerialPort port, State _state) {
        System.out.println("Port: " + port.getSystemPortName());

        arduino = port;
        arduino.setComPortParameters(9600, 8, 1, 0);
        arduino.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_BLOCKING, 0, 0);

        state = _state;


        if (arduino.openPort()) {
            System.out.println("Port is open :)");
        } else {
            System.out.println("Failed to open port :(");
        }

    }

    public void send(String command) throws IOException {
        //System.out.println(command);
        arduino.getOutputStream().write(command.getBytes());
        arduino.getOutputStream().flush();

    }

    public void startListening() {

        new Thread(() -> {
            System.out.println("Inside Listener thread");

            StringBuilder command = new StringBuilder();

            while (true) {
                try {
                    if (arduino.getInputStream().available() >= 1) {
                        char line = (char) arduino.getInputStream().read();
                        command.append(line);
                        if (command.toString().length() >= 6) {

                            if (command.toString().startsWith("St")) {

                                state.alterWaiting(Integer.parseInt(command.charAt(3)+""), 1);

                            } else if (command.toString().startsWith("Sp")) {

                                //commands.add(command.toString());

                            }
                            command = new StringBuilder();
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }
}
