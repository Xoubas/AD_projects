package org.example.controlador;

import org.example.IChisteDAO;
import org.example.vista.IVistaChiste;

public class ControladorChiste  implements IControladorChiste{

    private final IChisteDAO chisteDAO;
    private final IVistaChiste vistaChiste;

    public ControladorChiste(IChisteDAO chisteDAO, IVistaChiste vistaChiste) {
        this.chisteDAO = chisteDAO;
        this.vistaChiste = vistaChiste;
    }

    @Override
    public String getRandomJoke() {
        return chisteDAO.getRandomJoke();
    }
}
