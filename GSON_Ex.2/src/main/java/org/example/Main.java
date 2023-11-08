package org.example;

import controller.Controller;
import vista.MainFrame;

import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws MalformedURLException {
        MainFrame mainFrame = new MainFrame();
        Controller controller = new Controller();
        mainFrame.setController(controller);
    }
}