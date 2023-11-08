package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.IController;

public class MainFrame extends JFrame {
    private final JButton btnJoke;
    private IController controller;

    public MainFrame() {
        setLayout(new FlowLayout());
        btnJoke = new JButton("Get random joke");

        btnJoke.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.getJoke("Chistazo");
            }
        });

        add(btnJoke);

        setLocationRelativeTo(null);
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void setController(IController controller) {
        this.controller = controller;
    }
}
