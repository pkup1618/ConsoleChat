package com.company;

import java.net.Socket;

public class ClientConnectionClass {

    private static ClientConnectionClass uniqueInstance;

    private ClientConnectionClass() {}

    public static ClientConnectionClass getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new ClientConnectionClass();
        }
        return uniqueInstance;
    }


    public void createSocketConnection(String host, int port) {

        try {
            Socket socket = new Socket(host, port);
        }
        catch (Exception e) {
            e.printStackTrace();
        }


    }
}
