package com.company;

import java.io.*;
import java.util.Scanner;


/**
 * Общее между клиентской и серверной частями программы общения
 */
public abstract class ChatSideBase {

    protected InputStream in;
    protected OutputStream out;


    /**
     * Создание потоков для отправки и принятия сообщений
     */
    protected void createThreads() {

        Thread inThread = new Thread(() -> {

            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String message;

            try {
                while (true) {
                    message = reader.readLine();
                    if (message != null) {
                        System.out.println("Получено сообщение: " + message);
                    }
                }
            }
            catch(IOException e) {
                e.printStackTrace();
            }
        });

        Thread outThread = new Thread(() -> {

            PrintWriter writer = new PrintWriter(new OutputStreamWriter(out), true);
            Scanner reader = new Scanner(System.in);

            while (true) {
                writer.println(reader.nextLine());
            }
        });


        inThread.start();
        outThread.start();
    }
}

