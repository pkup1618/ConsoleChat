package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerConnectionClass {

    private static ServerConnectionClass uniqueInstance;

    private ServerConnectionClass() {}

    public static ServerConnectionClass getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new ServerConnectionClass();
        }
        return uniqueInstance;
    }


    private ServerSocket serverSocket;
    private Socket socket;

    private InputStream in;
    private OutputStream out;


    // после того, как запускается этот метод мы имеем подключение к socket
    public void openSocket(int port) {
        try {
            serverSocket = new ServerSocket(port);
            socket = serverSocket.accept();

            in = socket.getInputStream();
            out = socket.getOutputStream();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}
