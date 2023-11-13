package org.example;

import org.example.controlador.ControladorChiste;
import org.example.controlador.IControladorChiste;
import org.example.vista.IVistaChiste;
import org.example.vista.VistaChisteSwing;

public class AppConsultaChiste {
    public static void main(String[] args) {
        IChisteDAO chisteDAO= new ChisteDAO();
        IVistaChiste vistaChiste = new VistaChisteSwing();
        IControladorChiste controlador= new ControladorChiste(chisteDAO, vistaChiste);
        vistaChiste.setController(controlador);
    }
}