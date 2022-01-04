package com.company;

import java.net.Socket;

/**
 * Клиентская часть программы (Singleton)
 */
public class ClientSide extends ChatSideBase {

    private static ClientSide uniqueInstance;
    private ClientSide() {}
    public static ClientSide getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new ClientSide();
        }
        return uniqueInstance;
    }

    /**
     * Подключиться к серверу
     * @param host ip-адрес
     * @param port порт
     */
    public void provideSocketConnection(String host, int port) {

        try {
            Socket socket = new Socket(host, port);
            System.out.println("Вы подключились к серверу чата");

            in = socket.getInputStream();
            out = socket.getOutputStream();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        createThreads();
    }
}
