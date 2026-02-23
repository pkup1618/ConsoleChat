package clientserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerSide extends ChatSideBase {
    private static ServerSide uniqueInstance;

    private ServerSide() {
    }

    public static ServerSide getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new ServerSide();
        }
        return uniqueInstance;
    }

    public void provideSocketConnection(int port) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            Socket socket = serverSocket.accept();
            System.out.println("Собеседник подключился");

            in = socket.getInputStream();
            System.out.println(in.getClass());

            out = socket.getOutputStream();
            System.out.println(out.getClass());
        } catch (IOException e) {

        }

        createThreads();
    }
}
