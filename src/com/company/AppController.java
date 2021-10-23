package com.company;

public class AppController {


    public static void main(String args[]) {

        InformationContainer informationContainer = InformationContainer.getInstance();     //singleton
        ServerConnectionClass serverConnectionClass = ServerConnectionClass.getInstance();  //singleton
        ClientConnectionClass clientConnectionClass = ClientConnectionClass.getInstance();  //singleton

        //Нужно связать кнопки с функциями в main, а main связать с функциями этиъ классов

        /*
        То есть main class управляет все программой, но слушает команды о том как управлять от интерфейса.
         */

        AppGui gui = new AppGui();
        gui.createGUI();


    }

}
