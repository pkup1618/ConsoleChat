package com.company;

import javax.swing.*;
import java.awt.*;

public class AppGui {

    public void createGUI() {

        JFrame frame = new JFrame("Программа для общения через консоль");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setPreferredSize(new Dimension(1280, 720 ));

        JPanel contents = new JPanel();
        contents.add(new Button("Узнать ip компьютера"));
        contents.add(new Button("Установить порт"));
        contents.add(new Button("Начать ожидать соединение с клиентом"));
        contents.add(new Button("Подключиться к серверу"));
        contents.setLayout(new BoxLayout(contents, BoxLayout.Y_AXIS));
        frame.setContentPane(contents);


        frame.pack();
        frame.setVisible(true);

    }
}
