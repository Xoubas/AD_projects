package controller;

import vista.MainFrame;

public class Controller implements IController {
    String joke;

    @Override
    public void getJoke(String joke) {
        System.out.println(joke);
    }
}
