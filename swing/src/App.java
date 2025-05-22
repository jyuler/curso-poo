
import javax.swing.JFrame;

import ean.poo.swing.controles.ControlesBasicos;
import ean.poo.swing.controles.ControlesConModelo;

public class App {
    
    public static void main(String[] args) throws Exception {
        // ControlesBasicos.etiquetaHolaMundo().setVisible(true);
        // ControlesBasicos.etiquetayNombre().setVisible(true);
        // ControlesBasicos.nombreConBotones().setVisible(true);
        // ControlesBasicos.checkboxes().setVisible(true);
        // ControlesBasicos.radioButtons().setVisible(true);
        // ControlesBasicos.botonesConEventos().setVisible(true);

        // FlowLayout
        // Layouts.flowlayout(FlowLayout.LEFT).setVisible(true);
        // Layouts.flowlayout(FlowLayout.CENTER).setVisible(true);
        // Layouts.flowlayout(FlowLayout.RIGHT).setVisible(true);

        // BoxLayout
        // Layouts.boxlayout(BoxLayout.X_AXIS).setVisible(true);
        // Layouts.boxlayout(BoxLayout.Y_AXIS).setVisible(true);

        // GridLayout
        // Layouts.gridlayout(10, 3, 3).setVisible(true);
        // Layouts.gridlayout(8, 2, 4).setVisible(true);
        // Layouts.gridlayout(13,0, 2).setVisible(true);

        // BorderLayout
        // Layouts.borderlayout(1).setVisible(true);
        // Layouts.borderlayout(2).setVisible(true);
        // Layouts.borderlayout(3).setVisible(true);
        // Layouts.borderlayout(4).setVisible(true);
        // Layouts.borderlayout(5).setVisible(true);
        // Layouts.borderlayout(6).setVisible(true);
        // ControlesBasicos.etiquetayTextoMultilinea().setVisible(true);
        // Layouts.gridbaglayout().setVisible(true);


        
        ControlesConModelo.lista().setVisible(true);
        // ControlesConModelo.combobox().setVisible(true);
        // ControlesConModelo.comboboxConModel().setVisible(true);
    }

    private static JFrame primeraVentana() {
        // Crea una ventana
        JFrame f = new JFrame("Mi primera ventana Java");
        // Establece que se debe hacer cuando se cierre la ventana
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // Establece el tamaño de la ventana
        f.setSize(300, 188);
        return f;
    }


    
}
