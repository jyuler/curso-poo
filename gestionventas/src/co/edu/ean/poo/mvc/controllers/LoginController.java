package co.edu.ean.poo.mvc.controllers;

import co.edu.ean.poo.mvc.views.LoginView;

/**
 * Controlador de la vista de login
 */
public class LoginController implements Controller {
    private Runnable correrCuandoLoginExitoso;
    private LoginView vista;

    /**
     * El controlador se crea con una vista de login asociada
     * @param lv
     */
    public LoginController(LoginView lv) {
        vista = lv;
        vista.setController(this);
    }

    public LoginController mostrarLogin() {
        vista.mostrarVista();
        return this;
    }

    /**
     * Establece una acción a ejecutar cuando el login es exitoso
     * @param r objeto Runnable que contiene la acción a ejecutar a través de un método run()
     * @return
     */
    public LoginController siLoginExitoso(Runnable r) {
        this.correrCuandoLoginExitoso = r;
        return this;
    }

    /**
     * Valida el login del usuario
     * @param usuario
     * @param contraseña
     */
    public void validarLogin(String usuario, String contraseña) {
        if ( "admin".equals(usuario) && "admin".equals(contraseña) ) {
            vista.ocultarVista();
            despuesDeLoginExitoso();
        } else {
            vista.mostrarError("Usuario o contraseña incorrectos" );
            vista.mostrarVista();
        }
    }

    /**
     * Se ejecuta cuando el login es exitoso
     */
    private void despuesDeLoginExitoso() {
        if ( correrCuandoLoginExitoso != null )
            correrCuandoLoginExitoso.run();
    }
}
