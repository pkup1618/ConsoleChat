package com.company;

import javax.swing.*;
import java.awt.*;


public class AppGui {

    public Button checkIpButton = new Button("Узнать ip компьютера");
    public Button setPortButton = new Button("Установить порт");
    public Button startServerButton = new Button("Начать ожидать соединение с клиентом");
    public Button startClientButton = new Button("Подключиться к серверу");
    public JLabel portLabel = new JLabel("Порт не установлен");
    public JLabel ipLabel = new JLabel("IP не инициализирован");

    public void createGUI() {


        JFrame frame = new JFrame("Программа для общения через консоль");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(1280, 720 ));

        JPanel contents = new JPanel();
        contents.add(checkIpButton);
        contents.add(setPortButton);
        contents.add(startServerButton);
        contents.add(startClientButton);
        contents.add(portLabel);
        contents.add(ipLabel);

        contents.setLayout(new BoxLayout(contents, BoxLayout.Y_AXIS));
        frame.setContentPane(contents);

        frame.pack();
        frame.setVisible(true);

    }
}
