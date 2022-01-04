package com.company;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * Серверная часть программы часть программы (Singleton)
 */
public class ServerSide extends ChatSideBase {

    private static ServerSide uniqueInstance;
    private ServerSide() {}
    public static ServerSide getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new ServerSide();
        }
        return uniqueInstance;
    }


    /**
     * Начать ожидание клиента
     * @param port порт
     */
    public void provideSocketConnection(int port) {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            Socket socket = serverSocket.accept();
            System.out.println("Собеседник подключился");


            in = socket.getInputStream();
            System.out.println(in.getClass());
            out = socket.getOutputStream();
            System.out.println(out.getClass());
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        createThreads();
    }
}
