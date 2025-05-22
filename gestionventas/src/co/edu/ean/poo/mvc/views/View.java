package co.edu.ean.poo.mvc.views;

import co.edu.ean.poo.mvc.controllers.Controller;

/**
 * Interfaz que define los métodos que debe implementar cualquier vista.
 */
public interface View {
    void mostrarVista();
    void ocultarVista();
    void setController(Controller controller);
}
