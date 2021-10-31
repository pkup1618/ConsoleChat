package com.company;

import javax.swing.*;


public class AppController {


    public static void main(String[] args) {

        InformationContainer informationContainer = InformationContainer.getInstance();
        ServerSide serverSide = ServerSide.getInstance();
        ClientSide clientSide = ClientSide.getInstance();

        AppGui gui = new AppGui();
        gui.createGUI();
        gui.ipLabel.setText("ip этого компьютера в локальной сети: " + InformationContainer.GetIpFromSystem());

        gui.setPortButton.addActionListener(e -> {

            String enteredMessage = JOptionPane.showInputDialog("Введите незанятый порт от 18 000 до 19 000");
            informationContainer.setPort(Integer.parseInt(enteredMessage));
            gui.portLabel.setText(String.valueOf(informationContainer.getPort()));
        });

        gui.startClientButton.addActionListener(e -> {

            Thread clientThread = new Thread(() -> {
                String ip = JOptionPane.showInputDialog("Введите ip компьютера, запустившего серверную программу");
                int port = Integer.parseInt(JOptionPane.showInputDialog("Введите порт серверной программы"));
                clientSide.provideSocketConnection(ip, port);
            });

            clientThread.start();
        });

        gui.startServerButton.addActionListener(e -> {

            Thread serverThread = new Thread(() -> serverSide.provideSocketConnection(informationContainer.getPort()));

            serverThread.start();
        });
    }
}
