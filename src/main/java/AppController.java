import clientserver.ClientSide;
import clientserver.ServerSide;

import javax.swing.*;


public class AppController {

    public static void main(String[] args) {
        // Загрузка всех компонентов программы
        InformationContainer informationContainer = InformationContainer.getInstance();
        ServerSide serverSide = ServerSide.getInstance();
        ClientSide clientSide = ClientSide.getInstance();

        GUI gui = new GUI();
        gui.createGUI();

        gui.ipLabel.setText("ip этого компьютера в локальной сети: " + InformationContainer.GetIpFromSystem());

        // Установка поведения для кнопки
        gui.setPortButton.addActionListener(e -> {

            String enteredMessage = JOptionPane.showInputDialog("Введите незанятый порт от 18 000 до 19 000");
            informationContainer.setPort(Integer.parseInt(enteredMessage));
            gui.portLabel.setText(String.valueOf(informationContainer.getPort()));
        });

        // Установка поведения для кнопки
        gui.startClientButton.addActionListener(e -> {

            Thread clientThread = new Thread(() -> {
                String ip = JOptionPane.showInputDialog("Введите ip компьютера, запустившего серверную программу");
                int port = Integer.parseInt(JOptionPane.showInputDialog("Введите порт серверной программы"));
                clientSide.provideSocketConnection(ip, port);
            });

            clientThread.start();
        });

        // Установка поведения для кнопки
        gui.startServerButton.addActionListener(e -> {

            Thread serverThread = new Thread(() -> serverSide.provideSocketConnection(informationContainer.getPort()));
            serverThread.start();
        });
    }
}
