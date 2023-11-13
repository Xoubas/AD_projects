package org.example.vista;

import org.example.controlador.IControladorChiste;
import org.example.vista.IVistaChiste;

public class VistaChisteTexto implements IVistaChiste {

    private IControladorChiste controlador;

    private void menu(){
        System.out.println("Intro para un chiste aleatorio:");
    }

    @Override
    public void setChiste(String chiste) {
        System.out.println(chiste);
    }

    @Override
    public void setController(IControladorChiste controller) {
    this.controlador= controller;
    }
}
