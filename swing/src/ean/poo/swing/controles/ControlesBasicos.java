package ean.poo.swing.controles;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ControlesBasicos {
    public static JFrame etiquetaHolaMundo() {
        JFrame f = new JFrame("Mi segunda ventana Java");
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setSize(250, 80);

        // Crea una etiqueta con un texto
        JLabel lbl = new JLabel("😊 ¡Hola mundo! 💪🏻");
        // Se agrega el componente etiqueta a la ventana
        f.add(lbl);
        return f;
    }
    public static JFrame etiquetayNombre() {
        JFrame f = new JFrame("Mi tercera ventana Java");
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setLayout(new FlowLayout());
        // Define una etiqueta y una caja de texto
        JLabel lbl = new JLabel("Nombre y apellido");
        JTextField txt = new JTextField(25);
        // agregamos los componentes a la ventana
        f.add(lbl);
        f.add(txt);
        // calcula el tamaño de la ventana con los controles a mostrar
        f.pack();
        return f;
    }

    public static JFrame nombreConBotones() {
        JButton btnGuardar = new JButton("Guardar");
        JButton btnCancelar = new JButton("Cancelar");
        var f = etiquetayNombre();
        f.add( btnGuardar );
        f.add( btnCancelar );
        f.pack();
        return f;
    }
    public static JFrame checkboxes() {
        var f = new JFrame("Checkboxes");
        f.setLayout(new FlowLayout());
        JCheckBox cbMusica = new JCheckBox("Musica", true);
        JCheckBox cbCine = new JCheckBox("Cine", true);
        JCheckBox cbTeatro = new JCheckBox("Teatro");
        f.add(cbMusica);
        f.add(cbCine);
        f.add(cbTeatro);
        System.out.printf("Musica: %s, Cine: %s, Teatro: %s\n", cbMusica.isSelected(), cbCine.isSelected(), cbTeatro.isSelected() );
        f.pack();
        return f;
    }
    public static JFrame radioButtons() {
        var f = new JFrame("Radio buttons");
        f.setLayout(new FlowLayout());
        JRadioButton cbMusica = new JRadioButton("Musica", true);
        JRadioButton cbCine = new JRadioButton("Cine", true);
        JRadioButton cbTeatro = new JRadioButton("Teatro");
        
        // el grupo controla que solo un radio button se pueda seleccionar a la vez
        // ButtonGroup bg = new ButtonGroup();
        // bg.add(cbMusica);
        // bg.add(cbCine);
        // bg.add(cbTeatro);
        // Se agregan los controles a la ventana
        f.add(cbMusica);
        f.add(cbCine);
        f.add(cbTeatro);
        // redimensiona la ventana
        f.pack();
        return f;
    }

    public static JFrame etiquetayTextoMultilinea() {
        JFrame f = new JFrame("Caja de texto multilínea");
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //f.setLayout(new FlowLayout());
        // Define una etiqueta y una caja de texto
        JLabel lbl = new JLabel("Escribe aquì tu carta");
        JTextArea txaCarta = new JTextArea(3,10);
        //JScrollPane scrPane = new JScrollPane(txaCarta);
        
        // agregamos los componentes a la ventana
        f.add(lbl, BorderLayout.NORTH);
        f.getContentPane().add(txaCarta, BorderLayout.CENTER);
        // calcula el tamaño de la ventana con los controles a mostrar
        f.pack();
        return f;
    }

}
