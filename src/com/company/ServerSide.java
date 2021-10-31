package com.company;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSide extends ChatSideBase {

    private static ServerSide uniqueInstance;
    private ServerSide() {}
    public static ServerSide getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new ServerSide();
        }
        return uniqueInstance;
    }


    public void provideSocketConnection(int port) {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            Socket socket = serverSocket.accept();
            System.out.println("Собеседник подключился");


            in = socket.getInputStream();
            out = socket.getOutputStream();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        createThreads();
    }
}
