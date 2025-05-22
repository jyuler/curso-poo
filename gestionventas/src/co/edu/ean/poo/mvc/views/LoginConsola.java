package co.edu.ean.poo.mvc.views;

import java.io.Console;

import co.edu.ean.poo.mvc.controllers.LoginController;

/**
 * Ofrece una por consola para hacer login de la aplicación
 */
public class LoginConsola implements LoginView, Consola {
    private LoginController controller;
    private Console cn;

    public LoginConsola() {
        // Este objeto se crea solamente si hay una consola disponible
        Console c = System.console();
        if (c == null) {
            throw new IllegalStateException("No hay consola disponible");
        }
        this.cn = c;
    }

    /**
     * Muestra la vista de login. En este caso, mostrar un título y pedir el
     * usuario y la contraseña por consola para luego ser validados por
     * el controller
     */
    @Override
    public void mostrarVista() {
        cn.printf("\n%sBienvenido al sistema de ventas%s\n", ANSI_YELLOW, ANSI_RESET);
        cn.printf("%sUsuario: %s", ANSI_BLUE, ANSI_RESET);
        String user = cn.readLine();
        cn.printf("%sContraseña: %s", ANSI_BLUE, ANSI_RESET);
        var password = cn.readPassword();
        if (controller != null)
            controller.validarLogin(user, new String(password));
    }

    /**
     * Muestra un mensaje de error en la consola
     */
    @Override
    public void mostrarError(String error) {
        cn.printf("%sError: %s%s\n", ANSI_PURPLE, error, ANSI_RESET);
    }

    
    @Override
    public void ocultarVista() {
        // No action needed for console
    }

    @Override
    public void setController(LoginController c) {
        controller = c;
    }

}
