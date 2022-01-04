package com.company;

import java.net.Inet4Address;
import java.net.UnknownHostException;

/**
 * Класс для хранения разнородной информации, нужной приложению (Singleton)
 */
public class InformationContainer {

    private static InformationContainer uniqueInstance;
    private InformationContainer() {}
    public static InformationContainer getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new InformationContainer();
        }
        return uniqueInstance;
    }

    /**
     * Порт, на котором мы откроем серверную часть
     */
    private int port;

    /**
     * Установить порт для серверной части чата
     * @param port - любой порт (целое число) (в случае выхода за рамки отрезка
     *               (18 000 , 19 000) будет установленно ближайшее к отрезку число)
     */
    public void setPort(int port) {

        if (port < 19000)
        {
            this.port = Math.max(port, 18000);
        }
        else
        {
            this.port = 19000;
        }
    }

    /**
     * Получить текущий установленный порт
     * @return текущий установленный порт
     */
    public int getPort() {
        return port;
    }


    /**
     * Узнаёт ip-адрес компьютера в локальной сети
     * @return строковый ip-адрес компьютера
     */
    public static String GetIpFromSystem() {

        try {
            return Inet4Address.getLocalHost().getHostAddress();
        }
        catch (UnknownHostException e) {
            e.printStackTrace();
        }

        return null;
    }
}
