package org.example.vista;

import org.example.controlador.IControladorChiste;

import javax.swing.*;
import java.awt.*;

public class VistaChisteSwing extends JFrame implements IVistaChiste {

    private final JTextArea txtChiste;
    private final JButton btConsulta;

    private IControladorChiste controlador;

    public VistaChisteSwing() throws HeadlessException {

        this.controlador = controlador;
        btConsulta = new JButton("Consultar Chiste");
        txtChiste = new JTextArea();

        btConsulta.addActionListener(t -> {
            String chiste = this.controlador.getRandomJoke();
            txtChiste.setText(chiste);
        });


        JPanel panelSuperior = new JPanel();

        panelSuperior.add(btConsulta);
        add(panelSuperior, BorderLayout.PAGE_START);
        add(txtChiste);
        setLocationRelativeTo(null);
        setSize(500, 440);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);


    }

    @Override
    public void setChiste(String chiste) {
        txtChiste.setText(chiste);
    }

    @Override
    public void setController(IControladorChiste controller) {
        this.controlador= controller;
    }


}
