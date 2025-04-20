package co.edu.ean.poo.gui;

import javax.swing.SwingUtilities;

public class LoginController {
    private Runnable loginExitoso;

    public LoginController() {
    }

    public LoginController mostrarLogin() {
        SwingUtilities.invokeLater(() -> new LoginView(this).setVisible(true) );
        return this;
    }

    public LoginController siLoginExitoso(Runnable r) {
        this.loginExitoso = r;
        return this;
    }

    boolean validateLogin(String user, String password) {
        // Simulate a login validation
        return "admin".equals(user) && "admin".equals(password);
    }
    void loginExitoso() {
        if ( loginExitoso != null )
            loginExitoso.run();
    }
}
