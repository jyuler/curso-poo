package co.edu.ean.poo.mvc.views;

import co.edu.ean.poo.mvc.controllers.Controller;
import co.edu.ean.poo.mvc.controllers.LoginController;

/**
 * Interfaz que define una vista de login
 */
public interface LoginView extends View {
    /**
     * método por defecto para establecer el controlador previa validación
     * de que sea una instancia de LoginController
     */
    default void setController(Controller c) {
        if ( c instanceof LoginController lc ) {
            setController(lc);
        } else {
            throw new IllegalArgumentException("La vista de login requiere un LoginController");
        }
    }

    /**
     * Permite establecer el controlador de la vista
     * @param controller
     */
    void setController(LoginController controller);

    /**
     * Muestra un mensaje de error en la vista cuando el login falla   
     * @param error
     */
    void mostrarError(String error);
}
