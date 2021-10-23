package com.company;

import java.net.Inet4Address;
import java.net.UnknownHostException;

public class InformationContainer {

    private static InformationContainer uniqueInstance;

    private InformationContainer() {}

    public static InformationContainer getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new InformationContainer();
        }
        return uniqueInstance;
    }

    private int port;

    public void setPort(int port) {

        if (port < 19000)
        {
            if (port > 18000)
            {
                this.port = port;
            }
            else
            {
                this.port = 18000;
            }
        }
        else
        {
            this.port = 19000;
        }
    }

    public int getPort() {
        return port;
    }



    private String lanIP;

    public void updateIp() {

        String ip = GetIpFromSystem();

        if (ip != null)
            lanIP = ip;

    }

    public String getLanIP() {

        return lanIP;
    }

    public static String GetIpFromSystem() {

        try {
            return Inet4Address.getLocalHost().getHostAddress();
        }
        catch (UnknownHostException e) {
            e.printStackTrace();
        }

        return null;
    }


    private boolean isWaitingForConnection;

    public void enableWaitingForConnection() {
        isWaitingForConnection = true;
    }

    public void disableWaitingForConnection() {
        isWaitingForConnection = true;
    }
}
